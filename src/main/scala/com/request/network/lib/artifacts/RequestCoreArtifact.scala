package com.request.network.lib.artifacts

import com.request.network.lib.exception.RequestUnmarshalException
import com.request.network.lib.util.FileUtil
import play.api.libs.json.{JsError, JsSuccess, Json}

case class RequestCoreArtifact(networks: Map[String, NetworkArtifact])

object RequestCoreArtifact {

  implicit val requestCoreArtifactFormat = Json.format[RequestCoreArtifact]

  def apply(): RequestCoreArtifact = {
    val fileContent = FileUtil.readFileToString("RequestCore.json")
    Json.parse(fileContent).validate[RequestCoreArtifact] match {
      case JsSuccess(requestCoreArtifact, _) =>
        requestCoreArtifact
      case error: JsError =>
        throw RequestUnmarshalException(s"Error at unmarshalling RequestCore json, reason: $error")
    }
  }

}
