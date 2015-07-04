public class AvoidNull
{
    public static void main(String[] args)
    {
        String s = null ;
        System.out.println("This is string"+blanknull(s)+"Completed");
    }
    static String blanknull(String s)
    {
        return (s == null) ? "\"\"" : s;
    }
}