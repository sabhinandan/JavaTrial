import java.util.StringTokenizer;

public class StringTokenizerTest
{
    public static void main(String[] args)
    {
        String test = "This,is,','new,String,";
        StringTokenizer stringTokenizer = new StringTokenizer(test,",");
        int i=0;
/*
        while(stringTokenizer.hasMoreTokens())
        {
           i++;
           //stringTokenizer.nextToken();
           System.out.println(stringTokenizer.nextElement());

        }
*/

  //      System.out.println("Tokens are "+i);

        String[] result = "This,is,','new,String".split(",");
        for(int x=0;x<result.length;x++)
          System.out.println(result[x]);
        System.out.println(result.length);


    }
}