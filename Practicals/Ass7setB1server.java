import java.util.*;
import java.io.*;
import java.net.*;
public class Ass7setB1server {
    public static void main(String[] args) throws UnknownHostException, IOException {
        String fn,msg="";
        File f;

        ServerSocket ss = new ServerSocket(4444);
        System.out.println("Server is running...");

        Socket s = ss.accept();
        System.out.println("Client is connected...");

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        ArrayList<String> al=new ArrayList<>();

        while(true){
            fn=dis.readUTF();
            if(fn.equals("end")){
                break;
            }
            else{
                al.add(fn);
                System.out.println("File Name is : "+fn);
            }
        }

        for(int i=0;i<al.size();i++){
            f=new File(al.get(i));
            if(f.exists()){
                
                dos.writeUTF(al.get(i).toString()+" is Exists");
            }
            else{
                dos.writeUTF(al.get(i).toString()+" is Not Exists");
            }
        }
        
    }
}
