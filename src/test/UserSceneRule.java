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
public final class UserSceneRule extends Contract {
    private static String BINARY = "60606040526000600155341561001157fe5b604051604080612c8a833981016040528080519060200190919080519060200190919050505b81600060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b50505b612bbe806100cc6000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680634eb34be51461005157806366c7667b14610101578063dcf87ff714610219575bfe5b341561005957fe5b6100e7600480806080019091908035906020019082018035906020019190919290803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091908035906020019082018035906020019190919290803590602001908201803590602001919091929050506102be565b604051808215151515815260200191505060405180910390f35b341561010957fe5b6101856004808060800190600480602002604051908101604052809291908260046020028082843782019150505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091905050610a82565b6040518083151515158152602001806020018281038252838181518152602001915080519060200190808383600083146101de575b8051825260208311156101de576020820191506020810190506020830392506101ba565b505050905090810190601f16801561020a5780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b341561022157fe5b6102a460048080608001909190803573ffffffffffffffffffffffffffffffffffffffff169060200190919080359060200190820180359060200191909192908035906020019082018035906020019190919290803590602001908201803590602001919091929080359060200190820180359060200191909192905050611070565b604051808215151515815260200191505060405180910390f35b6000600060006000600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1661035787876040518083836020028082843782019150509250505060405180910390208a8a808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050506118f0565b73ffffffffffffffffffffffffffffffffffffffff16141515610426577fe04c951cf7ecc765e96b79fe72827854b42f9d592495f6c91196924276fde670336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807fe69caae9809ae8bf87e7adbee5908de8aea4e8af810000000000000000000000815250602001935050505060405180910390a160009350610a72565b61047d86866000818110151561043857fe5b9050602002013587876001818110151561044e57fe5b90506020020135600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16611a83565b1515610535577fe04c951cf7ecc765e96b79fe72827854b42f9d592495f6c91196924276fde670336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe9878de5a48de8afb7e6b1820000000000000000000000000000000000000000815250602001935050505060405180910390a160009350610a72565b6105638d60048060200260405190810160405280929190826004602002808284378201915050505050611b5b565b1515610641577fe04c951cf7ecc765e96b79fe72827854b42f9d592495f6c91196924276fde670336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260318152602001807fe6b7bbe58aa0e794a8e688b7e59cbae699afe5a4b1e8b4a52ce5b9b3e58fb0e681526020017f8896e8aebee5a487e69caae6b3a8e5868c000000000000000000000000000000815250604001935050505060405180910390a160009350610a72565b600260008e600160048110151561065457fe5b602002013573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002092508c60006004811015156106ba57fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168360010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508c600160048110151561072657fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168360000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550898360020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555082600301600081548092919060010191905055508260040160008e60036004811015156107ef57fe5b602002013573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002091508c600260048110151561085557fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168260010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508c60036004811015156108c157fe5b602002013573ffffffffffffffffffffffffffffffffffffffff168260000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550888260020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508160030160008154809291906001019190505550816004018c8c60405180838380828437820191505092505050908152602001604051809103902090508b8b8260000191906109b1929190612ac5565b506001600081548092919060010191905055507fe04c951cf7ecc765e96b79fe72827854b42f9d592495f6c91196924276fde670336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260188152602001807fe6b7bbe58aa0e794a8e688b7e59cbae699afe68890e58a9f0000000000000000815250602001935050505060405180910390a1600193505b5050509998505050505050505050565b6000610a8c612b45565b60006000600060026000886001600481101515610aa557fe5b602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209250600073ffffffffffffffffffffffffffffffffffffffff168360000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161480610ba85750866001600481101515610b4f57fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168360000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614155b15610bef576000604060405190810160405280601581526020017fe88194e58aa8e8aebee5a487e4b88de5ad98e59ca8000000000000000000000081525094509450611066565b866000600481101515610bfe57fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168360010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141515610c9d576000604060405190810160405280601581526020017fe88194e58aa8e5b9b3e58fb0e4b88de58cb9e9858d000000000000000000000081525094509450611066565b826004016000886003600481101515610cb257fe5b602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000209150600073ffffffffffffffffffffffffffffffffffffffff168260000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161480610db55750866003600481101515610d5c57fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168260000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614155b15610dfc576000604060405190810160405280601581526020017fe58f97e68ea7e8aebee5a487e4b88de5ad98e59ca8000000000000000000000081525094509450611066565b866002600481101515610e0b57fe5b602002015173ffffffffffffffffffffffffffffffffffffffff168260010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141515610eaa576000604060405190810160405280601581526020017fe58f97e68ea7e5b9b3e58fb0e4b88de58cb9e9858d000000000000000000000081525094509450611066565b81600401866040518082805190602001908083835b60208310610ee25780518252602082019150602081019050602083039250610ebf565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902090506000816000018054600181600116156101000203166002900490501480610fe15750610fdf816000018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610fd45780601f10610fa957610100808354040283529160200191610fd4565b820191906000526020600020905b815481529060010190602001808311610fb757829003601f168201915b505050505087611fcf565b155b15611028576000604060405190810160405280601581526020017fe58f97e68ea7e5b19ee680a7e4b88de5ad98e59ca8000000000000000000000081525094509450611066565b6001604060405190810160405280600681526020017fe6ada3e7a1ae0000000000000000000000000000000000000000000000000000815250945094505b5050509250929050565b60006111678b600480602002604051908101604052809291908260046020028082843782019150505050508b8b8b8080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050508a8a8080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050898980806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050888880806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050612113565b151561121f577f175646cbe010191a0c6d5416dacddc31b31295ba0737069ac6fc1ad88f9454bb336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260158152602001807fe69caae9809ae8bf87e7adbee5908de8aea4e8af810000000000000000000000815250602001935050505060405180910390a1600090506118e2565b61127d83836000818110151561123157fe5b9050602002013584846001818110151561124757fe5b905060200201358d600160048110151561125d57fe5b602002013573ffffffffffffffffffffffffffffffffffffffff16611a83565b1515611335577f175646cbe010191a0c6d5416dacddc31b31295ba0737069ac6fc1ad88f9454bb336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252600c8152602001807fe9878de5a48de8afb7e6b1820000000000000000000000000000000000000000815250602001935050505060405180910390a1600090506118e2565b8a600060048110151561134457fe5b602002013573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1663cee0a1786000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401809050602060405180830381600087803b15156113e157fe5b6102c65a03f115156113ef57fe5b5050506040518051905073ffffffffffffffffffffffffffffffffffffffff161415156114c8577f175646cbe010191a0c6d5416dacddc31b31295ba0737069ac6fc1ad88f9454bb336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260188152602001807fe8afb7e6b182e69da5e6ba90e59cb0e59d80e99499e8afaf0000000000000000815250602001935050505060405180910390a1600090506118e2565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a6a502128c600060048110151561151557fe5b602002013573ffffffffffffffffffffffffffffffffffffffff166000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15156115b357fe5b6102c65a03f115156115c157fe5b505050604051805190501515611683577f175646cbe010191a0c6d5416dacddc31b31295ba0737069ac6fc1ad88f9454bb336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252601b8152602001807fe8afb7e6b182e69da5e6ba90e5b9b3e58fb0e69caae6b3a8e5868c0000000000815250602001935050505060405180910390a1600090506118e2565b6116b18b60048060200260405190810160405280929190826004602002808284378201915050505050611b5b565b1515611769577f175646cbe010191a0c6d5416dacddc31b31295ba0737069ac6fc1ad88f9454bb336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182151515158152602001806020018281038252601e8152602001807fe58f97e68ea7e5b9b3e58fb0e5928ce8aebee5a487e69caae6b3a8e5868c0000815250602001935050505060405180910390a1600090506118e2565b6117ca8b600480602002604051908101604052809291908260046020028082843782019150505050508a8a8080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050506123fe565b15156117d957600090506118e2565b6118ce8b600480602002604051908101604052809291908260046020028082843782019150505050508b8b8b8080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050508a8a8080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050898980806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050888880806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050612524565b15156118dd57600090506118e2565b600190505b9a9950505050505050505050565b60006118fa612b59565b6000604060405190810160405280601c81526020017f19457468657265756d205369676e6564204d6573736167653a0a333200000000815250915081856040518083805190602001908083835b6020831061196a5780518252602082019150602081019050602083039250611947565b6001836020036101000a038019825116818451168082178552505050505050905001826000191660001916815260200192505050604051809103902090506001818560008151811015156119ba57fe5b90602001906020020151600190048660018151811015156119d757fe5b906020019060200201518760028151811015156119f057fe5b90602001906020020151604051806000526020016040526000604051602001526040518085600019166000191681526020018460ff1660ff16815260200183600019166000191681526020018260001916600019168152602001945050505050602060405160208103908084039060008661646e5a03f11515611a6f57fe5b50506020604051035192505b505092915050565b60006000600460008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090508481600101541415611add5760009150611b53565b806002015484111515611af35760009150611b53565b828160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555083816002018190555084816001018190555060019150611b53565b5b5b509392505050565b6000600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a6a50212836000600481101515611baa57fe5b60200201516000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b1515611c3257fe5b6102c65a03f11515611c4057fe5b505050604051805190508015611d865750600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f459f5a2836000600481101515611c9e57fe5b6020020151846001600481101515611cb257fe5b60200201516000604051602001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050602060405180830381600087803b1515611d6d57fe5b6102c65a03f11515611d7b57fe5b505050604051805190505b8015611e7b5750600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a6a50212836002600481101515611dda57fe5b60200201516000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b1515611e6257fe5b6102c65a03f11515611e7057fe5b505050604051805190505b8015611fb75750600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f459f5a2836002600481101515611ecf57fe5b6020020151846003600481101515611ee357fe5b60200201516000604051602001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200192505050602060405180830381600087803b1515611f9e57fe5b6102c65a03f11515611fac57fe5b505050604051805190505b15611fc55760019050611fca565b600090505b919050565b6000600082518451141515611fe7576000915061210c565b600090505b835181101561210757828181518110151561200357fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916848281518110151561207e57fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f0100000000000000000000000000000000000000000000000000000000000000027effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff19161415156120fb576000915061210c565b5b806001019050611fec565b600191505b5092915050565b600086600160048110151561212457fe5b602002015173ffffffffffffffffffffffffffffffffffffffff166123da88600060048110151561215157fe5b602002015189600160048110151561216557fe5b60200201518a600260048110151561217957fe5b60200201518b600360048110151561218d57fe5b60200201518b8b8b8a604051808973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c0100000000000000000000000002815260140184805190602001908083835b6020831061230e57805182526020820191506020810190506020830392506122eb565b6001836020036101000a03801982511681845116808217855250505050505090500183805190602001908083835b6020831061235f578051825260208201915060208101905060208303925061233c565b6001836020036101000a0380198251168184511680821785525050505050509050018280519060200190602002808383600083146123bc575b8051825260208311156123bc57602082019150602081019050602083039250612398565b505050905001985050505050505050506040518091039020856118f0565b73ffffffffffffffffffffffffffffffffffffffff161490505b9695505050505050565b6000600061240a612b45565b6124148585610a82565b8092508193505050811515612517577f175646cbe010191a0c6d5416dacddc31b31295ba0737069ac6fc1ad88f9454bb33600083604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183151515158152602001806020018281038252838181518152602001915080519060200190808383600083146124d3575b8051825260208311156124d3576020820191506020810190506020830392506124af565b505050905090810190601f1680156124ff5780820380516001836020036101000a031916815260200191505b5094505050505060405180910390a16000925061251c565b600192505b505092915050565b6000600060006000600260008b600160048110151561253f57fe5b602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002092508260040160008b600360048110151561259557fe5b602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002091508260020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600560006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600560009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663e609206e8b8b8b8b8760020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168c8c6000604051602001526040518863ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018088600460200280838360008314612712575b805182526020831115612712576020820191506020810190506020830392506126ee565b5050509050018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001806020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001806020018060200185810385528a8181518152602001915080519060200190808383600083146127d3575b8051825260208311156127d3576020820191506020810190506020830392506127af565b505050905090810190601f1680156127ff5780820380516001836020036101000a031916815260200191505b50858103845289818151815260200191508051906020019080838360008314612847575b80518252602083111561284757602082019150602081019050602083039250612823565b505050905090810190601f1680156128735780820380516001836020036101000a031916815260200191505b508581038352878181518152602001915080519060200190602002808383600083146128be575b8051825260208311156128be5760208201915060208101905060208303925061289a565b50505090500185810382528681815181526020019150805190602001906020028083836000831461290e575b80518252602083111561290e576020820191506020810190506020830392506128ea565b5050509050019b505050505050505050505050602060405180830381600087803b151561293757fe5b6102c65a03f1151561294557fe5b505050604051805190509050801515612a0a577f175646cbe010191a0c6d5416dacddc31b31295ba0737069ac6fc1ad88f9454bb336000604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260188152602001807fe8b083e794a8e88194e58aa8e8a784e58899e5a4b1e8b4a50000000000000000815250602001935050505060405180910390a160009350612ab8565b7f175646cbe010191a0c6d5416dacddc31b31295ba0737069ac6fc1ad88f9454bb336001604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018215151515815260200180602001828103825260188152602001807fe8b083e794a8e88194e58aa8e8a784e58899e68890e58a9f0000000000000000815250602001935050505060405180910390a1600193505b5050509695505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10612b0657803560ff1916838001178555612b34565b82800160010185558215612b34579182015b82811115612b33578235825591602001919060010190612b18565b5b509050612b419190612b6d565b5090565b602060405190810160405280600081525090565b602060405190810160405280600081525090565b612b8f91905b80821115612b8b576000816000905550600101612b73565b5090565b905600a165627a7a723058202b84173c635753ff33b749760a69d2163b5bb71685369cf7ea68872e76c3ed7a0029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"attrType\",\"type\":\"string\"},{\"name\":\"ruleAddr\",\"type\":\"address\"},{\"name\":\"trustAddr\",\"type\":\"address\"},{\"name\":\"sig\",\"type\":\"bytes32[]\"},{\"name\":\"nounceAndtimestamp\",\"type\":\"uint256[]\"}],\"name\":\"addUserSceneRule\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"attrType\",\"type\":\"string\"}],\"name\":\"checkUserSceneRule\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"},{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"addr4\",\"type\":\"address[4]\"},{\"name\":\"userSceneRuleAddr\",\"type\":\"address\"},{\"name\":\"attrType\",\"type\":\"string\"},{\"name\":\"attrState\",\"type\":\"string\"},{\"name\":\"sig\",\"type\":\"bytes32[]\"},{\"name\":\"nounceAndtimestamp\",\"type\":\"uint256[]\"}],\"name\":\"userSceneRule\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"type\":\"function\"},{\"inputs\":[{\"name\":\"user\",\"type\":\"address\"},{\"name\":\"consAddr\",\"type\":\"address\"}],\"payable\":false,\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"addUserSceneRuleEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"sender\",\"type\":\"address\"},{\"indexed\":false,\"name\":\"result\",\"type\":\"bool\"},{\"indexed\":false,\"name\":\"message\",\"type\":\"string\"}],\"name\":\"userSceneRuleEvent\",\"type\":\"event\"}]";

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

    public Future<TransactionReceipt> addUserSceneRule(StaticArray<Address> addr4, Utf8String attrType, Address ruleAddr, Address trustAddr, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp) {
        Function function = new Function("addUserSceneRule", Arrays.<Type>asList(addr4, attrType, ruleAddr, trustAddr, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void addUserSceneRule(StaticArray<Address> addr4, Utf8String attrType, Address ruleAddr, Address trustAddr, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp, TransactionSucCallback callback) {
        Function function = new Function("addUserSceneRule", Arrays.<Type>asList(addr4, attrType, ruleAddr, trustAddr, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<List<Type>> checkUserSceneRule(StaticArray<Address> addr4, Utf8String attrType) {
        Function function = new Function("checkUserSceneRule", 
                Arrays.<Type>asList(addr4, attrType), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Utf8String>() {}));
        return executeCallMultipleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> userSceneRule(StaticArray<Address> addr4, Address userSceneRuleAddr, Utf8String attrType, Utf8String attrState, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp) {
        Function function = new Function("userSceneRule", Arrays.<Type>asList(addr4, userSceneRuleAddr, attrType, attrState, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void userSceneRule(StaticArray<Address> addr4, Address userSceneRuleAddr, Utf8String attrType, Utf8String attrState, DynamicArray<Bytes32> sig, DynamicArray<Uint256> nounceAndtimestamp, TransactionSucCallback callback) {
        Function function = new Function("userSceneRule", Arrays.<Type>asList(addr4, userSceneRuleAddr, attrType, attrState, sig, nounceAndtimestamp), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public static Future<UserSceneRule> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Address user, Address consAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(user, consAddr));
        return deployAsync(UserSceneRule.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static Future<UserSceneRule> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Address user, Address consAddr) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(user, consAddr));
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
