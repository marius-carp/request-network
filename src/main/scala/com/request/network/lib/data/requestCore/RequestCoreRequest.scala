package com.request.network.lib.data.requestCore

import java.math.BigInteger
import org.web3j.tuples.generated.Tuple9

case class RequestCoreRequestData(data: String, hash: String)

case class RequestCoreRequest(
  creator: String,
  payee: String,
  payer: String,
  expectedAmount: BigInteger,
  currencyContract: String,
  balance: BigInteger,
  state: Int,
  extension: String,
  data: Option[RequestCoreRequestData]
)

object RequestCoreRequest {
  val EMPTY_BYTES_32: String = "0x0000000000000000000000000000000000000000"

  def apply(request: Tuple9[String, String, String, BigInteger, String, BigInteger, BigInteger, String, String],
            currencyContract: String,
            extension: String,
            data: Option[RequestCoreRequestData]
            ): RequestCoreRequest =

    new RequestCoreRequest(
      creator = request.getValue1,
      payee = request.getValue2,
      payer = request.getValue3,
      expectedAmount = request.getValue4,
      currencyContract = currencyContract,
      balance = request.getValue6,
      state = request.getValue7.intValue(),
      extension = extension,
      data = data
    )
}


