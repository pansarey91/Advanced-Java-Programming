import java.util.*;
import java.io.*;

class Ass1SetA1
{
    public static void main(String args[]) throws Exception
    {
        int n,i;
        String srch;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet ts = new TreeSet();

        System.out.print("\n\t How many Elements you want? = ");
        n = Integer.parseInt(br.readLine());

        for (i=0;i<n;i++)
            ts.add(br.readLine());

        System.out.println(ts);

        System.out.print("\n\t Enter Elements to Search = ");
        srch = br.readLine();

        if (ts.contains(srch))
            System.out.println("\n\t "+srch+" Found ");
        else
            System.out.println("\n\t "+srch+" NOT Found ");
    }
}