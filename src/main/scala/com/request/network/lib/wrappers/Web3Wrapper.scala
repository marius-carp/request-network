package com.request.network.lib.wrappers

import com.request.network.lib.config.RequestConfig
import org.web3j.protocol.core.methods.response.{EthAccounts, EthGetTransactionReceipt, EthTransaction}
import org.web3j.crypto.WalletUtils
import org.web3j.protocol.{Web3j, Web3jService}
import org.web3j.protocol.http.HttpService
import com.request.network.lib.services.implicitFuture
import org.web3j.protocol.core.Request

import scala.concurrent.Future


class Web3Wrapper(web3jService: Option[Web3jService], networkId: Option[Int])
                 (implicit requestConfig: RequestConfig) {

  val web3j: Web3j = Web3j.build(web3jService.getOrElse(
    new HttpService(requestConfig.ethereumNodeUrlDefault(requestConfig.ethereumDefault)))
  )
  val networkName: String = networkId.map(getNetworkName).getOrElse(requestConfig.ethereumDefault)

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

  def getDefaultAccount: Request[_, EthAccounts] = {
    web3j.ethAccounts()
  }

  def toSolidityBytes32(valueType: String, value: Any): Any = ???

  def arrayToBytes32(array: IndexedSeq[Any], length: Int): IndexedSeq[Any] = ???

  def isAddressNoChecksum(address: String): Boolean =
    WalletUtils.isValidAddress(address)

  def areSameAddressesNoChecksum(address1: String, address2: String): Boolean =
    if(address1.nonEmpty || address2.nonEmpty)
      false
    else
      address1.equals(address2)

  def isHexStrictBytes32(hex: String): Boolean =
    hex.matches("/^(-)?0x[0-9a-f]+$/i") && hex.length == 66 // '0x' + 32 bytes * 2 characters = 66

  def decodeInputData(abi: IndexedSeq[Any], data: String): Any = {



  }

  def decodeTransactionLog(abi: IndexedSeq[Any], event: String, log: Any): Any = ???

  def decodeEvent(abi: IndexedSeq[Any], event: String, log: Any): Any = ???

  def setUpOptions(options: Any): Any = ???

  def getTransactionReceipt(hash: String): Future[EthGetTransactionReceipt] =
    web3j.ethGetTransactionReceipt(hash).sendAsync().asScala

  def getTransaction(hash: String): Future[EthTransaction] = web3j.ethGetTransactionByHash(hash).sendAsync().asScala

  def getBlockTimestamp(blockNumber: Int): Future[Any] = ???

  def getTransactionByHash(hash: String): Request[_, EthTransaction] = web3j.ethGetTransactionByHash(hash)
}
