package com.request.network.lib.services

import com.request.network.lib.artifacts.RequestCoreArtifact
import com.request.network.lib.wrappers.{IpfsWrapper, Web3Wrapper}

import scala.concurrent.Future

class RequestCoreService()(implicit
                           ipfs: IpfsWrapper,
                           web3Wrapper: Web3Wrapper,
                           requestCoreArtifact: RequestCoreArtifact) {
  require(requestCoreArtifact.networks.contains(web3Wrapper.networkName), s"RequestCore Artifact does not have configuration for network: ${web3Wrapper.networkName}")

  private val addressRequestCore: String = requestCoreArtifact.networks(web3Wrapper.networkName).address
  private val requestCore = ???

  def getCurrentNumRequest(): Future[Int] = ???

  def getVersion: Future[Int] = ???

  def getCollectEstimation(expectedAmount: Double, currencyContract: String, extension: String) = ???

  def getRequest(requestID: String) = ???

  def getRequestByTransactionHash(hash: String) = ???

  def getRequestEvents(requestID: String, fromBlock: Option[Int], toBlock: Option[Int]) = ???

  def getRequestsByAddress(address: String, fromBlock: Option[Int], toBlock: Option[Int]) = ???

  def getIpfsFile(hash: String) = ???

}
