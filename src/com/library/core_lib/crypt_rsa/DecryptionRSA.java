package com.library.core_lib.crypt_rsa;

import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class DecryptionRSA {
    public DecryptionRSA() {

    }

    public String DecryptData(String data) {
        try {
            FileInputStream fis = new FileInputStream("OopLibrarySystem\\privateKey.rsa");
            byte[] b = new byte[fis.available()];
            fis.read(b);
            fis.close();

            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PrivateKey priKey = factory.generatePrivate(spec);

            Cipher c = Cipher.getInstance("RSA");
            c.init(Cipher.DECRYPT_MODE, priKey);
            byte decryptOut[] = c.doFinal(Base64.getDecoder().decode(data));
            return new String(decryptOut);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

// public static void main(String[] args) {
// DecryptionRSA decrypt = new DecryptionRSA();
// System.out.println(decrypt.DecryptData(
// "y4L8EZrGbaWGcS0PiXZ830Y9fu7dPuFLrGImLYhL9shZUvyAnFq7pQ7QJy2YLB4YEs4231R8Y4I8+JBQm0clm120ZEYxEcf6gv4UsLx78WVR0AybGM/QjqqPXkj4gfY5+TCS0F8aRYqSyrEBp0Dl7kOhH6D3FJiA6BnlIvR8qP4TYRgp4w1gQgKe4C7Sd0fpdLok6LMnaoapVc1jMKTqLYT5W0Fsent4bvDsQ3qzSWzMjXKrFfSVqT24iJP5ugO7l4P2dQ4ZKqLGJy9ypfI4PITDtdiAUOtjdhoq++Jb1yCkFenyYEf3iImnx9wROiZonnr7j96OEWQ8A10Z0KzhmPt031GTqOUWI+00WTIVE0jWXzhCT+ny0Kl+A4U52PDzeCsorZ+1WLQyvfje6MVMiQnEymFkfOhrfU4K4j67Qkl5yrAmJ55NX3yYeePOOW/zbHt94K4Y95HIySV/TpQeWLW8rWKhS72QfkiRsY/eIre7nVePeyQr9CyKFUL3SuBnd6giF1ZbrsO+5Cr3fM7uJs0J8eenuF0TJowgqncxF3lPlI3Et5VjQZrHW3sQYju9Hh8bVW4XJfB4QS0TB/QvX1P1IdceNGR20xfOhTw+i2CN3vK4I1DpLHdmwCqRgqpMxH4kohNYOISTRTwmn2px3hJEQZ24Qa9WzfhOJOkVtNo="));
// }
// }