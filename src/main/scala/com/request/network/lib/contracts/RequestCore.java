package com.request.network.lib.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint32;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple9;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.2.0.
 */
public class RequestCore extends Contract {
    private static final String BINARY = "0x606060405260008060146101000a81548160ff021916908315150217905550341561002957600080fd5b336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600481905550612c80806100806000396000f3006060604052600436106101c1576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168062ca2f75146101c65780630410fac71461022d57806309648a9d146102665780630cf45091146102af5780630d799b8514610373578063141dfcef146103b9578063161d3abb146103ff5780632d3e653614610454578063304ebbc41461048f5780633f4ba83a146104c857806354fe2499146104dd5780635c975abb1461050d57806379455ff51461053a5780637f538fd61461056a5780638456cb59146105df578063857bcb2c146105f45780638a80faeb1461062d5780638da5cb5b146106805780638e739461146106d5578063919c90a61461071057806396b5059d146107635780639d8669851461079c5780639e3572b51461097b5780639fb42b1f146109e2578063a12cad7014610a0b578063a246a6f514610a72578063c139626b14610aab578063c4d252f514610b12578063c868154914610b39578063ca7be8af14610b8c578063e4725ba114610bd2578063f2fde38b14610bf9578063f3479fe814610c32578063f8db71b514610c62578063fcc01cce14610cb5578063ffa1ad7414610cf0575b600080fd5b34156101d157600080fd5b6101eb600480803560001916906020019091905050610d25565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561023857600080fd5b610264600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610d6d565b005b341561027157600080fd5b61028b600480803560001916906020019091905050610ee6565b6040518082600281111561029b57fe5b60ff16815260200191505060405180910390f35b610355600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803590602001909190803573ffffffffffffffffffffffffffffffffffffffff169060200190919080359060200190820180359060200191909192905050610f1b565b60405180826000191660001916815260200191505060405180910390f35b341561037e57600080fd5b6103b760048080356000191690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050611509565b005b34156103c457600080fd5b6103fd60048080356000191690602001909190803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506116d1565b005b341561040a57600080fd5b610412611818565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561045f57600080fd5b61048d600480803560001916906020019091908035906020019082018035906020019190919290505061183e565b005b341561049a57600080fd5b6104c6600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050611945565b005b34156104d357600080fd5b6104db611abe565b005b34156104e857600080fd5b61050b600480803560001916906020019091908035906020019091905050611b7c565b005b341561051857600080fd5b610520611c5d565b604051808215151515815260200191505060405180910390f35b341561054557600080fd5b610568600480803560001916906020019091908035906020019091905050611c70565b005b341561057557600080fd5b6105c9600480803590602001909190803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050611d4d565b6040518082815260200191505060405180910390f35b34156105ea57600080fd5b6105f2611e74565b005b34156105ff57600080fd5b61062b600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050611f34565b005b341561063857600080fd5b610664600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190505061204d565b604051808260ff1660ff16815260200191505060405180910390f35b341561068b57600080fd5b61069361206d565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34156106e057600080fd5b6106fa600480803560001916906020019091905050612092565b6040518082815260200191505060405180910390f35b341561071b57600080fd5b610747600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506120ba565b604051808260ff1660ff16815260200191505060405180910390f35b341561076e57600080fd5b61079a600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050612110565b005b34156107a757600080fd5b6107c1600480803560001916906020019091905050612212565b604051808a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018781526020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018581526020018460028111156108a557fe5b60ff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001806020018281038252838181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156109645780601f1061093957610100808354040283529160200191610964565b820191906000526020600020905b81548152906001019060200180831161094757829003601f168201915b50509a505050505050505050505060405180910390f35b341561098657600080fd5b6109a060048080356000191690602001909190505061230c565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34156109ed57600080fd5b6109f5612354565b6040518082815260200191505060405180910390f35b3415610a1657600080fd5b610a3060048080356000191690602001909190505061235a565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3415610a7d57600080fd5b610aa9600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506123a2565b005b3415610ab657600080fd5b610ad06004808035600019169060200190919050506124bc565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3415610b1d57600080fd5b610b37600480803560001916906020019091905050612504565b005b3415610b4457600080fd5b610b70600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506125dc565b604051808260ff1660ff16815260200191505060405180910390f35b3415610b9757600080fd5b610bd060048080356000191690602001909190803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506125fc565b005b3415610bdd57600080fd5b610bf7600480803560001916906020019091905050612743565b005b3415610c0457600080fd5b610c30600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190505061281b565b005b3415610c3d57600080fd5b610c60600480803560001916906020019091908035906020019091905050612970565b005b3415610c6d57600080fd5b610c99600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050612a4d565b604051808260ff1660ff16815260200191505060405180910390f35b3415610cc057600080fd5b610cda600480803560001916906020019091905050612aa3565b6040518082815260200191505060405180910390f35b3415610cfb57600080fd5b610d03612acb565b604051808263ffffffff1663ffffffff16815260200191505060405180910390f35b600060056000836000191660001916815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610dc857600080fd5b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff1660ff1614151515610e2757600080fd5b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff021916908360ff1602179055507f37e1aad3ab2362f3de04d0fe2369a3dd3596a8c79745fb1345df1336f07cb72881604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a150565b600060056000836000191660001916815260200190815260200160002060060160009054906101000a900460ff169050919050565b60008060149054906101000a900460ff16151515610f3857600080fd5b3360018060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff1660ff16141515610f9657600080fd5b8460008173ffffffffffffffffffffffffffffffffffffffff16148061100b57506001600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff1660ff16145b151561101657600080fd5b8960008173ffffffffffffffffffffffffffffffffffffffff161415151561103d57600080fd5b6110536001600454612ad090919063ffffffff16565b6004819055506004546001604051808381526020018263ffffffff1663ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004019250505060405180910390209350610120604051908101604052808c73ffffffffffffffffffffffffffffffffffffffff1681526020018b73ffffffffffffffffffffffffffffffffffffffff1681526020018a73ffffffffffffffffffffffffffffffffffffffff1681526020018981526020013373ffffffffffffffffffffffffffffffffffffffff168152602001600081526020016000600281111561113e57fe5b81526020018873ffffffffffffffffffffffffffffffffffffffff16815260200187878080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505081525060056000866000191660001916815260200190815260200160002060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060408201518160020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506060820151816003015560808201518160040160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060a0820151816005015560c08201518160060160006101000a81548160ff0219169083600281111561130457fe5b021790555060e08201518160060160016101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555061010082015181600701908051906020019061136d929190612b2f565b50905050600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663720d3f49348a338b6000604051602001526040518563ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808481526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200193505050506020604051808303818588803b151561147257600080fd5b6125ee5a03f1151561148357600080fd5b5050505060405180519050151561149957600080fd5b8873ffffffffffffffffffffffffffffffffffffffff168a73ffffffffffffffffffffffffffffffffffffffff1685600019167fe6d28c9f55198aba8818ea50c42929faefa033fb2984d9095b4da1e99934747860405160405180910390a4839350505050979650505050505050565b60008160008173ffffffffffffffffffffffffffffffffffffffff16148061158057506001600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff1660ff16145b151561158b57600080fd5b60056000856000191660001916815260200190815260200160002091503373ffffffffffffffffffffffffffffffffffffffff168260040160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614151561160657600080fd5b8260056000866000191660001916815260200190815260200160002060060160016101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555083600019167f374086d5e631a6f798d3727174cfbccdfc5bdd8a5d770a240dc23cb4b7da628084604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a250505050565b600060056000846000191660001916815260200190815260200160002090503373ffffffffffffffffffffffffffffffffffffffff168160040160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614151561174e57600080fd5b8160056000856000191660001916815260200190815260200160002060020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555082600019167fb993313924b36bd849fa52d0a074e373a396c05011da3e24549e065c1b2213f583604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a2505050565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600060056000856000191660001916815260200190815260200160002090503373ffffffffffffffffffffffffffffffffffffffff168160040160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415156118bb57600080fd5b828260056000876000191660001916815260200190815260200160002060070191906118e8929190612baf565b5083600019167ff28775c10f46f84af2b7fd9bfc55f99af42f604d9e14c4f39c9e7c73b08349298484604051808060200182810382528484828181526020019250808284378201915050935050505060405180910390a250505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156119a057600080fd5b6000600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff1660ff16141515156119ff57600080fd5b6000600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff021916908360ff1602179055507fdc9a204d909138de82035fe2db864cb4bd386a905d05418e46cc3c2983d5bb8b81604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a150565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611b1957600080fd5b600060149054906101000a900460ff161515611b3457600080fd5b60008060146101000a81548160ff0219169083151502179055507f7805862f689e2f13df9f062ff482ad3ad112aca9e0847911ed832e158c525b3360405160405180910390a1565b600060056000846000191660001916815260200190815260200160002090503373ffffffffffffffffffffffffffffffffffffffff168160040160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141515611bf957600080fd5b816005600085600019166000191681526020019081526020016000206003018190555082600019167fbaf58c8ec5a8e8ce319c874304238b79853ff6e9dcece29ff8a9dc8053bc544d836040518082815260200191505060405180910390a2505050565b600060149054906101000a900460ff1681565b600060056000846000191660001916815260200190815260200160002090503373ffffffffffffffffffffffffffffffffffffffff168160040160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141515611ced57600080fd5b611d04828260050154612aee90919063ffffffff16565b816005018190555082600019167ff00660db1da02eadf1e0e71eb1d8c7b2d5205745aa3be7f89ade9a48884157f5836040518082815260200191505060405180910390a2505050565b6000600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166349ede0ca8585856000604051602001526040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808481526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019350505050602060405180830381600087803b1515611e5057600080fd5b6102c65a03f11515611e6157600080fd5b5050506040518051905090509392505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611ecf57600080fd5b600060149054906101000a900460ff16151515611eeb57600080fd5b6001600060146101000a81548160ff0219169083151502179055507f6985a02210a168e66602d3235cb6db0e70f92b3ba4d376a33c0f3d9434bff62560405160405180910390a1565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611f8f57600080fd5b60018060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff021916908360ff1602179055507f26644c0325b712ffff764a64a71985fb39d46406ffb32dd76c3ca00c56136a5781604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a150565b60016020528060005260406000206000915054906101000a900460ff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000600560008360001916600019168152602001908152602001600020600501549050919050565b6000600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff169050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561216b57600080fd5b80600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055507f948381ee40839db1c971aa81c1d539a1f8f5f01b0d857bf1a321e9ae5038261a81604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a150565b60056020528060005260406000206000915090508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060030154908060040160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060050154908060060160009054906101000a900460ff16908060060160019054906101000a900473ffffffffffffffffffffffffffffffffffffffff169080600701905089565b600060056000836000191660001916815260200190815260200160002060040160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b60045481565b600060056000836000191660001916815260200190815260200160002060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156123fd57600080fd5b6001600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff021916908360ff1602179055507ff86a6607d50e3e49c32332972e579f045ace5af1902162e45ac1802ccc006ff981604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a150565b600060056000836000191660001916815260200190815260200160002060060160019054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b600060056000836000191660001916815260200190815260200160002090503373ffffffffffffffffffffffffffffffffffffffff168160040160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614151561258157600080fd5b60028160060160006101000a81548160ff021916908360028111156125a257fe5b021790555081600019167f134fdd648feeaf30251f0157f9624ef8608ff9a042aad6d13e73f35d21d3f88d60405160405180910390a25050565b60026020528060005260406000206000915054906101000a900460ff1681565b600060056000846000191660001916815260200190815260200160002090503373ffffffffffffffffffffffffffffffffffffffff168160040160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614151561267957600080fd5b8160056000856000191660001916815260200190815260200160002060010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555082600019167f7ab45e5f9954c3a9c811a8ce60096ad2c9fcf5d574145fb241de6ecee960164683604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a2505050565b600060056000836000191660001916815260200190815260200160002090503373ffffffffffffffffffffffffffffffffffffffff168160040160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415156127c057600080fd5b60018160060160006101000a81548160ff021916908360028111156127e157fe5b021790555081600019167f1f3c0697c3ada95f9e84a917995664b76cd8b4ae5de25e77ee111122ae3a00d060405160405180910390a25050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561287657600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16141515156128b257600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b600060056000846000191660001916815260200190815260200160002090503373ffffffffffffffffffffffffffffffffffffffff168160040160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415156129ed57600080fd5b612a04828260030154612aee90919063ffffffff16565b816003018190555082600019167f1718f2b0fe4312f030ebc92a188add3d89c73d19d346c00fff5f03b79846a460836040518082815260200191505060405180910390a2505050565b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff169050919050565b6000600560008360001916600019168152602001908152602001600020600301549050919050565b600181565b6000808284019050838110151515612ae457fe5b8091505092915050565b600080828401905060008312158015612b075750838112155b80612b1d5750600083128015612b1c57508381125b5b1515612b2557fe5b8091505092915050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10612b7057805160ff1916838001178555612b9e565b82800160010185558215612b9e579182015b82811115612b9d578251825591602001919060010190612b82565b5b509050612bab9190612c2f565b5090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10612bf057803560ff1916838001178555612c1e565b82800160010185558215612c1e579182015b82811115612c1d578235825591602001919060010190612c02565b5b509050612c2b9190612c2f565b5090565b612c5191905b80821115612c4d576000816000905550600101612c35565b5090565b905600a165627a7a7230582055f7dc5fb1d77be03f1a46ffd89190569f34fa5dd7bcee61c05a5f8b66a80b800029";

