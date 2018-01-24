package com.request.network.lib.wrappers

import org.web3j.protocol.Web3j

import scala.concurrent.{Future, Promise}


class Web3Wrapper(web3Provider: Option[Any], networkId: Option[Int]) {

  val networkName: String = ???
  val web3j: Web3j = ???

  def BN() = ???

  def getNetworkName(networkId: Int): String = ???

  def broadcastMethod() = ???

  def getDefaultAccount(): Future[Any] = ???

  def toSolidityBytes32(valueType: String, value: Any): Any = ???

  def arrayToBytes32(array: IndexedSeq[Any], length: Int): IndexedSeq[Any] = ???

  def isAddressNoChecksum(address: String): Boolean = ???

  def areSameAddressesNoChecksum(address1: String, address2: String) = ???

  def isHexStrictBytes32(hex: String): Boolean = ???

  def decodeInputData(abi: IndexedSeq[Any], data: String): Any = ???

  def decodeTransactionLog(abi: IndexedSeq[Any], event: String, log: Any): Any = ???

  def decodeEvent(abi: IndexedSeq[Any], event: String, log: Any): Any = ???

  def setUpOptions(options: Any): Any = ???

  def getTransactionReceipt(hash: String): Future[Any] = ???

  def getTransaction(hash: String): Future[Any] = ???

  def getBlockTimestamp(blockNumber: Int): Future[Any] = ???


}
