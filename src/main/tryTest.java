package main;

import org.bcos.web3j.crypto.*;
import org.bcos.web3j.protocol.Web3j;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class tryTest {

    public static void main(String[] args) throws Exception {
        ECKeyPair keyPair =  ECKeyPair.create(new BigInteger("852984b557aa21e3e824abc03cdf54256680ea438daf967e9d670da103faef24",16));

        System.out.println(keyPair.getPublicKey().toString(16));
//        signParams();
//        generateKey();
    }
    //Public:852984b557aa21e3e824abc03cdf54256680ea438daf967e9d670da103faef24
    //Private:852984b557aa21e3e824abc03cdf54256680ea438daf967e9d670da103faef24
    //Address:f965fb27ece4cdbb9ce8a72e3cab43f4934e10ef
//    Public:88389849803203412300082796402640469164451737580238328982268733578557535963820
//    Private:88389849803203412300082796402640469164451737580238328982268733578557535963820
//    Address:b66469acef61199b3bbe24dccee49358c57c583e
    //Address:40

    public static void generateKey() throws Exception {
        //简单生成公私钥对
        ECKeyPair ecKeyPair = Keys.createEcKeyPair();

        String sPublicKey = ecKeyPair.getPrivateKey().toString();
        String sPublicKeyHex = ecKeyPair.getPrivateKey().toString(16);
        String sPrivateKey = ecKeyPair.getPrivateKey().toString();
        String sPrivateKeyHex = ecKeyPair.getPrivateKey().toString(16);
        String sAddress = Keys.getAddress(sPublicKey);

        System.out.println("Public:" + sPublicKey);
        System.out.println("Private:" + sPrivateKey);
        System.out.println("Address:" + sAddress);
        System.out.println("Address:" + sAddress.length());
    }

    public static void signParams(){

        //使用keccak256打包参数
        String[] testAddress = new String[]{"0xcd2a3d9f938e13cd947ec05abc7fe734df8dd826"};
        String[] testTypes = new String[]{"属性", "关闭"};
        byte[] packageResult = sign(testAddress, testTypes);
        String strPackage = bytesToHex(packageResult); //转换成16进制字符串, 与solidity相同
        System.out.println("PackageResult in HexString:" + strPackage);

        //私钥签名
        byte[] a = new byte[]{1, 2, 3, 4};
        ECDSASign sign = new ECDSASign();
//        Sign.SignatureData b = sign.signMessage(a, ecKeyPair);
//        Sign.signMessage(a, ecKeyPair);
//        System.out.println(b.hashCode());
    }


    //签名函数,根据传入参数进行动态调整
    // 返回byte[]
    public static byte[] sign(String[] addrs, String[] types) {
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
    // bytes转16进制string
    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String bytesToHex(byte[] bytes) {
        char[] buf = new char[bytes.length * 2];
        int a = 0;
        int index = 0;
        for (byte b : bytes) {
            if (b < 0) {
                a = 256 + b;
            } else {
                a = b;
            }
            buf[index++] = HEX_CHAR[a / 16];
            buf[index++] = HEX_CHAR[a % 16];
        }
        return "0x" + new String(buf);
    }

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
