package com.request.network.lib.artifacts

import com.request.network.lib.exception.RequestUnmarshalException
import com.request.network.lib.util.FileUtil
import play.api.libs.json.{JsError, JsSuccess, Json}

case class RequestSynchroneExtensionEscrowArtifact(networks: Map[String, NetworkArtifact])

object RequestSynchroneExtensionEscrowArtifact {

  implicit val requestSynchroneExtensionEscrowArtifactFormat = Json.format[RequestSynchroneExtensionEscrowArtifact]

  def apply(): RequestSynchroneExtensionEscrowArtifact = {
    val fileContent = FileUtil.readFileToString("RequestSynchroneExtensionEscrow.json")
    Json.parse(fileContent).validate[RequestSynchroneExtensionEscrowArtifact] match {
      case JsSuccess(requestSynchroneExtensionEscrowArtifact, _) =>
        requestSynchroneExtensionEscrowArtifact
      case error: JsError =>
        throw RequestUnmarshalException(s"Error at unmarshalling RequestSynchroneExtensionEscrow json, reason: $error")
    }
  }
}
