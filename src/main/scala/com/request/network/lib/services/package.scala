package com.request.network.lib

import java.util.concurrent.CompletableFuture

import scala.compat.java8.FutureConverters
import scala.concurrent.Future

package object services {

  implicit def implicitFuture[A](completableFuture: CompletableFuture[A]): Future[A] = {
    FutureConverters.toScala(completableFuture)
  }

}
