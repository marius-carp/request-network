package com.request.network.lib

import java.util.Optional
import java.util.concurrent.CompletableFuture

import scala.compat.java8.FutureConverters
import scala.compat.java8.OptionConverters

package object services {

  implicit class implicitFuture[A](completableFuture: CompletableFuture[A]) {
    def asScala = FutureConverters.toScala(completableFuture)
  }

  implicit class implicitOption[A](optional: Optional[A]) {
    def asScala = OptionConverters.toScala(optional)
  }

}
