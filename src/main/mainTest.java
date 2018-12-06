package main;

import org.bcos.channel.client.Service;
import org.bcos.contract.source.UserCheck;
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

import static main.tryTest.getNounceAndTimeStamp;
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

    // 成员地址与私钥
    private static String userAddr = "0xe982dcd5069bc0d5c907e1d67a114881b89548cd";//用户地址
    private static String userPrivateKey = "bf4e4e1c5ca30a2d6797679cadf1ce40c0b0caa088bf43fd4e41f66213ef7a69";//用户私钥
    private static String deviceAddr_1 = "0xb5ebbfb60bb71c1070cef93e6023ed7d1b1e8002";//设备1地址
    private static String deviceAddr_1_PrivateKey = "f38259b50b6a4a447dde6999480a5308b26ef9bb9ff8d2699af737834308561d";//设备1私钥
    private static String deviceAddr_2 = "0xba2691455bf7aad385c754f333573570e5691673";//设备2地址
    private static String deviceAddr_2_PrivateKey = "336b34bd229f65818f6795567938fdd61d889c14d6c4f4858eb7b5ecab1ba3ca";//设备2私钥
    private static String platAddr_1 = "0x399bbb50e1b9b5b4623025a1203d70010d8f2763"; //平台1地址
    private static String platAddr_1_PrivateKey = "e2668140273281d2d8fd10ee8b4ced9e2dbef3a17b457083736e3590e572c85f";//平台1私钥
    private static String platAddr_2 = "0xc7bfe6df9535c7ade65c4536e115cfb8a6ed69d5"; //平台2地址
    private static String platAddr_2_PrivateKey = "5b670b973c3eb1f0896b3001eeb78cabe6127222dc30a6735d06b347136f2edf";//平台2私钥
    // 常用参数
    private static StaticArray<Address> addr4 = new StaticArray<>(new Address(platAddr_1), new Address(deviceAddr_1), new Address(platAddr_2), new Address(deviceAddr_2));
    private static String attrType = "属性1"; //设置属性
    private static String attrState = "打开"; //设置状态

    /* 部署合约 */
    private static void deploy(String opCode) throws InterruptedException, ExecutionException {
        String contractName = "";
        String contractAddr = "";
        switch (opCode) {
            case "LinkageRule":
                Future<LinkageRule> linakgeRuleDeploy = LinkageRule.deploy(web3j, credentials, gasPrice, gasLimit, initialWeiValue, new Address(platAddr_1), new Address(registerAddr));
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
                Future<TrustRule> trustRuleDeploy = TrustRule.deploy(web3j, credentials, gasPrice, gasLimit, initialWeiValue, new Address(platAddr_1), new Address(registerAddr));
                TrustRule trustRule = trustRuleDeploy.get();
                contractName = "trustRuleAddr_1";
                contractAddr = trustRule.getContractAddress();
                trustRuleAddr_1 = contractAddr;
                break;
            case "TrustRule_2":
                Future<TrustRule> trustRuleDeploy_2 = TrustRule.deploy(web3j, credentials, gasPrice, gasLimit, initialWeiValue, new Address(platAddr_2), new Address(registerAddr));
                TrustRule trustRule_2 = trustRuleDeploy_2.get();
                contractName = "trustRuleAddr_2";
                contractAddr = trustRule_2.getContractAddress();
                trustRuleAddr_2 = contractAddr;
                break;
            case "UserSceneRule":
                Future<UserSceneRule> userSceneRuleDeploy = UserSceneRule.deploy(web3j, credentials, gasPrice, gasLimit, initialWeiValue, new Address(userAddr), new Address(registerAddr));
                UserSceneRule userSceneRule = userSceneRuleDeploy.get();
                contractName = "userSceneRuleAddr";
                contractAddr = userSceneRule.getContractAddress();
                userSceneRuleAddr = contractAddr;
                break;
        }
        System.out.println(contractName + " = \"" + contractAddr + "\";");
    }

    // 重放攻击测试
    public static void signTest() throws SignatureException, ExecutionException, InterruptedException {
        //生成参数
        String privateKey = "5a0b841d73c934df67fca222ba8446f9915b2834a77bc128499d7dc1d565ea99";
//        privateKey = userPrivateKey;
        String address = "0x0fa358fb1384e326e7806ca900aad405b8a51657";
//        address = userAddr;
        ECKeyPair keyPair = ECKeyPair.create(new BigInteger(privateKey, 16));
        //使用keccak256打包参数
        String[] testAddress = new String[]{platAddr_1, deviceAddr_1, platAddr_2, deviceAddr_2, address};
        String[] testTypes = new String[]{attrType, attrState};
        long[] testNTS = getNounceAndTimeStamp();
        byte[] packageResult = packageParams(testAddress, testTypes, testNTS); //将参数打包
        String strPackage = Numeric.toHexString(packageResult); //转换成16进制字符串, 与solidity测试结果相同
//        System.out.println("PackageResult in HexString: " + strPackage);
        DynamicArray<Bytes32> signResult = signParams(strPackage, keyPair);// Byte32 [] 直接传给合约
        DynamicArray<Uint256> nounceResult = new DynamicArray<>(new Uint256(testNTS[0]), new Uint256(testNTS[1]));
        // 测试1 普通调用
        Register register = Register.load(registerAddr, web3j, credentials, gasPrice, gasLimit);
        TransactionReceipt test1 = register.test(addr4, new Address(address), new Utf8String(attrType), new Utf8String(attrState), signResult, nounceResult).get();
        for (Register.DeviceUnRegisterEventEventResponse response : Register.getDeviceUnRegisterEventEvents(test1)) {
            System.out.println("测试1结果返回:" + response.message.getValue());
        }
        // 测试2 重放
        TransactionReceipt test2 = register.test(addr4, new Address(address), new Utf8String(attrType), new Utf8String(attrState), signResult, nounceResult).get();
        for (Register.DeviceUnRegisterEventEventResponse response : Register.getDeviceUnRegisterEventEvents(test2)) {
            System.out.println("测试2结果返回:" + response.message.getValue());
        }
        // 测试3 重放旧请求 (修改nounce,减少timestamp)
        testNTS[0] = testNTS[0] - 1;
        testNTS[1] = testNTS[1] - 1;
        byte[] packageResult3 = packageParams(testAddress, testTypes, testNTS); //将参数打包
        String strPackage3 = Numeric.toHexString(packageResult3); //转换成16进制字符串, 与solidity测试结果相同
//        System.out.println("PackageResult in HexString: " + strPackage);
        DynamicArray<Bytes32> signResult3 = signParams(strPackage3, keyPair);
        DynamicArray<Uint256> nounceResult3 = new DynamicArray<>(new Uint256(testNTS[0]), new Uint256(testNTS[1]));
        TransactionReceipt test3 = register.test(addr4, new Address(address), new Utf8String(attrType), new Utf8String(attrState), signResult3, nounceResult3).get();
        for (Register.DeviceUnRegisterEventEventResponse response : Register.getDeviceUnRegisterEventEvents(test3)) {
            System.out.println("测试3结果返回:" + response.message.getValue());
        }
    }

    /* 注册合约测试 */
    // 都使用get()方法同步执行
    private static void registerTest() throws ExecutionException, InterruptedException, SignatureException {
        Register register = Register.load(registerAddr, web3j, credentials, gasPrice, gasLimit);
        //平台1注册
        ECKeyPair keyPair1 = ECKeyPair.create(new BigInteger(platAddr_1_PrivateKey, 16));
        long[] testNTS = getNounceAndTimeStamp();
        DynamicArray<Bytes32> signResult1 = signParams(Numeric.toHexString(packageParams(new String[]{}, new String[]{}, testNTS)), keyPair1);//写在外面
        DynamicArray<Uint256> nounceResult1 = new DynamicArray<>(new Uint256(testNTS[0]), new Uint256(testNTS[1]));
        TransactionReceipt platformRegister = register.platformRegister(new Address(platAddr_1), signResult1, nounceResult1).get();
        for (Register.PlatformRegisterEventEventResponse response : Register.getPlatformRegisterEventEvents(platformRegister)) {
            System.out.println("平台1 注册事件返回:" + response.message.getValue());
        }
        Future<Bool> result1 = register.checkPlatformRegister(new Address(platAddr_1));
        System.out.println("查询平台1 注册查询结果:" + result1.get().getValue());
        //平台2注册
        ECKeyPair keyPair2 = ECKeyPair.create(new BigInteger(platAddr_2_PrivateKey, 16));
        testNTS = getNounceAndTimeStamp();
        register.platformRegister(new Address(platAddr_2),
                signParams(Numeric.toHexString(packageParams(new String[]{}, new String[]{}, testNTS)), keyPair2),
                new DynamicArray<>(new Uint256(testNTS[0]), new Uint256(testNTS[1]))).get();
        Future<Bool> result2 = register.checkPlatformRegister(new Address(platAddr_2));
        System.out.println("查询平台2 注册结果:" + result2.get().getValue());
        //设备1注册
        ECKeyPair keyPair3 = ECKeyPair.create(new BigInteger(deviceAddr_1_PrivateKey, 16));
        testNTS = getNounceAndTimeStamp();
        register.devicesRegister(new Address(platAddr_1), new Address(deviceAddr_1),
                signParams(Numeric.toHexString(packageParams(new String[]{}, new String[]{}, testNTS)), keyPair3),
                new DynamicArray<>(new Uint256(testNTS[0]), new Uint256(testNTS[1]))).get();
        Future<Bool> result3 = register.checkDeviceRegister(new Address(platAddr_1), new Address(deviceAddr_1));
        System.out.println("查询设备1 注册结果:" + result3.get().getValue());
        //设备1添加属性
        testNTS = getNounceAndTimeStamp();
        register.devicesSetAttr(new Address(platAddr_1), new Address(deviceAddr_1), new Utf8String("属性1"), new Utf8String("关闭"),
                signParams(Numeric.toHexString(packageParams(new String[]{}, new String[]{}, testNTS)), keyPair3),
                new DynamicArray<>(new Uint256(testNTS[0]), new Uint256(testNTS[1]))).get();
        //用户1注册
        ECKeyPair keyPair4 = ECKeyPair.create(new BigInteger(userPrivateKey, 16));
        testNTS = getNounceAndTimeStamp();
        register.userRegister(new Address(userAddr),
                signParams(Numeric.toHexString(packageParams(new String[]{}, new String[]{}, testNTS)), keyPair4),
                new DynamicArray<>(new Uint256(testNTS[0]), new Uint256(testNTS[1]))).get();
        Future<Bool> result4 = register.checkUserRegister(new Address(userAddr));
        System.out.println("用户1 注册结果:" + result4.get().getValue());
        //设备2注册
        ECKeyPair keyPair5 = ECKeyPair.create(new BigInteger(deviceAddr_2_PrivateKey, 16));
        testNTS = getNounceAndTimeStamp();
        TransactionReceipt deviceRegister = register.devicesRegister(new Address(platAddr_2), new Address(deviceAddr_2),
                signParams(Numeric.toHexString(packageParams(new String[]{}, new String[]{}, testNTS)), keyPair5),
                new DynamicArray<>(new Uint256(testNTS[0]), new Uint256(testNTS[1]))).get();
        for (Register.DevicesRegisterEventEventResponse response : Register.getDevicesRegisterEventEvents(deviceRegister)) {
            System.out.println("设备2 注册事件返回:" + response.message.getValue());
        }
        Future<Bool> result5 = register.checkDeviceRegister(new Address(platAddr_2), new Address(deviceAddr_2));
        System.out.println("查询设备2 注册结果:" + result5.get().getValue());
        //设备2属性
        testNTS = getNounceAndTimeStamp();
        register.devicesSetAttr(new Address(platAddr_2), new Address(deviceAddr_2), new Utf8String("属性2"), new Utf8String("关闭"),
                signParams(Numeric.toHexString(packageParams(new String[]{}, new String[]{}, testNTS)), keyPair4),
                new DynamicArray<>(new Uint256(testNTS[0]), new Uint256(testNTS[1])));
    }

    /* 信任规则合约测试 都使用同步阻塞方式*/
    private static void trustRuleTest() throws ExecutionException, InterruptedException, SignatureException {
        // 平台1获取信任规则合约
        TrustRule trustRule = TrustRule.load(trustRuleAddr_1, web3j, credentials, gasPrice, gasLimit);
        // 平台1设置信任值
        ECKeyPair keyPair1 = ECKeyPair.create(new BigInteger(platAddr_1_PrivateKey, 16));
        long[] testNTS = getNounceAndTimeStamp();
        TransactionReceipt setTrustThreshold = trustRule.setTrustThreshold(new Int256(50),
                signParams(Numeric.toHexString(packageParams(new String[]{}, new String[]{}, testNTS)), keyPair1),
                new DynamicArray<>(new Uint256(testNTS[0]), new Uint256(testNTS[1]))).get();
        for (TrustRule.SetTrustThresholdEventEventResponse response : TrustRule.getSetTrustThresholdEventEvents(setTrustThreshold)) {
            System.out.println("平台1设置信任值 事件返回:" + response.message.getValue());
        }
        // 平台1添加信任设备1
        testNTS = getNounceAndTimeStamp();
        TransactionReceipt setDevices = trustRule.setDevices(new Address(deviceAddr_1), new Int256(100), new Uint8(0),
                signParams(Numeric.toHexString(packageParams(new String[]{}, new String[]{}, testNTS)), keyPair1),
                new DynamicArray<>(new Uint256(testNTS[0]), new Uint256(testNTS[1]))).get();
        for (TrustRule.SetDevicesEventEventResponse response : TrustRule.getSetDevicesEventEvents(setDevices)) {
            System.out.println("平台1添加信任设备1 事件返回:" + response.message.getValue());
        }
        // 检查注册
        Future<List<Type>> result_1 = trustRule.trustRuleJudgePackage(new Address(platAddr_1), new Address(deviceAddr_1));
        System.out.println("查询平台1信任设备1 结果:" + result_1.get().get(1).getValue());
        // 平台2读取信任规则合约
        TrustRule trustRule_2 = TrustRule.load(trustRuleAddr_2, web3j, credentials, gasPrice, gasLimit);
        // 平台2设置信任信任值\
        ECKeyPair keyPair2 = ECKeyPair.create(new BigInteger(platAddr_2_PrivateKey, 16));
        testNTS = getNounceAndTimeStamp();
        TransactionReceipt setTrustThreshold2 = trustRule_2.setTrustThreshold(new Int256(50),
                signParams(Numeric.toHexString(packageParams(new String[]{}, new String[]{}, testNTS)), keyPair2),
                new DynamicArray<>(new Uint256(testNTS[0]), new Uint256(testNTS[1]))).get();
        for (TrustRule.SetTrustThresholdEventEventResponse response : TrustRule.getSetTrustThresholdEventEvents(setTrustThreshold2)) {
            System.out.println("平台2设置信任值 事件返回:" + response.message.getValue());
        }
        // 添加设备2
        testNTS = getNounceAndTimeStamp();
        TransactionReceipt setDevices2 = trustRule_2.setDevices(new Address(deviceAddr_2), new Int256(100), new Uint8(0),
                signParams(Numeric.toHexString(packageParams(new String[]{}, new String[]{}, testNTS)), keyPair2),
                new DynamicArray<>(new Uint256(testNTS[0]), new Uint256(testNTS[1]))).get();
        for (TrustRule.SetDevicesEventEventResponse response : TrustRule.getSetDevicesEventEvents(setDevices2)) {
            System.out.println("平台2添加信任设备2 事件返回:" + response.message.getValue());
        }
        // 检查注册
        Future<List<Type>> result_2 = trustRule_2.trustRuleJudgePackage(new Address(platAddr_2), new Address(deviceAddr_2));
        System.out.println("查询平台2信任设备2 结果:" + result_2.get().get(1).getValue());
    }

    /* 用户规则合约测试 */
    private static void userSceneRuleTest() throws ExecutionException, InterruptedException, SignatureException {
        // 获取用户1场景规则合约
        UserSceneRule userSceneRule = UserSceneRule.load(userSceneRuleAddr, web3j, credentials, gasPrice, gasLimit);
        // 添加用户场景
        long[] testNTS = getNounceAndTimeStamp();
        ECKeyPair keyPair1 = ECKeyPair.create(new BigInteger(userPrivateKey, 16));
        TransactionReceipt addUserSceneRule = userSceneRule.addUserSceneRule(addr4, new Utf8String("属性1"), new Address(linkageRuleAddr), new Address(trustRuleAddr_2),
                signParams(Numeric.toHexString(packageParams(new String[]{}, new String[]{}, testNTS)), keyPair1),
                new DynamicArray<>(new Uint256(testNTS[0]), new Uint256(testNTS[1]))).get();
        for (UserSceneRule.AddUserSceneRuleEventEventResponse response : UserSceneRule.getAddUserSceneRuleEventEvents(addUserSceneRule)) {
            System.out.println("添加用户场景 事件返回:" + response.message.getValue());
        }
        // 检查用户规则是否存在
        Future<List<Type>> result_1 = userSceneRule.checkUserSceneRule(addr4, new Utf8String("属性1"));
        System.out.println("检查用户规则 添加结果:" + result_1.get().get(1).getValue());
    }

    /* 联动规则合约测试 */
    private static void linkageRuleTest() throws ExecutionException, InterruptedException, SignatureException {
        // 获取平台1联动规则合约
        LinkageRule linkageRule = LinkageRule.load(linkageRuleAddr, web3j, credentials, gasPrice, gasLimit);
        // 设置联动规则
        ECKeyPair keyPair1 = ECKeyPair.create(new BigInteger(platAddr_1_PrivateKey, 16));
        long[] testNTS = getNounceAndTimeStamp();
        TransactionReceipt addLinkageSceneRule = linkageRule.addLinkageRule(addr4, new Utf8String("属性1"),
                signParams(Numeric.toHexString(packageParams(new String[]{}, new String[]{}, testNTS)), keyPair1),
                new DynamicArray<>(new Uint256(testNTS[0]), new Uint256(testNTS[1]))).get();
        for (LinkageRule.AddLinkageRuleEventEventResponse response : LinkageRule.getAddLinkageRuleEventEvents(addLinkageSceneRule)) {
            System.out.println("添加用户场景 事件返回:" + response.message.getValue());
        }
        // 检查联动规则
        Future<List<Type>> result_1 = linkageRule.checkLinkageRule(addr4, new Utf8String("属性1"));
        System.out.println("检查用户规则 添加结果:" + result_1.get().get(1).getValue());
    }

    /* 联动测试 */
    private static void transactionTest() throws ExecutionException, InterruptedException, SignatureException {
        TrustRule trustRule = TrustRule.load(trustRuleAddr_1, web3j, credentials, gasPrice, gasLimit);
        // 通过平台1部署的信任规则合约发起交易
        ECKeyPair keyPair1 = ECKeyPair.create(new BigInteger(deviceAddr_1_PrivateKey, 16));
        long[] testNTS = getNounceAndTimeStamp();
        DynamicArray<Bytes32> signResult1 = signParams(Numeric.toHexString(packageParams(new String[]{platAddr_1, deviceAddr_1, platAddr_2, deviceAddr_2, userSceneRuleAddr}, new String[]{"属性1", "打开"}, testNTS)), keyPair1);
        DynamicArray<Uint256> nounceResult1 = new DynamicArray<>(new Uint256(testNTS[0]), new Uint256(testNTS[1]));
        TransactionReceipt startLinking = trustRule.startLinking(addr4, new Address(userSceneRuleAddr), new Utf8String("属性1"), new Utf8String("打开"), signResult1, nounceResult1).get();
        for (TrustRule.TrustRuleEventEventResponse response : TrustRule.getTrustRuleEventEvents(startLinking)) {
            System.out.println("触发联动 TrustRuleEventEventResponse事件返回:" + response.message.getValue());
        }
        for (UserSceneRule.UserSceneRuleEventEventResponse response : UserSceneRule.getUserSceneRuleEventEvents(startLinking)) {
            System.out.println("触发联动 UserSceneRuleEventEventResponse事件返回:" + response.message.getValue());
        }
        for (LinkageRule.LinkageRuleEventEventResponse response : LinkageRule.getLinkageRuleEventEvents(startLinking)) {
            System.out.println("触发联动 LinkageRuleEventEventResponse事件返回:" + response.message.getValue());
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
        registerTest();
        userSceneRuleTest();
        linkageRuleTest();
        trustRuleTest();
        transactionTest();

        /* 打印区块数量 */
        ethBlockNumber = web3j.ethBlockNumber().sendAsync().get();
        int finishBlockNumber = ethBlockNumber.getBlockNumber().intValue();
        System.out.println("<--start blockNumber = " + startBlockNumber + ",finish blocknmber=" + finishBlockNumber);
        System.exit(0);
    }

    /* 集中部署 */
    private static void deployer() throws ExecutionException, InterruptedException {
        deploy("Register");
        deploy("TrustRule_1");
        deploy("TrustRule_2");
        deploy("LinkageRule");
        deploy("UserSceneRule");
    }

}
