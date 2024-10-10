//Program : Client Socket

import java.net.*; 
import java.io.*;

class Net5_MyClient
{
 public static void main(String args[]) 
 {	
  try{
		InetAddress addr = InetAddress.getByName("localhost");
		Socket s=new Socket (addr, 4444);
		System.out.println (s.getInetAddress());	
		System.out.println (s.getPort());		
		System.out.println (s.getLocalPort());		
		s.close();
     }
	catch(Exception e)
	{ e.printStackTrace(); }
 }
}
