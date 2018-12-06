package test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.bcos.channel.client.TransactionSucCallback;
import org.bcos.web3j.abi.EventEncoder;
import org.bcos.web3j.abi.EventValues;
import org.bcos.web3j.abi.TypeReference;
import org.bcos.web3j.abi.datatypes.Address;
import org.bcos.web3j.abi.datatypes.Bool;
import org.bcos.web3j.abi.datatypes.DynamicArray;
import org.bcos.web3j.abi.datatypes.Event;
import org.bcos.web3j.abi.datatypes.Function;
import org.bcos.web3j.abi.datatypes.StaticArray;
import org.bcos.web3j.abi.datatypes.Type;
import org.bcos.web3j.abi.datatypes.Utf8String;
import org.bcos.web3j.abi.datatypes.generated.Bytes32;
import org.bcos.web3j.abi.datatypes.generated.Uint256;
import org.bcos.web3j.crypto.Credentials;
import org.bcos.web3j.protocol.Web3j;
import org.bcos.web3j.protocol.core.DefaultBlockParameter;
import org.bcos.web3j.protocol.core.methods.request.EthFilter;
import org.bcos.web3j.protocol.core.methods.response.Log;
import org.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.bcos.web3j.tx.Contract;
import org.bcos.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>, or {@link org.bcos.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version none.
 */
public final class Register extends Contract {
    private static String BINARY = "6060604052341561000c57fe5b5b6128768061001c6000396000f30060606040523615610097576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063412e11e7146100995780635434ca9c146102195780635d2a7637146102d657806394d3158514610324578063a19337af146103b9578063a6a502121461042f578063c59a12e51461047d578063e68f5e0c14610512578063f459f5a214610588575bfe5b34156100a157fe5b6101ff6004808060800190600480602002604051908101604052809291908260046020028082843782019150505050509190803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505091908035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919050506105f5565b604051808215151515815260200191505060405180910390f35b341561022157fe5b6102bc600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff169060200190919080359060200190820180359060200191909192908035906020019082018035906020019190919290803590602001908201803590602001919091929080359060200190820180359060200191909192905050610b23565b604051808215151515815260200191505060405180910390f35b34156102de57fe5b61030a600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050611120565b604051808215151515815260200191505060405180910390f35b341561032c57fe5b61039f600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091908035906020019082018035906020019190919290803590602001908201803590602001919091929050506111bb565b604051808215151515815260200191505060405180910390f35b34156103c157fe5b610415600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803590602001908201803590602001919091929080359060200190820180359060200191909192905050611561565b604051808215151515815260200191505060405180910390f35b341561043757fe5b610463600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506119e0565b604051808215151515815260200191505060405180910390f35b341561048557fe5b6104f8600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803590602001908201803590602001919091929080359060200190820180359060200191909192905050611a7b565b604051808215151515815260200191505060405180910390f35b341561051a57fe5b61056e600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919080359060200190820180359060200191909192908035906020019082018035906020019190919290505061200d565b604051808215151515815260200191505060405180910390f35b341561059057fe5b6105db600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff1690602001909190505061244a565b604051808215151515815260200191505060405180910390f35b60008573ffffffffffffffffffffffffffffffffffffffff166108a988600060048110151561062057fe5b602002015189600160048110151561063457fe5b60200201518a600260048110151561064857fe5b60200201518b600360048110151561065c57fe5b60200201518b8b8b8a604051808973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c0100000000000000000000000002815260140184805190602001908083835b602083106107dd57805182526020820191506020810190506020830392506107ba565b6001836020036101000a03801982511681845116808217855250505050505090500183805190602001908083835b6020831061082e578051825260208201915060208101905060208303925061080b565b6001836020036101000a03801982511681845116808217855250505050505090500182805190602001906020028083836000831461088b575b80518252602083111561088b57602082019150602081019050602083039250610867565b50505090500198505050505050505050604051809103902085612526565b73ffffffffffffffffffffffffffffffffffffffff16141515610978577fd7fedc4e21c1e8c868c39947f237cbc93d69fb546f4f30807d089ce2903e913c336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807fe69caae9809ae8bf87e7adbee5908de8aea4e8af810000000000000000000000815250602001935050505060405180910390a160009050610b19565b6109b382600081518110151561098a57fe5b906020019060200201518360018151811015156109a357fe5b90602001906020020151886126b9565b1515610a6b577fd7fedc4e21c1e8c868c39947f237cbc93d69fb546f4f30807d089ce2903e913c336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe9878de5a48de8afb7e6b1820000000000000000000000000000000000000000815250602001935050505060405180910390a160009050610b19565b7fd7fedc4e21c1e8c868c39947f237cbc93d69fb546f4f30807d089ce2903e913c336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260068152602001807fe9809ae8bf870000000000000000000000000000000000000000000000000000815250602001935050505060405180910390a1600190505b9695505050505050565b6000600060008b73ffffffffffffffffffffffffffffffffffffffff16610b988686604051808383602002808284378201915050925050506040518091039020898980806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050612526565b73ffffffffffffffffffffffffffffffffffffffff16141515610c67577f87098308100b9295fda0e232be65e65af3ad95b4787d64dabc48e6c371bf6b0c336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807fe69caae9809ae8bf87e7adbee5908de8aea4e8af810000000000000000000000815250602001935050505060405180910390a160009250611110565b610c9c858560008181101515610c7957fe5b90506020020135868660018181101515610c8f57fe5b905060200201358e6126b9565b1515610d54577f87098308100b9295fda0e232be65e65af3ad95b4787d64dabc48e6c371bf6b0c336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe9878de5a48de8afb7e6b1820000000000000000000000000000000000000000815250602001935050505060405180910390a160009250611110565b600160008e73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209150600073ffffffffffffffffffffffffffffffffffffffff168260000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610ea0577f87098308100b9295fda0e232be65e65af3ad95b4787d64dabc48e6c371bf6b0c336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807fe697a0e5b7b2e6b3a8e5868ce79a84e5b9b3e58fb00000000000000000000000815250602001935050505060405180910390a160009250611110565b8160020160008d73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209050600073ffffffffffffffffffffffffffffffffffffffff168160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610fee577f87098308100b9295fda0e232be65e65af3ad95b4787d64dabc48e6c371bf6b0c336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807fe697a0e5b7b2e6b3a8e5868ce79a84e8aebee5a4870000000000000000000000815250602001935050505060405180910390a160009250611110565b8a8a826001018d8d6040518083838082843782019150509250505090815260200160405180910390206000019190611027929190612791565b508888826001018d8d6040518083838082843782019150509250505090815260200160405180910390206001019190611061929190612791565b507f87098308100b9295fda0e232be65e65af3ad95b4787d64dabc48e6c371bf6b0c336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260188152602001807fe8aebee5a487e5b19ee680a7e8aebee7bdaee68890e58a9f0000000000000000815250602001935050505060405180910390a1600192505b50509a9950505050505050505050565b60008173ffffffffffffffffffffffffffffffffffffffff16600360008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161490505b919050565b600060008673ffffffffffffffffffffffffffffffffffffffff1661122e8585604051808383602002808284378201915050925050506040518091039020888880806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050612526565b73ffffffffffffffffffffffffffffffffffffffff161415156112fd577fd7fedc4e21c1e8c868c39947f237cbc93d69fb546f4f30807d089ce2903e913c336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807fe69caae9809ae8bf87e7adbee5908de8aea4e8af810000000000000000000000815250602001935050505060405180910390a160009150611556565b61133284846000818110151561130f57fe5b9050602002013585856001818110151561132557fe5b90506020020135896126b9565b15156113ea577fd7fedc4e21c1e8c868c39947f237cbc93d69fb546f4f30807d089ce2903e913c336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe9878de5a48de8afb7e6b1820000000000000000000000000000000000000000815250602001935050505060405180910390a160009150611556565b600160008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090508060010160008154809291906001900391905055508060020160008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006000820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff021916905550507fd7fedc4e21c1e8c868c39947f237cbc93d69fb546f4f30807d089ce2903e913c336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807fe8aebee5a487e8a7a3e6b3a8e5868ce68890e58a9f0000000000000000000000815250602001935050505060405180910390a15b509695505050505050565b60008573ffffffffffffffffffffffffffffffffffffffff166115d28484604051808383602002808284378201915050925050506040518091039020878780806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050612526565b73ffffffffffffffffffffffffffffffffffffffff161415156116a1577fd81954d18e3f69b83c68deea82450921ca577eb54d94994fff701132edfd656b336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807fe69caae9809ae8bf87e7adbee5908de8aea4e8af810000000000000000000000815250602001935050505060405180910390a1600090506119d7565b6116d68383600081811015156116b357fe5b905060200201358484600181811015156116c957fe5b90506020020135886126b9565b151561178e577fd81954d18e3f69b83c68deea82450921ca577eb54d94994fff701132edfd656b336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe9878de5a48de8afb7e6b1820000000000000000000000000000000000000000815250602001935050505060405180910390a1600090506119d7565b611797866119e0565b1561184e577fd81954d18e3f69b83c68deea82450921ca577eb54d94994fff701132edfd656b336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600f8152602001807fe5b9b3e58fb0e5b7b2e6b3a8e5868c0000000000000000000000000000000000815250602001935050505060405180910390a1600090506119d7565b85600160008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600160008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101819055506000600081548092919060010191905055507fd81954d18e3f69b83c68deea82450921ca577eb54d94994fff701132edfd656b336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe6b3a8e5868ce68890e58a9f0000000000000000000000000000000000000000815250602001935050505060405180910390a1600190505b95945050505050565b60008173ffffffffffffffffffffffffffffffffffffffff16600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161490505b919050565b6000600060008773ffffffffffffffffffffffffffffffffffffffff16611af08686604051808383602002808284378201915050925050506040518091039020898980806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050612526565b73ffffffffffffffffffffffffffffffffffffffff16141515611bbf577f2590971dad0b3355b3062e2e354fab7494d749a0db6be74501d93694d96cf7ec336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807fe69caae9809ae8bf87e7adbee5908de8aea4e8af810000000000000000000000815250602001935050505060405180910390a160009250612001565b611bf4858560008181101515611bd157fe5b90506020020135868660018181101515611be757fe5b905060200201358a6126b9565b1515611cac577f2590971dad0b3355b3062e2e354fab7494d749a0db6be74501d93694d96cf7ec336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe9878de5a48de8afb7e6b1820000000000000000000000000000000000000000815250602001935050505060405180910390a160009250612001565b611cb6898961244a565b15611d6d577f2590971dad0b3355b3062e2e354fab7494d749a0db6be74501d93694d96cf7ec336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600f8152602001807fe8aebee5a487e5b7b2e6b3a8e5868c0000000000000000000000000000000000815250602001935050505060405180910390a160009250612001565b600160008a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209150600073ffffffffffffffffffffffffffffffffffffffff168260000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415611eb9577f2590971dad0b3355b3062e2e354fab7494d749a0db6be74501d93694d96cf7ec336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252601b8152602001807fe5bd93e5898de697a0e5b7b2e6b3a8e5868ce79a84e5b9b3e58fb00000000000815250602001935050505060405180910390a160009250612001565b8160020160008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090508160010160008154809291906001019190505550878160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055507f2590971dad0b3355b3062e2e354fab7494d749a0db6be74501d93694d96cf7ec336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260128152602001807fe8aebee5a487e6b3a8e5868ce68890e58a9f0000000000000000000000000000815250602001935050505060405180910390a1600192505b50509695505050505050565b600060008673ffffffffffffffffffffffffffffffffffffffff166120808585604051808383602002808284378201915050925050506040518091039020888880806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050612526565b73ffffffffffffffffffffffffffffffffffffffff1614151561214f577f1a8006d324205832eb7071928be447b54e48c9bf090f363212bdac67aff25dac336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807fe69caae9809ae8bf87e7adbee5908de8aea4e8af810000000000000000000000815250602001935050505060405180910390a160009150612440565b61218484846000818110151561216157fe5b9050602002013585856001818110151561217757fe5b90506020020135896126b9565b151561223c577f1a8006d324205832eb7071928be447b54e48c9bf090f363212bdac67aff25dac336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe9878de5a48de8afb7e6b1820000000000000000000000000000000000000000815250602001935050505060405180910390a160009150612440565b61224587611120565b156122fc577f1a8006d324205832eb7071928be447b54e48c9bf090f363212bdac67aff25dac336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600f8152602001807fe794a8e688b7e5b7b2e6b3a8e5868c0000000000000000000000000000000000815250602001935050505060405180910390a160009150612440565b600360008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209050868160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506002600081548092919060010191905055507f1a8006d324205832eb7071928be447b54e48c9bf090f363212bdac67aff25dac336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260128152602001807fe794a8e688b7e6b3a8e5868ce68890e58a9f0000000000000000000000000000815250602001935050505060405180910390a1600191505b5095945050505050565b60008173ffffffffffffffffffffffffffffffffffffffff16600160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161490505b92915050565b6000612530612811565b6000604060405190810160405280601c81526020017f19457468657265756d205369676e6564204d6573736167653a0a333200000000815250915081856040518083805190602001908083835b602083106125a0578051825260208201915060208101905060208303925061257d565b6001836020036101000a038019825116818451168082178552505050505050905001826000191660001916815260200192505050604051809103902090506001818560008151811015156125f057fe5b906020019060200201516001900486600181518110151561260d57fe5b9060200190602002015187600281518110151561262657fe5b90602001906020020151604051806000526020016040526000604051602001526040518085600019166000191681526020018460ff1660ff16815260200183600019166000191681526020018260001916600019168152602001945050505050602060405160208103908084039060008661646e5a03f115156126a557fe5b50506020604051035192505b505092915050565b60006000600460008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020905084816001015414156127135760009150612789565b8060020154841115156127295760009150612789565b828160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555083816002018190555084816001018190555060019150612789565b5b5b509392505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106127d257803560ff1916838001178555612800565b82800160010185558215612800579182015b828111156127ff5782358255916020019190600101906127e4565b5b50905061280d9190612825565b5090565b602060405190810160405280600081525090565b61284791905b8082111561284357600081600090555060010161282b565b5090565b905600a165627a7a7230582050f8fa459527400f8c9e49dcbdabb8340b997c8355a3486f663c8cc5e0b567990029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"deviceAddr\",\"type\":\"address\"},{\"name\":\"attrType\",\"type\":\"string\"},{\"name\":\"attrState\",\"type\":\"string\"},{\"name\":\"sig\",\"type\":\"bytes32[]\"},{\"name\":\"nounceAndtimestamp\",\"type\":\"uint256[]\"}],\"name\":\"test\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"},{\"name\":\"deviceAddr\",\"type\":\"address\"},{\"name\":\"attrType\",\"type\":\"string\"},{\"name\":\"attrState\",\"type\":\"string\"},{\"name\":\"sig\",\"type\":\"bytes32[]\"},{\"name\":\"nounceAndtimestamp\",\"type\":\"uint256[]\"}],\"name\":\"devicesSetAttr\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"addr\",\"type\":\"address\"}],\"name\":\"checkUserRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"},{\"name\":\"deviceAddr\",\"type\":\"address\"},{\"name\":\"sig\",\"type\":\"bytes32[]\"},{\"name\":\"nounceAndtimestamp\",\"type\":\"uint256[]\"}],\"name\":\"deviceUnRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"},{\"name\":\"sig\",\"type\":\"bytes32[]\"},{\"name\":\"nounceAndtimestamp\",\"type\":\"uint256[]\"}],\"name\":\"platformRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"addr\",\"type\":\"address\"}],\"name\":\"checkPlatformRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"},{\"name\":\"deviceAddr\",\"type\":\"address\"},{\"name\":\"sig\",\"type\":\"bytes32[]\"},{\"name\":\"nounceAndtimestamp\",\"type\":\"uint256[]\"}],\"name\":\"devicesRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"userAddr\",\"type\":\"address\"},{\"name\":\"sig\",\"type\":\"bytes32[]\"},{\"name\":\"nounceAndtimestamp\",\"type\":\"uint256[]\"}],\"name\":\"userRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"},{\"name\":\"addr\",\"type\":\"address\"}],\"name\":\"checkDeviceRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"platformRegisterEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"devicesRegisterEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"devicesSetAttrEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"deviceUnRegisterEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"userRegisterEvent\",\"type\":\"event\"}]";

    private Register(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, isInitByName);
    }

    private Register(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, isInitByName);
    }

    private Register(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    private Register(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public static List<PlatformRegisterEventEventResponse> getPlatformRegisterEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("platformRegisterEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<PlatformRegisterEventEventResponse> responses = new ArrayList<PlatformRegisterEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            PlatformRegisterEventEventResponse typedResponse = new PlatformRegisterEventEventResponse();
            typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
            typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<PlatformRegisterEventEventResponse> platformRegisterEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("platformRegisterEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, PlatformRegisterEventEventResponse>() {
            @Override
            public PlatformRegisterEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                PlatformRegisterEventEventResponse typedResponse = new PlatformRegisterEventEventResponse();
                typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
                typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public static List<DevicesRegisterEventEventResponse> getDevicesRegisterEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("devicesRegisterEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DevicesRegisterEventEventResponse> responses = new ArrayList<DevicesRegisterEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DevicesRegisterEventEventResponse typedResponse = new DevicesRegisterEventEventResponse();
            typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
            typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<DevicesRegisterEventEventResponse> devicesRegisterEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("devicesRegisterEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, DevicesRegisterEventEventResponse>() {
            @Override
            public DevicesRegisterEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DevicesRegisterEventEventResponse typedResponse = new DevicesRegisterEventEventResponse();
                typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
                typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public static List<DevicesSetAttrEventEventResponse> getDevicesSetAttrEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("devicesSetAttrEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DevicesSetAttrEventEventResponse> responses = new ArrayList<DevicesSetAttrEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DevicesSetAttrEventEventResponse typedResponse = new DevicesSetAttrEventEventResponse();
            typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
            typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<DevicesSetAttrEventEventResponse> devicesSetAttrEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("devicesSetAttrEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, DevicesSetAttrEventEventResponse>() {
            @Override
            public DevicesSetAttrEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DevicesSetAttrEventEventResponse typedResponse = new DevicesSetAttrEventEventResponse();
                typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
                typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public static List<DeviceUnRegisterEventEventResponse> getDeviceUnRegisterEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("deviceUnRegisterEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DeviceUnRegisterEventEventResponse> responses = new ArrayList<DeviceUnRegisterEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DeviceUnRegisterEventEventResponse typedResponse = new DeviceUnRegisterEventEventResponse();
            typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
            typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<DeviceUnRegisterEventEventResponse> deviceUnRegisterEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("deviceUnRegisterEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, DeviceUnRegisterEventEventResponse>() {
            @Override
            public DeviceUnRegisterEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DeviceUnRegisterEventEventResponse typedResponse = new DeviceUnRegisterEventEventResponse();
                typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
                typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public static List<UserRegisterEventEventResponse> getUserRegisterEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("userRegisterEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<UserRegisterEventEventResponse> responses = new ArrayList<UserRegisterEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            UserRegisterEventEventResponse typedResponse = new UserRegisterEventEventResponse();
            typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
            typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<UserRegisterEventEventResponse> userRegisterEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("userRegisterEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, UserRegisterEventEventResponse>() {
            @Override
            public UserRegisterEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                UserRegisterEventEventResponse typedResponse = new UserRegisterEventEventResponse();
                typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
                typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public Future<TransactionReceipt> test(StaticArray<Address> addr4, Address deviceAddr, Utf8String attrType, Utf8String attrState, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp) {
        Function function = new Function("test", Arrays.<Type>asList(addr4, deviceAddr, attrType, attrState, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void test(StaticArray<Address> addr4, Address deviceAddr, Utf8String attrType, Utf8String attrState, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp, TransactionSucCallback callback) {
        Function function = new Function("test", Arrays.<Type>asList(addr4, deviceAddr, attrType, attrState, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<TransactionReceipt> devicesSetAttr(Address platAddr, Address deviceAddr, Utf8String attrType, Utf8String attrState, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp) {
        Function function = new Function("devicesSetAttr", Arrays.<Type>asList(platAddr, deviceAddr, attrType, attrState, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void devicesSetAttr(Address platAddr, Address deviceAddr, Utf8String attrType, Utf8String attrState, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp, TransactionSucCallback callback) {
        Function function = new Function("devicesSetAttr", Arrays.<Type>asList(platAddr, deviceAddr, attrType, attrState, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Bool> checkUserRegister(Address addr) {
        Function function = new Function("checkUserRegister", 
                Arrays.<Type>asList(addr), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> deviceUnRegister(Address platAddr, Address deviceAddr, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp) {
        Function function = new Function("deviceUnRegister", Arrays.<Type>asList(platAddr, deviceAddr, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void deviceUnRegister(Address platAddr, Address deviceAddr, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp, TransactionSucCallback callback) {
        Function function = new Function("deviceUnRegister", Arrays.<Type>asList(platAddr, deviceAddr, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<TransactionReceipt> platformRegister(Address platAddr, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp) {
        Function function = new Function("platformRegister", Arrays.<Type>asList(platAddr, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void platformRegister(Address platAddr, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp, TransactionSucCallback callback) {
        Function function = new Function("platformRegister", Arrays.<Type>asList(platAddr, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Bool> checkPlatformRegister(Address addr) {
        Function function = new Function("checkPlatformRegister", 
                Arrays.<Type>asList(addr), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> devicesRegister(Address platAddr, Address deviceAddr, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp) {
        Function function = new Function("devicesRegister", Arrays.<Type>asList(platAddr, deviceAddr, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void devicesRegister(Address platAddr, Address deviceAddr, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp, TransactionSucCallback callback) {
        Function function = new Function("devicesRegister", Arrays.<Type>asList(platAddr, deviceAddr, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<TransactionReceipt> userRegister(Address userAddr, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp) {
        Function function = new Function("userRegister", Arrays.<Type>asList(userAddr, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void userRegister(Address userAddr, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp, TransactionSucCallback callback) {
        Function function = new Function("userRegister", Arrays.<Type>asList(userAddr, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Bool> checkDeviceRegister(Address platAddr, Address addr) {
        Function function = new Function("checkDeviceRegister", 
                Arrays.<Type>asList(platAddr, addr), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public static Future<Register> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(Register.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Future<Register> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(Register.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Register load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Register(contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    public static Register load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Register(contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public static Register loadByName(String contractName, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Register(contractName, web3j, credentials, gasPrice, gasLimit, true);
    }

    public static Register loadByName(String contractName, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Register(contractName, web3j, transactionManager, gasPrice, gasLimit, true);
    }

    public static class PlatformRegisterEventEventResponse {
        public Address sender;

        public Bool result;

        public Utf8String message;
    }

    public static class DevicesRegisterEventEventResponse {
        public Address sender;

        public Bool result;

        public Utf8String message;
    }

    public static class DevicesSetAttrEventEventResponse {
        public Address sender;

        public Bool result;

        public Utf8String message;
    }

    public static class DeviceUnRegisterEventEventResponse {
        public Address sender;

        public Bool result;

        public Utf8String message;
    }

    public static class UserRegisterEventEventResponse {
        public Address sender;

        public Bool result;

        public Utf8String message;
    }
}
