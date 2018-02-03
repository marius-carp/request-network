package com.request.network.lib.wrappers

import com.request.network.lib.config.RequestConfig
import org.web3j.crypto.WalletUtils
import org.web3j.protocol.{Web3j, Web3jService}
import org.web3j.protocol.http.HttpService

import scala.concurrent.Future


class Web3Wrapper(web3jService: Option[Web3jService], networkId: Option[Int])
                 (implicit requestConfig: RequestConfig) {

  val web3j: Web3j = Web3j.build(web3jService.getOrElse(
    new HttpService(requestConfig.ethereumNodeUrlDefault(requestConfig.ethereumDefault)))
  )
  val networkName: String = networkId.map(getNetworkName).getOrElse(requestConfig.ethereumDefault)

  def BN() = ???

  def getNetworkName(networkId: Int): String = {
    networkId match {
      case 1 => "main"
      case 2 => "morden"
      case 3 => "ropsten"
      case 4 => "rinkeby"
      case 42 => "kovan"
      case _ => "private"
    }
  }

  def broadcastMethod() = ???

  def getDefaultAccount(): Future[Any] = ???

  def toSolidityBytes32(valueType: String, value: Any): Any = ???

  def arrayToBytes32(array: IndexedSeq[Any], length: Int): IndexedSeq[Any] = ???

  def isAddressNoChecksum(address: String): Boolean =
    WalletUtils.isValidAddress(address)

  def areSameAddressesNoChecksum(address1: String, address2: String) = ???

  def isHexStrictBytes32(hex: String): Boolean =
    hex.matches("/^(-)?0x[0-9a-f]+$/i") && hex.length == 66 // '0x' + 32 bytes * 2 characters = 66

  def decodeInputData(abi: IndexedSeq[Any], data: String): Any = ???

  def decodeTransactionLog(abi: IndexedSeq[Any], event: String, log: Any): Any = ???

  def decodeEvent(abi: IndexedSeq[Any], event: String, log: Any): Any = ???

  def setUpOptions(options: Any): Any = ???

  def getTransactionReceipt(hash: String): Future[Any] = ???

  def getTransaction(hash: String): Future[Any] = ???

  def getBlockTimestamp(blockNumber: Int): Future[Any] = ???

}
