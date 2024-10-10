// Create a second thread. 

class NewThread implements Runnable
{
  Thread t; 
 
  NewThread()
  {
    t = new Thread(this, "Demo Thread"); 
    System.out.println("\n\t Child thread: " + t); 
    t.start();
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
    System.out.println("\n*** Exiting child thread. ***"); 
  } 
} 
 
class TH2_ThreadDemo
{
  public static void main(String args[])
  {
    new NewThread();
 
    try
    {
      for(int i = 5; i > 0; i--)
      {
        System.out.println("\n Main Thread: " + i); 
        Thread.sleep(1000); 
      } 
    } catch (InterruptedException e) {} 
    System.out.println("\n*** Main thread exiting. ***"); 
  } 
}
