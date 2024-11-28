import java.util.*;
import java.io.*;
import java.net.*;
public class Ass7setA1client {
    public static void main(String[] args) throws UnknownHostException, IOException {

        Socket s = new Socket("localhost", 4444);

        DataInputStream dis = new DataInputStream(s.getInputStream());
        String str = dis.readUTF();
        System.out.println("Message from server: " + str);        
    }
}
