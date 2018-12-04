package main;

import org.bcos.channel.client.Service;
import org.bcos.web3j.abi.datatypes.*;
import org.bcos.web3j.abi.datatypes.generated.Bytes32;
import org.bcos.web3j.abi.datatypes.generated.Int256;
import org.bcos.web3j.abi.datatypes.generated.Uint256;
import org.bcos.web3j.abi.datatypes.generated.Uint8;
import org.bcos.web3j.crypto.Credentials;
import org.bcos.web3j.crypto.ECKeyPair;
import org.bcos.web3j.crypto.Keys;
import org.bcos.web3j.protocol.Web3j;
import org.bcos.web3j.protocol.channel.ChannelEthereumService;
import org.bcos.web3j.protocol.core.methods.response.EthBlockNumber;
import org.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.bcos.web3j.utils.Numeric;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.*;

import java.math.BigInteger;
import java.security.SignatureException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static main.tryTest.packageParams;
import static main.tryTest.signParams;

public class mainTest {
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
    private static String trustRuleAddr_1;//平台1
    private static String trustRuleAddr_2;//平台2
    private static String userSceneRuleAddr;

    // 成员地址
    public static String userAddr = "0x24602722816b6cad0e143ce9fabf31f6026ec622";//用户地址
    private static String deviceAddr_1 = "0xcd2a3d9f938e13cd947ec05abc7fe734df8dd826";//设备1地址
    private static String deviceAddr_2 = "0xf8514b2da9da74903f409bfd6f9a7fc2aa056c93";//设备2地址
    private static String platAddr_1 = "0x1b8cBBf72D2260079c01fd622b284Ed2FBf972A0"; //平台1地址
    private static String platAddr_2 = "0xeA02218208eC9489267De43D4AF2398d7f1BfF88"; //平台2地址
    private static StaticArray<Address> addr4 = new StaticArray<>(new Address(platAddr_1), new Address(deviceAddr_1), new Address(platAddr_2), new Address(deviceAddr_2));

    private static String attrType = "属性1"; //设置属性
    private static String attrState = "打开"; //设置状态

    /* 部署合约 */
    private static void deploy(String opCode) throws InterruptedException, ExecutionException {
        String contractName = "";
        String contractAddr = "";
        switch (opCode) {
            case "LinkageRule":
                Future<LinkageRule> linakgeRuleDeploy = LinkageRule.deploy(web3j, credentials, gasPrice, gasLimit, initialWeiValue, new Address(registerAddr));
                LinkageRule linkageRule = linakgeRuleDeploy.get();
                contractName = "linkageRuleAddr";
                contractAddr = linkageRule.getContractAddress();
                linkageRuleAddr = contractAddr;
                break;
            case "Register":
                Future<Register> registerDeploy = Register.deploy(web3j, credentials, gasPrice, gasLimit, initialWeiValue);
                Register register = registerDeploy.get();
                contractName = "registerAddr";
                contractAddr = register.getContractAddress();
                registerAddr = contractAddr;
                break;
            case "TrustRule_1":
                Future<TrustRule> trustRuleDeploy = TrustRule.deploy(web3j, credentials, gasPrice, gasLimit, initialWeiValue, new Address(registerAddr));
                TrustRule trustRule = trustRuleDeploy.get();
                contractName = "trustRuleAddr_1";
                contractAddr = trustRule.getContractAddress();
                trustRuleAddr_1 = contractAddr;
                break;
            case "TrustRule_2":
                Future<TrustRule> trustRuleDeploy_2 = TrustRule.deploy(web3j, credentials, gasPrice, gasLimit, initialWeiValue, new Address(registerAddr));
                TrustRule trustRule_2 = trustRuleDeploy_2.get();
                contractName = "trustRuleAddr_2";
                contractAddr = trustRule_2.getContractAddress();
                trustRuleAddr_2 = contractAddr;
                break;
            case "UserSceneRule":
                Future<UserSceneRule> userSceneRuleDeploy = UserSceneRule.deploy(web3j, credentials, gasPrice, gasLimit, initialWeiValue, new Address(registerAddr));
                UserSceneRule userSceneRule = userSceneRuleDeploy.get();
                contractName = "userSceneRuleAddr";
                contractAddr = userSceneRule.getContractAddress();
                userSceneRuleAddr = contractAddr;
                break;
        }
        System.out.println(contractName + " = \"" + contractAddr + "\";");
    }

