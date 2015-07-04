class Counter extends Thread
{
    private int currentValue;
    public Counter(String threadName)
    {
   //     super(threadName);
   //     setName(threadName);
        currentValue=0;
        System.out.println(this);
        start();
    }
    public int getValue()
    {
        return currentValue;
    }
    public void run()
    {
        try
        {
            while(currentValue <5)
            {
                System.out.println(getName()+" : "+(currentValue++));
                Thread.sleep(250);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println(getName()+" interrupted");
        }
        System.out.println("Exit from thread: "+getName());
    }
}
public class ClientThread
{
    public static void main(String[] args)
    {
        System.out.println("Method main() runs in thread "+Thread.currentThread().getName());
        Counter counterA = new Counter("Counter A");
        Counter counterB = new Counter("Counter B");

        System.out.println("Exit from main() method");
    }
}