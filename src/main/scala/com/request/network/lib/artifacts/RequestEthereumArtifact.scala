package com.request.network.lib.artifacts

import com.kifi.macros.jsonstrict
import com.request.network.lib.exception.RequestUnmarshalException
import com.request.network.lib.util.FileUtil
import play.api.libs.json.{JsError, JsSuccess, Json}


@jsonstrict
case class RequestEthereumArtifact(networks: Map[String, NetworkArtifact])

object RequestEthereumArtifact {

  def apply(): RequestEthereumArtifact = {
    val fileContent = FileUtil.readFileToString("RequestEthereum.json")
    Json.parse(fileContent).validate[RequestEthereumArtifact] match {
      case success: JsSuccess[RequestEthereumArtifact] =>
        success.get
      case error: JsError =>
        throw RequestUnmarshalException(s"Error at unmarshalling RequestCore json, reason: $error")
    }
  }

}
