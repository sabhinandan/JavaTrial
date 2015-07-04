packate javaapplication1;
class StackImpl
{
    private Object[] stackArray;
    private int topOfStack;
    public StackImpl(int capacity)
    {
        stackArray = new Object[capacity];
        topOfStack=-1;
    }
    public boolean push(Object element)
    {
        if(isFull()) return false;
        ++topOfStack;
        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e) {  }
        stackArray[topOfStack]=element;
        return true;
    }
    public Object pop()
    {
        if(isEmpty()) return null;
        Object obj = stackArray[topOfStack];
        stackArray[topOfStack]=null;
        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e) {   }
        topOfStack--;
        return obj;
    }
    public boolean isEmpty()
    {
        return topOfStack < 0;
    }
    public boolean isFull()
    {
        return topOfStack >=stackArray.length -1;
    }
}
public class Mutex
{
    public static void main(String[] args)
    {
        final StackImpl stack = new StackImpl(20);
        (new Thread("Pusher")
        {
            public void run()
            {
                for(;;)
                {
                    System.out.println("Pushed: "+stack.push(new Integer(2003)));
                }
            }
        }).start();

        (new Thread("Popper")
        {
            public void run()
            {
                for(;;)
                {
                    System.out.println("Popped: "+stack.pop());
                }
            }
        }).start();
        System.out.println("Exit from main().");
    }
}