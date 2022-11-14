import java.net.*;
import java.io.*;

public class SolicitanteConexion{

    public static void main(String[ ] args){
        if(args.length != 2)
            System.out.println
            ("Este programa requiere dos argumentos de línes de mandato");
        else {
            try{
                InetAddress maquinaAceptadora = InetAddress.getByName(args[0]);
                int puertoAceptador = Integer.parseInt(args[1]);

                Socket miSocket = new Socket(maquinaAceptadora, puertoAceptador);
                System.out.println("Solicitud de conexión concedida");

                InputStream flujoEntrada = miSocket.getInputStream();
                BufferedReader socketInput = new BufferedReader(new InputStreamReader(flujoEntrada));
                System.out.println("Esperando leer");

                String mensaje = socketInput.readLine( );
                System.out.println("Mensaje recibido: ");
                System.out.println("\t" + mensaje);
                miSocket.close();
                System.out.println("Socket de datos cerrado");

            }
            catch (Exception ex){
                ex.printStackTrace( );
            }
        }
    }
}
