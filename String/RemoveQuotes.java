
public class RemoveQuotes
{
    public static void main(String[] args)
    {
        String str = "\"Hi THis is String with Quotes\"";
        System.out.println(str);
         if(str.startsWith("\"") && str.endsWith("\""))
		    {
               System.out.println(str.substring(1,str.length() - 1));
	        }
	        else
	        {
                System.out.println(str);
            }
    }
}