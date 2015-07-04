import java.util.*;

public class HashMapRND
{
    public static void main(String[] args)
    {
        HashMap hashMap = new HashMap();
        HashMap hashMap1 = new HashMap();
        System.out.println(hashMap1.size());
        Vector v = new Vector();
        Vector v2 = new Vector();
   //     v.add("Str1");
   //     v.add("Str2");
        v.add("Str3");
        hashMap.put("s1",v);
        v2 = (Vector)hashMap.get("s12");
        if(v2 == null)
            System.out.println("v2 is null")  ;
        v2 = new Vector();
        v2.add("Str4");
        hashMap.put("s1",v2);
        v = (Vector)hashMap.get("s1");

        Iterator it;
        it = v.iterator();
        while(it.hasNext())
        {
            System.out.println((String)it.next());
        }



    }

}