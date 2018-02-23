package com.request.network.lib.artifacts

import com.request.network.lib.exception.RequestUnmarshalException
import com.request.network.lib.util.FileUtil
import play.api.libs.json.{JsError, JsSuccess, Json}

case class RequestBurnManagerSimple(networks: Map[String, NetworkArtifact])

object RequestBurnManagerSimple {

  implicit val requestBurnManagerSimpleFormat = Json.format[RequestBurnManagerSimple]

  def apply(): RequestBurnManagerSimple = {
    val fileContent = FileUtil.readFileToString("RequestBurnManagerSimple.json")
    Json.parse(fileContent).validate[RequestBurnManagerSimple] match {
      case JsSuccess(requestBurnManagerSimple, _) =>
        requestBurnManagerSimple
      case error: JsError =>
        throw RequestUnmarshalException(s"Error at unmarshalling RequestBurnManagerSimple json, reason: $error")
    }
  }

}
