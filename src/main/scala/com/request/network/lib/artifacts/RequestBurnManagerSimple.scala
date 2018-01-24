package com.request.network.lib.artifacts

import com.request.network.lib.artifacts.Abi.{Input, Output}

case class RequestBurnManagerSimpleAbi(constant: Boolean,
                                    input: List[Input],
                                    name: Option[AbiName],
                                    output: List[Output],
                                    payable: Boolean,
                                    stateMutability: Option[StateMutability],
                                    abiType: AbiType) extends Abi

case class RequestBurnManagerSimple(abi: List[RequestBurnManagerSimpleAbi], networks: Map[String, NetworkArtifact])

object RequestBurnManagerSimple {

  def apply(): RequestBurnManagerSimple = new RequestBurnManagerSimple(abi, networks)

  private val abi: List[RequestBurnManagerSimpleAbi] = List(
    RequestBurnManagerSimpleAbi(
      constant = false,
      List(InputOutput(ReqBurnerContractAbiInputName, AddressAbiInputType)),
      Some(SetReqBurnerContractAbiName),
      List.empty[Output],
      payable = false,
      Some(NonPayableStateMutability),
      FunctionAbiType)
  )

  val networks: Map[String, NetworkArtifact] = Map(
    "private" -> NetworkArtifact("0xf25186b5081ff5ce73482ad761db0eb0d25abfbf", 0),
    "rinkeby" -> NetworkArtifact("0x6E51827948F057a354d01bA0a108Fdc7843B0d04", 1402858)
  )

}
