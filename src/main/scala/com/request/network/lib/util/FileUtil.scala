package com.request.network.lib.util

import com.request.network.lib.exception.RequestReadFileFailureException

import scala.io.Source

object FileUtil {
  def readFileToString(path: String): String = {
    try {
      val file = Source.fromInputStream(getClass.getClassLoader.getResourceAsStream(path))
      val result = file.getLines().mkString(System.getProperty("line.separator"))
      file.close()

      result
    }
    catch {
      case _: NullPointerException =>
        throw RequestReadFileFailureException(s"No file found at $path")
    }
  }
}
