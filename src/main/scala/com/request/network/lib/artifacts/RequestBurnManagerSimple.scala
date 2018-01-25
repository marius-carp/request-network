package com.request.network.lib.artifacts

import com.kifi.macros.jsonstrict
import com.request.network.lib.artifacts.Abi.{Input, Output}
import com.request.network.lib.exception.RequestUnmarshalException
import com.request.network.lib.util.FileUtil
import play.api.libs.json.{JsError, JsSuccess, Json}

@jsonstrict
case class RequestBurnManagerSimpleAbi(constant: Boolean,
                                    input: List[Input],
                                    name: Option[AbiName],
                                    output: List[Output],
                                    payable: Boolean,
                                    stateMutability: Option[StateMutability],
                                    abiType: AbiType) extends Abi

@jsonstrict
case class RequestBurnManagerSimple(abi: List[RequestBurnManagerSimpleAbi], networks: Map[String, NetworkArtifact])

object RequestBurnManagerSimple {

  def apply(): RequestBurnManagerSimple = {
    val fileContent = FileUtil.readFileToString("RequestBurnManagerSimple.json")
    Json.parse(fileContent).validate[RequestBurnManagerSimple] match {
      case success: JsSuccess[RequestBurnManagerSimple] =>
        success.get
      case error: JsError =>
        throw RequestUnmarshalException(s"Error at unmarshalling RequestBurnManagerSimple json, reason: $error")
    }
  }

}
