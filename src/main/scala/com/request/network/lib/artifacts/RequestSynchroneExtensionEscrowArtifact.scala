package com.request.network.lib.artifacts

import com.kifi.macros.jsonstrict
import com.request.network.lib.exception.RequestUnmarshalException
import com.request.network.lib.util.FileUtil
import play.api.libs.json.{JsError, JsSuccess, Json}

@jsonstrict
case class RequestSynchroneExtensionEscrowArtifact(networks: Map[String, NetworkArtifact])

object RequestSynchroneExtensionEscrowArtifact {

  def apply(): RequestSynchroneExtensionEscrowArtifact = {
    val fileContent = FileUtil.readFileToString("RequestSynchroneExtensionEscrow.json")
    Json.parse(fileContent).validate[RequestSynchroneExtensionEscrowArtifact] match {
      case success: JsSuccess[RequestSynchroneExtensionEscrowArtifact] =>
        success.get
      case error: JsError =>
        throw RequestUnmarshalException(s"Error at unmarshalling RequestSynchroneExtensionEscrow json, reason: $error")
    }
  }
}
