// lamba expression background

interface int1
{
	void disp();
}

class lambda1
{
	public static void main(String args[])
	{
		int1 obj = ()->	System.out.println("\n\t I am in disp()");
		obj.disp();
	}
}
