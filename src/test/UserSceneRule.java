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
public final class UserSceneRule extends Contract {
    private static String BINARY = "60606040526000600155341561001157fe5b604051602080611b4e833981016040528080519060200190919050505b33600060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b505b611a8c806100c26000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806366c7667b146100515780637e3b6f5a14610169578063a273d8c2146101c7575bfe5b341561005957fe5b6100d56004808060800190600480602002604051908101604052809291908260046020028082843782019150505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190505061024f565b60405180831515151581526020018060200182810382528381815181526020019150805190602001908083836000831461012e575b80518252602083111561012e5760208201915060208101905060208303925061010a565b505050905090810190601f16801561015a5780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b341561017157fe5b6101ad6004808060800190919080359060200190820180359060200191909192908035906020019082018035906020019190919290505061083d565b604051808215151515815260200191505060405180910390f35b34156101cf57fe5b610235600480806080019091908035906020019082018035906020019190919290803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610e9e565b604051808215151515815260200191505060405180910390f35b60006102596119a7565b6000600060006002600088600160048110151561027257fe5b602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209250600073ffffffffffffffffffffffffffffffffffffffff168360000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161480610375575086600160048110151561031c57fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168360000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614155b156103bc576000604060405190810160405280601581526020017fe88194e58aa8e8aebee5a487e4b88de5ad98e59ca8000000000000000000000081525094509450610833565b8660006004811015156103cb57fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168360010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614151561046a576000604060405190810160405280601581526020017fe88194e58aa8e5b9b3e58fb0e4b88de58cb9e9858d000000000000000000000081525094509450610833565b82600401600088600360048110151561047f57fe5b602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209150600073ffffffffffffffffffffffffffffffffffffffff168260000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161480610582575086600360048110151561052957fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168260000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614155b156105c9576000604060405190810160405280601581526020017fe58f97e68ea7e8aebee5a487e4b88de5ad98e59ca8000000000000000000000081525094509450610833565b8660026004811015156105d857fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168260010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141515610677576000604060405190810160405280601581526020017fe58f97e68ea7e5b9b3e58fb0e4b88de58cb9e9858d000000000000000000000081525094509450610833565b81600401866040518082805190602001908083835b602083106106af578051825260208201915060208101905060208303925061068c565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020905060008160000180546001816001161561010002031660029004905014806107ae57506107ac816000018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156107a15780601f10610776576101008083540402835291602001916107a1565b820191906000526020600020905b81548152906001019060200180831161078457829003601f168201915b5050505050876113ef565b155b156107f5576000604060405190810160405280601581526020017fe58f97e68ea7e5b19ee680a7e4b88de5ad98e59ca8000000000000000000000081525094509450610833565b6001604060405190810160405280600681526020017fe6ada3e7a1ae0000000000000000000000000000000000000000000000000000815250945094505b5050509250929050565b600060006108496119a7565b60006000600061087d8b60048060200260405190810160405280929190826004602002808284378201915050505050611533565b1515610935577f175646cbe010191a0c6d5416dacddc31b31295ba0737069ac6fc1ad88f9454bb336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252601e8152602001807fe58f97e68ea7e5b9b3e58fb0e5928ce8aebee5a487e69caae6b3a8e5868c0000815250602001935050505060405180910390a160009550610e90565b6109968b600480602002604051908101604052809291908260046020028082843782019150505050508b8b8080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505061024f565b8095508196505050841515610a99577f175646cbe010191a0c6d5416dacddc31b31295ba0737069ac6fc1ad88f9454bb33600086604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018315151515815260200180602001828103825283818151815260200191508051906020019080838360008314610a55575b805182526020831115610a5557602082019150602081019050602083039250610a31565b505050905090810190601f168015610a815780820380516001836020036101000a031916815260200191505b5094505050505060405180910390a160009550610e90565b600260008c6001600481101515610aac57fe5b602002013573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002092508260040160008c6003600481101515610b1857fe5b602002013573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002091508260020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663e52063788c8c8c8c8c8860020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166000604051602001526040518763ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018087600460200280828437820191505080602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835288888281815260200192508082843782019150508381038252868682818152602001925080828437820191505098505050505050505050602060405180830381600087803b1515610d0f57fe5b6102c65a03f11515610d1d57fe5b505050604051805190509050801515610de2577f175646cbe010191a0c6d5416dacddc31b31295ba0737069ac6fc1ad88f9454bb336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260188152602001807fe8b083e794a8e88194e58aa8e8a784e58899e5a4b1e8b4a50000000000000000815250602001935050505060405180910390a160009550610e90565b7f175646cbe010191a0c6d5416dacddc31b31295ba0737069ac6fc1ad88f9454bb336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260188152602001807fe8b083e794a8e88194e58aa8e8a784e58899e68890e58a9f0000000000000000815250602001935050505060405180910390a1600195505b505050505095945050505050565b6000600060006000610ed48960048060200260405190810160405280929190826004602002808284378201915050505050611533565b1515610fb2577fe04c951cf7ecc765e96b79fe72827854b42f9d592495f6c91196924276fde670336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260318152602001807fe6b7bbe58aa0e794a8e688b7e59cbae699afe5a4b1e8b4a52ce5b9b3e58fb0e681526020017f8896e8aebee5a487e69caae6b3a8e5868c000000000000000000000000000000815250604001935050505060405180910390a1600093506113e3565b600260008a6001600481101515610fc557fe5b602002013573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020925088600060048110151561102b57fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168360010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555088600160048110151561109757fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168360000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550858360020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555082600301600081548092919060010191905055508260040160008a600360048110151561116057fe5b602002013573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002091508860026004811015156111c657fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168260010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555088600360048110151561123257fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168260000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550848260020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508160030160008154809291906001019190505550816004018888604051808383808284378201915050925050509081526020016040518091039020905087878260000191906113229291906119bb565b506001600081548092919060010191905055507fe04c951cf7ecc765e96b79fe72827854b42f9d592495f6c91196924276fde670336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260188152602001807fe6b7bbe58aa0e794a8e688b7e59cbae699afe68890e58a9f0000000000000000815250602001935050505060405180910390a1600193505b50505095945050505050565b6000600082518451141515611407576000915061152c565b600090505b835181101561152757828181518110151561142357fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916848281518110151561149e57fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff191614151561151b576000915061152c565b5b80600101905061140c565b600191505b5092915050565b6000600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a6a5021283600060048110151561158257fe5b60200201516000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b151561160a57fe5b6102c65a03f1151561161857fe5b50505060405180519050801561175e5750600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f459f5a283600060048110151561167657fe5b602002015184600160048110151561168a57fe5b60200201516000604051602001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050602060405180830381600087803b151561174557fe5b6102c65a03f1151561175357fe5b505050604051805190505b80156118535750600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a6a502128360026004811015156117b257fe5b60200201516000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b151561183a57fe5b6102c65a03f1151561184857fe5b505050604051805190505b801561198f5750600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f459f5a28360026004811015156118a757fe5b60200201518460036004811015156118bb57fe5b60200201516000604051602001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050602060405180830381600087803b151561197657fe5b6102c65a03f1151561198457fe5b505050604051805190505b1561199d57600190506119a2565b600090505b919050565b602060405190810160405280600081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106119fc57803560ff1916838001178555611a2a565b82800160010185558215611a2a579182015b82811115611a29578235825591602001919060010190611a0e565b5b509050611a379190611a3b565b5090565b611a5d91905b80821115611a59576000816000905550600101611a41565b5090565b905600a165627a7a7230582020d3f93b4ff3bb2fc9cfcfc506dc90499180634f52eafccb444b3d4360b920b00029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"attrType\",\"type\":\"string\"}],\"name\":\"checkUserSceneRule\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"},{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"attrType\",\"type\":\"string\"},{\"name\":\"attrState\",\"type\":\"string\"}],\"name\":\"userSceneRule\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"attrType\",\"type\":\"string\"},{\"name\":\"ruleAddr\",\"type\":\"address\"},{\"name\":\"trustAddr\",\"type\":\"address\"}],\"name\":\"addUserSceneRule\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"inputs\":[{\"name\":\"consAddr\",\"type\":\"address\"}],\"payable\":false,\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"addUserSceneRuleEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"userSceneRuleEvent\",\"type\":\"event\"}]";

    private UserSceneRule(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, isInitByName);
    }

    private UserSceneRule(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, isInitByName);
    }

    private UserSceneRule(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    private UserSceneRule(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public static List<AddUserSceneRuleEventEventResponse> getAddUserSceneRuleEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("addUserSceneRuleEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<AddUserSceneRuleEventEventResponse> responses = new ArrayList<AddUserSceneRuleEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            AddUserSceneRuleEventEventResponse typedResponse = new AddUserSceneRuleEventEventResponse();
            typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
            typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<AddUserSceneRuleEventEventResponse> addUserSceneRuleEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("addUserSceneRuleEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, AddUserSceneRuleEventEventResponse>() {
            @Override
            public AddUserSceneRuleEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                AddUserSceneRuleEventEventResponse typedResponse = new AddUserSceneRuleEventEventResponse();
                typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
                typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public static List<UserSceneRuleEventEventResponse> getUserSceneRuleEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("userSceneRuleEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<UserSceneRuleEventEventResponse> responses = new ArrayList<UserSceneRuleEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            UserSceneRuleEventEventResponse typedResponse = new UserSceneRuleEventEventResponse();
            typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
            typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<UserSceneRuleEventEventResponse> userSceneRuleEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("userSceneRuleEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, UserSceneRuleEventEventResponse>() {
            @Override
            public UserSceneRuleEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                UserSceneRuleEventEventResponse typedResponse = new UserSceneRuleEventEventResponse();
                typedResponse.sender = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(1);
                typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public Future<List<Type>> checkUserSceneRule(StaticArray<Address> addr4, Utf8String attrType) {
        Function function = new Function("checkUserSceneRule", 
                Arrays.<Type>asList(addr4, attrType), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> userSceneRule(StaticArray<Address> addr4, Utf8String attrType, Utf8String attrState) {
        Function function = new Function("userSceneRule", Arrays.<Type>asList(addr4, attrType, attrState), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void userSceneRule(StaticArray<Address> addr4, Utf8String attrType, Utf8String attrState, TransactionSucCallback callback) {
        Function function = new Function("userSceneRule", Arrays.<Type>asList(addr4, attrType, attrState), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<TransactionReceipt> addUserSceneRule(StaticArray<Address> addr4, Utf8String attrType, Address ruleAddr, Address trustAddr) {
        Function function = new Function("addUserSceneRule", Arrays.<Type>asList(addr4, attrType, ruleAddr, trustAddr), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void addUserSceneRule(StaticArray<Address> addr4, Utf8String attrType, Address ruleAddr, Address trustAddr, TransactionSucCallback callback) {
        Function function = new Function("addUserSceneRule", Arrays.<Type>asList(addr4, attrType, ruleAddr, trustAddr), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public static Future<UserSceneRule> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Address consAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(consAddr));
        return deployAsync(UserSceneRule.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static Future<UserSceneRule> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Address consAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(consAddr));
        return deployAsync(UserSceneRule.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static UserSceneRule load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new UserSceneRule(contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    public static UserSceneRule load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new UserSceneRule(contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public static UserSceneRule loadByName(String contractName, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new UserSceneRule(contractName, web3j, credentials, gasPrice, gasLimit, true);
    }

    public static UserSceneRule loadByName(String contractName, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new UserSceneRule(contractName, web3j, transactionManager, gasPrice, gasLimit, true);
    }

    public static class AddUserSceneRuleEventEventResponse {
        public Address sender;

        public Bool result;

        public Utf8String message;
    }

    public static class UserSceneRuleEventEventResponse {
        public Address sender;

        public Bool result;

        public Utf8String message;
    }
}
