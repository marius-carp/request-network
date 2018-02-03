package com.request.network.lib.exception


case class RequestNetworkServiceException(message: String, cause: Option[Exception] = None)
  extends RuntimeException(message, cause.orNull)
    with RequestNetworkException
