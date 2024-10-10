// Create a second thread by extending Thread 

class Nth extends Thread
{
  Nth()
  {
    super("Demo Thread"); 
    System.out.println("\n\t Child thread: " + this); 
    start(); // Start the thread 
  } 
 
  public void run()
  {
    try
    {
      for(int i = 5; i > 0; i--)
      {
        System.out.println("\n\t Child Thread: " + i); 
        Thread.sleep(500); 
      } 
    } catch (InterruptedException e) {}

    System.out.println("\n ***Exiting child thread.***"); 
  } 
} 
 
class TH3_ExtendThread
{
  public static void main(String args[])
  {
    new Nth(); // create a new thread 
 
    try
    {
      for(int i = 5; i > 0; i--)
      {
        System.out.println("\n Main Thread: " + i); 
        Thread.sleep(1000); 
      } 
    } catch (InterruptedException e) {}

    System.out.println("*** Main thread exiting.*** "); 
  } 
}
