package com.request.network.lib.artifacts

import com.kifi.macros.jsonstrict

@jsonstrict
case class NetworkArtifact(address: String, blockNumber: Long)
