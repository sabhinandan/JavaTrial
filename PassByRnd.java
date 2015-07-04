class PassByRnd
{
    public static void main(String[] args)
    {
        StringBuffer x = new StringBuffer("ABC");
        giveMeAString (x);
        System.out.println (x);
    }
    static void giveMeAString (StringBuffer y)
    {
        y.append("Xtra");
    }

}