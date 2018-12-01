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
    private static String BINARY = "6060604052341561000c57fe5b6040516020806109b9833981016040528080519060200190919050505b33600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b505b6108fc806100bd6000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063787055111461005c57806389d878e2146100c15780638a70e9cd146100f9578063c30af21314610166575bfe5b341561006457fe5b6100bf6004808060800190919080359060200190820180359060200191909192908035906020019082018035906020019190919290803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506101c9565b005b34156100c957fe5b6100df6004808035906020019091905050610463565b604051808215151515815260200191505060405180910390f35b341561010157fe5b61014c600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610476565b604051808215151515815260200191505060405180910390f35b341561016e57fe5b6101af600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803590602001909190803560ff1690602001909190505061071b565b604051808215151515815260200191505060405180910390f35b60006102278760006004811015156101dd57fe5b602002013573ffffffffffffffffffffffffffffffffffffffff1688600160048110151561020757fe5b602002013573ffffffffffffffffffffffffffffffffffffffff16610476565b156103e35781600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16637e3b6f5a88888888886000604051602001526040518663ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018086600460200280828437820191505080602001806020018381038352878782818152602001925080828437820191505083810382528585828181526020019250808284378201915050975050505050505050602060405180830381600087803b151561035057fe5b6102c65a03f1151561035e57fe5b5050506040518051905090507f75eb3b045717d2ca636f7a28e650eef47f533f2531d61dc7b509efa4ffda3b8a816040518082151515158152602001806020018281038252600c8152602001807fe8b083e794a8e68890e58a9f00000000000000000000000000000000000000008152506020019250505060405180910390a1610459565b7f75eb3b045717d2ca636f7a28e650eef47f533f2531d61dc7b509efa4ffda3b8a60006040518082151515158152602001806020018281038252600f8152602001807fe4bfa1e4bbbbe580bce4b88de5a49f00000000000000000000000000000000008152506020019250505060405180910390a15b5b50505050505050565b600081600481905550600190505b919050565b60006000600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16639185b15a85600160006000604051602001526040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018360ff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019350505050602060405180830381600087803b151561057d57fe5b6102c65a03f1151561058b57fe5b5050506040518051905015806106b85750600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16639185b15a856002866000604051602001526040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018360ff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019350505050602060405180830381600087803b151561069e57fe5b6102c65a03f115156106ac57fe5b50505060405180519050155b156106c65760009150610714565b600360008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090506004548160010154121591505b5092915050565b60006000600360008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090508260ff16600060ff1614156107d257848160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508381600101819055506002600081548092919060010191905055506108c3565b8260ff16600160ff16141561083257848160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508381600101819055506108c2565b8260ff16600260ff1614156108b857600360008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006000820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff0219169055600182016000905550506108c1565b600091506108c8565b5b5b600191505b5093925050505600a165627a7a7230582098301a5e0d6c0e633ab2f8ae5a83c2b5ba62878ba7f83a4649d4bc8aa55a0d450029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"attrType\",\"type\":\"string\"},{\"name\":\"attrState\",\"type\":\"string\"},{\"name\":\"userRuleAddr\",\"type\":\"address\"}],\"name\":\"startLinking\",\"outputs\":[],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"value\",\"type\":\"int256\"}],\"name\":\"setTrustThreshold\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"},{\"name\":\"deviceAddr\",\"type\":\"address\"}],\"name\":\"trustRuleJudge\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"deviceAddr\",\"type\":\"address\"},{\"name\":\"trustValue\",\"type\":\"int256\"},{\"name\":\"opCode\",\"type\":\"uint8\"}],\"name\":\"setDevices\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"inputs\":[{\"name\":\"consAddr\",\"type\":\"address\"}],\"payable\":false,\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"TrustRuleEvent\",\"type\":\"event\"}]";

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

    public static List<TrustRuleEventEventResponse> getTrustRuleEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("TrustRuleEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<TrustRuleEventEventResponse> responses = new ArrayList<TrustRuleEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            TrustRuleEventEventResponse typedResponse = new TrustRuleEventEventResponse();
            typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(0);
            typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TrustRuleEventEventResponse> trustRuleEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("TrustRuleEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, TrustRuleEventEventResponse>() {
            @Override
            public TrustRuleEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                TrustRuleEventEventResponse typedResponse = new TrustRuleEventEventResponse();
                typedResponse.result = (Bool) eventValues.getNonIndexedValues().get(0);
                typedResponse.message = (Utf8String) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
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

    public Future<TransactionReceipt> trustRuleJudge(Address platAddr, Address deviceAddr) {
        Function function = new Function("trustRuleJudge", Arrays.<Type>asList(platAddr, deviceAddr), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void trustRuleJudge(Address platAddr, Address deviceAddr, TransactionSucCallback callback) {
        Function function = new Function("trustRuleJudge", Arrays.<Type>asList(platAddr, deviceAddr), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
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

    public static class TrustRuleEventEventResponse {
        public Bool result;

        public Utf8String message;
    }
}
