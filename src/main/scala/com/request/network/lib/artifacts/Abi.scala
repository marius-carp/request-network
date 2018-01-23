package com.request.network.lib.artifacts

case class InputOutput(name: String, _type: String)



case class Abi(constant: Boolean, input: InputOutput, name: String, output: InputOutput)
