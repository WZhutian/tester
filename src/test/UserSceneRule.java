package test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Future;
import org.bcos.channel.client.TransactionSucCallback;
import org.bcos.web3j.abi.FunctionEncoder;
import org.bcos.web3j.abi.TypeReference;
import org.bcos.web3j.abi.datatypes.Address;
import org.bcos.web3j.abi.datatypes.Bool;
import org.bcos.web3j.abi.datatypes.Function;
import org.bcos.web3j.abi.datatypes.StaticArray;
import org.bcos.web3j.abi.datatypes.Type;
import org.bcos.web3j.abi.datatypes.Utf8String;
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
public final class UserSceneRule extends Contract {
    private static String BINARY = "60606040526000600155341561001157fe5b60405160208061151f833981016040528080519060200190919050505b33600060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b505b61145d806100c26000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806366c7667b1461005c5780637e3b6f5a146100fa578063818ad10814610158578063a273d8c214610182575bfe5b341561006457fe5b6100e06004808060800190600480602002604051908101604052809291908260046020028082843782019150505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190505061020a565b604051808215151515815260200191505060405180910390f35b341561010257fe5b61013e60048080608001909190803590602001908201803590602001919091929080359060200190820180359060200191909192905050610776565b604051808215151515815260200191505060405180910390f35b341561016057fe5b610168610adc565b604051808215151515815260200191505060405180910390f35b341561018a57fe5b6101f0600480806080019091908035906020019082018035906020019190919290803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610ae2565b604051808215151515815260200191505060405180910390f35b60006000600060006002600087600160048110151561022557fe5b602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209250600073ffffffffffffffffffffffffffffffffffffffff168360000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16148061032757508560016004811015156102cf57fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168360000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16145b15610335576000935061076d565b85600060048110151561034457fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168360010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156103a9576000935061076d565b8260040160008760036004811015156103be57fe5b602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209150600073ffffffffffffffffffffffffffffffffffffffff168260000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614806104c0575085600360048110151561046857fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168260000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16145b156104ce576000935061076d565b8560026004811015156104dd57fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168260010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415610542576000935061076d565b81600401856040518082805190602001908083835b6020831061057a5780518252602082019150602081019050602083039250610557565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390209050600081600001805460018160011615610100020316600290049050148061075a575073__Tools.sol:Tools_______________________6388d8da5f82600001876000604051602001526040518363ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001806020018381038352858181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156106b15780601f10610686576101008083540402835291602001916106b1565b820191906000526020600020905b81548152906001019060200180831161069457829003601f168201915b50508381038252848181518152602001915080519060200190808383600083146106fa575b8051825260208311156106fa576020820191506020810190506020830392506106d6565b505050905090810190601f1680156107265780820380516001836020036101000a031916815260200191505b5094505050505060206040518083038186803b151561074157fe5b6102c65a03f4151561074f57fe5b505050604051805190505b15610768576000935061076d565b600193505b50505092915050565b60006000600060006107ac8960048060200260405190810160405280929190826004602002808284378201915050505050610e7e565b15156107bb5760009350610ad0565b61081c896004806020026040519081016040528092919082600460200280828437820191505050505089898080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505061020a565b151561082b5760009350610ad0565b600260008a600160048110151561083e57fe5b602002013573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002092508260040160008a60036004811015156108aa57fe5b602002013573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002091508260020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663e52063788a8a8a8a8a8860020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166000604051602001526040518763ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018087600460200280828437820191505080602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835288888281815260200192508082843782019150508381038252868682818152602001925080828437820191505098505050505050505050602060405180830381600087803b1515610aa157fe5b6102c65a03f11515610aaf57fe5b505050604051805190509050801515610acb5760009350610ad0565b600193505b50505095945050505050565b60005b90565b6000600060006000600260008a6001600481101515610afd57fe5b602002013573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002092508260040160008a6003600481101515610b6957fe5b602002013573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002091508160040188886040518083838082843782019150509250505090815260200160405180910390209050886000600481101515610bf857fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168360010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550886001600481101515610c6457fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168360000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550858360020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508260030160008154809291906001019190505550886002600481101515610d2757fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168260010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550886003600481101515610d9357fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168260000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550848260020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600301600081548092919060010191905055508787826000019190610e5a92919061138c565b50600160008154809291906001019190505550600193505b50505095945050505050565b6000600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16639185b15a836000600481101515610ecd57fe5b6020020151600160006000604051602001526040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018360ff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019350505050602060405180830381600087803b1515610f9657fe5b6102c65a03f11515610fa457fe5b5050506040518051905080156110f65750600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16639185b15a83600060048110151561100257fe5b6020020151600285600160048110151561101857fe5b60200201516000604051602001526040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018360ff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019350505050602060405180830381600087803b15156110dd57fe5b6102c65a03f115156110eb57fe5b505050604051805190505b801561122c5750600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16639185b15a83600260048110151561114a57fe5b6020020151600160006000604051602001526040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018360ff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019350505050602060405180830381600087803b151561121357fe5b6102c65a03f1151561122157fe5b505050604051805190505b80156113745750600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16639185b15a83600260048110151561128057fe5b6020020151600285600360048110151561129657fe5b60200201516000604051602001526040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018360ff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019350505050602060405180830381600087803b151561135b57fe5b6102c65a03f1151561136957fe5b505050604051805190505b156113825760019050611387565b600090505b919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106113cd57803560ff19168380011785556113fb565b828001600101855582156113fb579182015b828111156113fa5782358255916020019190600101906113df565b5b509050611408919061140c565b5090565b61142e91905b8082111561142a576000816000905550600101611412565b5090565b905600a165627a7a723058209d6ba716ebf26b296cab6ebb17f9e67e2d6ccd1b7d0aef3e7047fc73028d7b100029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"attrType\",\"type\":\"string\"}],\"name\":\"checkUserSceneRule\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"attrType\",\"type\":\"string\"},{\"name\":\"attrState\",\"type\":\"string\"}],\"name\":\"userSceneRule\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"getUserSceneRule\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"attrType\",\"type\":\"string\"},{\"name\":\"ruleAddr\",\"type\":\"address\"},{\"name\":\"trustAddr\",\"type\":\"address\"}],\"name\":\"addUserSceneRule\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"inputs\":[{\"name\":\"consAddr\",\"type\":\"address\"}],\"payable\":false,\"type\":\"constructor\"}]";

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

    public Future<Bool> checkUserSceneRule(StaticArray<Address> addr4, Utf8String attrType) {
        Function function = new Function("checkUserSceneRule", 
                Arrays.<Type>asList(addr4, attrType), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> userSceneRule(StaticArray<Address> addr4, Utf8String attrType, Utf8String attrState) {
        Function function = new Function("userSceneRule", Arrays.<Type>asList(addr4, attrType, attrState), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void userSceneRule(StaticArray<Address> addr4, Utf8String attrType, Utf8String attrState, TransactionSucCallback callback) {
        Function function = new Function("userSceneRule", Arrays.<Type>asList(addr4, attrType, attrState), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<TransactionReceipt> getUserSceneRule() {
        Function function = new Function("getUserSceneRule", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void getUserSceneRule(TransactionSucCallback callback) {
        Function function = new Function("getUserSceneRule", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
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
}
