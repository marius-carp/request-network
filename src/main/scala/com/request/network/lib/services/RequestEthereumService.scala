package com.request.network.lib.services

import com.request.network.lib.artifacts.{RequestCoreArtifact, RequestEthereumArtifact}
import com.request.network.lib.config.RequestConfig
import com.request.network.lib.contracts.{RequestCore, RequestEthereum}
import com.request.network.lib.data.{RequestAdditional, RequestExtension, RequestOption}
import com.request.network.lib.wrappers.{IpfsWrapper, Web3Wrapper}
import org.web3j.crypto.WalletUtils
import org.web3j.tx.{Contract, ManagedTransaction}

import scala.concurrent.Future

class RequestEthereumService()(implicit ipfsWrapper: IpfsWrapper,
                               web3Wrapper: Web3Wrapper,
                               requestCoreService: RequestCoreService,
                               requestCoreArtifact: RequestCoreArtifact,
                               requestEthereumArtifact: RequestEthereumArtifact,
                               requestConfig: RequestConfig) {

  require(requestEthereumArtifact.networks.contains(web3Wrapper.networkName),
    s"RequestEthereum Artifact does not have configuration for network: ${web3Wrapper.networkName}")

  val addressRequestEthereum: String = requestEthereumArtifact.networks(web3Wrapper.networkName).address
  //TODO not sure if we need this
  private val credentials = WalletUtils.loadCredentials("password", "/path/to/walletfile")
  private val requestEthereum: RequestEthereum = RequestEthereum.deploy(web3Wrapper.web3j, credentials,
    ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT, requestCoreService.addressRequestCore).send()


  def createRequestAsPayee(payer: String,
                           amountInitial: Double,
                           data: Option[String],
                           extension: Option[RequestExtension],
                           extensionParams: Option[List[RequestExtension]],
                           options: Option[RequestOption]): Any = ???

  def accept(requestId: String, options: Option[RequestOption]) = ???

  def cancel(requestId: String, options: Option[RequestOption]) = ???

  def paymentAction(requestId: String, amount: Double, additional: RequestAdditional,options: Option[RequestOption]) = ???

  def refundAction(requestId: String, amount: Double, options: Option[RequestOption]) = ???

  def subtractAction(requestId: String, amount: Double, options: Option[RequestOption]) = ???

  def additionalAction(requestId: String, amount: Double, options: Option[RequestOption]) = ???

  def getRequestCurrencyContractInfo(requestId: String): Future[Unit] = Future.successful[Unit](Unit)

  def getRequest(requestId: String) = requestCoreService.getRequest(requestId)

  def getRequestEvents(requestId: String, fromBlock: Option[Int], toBlock: Option[Int]) =
    requestCoreService.getRequestEvents(requestId, fromBlock, toBlock)

  def decodeInputData(data: Any) = ???

  def getRequestEventsCurrencyContractInfo(requestId: String, fromBlock: Option[Int], toBlock: Option[Int]) = ???


}
