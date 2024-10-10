//Program :  URL class

import java.net.*;

class Net2_URLDemo
{
 public static void main(String args[]) throws MalformedURLException
 {

  URL myURL = new URL ("http://www.oracle.com/technetwork/java/index.html");
  System.out.println("Protocol is:" + myURL.getProtocol()); 
  System.out.println("Port is:" + myURL.getPort()); 
  System.out.println("Host is:" + myURL.getHost()); 
  System.out.println("File is:" + myURL.getFile()); 
 }
}