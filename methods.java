package rsa;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class methods {
 
    public byte[] mEncrypt( PublicKey pk, String msj ) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException{
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, pk);
        
        byte[] secretMessageBytes = msj.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);
        
        String encodedMessage = Base64.getEncoder().encodeToString(encryptedMessageBytes);
        System.out.println("Mensaje: "+msj);
        System.out.println("Encriptado: "+encodedMessage);
        
        return encryptedMessageBytes;
    }
    
    public String mDecrypt( PrivateKey pk, byte[] msj ) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException{
        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, pk);
        
        byte[] decryptedMessageBytes = decryptCipher.doFinal(msj);
        String decryptedMessage = new String(decryptedMessageBytes, StandardCharsets.UTF_8);
        
        System.out.println("Decifrado: "+decryptedMessage);
        
        return decryptedMessage;
    }
}