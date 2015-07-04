import java.util.*;
public class CharacterSets
{
    public static void main(String[] args)
    {

        int numArgs =  args.length;
        Set encountered = new HashSet();
        for(int i=0;i<numArgs;i++)
        {
            String argument = args[i];
            Set characters = new HashSet();
            int size = argument.length();
            for(int j=0;j<size;j++)
            {
                characters.add(new Character(argument.charAt(j)));
            }
            Set commonSubset = new HashSet(encountered);
            commonSubset.retainAll(characters);
            boolean areDisjunct = (commonSubset.size() == 0 );
            if(areDisjunct)
            {
                System.out.println(characters + " and "+ encountered + " are disjnct.");
            }
            else
            {
                System.out.println("Not distinct");
            }
            encountered.addAll(characters);
        }
    }
}