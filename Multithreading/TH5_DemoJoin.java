// Using join() to wait for threads to finish. 

class NT implements Runnable
{
  String name; // name of thread 
  Thread t; 
 
  NT(String threadname)
  {
    name = threadname; 
    t = new Thread(this, name);

    System.out.println("New thread: " + t); 
    t.start(); 
  } 
 
  public void run()
  {
    try
    {
      for(int i = 5; i > 0; i--)
      {
        System.out.println(name + ": " + i); 
        Thread.sleep(1000); 
      } 
    } catch (InterruptedException e) {} 
    System.out.println("\n\t*** "+name + " exiting.***"); 
  } 
} 
 
class TH5_DemoJoin
{
  public static void main(String args[])
  {
    NT ob1 = new NT("One"); 
    NT ob2 = new NT("Two"); 
    NT ob3 = new NT("Three"); 
 
    System.out.println("Thread One is alive: " + ob1.t.isAlive()); 
    System.out.println("Thread Two is alive: " + ob2.t.isAlive()); 
    System.out.println("Thread Three is alive: "+ ob3.t.isAlive()); 
    // wait for threads to finish   
 
   try
   {
      System.out.println("*** Waiting for threads to finish***."); 
      ob1.t.join(); 
      ob2.t.join(); 
      ob3.t.join(); 
    } catch (InterruptedException e) {} 
 
    System.out.println("Thread One is alive: " + ob1.t.isAlive()); 
    System.out.println("Thread Two is alive: " + ob2.t.isAlive()); 
    System.out.println("Thread Three is alive: " + ob3.t.isAlive()); 
 
    System.out.println("*** Main thread exiting. ***"); 
  } 
}