package rsa;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthCert {
    
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public AuthCert() throws NoSuchAlgorithmException {
        
        //Se generan las llaves 
        
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair pair = keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
        
        //Sockets

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingresa el puerto del cifrador: ");
            int portNumC = Integer.parseInt(sc.nextLine());
            
            System.out.println("Ingresa la ip del cifrador: ");
            InetAddress ip = InetAddress.getByName(sc.nextLine());
            ServerSocket socketConexion = new ServerSocket(portNumC);
            Socket socketDatos = socketConexion.accept();
            Socket sCifrador = new Socket(ip, portNumC);
            OutputStream flujoSalida = socketDatos.getOutputStream();
            PrintWriter salidaSocket = new PrintWriter(new OutputStreamWriter(flujoSalida));
            
            salidaSocket.println(publicKey);
            salidaSocket.flush();
            socketDatos.close( );
            socketConexion.close( );
            
        } 
        catch (IOException ex) {
            ex.printStackTrace( );
        }
        
        
    }
    
    
    
    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }
}
