/* we use the put() and get() methods to store and 
	retrieve the key/values pair a Hashtable
	Hashtable() 
	Hashtable(int initialCapacity) 
	Hashtable(int initialCapacity, float loadFactor) 
*/
import java.util.*;
class HashtableDemo7
{ 
	public static void main(String args[])
	{ 
		Hashtable<String,String> h1 = new Hashtable<>();
		h1.put("1","Ramesh");   
		h1.put("2","Suresh");   
		h1.put("3","Ganesh");   
		
		@SuppressWarnings("rawtypes")
		Enumeration en = h1.keys();
		while(en.hasMoreElements())
		{
			String s = (String) en.nextElement();
			System.out.println(s + " - " + h1.get(s));
		}
	}
} 
