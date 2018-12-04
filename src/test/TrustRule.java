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
import org.bcos.web3j.abi.datatypes.generated.Bytes32;
import org.bcos.web3j.abi.datatypes.generated.Int256;
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
    private static String BINARY = "6060604052341561000c57fe5b60405160208061116a833981016040528080519060200190919050505b33600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b505b6110ad806100bd6000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806355eba6e614610067578063787055111461014e57806389d878e2146101b35780638a70e9cd146101eb578063c30af21314610267575bfe5b341561006f57fe5b6100ba600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506102ca565b604051808315151515815260200180602001828103825283818151815260200191508051906020019080838360008314610113575b805182526020831115610113576020820191506020810190506020830392506100ef565b505050905090810190601f16801561013f5780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b341561015657fe5b6101b16004808060800190919080359060200190820180359060200191909192908035906020019082018035906020019190919290803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610302565b005b34156101bb57fe5b6101d1600480803590602001909190505061065b565b604051808215151515815260200191505060405180910390f35b34156101f357fe5b61023e600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610717565b604051808315151515815260200182600019166000191681526020019250505060405180910390f35b341561026f57fe5b6102b0600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803590602001909190803560ff16906020019091905050610a15565b604051808215151515815260200191505060405180910390f35b60006102d4611059565b600060006102e28686610717565b8092508193505050816102f482610e6e565b935093505b50509250929050565b600061030c611059565b600061036a89600060048110151561032057fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168a600160048110151561034a57fe5b602002013573ffffffffffffffffffffffffffffffffffffffff166102ca565b809350819450505082156105635783600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16637e3b6f5a8a8a8a8a8a6000604051602001526040518663ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018086600460200280828437820191505080602001806020018381038352878782818152602001925080828437820191505083810382528585828181526020019250808284378201915050975050505050505050602060405180830381600087803b151561049c57fe5b6102c65a03f115156104aa57fe5b5050506040518051905090507f347130657bfcbc82a8fe8ea08742f36b796e7c1defcdb0d121dd1c1415b67c383382604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe8b083e794a8e68890e58a9f0000000000000000000000000000000000000000815250602001935050505060405180910390a161064f565b7f347130657bfcbc82a8fe8ea08742f36b796e7c1defcdb0d121dd1c1415b67c3833600084604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018315151515815260200180602001828103825283818151815260200191508051906020019080838360008314610613575b805182526020831115610613576020820191506020810190506020830392506105ef565b505050905090810190601f16801561063f5780820380516001836020036101000a031916815260200191505b5094505050505060405180910390a15b5b505050505050505050565b6000816004819055507ff180c5c65b2c868e3a3ce7b7e32517d3ade773cab2ce5481d2b6987440197954336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807fe4bfa1e4bbbbe580bce8aebee7bdaee68890e58a9f0000000000000000000000815250602001935050505060405180910390a1600190505b919050565b600060006000600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a6a50212866000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15156107df57fe5b6102c65a03f115156107ed57fe5b5050506040518051905015156108295760007fe5b9b3e58fb0e69caae6b3a8e5868c000000000000000000000000000000000092509250610a0d565b600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f459f5a286866000604051602001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050602060405180830381600087803b151561091f57fe5b6102c65a03f1151561092d57fe5b5050506040518051905015156109695760007fe8aebee5a487e69caae6b3a8e5868c000000000000000000000000000000000092509250610a0d565b600360008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020905060045481600101541215156109e55760017fe8aebee5a487e58fafe4bfa1e4bbbb000000000000000000000000000000000092509250610a0d565b60007fe69caae8bebee588b0e5b9b3e58fb0e99888e580bc0000000000000000000000925092505b509250929050565b60006000600360008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090508260ff16600060ff161415610b7557848160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508381600101819055506002600081548092919060010191905055507f26705d6cdf67596ee1ac37c945f30dd7d2e4f72bc8d696fa2f1f567e89316e71336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe6b7bbe58aa0e68890e58a9f0000000000000000000000000000000000000000815250602001935050505060405180910390a1610e61565b8260ff16600160ff161415610c7e57848160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508381600101819055507f26705d6cdf67596ee1ac37c945f30dd7d2e4f72bc8d696fa2f1f567e89316e71336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe4bfaee694b9e68890e58a9f0000000000000000000000000000000000000000815250602001935050505060405180910390a1610e60565b8260ff16600260ff161415610dad57600360008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006000820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff0219169055600182016000905550507f26705d6cdf67596ee1ac37c945f30dd7d2e4f72bc8d696fa2f1f567e89316e71336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe588a0e999a4e68890e58a9f0000000000000000000000000000000000000000815250602001935050505060405180910390a1610e5f565b7f26705d6cdf67596ee1ac37c945f30dd7d2e4f72bc8d696fa2f1f567e89316e71336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600f8152602001807fe69caae79fa5e6938de4bd9ce7aca60000000000000000000000000000000000815250602001935050505060405180910390a160009150610e66565b5b5b600191505b509392505050565b610e76611059565b610e7e61106d565b600060006000610e8c61106d565b6020604051805910610e9b5750595b908082528060200260200182016040525b50945060009350600092505b6020831015610f77578260080260020a876001900402600102915060007f010000000000000000000000000000000000000000000000000000000000000002827effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916141515610f6957818585815181101515610f3057fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a90535083806001019450505b5b8280600101935050610eb8565b83604051805910610f855750595b908082528060200260200182016040525b509050600092505b8383101561104b578483815181101515610fb457fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f010000000000000000000000000000000000000000000000000000000000000002818481518110151561100d57fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053505b8280600101935050610f9e565b8095505b5050505050919050565b602060405190810160405280600081525090565b6020604051908101604052806000815250905600a165627a7a72305820a025c61f736fc259b62157b6a7f6acbdf0e5875247a29fe13159a97fc6cfd4760029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"},{\"name\":\"deviceAddr\",\"type\":\"address\"}],\"name\":\"trustRuleJudgePackage\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"},{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"attrType\",\"type\":\"string\"},{\"name\":\"attrState\",\"type\":\"string\"},{\"name\":\"userRuleAddr\",\"type\":\"address\"}],\"name\":\"startLinking\",\"outputs\":[],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"value\",\"type\":\"int256\"}],\"name\":\"setTrustThreshold\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"},{\"name\":\"deviceAddr\",\"type\":\"address\"}],\"name\":\"trustRuleJudge\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"},{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"deviceAddr\",\"type\":\"address\"},{\"name\":\"trustValue\",\"type\":\"int256\"},{\"name\":\"opCode\",\"type\":\"uint8\"}],\"name\":\"setDevices\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"inputs\":[{\"name\":\"consAddr\",\"type\":\"address\"}],\"payable\":false,\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"setTrustThresholdEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"setDevicesEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"TrustRuleEvent\",\"type\":\"event\"}]";

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

    public Future<List<Type>> trustRuleJudgePackage(Address platAddr, Address deviceAddr) {
        Function function = new Function("trustRuleJudgePackage", 
                Arrays.<Type>asList(platAddr, deviceAddr), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> startLinking(StaticArray<Address> addr4, Utf8String attrType, Utf8String attrState, Address userRuleAddr) {
        Function function = new Function("startLinking", Arrays.<Type>asList(addr4, attrType, attrState, userRuleAddr), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void startLinking(StaticArray<Address> addr4, Utf8String attrType, Utf8String attrState, Address userRuleAddr, TransactionSucCallback callback) {
        Function function = new Function("startLinking", Arrays.<Type>asList(addr4, attrType, attrState, userRuleAddr), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<TransactionReceipt> setTrustThreshold(Int256 value) {
        Function function = new Function("setTrustThreshold", Arrays.<Type>asList(value), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void setTrustThreshold(Int256 value, TransactionSucCallback callback) {
        Function function = new Function("setTrustThreshold", Arrays.<Type>asList(value), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<List<Type>> trustRuleJudge(Address platAddr, Address deviceAddr) {
        Function function = new Function("trustRuleJudge", 
                Arrays.<Type>asList(platAddr, deviceAddr), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Bytes32>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> setDevices(Address deviceAddr, Int256 trustValue, Uint8 opCode) {
        Function function = new Function("setDevices", Arrays.<Type>asList(deviceAddr, trustValue, opCode), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void setDevices(Address deviceAddr, Int256 trustValue, Uint8 opCode, TransactionSucCallback callback) {
        Function function = new Function("setDevices", Arrays.<Type>asList(deviceAddr, trustValue, opCode), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public static Future<TrustRule> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Address consAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(consAddr));
        return deployAsync(TrustRule.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static Future<TrustRule> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Address consAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(consAddr));
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