    public static void signTest() throws SignatureException, ExecutionException, InterruptedException {
        //生成参数
        String privateKey = "5a0b841d73c934df67fca222ba8446f9915b2834a77bc128499d7dc1d565ea99";
        String address = "0fa358fb1384e326e7806ca900aad405b8a51657";
        ECKeyPair keyPair = ECKeyPair.create(new BigInteger(privateKey, 16));
        //使用keccak256打包参数
        String[] testAddress = new String[]{platAddr_1, platAddr_2};
        String[] testTypes = new String[]{attrType, attrState};
        byte[] packageResult = packageParams(testAddress, testTypes); //将参数打包
        String strPackage = Numeric.toHexString(packageResult); //转换成16进制字符串, 与solidity测试结果相同
        System.out.println("PackageResult in HexString: " + strPackage);
        DynamicArray<Bytes32> tmp = signParams(strPackage, keyPair);// Byte32 [] 直接传给合约
        // 调用链码
        Register register = Register.load(registerAddr, web3j, credentials, gasPrice, gasLimit);
        Future<List<Type>> result = register.test(new Address(platAddr_1), new Address(platAddr_2), new Utf8String(attrType), new Utf8String(attrState), tmp, new Address(address));
        System.out.println("params参数: " + result.get().get(0));
        System.out.println("检测结果: " + result.get().get(1).getValue());
    }

    /* 注册合约测试 */
    // 都使用get()方法同步执行
    public static void registerTest() throws ExecutionException, InterruptedException {
        Register register = Register.load(registerAddr, web3j, credentials, gasPrice, gasLimit);
        //平台1注册
        TransactionReceipt platformRegister = register.platformRegister(new Address(platAddr_1)).get();
        List<Register.PlatformRegisterEventEventResponse> lstCN = Register.getPlatformRegisterEventEvents(platformRegister);
        for (int i = 0; i < lstCN.size(); i++) {
            Register.PlatformRegisterEventEventResponse response = lstCN.get(i);
            System.out.println("平台1 注册事件返回:" + response.message.getValue());
        }
        Future<Bool> result1 = register.checkPlatformRegister(new Address(platAddr_1));
        System.out.println("查询平台1 注册查询结果:" + result1.get().getValue());
        //平台2注册
        register.platformRegister(new Address(platAddr_2)).get();
        Future<Bool> result2 = register.checkPlatformRegister(new Address(platAddr_2));
        System.out.println("查询平台2 注册结果:" + result2.get().getValue());
        //设备1注册
        register.devicesRegister(new Address(platAddr_1), new Address(deviceAddr_1)).get();
        Future<Bool> result3 = register.checkDeviceRegister(new Address(platAddr_1), new Address(deviceAddr_1));
        System.out.println("查询设备1 注册结果:" + result3.get().getValue());
        //设备1添加属性
        register.devicesSetAttr(new Address(platAddr_1), new Address(deviceAddr_1), new Utf8String("属性1"), new Utf8String("关闭")).get();
        //用户1注册
        register.userRegister(new Address(userAddr)).get();
        Future<Bool> result4 = register.checkUserRegister(new Address(userAddr));
        System.out.println("用户1 注册结果:" + result4.get().getValue());
        //设备2注册
        TransactionReceipt deviceRegister = register.devicesRegister(new Address(platAddr_2), new Address(deviceAddr_2)).get();
        List<Register.DevicesRegisterEventEventResponse> lstCN2 = Register.getDevicesRegisterEventEvents(deviceRegister);
        for (int i = 0; i < lstCN2.size(); i++) {
            Register.DevicesRegisterEventEventResponse response = lstCN2.get(i);
            System.out.println("设备2 注册事件返回:" + response.message.getValue());
        }
        Future<Bool> result5 = register.checkDeviceRegister(new Address(platAddr_2), new Address(deviceAddr_2));
        System.out.println("查询设备2 注册结果:" + result5.get().getValue());
        //设备2属性
        register.devicesSetAttr(new Address(platAddr_2), new Address(deviceAddr_2), new Utf8String("属性2"), new Utf8String("关闭"));
    }

    /* 信任规则合约测试 都使用同步阻塞方式*/
    public static void trustRuleTest() throws ExecutionException, InterruptedException {
        // 平台1部署信任规则合约
        TrustRule trustRule = TrustRule.load(trustRuleAddr_1, web3j, credentials, gasPrice, gasLimit);
        // 平台1设置信任值
        TransactionReceipt setTrustThreshold = trustRule.setTrustThreshold(new Int256(50)).get();
        List<TrustRule.SetTrustThresholdEventEventResponse> lstCN = TrustRule.getSetTrustThresholdEventEvents(setTrustThreshold);
        for (int i = 0; i < lstCN.size(); i++) {
            TrustRule.SetTrustThresholdEventEventResponse response = lstCN.get(i);
            System.out.println("设置信任值 事件返回:" + response.message.getValue());
        }
        // 平台1添加信任设备1
        TransactionReceipt setDevices = trustRule.setDevices(new Address(deviceAddr_1), new Int256(100), new Uint8(0)).get();
        List<TrustRule.SetDevicesEventEventResponse> lstCN2 = TrustRule.getSetDevicesEventEvents(setDevices);
        for (int i = 0; i < lstCN2.size(); i++) {
            TrustRule.SetDevicesEventEventResponse response = lstCN2.get(i);
            System.out.println("添加信任设备1 事件返回:" + response.message.getValue());
        }
        // 检查注册
        Future<List<Type>> result_1 = trustRule.trustRuleJudgePackage(new Address(platAddr_1), new Address(deviceAddr_1));
        System.out.println("查询信任设备1 结果:" + result_1.get().get(1).getValue());
        // 平台2部署信任规则合约
        // 平台2设置信任规则合约\信任值\添加设备2
        TrustRule trustRule_2 = TrustRule.load(trustRuleAddr_2, web3j, credentials, gasPrice, gasLimit);
        trustRule_2.setTrustThreshold(new Int256(50)).get();
        trustRule.setDevices(new Address(deviceAddr_2), new Int256(100), new Uint8(0)).get();
    }

