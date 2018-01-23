package com.request.network.lib.wrappers

import io.ipfs.api.IPFS

import scala.concurrent.Future

class IpfsWrapper(ipfs: IPFS) {

  def addFile(data: String): Future[Any] = ???

  def getFile(hash: String): Future[String] = ???

}
