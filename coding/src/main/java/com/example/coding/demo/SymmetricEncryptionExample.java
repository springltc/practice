package com.example.coding.demo;

/**
 * @author liutc
 * @date 2024/5/6 17:42
 */
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class SymmetricEncryptionExample {

    public static void main(String[] args) {
        String plainText = "Hello, world!";
        String encryptionKey = "AESencryptionKey";

        try {
            // 加密
            byte[] encryptedBytes = encrypt(plainText, encryptionKey);

            // 将加密结果转换为Base64字符串
            String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
            System.out.println("Encrypted text: " + encryptedText);

            // 解密
            String decryptedText = decrypt(encryptedBytes, encryptionKey);
            System.out.println("Decrypted text: " + decryptedText);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static byte[] encrypt(String plainText, String encryptionKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(plainText.getBytes());
    }

    public static String decrypt(byte[] encryptedBytes, String encryptionKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }
}

