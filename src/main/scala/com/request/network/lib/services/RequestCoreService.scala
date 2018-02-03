package com.request.network.lib.services

import java.math.BigInteger

import com.request.network.lib.artifacts.RequestCoreArtifact
import com.request.network.lib.config.RequestConfig
import com.request.network.lib.contracts.{RequestCore, RequestEthereum}
import com.request.network.lib.data.requestCore.{RequestCoreRequest, RequestCoreRequestData}
import com.request.network.lib.exception.RequestNetworkServiceException
import com.request.network.lib.wrappers.{IpfsWrapper, Web3Wrapper}
import org.web3j.crypto.WalletUtils
import org.web3j.tuples.generated.Tuple9
import org.web3j.tx.{Contract, ManagedTransaction}

import scala.concurrent.Future

class RequestCoreService()(implicit
                           ipfsWrapper: IpfsWrapper,
                           web3Wrapper: Web3Wrapper,
                           requestCoreArtifact: RequestCoreArtifact,
                           requestConfig: RequestConfig) {
  require(!requestCoreArtifact.networks.contains(web3Wrapper.networkName), s"RequestCore Artifact does not have configuration for network: ${web3Wrapper.networkName}")

  val addressRequestCore: String = requestCoreArtifact.networks(web3Wrapper.networkName).address
  //TODO not sure if we need this
  private val credentials = WalletUtils.loadCredentials("password", "/path/to/walletfile")
  //TODO get contracts by network name
  private val requestCore: RequestCore = RequestCore.deploy(web3Wrapper.web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send()
  private val requestEthereum: RequestEthereum = RequestEthereum.deploy(web3Wrapper.web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT, this.addressRequestCore).send()

  /**
    * get the number of the last request (N.B: number !== id)
    * @return  future of the number of the last request
    */
  def getCurrentNumRequest: Future[BigInteger] = requestCore.numRequests().sendAsync()

  /**
    * get the version of the contract
    * @return  future of the version of the contract
    */
  def getVersion: Future[BigInteger] = requestCore.VERSION().sendAsync()

  /**
    * get the estimation of ether (in wei) needed to create a request
    * @param   expectedAmount    amount expected of the request
    * @param   currencyContract  address of the currency contract of the request
    * @param   extension         address of the extension contract of the request
    * @return  future of the number of wei needed to create the request
    */
  def getCollectEstimation(expectedAmount: BigInteger, currencyContract: String, extension: String): Future[BigInteger] = {
    if(!web3Wrapper.isAddressNoChecksum(currencyContract))
      throw RequestNetworkServiceException("currencyContract must be a valid eth address")

    requestCore.getCollectEstimation(expectedAmount, currencyContract, extension).sendAsync()
  }


  def getRequest(requestId: String): Future[RequestCoreRequest] = {
    if(!web3Wrapper.isHexStrictBytes32(requestId))
      throw RequestNetworkServiceException("requestId must be a 32 bytes hex string")
    requestCore.requests(requestId.getBytes).sendAsync().map { request =>
      if(request.getValue1.equals(RequestCoreRequest.EMPTY_BYTES_32)) //creator
        throw RequestNetworkServiceException("request not found")

      val currencyContractFuture = RequestEthereumService.getRequestCurrencyContractInfo(requestId)
      //TODO I cant find anywhere this method?!?
      val extensionFuture = RequestEthereumService.getRequestExtensionInfo(requestId)

      val dataFuture = if(!request.getValue9.equals(""))
        ipfsWrapper.getFile(request.getValue9).map { fileContent =>
          Some(RequestCoreRequestData(fileContent, request.getValue9))
        }
      else
        Future.successful(None)

      for {
        contract <- currencyContractFuture
        extension <- extensionFuture
        data <- dataFuture
      } yield {
        RequestCoreRequest(request, contract, extension, data)
      }
    }.recoverWith{
      case e: Exception =>
        throw RequestNetworkServiceException(e.getMessage)
    }.flatten
  }

  def getRequestByTransactionHash(hash: String) = ???

  def getRequestEvents(requestID: String, fromBlock: Option[Int], toBlock: Option[Int]) = ???

  def getRequestsByAddress(address: String, fromBlock: Option[Int], toBlock: Option[Int]) = ???

  def getIpfsFile(hash: String) = ???

}
