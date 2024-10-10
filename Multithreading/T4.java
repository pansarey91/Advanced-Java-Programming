class MT extends Thread
{
	public void run()
	{
		System.out.println("Thread is Running."); 
	}	
}

class T4
{
  public static void main(String args[])
  {
	  MT obj = new MT();
	  obj.start();
  }
}