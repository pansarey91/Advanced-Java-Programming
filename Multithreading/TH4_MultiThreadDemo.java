// Create multiple threads.   

class NewTh implements Runnable
{
  String name; // name of thread 
  Thread t; 
 
  NewTh(String threadname)
  {
    name = threadname; 
    t = new Thread(this,name); 
    System.out.println("New Thrd : " + t); 
    t.start();
  } 
 
  public void run()
  {
   try
   {
      for(int i = 5; i > 0; i--)
      {
        System.out.println("\n\t "+name + ":"+i); 
        Thread.sleep(1000); 
      } 
    } catch (InterruptedException e) {}

    System.out.println(" *** "+name + " exiting. ***"); 
  } 
} 
 
class TH4_MultiThreadDemo
{
  public static void main(String args[])
  {
    new NewTh("One"); // start threads 
    new NewTh("Two"); 
    new NewTh("Three"); 
 
    try
    {
      Thread.sleep(10000); 
    } catch (InterruptedException e) {} 
 
    System.out.println("*** Main thread exiting. ***"); 
  } 
}