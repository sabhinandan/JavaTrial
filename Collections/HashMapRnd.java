
import java.util.*;

public class HashMapRnd
{
 private static final Integer ONE = new Integer(1);
 public static void main(String args[])
 {
  Map m = new HashMap();
  Collection c = new ArrayList();
  for(int i=0;i<args.length;i++)
  {
      c.add(args[i]);
  }
 TreeSet hashSet = removeDups(c);

System.out.println(hashSet);

  // Initialize frequency table from command line
/*  for (int i=0; i < args.length; i++)
   {
      Integer freq = (Integer) m.get(args[i]);
      System.out.println(freq);
      m.put(args[i], (freq==null ? ONE :
      new Integer(freq.intValue() + 1)));
   }
        System.out.println(m.size()+ " distinct words detected:");
        System.out.println(m);
  */
   }
public static TreeSet removeDups(Collection c)
  {
    return new TreeSet(c);
    }
}