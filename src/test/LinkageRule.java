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
import org.bcos.web3j.abi.datatypes.Event;
import org.bcos.web3j.abi.datatypes.Function;
import org.bcos.web3j.abi.datatypes.StaticArray;
import org.bcos.web3j.abi.datatypes.Type;
import org.bcos.web3j.abi.datatypes.Utf8String;
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
public final class LinkageRule extends Contract {
    private static String BINARY = "606060405260006001556000600355341561001657fe5b60405160208061231a833981016040528080519060200190919050505b33600060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b505b612253806100c76000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630497f7891461005c57806343accb391461017457806345651292146101be578063e5206378146103b2575bfe5b341561006457fe5b6100e06004808060800190600480602002604051908101604052809291908260046020028082843782019150505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190505061042f565b604051808315151515815260200180602001828103825283818151815260200191508051906020019080838360008314610139575b80518252602083111561013957602082019150602081019050602083039250610115565b505050905090810190601f1680156101655780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b341561017c57fe5b6101a46004808060800190919080359060200190820180359060200191909192905050610a1d565b604051808215151515815260200191505060405180910390f35b34156101c657fe5b6101dc6004808035906020019091905050610ee6565b604051808873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001806020018481526020018381038352868181518152602001915080519060200190808383600083146102fd575b8051825260208311156102fd576020820191506020810190506020830392506102d9565b505050905090810190601f1680156103295780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360008314610371575b8051825260208311156103715760208201915060208101905060208303925061034d565b505050905090810190601f16801561039d5780820380516001836020036101000a031916815260200191505b50995050505050505050505060405180910390f35b34156103ba57fe5b6104156004808060800190919080359060200190820180359060200191909192908035906020019082018035906020019190919290803573ffffffffffffffffffffffffffffffffffffffff1690602001909190505061110b565b604051808215151515815260200191505060405180910390f35b60006104396120da565b6000600060006002600088600160048110151561045257fe5b602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209250600073ffffffffffffffffffffffffffffffffffffffff168360000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16148061055557508660016004811015156104fc57fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168360000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614155b1561059c576000604060405190810160405280601581526020017fe88194e58aa8e8aebee5a487e4b88de5ad98e59ca8000000000000000000000081525094509450610a13565b8660006004811015156105ab57fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168360010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614151561064a576000604060405190810160405280601581526020017fe88194e58aa8e5b9b3e58fb0e4b88de58cb9e9858d000000000000000000000081525094509450610a13565b82600301600088600360048110151561065f57fe5b602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209150600073ffffffffffffffffffffffffffffffffffffffff168260000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161480610762575086600360048110151561070957fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168260000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614155b156107a9576000604060405190810160405280601581526020017fe58f97e68ea7e8aebee5a487e4b88de5ad98e59ca8000000000000000000000081525094509450610a13565b8660026004811015156107b857fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168260010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141515610857576000604060405190810160405280601581526020017fe58f97e68ea7e5b9b3e58fb0e4b88de58cb9e9858d000000000000000000000081525094509450610a13565b81600301866040518082805190602001908083835b6020831061088f578051825260208201915060208101905060208303925061086c565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390209050600081600001805460018160011615610100020316600290049050148061098e575061098c816000018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156109815780601f1061095657610100808354040283529160200191610981565b820191906000526020600020905b81548152906001019060200180831161096457829003601f168201915b505050505087611768565b155b156109d5576000604060405190810160405280601581526020017fe58f97e68ea7e5b19ee680a7e4b88de5ad98e59ca8000000000000000000000081525094509450610a13565b6001604060405190810160405280600681526020017fe6ada3e7a1ae0000000000000000000000000000000000000000000000000000815250945094505b5050509250929050565b6000600060006000610a5387600480602002604051908101604052809291908260046020028082843782019150505050506118ac565b1515610b31577f84fc29b6e646f4cad26b8d4ebd3391b1230e7e8d67bc19b5393be19df6a75795336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260318152602001807fe6b7bbe58aa0e794a8e688b7e59cbae699afe5a4b1e8b4a52ce5b9b3e58fb0e681526020017f8896e8aebee5a487e69caae6b3a8e5868c000000000000000000000000000000815250604001935050505060405180910390a160009350610edc565b60026000886001600481101515610b4457fe5b602002013573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209250866000600481101515610baa57fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168360010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550866001600481101515610c1657fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168360000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508260020160008154809291906001019190505550826003016000886003600481101515610c9c57fe5b602002013573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209150866002600481101515610d0257fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168260010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550866003600481101515610d6e57fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168260000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550816002016000815480929190600101919050555081600301868660405180838380828437820191505092505050908152602001604051809103902090508585826000019190610e1b9291906120ee565b506001600081548092919060010191905055507f84fc29b6e646f4cad26b8d4ebd3391b1230e7e8d67bc19b5393be19df6a75795336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260188152602001807fe6b7bbe58aa0e88194e58aa8e8a784e58899e68890e58a9f0000000000000000815250602001935050505060405180910390a1600193505b5050509392505050565b6000600060006000610ef66120da565b610efe6120da565b60006000600460008a815260200190815260200160002090508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168260020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168360030160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1684600401856005018660060154828054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561104d5780601f106110225761010080835404028352916020019161104d565b820191906000526020600020905b81548152906001019060200180831161103057829003601f168201915b50505050509250818054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156110e95780601f106110be576101008083540402835291602001916110e9565b820191906000526020600020905b8154815290600101906020018083116110cc57829003601f168201915b5050505050915097509750975097509750975097505b50919395979092949650565b600060006111176120da565b600060006111498b600480602002604051908101604052809291908260046020028082843782019150505050506118ac565b1515611201577fc9cdd6cf18aaf9f65139b7973ab3431ba80040a73e9df1cd045705cb5158f80b336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252601e8152602001807fe58f97e68ea7e5b9b3e58fb0e68896e8aebee5a487e69caae6b3a8e5868c0000815250602001935050505060405180910390a16000945061175a565b6112628b600480602002604051908101604052809291908260046020028082843782019150505050508b8b8080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505061042f565b8094508195505050831515611365577fc9cdd6cf18aaf9f65139b7973ab3431ba80040a73e9df1cd045705cb5158f80b33600085604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018315151515815260200180602001828103825283818151815260200191508051906020019080838360008314611321575b805182526020831115611321576020820191506020810190506020830392506112fd565b505050905090810190601f16801561134d5780820380516001836020036101000a031916815260200191505b5094505050505060405180910390a16000945061175a565b85600660006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600660009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16638a70e9cd8c60026004811015156113f357fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168d600360048110151561141d57fe5b602002013573ffffffffffffffffffffffffffffffffffffffff166000604051604001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050604060405180830381600087803b15156114ee57fe5b6102c65a03f115156114fc57fe5b505050604051805190602001805190508092508193505050811515611617577fc9cdd6cf18aaf9f65139b7973ab3431ba80040a73e9df1cd045705cb5158f80b33600061154884611d20565b604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183151515158152602001806020018281038252838181518152602001915080519060200190808383600083146115d3575b8051825260208311156115d3576020820191506020810190506020830392506115af565b505050905090810190601f1680156115ff5780820380516001836020036101000a031916815260200191505b5094505050505060405180910390a16000945061175a565b6116ab8b600480602002604051908101604052809291908260046020028082843782019150505050508b8b8080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050508a8a8080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050611f0b565b507fc9cdd6cf18aaf9f65139b7973ab3431ba80040a73e9df1cd045705cb5158f80b336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe88194e58aa8e68890e58a9f0000000000000000000000000000000000000000815250602001935050505060405180910390a1600194505b505050509695505050505050565b600060008251845114151561178057600091506118a5565b600090505b83518110156118a057828181518110151561179c57fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916848281518110151561181757fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff191614151561189457600091506118a5565b5b806001019050611785565b600191505b5092915050565b6000600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a6a502128360006004811015156118fb57fe5b60200201516000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b151561198357fe5b6102c65a03f1151561199157fe5b505050604051805190508015611ad75750600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f459f5a28360006004811015156119ef57fe5b6020020151846001600481101515611a0357fe5b60200201516000604051602001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050602060405180830381600087803b1515611abe57fe5b6102c65a03f11515611acc57fe5b505050604051805190505b8015611bcc5750600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a6a50212836002600481101515611b2b57fe5b60200201516000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b1515611bb357fe5b6102c65a03f11515611bc157fe5b505050604051805190505b8015611d085750600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f459f5a2836002600481101515611c2057fe5b6020020151846003600481101515611c3457fe5b60200201516000604051602001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050602060405180830381600087803b1515611cef57fe5b6102c65a03f11515611cfd57fe5b505050604051805190505b15611d165760019050611d1b565b600090505b919050565b611d286120da565b611d3061216e565b600060006000611d3e61216e565b6020604051805910611d4d5750595b908082528060200260200182016040525b50945060009350600092505b6020831015611e29578260080260020a876001900402600102915060007f010000000000000000000000000000000000000000000000000000000000000002827effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916141515611e1b57818585815181101515611de257fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a90535083806001019450505b5b8280600101935050611d6a565b83604051805910611e375750595b908082528060200260200182016040525b509050600092505b83831015611efd578483815181101515611e6657fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000028184815181101515611ebf57fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053505b8280600101935050611e50565b8095505b5050505050919050565b600060006004600060035481526020019081526020016000209050846000600481101515611f3557fe5b60200201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550846001600481101515611f8b57fe5b60200201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550846002600481101515611fe157fe5b60200201518160020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555084600360048110151561203757fe5b60200201518160030160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555083816004019080519060200190612096929190612182565b50828160050190805190602001906120af929190612182565b506003548160060181905550600360008154809291906001019190505550600191505b509392505050565b602060405190810160405280600081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061212f57803560ff191683800117855561215d565b8280016001018555821561215d579182015b8281111561215c578235825591602001919060010190612141565b5b50905061216a9190612202565b5090565b602060405190810160405280600081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106121c357805160ff19168380011785556121f1565b828001600101855582156121f1579182015b828111156121f05782518255916020019190600101906121d5565b5b5090506121fe9190612202565b5090565b61222491905b80821115612220576000816000905550600101612208565b5090565b905600a165627a7a72305820385a795b8b772dfb5b37fb78982481f1ce37476ef3da7b32bea85759639cdac40029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"attrType\",\"type\":\"string\"}],\"name\":\"checkLinkageRule\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"},{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"attrType\",\"type\":\"string\"}],\"name\":\"addLinkageRule\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"recordID\",\"type\":\"uint256\"}],\"name\":\"queryRecord\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"attrType\",\"type\":\"string\"},{\"name\":\"attrState\",\"type\":\"string\"},{\"name\":\"trustAddr\",\"type\":\"address\"}],\"name\":\"linkageRule\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"inputs\":[{\"name\":\"consAddr\",\"type\":\"address\"}],\"payable\":false,\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"addLinkageRuleEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"linkageRuleEvent\",\"type\":\"event\"}]";

    private LinkageRule(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, isInitByName);
    }

    private LinkageRule(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, isInitByName);
    }

    private LinkageRule(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    private LinkageRule(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public static List<AddLinkageRuleEventEventResponse> getAddLinkageRuleEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("addLinkageRuleEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<AddLinkageRuleEventEventResponse> responses = new ArrayList<AddLinkageRuleEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            AddLinkageRuleEventEventResponse typedResponse = new AddLinkageRuleEventEventResponse();
            typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
            typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<AddLinkageRuleEventEventResponse> addLinkageRuleEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("addLinkageRuleEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, AddLinkageRuleEventEventResponse>() {
            @Override
            public AddLinkageRuleEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                AddLinkageRuleEventEventResponse typedResponse = new AddLinkageRuleEventEventResponse();
                typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
                typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public static List<LinkageRuleEventEventResponse> getLinkageRuleEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("linkageRuleEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<LinkageRuleEventEventResponse> responses = new ArrayList<LinkageRuleEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            LinkageRuleEventEventResponse typedResponse = new LinkageRuleEventEventResponse();
            typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
            typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LinkageRuleEventEventResponse> linkageRuleEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("linkageRuleEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LinkageRuleEventEventResponse>() {
            @Override
            public LinkageRuleEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                LinkageRuleEventEventResponse typedResponse = new LinkageRuleEventEventResponse();
                typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
                typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public Future<List<Type>> checkLinkageRule(StaticArray<Address> addr4, Utf8String attrType) {
        Function function = new Function("checkLinkageRule", 
                Arrays.<Type>asList(addr4, attrType), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> addLinkageRule(StaticArray<Address> addr4, Utf8String attrType) {
        Function function = new Function("addLinkageRule", Arrays.<Type>asList(addr4, attrType), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void addLinkageRule(StaticArray<Address> addr4, Utf8String attrType, TransactionSucCallback callback) {
        Function function = new Function("addLinkageRule", Arrays.<Type>asList(addr4, attrType), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<List<Type>> queryRecord(Uint256 recordID) {
        Function function = new Function("queryRecord", 
                Arrays.<Type>asList(recordID), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> linkageRule(StaticArray<Address> addr4, Utf8String attrType, Utf8String attrState, Address trustAddr) {
        Function function = new Function("linkageRule", Arrays.<Type>asList(addr4, attrType, attrState, trustAddr), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void linkageRule(StaticArray<Address> addr4, Utf8String attrType, Utf8String attrState, Address trustAddr, TransactionSucCallback callback) {
        Function function = new Function("linkageRule", Arrays.<Type>asList(addr4, attrType, attrState, trustAddr), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public static Future<LinkageRule> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Address consAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(consAddr));
        return deployAsync(LinkageRule.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static Future<LinkageRule> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Address consAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(consAddr));
        return deployAsync(LinkageRule.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static LinkageRule load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new LinkageRule(contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    public static LinkageRule load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LinkageRule(contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public static LinkageRule loadByName(String contractName, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new LinkageRule(contractName, web3j, credentials, gasPrice, gasLimit, true);
    }

    public static LinkageRule loadByName(String contractName, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LinkageRule(contractName, web3j, transactionManager, gasPrice, gasLimit, true);
    }

    public static class AddLinkageRuleEventEventResponse {
        public Address sender;

        public Bool result;

        public Utf8String message;
    }

    public static class LinkageRuleEventEventResponse {
        public Address sender;

        public Bool result;

        public Utf8String message;
    }
}
