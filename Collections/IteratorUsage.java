import java.util.*;
public class IteratorUsage
{
    public static void main(String[] args)
    {
        Collection intList = new ArrayList();
        int[] values={9,11,2,-4,13,99,0};
        for(int i=0;i<values.length;i++)
        {
            intList.add(new Integer(values[i]));
        }
        System.out.println("Before "+intList);
        Iterator intIterator = intList.iterator();
        while(intIterator.hasNext())
        {
            Integer element = (Integer)intIterator.next();
            int value = element.intValue();
            if(value < 1 || value >10)
                intIterator.remove();
        }
        System.out.println("After "+intList);
    }
}