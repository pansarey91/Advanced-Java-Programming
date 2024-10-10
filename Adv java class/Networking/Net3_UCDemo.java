//Program : URLConnection class

import java.net.*;
import java.io.*;
import java.util.Date;

class Net3_UCDemo
{
	public static void main(String args[]) throws Exception 
	{
        URL myURL = new URL("https://tccollege.org");
		URLConnection uc = myURL.openConnection();

		System.out.println("Date: " + new Date(uc.getDate()));
		System.out.println("Content-Type: " + uc.getContentType());
		System.out.println("Expires: " + uc.getExpiration());
		System.out.println("Last-Modified: " + new Date(uc.getLastModified()));
	}
}
