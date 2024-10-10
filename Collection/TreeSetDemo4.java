/* The TreeSet Class
	
	The following constructors are defined:     
	
	TreeSet( ) 
	TreeSet(Collection c) 
	TreeSet(Comparator comp) 
	TreeSet(SortedSet ss) 
*/

import java.util.*; 

class TreeSetDemo4
{ 
	public static void main(String args[]) 
	{ 
		// Create a tree set 
		TreeSet<String> ts = new TreeSet<String>(); 
		
		// Add elements to the tree set 
		ts.add("C"); 
		ts.add("A"); 
		ts.add("B"); 
		ts.add("E"); 
		ts.add("F"); 
		ts.add("D"); 
		
		System.out.println(ts); 
	} 
}