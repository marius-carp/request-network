package com.request.network.lib.artifacts

import com.request.network.lib.artifacts.Abi.{Input, Output}

case class InputOutput(name: AbiInputName, _type: AbiInputType)

trait AbiInputName

case object BlankAbiInputName extends AbiInputName {override def toString: String = "" }

case object AdditionalsAbiInputName extends AbiInputName { override def toString: String = "additionals"}
case object AmountAmountAbiInputName extends AbiInputName { override def toString: String = "amount"}
case object CurrencyContractParamsAmountAbiInputName extends AbiInputName { override def toString: String = "currencyContract"}
case object DataParamsAmountAbiInputName extends AbiInputName { override def toString: String = "data"}
case object ExpectedAmountAbiInputName extends AbiInputName { override def toString: String = "expectedAmount"}
case object ExtensionAmountAbiInputName extends AbiInputName { override def toString: String = "extension"}
case object ExtensionParamsAmountAbiInputName extends AbiInputName { override def toString: String = "extensionParams"}
case object NewRateAbiInputName extends AbiInputName { override def toString: String = "newRate"}
case object NewMaxAbiInputName extends AbiInputName { override def toString: String = "newMax"}
case object NewOwnerAbiInputName extends AbiInputName { override def toString: String = "newOwner"}
case object PayerAbiInputName extends AbiInputName { override def toString: String = "payer"}
case object PreviousOwnerAbiInputName extends AbiInputName { override def toString: String = "previousOwner"}
case object RequestIdAbiInputName extends AbiInputName { override def toString: String = "requestId"}
case object RecipientAbiInputName extends AbiInputName { override def toString: String = "recipient"}
case object ReqBurnerContractAbiInputName extends AbiInputName { override def toString: String = "reqBurnerContract"}


case object BalanceAbiInputName extends AbiInputName { override def toString: String = "balance"}
case object CreatorAbiInputName extends AbiInputName { override def toString: String = "creator"}
case object CurrencyContractAbiInputName extends AbiInputName { override def toString: String = "currencyContract"}
case object ContractAddressAbiInputName extends AbiInputName { override def toString: String = "contractAddress"}
case object DataAbiInputName extends AbiInputName { override def toString: String = "data"}
case object DeltaAmountAbiInputName extends AbiInputName { override def toString: String = "deltaAmount"}
case object ExtensionAbiInputName extends AbiInputName { override def toString: String = "extension"}
case object NewContractAddressAbiInputName extends AbiInputName { override def toString: String = "newContractAddress"}
case object NewBurnManagerAbiInputName extends AbiInputName { override def toString: String = "newBurnManager"}
case object NewExtensionAbiInputName extends AbiInputName { override def toString: String = "newExtension"}
case object NewContractAbiInputName extends AbiInputName { override def toString: String = "newContract"}
case object NewFeesManagerAbiInputName extends AbiInputName { override def toString: String = "newFeesManager"}
case object OldTrustedContractAddressAbiInputName extends AbiInputName { override def toString: String = "oldTrustedContractAddress"}
case object OldExtensionAbiInputName extends AbiInputName { override def toString: String = "oldExtension"}
case object oldContractAbiInputName extends AbiInputName { override def toString: String = "oldContract"}
case object PayeeAbiInputName extends AbiInputName { override def toString: String = "payee"}
case object StateAbiInputName extends AbiInputName { override def toString: String = "state"}


case object HashAbiInputName extends AbiInputName { override def toString: String = "hash"}
case object SignerAbiInputName extends AbiInputName { override def toString: String = "signer"}
case object RAbiInputName extends AbiInputName { override def toString: String = "r"}
case object SAbiInputName extends AbiInputName { override def toString: String = "s"}
case object VAbiInputName extends AbiInputName { override def toString: String = "v"}


case object EscrowAbiInputName extends AbiInputName { override def toString: String = "escrow"}
case object RequestCoreAddressAbiInputName extends AbiInputName { override def toString: String = "requestCoreAddress"}

