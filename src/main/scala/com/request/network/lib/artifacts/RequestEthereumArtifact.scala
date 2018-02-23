package com.request.network.lib.artifacts

import com.request.network.lib.exception.RequestUnmarshalException
import com.request.network.lib.util.FileUtil
import play.api.libs.json.{JsError, JsSuccess, Json}

case class RequestEthereumArtifact(networks: Map[String, NetworkArtifact])

object RequestEthereumArtifact {

  implicit val requestEthereumArtifactFormat = Json.format[RequestEthereumArtifact]

  def apply(): RequestEthereumArtifact = {
    val fileContent = FileUtil.readFileToString("RequestEthereum.json")
    Json.parse(fileContent).validate[RequestEthereumArtifact] match {
      case JsSuccess(requestEthereumArtifact, _) =>
        requestEthereumArtifact
      case error: JsError =>
        throw RequestUnmarshalException(s"Error at unmarshalling RequestCore json, reason: $error")
    }
  }

}
