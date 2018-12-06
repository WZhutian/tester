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
import org.bcos.web3j.abi.FunctionEncoder;
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
import org.bcos.web3j.abi.datatypes.generated.Int256;
import org.bcos.web3j.abi.datatypes.generated.Uint256;
import org.bcos.web3j.abi.datatypes.generated.Uint8;
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
public final class TrustRule extends Contract {
    private static String BINARY = "6060604052341561000c57fe5b604051604080612251833981016040528080519060200190919080519060200190919050505b81600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b50505b61218a806100c76000396000f30060606040523615610076576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680631e663c181461007857806340b0d09a1461011d57806355eba6e6146101a85780638a70e9cd1461028f5780639f56b6681461030b578063cee0a1781461036b575bfe5b341561008057fe5b61010360048080608001909190803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803590602001908201803590602001919091929080359060200190820180359060200191909192908035906020019082018035906020019190919290803590602001908201803590602001919091929050506103bd565b604051808215151515815260200191505060405180910390f35b341561012557fe5b61018e600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803590602001909190803560ff1690602001909190803590602001908201803590602001919091929080359060200190820180359060200191909192905050610787565b604051808215151515815260200191505060405180910390f35b34156101b057fe5b6101fb600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610e53565b604051808315151515815260200180602001828103825283818151815260200191508051906020019080838360008314610254575b80518252602083111561025457602082019150602081019050602083039250610230565b505050905090810190601f1680156102805780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b341561029757fe5b6102e2600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610e8b565b604051808315151515815260200182600019166000191681526020019250505060405180910390f35b341561031357fe5b610351600480803590602001909190803590602001908201803590602001919091929080359060200190820180359060200191909192905050611189565b604051808215151515815260200191505060405180910390f35b341561037357fe5b61037b6114b8565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b60006104b48b600480602002604051908101604052809291908260046020028082843782019150505050508b8b8b8080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050508a8a8080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050508989808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050508888808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050506114e3565b151561056c577f347130657bfcbc82a8fe8ea08742f36b796e7c1defcdb0d121dd1c1415b67c38336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807fe69caae9809ae8bf87e7adbee5908de8aea4e8af810000000000000000000000815250602001935050505060405180910390a160009050610779565b6105ca83836000818110151561057e57fe5b9050602002013584846001818110151561059457fe5b905060200201358d60016004811015156105aa57fe5b602002013573ffffffffffffffffffffffffffffffffffffffff166117ce565b1515610682577f347130657bfcbc82a8fe8ea08742f36b796e7c1defcdb0d121dd1c1415b67c38336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe9878de5a48de8afb7e6b1820000000000000000000000000000000000000000815250602001935050505060405180910390a160009050610779565b6107778b600480602002604051908101604052809291908260046020028082843782019150505050508b8b8b8080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050508a8a8080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050508989808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050508888808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050506118a6565b505b9a9950505050505050505050565b60006000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1661081c8585604051808383602002808284378201915050925050506040518091039020888880806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050611db8565b73ffffffffffffffffffffffffffffffffffffffff161415156108eb577f26705d6cdf67596ee1ac37c945f30dd7d2e4f72bc8d696fa2f1f567e89316e71336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807fe69caae9809ae8bf87e7adbee5908de8aea4e8af810000000000000000000000815250602001935050505060405180910390a160009150610e47565b6109428484600081811015156108fd57fe5b9050602002013585856001818110151561091357fe5b90506020020135600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166117ce565b15156109fa577f26705d6cdf67596ee1ac37c945f30dd7d2e4f72bc8d696fa2f1f567e89316e71336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe9878de5a48de8afb7e6b1820000000000000000000000000000000000000000815250602001935050505060405180910390a160009150610e47565b600360008a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090508660ff16600060ff161415610b5657888160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508781600101819055506002600081548092919060010191905055507f26705d6cdf67596ee1ac37c945f30dd7d2e4f72bc8d696fa2f1f567e89316e71336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe6b7bbe58aa0e68890e58a9f0000000000000000000000000000000000000000815250602001935050505060405180910390a1610e42565b8660ff16600160ff161415610c5f57888160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508781600101819055507f26705d6cdf67596ee1ac37c945f30dd7d2e4f72bc8d696fa2f1f567e89316e71336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe4bfaee694b9e68890e58a9f0000000000000000000000000000000000000000815250602001935050505060405180910390a1610e41565b8660ff16600260ff161415610d8e57600360008a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006000820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff0219169055600182016000905550507f26705d6cdf67596ee1ac37c945f30dd7d2e4f72bc8d696fa2f1f567e89316e71336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe588a0e999a4e68890e58a9f0000000000000000000000000000000000000000815250602001935050505060405180910390a1610e40565b7f26705d6cdf67596ee1ac37c945f30dd7d2e4f72bc8d696fa2f1f567e89316e71336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600f8152602001807fe69caae79fa5e6938de4bd9ce7aca60000000000000000000000000000000000815250602001935050505060405180910390a160009150610e47565b5b5b600191505b50979650505050505050565b6000610e5d612136565b60006000610e6b8686610e8b565b809250819350505081610e7d82611f4b565b935093505b50509250929050565b600060006000600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a6a50212866000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b1515610f5357fe5b6102c65a03f11515610f6157fe5b505050604051805190501515610f9d5760007fe5b9b3e58fb0e69caae6b3a8e5868c000000000000000000000000000000000092509250611181565b600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f459f5a286866000604051602001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050602060405180830381600087803b151561109357fe5b6102c65a03f115156110a157fe5b5050506040518051905015156110dd5760007fe8aebee5a487e69caae6b3a8e5868c000000000000000000000000000000000092509250611181565b600360008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020905060045481600101541215156111595760017fe8aebee5a487e58fafe4bfa1e4bbbb000000000000000000000000000000000092509250611181565b60007fe69caae8bebee588b0e5b9b3e58fb0e99888e580bc0000000000000000000000925092505b509250929050565b6000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1661121c8484604051808383602002808284378201915050925050506040518091039020878780806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050611db8565b73ffffffffffffffffffffffffffffffffffffffff161415156112eb577ff180c5c65b2c868e3a3ce7b7e32517d3ade773cab2ce5481d2b6987440197954336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807fe69caae9809ae8bf87e7adbee5908de8aea4e8af810000000000000000000000815250602001935050505060405180910390a1600090506114af565b6113428383600081811015156112fd57fe5b9050602002013584846001818110151561131357fe5b90506020020135600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166117ce565b15156113fa577ff180c5c65b2c868e3a3ce7b7e32517d3ade773cab2ce5481d2b6987440197954336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe9878de5a48de8afb7e6b1820000000000000000000000000000000000000000815250602001935050505060405180910390a1600090506114af565b856004819055507ff180c5c65b2c868e3a3ce7b7e32517d3ade773cab2ce5481d2b6987440197954336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807fe4bfa1e4bbbbe580bce8aebee7bdaee68890e58a9f0000000000000000000000815250602001935050505060405180910390a1600190505b95945050505050565b6000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690505b90565b60008660016004811015156114f457fe5b602002015173ffffffffffffffffffffffffffffffffffffffff166117aa88600060048110151561152157fe5b602002015189600160048110151561153557fe5b60200201518a600260048110151561154957fe5b60200201518b600360048110151561155d57fe5b60200201518b8b8b8a604051808973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c0100000000000000000000000002815260140184805190602001908083835b602083106116de57805182526020820191506020810190506020830392506116bb565b6001836020036101000a03801982511681845116808217855250505050505090500183805190602001908083835b6020831061172f578051825260208201915060208101905060208303925061170c565b6001836020036101000a03801982511681845116808217855250505050505090500182805190602001906020028083836000831461178c575b80518252602083111561178c57602082019150602081019050602083039250611768565b50505090500198505050505050505050604051809103902085611db8565b73ffffffffffffffffffffffffffffffffffffffff161490505b9695505050505050565b60006000600560008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090508481600101541415611828576000915061189e565b80600201548411151561183e576000915061189e565b828160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508381600201819055508481600101819055506001915061189e565b5b5b509392505050565b600060006118b2612136565b60006118e48a60006004811015156118c657fe5b60200201518b60016004811015156118da57fe5b6020020151610e53565b80935081945050508215611cb65788600660006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600660009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663dcf87ff78b8b8b8b8b8b6000604051602001526040518763ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180876004602002808383600083146119e5575b8051825260208311156119e5576020820191506020810190506020830392506119c1565b5050509050018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001806020018060200180602001858103855289818151815260200191508051906020019080838360008314611a74575b805182526020831115611a7457602082019150602081019050602083039250611a50565b505050905090810190601f168015611aa05780820380516001836020036101000a031916815260200191505b50858103845288818151815260200191508051906020019080838360008314611ae8575b805182526020831115611ae857602082019150602081019050602083039250611ac4565b505050905090810190601f168015611b145780820380516001836020036101000a031916815260200191505b50858103835287818151815260200191508051906020019060200280838360008314611b5f575b805182526020831115611b5f57602082019150602081019050602083039250611b3b565b505050905001858103825286818151815260200191508051906020019060200280838360008314611baf575b805182526020831115611baf57602082019150602081019050602083039250611b8b565b5050509050019a5050505050505050505050602060405180830381600087803b1515611bd757fe5b6102c65a03f11515611be557fe5b5050506040518051905090508015611ca8577f347130657bfcbc82a8fe8ea08742f36b796e7c1defcdb0d121dd1c1415b67c383382604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe8b083e794a8e68890e58a9f0000000000000000000000000000000000000000815250602001935050505060405180910390a160019350611dab565b60009350611dab565b611daa565b7f347130657bfcbc82a8fe8ea08742f36b796e7c1defcdb0d121dd1c1415b67c3833600084604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018315151515815260200180602001828103825283818151815260200191508051906020019080838360008314611d66575b805182526020831115611d6657602082019150602081019050602083039250611d42565b505050905090810190601f168015611d925780820380516001836020036101000a031916815260200191505b5094505050505060405180910390a160009350611dab565b5b5050509695505050505050565b6000611dc261214a565b6000604060405190810160405280601c81526020017f19457468657265756d205369676e6564204d6573736167653a0a333200000000815250915081856040518083805190602001908083835b60208310611e325780518252602082019150602081019050602083039250611e0f565b6001836020036101000a03801982511681845116808217855250505050505090500182600019166000191681526020019250505060405180910390209050600181856000815181101515611e8257fe5b9060200190602002015160019004866001815181101515611e9f57fe5b90602001906020020151876002815181101515611eb857fe5b90602001906020020151604051806000526020016040526000604051602001526040518085600019166000191681526020018460ff1660ff16815260200183600019166000191681526020018260001916600019168152602001945050505050602060405160208103908084039060008661646e5a03f11515611f3757fe5b50506020604051035192505b505092915050565b611f53612136565b611f5b61214a565b600060006000611f6961214a565b6020604051805910611f785750595b908082528060200260200182016040525b50945060009350600092505b6020831015612054578260080260020a876001900402600102915060007f010000000000000000000000000000000000000000000000000000000000000002827effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff19161415156120465781858581518110151561200d57fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a90535083806001019450505b5b8280600101935050611f95565b836040518059106120625750595b908082528060200260200182016040525b509050600092505b8383101561212857848381518110151561209157fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f01000000000000000000000000000000000000000000000000000000000000000281848151811015156120ea57fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053505b828060010193505061207b565b8095505b5050505050919050565b602060405190810160405280600081525090565b6020604051908101604052806000815250905600a165627a7a7230582054e21340ce4e7d672d9eabc954b2f3e732346174714012dd801c3a6e0c339a440029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"userSceneRuleAddr\",\"type\":\"address\"},{\"name\":\"attrType\",\"type\":\"string\"},{\"name\":\"attrState\",\"type\":\"string\"},{\"name\":\"sig\",\"type\":\"bytes32[]\"},{\"name\":\"nounceAndtimestamp\",\"type\":\"uint256[]\"}],\"name\":\"startLinking\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"deviceAddr\",\"type\":\"address\"},{\"name\":\"trustValue\",\"type\":\"int256\"},{\"name\":\"opCode\",\"type\":\"uint8\"},{\"name\":\"sig\",\"type\":\"bytes32[]\"},{\"name\":\"nounceAndtimestamp\",\"type\":\"uint256[]\"}],\"name\":\"setDevices\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"},{\"name\":\"deviceAddr\",\"type\":\"address\"}],\"name\":\"trustRuleJudgePackage\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"},{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"},{\"name\":\"deviceAddr\",\"type\":\"address\"}],\"name\":\"trustRuleJudge\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"},{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"value\",\"type\":\"int256\"},{\"name\":\"sig\",\"type\":\"bytes32[]\"},{\"name\":\"nounceAndtimestamp\",\"type\":\"uint256[]\"}],\"name\":\"setTrustThreshold\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getPlatAddr\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"type\":\"function\"},{\"inputs\":[{\"name\":\"plat\",\"type\":\"address\"},{\"name\":\"consAddr\",\"type\":\"address\"}],\"payable\":false,\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"setTrustThresholdEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"setDevicesEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"TrustRuleEvent\",\"type\":\"event\"}]";

    private TrustRule(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, isInitByName);
    }

    private TrustRule(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, isInitByName);
    }

    private TrustRule(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    private TrustRule(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public static List<SetTrustThresholdEventEventResponse> getSetTrustThresholdEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("setTrustThresholdEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<SetTrustThresholdEventEventResponse> responses = new ArrayList<SetTrustThresholdEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            SetTrustThresholdEventEventResponse typedResponse = new SetTrustThresholdEventEventResponse();
            typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
            typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SetTrustThresholdEventEventResponse> setTrustThresholdEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("setTrustThresholdEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, SetTrustThresholdEventEventResponse>() {
            @Override
            public SetTrustThresholdEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                SetTrustThresholdEventEventResponse typedResponse = new SetTrustThresholdEventEventResponse();
                typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
                typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public static List<SetDevicesEventEventResponse> getSetDevicesEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("setDevicesEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<SetDevicesEventEventResponse> responses = new ArrayList<SetDevicesEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            SetDevicesEventEventResponse typedResponse = new SetDevicesEventEventResponse();
            typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
            typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SetDevicesEventEventResponse> setDevicesEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("setDevicesEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, SetDevicesEventEventResponse>() {
            @Override
            public SetDevicesEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                SetDevicesEventEventResponse typedResponse = new SetDevicesEventEventResponse();
                typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
                typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public static List<TrustRuleEventEventResponse> getTrustRuleEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("TrustRuleEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<TrustRuleEventEventResponse> responses = new ArrayList<TrustRuleEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            TrustRuleEventEventResponse typedResponse = new TrustRuleEventEventResponse();
            typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
            typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TrustRuleEventEventResponse> trustRuleEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("TrustRuleEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, TrustRuleEventEventResponse>() {
            @Override
            public TrustRuleEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                TrustRuleEventEventResponse typedResponse = new TrustRuleEventEventResponse();
                typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
                typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public Future<TransactionReceipt> startLinking(StaticArray<Address> addr4, Address userSceneRuleAddr, Utf8String attrType, Utf8String attrState, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp) {
        Function function = new Function("startLinking", Arrays.<Type>asList(addr4, userSceneRuleAddr, attrType, attrState, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void startLinking(StaticArray<Address> addr4, Address userSceneRuleAddr, Utf8String attrType, Utf8String attrState, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp, TransactionSucCallback callback) {
        Function function = new Function("startLinking", Arrays.<Type>asList(addr4, userSceneRuleAddr, attrType, attrState, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<TransactionReceipt> setDevices(Address deviceAddr, Int256 trustValue, Uint8 opCode, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp) {
        Function function = new Function("setDevices", Arrays.<Type>asList(deviceAddr, trustValue, opCode, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void setDevices(Address deviceAddr, Int256 trustValue, Uint8 opCode, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp, TransactionSucCallback callback) {
        Function function = new Function("setDevices", Arrays.<Type>asList(deviceAddr, trustValue, opCode, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<List<Type>> trustRuleJudgePackage(Address platAddr, Address deviceAddr) {
        Function function = new Function("trustRuleJudgePackage", 
                Arrays.<Type>asList(platAddr, deviceAddr), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<List<Type>> trustRuleJudge(Address platAddr, Address deviceAddr) {
        Function function = new Function("trustRuleJudge", 
                Arrays.<Type>asList(platAddr, deviceAddr), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Bytes32>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> setTrustThreshold(Int256 value, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp) {
        Function function = new Function("setTrustThreshold", Arrays.<Type>asList(value, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void setTrustThreshold(Int256 value, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp, TransactionSucCallback callback) {
        Function function = new Function("setTrustThreshold", Arrays.<Type>asList(value, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Address> getPlatAddr() {
        Function function = new Function("getPlatAddr", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public static Future<TrustRule> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Address plat, Address consAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(plat, consAddr));
        return deployAsync(TrustRule.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static Future<TrustRule> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Address plat, Address consAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(plat, consAddr));
        return deployAsync(TrustRule.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static TrustRule load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TrustRule(contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    public static TrustRule load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TrustRule(contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public static TrustRule loadByName(String contractName, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TrustRule(contractName, web3j, credentials, gasPrice, gasLimit, true);
    }

    public static TrustRule loadByName(String contractName, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TrustRule(contractName, web3j, transactionManager, gasPrice, gasLimit, true);
    }

    public static class SetTrustThresholdEventEventResponse {
        public Address sender;

        public Bool result;

        public Utf8String message;
    }

    public static class SetDevicesEventEventResponse {
        public Address sender;

        public Bool result;

        public Utf8String message;
    }

    public static class TrustRuleEventEventResponse {
        public Address sender;

        public Bool result;

        public Utf8String message;
    }
}
