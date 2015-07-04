import java.util.*;
public class ComparatorUsage
{
    public static void main(String[] args)
    {
        //Set strSet = new TreeSet();
        //Set strSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        Set strSet = new TreeSet(new RhymingStringComparator());
        for(int i=0;i<args.length;i++)
        {
             strSet.add(args[i]);
        }
        System.out.println(strSet);
    }

}
class RhymingStringComparator implements Comparator
{
    public int compare(Object obj1, Object obj2)
    {
        String reverseStr1 = new StringBuffer((String)obj1).reverse().toString();
        String reverseStr2 = new StringBuffer((String)obj2).reverse().toString();
        return reverseStr1.compareTo(reverseStr2);
    }
}