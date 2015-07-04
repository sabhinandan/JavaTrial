//Just to check the setDaemon property and a simple calling of thread.
class Counter implements Runnable
{
    private int currentValue;
    private Thread worker;
    public Counter(String threadName)
    {
        currentValue=0;
        worker = new Thread(this,threadName);
        System.out.println(worker);
//        worker.setDaemon(true);
        worker.start();
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
                System.out.println(worker.getName() + ": "+(currentValue++));
                Thread.sleep(250);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println(worker.getName()+" interruped.");
        }
        System.out.println("Exit from thread: "+worker.getName());
    }
}
public class Client
{
    public static void main(String[] args)
    {
        Counter counterA = new Counter("Counter A");

        try
        {
            int val;
            do
            {
                val=counterA.getValue();
                System.out.println("Counter value read by main thread: "+val);
                Thread.sleep(100);
            }while(val<5);
        }
        catch(InterruptedException e)
        {
            System.out.println("main thread interruped");
        }
        System.out.println("Exit from main thread");
    }
}