package com.library.core_lib.crypt_aes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class DecryptionAES {
    public DecryptionAES() {

    }

    public String DecryptData(String data)
            throws IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException,
            IOException, ClassNotFoundException, InvalidKeyException {
        FileInputStream fis = new FileInputStream("OopLibrarySystem\\Key.aes");
        ObjectInputStream objectIn = new ObjectInputStream(fis);
        SecretKeySpec key = (SecretKeySpec) objectIn.readObject();
        objectIn.close();

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
    }
}

// public static void main(String[] args) {
// try {
// System.out.println(new
// DecryptionAES().DecryptData("9RW6vrJzlu9C2TlEJlKGIw=="));
// } catch (InvalidKeyException | IllegalBlockSizeException |
// BadPaddingException | NoSuchAlgorithmException
// | NoSuchPaddingException | ClassNotFoundException | IOException e) {
// e.printStackTrace();
// }
// }
// }
