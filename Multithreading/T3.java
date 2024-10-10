class T3
{
  public static void main(String args[])
  {
    Thread t = Thread.currentThread(); 
    System.out.println("\n\t Current thread: " + t); 
 
    try
    {
     System.out.println("\n\t Now I am Sleeping ...");

        Thread.sleep(3000);   // Time is in  Mili Sec.

      System.out.println("\n\t Now I am Wake UP ...");  
    } catch (Exception e){} 
  } 
}