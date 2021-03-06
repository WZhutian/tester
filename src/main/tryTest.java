package main;

import io.netty.buffer.ByteBuf;
import org.apache.commons.codec.binary.StringUtils;
import org.bcos.web3j.abi.datatypes.DynamicArray;
import org.bcos.web3j.abi.datatypes.generated.Bytes32;
import org.bcos.web3j.abi.datatypes.generated.Uint256;
import org.bcos.web3j.abi.datatypes.generated.Uint8;
import org.bcos.web3j.crypto.*;
import org.bcos.web3j.utils.Numeric;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.Random;

import static com.google.common.base.Strings.repeat;


public class tryTest {

    private static String deviceAddr_1 = "0xcd2a3d9f938e13cd947ec05abc7fe734df8dd826";//设备1地址
    private static String deviceAddr_2 = "0xf8514b2da9da74903f409bfd6f9a7fc2aa056c93";//设备2地址
    private static String platAddr_1 = "0x1b8cBBf72D2260079c01fd622b284Ed2FBf972A0"; //平台1地址
    private static String platAddr_2 = "0xeA02218208eC9489267De43D4AF2398d7f1BfF88"; //平台2地址
    private static String attrType = "属性1"; //设置属性
    private static String attrState = "打开"; //设置状态

    public static void main(String[] args) throws Exception {

//        generateKey();
//        String privateKey = "5a0b841d73c934df67fca222ba8446f9915b2834a77bc128499d7dc1d565ea99";
//        String address = "0x0fa358fb1384e326e7806ca900aad405b8a51657";
//        int nounce = 1000000;
//        long timeStamp = 1543933595543L;
//        ECKeyPair keyPair = ECKeyPair.create(new BigInteger(privateKey, 16));
//        //使用keccak256打包参数
//        String[] testAddress = new String[]{platAddr_1,deviceAddr_1,platAddr_2,deviceAddr_2, address};
//        String[] testTypes = new String[]{attrType, attrState};
//        long[] testNTS = new long[]{nounce,timeStamp};
//        byte[] packageResult = packageParams(testAddress, testTypes, testNTS); //将参数打包
//        String strPackage = Numeric.toHexString(packageResult); //转换成16进制字符串, 与solidity测试结果相同
//        System.out.println("PackageResult in HexString: " + strPackage);
//        DynamicArray<Bytes32> signResult = signParams(strPackage, keyPair);// Byte32 [] 直接传给合约
//        DynamicArray<Uint256> nounceResult = new DynamicArray<>(new Uint256(nounce), new Uint256(timeStamp));

//        signParams(strPackage, keyPair);// Byte32 [] 直接传给合约
    }


    //生成公私钥对
    public static ECKeyPair generateKey() throws Exception {

        ECKeyPair ecKeyPair = Keys.createEcKeyPair();
        String sPublicKey = ecKeyPair.getPublicKey().toString(16);
        String sPrivateKey = ecKeyPair.getPrivateKey().toString(16);
        String sAddress = "0x" + Keys.getAddress(ecKeyPair);

        System.out.println("PublicKey in HexString:" + sPublicKey);
        System.out.println("Private in HexString:" + sPrivateKey);
        System.out.println("Address:" + sAddress);
        return ecKeyPair;
    }

    /**
     * 使用私钥签名 参数
     * 参数为: 16进制字符串(带有0x)
     * @return 签名结果数组 [v, r, s]
     */
    public static DynamicArray<Bytes32> signParams(String paramsHex, ECKeyPair keyPair) throws SignatureException {
        // copy from web3.min.js ver 1.0.0 - wzt
        byte[] r = Numeric.hexStringToByteArray(paramsHex);// 仍旧需要修改,未做16进制判断,(如果是16进制则使用当前方法,如果paramsHax是单纯的字符串则使用tobytes()方法) - wzt
        String n = "\u0019Ethereum Signed Message:\n" + r.length;
        byte[] i = n.getBytes();
        byte[] o = byteMerger(i, r);
        Sign.SignatureData signMessage = Sign.signMessage(o, keyPair);
//        System.out.println("messageHash: " + Numeric.toHexString(Hash.sha3(o)));
        Uint8 V = new Uint8(signMessage.getV());
        Bytes32 R = new Bytes32(signMessage.getR());
        Bytes32 S = new Bytes32(signMessage.getS());
//        System.out.println("v:" + signMessage.getV());
//        System.out.println("r:" + Numeric.toHexString(signMessage.getR()));
//        System.out.println("s:" + Numeric.toHexString(signMessage.getS()));
        String s = "0x00000000000000000000000000000000000000000000000000000000000000" + V.getValue().toString(16); //0x1c 或者 0x1b
        return new DynamicArray<>(new Bytes32(Numeric.hexStringToByteArray(s)), R, S);
    }

    /**
     * 获取nounce和时间戳
     * @return [nounce,timestamp]
     */
    public static long[] getNounceAndTimeStamp() {
        Random random = new Random();
        long s = random.nextInt(10000);
        long t1 = System.currentTimeMillis();
        long[] ret = new long[]{s, t1};
        return ret;
    }

    /**
     * 参数打包, 根据传入参数进行动态调整
     * 注意: 必须按照[地址],[字符串],[nounce,时间戳] 的顺序传入参数
     * @return byte[]
     */
    public static byte[] packageParams(String[] addrs, String[] types, long[] NTS) {
        // 初始化
        byte[] byteAll = "".getBytes(); // 用于保存地址字节数组
        String allTypes = ""; // 用于保存类型字符串
        // 取出addrs中的地址,并删除16进制"0x" 以供紧凑.(与solidity的keccak256方法保持一致)
        for (String addr : addrs) {
            String tmp = addr;
            if (tmp.length() > 2 && "0x".equals(tmp.substring(0, 2))) {
                tmp = tmp.substring(2);
            }
            byteAll = byteMerger(byteAll, Numeric.hexStringToByteArray(tmp));
        }
        //取出types中的属性并整合
        for (String type : types) {
            allTypes += type;
        }
        byteAll = byteMerger(byteAll, allTypes.getBytes(StandardCharsets.UTF_8));
        //nts 转16进制,然后转成byte[],并填充"0"至64位 (与solidity实现方式保持一致
        for (long nts : NTS) {
            String ntsHex = Long.toHexString(nts);
            String tmp = "0x" + repeat("0", 64 - ntsHex.length()) + ntsHex;
            byteAll = byteMerger(byteAll, Numeric.hexStringToByteArray(tmp));
        }
        //取出Nounce和Timestamp
        return Hash.sha3(byteAll);
    }

    /* 工具方法 */
    //合并byte数组
    private static byte[] byteMerger(byte[] byte_1, byte[] byte_2) {
        byte[] byte_3 = new byte[byte_1.length + byte_2.length];
        System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
        System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);
        return byte_3;
    }
}
