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
    private static String BINARY = "6060604052341561000c57fe5b5b61138b8061001c6000396000f3006060604052361561008c576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063531625581461008e5780635d2a7637146100dc5780638c83e25a1461012a578063a6a5021214610197578063c3799525146101e5578063e4ea75af14610252578063e617fe9f146102a0578063f459f5a214610335575bfe5b341561009657fe5b6100c2600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506103a2565b604051808215151515815260200191505060405180910390f35b34156100e457fe5b610110600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506105b0565b604051808215151515815260200191505060405180910390f35b341561013257fe5b61017d600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff1690602001909190505061064b565b604051808215151515815260200191505060405180910390f35b341561019f57fe5b6101cb600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506109ae565b604051808215151515815260200191505060405180910390f35b34156101ed57fe5b610238600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610a49565b604051808215151515815260200191505060405180910390f35b341561025a57fe5b610286600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610bc0565b604051808215151515815260200191505060405180910390f35b34156102a857fe5b61031b600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803590602001908201803590602001919091929080359060200190820180359060200191909192905050610e10565b604051808215151515815260200191505060405180910390f35b341561033d57fe5b610388600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506111de565b604051808215151515815260200191505060405180910390f35b600060006103af836105b0565b15610466577f1a8006d324205832eb7071928be447b54e48c9bf090f363212bdac67aff25dac336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600f8152602001807fe794a8e688b7e5b7b2e6b3a8e5868c0000000000000000000000000000000000815250602001935050505060405180910390a1600091506105aa565b600360008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209050828160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506002600081548092919060010191905055507f1a8006d324205832eb7071928be447b54e48c9bf090f363212bdac67aff25dac336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260128152602001807fe794a8e688b7e6b3a8e5868ce68890e58a9f0000000000000000000000000000815250602001935050505060405180910390a1600191505b50919050565b60008173ffffffffffffffffffffffffffffffffffffffff16600360008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161490505b919050565b60006000600061065b85856111de565b15610712577f2590971dad0b3355b3062e2e354fab7494d749a0db6be74501d93694d96cf7ec336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600f8152602001807fe8aebee5a487e5b7b2e6b3a8e5868c0000000000000000000000000000000000815250602001935050505060405180910390a1600092506109a6565b600160008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209150600073ffffffffffffffffffffffffffffffffffffffff168260000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141561085e577f2590971dad0b3355b3062e2e354fab7494d749a0db6be74501d93694d96cf7ec336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252601b8152602001807fe5bd93e5898de697a0e5b7b2e6b3a8e5868ce79a84e5b9b3e58fb00000000000815250602001935050505060405180910390a1600092506109a6565b8160020160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090508160010160008154809291906001019190505550838160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055507f2590971dad0b3355b3062e2e354fab7494d749a0db6be74501d93694d96cf7ec336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260128152602001807fe8aebee5a487e6b3a8e5868ce68890e58a9f0000000000000000000000000000815250602001935050505060405180910390a1600192505b505092915050565b60008173ffffffffffffffffffffffffffffffffffffffff16600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161490505b919050565b60006000600160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090508060010160008154809291906001900391905055508060020160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006000820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff021916905550507fd7fedc4e21c1e8c868c39947f237cbc93d69fb546f4f30807d089ce2903e913c336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807fe8aebee5a487e8a7a3e6b3a8e5868ce68890e58a9f0000000000000000000000815250602001935050505060405180910390a15b5092915050565b6000610bcb826109ae565b15610c82577fd81954d18e3f69b83c68deea82450921ca577eb54d94994fff701132edfd656b336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600f8152602001807fe5b9b3e58fb0e5b7b2e6b3a8e5868c0000000000000000000000000000000000815250602001935050505060405180910390a160009050610e0b565b81600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101819055506000600081548092919060010191905055507fd81954d18e3f69b83c68deea82450921ca577eb54d94994fff701132edfd656b336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe6b3a8e5868ce68890e58a9f0000000000000000000000000000000000000000815250602001935050505060405180910390a1600190505b919050565b600060006000600160008a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209150600073ffffffffffffffffffffffffffffffffffffffff168260000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610f62577f87098308100b9295fda0e232be65e65af3ad95b4787d64dabc48e6c371bf6b0c336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807fe697a0e5b7b2e6b3a8e5868ce79a84e5b9b3e58fb00000000000000000000000815250602001935050505060405180910390a1600092506111d2565b8160020160008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209050600073ffffffffffffffffffffffffffffffffffffffff168160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156110b0577f87098308100b9295fda0e232be65e65af3ad95b4787d64dabc48e6c371bf6b0c336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807fe697a0e5b7b2e6b3a8e5868ce79a84e8aebee5a4870000000000000000000000815250602001935050505060405180910390a1600092506111d2565b868682600101898960405180838380828437820191505092505050908152602001604051809103902060000191906110e99291906112ba565b50848482600101898960405180838380828437820191505092505050908152602001604051809103902060010191906111239291906112ba565b507f87098308100b9295fda0e232be65e65af3ad95b4787d64dabc48e6c371bf6b0c336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260188152602001807fe8aebee5a487e5b19ee680a7e8aebee7bdaee68890e58a9f0000000000000000815250602001935050505060405180910390a1600192505b50509695505050505050565b60008173ffffffffffffffffffffffffffffffffffffffff16600160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161490505b92915050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106112fb57803560ff1916838001178555611329565b82800160010185558215611329579182015b8281111561132857823582559160200191906001019061130d565b5b509050611336919061133a565b5090565b61135c91905b80821115611358576000816000905550600101611340565b5090565b905600a165627a7a7230582028a879574198d592ce66ae09f3d2d5aa06fb8a9989594c31917698412172a4040029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"userAddr\",\"type\":\"address\"}],\"name\":\"userRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"addr\",\"type\":\"address\"}],\"name\":\"checkUserRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"},{\"name\":\"deviceAddr\",\"type\":\"address\"}],\"name\":\"devicesRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"addr\",\"type\":\"address\"}],\"name\":\"checkPlatformRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"},{\"name\":\"deviceAddr\",\"type\":\"address\"}],\"name\":\"deviceUnRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"}],\"name\":\"platformRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"},{\"name\":\"deviceAddr\",\"type\":\"address\"},{\"name\":\"attrType\",\"type\":\"string\"},{\"name\":\"attrState\",\"type\":\"string\"}],\"name\":\"devicesSetAttr\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"},{\"name\":\"addr\",\"type\":\"address\"}],\"name\":\"checkDeviceRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"platformRegisterEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"devicesRegisterEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"devicesSetAttrEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"deviceUnRegisterEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"userRegisterEvent\",\"type\":\"event\"}]";

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

    public Future<TransactionReceipt> userRegister(Address userAddr) {
        Function function = new Function("userRegister", Arrays.<Type>asList(userAddr), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void userRegister(Address userAddr, TransactionSucCallback callback) {
        Function function = new Function("userRegister", Arrays.<Type>asList(userAddr), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Bool> checkUserRegister(Address addr) {
        Function function = new Function("checkUserRegister", 
                Arrays.<Type>asList(addr), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> devicesRegister(Address platAddr, Address deviceAddr) {
        Function function = new Function("devicesRegister", Arrays.<Type>asList(platAddr, deviceAddr), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void devicesRegister(Address platAddr, Address deviceAddr, TransactionSucCallback callback) {
        Function function = new Function("devicesRegister", Arrays.<Type>asList(platAddr, deviceAddr), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Bool> checkPlatformRegister(Address addr) {
        Function function = new Function("checkPlatformRegister", 
                Arrays.<Type>asList(addr), 
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