    /* 用户规则合约测试 */
    public static void userSceneRuleTest() throws ExecutionException, InterruptedException {
        // 获取用户1场景规则合约
        UserSceneRule userSceneRule = UserSceneRule.load(userSceneRuleAddr, web3j, credentials, gasPrice, gasLimit);
        // 添加用户场景
        TransactionReceipt addUserSceneRule = userSceneRule.addUserSceneRule(addr4, new Utf8String("属性1"), new Address(linkageRuleAddr), new Address(trustRuleAddr_1)).get();
        List<UserSceneRule.AddUserSceneRuleEventEventResponse> lstCN1 = UserSceneRule.getAddUserSceneRuleEventEvents(addUserSceneRule);
        for (int i = 0; i < lstCN1.size(); i++) {
            UserSceneRule.AddUserSceneRuleEventEventResponse response = lstCN1.get(i);
            System.out.println("添加用户场景 事件返回:" + response.message.getValue());
        }
        // 检查用户规则是否存在
        Future<List<Type>> result_1 = userSceneRule.checkUserSceneRule(addr4, new Utf8String("属性1"));
        System.out.println("检查用户规则 添加结果:" + result_1.get().get(1).getValue());
    }

    /* 联动规则合约测试 */
    public static void linkageRuleTest() throws ExecutionException, InterruptedException {
        // 获取平台1联动规则合约
        LinkageRule linkageRule = LinkageRule.load(linkageRuleAddr, web3j, credentials, gasPrice, gasLimit);
        // 设置联动规则
        TransactionReceipt addUserSceneRule = linkageRule.addLinkageRule(addr4, new Utf8String("属性1")).get();
        List<LinkageRule.AddLinkageRuleEventEventResponse> lstCN1 = LinkageRule.getAddLinkageRuleEventEvents(addUserSceneRule);
        for (int i = 0; i < lstCN1.size(); i++) {
            LinkageRule.AddLinkageRuleEventEventResponse response = lstCN1.get(i);
            System.out.println("添加用户场景 事件返回:" + response.message.getValue());
        }
        // 检查联动规则
        Future<List<Type>> result_1 = linkageRule.checkLinkageRule(addr4, new Utf8String("属性1"));
        System.out.println("检查用户规则 添加结果:" + result_1.get().get(1).getValue());
    }

    /* 联动测试 */
    public static void transactionTest() throws ExecutionException, InterruptedException {
        TrustRule trustRule = TrustRule.load(trustRuleAddr_1, web3j, credentials, gasPrice, gasLimit);
        // 通过平台1部署的信任规则合约发起交易

        TransactionReceipt startLinking = trustRule.startLinking(addr4, new Utf8String("属性1"), new Utf8String("打开"), new Address(userSceneRuleAddr)).get();
        List<LinkageRule.LinkageRuleEventEventResponse> lstCN1 = LinkageRule.getLinkageRuleEventEvents(startLinking);
        for (int i = 0; i < lstCN1.size(); i++) {
            LinkageRule.LinkageRuleEventEventResponse response = lstCN1.get(i);
            System.out.println("添加用户场景 事件返回:" + response.message.getValue());
        }
        // 查询交易记录
        LinkageRule linkageRule = LinkageRule.load(linkageRuleAddr, web3j, credentials, gasPrice, gasLimit);
        Future<List<Type>> result_1 = linkageRule.queryRecord(new Uint256(0));
        System.out.println("检查联动记录 联动平台:" + result_1.get().get(0));
        System.out.println("检查联动记录 联动设备:" + result_1.get().get(1));
        System.out.println("检查联动记录 控制平台:" + result_1.get().get(2));
        System.out.println("检查联动记录 控制设备:" + result_1.get().get(3));
        System.out.println("检查联动记录 控制属性:" + result_1.get().get(4).getValue());
        System.out.println("检查联动记录 控制状态:" + result_1.get().get(5).getValue());
        System.out.println("检查联动记录 ID:" + result_1.get().get(6).getValue());
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

        deployer();
        signTest();
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

    /* 集中部署 */
    static void deployer() throws ExecutionException, InterruptedException {
        deploy("Register");
//        deploy("TrustRule_1");
//        deploy("TrustRule_2");
//        deploy("LinkageRule");
//        deploy("UserSceneRule");
    }

}
