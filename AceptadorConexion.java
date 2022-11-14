import java.net.*;
import java.io.*;

public class AceptadorConexion{

    public static void main(String[ ] args){
        if(args.length != 2)
            System.out.println
            ("Este programa requiere dos argumentos de línes de mandato");
        else {
            try{
                int numPuerto = Integer.parseInt(args[0]);
                String mensaje = args[1];

                ServerSocket socketConexion = new ServerSocket(numPuerto);
                System.out.println("preparado para aceptar una conexión");

                Socket socketDatos = socketConexion.accept();
                System.out.println("Conexion aceptada");

                OutputStream flujoSalida = socketDatos.getOutputStream();
                PrintWriter salidaSocket = new PrintWriter(new OutputStreamWriter(flujoSalida));

                salidaSocket.println(mensaje);
                salidaSocket.flush();
                System.out.println("mensaje enviado");
                socketDatos.close( );
                System.out.println("socket de datos cerrado");
                socketConexion.close( );
                System.out.println("socket de conexión cerrado");
            }
            catch (Exception ex){
                ex.printStackTrace( );
            }
        }
    }
}
