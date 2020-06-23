package com.business;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordHash {
    private static Integer saltSize = 0X10;
    private static Integer hashSize = 0X14;
    private static Integer iterations = 0X2710;
    private static String delimiter = ",";

    public static String compute(String password) throws Exception {
        byte[] salt = salt();
        byte[] pbkdf = pbkdf(password.toCharArray(), salt);

        Base64.Encoder encoder = Base64.getEncoder();

        return String.format("%s%s%s", new String(encoder.encode(salt)),
                delimiter, new String(encoder.encode(pbkdf)));
    }

    public static boolean isValid(String hash, String password) throws Exception {
        String[] splitHash = hash.split(delimiter);

        Base64.Decoder decoder = Base64.getDecoder();

        byte[] salt = decoder.decode(splitHash[0]);
        byte[] fromHash = decoder.decode(splitHash[1]);
        byte[] fromPassword = pbkdf(password.toCharArray(), salt);

        return areEqual(fromHash, fromPassword);
    }

    private static boolean areEqual(byte[] a, byte[] b) {
        int difference = a.length ^ b.length;
        for (int i = 0; i < a.length && i < b.length; ++i)
            difference |= (a[i] ^ b[i]);

        return difference == 0;
    }

    private static byte[] salt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[saltSize];
        random.nextBytes(salt);
        return salt;
    }

    private static byte[] pbkdf(char[] password, byte[] salt) throws Exception {
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, hashSize);
        SecretKey key = skf.generateSecret(spec);
        return key.getEncoded();
    }
}
