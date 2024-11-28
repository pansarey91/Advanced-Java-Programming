import java.util.*;
import java.io.*;
import java.net.*;
public class Ass7setA1server {
    public static void main(String[] args) throws UnknownHostException, IOException {

        ServerSocket ss = new ServerSocket(4444);
        System.out.println("Server is running...");

        Socket s = ss.accept();
        System.out.println("Client is connected...");

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        dos.writeUTF("Welcome to Server.. todays date is " + new Date());
        
    }
}
