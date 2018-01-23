package com.request.network.lib.services

import com.request.network.lib.data.{RequestAdditional, RequestExtension, RequestOption}
import com.request.network.lib.wrappers.{IpfsWrapper, Web3Wrapper}

class RequestEthereumService(
                            abiRequestCore: Any,
                            abiRequestEthereum: Any,
                            addressRequestEthereum: String,
                            instanceRequestEthereum: Any
                            )(implicit ipfsWrapper: IpfsWrapper,
                              web3Wrapper: Web3Wrapper,
                              requestCoreService: RequestCoreService) {

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

  def getRequestCurrencyContractInfo(requestId: String) = ???

  def getRequest(requestId: String) = ???

  def getRequestEvents(requestId: String, fromBlock: Option[Int], toBlock: Int) = ???

  def decodeInputData(data: Any) = ???

  def getRequestEventsCurrencyContractInfo(requestId: String, fromBlock: Option[Int], toBlock: Option[Int]) = ???


}
