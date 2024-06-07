import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main
{
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6600);

        while(true)
        {
            Socket connect = server.accept();
            MainServer ob = new MainServer(connect);
            Thread t = new Thread(ob);
            t.start();
        }

    }
}