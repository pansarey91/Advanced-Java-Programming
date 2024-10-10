class Th1 implements Runnable
{
    int n;
    Thread t; 
    String nm;
 
  Th1(int n,String name)
  {
    this.n=n;
    this.nm=name;
    t = new Thread(this); 
    //System.out.println("Thrd one: " + t); 
    t.start();
  } 
 
  public void run()
  {
   try
   {
      for(int i=1; i <=n; i++)
      {
        System.err.println("I am in " +nm+ "," +i);
        Thread.sleep(500); 
      } 
    } catch (InterruptedException e) {}

    System.out.println(" *** "+t + " exiting. ***"); 
  } 
} 
class Assign2SetA3
{
  public static void main(String args[])throws Exception
  { 
    Th1 ob1=new Th1(10,"FY");
    ob1.t.join();
    Th1 ob2=new Th1(20,"SY");
    ob2.t.join();
    Th1 ob3=new Th1(30,"TY");
    ob3.t.join();
    
    System.out.println("*** Main thread exiting. ***"); 
  } 
}