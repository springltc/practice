package com.example.coding.demo;

/**
 * @author liutc
 * @date 2024/5/6 17:43
 */

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class AsymmetricEncryptionExample {

    public static void main(String[] args) {
        try {
            // 生成RSA密钥对
            KeyPair keyPair = generateKeyPair();

            // 获取公钥和私钥
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            // 要加密的文本
            String plainText = "Hello, world!";

            // 使用公钥加密文本
            byte[] encryptedBytes = encrypt(publicKey, plainText);
            String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
            System.out.println("Encrypted text: " + encryptedText);

            // 使用私钥解密
            String decryptedText = decrypt(privateKey, encryptedBytes);
            System.out.println("Decrypted text: " + decryptedText);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }

    public static byte[] encrypt(PublicKey publicKey, String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(plainText.getBytes());
    }

    public static String decrypt(PrivateKey privateKey, byte[] encryptedBytes) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }

}

