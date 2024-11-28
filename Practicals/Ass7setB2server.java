import java.io.*;
import java.net.*;
public class Ass7setB2server {
    public static void main(String[] args) throws UnknownHostException, IOException {
        ServerSocket ss = new ServerSocket(4444);
        System.out.println("Server is running...");

        Socket s = ss.accept();
        System.out.println("Client is connected...");

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        while (true) {
            String msg = dis.readUTF();
            if (msg.equals("end")) {
                System.out.println("Chatting Ended");
                break;
            }
            else{
                System.out.println("Client: " + msg);
            }

        }
    }
}
