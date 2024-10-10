 class T2 {
    public static void main(String args[])
  {
    Thread t = Thread.currentThread(); 
    System.out.println("\n\t Current thread: " + t); 
 
    // change the name of the thread 
    t.setName("New_Thrd"); 
    System.out.println("\n\t After name change: " + t); 
  } 
}
