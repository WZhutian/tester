package main;

import example.bcosliteclient;
import org.bcos.channel.client.Service;
import org.bcos.channel.client.TransactionSucCallback;
import org.bcos.channel.dto.EthereumResponse;
import org.bcos.web3j.abi.datatypes.Address;
import org.bcos.web3j.abi.datatypes.StaticArray;
import org.bcos.web3j.abi.datatypes.Utf8String;
import org.bcos.web3j.abi.datatypes.generated.Int256;
import org.bcos.web3j.abi.datatypes.generated.Uint256;
import org.bcos.web3j.abi.datatypes.generated.Uint8;
import org.bcos.web3j.crypto.Credentials;
import org.bcos.web3j.crypto.ECKeyPair;
import org.bcos.web3j.crypto.Keys;
import org.bcos.web3j.protocol.Web3j;
import org.bcos.web3j.protocol.channel.ChannelEthereumService;
import org.bcos.web3j.protocol.core.methods.response.EthBlockNumber;
import org.bcos.web3j.protocol.core.methods.response.Log;
import org.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.*;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class mainTest {
    static Logger logger = LoggerFactory.getLogger(bcosliteclient.class);
    public static Web3j web3j;
    // 初始化交易参数
    private static java.math.BigInteger gasPrice = new BigInteger("1");
    private static java.math.BigInteger gasLimit = new BigInteger("30000000");
    private static java.math.BigInteger initialWeiValue = new BigInteger("0");
    private static ECKeyPair keyPair;
    private static Credentials credentials;
    // 合约地址
    private static String linkageRuleAddr;
    private static String registerAddr;
    private static String toolsAddr;
    private static String trustRuleAddr_1;//平台1
    private static String trustRuleAddr_2;//平台2
    private static String userSceneRuleAddr;

    // 成员地址
    public static String userAddr = "0x24602722816b6cad0e143ce9fabf31f6026ec622";//用户地址
    private static String deviceAddr_1 = "0xcd2a3d9f938e13cd947ec05abc7fe734df8dd826";//设备1地址
    private static String deviceAddr_2 = "0x8F3732276ed0f1B9fEB7A66bC3565aFB4A45FEAa";//设备2地址
    private static String platAddr_1 = "0x1b8cBBf72D2260079c01fd622b284Ed2FBf972A0"; //平台1地址
    private static String platAddr_2 = "0xeA02218208eC9489267De43D4AF2398d7f1BfF88"; //平台2地址
    private static StaticArray<Address> addr4 = new StaticArray<>(new Address(platAddr_1),new Address(deviceAddr_1),new Address(platAddr_2),new Address(deviceAddr_2));
    /* 部署合约 */
    private static void deploy(String opCode) throws InterruptedException, ExecutionException {
        String contractName = "";
        String contractAddr = "";
        switch (opCode) {
            case "LinkageRule":
                Future<LinkageRule> linakgeRuleDeploy = LinkageRule.deploy(web3j, credentials, gasPrice, gasLimit, initialWeiValue);
                LinkageRule linkageRule = linakgeRuleDeploy.get();
                contractName = linkageRule.getContractName();
                contractAddr = linkageRule.getContractAddress();
                linkageRuleAddr = contractAddr;
                break;
            case "Register":
                Future<Register> registerDeploy = Register.deploy(web3j, credentials, gasPrice, gasLimit, initialWeiValue);
                Register register = registerDeploy.get();
                contractName = register.getContractName();
                contractAddr = register.getContractAddress();
                registerAddr = contractAddr;
                break;
            case "Tools":
                Future<Tools> toolsDeploy = Tools.deploy(web3j, credentials, gasPrice, gasLimit, initialWeiValue);
                Tools tools = toolsDeploy.get();
                contractName = tools.getContractName();
                contractAddr = tools.getContractAddress();
                toolsAddr = contractAddr;
                break;
            case "TrustRule_1":
                Future<TrustRule> trustRuleDeploy = TrustRule.deploy(web3j, credentials, gasPrice, gasLimit, initialWeiValue, new Address(registerAddr));
                TrustRule trustRule = trustRuleDeploy.get();
                contractName = trustRule.getContractName();
                contractAddr = trustRule.getContractAddress();
                trustRuleAddr_1 = contractAddr;
                break;
            case "TrustRule_2":
                Future<TrustRule> trustRuleDeploy_2 = TrustRule.deploy(web3j, credentials, gasPrice, gasLimit, initialWeiValue, new Address(registerAddr));
                TrustRule trustRule_2 = trustRuleDeploy_2.get();
                contractName = trustRule_2.getContractName();
                contractAddr = trustRule_2.getContractAddress();
                trustRuleAddr_2 = contractAddr;
                break;
            case "UserSceneRule":
                Future<UserSceneRule> userSceneRuleDeploy = UserSceneRule.deploy(web3j, credentials, gasPrice, gasLimit, initialWeiValue, new Address(registerAddr));
                UserSceneRule userSceneRule = userSceneRuleDeploy.get();
                contractName = userSceneRule.getContractName();
                contractAddr = userSceneRule.getContractAddress();
                userSceneRuleAddr = contractAddr;
                break;
        }
        System.out.println("Deploy contract :" + contractName + ",address :" + registerAddr);
    }

    /* 注册合约测试 */
    public static void registerTest() throws ExecutionException, InterruptedException {
        deploy("Register");
        Register register = Register.load(registerAddr, web3j, credentials, gasPrice, gasLimit);
        //平台1注册
//        register.platformRegister(new Address(platAddr_1));
//        Future<TransactionReceipt> result = register.checkRegister(new Address(platAddr_1),new Uint8(2),new Address(platAddr_1));
//        TransactionReceipt res = result.get();
//        System.out.println(result.get());
//        //平台2注册
//        register.platformRegister(new Address(platAddr_2));
//        register.checkRegister(new Address(platAddr_2),new Uint8(2),new Address(""));
//        //设备1注册
//        register.devicesRegister(new Address(platAddr_1), new Address(deviceAddr_1));
//        register.checkRegister(new Address(deviceAddr_1),new Uint8(1),new Address(platAddr_1));
//        //设备1属性
//        register.devicesSetAttr(new Address(platAddr_1), new Address(deviceAddr_1), new Utf8String("属性1"), new Utf8String("关闭"));
//        //用户1注册
//        register.userRegister(new Address(userAddr));
//        register.checkRegister(new Address(userAddr),new Uint8(0),new Address(""));
//        //设备2注册
//        register.devicesRegister(new Address(platAddr_2), new Address(deviceAddr_2));
//        register.checkRegister(new Address(deviceAddr_2),new Uint8(1),new Address(platAddr_2));
//        //设备2属性
//        register.devicesSetAttr(new Address(platAddr_2), new Address(deviceAddr_2), new Utf8String("属性2"), new Utf8String("关闭"));
    }

    /* 信任规则合约测试 */
    public static void trustRuleTest() throws ExecutionException, InterruptedException {
        // 平台1部署信任规则合约
        deploy("TrustRule_1");
        TrustRule trustRule = TrustRule.load(trustRuleAddr_1, web3j, credentials, gasPrice, gasLimit);
        // 平台1设置信任值
        trustRule.setTrustThreshold(new Int256(50));
        // 平台1添加信任设备1
        trustRule.setDevices(new Address(deviceAddr_1), new Int256(100), new Uint8(0));
        // 检查注册
        Future<TransactionReceipt> result_1 = trustRule.trustRuleJudge(new Address(platAddr_1), new Address(deviceAddr_1));
        System.out.println(result_1.get().getLogs());
        // 平台2部署信任规则合约
        deploy("TrustRule_2");
        // 平台2设置信任规则合约\信任值\添加设备2
        TrustRule trustRule_2 = TrustRule.load(trustRuleAddr_2, web3j, credentials, gasPrice, gasLimit);
        trustRule_2.setTrustThreshold(new Int256(50));
        trustRule.setDevices(new Address(deviceAddr_2), new Int256(100), new Uint8(0));
    }

    /* 用户规则合约测试 */
    public static void userSceneRuleTest() throws ExecutionException, InterruptedException {
        // 用户1部署用户场景规则合约
        deploy("UserSceneRule");
        UserSceneRule userSceneRule = UserSceneRule.load(userSceneRuleAddr, web3j, credentials, gasPrice, gasLimit);
        // 添加用户场景
        userSceneRule.addUserSceneRule(addr4,new Utf8String("属性1"),new Address(linkageRuleAddr),new Address(trustRuleAddr_1));
        // 检查用户规则是否存在
//        Future<TransactionReceipt> result_1 = userSceneRule.checkUserSceneRule(addr4,new Utf8String("属性1"));
//        result_1.get().getLogs();
    }

    /* 联动规则合约测试 */
    public static void linkageRuleTest() throws ExecutionException, InterruptedException {
        // 平台1部署联动规则合约
        deploy("LinkageRule");
        LinkageRule linkageRule = LinkageRule.load(linkageRuleAddr, web3j, credentials, gasPrice, gasLimit);
        // 设置联动规则
        linkageRule.addLinkageRule(addr4, new Utf8String("属性1"));
        // 检查联动规则
//        Future<TransactionReceipt> result_1 = linkageRule.checkLinkageRule(addr4,new Utf8String("属性1"));
//        result_1.get().getLogs();
    }

    /* 联动测试 */
    public static void transactionTest() throws ExecutionException, InterruptedException {
        // 通过平台1部署的信任规则合约发起交易
        TrustRule trustRule = TrustRule.load(trustRuleAddr_1, web3j, credentials, gasPrice, gasLimit);
        Future<TransactionReceipt> result_1 = trustRule.startLinking(addr4, new Utf8String("属性1"), new Utf8String("打开"), new Address(userSceneRuleAddr));
        // 查询交易记录 TODO
        String hash = result_1.get().getTransactionHash();
        LinkageRule linkageRule = LinkageRule.load(linkageRuleAddr, web3j, credentials, gasPrice, gasLimit);
        linkageRule.queryRecord(new Uint256(Long.parseLong(hash)));
    }

    public static void main(String[] args) throws Exception {

        // init the Service
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Service service = context.getBean(Service.class);
        service.run(); // run the daemon service
        // init the client keys
        keyPair = Keys.createEcKeyPair();
        credentials = Credentials.create(keyPair);

        System.out.println("-----> start test !");
        System.out.println("init AOMP ChannelEthereumService");
        ChannelEthereumService channelEthereumService = new ChannelEthereumService();
        channelEthereumService.setChannelService(service);

        // init webj client base on channelEthereumService
        web3j = Web3j.build(channelEthereumService);
        /*------------------init done start test--------------------------------*/

        // test get blocknumber,just optional steps

        EthBlockNumber ethBlockNumber = web3j.ethBlockNumber().sendAsync().get();
        int startBlockNumber = ethBlockNumber.getBlockNumber().intValue();
        System.out.println("-->Got ethBlockNumber: " + startBlockNumber);


        /* 测试流程 */
        // 0.工具合约部署
        // 1.平台1注册 平台2注册 设备1注册 设置设备1属性 用户1注册 (设备2注册 设备2解注册) Register
        // 2.平台1部署信任规则合约 设置信任规则合约 检查注册 TrustRule
        //    2.1 平台2部署信任规则合约 设置信任规则合约
        // 3.用户1部署用户场景规则合约 添加用户场景 检查用户规则 UserSceneRule
        // 4.平台1部署联动规则合约  设置联动规则 检查联动规则 LinkageRule
        // 5.通过平台1部署的信任规则合约发起交易 查询交易记录

//        deploy("Tools");
//        registerTest();
//        trustRuleTest();
//        userSceneRuleTest();
//        linkageRuleTest();
//        transactionTest();

        /* 打印区块数量 */
        ethBlockNumber = web3j.ethBlockNumber().sendAsync().get();
        int finishBlockNumber = ethBlockNumber.getBlockNumber().intValue();
        System.out.println("<--start blockNumber = " + startBlockNumber + ",finish blocknmber=" + finishBlockNumber);
        System.exit(0);
    }

}
