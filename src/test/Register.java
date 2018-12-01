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
import org.bcos.web3j.abi.datatypes.Event;
import org.bcos.web3j.abi.datatypes.Function;
import org.bcos.web3j.abi.datatypes.Type;
import org.bcos.web3j.abi.datatypes.Utf8String;
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
public final class Register extends Contract {
    private static String BINARY = "6060604052341561000c57fe5b5b610c4b8061001c6000396000f30060606040523615610076576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806353162558146100785780638c83e25a146100c65780639185b15a14610133578063c3799525146101ac578063e4ea75af14610219578063e617fe9f14610267575bfe5b341561008057fe5b6100ac600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506102fc565b604051808215151515815260200191505060405180910390f35b34156100ce57fe5b610119600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506103bc565b604051808215151515815260200191505060405180910390f35b341561013b57fe5b610192600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803560ff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610526565b604051808215151515815260200191505060405180910390f35b34156101b457fe5b6101ff600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610770565b604051808215151515815260200191505060405180910390f35b341561022157fe5b61024d600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610842565b604051808215151515815260200191505060405180910390f35b341561026f57fe5b6102e2600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091908035906020019082018035906020019190919290803590602001908201803590602001919091929050506109a7565b604051808215151515815260200191505060405180910390f35b6000600061030d8360006000610526565b1561031b57600091506103b6565b600360008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209050828160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600260008154809291906001019190505550600191505b50919050565b6000600060006103ce84600287610526565b156103dc576000925061051e565b600160008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209150600073ffffffffffffffffffffffffffffffffffffffff168260000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141561047f576000925061051e565b8160020160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090508160010160008154809291906001019190505550838160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600192505b505092915050565b60008260ff16600060ff1614156105cf578373ffffffffffffffffffffffffffffffffffffffff16600360008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16149050610769565b8260ff16600160ff1614156106b6578373ffffffffffffffffffffffffffffffffffffffff16600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16149050610769565b8260ff16600260ff16141561075d578373ffffffffffffffffffffffffffffffffffffffff16600160008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16149050610769565b60009050610769565b5b5b5b9392505050565b60006000600160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090508060010160008154809291906001900391905055508060020160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006000820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff02191690555050600191505b5092915050565b60006108518260016000610526565b1561085f57600090506109a2565b81600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101819055506000600081548092919060010191905055507f885a8574ca0fa9322e140a8278258d0be286859f02bcbb856fe906cb50fda4cb82604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a1600190505b919050565b600060006000600160008a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209150600073ffffffffffffffffffffffffffffffffffffffff168260000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610a505760009250610b6e565b8160020160008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209050600073ffffffffffffffffffffffffffffffffffffffff168160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610af55760009250610b6e565b86868260010189896040518083838082843782019150509250505090815260200160405180910390206000019190610b2e929190610b7a565b5084848260010189896040518083838082843782019150509250505090815260200160405180910390206001019190610b68929190610b7a565b50600192505b50509695505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610bbb57803560ff1916838001178555610be9565b82800160010185558215610be9579182015b82811115610be8578235825591602001919060010190610bcd565b5b509050610bf69190610bfa565b5090565b610c1c91905b80821115610c18576000816000905550600101610c00565b5090565b905600a165627a7a723058203668eef7aa889c8cac850c226594acb977335bffbef14a357948353f31dd9f0b0029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"userAddr\",\"type\":\"address\"}],\"name\":\"userRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"},{\"name\":\"deviceAddr\",\"type\":\"address\"}],\"name\":\"devicesRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"addr\",\"type\":\"address\"},{\"name\":\"opCode\",\"type\":\"uint8\"},{\"name\":\"platAddr\",\"type\":\"address\"}],\"name\":\"checkRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"},{\"name\":\"deviceAddr\",\"type\":\"address\"}],\"name\":\"deviceUnRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"}],\"name\":\"platformRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"},{\"name\":\"deviceAddr\",\"type\":\"address\"},{\"name\":\"attrType\",\"type\":\"string\"},{\"name\":\"attrState\",\"type\":\"string\"}],\"name\":\"devicesSetAttr\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"platAddr\",\"type\":\"address\"}],\"name\":\"platformRegisterEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[],\"name\":\"devicesRegisterEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[],\"name\":\"devicesSetAttrEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[],\"name\":\"deviceUnRegisterEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[],\"name\":\"userRegisterEvent\",\"type\":\"event\"}]";

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
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<PlatformRegisterEventEventResponse> responses = new ArrayList<PlatformRegisterEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            PlatformRegisterEventEventResponse typedResponse = new PlatformRegisterEventEventResponse();
            typedResponse.platAddr = (Address) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<PlatformRegisterEventEventResponse> platformRegisterEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("platformRegisterEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, PlatformRegisterEventEventResponse>() {
            @Override
            public PlatformRegisterEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                PlatformRegisterEventEventResponse typedResponse = new PlatformRegisterEventEventResponse();
                typedResponse.platAddr = (Address) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public static List<DevicesRegisterEventEventResponse> getDevicesRegisterEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("devicesRegisterEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DevicesRegisterEventEventResponse> responses = new ArrayList<DevicesRegisterEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DevicesRegisterEventEventResponse typedResponse = new DevicesRegisterEventEventResponse();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<DevicesRegisterEventEventResponse> devicesRegisterEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("devicesRegisterEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, DevicesRegisterEventEventResponse>() {
            @Override
            public DevicesRegisterEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DevicesRegisterEventEventResponse typedResponse = new DevicesRegisterEventEventResponse();
                return typedResponse;
            }
        });
    }

    public static List<DevicesSetAttrEventEventResponse> getDevicesSetAttrEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("devicesSetAttrEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DevicesSetAttrEventEventResponse> responses = new ArrayList<DevicesSetAttrEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DevicesSetAttrEventEventResponse typedResponse = new DevicesSetAttrEventEventResponse();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<DevicesSetAttrEventEventResponse> devicesSetAttrEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("devicesSetAttrEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, DevicesSetAttrEventEventResponse>() {
            @Override
            public DevicesSetAttrEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DevicesSetAttrEventEventResponse typedResponse = new DevicesSetAttrEventEventResponse();
                return typedResponse;
            }
        });
    }

    public static List<DeviceUnRegisterEventEventResponse> getDeviceUnRegisterEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("deviceUnRegisterEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<DeviceUnRegisterEventEventResponse> responses = new ArrayList<DeviceUnRegisterEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            DeviceUnRegisterEventEventResponse typedResponse = new DeviceUnRegisterEventEventResponse();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<DeviceUnRegisterEventEventResponse> deviceUnRegisterEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("deviceUnRegisterEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, DeviceUnRegisterEventEventResponse>() {
            @Override
            public DeviceUnRegisterEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DeviceUnRegisterEventEventResponse typedResponse = new DeviceUnRegisterEventEventResponse();
                return typedResponse;
            }
        });
    }

    public static List<UserRegisterEventEventResponse> getUserRegisterEventEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("userRegisterEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<UserRegisterEventEventResponse> responses = new ArrayList<UserRegisterEventEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            UserRegisterEventEventResponse typedResponse = new UserRegisterEventEventResponse();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<UserRegisterEventEventResponse> userRegisterEventEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("userRegisterEvent", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, UserRegisterEventEventResponse>() {
            @Override
            public UserRegisterEventEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                UserRegisterEventEventResponse typedResponse = new UserRegisterEventEventResponse();
                return typedResponse;
            }
        });
    }

    public Future<TransactionReceipt> userRegister(Address userAddr) {
        Function function = new Function("userRegister", Arrays.<Type>asList(userAddr), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void userRegister(Address userAddr, TransactionSucCallback callback) {
        Function function = new Function("userRegister", Arrays.<Type>asList(userAddr), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<TransactionReceipt> devicesRegister(Address platAddr, Address deviceAddr) {
        Function function = new Function("devicesRegister", Arrays.<Type>asList(platAddr, deviceAddr), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void devicesRegister(Address platAddr, Address deviceAddr, TransactionSucCallback callback) {
        Function function = new Function("devicesRegister", Arrays.<Type>asList(platAddr, deviceAddr), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Bool> checkRegister(Address addr, Uint8 opCode, Address platAddr) {
        Function function = new Function("checkRegister", 
                Arrays.<Type>asList(addr, opCode, platAddr), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> deviceUnRegister(Address platAddr, Address deviceAddr) {
        Function function = new Function("deviceUnRegister", Arrays.<Type>asList(platAddr, deviceAddr), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void deviceUnRegister(Address platAddr, Address deviceAddr, TransactionSucCallback callback) {
        Function function = new Function("deviceUnRegister", Arrays.<Type>asList(platAddr, deviceAddr), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<TransactionReceipt> platformRegister(Address platAddr) {
        Function function = new Function("platformRegister", Arrays.<Type>asList(platAddr), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void platformRegister(Address platAddr, TransactionSucCallback callback) {
        Function function = new Function("platformRegister", Arrays.<Type>asList(platAddr), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<TransactionReceipt> devicesSetAttr(Address platAddr, Address deviceAddr, Utf8String attrType, Utf8String attrState) {
        Function function = new Function("devicesSetAttr", Arrays.<Type>asList(platAddr, deviceAddr, attrType, attrState), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void devicesSetAttr(Address platAddr, Address deviceAddr, Utf8String attrType, Utf8String attrState, TransactionSucCallback callback) {
        Function function = new Function("devicesSetAttr", Arrays.<Type>asList(platAddr, deviceAddr, attrType, attrState), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
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
        public Address platAddr;
    }

    public static class DevicesRegisterEventEventResponse {
    }

    public static class DevicesSetAttrEventEventResponse {
    }

    public static class DeviceUnRegisterEventEventResponse {
    }

    public static class UserRegisterEventEventResponse {
    }
}
