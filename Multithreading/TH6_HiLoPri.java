// Demonstrate thread priorities. 

class clicker implements Runnable
{
  int click = 0; 
  Thread t; 
  boolean running = true; 
 
  public clicker(int p)
  {
    t = new Thread(this); 
    t.setPriority(p); 
  } 
 
  public void run()
  {
    while (running)
    {
      click++; 
    } 
  } 
 
  public void stop()
  {
    running = false; 
  } 
 
  public void start()
  {
    t.start(); 
  } 
} 
 
class TH6_HiLoPri
{
  public static void main(String args[])
  {
    Thread.currentThread().setPriority(Thread.MAX_PRIORITY); 
    clicker hi = new clicker(Thread.NORM_PRIORITY + 2); 
    clicker lo = new clicker(Thread.NORM_PRIORITY - 2); 
 
    lo.start(); 
    hi.start(); 

    try
    {
      Thread.sleep(5000); 
    } catch (InterruptedException e) {}
 
    lo.stop(); 
    hi.stop(); 
 
    // Wait for child threads to terminate. 
    try
    {
      hi.t.join(); 
      lo.t.join(); 
    } catch (InterruptedException e) {} 
 
    System.out.println("Low-priority thread: " + lo.click);  
    System.out.println("High-priority thread: " + hi.click); 
  } 
}