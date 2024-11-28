import java.util.*;

class Ass1SetA2
{
    public static void main(String args[])
    {
		LinkedList colors = new LinkedList();
		colors.add("red");
		colors.add("blue");
		colors.add("yellow");
		colors.add("orange");
        System.out.print(colors);
		
		System.out.println("\n\nContents of List using an Iterator : ");
		Iterator i = colors.iterator();
		while(i.hasNext())
			System.out.println(i.next());

		System.out.println("\n\nReverse Contents of List using ListIterator : ");
		ListIterator li = colors.listIterator(colors.size());
		// Iterate in reverse.
		while(li.hasPrevious()) 
			System.out.println(li.previous());
		
		LinkedList colors2 = new LinkedList();
		colors2.add("pink");
		colors2.add("green");

        colors.addAll(2,colors2);
		System.out.println("\n\nAfter adding another List : ");
        System.out.println(colors);		
	}
}