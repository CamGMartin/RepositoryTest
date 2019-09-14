// Cameron Martin
package hangmancameronmartin;

import java.util.Scanner;

public class HangManCameronMartin
{
    public static char[] explode(String word)
    {
        //converts random word string to character array
        char[] rWordLetters = word.toCharArray();
        return rWordLetters;
    }

    public static char[] alphabetCheck(char userGuess, char[] alphabet)
    {
        //replaces user alphabet display with blank spaces for each letter input
        for (int i = 0; i < alphabet.length; i++)
        {
            if (alphabet[i] == userGuess)
            {
                alphabet[i] = '_';
            }
        }
        return alphabet;
    }

    public static char[] letterGuessCheck(char userGuess, char[] rWordLetters, char[] rWordDisplay)
    {
        /*compares user input letter to random word letter array and inserts correct user input letter into
        blank letter display*/
        for (int i = 0; i < rWordLetters.length; i++)
        {
            if (rWordLetters[i] == userGuess)
            {
                rWordDisplay[i] = rWordLetters[i];
            }
        }
        return rWordDisplay;
    }

    public static String checkGuess(char userGuess, char[] rWordLetters, String rWord)
    {
        String result = null;

        //copies random word array for comparison
        char[] rWordLettersCopy = new char[rWordLetters.length];
        for (int i = 0; i < rWordLetters.length; i++)
        {
            rWordLettersCopy[i] = rWordLetters[i];
        }

        //condition that alters random word array copy according to usetr correct letter input
        for (int i = 0; i < rWordLetters.length; i++)
        {
            if (rWordLetters[i] == userGuess)
            {
                rWordLettersCopy[i] = 'X';
            }
        }

        //converts random word copy array to string for comparison
        String newRWord = new String(rWordLettersCopy);

        /*compares strings of random word to altered random word copy to return if user input is an
        incorrect guess*/
        if (rWord.equals(newRWord))
        {
            result = "incorrect guess";
        }
        return result;
    }

    public static boolean hangmanBuild(int gameCount)
    {
        //code to display build of hangman
        boolean gameOver = false;
        if (gameCount == 0)
        {
            System.out.println(" ");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("");
        }
        if (gameCount == 1)
        {
            System.out.println(" ");
            System.out.println("|        O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("");
        }
        if (gameCount == 2)
        {
            System.out.println(" ");
            System.out.println("|        O");
            System.out.println("|        |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("");
        }
        if (gameCount == 3)
        {
            System.out.println(" ");
            System.out.println("|        O");
            System.out.println("|       /|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("");
        }
        if (gameCount == 4)
        {
            System.out.println(" ");
            System.out.println("|        O");
            System.out.println("|       /|\\");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("");
        }
        if (gameCount == 5)
        {
            System.out.println(" ");
            System.out.println("|        O");
            System.out.println("|       /|\\");
            System.out.println("|        |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("");
        }
        if (gameCount == 6)
        {
            System.out.println(" ");
            System.out.println("|        O");
            System.out.println("|       /|\\");
            System.out.println("|        |");
            System.out.println("|       /");
            System.out.println("|");
            System.out.println("");
        }
        if (gameCount == 7)
        {
            System.out.println(" ");
            System.out.println("|        O");
            System.out.println("|       /|\\");
            System.out.println("|        |");
            System.out.println("|       / \\");
            System.out.println("|");
            System.out.println("");
            gameOver = true;
        }
        return gameOver;
    }

    public static void main(String[] args)
    {
        loadGame();
    }
    
    public static void loadGame()
    {  
        String[] words = new String[]
        {
            "javascript", "declaration", "object", "class",
            "failing"
        };

        String rWord = words[(int) (Math.random() * words.length)];

        char[] alphabet = new char[]
        {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        };

        char[] rWordLetters = explode(rWord);

        //creates blank display for user letter input
        char[] rWordDisplay = new char[rWordLetters.length];
        for (int i = 0; i < rWordLetters.length; i++)
        {
            rWordDisplay[i] = '_';
        }

        //code for startup display of game
        System.out.println("");
        System.out.println("---------- ");
        System.out.print("|        |            ");
        for (int i = 0; i < alphabet.length; i++)
        {
            System.out.print(alphabet[i] + " ");
        }
        System.out.println(" ");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("");

        for (int i = 0; i < rWordDisplay.length; i++)
        {
            System.out.print(rWordDisplay[i]);
            System.out.print(" ");
        }
        System.out.println("");

        int gameCount = 0;
        boolean gameOver = false;

        //condition that causes the game to repeat
        while (gameOver == false)
        {
            Scanner input;
            input = new Scanner(System.in);
            System.out.println("");
            System.out.println("Guess a letter: ");
            char userGuess = input.next().charAt(0);

            String result = checkGuess(userGuess, rWordLetters, rWord);

            //condition to track amount of incorrect lettetr guesses
            if (result == "incorrect guess")
            {
                gameCount++;
            }

            System.out.println("");
            System.out.println("---------- ");
            System.out.print("|        |            ");

            //displays alphabet letters available to user
            char[] alphabetDisplay = alphabetCheck(userGuess, alphabet);
            for (int i = 0; i < alphabetDisplay.length; i++)
            {
                System.out.print(alphabetDisplay[i] + " ");
            }

            gameOver = hangmanBuild(gameCount);

            char[] letterGuessDisplay = letterGuessCheck(userGuess, rWordLetters, rWordDisplay);

            //Condition to compare strings to win the game
            String winGame = new String(letterGuessDisplay);
            if (rWord.equals(winGame))
            {
                System.out.println(rWord);
                System.out.println("");
                System.out.println("YOU WIN!");
                loadGame();
            }

            //displays correct letter guess
            for (int i = 0; i < rWordDisplay.length; i++)
            {
                System.out.print(rWordDisplay[i] + " ");
            }
            System.out.println("");

            //condition to lose the game
            if (gameOver == true)
            {
                System.out.println("");
                System.out.println("YOU lOSE! Game Over!");
                loadGame();
            }
        }
    }
}
