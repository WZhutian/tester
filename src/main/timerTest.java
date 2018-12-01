package main;

import org.bcos.channel.client.Service;
import org.bcos.web3j.abi.datatypes.Type;
import org.bcos.web3j.abi.datatypes.generated.Uint256;
import org.bcos.web3j.crypto.Credentials;
import org.bcos.web3j.crypto.ECKeyPair;
import org.bcos.web3j.crypto.Keys;
import org.bcos.web3j.protocol.Web3j;
import org.bcos.web3j.protocol.channel.ChannelEthereumService;
import org.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.LinkageRule;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

import static java.lang.Integer.parseInt;

//说明:
// 受控平台轮询
// 使用前先跑mainTest部署好合约, 然后填写联动规则合约地址 然后注册,填写平台注册地址
public class timerTest {
    public static void main(String[] args) throws Exception {
        Timer timer = new Timer();
        long delay = 0;
        long interval = 2000;
        JobTask polling = new JobTask();
        polling.init();
        timer.schedule(polling, delay, interval);
    }
}

class JobTask extends TimerTask {
    private static String linkageRuleAddr = ""; // 联动规则合约地址
    private static String platformAddr = ""; // 平台注册地址
    private static LinkageRule linkageRule;
    public static Web3j web3j;
    private static ECKeyPair keyPair;
    private static Credentials credentials;
    private static java.math.BigInteger gasPrice = new BigInteger("1");
    private static java.math.BigInteger gasLimit = new BigInteger("30000000");
    private boolean changed = true;
    private static int recordID = 0;

    void init() throws Exception {
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
        // 载入合约
        linkageRule = LinkageRule.load(linkageRuleAddr, web3j, credentials, gasPrice, gasLimit);
    }
    public void run() {
        // 调用
        System.out.println("Polling At: "  + Calendar.getInstance().getTime());
        try {
            List<Type> result = linkageRule.queryRecord(new Uint256(recordID)).get();
            //是否是最新  (没有新记录的时候会保持在这一状态)
            if(parseInt(result.get(6).getTypeAsString()) < recordID){
                // 不操作
            } else if(check(result.get(3).getTypeAsString())){ // 是否是本平台设备
                logger(result);
                doAction();
                recordID ++;
            } else if(parseInt(result.get(6).getTypeAsString()) > recordID){// 是否有新的记录出现
                logger(result);
                recordID ++;
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    //检查是否属于本平台的设备
    private boolean check(String addr){
        return platformAddr.equals(addr);
    }
    //执行相关操作
    private void doAction(){
        System.out.println(" Find opreation!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
    private void logger(List<Type> result){
        System.out.println("record.linkPlatAddr,"  + result.get(0));
        System.out.println("record.linkDeviceAddr,"  + result.get(1));
        System.out.println("record.controlPlatAddr,"  + result.get(2));
        System.out.println("record.controlDeviceAddr,"  + result.get(3));
        System.out.println("record.attrType,"  + result.get(4));
        System.out.println("record.attrState,"  + result.get(5));
        System.out.println("record.ID"  + result.get(6));
    }
}
