package com.request.network.lib.artifacts

import com.request.network.lib.artifacts.Abi.{Input, Output}


case class RequestEthereum(constant: Boolean,
                           input: List[Input],
                           name: Option[AbiName],
                           output: List[Output],
                           payable: Boolean,
                           stateMutability: Option[StateMutability],
                           abiType: AbiType) extends Abi

object RequestEthereum {

  private val abi: List[RequestEthereum] = List(
    RequestEthereum(
      constant = false,
      List(
        InputOutput(RequestIdAbiInputName, Bytes32AbiInputType),
        InputOutput(AdditionalsAbiInputName, Uint256AbiInputType)
      ),
      Some(PaymentAbiName),
      List.empty[Output],
      payable = true,
      Some(PayableStateMutability),
      FunctionAbiType)
  )

  def apply(): List[RequestEthereum] = abi

}
