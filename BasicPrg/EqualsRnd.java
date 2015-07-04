public class EqualsRnd
{
    public static void main(String[] args)
    {
        String str1 = "hi";
        String str2= "hi";
        String str3 = new String("hi");
        String str4 = str3;
        str4="good buy";
        System.out.println(str3);
        //String str3=str1;
        "hi".replace('h','d');
        //str2="good bye";
        System.out.println("str1 is "+str1);
        if(str1==str2)
        {
            System.out.println("str1 == str2");
        }
        if(str1==str3)
        {
            System.out.println("str1==str3");
        }
        if(str1.equals(str3))
        {
            System.out.println("str1.euqals(str3)");
        }
    }
}