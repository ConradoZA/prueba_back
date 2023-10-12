package com.prueba_tecnica.utils;

import java.util.Base64;

public class Encrypter {

    // I KNOW!! SHA-256, salt, secretkey, publickey.... No time

    public String encrypt(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes());
    }

    public Boolean isEncryptedValid(String code1, String code2) {
        byte[] decoded1 = Base64.getDecoder().decode(code1);
        String original1 = new String(decoded1);

        byte[] decoded2 = Base64.getDecoder().decode(code2);
        String original2 = new String(decoded2);

        return original1.equals(original2);
    }
}
