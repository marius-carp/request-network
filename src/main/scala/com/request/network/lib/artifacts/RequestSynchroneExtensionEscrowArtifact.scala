package com.request.network.lib.artifacts

import com.kifi.macros.jsonstrict
import com.request.network.lib.artifacts.Abi.{Input, Output}
import com.request.network.lib.exception.RequestUnmarshalException
import com.request.network.lib.util.FileUtil
import play.api.libs.json.{JsError, JsSuccess, Json}

@jsonstrict
case class RequestSynchroneExtensionEscrowArtifactAbi(constant: Boolean,
                                                   input: List[Input],
                                                   name: Option[AbiName],
                                                   output: List[Output],
                                                   payable: Boolean,
                                                   stateMutability: Option[StateMutability],
                                                   abiType: AbiType) extends Abi

@jsonstrict
case class RequestSynchroneExtensionEscrowArtifact(abi: List[RequestCoreArtifactAbi], networks: Map[String, NetworkArtifact])

object RequestSynchroneExtensionEscrowArtifact {

  def apply(): RequestSynchroneExtensionEscrowArtifact = {
    val fileContent = FileUtil.readFileToString("contracts/RequestSynchroneExtensionEscrow.json")
    Json.parse(fileContent).validate[RequestSynchroneExtensionEscrowArtifact] match {
      case success: JsSuccess[RequestSynchroneExtensionEscrowArtifact] =>
        success.get
      case error: JsError =>
        throw RequestUnmarshalException(s"Error at unmarshalling RequestSynchroneExtensionEscrow json, reason: $error")
    }
  }
}
