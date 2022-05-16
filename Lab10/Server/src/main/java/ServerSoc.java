import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSoc {
    int port;
    Socket socket = null;
    ServerSocket server = null;

    public ServerSoc(int port){
        this.port = port;
        initializeServer();
    }

    private void initializeServer() {
        try{
            server = new ServerSocket(port);
            System.out.println("Waiting for client");
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
