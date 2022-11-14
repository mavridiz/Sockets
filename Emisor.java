package rsa;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Emisor {
    
    public static void main(String args[]) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        
        String msj = "Chencho se besa con Cristian";
        AuthCert ac = new AuthCert();        
        methods e = new methods();
        
        byte[] msjEncrypted = e.mEncrypt(ac.getPublicKey(),msj);
        
        String msjDecrypted = e.mDecrypt(ac.getPrivateKey(), msjEncrypted);
    }
}