trait AbiInputType
case object AddressAbiInputType extends AbiInputType { override def toString: String = "address"}
case object Bytes32AbiInputType extends AbiInputType { override def toString: String = "bytes32"}
case object BoolAbiInputType extends AbiInputType { override def toString: String = "bool"}
case object Int256AbiInputType extends AbiInputType { override def toString: String = "int256"}
case object Uint8AbiInputType extends AbiInputType { override def toString: String = "uint8"}
case object Uint256AbiInputType extends AbiInputType { override def toString: String = "uint256"}


trait AbiName
case object CollectEstimationAbiName extends AbiName { override def toString: String = "collectEstimation"}
case object CollectForReqBurningAbiName extends AbiName { override def toString: String = "collectForReqBurning"}
case object FeesPer10000AbiName extends AbiName { override def toString: String = "feesPer10000"}
case object MaxFeesAbiName extends AbiName { override def toString: String = "maxFees"}
case object OwnerAbiName extends AbiName { override def toString: String = "OwnershipTransferred"}
case object OwnershipTransferredAbiName extends AbiName { override def toString: String = "owner"}
case object PausedAbiName extends AbiName { override def toString: String = "paused"}
case object ReqBurnerContractAbiName extends AbiName { override def toString: String = "reqBurnerContract"}
case object SetReqBurnerContractAbiName extends AbiName { override def toString: String = "setReqBurnerContract"}
case object SetFeesPerTenThousandAbiName extends AbiName { override def toString: String = "setFeesPerTenThousand"}
case object SetMaxCollectableAbiName extends AbiName { override def toString: String = "setMaxCollectable"}
case object TransferOwnershipAbiName extends AbiName { override def toString: String = "transferOwnership"}
case object UnpauseAbiName extends AbiName { override def toString: String = "Unpause"}

case object AcceptAbiName extends AbiName { override def toString: String = "accept"}
case object AcceptedAbiName extends AbiName { override def toString: String = "Accepted"}
case object AdminRemoveTrustedCurrencyContractAbiName extends AbiName { override def toString: String = "adminRemoveTrustedCurrencyContract"}
case object AdminAddTrustedExtensionAbiName extends AbiName { override def toString: String = "adminAddTrustedExtension"}
case object AdminRemoveExtensionAbiName extends AbiName { override def toString: String = "adminRemoveExtension"}
case object AdminAddTrustedCurrencyContractAbiName extends AbiName { override def toString: String = "adminAddTrustedCurrencyContract"}
case object CreateRequestAbiName extends AbiName { override def toString: String = "createRequest"}
case object CreatedAbiName extends AbiName { override def toString: String = "Created"}
case object CancelAbiName extends AbiName { override def toString: String = "cancel"}
case object CanceledAbiName extends AbiName { override def toString: String = "Canceled"}
case object GetPayeeAbiName extends AbiName { override def toString: String = "getPayee"}
case object GetPayerAbiName extends AbiName { override def toString: String = "getPayer"}
case object GetStateAbiName extends AbiName { override def toString: String = "getState"}
case object GetExtensionAbiName extends AbiName { override def toString: String = "getExtension"}
case object GetCollectEstimationAbiName extends AbiName { override def toString: String = "getCollectEstimation"}
case object GetBalanceAbiName extends AbiName { override def toString: String = "getBalance"}
case object GetStatusExtensionAbiName extends AbiName { override def toString: String = "getStatusExtension"}
case object GetCurrencyContractAbiName extends AbiName { override def toString: String = "getCurrencyContract"}
case object GetStatusContractAbiName extends AbiName { override def toString: String = "getStatusContract"}
case object GetExpectedAmountAbiName extends AbiName { override def toString: String = "getExpectedAmount"}
case object NumRequestsAbiName extends AbiName { override def toString: String = "numRequests"}
case object NewPayerAbiName extends AbiName { override def toString: String = "NewPayer"}
case object NewExpectedAmountAbiName extends AbiName { override def toString: String = "NewExpectedAmount"}
case object NewExtensionAbiName extends AbiName { override def toString: String = "NewExtension"}
case object NewDataAbiName extends AbiName { override def toString: String = "NewData"}
case object NewTrustedContractAbiName extends AbiName { override def toString: String = "NewTrustedContract"}
case object NewTrustedExtensionAbiName extends AbiName { override def toString: String = "NewTrustedExtension"}
case object NewBurnManagerAbiName extends AbiName { override def toString: String = "NewBurnManager"}
case object RequestsAbiName extends AbiName { override def toString: String = "requests"}
case object RemoveTrustedContractAbiName extends AbiName { override def toString: String = "RemoveTrustedContract"}
case object RemoveTrustedExtensionAbiName extends AbiName { override def toString: String = "RemoveTrustedExtension"}
case object SetExtensionAbiName extends AbiName { override def toString: String = "setExtension"}
case object SetPayerAbiName extends AbiName { override def toString: String = "setPayer"}
case object SetPayeeAbiName extends AbiName { override def toString: String = "setPayee"}
case object SetDataAbiName extends AbiName { override def toString: String = "setData"}
case object SetExpectedAmountAbiName extends AbiName { override def toString: String = "setExpectedAmount"}
case object SetBurnManagerAbiName extends AbiName { override def toString: String = "setBurnManager"}
case object TrustedNewBurnManagerAbiName extends AbiName { override def toString: String = "trustedNewBurnManager"}
case object TrustedCurrencyContractsAbiName extends AbiName { override def toString: String = "trustedCurrencyContracts"}
case object TrustedExtensionsAbiName extends AbiName { override def toString: String = "trustedExtensions"}
case object UpdateBalanceAbiName extends AbiName { override def toString: String = "updateBalance"}
case object UpdateExpectedAmountAbiName extends AbiName { override def toString: String = "updateExpectedAmount"}
case object VersionAbiName extends AbiName { override def toString: String = "VERSION"}


