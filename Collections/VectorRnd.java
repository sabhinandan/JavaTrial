import java.util.*;

public class VectorRnd
{
    public static void main(String[] args)
    {
        Vector<String> vecFirst = new Vector<String>();
        vecFirst.add("String1");
        vecFirst.add("String2");
        vecFirst.add("String3");

        //System.out.println(vecFirst.firstElement());
        //vecFirst.remove(0);
        //System.out.println(vecFirst.firstElement());
        for(String s : vecFirst)
        {
            System.out.println(s);
        }
    }
}