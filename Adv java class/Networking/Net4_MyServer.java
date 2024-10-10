//Program : Server Socket

import java.net.*;  
import java.io.*;

class Net4_MyServer
{
	public static void main(String args[])
	throws UnknownHostException, IOException
	{ 	
		ServerSocket ss=new ServerSocket(4444);
		System.out.println("Server Started ... Wating for client");
		Socket s = ss.accept();	
		System.out.println("client connected");
		s.close();
 	}
}