case object AdditionalActionAbiName extends AbiName { override def toString: String = "additionalAction"}
case object CreateRequestAsPayeeAbiName extends AbiName { override def toString: String = "createRequestAsPayee"}
case object CreateRequestAsPayerAbiName extends AbiName { override def toString: String = "createRequestAsPayer"}
case object CheckRequestSignatureAbiName extends AbiName { override def toString: String = "checkRequestSignature"}
case object EthToWithdrawAbiName extends AbiName { override def toString: String = "ethToWithdraw"}
case object EtherAvailableToWithdrawAbiName extends AbiName { override def toString: String = "EtherAvailableToWithdraw"}
case object FundOrderAbiName extends AbiName { override def toString: String = "fundOrder"}
case object IsValidSignatureAbiName extends AbiName { override def toString: String = "isValidSignature"}
case object PaymentActionAbiName extends AbiName { override def toString: String = "paymentAction"}
case object PaymentAbiName extends AbiName { override def toString: String = "payment"}
case object RequestCoreAbiName extends AbiName { override def toString: String = "requestCore"}
case object RefundActionAbiName extends AbiName { override def toString: String = "refundAction"}
case object SubtractActionAbiName extends AbiName { override def toString: String = "subtractAction"}
case object WithdrawAbiName extends AbiName { override def toString: String = "withdraw"}

case object EscrowsAbiName extends AbiName { override def toString: String = "escrows"}
case object EscrowPaymentAbiName extends AbiName { override def toString: String = "EscrowPayment"}
case object EscrowReleaseRequestAbiName extends AbiName { override def toString: String = "EscrowReleaseRequest"}
case object EscrowRefundRequestAbiName extends AbiName { override def toString: String = "EscrowRefundRequest"}
case object ReleaseToPayeeActionAbiName extends AbiName { override def toString: String = "releaseToPayeeAction"}
case object RefundAbiName extends AbiName { override def toString: String = "refund"}
case object ReleaseToPayerActionAbiName extends AbiName { override def toString: String = "releaseToPayerAction"}

trait StateMutability
case object PayableStateMutability extends StateMutability
case object NonPayableStateMutability extends StateMutability
case object ViewStateMutability extends StateMutability

trait AbiType
case object FunctionAbiType extends AbiType
case object EventAbiType extends AbiType

trait Abi {
  val constant: Boolean
  val input: List[Input]
  val name: Option[AbiName]
  val output: List[Output]
  val payable: Boolean
  val stateMutability: StateMutability
  val abiType: AbiType
}

object Abi {
  type Output = InputOutput
  type Input = InputOutput
}


/*
case object PaymentAction extends Abi {
  val constant: Boolean
  val input: InputOutput
  val name: String
  val output: InputOutput
}*/
