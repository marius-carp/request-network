package com.request.network.lib.artifacts

import com.request.network.lib.artifacts.Abi.{Input, Output}

case class RequestSynchroneExtensionEscrowArtifactAbi(constant: Boolean,
                                                   input: List[Input],
                                                   name: Option[AbiName],
                                                   output: List[Output],
                                                   payable: Boolean,
                                                   stateMutability: Option[StateMutability],
                                                   abiType: AbiType) extends Abi

case class RequestSynchroneExtensionEscrowArtifact(abi: List[RequestCoreArtifactAbi], networks: Map[String, NetworkArtifact])

object RequestSynchroneExtensionEscrowArtifact {

  def apply(): RequestSynchroneExtensionEscrowArtifact = new RequestSynchroneExtensionEscrowArtifact(abi, networks)

  private val abi: List[RequestSynchroneExtensionEscrowArtifactAbi] = List(
    RequestSynchroneExtensionEscrowArtifactAbi(
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

  val networks: Map[String, NetworkArtifact] = Map(
    "private" -> NetworkArtifact("0x345ca3e014aaf5dca488057592ee47305d9b3e10", 0),
    "rinkeby" -> NetworkArtifact("0x8B9186213fFE76365167e12C6D9965774E5fed33", 1402856)
  )
}
