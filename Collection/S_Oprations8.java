// Stack Operation
import java.util.*;
class S_Oprations8
{
	public static void main(String args[])
	{
		int i,n;
		Stack<Integer> s = new Stack<>();
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("\n\t How many Numbers = ");
			n = sc.nextInt();
					
			System.out.print("\n\t Enter "+n+" Numbers = ");
			for(i=0;i<n;i++)
			{
				s.push(sc.nextInt());
			}
			System.out.println("\n\t Stack Elements = "+s);
			
			System.out.println("\n\t Poping Elements in LIFO manner : ");
			for(i=0;i<n;i++)
			System.out.print("\t"+s.pop());
			sc.close();
		}
	}
}