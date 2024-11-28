import java.io.*;
import java.net.*;
import java.util.*;
public class Ass7setB2client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket s = new Socket("localhost", 4444);
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Message and Type end to Exit : ");

        while(true){
            String msg = sc.nextLine();
            dos.writeUTF(msg);
            if(msg.equals("end")){
                System.out.println("Chatting Ended");
                break;
            }
        }
    }
}
