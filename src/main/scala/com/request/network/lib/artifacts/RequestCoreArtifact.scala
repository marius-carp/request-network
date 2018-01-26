package com.request.network.lib.artifacts

import com.kifi.macros.jsonstrict
import com.request.network.lib.exception.RequestUnmarshalException
import com.request.network.lib.util.FileUtil
import play.api.libs.json.{JsError, JsSuccess, Json}

@jsonstrict
case class RequestCoreArtifact(networks: Map[String, NetworkArtifact])

object RequestCoreArtifact {

  def apply(): RequestCoreArtifact = {
    val fileContent = FileUtil.readFileToString("RequestCore.json")
    Json.parse(fileContent).validate[RequestCoreArtifact] match {
      case success: JsSuccess[RequestCoreArtifact] =>
        success.get
      case error: JsError =>
        throw RequestUnmarshalException(s"Error at unmarshalling RequestCore json, reason: $error")
    }
  }

}
