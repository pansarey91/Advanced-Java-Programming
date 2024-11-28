import java.io.*;
import java.net.*;
public class Ass7setA2server {
    public static void main(String[] args) throws UnknownHostException, IOException {
        
        ServerSocket ss = new ServerSocket(4444);
        System.out.println("Server is running...");

        Socket s = ss.accept();
        System.out.println("Client is connected...");

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        String fn=dis.readUTF();
        File f = new File(fn);
        String msg=""; 
        int c;
        if (f.exists()){
            FileInputStream fis = new FileInputStream(f);
            while ((c=fis.read()) != -1){
                msg += (char)c;
            }
            fis.close();
            dos.writeUTF(msg);
        }
        else{
            dos.writeUTF("File not found");
        }
        dis.close();
        dos.close();
        s.close();
    }
}
