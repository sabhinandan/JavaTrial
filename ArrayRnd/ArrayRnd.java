class ArrayRnd
{
    public static void main(String[] args)
    {
        String str = "Hello";
        char[] charStr = str.toCharArray();
        int i = 0;
        while(i != charStr.length)
        {
            System.out.println(charStr[i]);
            i++;
        }

    }
}