package com.request.network.lib.services

import java.math.BigInteger
import com.request.network.lib.artifacts.RequestCoreArtifact
import com.request.network.lib.config.RequestConfig
import com.request.network.lib.contracts.RequestCore
import com.request.network.lib.wrappers.{IpfsWrapper, Web3Wrapper}
import org.web3j.crypto.WalletUtils
import org.web3j.tx.{Contract, ManagedTransaction}

import scala.concurrent.Future

class RequestCoreService()(implicit
                           ipfs: IpfsWrapper,
                           web3Wrapper: Web3Wrapper,
                           requestCoreArtifact: RequestCoreArtifact,
                           requestConfig: RequestConfig) {
  require(!requestCoreArtifact.networks.contains(web3Wrapper.networkName), s"RequestCore Artifact does not have configuration for network: ${web3Wrapper.networkName}")

  val addressRequestCore: String = requestCoreArtifact.networks(web3Wrapper.networkName).address
  //TODO not sure if we need this
  private val credentials = WalletUtils.loadCredentials("password", "/path/to/walletfile")
  private val requestCore: RequestCore = RequestCore.deploy(web3Wrapper.web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send()

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

  def getCollectEstimation(expectedAmount: Double, currencyContract: String, extension: String) = ???

  def getRequest(requestID: String) = ???

  def getRequestByTransactionHash(hash: String) = ???

  def getRequestEvents(requestID: String, fromBlock: Option[Int], toBlock: Option[Int]) = ???

  def getRequestsByAddress(address: String, fromBlock: Option[Int], toBlock: Option[Int]) = ???

  def getIpfsFile(hash: String) = ???

}
