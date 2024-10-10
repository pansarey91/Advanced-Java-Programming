// Controlling the main Thread. 

class TH1_CurrentThreadDemo
{
  public static void main(String args[])
  {
    Thread t = Thread.currentThread();  
    System.out.println("\n\t Current thread: " + t); 
 
    try
    {
      for(int n = 5; n > 0; n--)
      {
        System.out.println("\n\t"+n); 
        Thread.sleep(1000); 
      } 
    } catch (InterruptedException e){} 
  } 
}