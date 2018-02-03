package com.request.network.lib.services

import com.request.network.lib.artifacts.RequestCoreArtifact
import com.request.network.lib.config.RequestConfig
import com.request.network.lib.contracts.RequestCore
import com.request.network.lib.wrappers.{IpfsWrapper, Web3Wrapper}
import org.web3j.crypto.WalletUtils
import org.web3j.tx.{Contract, ManagedTransaction}

import scala.concurrent.{ExecutionContext, Future}

class RequestCoreService()(implicit
                           ipfs: IpfsWrapper,
                           web3Wrapper: Web3Wrapper,
                           requestCoreArtifact: RequestCoreArtifact,
                           requestConfig: RequestConfig) {
  require(
    !requestCoreArtifact.networks.contains(web3Wrapper.networkName),
    s"RequestCore Artifact does not have configuration for network: ${web3Wrapper.networkName}"
  )

  val addressRequestCore: String =
    requestCoreArtifact.networks(web3Wrapper.networkName).address

  //TODO not sure if we need this
  private val credentials =
    WalletUtils.loadCredentials("password", "/path/to/walletfile")

  private val requestCore: RequestCore = RequestCore
    .deploy(web3Wrapper.web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT)
    .send()

  /**
    * get the number of the last request (N.B: number !== id)
    * @return  future of the number of the last request
    */
  def getCurrentNumRequest(implicit executionContext: ExecutionContext): Future[BigInt] =
    requestCore.numRequests().sendAsync().asScala.map(BigInt(_))

  /**
    * get the version of the contract
    * @return  future of the version of the contract
    */
  def getVersion(implicit executionContext: ExecutionContext): Future[BigInt] =
    requestCore.VERSION().sendAsync().asScala.map(BigInt(_))

  /**
    * get the estimation of ether (in wei) needed to create a request
    * @param   expectedAmount    amount expected of the request
    * @param   currencyContract  address of the currency contract of the request
    * @param   extension         address of the extension contract of the request
    * @return  future of the number of wei needed to create the request
    */
  def getCollectEstimation(expectedAmount: BigInt, currencyContract: String, extension: String)(
      implicit executionContext: ExecutionContext): Future[BigInt] = {
    if (!web3Wrapper.isAddressNoChecksum(currencyContract)) {
      Future.failed(new RuntimeException("currencyContract must be a valid eth address"))
    } else if (extension.nonEmpty && !web3Wrapper.isAddressNoChecksum(extension)) {
      Future.failed(new RuntimeException("extension must be a valid eth address"))
    } else {
      requestCore
        .getCollectEstimation(expectedAmount.bigInteger, currencyContract, extension)
        .sendAsync().asScala
        .map(BigInt(_))
    }
  }

  /**
    * get a request by its requestId
    * @param   requestId    requestId of the request
    * @return  future of the object containing the request
    */
  def getRequest(requestId: String): Future[Any] = {
    if(!web3Wrapper.isHexStrictBytes32(requestId)) {
      Future.failed(new RuntimeException("requestId must be a 32 bytes hex string"))
    } else {
      ???
    }
  }

  /**
    * get a request and method called by the hash of a transaction
    * @param   hash    hash of the ethereum transaction
    * @return  future of the object containing the request and the transaction
    */
  def getRequestByTransactionHash(hash: String)(
    implicit executionContext: ExecutionContext): Future[Any] = {
    web3Wrapper.getTransaction(hash).asScala.map { ethTransaction =>
      ethTransaction.getTransaction.asScala.map { transaction =>
        val ccyContract = transaction.getTo

        val ccyContractservice = ???

        ???
      }.getOrElse(new RuntimeException("transaction not found"))
    }
  }

  def getRequestEvents(requestId: String, fromBlock: Option[Int], toBlock: Option[Int]) = ???

  def getRequestsByAddress(address: String, fromBlock: Option[Int], toBlock: Option[Int]) = ???

  def getIpfsFile(hash: String) = ???

}
