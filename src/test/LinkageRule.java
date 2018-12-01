package test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.bcos.channel.client.TransactionSucCallback;
import org.bcos.web3j.abi.TypeReference;
import org.bcos.web3j.abi.datatypes.Address;
import org.bcos.web3j.abi.datatypes.Bool;
import org.bcos.web3j.abi.datatypes.Function;
import org.bcos.web3j.abi.datatypes.StaticArray;
import org.bcos.web3j.abi.datatypes.Type;
import org.bcos.web3j.abi.datatypes.Utf8String;
import org.bcos.web3j.abi.datatypes.generated.Uint256;
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
public final class LinkageRule extends Contract {
    private static String BINARY = "606060405260006001556000600355341561001657fe5b5b61145a806100266000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630497f7891461005c57806343accb39146100fa5780634565129214610144578063e520637814610338575bfe5b341561006457fe5b6100e06004808060800190600480602002604051908101604052809291908260046020028082843782019150505050509190803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919050506103b5565b604051808215151515815260200191505060405180910390f35b341561010257fe5b61012a6004808060800190919080359060200190820180359060200191909192905050610921565b604051808215151515815260200191505060405180910390f35b341561014c57fe5b6101626004808035906020019091905050610c35565b604051808873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018060200180602001848152602001838103835286818151815260200191508051906020019080838360008314610283575b8051825260208311156102835760208201915060208101905060208303925061025f565b505050905090810190601f1680156102af5780820380516001836020036101000a031916815260200191505b508381038252858181518152602001915080519060200190808383600083146102f7575b8051825260208311156102f7576020820191506020810190506020830392506102d3565b505050905090810190601f1680156103235780820380516001836020036101000a031916815260200191505b50995050505050505050505060405180910390f35b341561034057fe5b61039b6004808060800190919080359060200190820180359060200191909192908035906020019082018035906020019190919290803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610e5a565b604051808215151515815260200191505060405180910390f35b6000600060006000600260008760016004811015156103d057fe5b602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209250600073ffffffffffffffffffffffffffffffffffffffff168360000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614806104d2575085600160048110151561047a57fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168360000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16145b156104e05760009350610918565b8560006004811015156104ef57fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168360010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156105545760009350610918565b82600301600087600360048110151561056957fe5b602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209150600073ffffffffffffffffffffffffffffffffffffffff168260000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16148061066b575085600360048110151561061357fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168260000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16145b156106795760009350610918565b85600260048110151561068857fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168260010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156106ed5760009350610918565b81600301856040518082805190602001908083835b602083106107255780518252602082019150602081019050602083039250610702565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902090506000816000018054600181600116156101000203166002900490501480610905575073__Tools.sol:Tools_______________________6388d8da5f82600001876000604051602001526040518363ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018060200183810383528581815460018160011615610100020316600290048152602001915080546001816001161561010002031660029004801561085c5780601f106108315761010080835404028352916020019161085c565b820191906000526020600020905b81548152906001019060200180831161083f57829003601f168201915b50508381038252848181518152602001915080519060200190808383600083146108a5575b8051825260208311156108a557602082019150602081019050602083039250610881565b505050905090810190601f1680156108d15780820380516001836020036101000a031916815260200191505b5094505050505060206040518083038186803b15156108ec57fe5b6102c65a03f415156108fa57fe5b505050604051805190505b156109135760009350610918565b600193505b50505092915050565b60006000600060006002600088600160048110151561093c57fe5b602002013573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002092508260030160008860036004811015156109a857fe5b602002013573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002091508160030186866040518083838082843782019150509250505090815260200160405180910390209050866000600481101515610a3757fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168360000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550866001600481101515610aa357fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168360010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508260020160008154809291906001019190505550866003600481101515610b2357fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168260000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550866002600481101515610b8f57fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168260010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508585826000019190610bff9291906112f5565b508160020160008154809291906001019190505550600160008154809291906001019190505550600193505b5050509392505050565b6000600060006000610c45611375565b610c4d611375565b60006000600460008a815260200190815260200160002090508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168260020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168360030160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1684600401856005018660060154828054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610d9c5780601f10610d7157610100808354040283529160200191610d9c565b820191906000526020600020905b815481529060010190602001808311610d7f57829003601f168201915b50505050509250818054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610e385780601f10610e0d57610100808354040283529160200191610e38565b820191906000526020600020905b815481529060010190602001808311610e1b57829003601f168201915b5050505050915097509750975097509750975097505b50919395979092949650565b60006000610ebf886004806020026040519081016040528092919082600460200280828437820191505050505088888080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050506103b5565b1515610ece576000915061111b565b82600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16638a70e9cd896002600481101515610f5c57fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168a6003600481101515610f8657fe5b602002013573ffffffffffffffffffffffffffffffffffffffff166000604051602001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050602060405180830381600087803b151561105757fe5b6102c65a03f1151561106557fe5b505050604051805190509050801515611081576000915061111b565b611115886004806020026040519081016040528092919082600460200280828437820191505050505088888080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505087878080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050611126565b50600191505b509695505050505050565b60006000600460006003548152602001908152602001600020905084600060048110151561115057fe5b60200201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508460016004811015156111a657fe5b60200201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508460026004811015156111fc57fe5b60200201518160020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555084600360048110151561125257fe5b60200201518160030160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550838160040190805190602001906112b1929190611389565b50828160050190805190602001906112ca929190611389565b506003548160060181905550600360008154809291906001019190505550600191505b509392505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061133657803560ff1916838001178555611364565b82800160010185558215611364579182015b82811115611363578235825591602001919060010190611348565b5b5090506113719190611409565b5090565b602060405190810160405280600081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106113ca57805160ff19168380011785556113f8565b828001600101855582156113f8579182015b828111156113f75782518255916020019190600101906113dc565b5b5090506114059190611409565b5090565b61142b91905b8082111561142757600081600090555060010161140f565b5090565b905600a165627a7a7230582084e9b090f8ef50b850247fc30cb575141efcaa35ac97e51b96b4357cc320c71d0029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"attrType\",\"type\":\"string\"}],\"name\":\"checkLinkageRule\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"attrType\",\"type\":\"string\"}],\"name\":\"addLinkageRule\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"recordID\",\"type\":\"uint256\"}],\"name\":\"queryRecord\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"attrType\",\"type\":\"string\"},{\"name\":\"attrState\",\"type\":\"string\"},{\"name\":\"trustAddr\",\"type\":\"address\"}],\"name\":\"linkageRule\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"}]";

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

    public Future<Bool> checkLinkageRule(StaticArray<Address> addr4, Utf8String attrType) {
        Function function = new Function("checkLinkageRule", 
                Arrays.<Type>asList(addr4, attrType), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallSingleValueReturnAsync(function);
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

    public static Future<LinkageRule> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(LinkageRule.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Future<LinkageRule> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(LinkageRule.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
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
}
