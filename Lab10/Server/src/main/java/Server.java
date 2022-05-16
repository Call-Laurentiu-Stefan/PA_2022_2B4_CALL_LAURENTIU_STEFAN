import java.io.IOException;

public class Server {
    public static boolean serverRun = true;

    public Server(int port) throws IOException{
        ServerSoc serverSoc = new ServerSoc(port);
        while(serverRun){
            serverSoc.socket = serverSoc.server.accept();
            System.out.println("Accepted client");
            ClientCom clientCommand = new ClientCom(serverSoc.socket);
            Thread client = new Thread(clientCommand);
            client.start();
        }
    }
}
