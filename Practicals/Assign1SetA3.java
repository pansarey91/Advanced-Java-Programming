import java.util.*;
class Assign1SetA3{
   public static void main(String[] args) {
        
        Hashtable<String,Float> ht=new Hashtable<>();
    
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the no. Of Student");
        int n=sc.nextInt();
        System.out.println("ENter the Student name And Persentage");
        for (int i = 0; i < n; i++) {
            ht.put(sc.next(),sc.nextFloat());
        }
        System.out.println(ht);
        System.out.println("Enter the Key to Search :");
        String s=sc.next();

        if(ht.containsKey(s)){
            System.out.println("Percentage of "+s+" is "+ht.get(s));
        }
        else{
            System.out.println(s+" is not present in HashTable");
        }
        sc.close();
   }

}