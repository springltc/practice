package com.example.coding.demo;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author liutc
 * @date 2024/5/6 17:00
 */
public class Md5Demo {

    public static void main(String[] args) {
        String input = "Hello, World!";

        try {
            // 创建 MessageDigest 对象并指定算法为 MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 将输入字符串转换为字节数组
            byte[] inputBytes = input.getBytes();

            // 计算 MD5 哈希值
            byte[] hashBytes = md.digest(inputBytes);

            // 将字节数组转换为十六进制字符串
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            String md5Hash = sb.toString();

            System.out.println("Input: " + input);
            System.out.println("MD5 Hash: " + md5Hash);

        } catch (NoSuchAlgorithmException e) {
            System.err.println("MD5 algorithm is not available.");
        }
    }
}
