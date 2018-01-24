package com.request.network.lib

import com.request.network.lib.wrappers.{IpfsWrapper, Web3Wrapper}


class RequestNetwork(provider: Option[Any], networkId: Option[Int], useIpfsPublic: Boolean = true) {
  require(provider.isDefined && networkId.isEmpty)

  implicit private val web3Wrapper = new Web3Wrapper(provider, networkId)
  implicit private val ipfsWrapper = new IpfsWrapper(useIpfsPublic)

  val requestCoreService = ???
  val requestEthereumService = ???
  val requestSynchroneExtensionEscrowService = ???

}
