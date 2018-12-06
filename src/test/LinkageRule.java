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
    private static String BINARY = "606060405260006001556000600355341561001657fe5b60405160408061310b833981016040528080519060200190919080519060200190919050505b81600060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b50505b61303a806100d16000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630497f7891461005c57806345651292146101745780634e4495b914610368578063e609206e146103da575bfe5b341561006457fe5b6100e06004808060800190600480602002604051908101604052809291908260046020028082843782019150505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190505061049e565b604051808315151515815260200180602001828103825283818151815260200191508051906020019080838360008314610139575b80518252602083111561013957602082019150602081019050602083039250610115565b505050905090810190601f1680156101655780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b341561017c57fe5b6101926004808035906020019091905050610a8c565b604051808873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001806020018481526020018381038352868181518152602001915080519060200190808383600083146102b3575b8051825260208311156102b35760208201915060208101905060208303925061028f565b505050905090810190601f1680156102df5780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360008314610327575b80518252602083111561032757602082019150602081019050602083039250610303565b505050905090810190601f1680156103535780820380516001836020036101000a031916815260200191505b50995050505050505050505060405180910390f35b341561037057fe5b6103c0600480806080019091908035906020019082018035906020019190919290803590602001908201803590602001919091929080359060200190820180359060200191909192905050610cb1565b604051808215151515815260200191505060405180910390f35b34156103e257fe5b61048460048080608001909190803573ffffffffffffffffffffffffffffffffffffffff169060200190919080359060200190820180359060200191909192908035906020019082018035906020019190919290803573ffffffffffffffffffffffffffffffffffffffff16906020019091908035906020019082018035906020019190919290803590602001908201803590602001919091929050506113ed565b604051808215151515815260200191505060405180910390f35b60006104a8612ec1565b600060006000600260008860016004811015156104c157fe5b602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209250600073ffffffffffffffffffffffffffffffffffffffff168360000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614806105c4575086600160048110151561056b57fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168360000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614155b1561060b576000604060405190810160405280601581526020017fe88194e58aa8e8aebee5a487e4b88de5ad98e59ca8000000000000000000000081525094509450610a82565b86600060048110151561061a57fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168360010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415156106b9576000604060405190810160405280601581526020017fe88194e58aa8e5b9b3e58fb0e4b88de58cb9e9858d000000000000000000000081525094509450610a82565b8260030160008860036004811015156106ce57fe5b602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209150600073ffffffffffffffffffffffffffffffffffffffff168260000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614806107d1575086600360048110151561077857fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168260000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614155b15610818576000604060405190810160405280601581526020017fe58f97e68ea7e8aebee5a487e4b88de5ad98e59ca8000000000000000000000081525094509450610a82565b86600260048110151561082757fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168260010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415156108c6576000604060405190810160405280601581526020017fe58f97e68ea7e5b9b3e58fb0e4b88de58cb9e9858d000000000000000000000081525094509450610a82565b81600301866040518082805190602001908083835b602083106108fe57805182526020820191506020810190506020830392506108db565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020905060008160000180546001816001161561010002031660029004905014806109fd57506109fb816000018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156109f05780601f106109c5576101008083540402835291602001916109f0565b820191906000526020600020905b8154815290600101906020018083116109d357829003601f168201915b505050505087611c3a565b155b15610a44576000604060405190810160405280601581526020017fe58f97e68ea7e5b19ee680a7e4b88de5ad98e59ca8000000000000000000000081525094509450610a82565b6001604060405190810160405280600681526020017fe6ada3e7a1ae0000000000000000000000000000000000000000000000000000815250945094505b5050509250929050565b6000600060006000610a9c612ec1565b610aa4612ec1565b60006000600460008a815260200190815260200160002090508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168160010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168260020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168360030160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1684600401856005018660060154828054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610bf35780601f10610bc857610100808354040283529160200191610bf3565b820191906000526020600020905b815481529060010190602001808311610bd657829003601f168201915b50505050509250818054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610c8f5780601f10610c6457610100808354040283529160200191610c8f565b820191906000526020600020905b815481529060010190602001808311610c7257829003601f168201915b5050505050915097509750975097509750975097505b50919395979092949650565b6000600060006000600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16610d4a87876040518083836020028082843782019150509250505060405180910390208a8a80806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050611d7e565b73ffffffffffffffffffffffffffffffffffffffff16141515610e19577f84fc29b6e646f4cad26b8d4ebd3391b1230e7e8d67bc19b5393be19df6a75795336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807fe69caae9809ae8bf87e7adbee5908de8aea4e8af810000000000000000000000815250602001935050505060405180910390a1600093506113df565b610e70868660008181101515610e2b57fe5b90506020020135878760018181101515610e4157fe5b90506020020135600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16611f11565b1515610f28577f84fc29b6e646f4cad26b8d4ebd3391b1230e7e8d67bc19b5393be19df6a75795336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe9878de5a48de8afb7e6b1820000000000000000000000000000000000000000815250602001935050505060405180910390a1600093506113df565b610f568b60048060200260405190810160405280929190826004602002808284378201915050505050611fe9565b1515611034577f84fc29b6e646f4cad26b8d4ebd3391b1230e7e8d67bc19b5393be19df6a75795336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260318152602001807fe6b7bbe58aa0e794a8e688b7e59cbae699afe5a4b1e8b4a52ce5b9b3e58fb0e681526020017f8896e8aebee5a487e69caae6b3a8e5868c000000000000000000000000000000815250604001935050505060405180910390a1600093506113df565b600260008c600160048110151561104757fe5b602002013573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002092508a60006004811015156110ad57fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168360010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508a600160048110151561111957fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168360000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555082600201600081548092919060010191905055508260030160008c600360048110151561119f57fe5b602002013573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002091508a600260048110151561120557fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168260010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508a600360048110151561127157fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168260000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508160020160008154809291906001019190505550816003018a8a6040518083838082843782019150509250505090815260200160405180910390209050898982600001919061131e929190612ed5565b506001600081548092919060010191905055507f84fc29b6e646f4cad26b8d4ebd3391b1230e7e8d67bc19b5393be19df6a75795336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260188152602001807fe6b7bbe58aa0e88194e58aa8e8a784e58899e68890e58a9f0000000000000000815250602001935050505060405180910390a1600193505b505050979650505050505050565b60006114e48c600480602002604051908101604052809291908260046020028082843782019150505050508c8c8c8080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050508b8b8080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505089898080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505088888080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505061245d565b151561159c577fc9cdd6cf18aaf9f65139b7973ab3431ba80040a73e9df1cd045705cb5158f80b336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807fe69caae9809ae8bf87e7adbee5908de8aea4e8af810000000000000000000000815250602001935050505060405180910390a160009050611c2b565b6115fa8383600081811015156115ae57fe5b905060200201358484600181811015156115c457fe5b905060200201358e60016004811015156115da57fe5b602002013573ffffffffffffffffffffffffffffffffffffffff16611f11565b15156116b2577fc9cdd6cf18aaf9f65139b7973ab3431ba80040a73e9df1cd045705cb5158f80b336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe9878de5a48de8afb7e6b1820000000000000000000000000000000000000000815250602001935050505060405180910390a160009050611c2b565b8a73ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611799577fc9cdd6cf18aaf9f65139b7973ab3431ba80040a73e9df1cd045705cb5158f80b336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260188152602001807fe8afb7e6b182e69da5e6ba90e59cb0e59d80e99499e8afaf0000000000000000815250602001935050505060405180910390a160009050611c2b565b600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a6a502128d60006004811015156117e657fe5b602002013573ffffffffffffffffffffffffffffffffffffffff166000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b151561188457fe5b6102c65a03f1151561189257fe5b505050604051805190501515611954577fc9cdd6cf18aaf9f65139b7973ab3431ba80040a73e9df1cd045705cb5158f80b336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252601b8152602001807fe8afb7e6b182e69da5e6ba90e5b9b3e58fb0e69caae6b3a8e5868c0000000000815250602001935050505060405180910390a160009050611c2b565b6119828c60048060200260405190810160405280929190826004602002808284378201915050505050611fe9565b1515611a3a577fc9cdd6cf18aaf9f65139b7973ab3431ba80040a73e9df1cd045705cb5158f80b336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252601e8152602001807fe58f97e68ea7e5b9b3e58fb0e68896e8aebee5a487e69caae6b3a8e5868c0000815250602001935050505060405180910390a160009050611c2b565b611a9b8c600480602002604051908101604052809291908260046020028082843782019150505050508b8b8080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050612748565b1515611aaa5760009050611c2b565b611ad9868d6004806020026040519081016040528092919082600460200280828437820191505050505061286e565b1515611ae85760009050611c2b565b611b7c8c600480602002604051908101604052809291908260046020028082843782019150505050508b8b8080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050508a8a8080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050612b07565b507fc9cdd6cf18aaf9f65139b7973ab3431ba80040a73e9df1cd045705cb5158f80b336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe88194e58aa8e68890e58a9f0000000000000000000000000000000000000000815250602001935050505060405180910390a1600190505b9b9a5050505050505050505050565b6000600082518451141515611c525760009150611d77565b600090505b8351811015611d72578281815181101515611c6e57fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff19168482815181101515611ce957fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916141515611d665760009150611d77565b5b806001019050611c57565b600191505b5092915050565b6000611d88612f55565b6000604060405190810160405280601c81526020017f19457468657265756d205369676e6564204d6573736167653a0a333200000000815250915081856040518083805190602001908083835b60208310611df85780518252602082019150602081019050602083039250611dd5565b6001836020036101000a03801982511681845116808217855250505050505090500182600019166000191681526020019250505060405180910390209050600181856000815181101515611e4857fe5b9060200190602002015160019004866001815181101515611e6557fe5b90602001906020020151876002815181101515611e7e57fe5b90602001906020020151604051806000526020016040526000604051602001526040518085600019166000191681526020018460ff1660ff16815260200183600019166000191681526020018260001916600019168152602001945050505050602060405160208103908084039060008661646e5a03f11515611efd57fe5b50506020604051035192505b505092915050565b60006000600660008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090508481600101541415611f6b5760009150611fe1565b806002015484111515611f815760009150611fe1565b828160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555083816002018190555084816001018190555060019150611fe1565b5b5b509392505050565b6000600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a6a5021283600060048110151561203857fe5b60200201516000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15156120c057fe5b6102c65a03f115156120ce57fe5b5050506040518051905080156122145750600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f459f5a283600060048110151561212c57fe5b602002015184600160048110151561214057fe5b60200201516000604051602001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050602060405180830381600087803b15156121fb57fe5b6102c65a03f1151561220957fe5b505050604051805190505b80156123095750600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a6a5021283600260048110151561226857fe5b60200201516000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15156122f057fe5b6102c65a03f115156122fe57fe5b505050604051805190505b80156124455750600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f459f5a283600260048110151561235d57fe5b602002015184600360048110151561237157fe5b60200201516000604051602001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050602060405180830381600087803b151561242c57fe5b6102c65a03f1151561243a57fe5b505050604051805190505b156124535760019050612458565b600090505b919050565b600086600160048110151561246e57fe5b602002015173ffffffffffffffffffffffffffffffffffffffff1661272488600060048110151561249b57fe5b60200201518960016004811015156124af57fe5b60200201518a60026004811015156124c357fe5b60200201518b60036004811015156124d757fe5b60200201518b8b8b8a604051808973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c0100000000000000000000000002815260140184805190602001908083835b602083106126585780518252602082019150602081019050602083039250612635565b6001836020036101000a03801982511681845116808217855250505050505090500183805190602001908083835b602083106126a95780518252602082019150602081019050602083039250612686565b6001836020036101000a038019825116818451168082178552505050505050905001828051906020019060200280838360008314612706575b805182526020831115612706576020820191506020810190506020830392506126e2565b50505090500198505050505050505050604051809103902085611d7e565b73ffffffffffffffffffffffffffffffffffffffff161490505b9695505050505050565b60006000612754612ec1565b61275e858561049e565b8092508193505050811515612861577fc9cdd6cf18aaf9f65139b7973ab3431ba80040a73e9df1cd045705cb5158f80b33600083604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001831515151581526020018060200182810382528381815181526020019150805190602001908083836000831461281d575b80518252602083111561281d576020820191506020810190506020830392506127f9565b505050905090810190601f1680156128495780820380516001836020036101000a031916815260200191505b5094505050505060405180910390a160009250612866565b600192505b505092915050565b60006000600084600760006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16638a70e9cd85600260048110151561290257fe5b602002015186600360048110151561291657fe5b60200201516000604051604001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050604060405180830381600087803b15156129d157fe5b6102c65a03f115156129df57fe5b505050604051805190602001805190508092508193505050811515612afa577fc9cdd6cf18aaf9f65139b7973ab3431ba80040a73e9df1cd045705cb5158f80b336000612a2b84612cd6565b604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018315151515815260200180602001828103825283818151815260200191508051906020019080838360008314612ab6575b805182526020831115612ab657602082019150602081019050602083039250612a92565b505050905090810190601f168015612ae25780820380516001836020036101000a031916815260200191505b5094505050505060405180910390a160009250612aff565b600192505b505092915050565b600060006004600060035481526020019081526020016000209050846000600481101515612b3157fe5b60200201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550846001600481101515612b8757fe5b60200201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550846002600481101515612bdd57fe5b60200201518160020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550846003600481101515612c3357fe5b60200201518160030160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555083816004019080519060200190612c92929190612f69565b5082816005019080519060200190612cab929190612f69565b506003548160060181905550600360008154809291906001019190505550600191505b509392505050565b612cde612ec1565b612ce6612f55565b600060006000612cf4612f55565b6020604051805910612d035750595b908082528060200260200182016040525b50945060009350600092505b6020831015612ddf578260080260020a876001900402600102915060007f010000000000000000000000000000000000000000000000000000000000000002827effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916141515612dd157818585815181101515612d9857fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a90535083806001019450505b5b8280600101935050612d20565b83604051805910612ded5750595b908082528060200260200182016040525b509050600092505b83831015612eb3578483815181101515612e1c57fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000028184815181101515612e7557fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053505b8280600101935050612e06565b8095505b5050505050919050565b602060405190810160405280600081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10612f1657803560ff1916838001178555612f44565b82800160010185558215612f44579182015b82811115612f43578235825591602001919060010190612f28565b5b509050612f519190612fe9565b5090565b602060405190810160405280600081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10612faa57805160ff1916838001178555612fd8565b82800160010185558215612fd8579182015b82811115612fd7578251825591602001919060010190612fbc565b5b509050612fe59190612fe9565b5090565b61300b91905b80821115613007576000816000905550600101612fef565b5090565b905600a165627a7a7230582032c61e4a752828fc2df56ef17f73dd8ac7d51854a7c34c5f8b6483dc714fcfb90029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"attrType\",\"type\":\"string\"}],\"name\":\"checkLinkageRule\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"},{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"recordID\",\"type\":\"uint256\"}],\"name\":\"queryRecord\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"address\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"attrType\",\"type\":\"string\"},{\"name\":\"sig\",\"type\":\"bytes32[]\"},{\"name\":\"nounceAndtimestamp\",\"type\":\"uint256[]\"}],\"name\":\"addLinkageRule\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"userSceneRuleAddr\",\"type\":\"address\"},{\"name\":\"attrType\",\"type\":\"string\"},{\"name\":\"attrState\",\"type\":\"string\"},{\"name\":\"trustRuleAddr\",\"type\":\"address\"},{\"name\":\"sig\",\"type\":\"bytes32[]\"},{\"name\":\"nounceAndtimestamp\",\"type\":\"uint256[]\"}],\"name\":\"linkageRule\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"inputs\":[{\"name\":\"plat\",\"type\":\"address\"},{\"name\":\"consAddr\",\"type\":\"address\"}],\"payable\":false,\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"addLinkageRuleEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"linkageRuleEvent\",\"type\":\"event\"}]";

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

    public Future<List<Type>> queryRecord(Uint256 recordID) {
        Function function = new Function("queryRecord", 
                Arrays.<Type>asList(recordID), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> addLinkageRule(StaticArray<Address> addr4, Utf8String attrType, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp) {
        Function function = new Function("addLinkageRule", Arrays.<Type>asList(addr4, attrType, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void addLinkageRule(StaticArray<Address> addr4, Utf8String attrType, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp, TransactionSucCallback callback) {
        Function function = new Function("addLinkageRule", Arrays.<Type>asList(addr4, attrType, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<TransactionReceipt> linkageRule(StaticArray<Address> addr4, Address userSceneRuleAddr, Utf8String attrType, Utf8String attrState, Address trustRuleAddr, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp) {
        Function function = new Function("linkageRule", Arrays.<Type>asList(addr4, userSceneRuleAddr, attrType, attrState, trustRuleAddr, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void linkageRule(StaticArray<Address> addr4, Address userSceneRuleAddr, Utf8String attrType, Utf8String attrState, Address trustRuleAddr, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp, TransactionSucCallback callback) {
        Function function = new Function("linkageRule", Arrays.<Type>asList(addr4, userSceneRuleAddr, attrType, attrState, trustRuleAddr, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public static Future<LinkageRule> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Address plat, Address consAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(plat, consAddr));
        return deployAsync(LinkageRule.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static Future<LinkageRule> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Address plat, Address consAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(plat, consAddr));
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
