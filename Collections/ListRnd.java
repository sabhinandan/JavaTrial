import java.util.*;
public class ListRnd
{
    public static void main(String[] args)
    {
        int[] intArray = {1,2,1,5,3,4};
        List list = new ArrayList();
        for(int i=0;i<intArray.length;i++)
        {
            list.add(new Integer(intArray[i]));
        }

        Iterator listIterator = list.iterator();

        while(listIterator.hasNext())
        {
            System.out.println(listIterator.next());
        }

    }
}