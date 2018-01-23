package com.request.network.lib.services

import com.request.network.lib.data.{RequestExtension, RequestOption}

class RequestSynchroneExtensionEscrowService(
                                            abiRequestCore: Any,
                                            abiSynchroneExtensionEscrow: Any,
                                            addressSynchroneExtensionEscrow: String,
                                            instanceSynchroneExtensionEscrow: Any
                                            )(implicit
                                              requestCoreService: RequestCoreService) {

  def parseParameters(extensionParams: List[RequestExtension]) = ???

  def releaseToPayeeAction(requestId: String, options: Option[RequestOption]) = ???

  def releaseToPayerAction(requestId: String, options: Option[RequestOption]) = ???

  def getRequest(requestId: String) = ???

  def getRequestExtensionInfo(requestId: String) = ???

  def getRequestEvents(requestID: String, fromBlock: Option[Int], toBlock: Option[Int]) = ???

  def getRequestEventsExtensionInfo(requestID: String, fromBlock: Option[Int], toBlock: Option[Int]) = ???


}
