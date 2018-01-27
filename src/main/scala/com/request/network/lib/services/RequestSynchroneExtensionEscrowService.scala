package com.request.network.lib.services

import com.request.network.lib.artifacts.{RequestCoreArtifact, RequestSynchroneExtensionEscrowArtifact}
import com.request.network.lib.contracts.RequestSynchroneExtensionEscrow
import com.request.network.lib.data.{RequestExtension, RequestOption}
import com.request.network.lib.wrappers.{IpfsWrapper, Web3Wrapper}
import org.web3j.crypto.WalletUtils
import org.web3j.tx.{Contract, ManagedTransaction}

class RequestSynchroneExtensionEscrowService()(implicit
                                               ipfsWrapper: IpfsWrapper,
                                               web3Wrapper: Web3Wrapper,
                                               requestCoreService: RequestCoreService,
                                               requestCoreArtifact: RequestCoreArtifact,
                                               requestSynchroneExtensionEscrowArtifact: RequestSynchroneExtensionEscrowArtifact) {

  require(requestSynchroneExtensionEscrowArtifact.networks.contains(web3Wrapper.networkName),
    s"RequestSynchroneExtensionEscrow Artifact does not have configuration for network: ${web3Wrapper.networkName}")

  val addressSynchroneExtensionEscrow: String = requestSynchroneExtensionEscrowArtifact.networks(web3Wrapper.networkName).address
  //TODO not sure if we need this
  private val credentials = WalletUtils.loadCredentials("password", "/path/to/walletfile")
  private val requestEthereum: RequestSynchroneExtensionEscrow = RequestSynchroneExtensionEscrow.deploy(web3Wrapper.web3j, credentials,
    ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT, requestCoreService.addressRequestCore).send()


  def parseParameters(extensionParams: List[RequestExtension]) = ???

  def releaseToPayeeAction(requestId: String, options: Option[RequestOption]) = ???

  def releaseToPayerAction(requestId: String, options: Option[RequestOption]) = ???

  def getRequest(requestId: String) = ???

  def getRequestExtensionInfo(requestId: String) = ???

  def getRequestEvents(requestID: String, fromBlock: Option[Int], toBlock: Option[Int]) = ???

  def getRequestEventsExtensionInfo(requestID: String, fromBlock: Option[Int], toBlock: Option[Int]) = ???


}
