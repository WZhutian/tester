package test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Future;
import org.bcos.channel.client.TransactionSucCallback;
import org.bcos.web3j.abi.TypeReference;
import org.bcos.web3j.abi.datatypes.Address;
import org.bcos.web3j.abi.datatypes.Function;
import org.bcos.web3j.abi.datatypes.Type;
import org.bcos.web3j.abi.datatypes.Utf8String;
import org.bcos.web3j.abi.datatypes.generated.Uint8;
import org.bcos.web3j.crypto.Credentials;
import org.bcos.web3j.protocol.Web3j;
import org.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.bcos.web3j.tx.Contract;
import org.bcos.web3j.tx.TransactionManager;

/**
 * Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>, or {@link org.bcos.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version none.
 */
public final class Register extends Contract {
    private static String BINARY = "6060604052341561000c57fe5b5b610be88061001c6000396000f30060606040523615610076576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806353162558146100785780638c83e25a146100c65780639185b15a14610133578063c3799525146101ac578063e4ea75af14610219578063e617fe9f14610267575bfe5b341561008057fe5b6100ac600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506102fc565b604051808215151515815260200191505060405180910390f35b34156100ce57fe5b610119600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506103bc565b604051808215151515815260200191505060405180910390f35b341561013b57fe5b610192600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803560ff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610526565b604051808215151515815260200191505060405180910390f35b34156101b457fe5b6101ff600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610770565b604051808215151515815260200191505060405180910390f35b341561022157fe5b61024d600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610842565b604051808215151515815260200191505060405180910390f35b341561026f57fe5b6102e2600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803590602001908201803590602001919091929080359060200190820180359060200191909192905050610944565b604051808215151515815260200191505060405180910390f35b6000600061030d8360006000610526565b1561031b57600091506103b6565b600360008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209050828160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600260008154809291906001019190505550600191505b50919050565b6000600060006103ce84600287610526565b156103dc576000925061051e565b600160008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209150600073ffffffffffffffffffffffffffffffffffffffff168260000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141561047f576000925061051e565b8160020160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090508160010160008154809291906001019190505550838160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600192505b505092915050565b60008260ff16600060ff1614156105cf578373ffffffffffffffffffffffffffffffffffffffff16600360008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16149050610769565b8260ff16600160ff1614156106b6578373ffffffffffffffffffffffffffffffffffffffff16600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16149050610769565b8260ff16600260ff16141561075d578373ffffffffffffffffffffffffffffffffffffffff16600160008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16149050610769565b60009050610769565b5b5b5b9392505050565b60006000600160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090508060010160008154809291906001900391905055508060020160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006000820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff02191690555050600191505b5092915050565b60006108518260016000610526565b1561085f576000905061093f565b81600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010181905550600060008154809291906001019190505550600190505b919050565b600060006000600160008a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209150600073ffffffffffffffffffffffffffffffffffffffff168260000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156109ed5760009250610b0b565b8160020160008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209050600073ffffffffffffffffffffffffffffffffffffffff168160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610a925760009250610b0b565b86868260010189896040518083838082843782019150509250505090815260200160405180910390206000019190610acb929190610b17565b5084848260010189896040518083838082843782019150509250505090815260200160405180910390206001019190610b05929190610b17565b50600192505b50509695505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610b5857803560ff1916838001178555610b86565b82800160010185558215610b86579182015b82811115610b85578235825591602001919060010190610b6a565b5b509050610b939190610b97565b5090565b610bb991905b80821115610bb5576000816000905550600101610b9d565b5090565b905600a165627a7a723058201d34b362b94fe63fe91ff0d0427fa9977be671507c7296946a4cb0eae8e2a8cf0029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"userAddr\",\"type\":\"address\"}],\"name\":\"userRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"},{\"name\":\"deviceAddr\",\"type\":\"address\"}],\"name\":\"devicesRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"addr\",\"type\":\"address\"},{\"name\":\"opCode\",\"type\":\"uint8\"},{\"name\":\"platAddr\",\"type\":\"address\"}],\"name\":\"checkRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"},{\"name\":\"deviceAddr\",\"type\":\"address\"}],\"name\":\"deviceUnRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"}],\"name\":\"platformRegister\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"platAddr\",\"type\":\"address\"},{\"name\":\"deviceAddr\",\"type\":\"address\"},{\"name\":\"attrType\",\"type\":\"string\"},{\"name\":\"attrState\",\"type\":\"string\"}],\"name\":\"devicesSetAttr\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"}]";

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

    public Future<TransactionReceipt> checkRegister(Address addr, Uint8 opCode, Address platAddr) {
        Function function = new Function("checkRegister", Arrays.<Type>asList(addr, opCode, platAddr), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void checkRegister(Address addr, Uint8 opCode, Address platAddr, TransactionSucCallback callback) {
        Function function = new Function("checkRegister", Arrays.<Type>asList(addr, opCode, platAddr), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
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
}
