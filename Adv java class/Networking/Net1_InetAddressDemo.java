//Program : Demonstrates the methods of the InetAddress class

import java.net.*;

class Net1_InetAddressDemo
{
    public static void main(String[] args) 
    {
        try
        { 
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("Local host's address : " + address);
            
            address = InetAddress.getByName("www.google.in");
            System.out.println("Google's address : " + address);
            
            InetAddress[] allAddresses = InetAddress.getAllByName("www.google.in");
            
            for( int i=0 ; i<allAddresses.length ; i++)
               System.out.println("Address " + i+1 + " : " + allAddresses[i]);
           
        }
        catch(UnknownHostException e)
        {
            e.printStackTrace();
        }
    }   
}