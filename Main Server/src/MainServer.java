import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class MainServer implements Runnable
{
    String name;
    BufferedReader reader;
    BufferedWriter writer, fWriter;
    final static ArrayList<MainServer> list = new ArrayList<>();
    private ArrayList<String> listPrevMsg = new ArrayList<>();
    private final String path = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\Chat Server.txt";

    MainServer(Socket sc)
    {
        try
        {
            OutputStreamWriter out = new OutputStreamWriter(sc.getOutputStream());
            writer = new BufferedWriter(out);

            InputStreamReader in = new InputStreamReader(sc.getInputStream());
            reader = new BufferedReader(in);

            fWriter = new BufferedWriter(new FileWriter(path));

            name = reader.readLine();
            System.out.println(name);
            list.add(this);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true)
        {
            try
            {
                String msg = reader.readLine();
                msg = name+": "+msg+"\n";
                synchronized (list)
                {
                    for(MainServer lists: list)
                    {
                        lists.fWriter.write(msg);
                        lists.fWriter.flush();
                        lists.writer.write(msg);
                        lists.writer.flush();
                    }
                }
            }
            catch (SocketException s)
            {
                break;
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
