package com.lzw.data.util;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * @desp 测试类
 * @author LZW
 * @version 1.0
 * @date 2019-05-01
 * @website https://github.com/AweiLoveAndroid/CommonDevKnowledge
 * @mail lzw20099002@126.com 有任何疑问欢迎发邮件 或者 加微信咨询(本开源库README.md有介绍)
 *
 */
public class Test {

    public static void main(String[] args) {
//        String[] strArr = {"你", "好", "你好", "hell5", "你好hell5"};
//        String[] charsetArr = {"", "utf-8", "utf-16", "utf-32", "unicode", "gbk", "gb2312", "GB18030", "ascii", "ISO-8859-1"};
//        for (String str : strArr) {
//            System.out.println(str);
//            for (String charset : charsetArr) {
//                test(str, charset);
//            }
//            System.out.println("============================");
//        }


        System.out.println(DataUtil.stringHex2StringDecimal("FFFF")); // 65535

        String data = "0x123";
        System.out.println(isDecimal(data));
    }

    public static void test(String data, String charsetName) {
        try {
            byte[] byteArrays = DataUtil.string2ByteArr(data, charsetName);
            String result = DataUtil.byteArr2StringHex2(byteArrays);
            if (charsetName.equals("")) {
                System.out.println("默认编码：" + charsetName
                        + "    系统默认编码：" + System.getProperty("file.encoding")
                        + "    系统默认字符编码:" + Charset.defaultCharset()
                        + "    操作系统用户使用的语言:" + System.getProperty("user.language")
                        + "    所占字节数：" + byteArrays.length
                        + "    16进制：" + result);
            } else {
                System.out.println("编码：" + charsetName
                        + "    系统默认编码：" + System.getProperty("file.encoding")
                        + "    系统默认字符编码:" + Charset.defaultCharset()
                        + "    操作系统用户使用的语言:" + System.getProperty("user.language")
                        + "    所占字节数：" + byteArrays.length
                        + "    16进制：" + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isOctal(String data) {
        String substring;
        String regex = "[0-7]+$";
        if (data.startsWith("0")) {
            substring = data.substring(1);
            if (substring.matches(regex)) {
                System.out.println(data.toUpperCase() + "是8进制数");
                return true;
            } else {
                System.out.println(data.toUpperCase() + "不是8进制数");
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isDecimal(String data) {
        String regex = "[0-9]+$";
        if (data.matches(regex)) {
            System.out.println(data.toUpperCase() + "是10进制数");
            return true;
        } else {
            System.out.println(data.toUpperCase() + "不是10进制数");
            return false;
        }
    }

}