package main;

import example.Counter;
import example.bcosliteclient;
import org.bcos.channel.client.Service;
import org.bcos.web3j.abi.datatypes.Utf8String;
import org.bcos.web3j.abi.datatypes.generated.Uint256;
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
import test.Register;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class mainTest {
    static Logger logger = LoggerFactory.getLogger(bcosliteclient.class);
    public static Web3j web3j;
    // 初始化交易参数
    public static java.math.BigInteger gasPrice = new BigInteger("1");
    public static java.math.BigInteger gasLimit = new BigInteger("30000000");
    public static java.math.BigInteger initialWeiValue = new BigInteger("0");
    public static ECKeyPair keyPair;
    public static Credentials credentials;

    // 合约地址
    public static String LinkageRule;
    public static String RegisterAddr;
    public static String ToolsAddr;
    public static String TrustRuleAddr;
    public static String UserSceneRuleAddr;

    /* 部署合约 */
    public static void deploy(String opCode) throws InterruptedException, ExecutionException {
        switch (opCode){
            case "LinkageRule":
                Future<Register> futureDeploy = Register.deploy(web3j, credentials, gasPrice, gasLimit, initialWeiValue);
                Register register = futureDeploy.get();
                String contractName = register.getContractAddress();
                RegisterAddr = contractName;
                System.out.println("Deploy contract :" + register.getContractName() + ",address :" + RegisterAddr);
        }
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


        // 测试流程:
        // 0.工具合约部署
        // 1.平台1注册 平台2注册 设备1注册 设置设备1属性 用户1注册 (设备2注册 设备2解注册) Register
        // 2.平台1部署信任规则合约 设置信任规则合约 检查注册 TrustRule
        // 3.用户1部署用户场景规则合约 添加用户场景 检查用户规则 UserSceneRule
        // 4.平台1部署联动规则合约  设置联动规则 检查联动规则 LinkageRule
        // 5.平台2部署信任规则合约 设置信任规则合约
        // 6.通过平台1部署的信任规则合约发起交易 查询交易记录

        /* print block number after some transactions */
        ethBlockNumber = web3j.ethBlockNumber().sendAsync().get();
        int finishBlockNumber = ethBlockNumber.getBlockNumber().intValue();
        System.out.println("<--start blockNumber = " + startBlockNumber + ",finish blocknmber=" + finishBlockNumber);
        System.exit(0);
    }

}
