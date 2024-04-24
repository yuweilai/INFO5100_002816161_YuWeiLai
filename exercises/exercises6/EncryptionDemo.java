package exercises.exercises6;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.security.SecureRandom;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.*;
import java.util.Base64;

public class EncryptionDemo {

    public static void main(String[] args) throws Exception {
        // Generate AES key for symmetric encryption
        SecretKey aesKey = generateAESKey();

        // Generate RSA key pair for asymmetric encryption and signing
        KeyPair rsaKeyPair = generateRSAKeyPair();

        // Alice sends a message to Bob
        String message = "Hello Bob! This is Alice.";

        // Symmetric encryption/decryption between Alice and Bob
        String encryptedMessage = symmetricEncrypt(message, aesKey);
        String decryptedMessage = symmetricDecrypt(encryptedMessage, aesKey);

        System.out.println("Symmetric Encryption/Decryption:");
        System.out.println("Encrypted Message: " + encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);

        // Asymmetric encryption/decryption between Alice and Bob
        String encryptedMessageRSA = asymmetricEncrypt(message, rsaKeyPair.getPublic());
        String decryptedMessageRSA = asymmetricDecrypt(encryptedMessageRSA, rsaKeyPair.getPrivate());

        System.out.println("\nAsymmetric Encryption/Decryption:");
        System.out.println("Encrypted Message: " + encryptedMessageRSA);
        System.out.println("Decrypted Message: " + decryptedMessageRSA);

        // Signing and validating a message between Alice and Bob
        String signature = signMessage(message, rsaKeyPair.getPrivate());
        boolean isVerified = verifySignature(message, signature, rsaKeyPair.getPublic());

        System.out.println("\nSigning and Verification:");
        System.out.println("Signature: " + signature);
        System.out.println("Signature Verified: " + isVerified);
    }

    // Generate AES key
    private static SecretKey generateAESKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        return keyGen.generateKey();
    }

    // Generate RSA key pair
    private static KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        return keyGen.generateKeyPair();
    }

    // Symmetric encryption
    private static String symmetricEncrypt(String plaintext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] iv = cipher.getIV();
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(iv) + ":" + Base64.getEncoder().encodeToString(ciphertext);
    }

    // Symmetric decryption
    private static String symmetricDecrypt(String encryptedText, SecretKey key) throws Exception {
        String[] parts = encryptedText.split(":");
        byte[] iv = Base64.getDecoder().decode(parts[0]);
        byte[] ciphertext = Base64.getDecoder().decode(parts[1]);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, key, new GCMParameterSpec(128, iv));
        byte[] plaintext = cipher.doFinal(ciphertext);
        return new String(plaintext);
    }

    // Asymmetric encryption
    private static String asymmetricEncrypt(String plaintext, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(ciphertext);
    }

    // Asymmetric decryption
    private static String asymmetricDecrypt(String encryptedText, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] ciphertext = Base64.getDecoder().decode(encryptedText);
        byte[] plaintext = cipher.doFinal(ciphertext);
        return new String(plaintext);
    }

    // Signing a message
    private static String signMessage(String message, PrivateKey privateKey) throws Exception {
        Signature signer = Signature.getInstance("SHA256withRSA");
        signer.initSign(privateKey);
        signer.update(message.getBytes());
        byte[] signature = signer.sign();
        return Base64.getEncoder().encodeToString(signature);
    }

    // Verifying the signature
    private static boolean verifySignature(String message, String signature, PublicKey publicKey) throws Exception {
        Signature verifier = Signature.getInstance("SHA256withRSA");
        verifier.initVerify(publicKey);
        verifier.update(message.getBytes());
        byte[] signatureBytes = Base64.getDecoder().decode(signature);
        return verifier.verify(signatureBytes);
    }
}