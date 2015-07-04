import java.util.regex.*;
class CheckPattern
{
    public static void main(String[] args)
    {
        Pattern p = Pattern.compile("a*b");
        Matcher m = p.matcher("aaaaab");
        boolean b = m.matches();
    }
}