package com.request.network.lib

import com.request.network.lib.artifacts.{RequestCoreArtifact, RequestEthereumArtifact, RequestSynchroneExtensionEscrowArtifact}
import com.request.network.lib.wrappers.{IpfsWrapper, Web3Wrapper}
import org.web3j.protocol.Web3jService


class RequestNetwork(provider: Option[Web3jService], networkId: Option[Int], useIpfsPublic: Boolean = true) {
  require(provider.isDefined && networkId.isEmpty)

  implicit private val web3Wrapper = new Web3Wrapper(provider, networkId)
  implicit private val ipfsWrapper = new IpfsWrapper(useIpfsPublic)

  implicit private val requestCoreArtifact = RequestCoreArtifact
  implicit private val requestEthereumArtifact = RequestEthereumArtifact
  implicit private val requestSynchroneExtensionEscrowArtifact = RequestSynchroneExtensionEscrowArtifact

  val requestCoreService = ???
  val requestEthereumService = ???
  val requestSynchroneExtensionEscrowService = ???

}
