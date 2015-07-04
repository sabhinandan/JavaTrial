import java.util.*;
public class SetRnd
{
    public static void main(String[] args)
    {
        int[] intArray = {1,2,12,5,3,4};
        Set hashSet = new LinkedHashSet();
        //Set hashSet = new HashSet();
        for(int i=0;i<intArray.length;i++)
        {
            hashSet.add(new Integer(intArray[i]));
        }
        Iterator setIterator = hashSet.iterator();
        while(setIterator.hasNext())
        {
            System.out.println(setIterator.next());
        }
    }
}