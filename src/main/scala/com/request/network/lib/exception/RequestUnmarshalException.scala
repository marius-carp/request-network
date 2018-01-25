package com.request.network.lib.exception

case class RequestUnmarshalException(message: String, cause: Option[Exception] = None)
  extends RuntimeException(message, cause.orNull)
    with RequestNetworkException
