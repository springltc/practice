package com.example.coding.demo;

/**
 * @author liutc
 * @date 2024/5/6 17:08
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Example {
    public static String calculateSHA256(String input) {
        try {
            // 创建 MessageDigest 对象并指定算法为 SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // 将输入字符串转换为字节数组
            byte[] hashBytes = digest.digest(input.getBytes());

            // 将字节数组转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("SHA-256 algorithm is not available.");
            return null;
        }
    }

    public static void main(String[] args) {
        String input = "Hello, World!";
        String sha256Hash = calculateSHA256(input);

        System.out.println("Input: " + input);
        System.out.println("SHA-256 Hash: " + sha256Hash);
    }
}

