import java.util.*;
import java.io.*;
import java.net.*;
public class Ass7setB1client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket s = new Socket("localhost", 4444);

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter the File Name to Search : ");
            String fn = sc.nextLine();
            dos.writeUTF(fn);
            if(fn.equals("end")){
                break;
            }
        }
        while (true) {
            String str = dis.readUTF();
            System.out.println(str);
        }       
    }
}
