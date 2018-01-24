package com.request.network.lib.artifacts

import com.request.network.lib.artifacts.Abi.{Input, Output}

case class RequestCoreArtifactAbi(constant: Boolean,
                                  input: List[Input],
                                  name: Option[AbiName],
                                  output: List[Output],
                                  payable: Boolean,
                                  stateMutability: Option[StateMutability],
                                  abiType: AbiType) extends Abi

case class RequestCoreArtifact(abi: List[RequestCoreArtifactAbi], networks: Map[String, NetworkArtifact])

object RequestCoreArtifact {

  def apply(): RequestCoreArtifact = new RequestCoreArtifact(abi, networks)

  val abi: List[RequestCoreArtifactAbi] = List(
    RequestCoreArtifactAbi(
      constant = true,
      List(InputOutput(RequestIdAbiInputName, Bytes32AbiInputType)),
      Some(GetPayeeAbiName),
      List(InputOutput(BlankAbiInputName, AddressAbiInputType)),
      payable = false,
      Some(ViewStateMutability),
      FunctionAbiType)
  )

  val networks: Map[String, NetworkArtifact] = Map(
    "private" -> NetworkArtifact("0x8cdaf0cd259887258bc13a92c0a6da92698644c0", 0),
    "rinkeby" -> NetworkArtifact("0xDD7dF24DBB1188b6e1baa9E17CBfD1dB3955C223", 1402852)
  )

}
