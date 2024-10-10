class myyash implements Runnable 
{
    public void run()
	{ 
        System.out.println("Thread using Runnable interface."); 
    } 
}

class T5
{
  public static void main(String args[])
  {
	  Thread obj = new Thread(new myyash());
	  obj.start();
  }
}