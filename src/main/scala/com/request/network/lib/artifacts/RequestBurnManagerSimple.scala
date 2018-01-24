package com.request.network.lib.artifacts

import com.request.network.lib.artifacts.Abi.{Input, Output}

case class RequestBurnManagerSimple(constant: Boolean,
                                    input: List[Input],
                                    name: Option[AbiName],
                                    output: List[Output],
                                    payable: Boolean,
                                    stateMutability: Option[StateMutability],
                                    abiType: AbiType) extends Abi

object RequestBurnManagerSimple {

  private val abi: List[RequestBurnManagerSimple] = List(
    RequestBurnManagerSimple(
      constant = false,
      List(InputOutput(ReqBurnerContractAbiInputName, AddressAbiInputType)),
      Some(SetReqBurnerContractAbiName),
      List.empty[Output],
      payable = false,
      Some(NonPayableStateMutability),
      FunctionAbiType)
  )

  def apply: List[RequestBurnManagerSimple] = abi

}
