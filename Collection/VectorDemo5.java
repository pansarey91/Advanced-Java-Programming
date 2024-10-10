/* Vector 
	Here are the Vector constructors:     
	
	Vector( ) 
	Vector(int size) 
	Vector(int size, int incr) 
	Vector(Collection c) 
*/

import java.util.*; 

class VectorDemo5 
{ 
	public static void main(String args[]) 
	{ 
		
		// initial capcity is 3, increment is 2 
		Vector<Integer> v = new Vector<>(3, 2); 
		
		System.out.println("Initial size: " + v.size()); 
		System.out.println("Initial capacity: " + v.capacity()); 
		
		v.addElement(79); 
		v.addElement(56); 
		v.addElement(49); 
		v.addElement(75); 
		
		System.out.println("Capacity after four additions: " + v.capacity()); 
		v.addElement(5); 
		System.out.println("Current capacity: " + v.capacity()); 
		v.addElement(8); 
		v.addElement(4); 
		
		System.out.println("Current capacity: " + v.capacity()); 
		v.addElement(3); 
		v.addElement(2); 
		
		System.out.println("Current capacity: " + v.capacity()); 
		v.addElement(7); 
		v.addElement(56); 
		
		
		System.out.println("First element: " + (Integer)v.firstElement()); 
		System.out.println("Last element: " + (Integer)v.lastElement()); 
		
		
		if(v.contains(79))
			System.out.println("Vector contains 3."); 
		else
			System.out.println("Ele NOT Found"); 
		
		System.out.println("\n Elements in vector:"+v); 
		
		// enumerate the elements in the vector. 
		@SuppressWarnings("rawtypes")
		Enumeration vEnum = v.elements(); 
				
		System.out.println("\n Elements in vector by Enumeration:"); 
		
		while(vEnum.hasMoreElements()) 
			System.out.println(vEnum.nextElement()); 
	} 
}	