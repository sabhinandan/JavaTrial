public class ReadingCharsFromString
{
    public static void main(String[] args)
    {
        int[] frequencyData = new int[Character.MAX_VALUE];
        System.out.println(Character.MAX_VALUE);

        String str = "You cannot change me!";
        System.out.println(frequencyData[95]);
        for(int i=0;i<str.length();i++)
        {
            try
            {
                frequencyData[str.charAt(i)]++;
                System.out.println("str.charAt(i) "+str.charAt(i));
            }
            catch(StringIndexOutOfBoundsException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("Character frequence for string: \""+ str+ "\"");
        for(int i=0;i<frequencyData.length;i++)
        {
            if(frequencyData[i]!= 0)
                System.out.println((char)i + " (code" + i +"): " + frequencyData[i]);
        }

    }
}