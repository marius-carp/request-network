package com.request.network.lib.services

import com.request.network.lib.wrappers.{IpfsWrapper, Web3Wrapper}

import scala.concurrent.Future

class RequestCoreService(abiRequestCore: Any,
                         addressRequestCore: String,
                         instanceRequestCore: String)
                        (implicit ipfs: IpfsWrapper,
                         web3Wrapper: Web3Wrapper) {

  def getCurrentNumRequest(): Future[Int] = ???

  def getVersion: Future[Int] = ???

  def getCollectEstimation(expectedAmount: Double, currencyContract: String, extension: String) = ???

  def getRequest(requestID: String) = ???

  def getRequestByTransactionHash(hash: String) = ???

  def getRequestEvents(requestID: String, fromBlock: Option[Int], toBlock: Option[Int]) = ???

  def getRequestsByAddress(address: String, fromBlock: Option[Int], toBlock: Option[Int]) = ???

  def getIpfsFile(hash: String) = ???

}
