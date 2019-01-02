package org.titans.util;

/**
 * 字节转换工具.
 */
public class ByteConvertUtil {

    public static void main(String[] args) {

        byte b1 = -0x05;
        System.out.println("b==" + Integer.toBinaryString(b1&0xff));
        System.out.println("b==" + Integer.toHexString(b1&0xff));
        byte b2 = 0x05;
        System.out.println("b==" + Integer.toBinaryString(b2&0xff));
        System.out.println("b==" + Integer.toHexString(b2&0xff));
    }
}
