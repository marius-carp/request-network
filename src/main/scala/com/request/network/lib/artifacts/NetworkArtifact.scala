package com.request.network.lib.artifacts

import play.api.libs.json.Json

case class NetworkArtifact(address: String, blockNumber: Long)

object NetworkArtifact {
  implicit val networkArtifactFormat = Json.format[NetworkArtifact]
}