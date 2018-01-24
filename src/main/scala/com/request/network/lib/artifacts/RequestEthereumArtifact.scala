package com.request.network.lib.artifacts

import com.request.network.lib.artifacts.Abi.{Input, Output}


case class RequestEthereumArtifactAbi(constant: Boolean,
                                   input: List[Input],
                                   name: Option[AbiName],
                                   output: List[Output],
                                   payable: Boolean,
                                   stateMutability: Option[StateMutability],
                                   abiType: AbiType) extends Abi

case class RequestEthereumArtifact(abi: List[RequestEthereumArtifactAbi], networks: Map[String, NetworkArtifact])

object RequestEthereumArtifact {

  def apply(): RequestEthereumArtifact = new RequestEthereumArtifact(abi, networks)

  val abi: List[RequestEthereumArtifactAbi] = List(
    RequestEthereumArtifactAbi(
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

  val networks: Map[String, NetworkArtifact] = Map(
    "private" -> NetworkArtifact("0xf12b5dd4ead5f743c6baa640b0216200e89b60da", 0),
    "rinkeby" -> NetworkArtifact("0x0d5D6c5aB28737C182B9e67194451c2C6BcA8623", 1435761)
  )
}
