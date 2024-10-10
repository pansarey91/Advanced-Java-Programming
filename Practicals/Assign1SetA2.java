import java.util.*;
class Assign1SetA2{
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int ch;
        LinkedList<String> ll=new LinkedList<>();

        ll.add("red");
        ll.add("blue");
        ll.add("yellow");
        ll.add("orange");

        do{
            System.out.println("\n 1.Display the Content Using List Iterator\n 2.Display the Content Using List Iterator in Reverse Order\n 3.Create New list And add it in the main List\n 4.Exit\n");
            System.out.println("Enter Your Choice :");
            ch=sc.nextInt();
            switch(ch){
                case 1:
                        Iterator l=ll.iterator();
                        while(l.hasNext()){
                            String ele=(String) l.next();
                            System.out.println("Colors ="+ele);
                        }                    
                    break;
                case 2:
                        ListIterator i=ll.listIterator(ll.size());
                        while(i.hasPrevious()){
                            System.out.println("Colors ="+i.previous());
                        } 
                    break;
                case 3:
                        LinkedList<String> ll1=new LinkedList<>();
                        ll1.add("pink");
                        ll1.add("green");
                        ll.addAll(2, ll1);
                        System.out.println("Color ="+ll);
                    break;
                case 4:
                    System.out.println("\n Come Back Soon");
                    break;
                default :
                    System.out.println("\n Plz enter the valid Choice");
            }

        }while(ch!=4);
        sc.close();
    }
}