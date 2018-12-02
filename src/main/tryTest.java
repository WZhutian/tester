package main;

import org.bcos.web3j.abi.datatypes.generated.Bytes32;
import org.bcos.web3j.abi.datatypes.generated.Uint8;
import org.bcos.web3j.utils.Numeric;
import org.bcos.web3j.crypto.*;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.SignatureException;
import java.security.interfaces.ECKey;

//import org.bcos.web3j.crypto.*;

public class tryTest {

    public static void main(String[] args) throws Exception {

        generateKey();

        String privateKey = "f7e8023349ee775ad5dd97a2a6844aad6f8d55bf0a60ac46a0afc77234c21a2b";
        String publicKey = "d0cf0e3cb15a476fb65bc9898617fd38462101df5c9c3fc48547309ad63eb3202e7c254a511933aed31d7b1ddf755316d019d4cdd22bf40150a92bf209103369";
        String address = "0xf8514b2da9da74903f409bfd6f9a7fc2aa056c93";

        ECKeyPair keyPair = new ECKeyPair(new BigInteger(privateKey, 16), new BigInteger(publicKey, 16));
        signParams(keyPair);
    }

    public static ECKeyPair generateKey() throws Exception {
        //简单生成公私钥对
        ECKeyPair ecKeyPair = Keys.createEcKeyPair();

        String sPublicKey = ecKeyPair.getPublicKey().toString(16);
        String sPrivateKey = ecKeyPair.getPrivateKey().toString(16);
        String sAddress = "0x" + Keys.getAddress(ecKeyPair);

        System.out.println("PublicKey in HexString:" + sPublicKey);
        System.out.println("Private in HexString:" + sPrivateKey);
        System.out.println("Address:" + sAddress);
        System.out.println("Address:" + Numeric.toHexString(sAddress.getBytes()));


        return ecKeyPair;
    }

    public static void signParams(ECKeyPair keyPair) throws SignatureException {

        //使用keccak256打包参数
        String[] testAddress = new String[]{"0xcd2a3d9f938e13cd947ec05abc7fe734df8dd826"};
        String[] testTypes = new String[]{"属性", "关闭"};
        byte[] packageResult = signParam(testAddress, testTypes); //将参数打包
        String strPackage =  Numeric.toHexString(packageResult); //转换成16进制字符串, 与solidity测试结果相同
        System.out.println("PackageResult in HexString:" + strPackage);

        //私钥签名
        Sign.SignatureData signMessage = Sign.signMessage(packageResult, keyPair);
        // 获取验证所需的 v r s
        Uint8 v = new Uint8(signMessage.getV());
        Bytes32 r = new Bytes32(signMessage.getR());
        Bytes32 s = new Bytes32(signMessage.getS());
        System.out.println("hash:" + Numeric.toHexString(packageResult));
        System.out.println("v:" + signMessage.getV());
        System.out.println("r:" + Numeric.toHexString(signMessage.getR()));
        System.out.println("s:" + Numeric.toHexString(signMessage.getS()));

        String pubKey = Sign.signedMessageToKey(packageResult, signMessage).toString(16);//验证方法 不用
    }


    //签名函数,根据传入参数进行动态调整
    // 返回byte[]
    public static byte[] signParam(String[] addrs, String[] types) {
        // 初始化
        byte[] byteAddr = "".getBytes(); // 用于保存地址字节数组
        String allTypes = ""; // 用于保存类型字符串
        // 取出addrs中的地址,并删除16进制"0x" 以供紧凑.
        for (int i = 0; i < addrs.length; i++) {
            String tmp = addrs[i];
            if (tmp.length() > 2 && "0x".equals(tmp.substring(0, 2))) {
                tmp = tmp.substring(2);
            }
            byteAddr = byteMerger(byteAddr, toBytes(tmp));
        }
        //取出types中的属性并整合
        for (int j = 0; j < types.length; j++) {
            allTypes += types[j];
        }
        return Hash.sha3(byteMerger(byteAddr, allTypes.getBytes(StandardCharsets.UTF_8)));
    }

    /* 工具方法 */
    // 16进制string转bytes
    public static byte[] toBytes(String str) {
        if (str == null || str.trim().equals("")) {
            return new byte[0];
        }

        byte[] bytes = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }

        return bytes;
    }

    //合并byte数组
    public static byte[] byteMerger(byte[] byte_1, byte[] byte_2) {
        byte[] byte_3 = new byte[byte_1.length + byte_2.length];
        System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
        System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);
        return byte_3;
    }
}