    protected RequestCore(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected RequestCore(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<CreatedEventResponse> getCreatedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Created", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<CreatedEventResponse> responses = new ArrayList<CreatedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            CreatedEventResponse typedResponse = new CreatedEventResponse();
            typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.payee = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.payer = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<CreatedEventResponse> createdEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Created", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, CreatedEventResponse>() {
            @Override
            public CreatedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                CreatedEventResponse typedResponse = new CreatedEventResponse();
                typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.payee = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.payer = (String) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public List<AcceptedEventResponse> getAcceptedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Accepted", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<AcceptedEventResponse> responses = new ArrayList<AcceptedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            AcceptedEventResponse typedResponse = new AcceptedEventResponse();
            typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<AcceptedEventResponse> acceptedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Accepted", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, AcceptedEventResponse>() {
            @Override
            public AcceptedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                AcceptedEventResponse typedResponse = new AcceptedEventResponse();
                typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<CanceledEventResponse> getCanceledEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Canceled", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<CanceledEventResponse> responses = new ArrayList<CanceledEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            CanceledEventResponse typedResponse = new CanceledEventResponse();
            typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<CanceledEventResponse> canceledEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Canceled", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, CanceledEventResponse>() {
            @Override
            public CanceledEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                CanceledEventResponse typedResponse = new CanceledEventResponse();
                typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<UpdateBalanceEventResponse> getUpdateBalanceEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("UpdateBalance", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<UpdateBalanceEventResponse> responses = new ArrayList<UpdateBalanceEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            UpdateBalanceEventResponse typedResponse = new UpdateBalanceEventResponse();
            typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.deltaAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<UpdateBalanceEventResponse> updateBalanceEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("UpdateBalance", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, UpdateBalanceEventResponse>() {
            @Override
            public UpdateBalanceEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                UpdateBalanceEventResponse typedResponse = new UpdateBalanceEventResponse();
                typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.deltaAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<UpdateExpectedAmountEventResponse> getUpdateExpectedAmountEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("UpdateExpectedAmount", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<UpdateExpectedAmountEventResponse> responses = new ArrayList<UpdateExpectedAmountEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            UpdateExpectedAmountEventResponse typedResponse = new UpdateExpectedAmountEventResponse();
            typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.deltaAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<UpdateExpectedAmountEventResponse> updateExpectedAmountEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("UpdateExpectedAmount", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, UpdateExpectedAmountEventResponse>() {
            @Override
            public UpdateExpectedAmountEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                UpdateExpectedAmountEventResponse typedResponse = new UpdateExpectedAmountEventResponse();
                typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.deltaAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<NewPayeeEventResponse> getNewPayeeEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("NewPayee", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<NewPayeeEventResponse> responses = new ArrayList<NewPayeeEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            NewPayeeEventResponse typedResponse = new NewPayeeEventResponse();
            typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.payee = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<NewPayeeEventResponse> newPayeeEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("NewPayee", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, NewPayeeEventResponse>() {
            @Override
            public NewPayeeEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                NewPayeeEventResponse typedResponse = new NewPayeeEventResponse();
                typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.payee = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<NewPayerEventResponse> getNewPayerEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("NewPayer", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<NewPayerEventResponse> responses = new ArrayList<NewPayerEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            NewPayerEventResponse typedResponse = new NewPayerEventResponse();
            typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.payer = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<NewPayerEventResponse> newPayerEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("NewPayer", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, NewPayerEventResponse>() {
            @Override
            public NewPayerEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                NewPayerEventResponse typedResponse = new NewPayerEventResponse();
                typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.payer = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<NewExpectedAmountEventResponse> getNewExpectedAmountEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("NewExpectedAmount", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<NewExpectedAmountEventResponse> responses = new ArrayList<NewExpectedAmountEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            NewExpectedAmountEventResponse typedResponse = new NewExpectedAmountEventResponse();
            typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.expectedAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<NewExpectedAmountEventResponse> newExpectedAmountEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("NewExpectedAmount", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, NewExpectedAmountEventResponse>() {
            @Override
            public NewExpectedAmountEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                NewExpectedAmountEventResponse typedResponse = new NewExpectedAmountEventResponse();
                typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.expectedAmount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<NewExtensionEventResponse> getNewExtensionEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("NewExtension", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<NewExtensionEventResponse> responses = new ArrayList<NewExtensionEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            NewExtensionEventResponse typedResponse = new NewExtensionEventResponse();
            typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.extension = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<NewExtensionEventResponse> newExtensionEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("NewExtension", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, NewExtensionEventResponse>() {
            @Override
            public NewExtensionEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                NewExtensionEventResponse typedResponse = new NewExtensionEventResponse();
                typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.extension = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<NewDataEventResponse> getNewDataEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("NewData", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<NewDataEventResponse> responses = new ArrayList<NewDataEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            NewDataEventResponse typedResponse = new NewDataEventResponse();
            typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.data = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<NewDataEventResponse> newDataEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("NewData", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, NewDataEventResponse>() {
            @Override
            public NewDataEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                NewDataEventResponse typedResponse = new NewDataEventResponse();
                typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.data = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<NewTrustedContractEventResponse> getNewTrustedContractEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("NewTrustedContract", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<NewTrustedContractEventResponse> responses = new ArrayList<NewTrustedContractEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            NewTrustedContractEventResponse typedResponse = new NewTrustedContractEventResponse();
            typedResponse.newContract = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<NewTrustedContractEventResponse> newTrustedContractEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("NewTrustedContract", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, NewTrustedContractEventResponse>() {
            @Override
            public NewTrustedContractEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                NewTrustedContractEventResponse typedResponse = new NewTrustedContractEventResponse();
                typedResponse.newContract = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<RemoveTrustedContractEventResponse> getRemoveTrustedContractEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("RemoveTrustedContract", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<RemoveTrustedContractEventResponse> responses = new ArrayList<RemoveTrustedContractEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            RemoveTrustedContractEventResponse typedResponse = new RemoveTrustedContractEventResponse();
            typedResponse.oldContract = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<RemoveTrustedContractEventResponse> removeTrustedContractEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("RemoveTrustedContract", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, RemoveTrustedContractEventResponse>() {
            @Override
            public RemoveTrustedContractEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                RemoveTrustedContractEventResponse typedResponse = new RemoveTrustedContractEventResponse();
                typedResponse.oldContract = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<NewTrustedExtensionEventResponse> getNewTrustedExtensionEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("NewTrustedExtension", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<NewTrustedExtensionEventResponse> responses = new ArrayList<NewTrustedExtensionEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            NewTrustedExtensionEventResponse typedResponse = new NewTrustedExtensionEventResponse();
            typedResponse.newExtension = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<NewTrustedExtensionEventResponse> newTrustedExtensionEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("NewTrustedExtension", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, NewTrustedExtensionEventResponse>() {
            @Override
            public NewTrustedExtensionEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                NewTrustedExtensionEventResponse typedResponse = new NewTrustedExtensionEventResponse();
                typedResponse.newExtension = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<RemoveTrustedExtensionEventResponse> getRemoveTrustedExtensionEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("RemoveTrustedExtension", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<RemoveTrustedExtensionEventResponse> responses = new ArrayList<RemoveTrustedExtensionEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            RemoveTrustedExtensionEventResponse typedResponse = new RemoveTrustedExtensionEventResponse();
            typedResponse.oldExtension = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<RemoveTrustedExtensionEventResponse> removeTrustedExtensionEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("RemoveTrustedExtension", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, RemoveTrustedExtensionEventResponse>() {
            @Override
            public RemoveTrustedExtensionEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                RemoveTrustedExtensionEventResponse typedResponse = new RemoveTrustedExtensionEventResponse();
                typedResponse.oldExtension = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<NewBurnManagerEventResponse> getNewBurnManagerEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("NewBurnManager", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<NewBurnManagerEventResponse> responses = new ArrayList<NewBurnManagerEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            NewBurnManagerEventResponse typedResponse = new NewBurnManagerEventResponse();
            typedResponse.newFeesManager = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<NewBurnManagerEventResponse> newBurnManagerEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("NewBurnManager", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, NewBurnManagerEventResponse>() {
            @Override
            public NewBurnManagerEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                NewBurnManagerEventResponse typedResponse = new NewBurnManagerEventResponse();
                typedResponse.newFeesManager = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<PauseEventResponse> getPauseEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Pause", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<PauseEventResponse> responses = new ArrayList<PauseEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            PauseEventResponse typedResponse = new PauseEventResponse();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<PauseEventResponse> pauseEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Pause", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, PauseEventResponse>() {
            @Override
            public PauseEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                PauseEventResponse typedResponse = new PauseEventResponse();
                return typedResponse;
            }
        });
    }

    public List<UnpauseEventResponse> getUnpauseEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Unpause", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<UnpauseEventResponse> responses = new ArrayList<UnpauseEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            UnpauseEventResponse typedResponse = new UnpauseEventResponse();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<UnpauseEventResponse> unpauseEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Unpause", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, UnpauseEventResponse>() {
            @Override
            public UnpauseEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                UnpauseEventResponse typedResponse = new UnpauseEventResponse();
                return typedResponse;
            }
        });
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("OwnershipTransferred", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OwnershipTransferredEventResponse> ownershipTransferredEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("OwnershipTransferred", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<String> getPayee(byte[] _requestId) {
        Function function = new Function("getPayee", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> adminRemoveTrustedCurrencyContract(String _oldTrustedContractAddress) {
        Function function = new Function(
                "adminRemoveTrustedCurrencyContract", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_oldTrustedContractAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getState(byte[] _requestId) {
        Function function = new Function("getState", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> createRequest(String _creator, String _payee, String _payer, BigInteger _expectedAmount, String _extension, String _data, BigInteger weiValue) {
        Function function = new Function(
                "createRequest", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_creator), 
                new org.web3j.abi.datatypes.Address(_payee), 
                new org.web3j.abi.datatypes.Address(_payer), 
                new org.web3j.abi.datatypes.generated.Int256(_expectedAmount), 
                new org.web3j.abi.datatypes.Address(_extension), 
                new org.web3j.abi.datatypes.Utf8String(_data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> setExtension(byte[] _requestId, String _extension) {
        Function function = new Function(
                "setExtension", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId), 
                new org.web3j.abi.datatypes.Address(_extension)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setPayer(byte[] _requestId, String _payer) {
        Function function = new Function(
                "setPayer", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId), 
                new org.web3j.abi.datatypes.Address(_payer)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> trustedNewBurnManager() {
        Function function = new Function("trustedNewBurnManager", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setData(byte[] _requestId, String _data) {
        Function function = new Function(
                "setData", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId), 
                new org.web3j.abi.datatypes.Utf8String(_data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> adminRemoveExtension(String _oldExtension) {
        Function function = new Function(
                "adminRemoveExtension", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_oldExtension)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> unpause() {
        Function function = new Function(
                "unpause", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setExpectedAmount(byte[] _requestId, BigInteger _expectedAmount) {
        Function function = new Function(
                "setExpectedAmount", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId), 
                new org.web3j.abi.datatypes.generated.Int256(_expectedAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> paused() {
        Function function = new Function("paused", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> updateBalance(byte[] _requestId, BigInteger _deltaAmount) {
        Function function = new Function(
                "updateBalance", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId), 
                new org.web3j.abi.datatypes.generated.Int256(_deltaAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getCollectEstimation(BigInteger _expectedAmount, String _currencyContract, String _extension) {
        Function function = new Function("getCollectEstimation", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(_expectedAmount), 
                new org.web3j.abi.datatypes.Address(_currencyContract), 
                new org.web3j.abi.datatypes.Address(_extension)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> pause() {
        Function function = new Function(
                "pause", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> adminAddTrustedCurrencyContract(String _newContractAddress) {
        Function function = new Function(
                "adminAddTrustedCurrencyContract", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newContractAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> trustedCurrencyContracts(String param0) {
        Function function = new Function("trustedCurrencyContracts", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> owner() {
        Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> getBalance(byte[] _requestId) {
        Function function = new Function("getBalance", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getStatusExtension(String _extension) {
        Function function = new Function("getStatusExtension", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_extension)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setBurnManager(String _newBurnManager) {
        Function function = new Function(
                "setBurnManager", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newBurnManager)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple9<String, String, String, BigInteger, String, BigInteger, BigInteger, String, String>> requests(byte[] param0) {
        final Function function = new Function("requests", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Int256>() {}, new TypeReference<Address>() {}, new TypeReference<Int256>() {}, new TypeReference<Uint8>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple9<String, String, String, BigInteger, String, BigInteger, BigInteger, String, String>>(
                new Callable<Tuple9<String, String, String, BigInteger, String, BigInteger, BigInteger, String, String>>() {
                    @Override
                    public Tuple9<String, String, String, BigInteger, String, BigInteger, BigInteger, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple9<String, String, String, BigInteger, String, BigInteger, BigInteger, String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue(), 
                                (String) results.get(7).getValue(), 
                                (String) results.get(8).getValue());
                    }
                });
    }

    public RemoteCall<String> getCurrencyContract(byte[] _requestId) {
        Function function = new Function("getCurrencyContract", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> numRequests() {
        Function function = new Function("numRequests", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> getPayer(byte[] _requestId) {
        Function function = new Function("getPayer", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> adminAddTrustedExtension(String _newExtension) {
        Function function = new Function(
                "adminAddTrustedExtension", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newExtension)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getExtension(byte[] _requestId) {
        Function function = new Function("getExtension", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> cancel(byte[] _requestId) {
        Function function = new Function(
                "cancel", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> trustedExtensions(String param0) {
        Function function = new Function("trustedExtensions", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setPayee(byte[] _requestId, String _payee) {
        Function function = new Function(
                "setPayee", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId), 
                new org.web3j.abi.datatypes.Address(_payee)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> accept(byte[] _requestId) {
        Function function = new Function(
                "accept", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        Function function = new Function(
                "transferOwnership", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> updateExpectedAmount(byte[] _requestId, BigInteger _deltaAmount) {
        Function function = new Function(
                "updateExpectedAmount", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId), 
                new org.web3j.abi.datatypes.generated.Int256(_deltaAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getStatusContract(String _contractAddress) {
        Function function = new Function("getStatusContract", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_contractAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getExpectedAmount(byte[] _requestId) {
        Function function = new Function("getExpectedAmount", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> VERSION() {
        Function function = new Function("VERSION", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<RequestCore> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RequestCore.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<RequestCore> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RequestCore.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static RequestCore load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RequestCore(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static RequestCore load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RequestCore(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class CreatedEventResponse {
        public byte[] requestId;

        public String payee;

        public String payer;
    }

    public static class AcceptedEventResponse {
        public byte[] requestId;
    }

    public static class CanceledEventResponse {
        public byte[] requestId;
    }

    public static class UpdateBalanceEventResponse {
        public byte[] requestId;

        public BigInteger deltaAmount;
    }

    public static class UpdateExpectedAmountEventResponse {
        public byte[] requestId;

        public BigInteger deltaAmount;
    }

    public static class NewPayeeEventResponse {
        public byte[] requestId;

        public String payee;
    }

    public static class NewPayerEventResponse {
        public byte[] requestId;

        public String payer;
    }

    public static class NewExpectedAmountEventResponse {
        public byte[] requestId;

        public BigInteger expectedAmount;
    }

    public static class NewExtensionEventResponse {
        public byte[] requestId;

        public String extension;
    }

    public static class NewDataEventResponse {
        public byte[] requestId;

        public String data;
    }

    public static class NewTrustedContractEventResponse {
        public String newContract;
    }

    public static class RemoveTrustedContractEventResponse {
        public String oldContract;
    }

    public static class NewTrustedExtensionEventResponse {
        public String newExtension;
    }

    public static class RemoveTrustedExtensionEventResponse {
        public String oldExtension;
    }

    public static class NewBurnManagerEventResponse {
        public String newFeesManager;
    }

    public static class PauseEventResponse {
    }

    public static class UnpauseEventResponse {
    }

    public static class OwnershipTransferredEventResponse {
        public String previousOwner;

        public String newOwner;
    }
}
