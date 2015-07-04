import java.util.StringTokenizer;
import java.io.*;

public class StringTokenizerTest1
{
    public static void main(String[] args)
    {
        String test = "";
       try{
        Reader inp = new FileReader("temp.txt");
        StreamTokenizer tstream = new StreamTokenizer(inp);
      tstream.wordChars(0, 99);
        tstream.eolIsSignificant(true);
//		  StringTokenizer stringTokenizer = new StringTokenizer(test,",");
            int i=0;
           tstream.nextToken();
        while(tstream.ttype != StreamTokenizer.TT_EOF)
        {
           //i++;
           //stringTokenizer.nextToken();
           //System.out.print(tstream.nextToken());
           if(tstream.ttype == StreamTokenizer.TT_WORD )
           {
              System.out.print(tstream.toString());
           }
           tstream.nextToken();

        }


  //      System.out.println("Tokens are "+i);
/*
        String[] result = "This,is,','new,String".split(",");
        for(int x=0;x<result.length;x++)
          System.out.println(result[x]);
        System.out.println(result.length);
  */
        }
        catch(Exception e)
        {

        }
    }
}