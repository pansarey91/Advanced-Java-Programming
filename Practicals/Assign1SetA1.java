import java.util.*;

class Assign1SetA1{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("ENter the no. elements to add :");
        int n=sc.nextInt();
        TreeSet<Integer> t=new TreeSet<>();
        System.out.println("Enter the "+n+" elements :");
        for(int i=0;i<n;i++){
            t.add(sc.nextInt());
        }

        System.out.println("Sorted Order :"+t);
        System.out.println("Enter the element to Search :");
        int search=sc.nextInt();
        if(t.contains(search)){
            System.out.println(search+" is in the Set");
        }
        else{
            System.out.println(search+" is Not in the Set");
        }

        sc.close();
    }
}