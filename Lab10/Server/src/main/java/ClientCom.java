import java.io.*;
import java.net.Socket;

public class ClientCom implements Runnable{
    DataInputStream read = null;
    DataOutputStream write = null;
    Socket socket = null;

    public ClientCom(Socket socket) throws IOException{
        this.read = new DataInputStream(socket.getInputStream());
        this.write = new DataOutputStream(socket.getOutputStream());
        this.socket = socket;
    }
    @Override
    public void run() {
        String line = "";
        boolean exit = false;
        Thread thread = new Thread();
        Timeout connectionTimeOut = new Timeout(100);
        thread.start();
        while (!exit) {
            try {
                line = read.readUTF();
                System.out.print("Received -> ");
                System.out.println(line);
                connectionTimeOut.setSeconds(100);
                if(connectionTimeOut.connectionTimedOut){
                    write.writeUTF("Connection timed out");
                    break;
                }
                if (!Server.serverRun) {
                    write.writeUTF("Server stopped");
                    break;
                } else {
                    write.writeUTF("Request received");
                }
                switch (line) {
                    case "stop":
                        write.writeUTF("Stopping server");
                        Server.serverRun = false;
                        break;
                    case "exit":
                        exit = true;
                        write.writeUTF("\n");
                        break;
                    default:
                        write.writeUTF("Command not valid!");
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        System.out.println("Closing connection");
        try {
            socket.close();
            read.close();
            write.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
