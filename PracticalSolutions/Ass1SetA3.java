import java.io.*;
import java.util.*;

class Ass1SetA3
{
	public static void main(String arg[]) throws IOException
	{
		Hashtable HT=new Hashtable();
		String str;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		HT.put("Nagesh", new Double(77.88));
		HT.put("Amrut",new Double(57.87));
		HT.put("Pallavi",new Double(88.67));
		HT.put("Ramesh",new Double(80.58));
		
		System.out.println(HT+"\n\n");

		System.out.println("Enter student name to search :");
		str=br.readLine();
		
		if(HT.containsKey(str))
			System.out.println("\n\t Name : "+str+"\n\t Parc : "+HT.get(str));
		else
			System.out.println("\n\t Student info NOT found");	
	}
}