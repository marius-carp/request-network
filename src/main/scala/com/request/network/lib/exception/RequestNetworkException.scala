package com.request.network.lib.exception

trait RequestNetworkException {
  val message: String
  val cause: Option[Throwable]
}
