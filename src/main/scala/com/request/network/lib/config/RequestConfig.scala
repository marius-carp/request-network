package com.request.network.lib.config

import com.typesafe.config.Config
import scala.collection.JavaConverters._

class RequestConfig(rawConfig: Config) {

  Seq(
    "ethereum",
    "ipfs"
  ).foreach { mandatoryField =>
    require(rawConfig.hasPathOrNull(mandatoryField), s"missing or null mandatory service config field: $mandatoryField")
  }

  private val ethereum = rawConfig.getConfig("ethereum")

  val ethereumDefault: String = ethereum.getString("default")
  val ethereumNodeUrlDefault: Map[String, String] = {
    (for {
      item <- ethereum.getObjectList("nodeUrlDefault").asScala
      entry <- item.entrySet().asScala
    } yield (entry.getKey, entry.getValue.unwrapped().toString)).toMap
  }

}
