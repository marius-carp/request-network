package com.request.network.lib.artifacts

import com.request.network.lib.artifacts.Abi.{Input, Output}

case class RequestSynchroneExtensionEscrow(constant: Boolean,
                                           input: List[Input],
                                           name: Option[AbiName],
                                           output: List[Output],
                                           payable: Boolean,
                                           stateMutability: Option[StateMutability],
                                           abiType: AbiType) extends Abi

object RequestSynchroneExtensionEscrow {

  private val abi: List[RequestSynchroneExtensionEscrow] = List(
    RequestSynchroneExtensionEscrow(
      constant = true,
      List(InputOutput(BlankAbiInputName, Bytes32AbiInputType)),
      Some(EscrowsAbiName),
      List(
        InputOutput(CurrencyContractAbiInputName, AddressAbiInputType),
        InputOutput(EscrowAbiInputName, AddressAbiInputType),
        InputOutput(StateAbiInputName, Uint8AbiInputType),
        InputOutput(BalanceAbiInputName, Uint256AbiInputType)
      ),
      payable = true,
      Some(PayableStateMutability),
      FunctionAbiType)
  )

  def apply(): List[RequestSynchroneExtensionEscrow] = abi
}
