package com.request.network.lib.artifacts

import com.request.network.lib.artifacts.Abi.{Input, Output}

case class RequestCore(constant: Boolean,
                       input: List[Input],
                       name: Option[AbiName],
                       output: List[Output],
                       payable: Boolean,
                       stateMutability: Option[StateMutability],
                       abiType: AbiType) extends Abi

object RequestCore {

  private val abi: List[RequestCore] = List(
    RequestCore(
      constant = true,
      List(InputOutput(RequestIdAbiInputName, Bytes32AbiInputType)),
      Some(GetPayeeAbiName),
      List(InputOutput(BlankAbiInputName, AddressAbiInputType)),
      payable = false,
      Some(ViewStateMutability),
      FunctionAbiType)
  )

  def apply(): List[RequestCore] = abi

}
