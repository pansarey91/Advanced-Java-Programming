class firstth extends Thread{
    String msg;
    public firstth(String msg) {
        this.msg=msg;
    }
    public void run(){
        int i=0;
        while(true){
            System.out.println(msg+" "+i);
            i++;
        }
    }
    
}
class Assign2SetA1{
    public static void main(String[] args) {
        firstth obj=new firstth("Thread");
        firstth obj2=new firstth("Thread 2");
        obj.start();
        obj2.start();
    }
}