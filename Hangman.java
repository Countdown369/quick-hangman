import java.util.*;
public class Hangman
{
    public static void main(String[] args)
    {
        Scanner k = new Scanner(System.in);
        System.out.println("Agree on how many guesses Player 2 will be allowed before they lose, and then input the number.");
        int guessnumbering = k.nextInt();
        System.out.println("Player 1, please enter your SECRET word.");
        String secretword = k.next();
        for (int spacing = 0; spacing < 50; spacing++)
        {
            System.out.println("\n");
        }
        ArrayList<String> characters = new ArrayList<String>();
        for (int i = 0; i < secretword.length(); i++)
        {
            characters.add(secretword.substring(i, (i+1)));
        }
        ArrayList<String> game = new ArrayList<String>();
        for (int m = 0; m < secretword.length(); m++)
        {
            game.add("-");
        }
        System.out.println("Player 2, please make your guesses.");
        int f = guessnumbering + 1;
        do
        {
            ArrayList<String> temp = new ArrayList<String>();
            for (int z = 0; z < secretword.length(); z++)
            {
                temp.add(game.get(z));
            }
            String guess = k.nextLine();
            for (int x = 0; x < secretword.length(); x++)
            {
                if (guess.equals(characters.get(x)))
                {
                    game.set(x, guess);
                }
            }
            int part = 0;
            for (int d = 0; d < secretword.length(); d++)
            {
                if ((game.get(d)).equals((temp.get(d))))
                {
                    part++;
                }
                if (part == secretword.length())
                {
                    f--;
                    d+=(secretword.length()+1);
                }
            }
            for (int y = 0; y < secretword.length(); y++)
            {
                System.out.print(game.get(y));
            }
            int arb = 0;
            for (int p = 0; p < secretword.length(); p++)
            {
                if ((game.get(p)).equals("-"))
                {
                    arb++;
                }
            }
            if (arb == 0)
            {
                System.out.println("\n" + "Player 2 wins!");
                f = -1;
            }
            if (f > 0)
            {
                System.out.println("\n" + "This is how the game stands. You have " + f + " guess(es) left.");
            }
        } while (f > 0);
        if (f == 0)
        {
            System.out.println("\n" + "Player 1 wins! The word was \"" + secretword + "\".");
        }
    }
}