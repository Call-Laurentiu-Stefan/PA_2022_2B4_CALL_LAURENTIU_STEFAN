import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client(String address, int port) throws IOException{
        Socket socket = new Socket(address, port);
        DataInputStream read = new DataInputStream(socket.getInputStream());
        DataOutputStream write = new DataOutputStream(socket.getOutputStream());
        System.out.println("Connected");

        String request = "";
        String response = "";
        Scanner scan = new Scanner(System.in);
        while(!request.equals("exit")){
            request = scan.nextLine();
            write.writeUTF(request);
            response = read.readUTF();
            System.out.println(response);
            System.out.println(read.readUTF());
            if ("Server stopped".equals(response)){
                break;
            }
        }

        write.close();
        read.close();
        socket.close();
    }
}
