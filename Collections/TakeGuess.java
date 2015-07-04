import java.util.*;
public class TakeGuess
{
    final static int NUM_DIGITS = 5;
    public static void main(String[] args)
    {
        // Sanity check on the given dta.
        if(args.length != NUM_DIGITS)
        {
            System.err.println("Guess "+ NUM_DIGITS+ " digits.");
            return;
        }
        /* Initialize the solution list. This prgram has  fixed solution. */
        List secretSolution = new ArrayList();
        secretSolution.add("5");
        secretSolution.add("3");
        secretSolution.add("2");
        secretSolution.add("7");
        secretSolution.add("2");

        //Convert the user's guess from string array to list
        List guess = new ArrayList();
        for(int i=0;i<NUM_DIGITS;i++)
            guess.add(args[i]);

        List duplicate  = new ArrayList(secretSolution);
        int numIncluded = 0;
        for(int i=0;i<NUM_DIGITS;i++)
        {
            if(duplicate.remove(guess.get(i)))
                numIncluded++;

        }
        /* Find the number correctly placed digits by comparing the two
        lists, elemen by element, counting eadh correct placement.
        */
        ListIterator correct = secretSolution.listIterator();
        ListIterator attempt = guess.listIterator();
        int numPlaced = 0;
        while(correct.hasNext())
        {
            if(correct.next().equals(attempt.next()))
                numPlaced++;
        }
        System.out.println(numIncluded+" digit(s) correctly included");
        System.out.println(numPlaced+ " digit(s) correctly placed");
    }
}