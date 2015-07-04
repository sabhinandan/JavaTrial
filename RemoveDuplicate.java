class RemoveDuplicate
{
    public static void main(String args[])
    {
     String str1="HHBQ";
    String str2=new String(removeDuplicate(str1));

   System.out.println("The final string is " + str2 + " end");
   System.out.println("end");
    }
    public static String removeDuplicate(String str)
    {
     int len= str.length();
     int Str2Count=-1;
     int flag=1;
     char[] sourceStr = str.toCharArray();
     char[] finalStr = new char[len];
     char tempChar;
     for(int k=0;k<len;k++)
     {
          tempChar=sourceStr[k];

        for(int j=0;j<len;j++)
        {
          if(tempChar==finalStr[j])
             {
                flag=0;
                break;
             }
           else
          {
                flag=1;
          }
        }
        if(flag==1)
        {
           finalStr[++Str2Count]=tempChar;
        }
     }
     String temp= new String(finalStr);
     return (temp.trim());
    }
}    // main class