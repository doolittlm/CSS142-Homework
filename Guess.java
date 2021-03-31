import java.util.*;

/* Stephanie Liu
 * Homework 5
 * Number guessing game that gives hints of higher or lower and reports stats at the end.
 * The correct number can be 1 - MAX_NUMBER
 *
 * At a minimum, program should have the following methods:
 * a method that introduces the game to the user
 * a method to play one game with the user (just one game, not multiple games)
 * a method to report overall results to the user
 *
 * Deciding whether or not to play another game is determined by either y or n as first console entry
 * Rest of the content doesn't matter (nope, yup, YES, nein) - if it's not yes, it's no.
 *
 * Assume all guesses entered will be valid integers within the range.
 *
 * @param MAX_NUMBER - the max number the random number is allowed to be
 */
public class Guess {
    public static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
        introduction();
        Scanner console = new Scanner(System.in);
        int numberOfGames = 0;
        int guesses = 0;
        int totalGuesses = 0;
        int bestGame = -1;
        boolean playAgain = true;
        while (playAgain) {
            guesses = playOneGame(console);
            totalGuesses += guesses;
            if (bestGame == -1 || bestGame > guesses) {
                bestGame = guesses;
            }
            numberOfGames++;
            playAgain = playAgainChoice(console);
        }
        reportGameStats(numberOfGames, totalGuesses, bestGame);
    }

    /* @fn introduction()
     * Prints the introduction message with directions in the console.
     */
    public static void introduction() {
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and");
        System.out.println(MAX_NUMBER + " and will allow you to guess until");
        System.out.println("you get it. For each guess, I will tell you");
        System.out.println("whether the right answer is higher or lower");
        System.out.println("than your guess.");
        System.out.println();
    }

    /* @fn playOneGame(Scanner console)
     * Plays one round of guessing game where player attempts to guess the right number.
     *
     * @param[in] - object Scanner console allows user input
     * @param[in/out] correctNumber - A pseudorandom number between 1 and MAX_NUMBER,
     * sent to IsNumberHigherOrLower to give a hint.
     * @param[in/out] guess - Users guess - sent to isNumberHigherOrLower to give guess hint.
     * @param[in/out] guessCounter - increases for each guess entered, returned to calculate stats at end
     */
    public static int playOneGame(Scanner console) {
        System.out.println("I'm thinking of a number between 1 and " + MAX_NUMBER + "...");
        Random randomObject = new Random();
        int correctNumber = randomObject.nextInt(MAX_NUMBER) + 1;
        int guess = 0;
        int guessCounter = 0;
        while (guess != correctNumber) {
            System.out.println("Your guess?");
            guess = console.nextInt();
            isNumberHigherOrLower(guess, correctNumber);
            guessCounter++;
        }
        reportNumberOfGuesses(guessCounter);
        return guessCounter;
    }

    /* @fn isNumberHigherOrLower(int guess, int correctNumber)
     * Gives a hint whether the correct number is higher or lower than the user's guess.
     * Reports nothing if the guess is the correct number.
     *
     * @param[in] guess - the user input guess
     * @param[in] correctNumber - the pseudorandom generated number the user attempts to guess
     */
    public static void isNumberHigherOrLower(int guess, int correctNumber) {
        if (guess != correctNumber) {
            if (correctNumber > guess) {
                System.out.println("It's higher.");
            } else {
                System.out.println("It's lower.");
            }
        }
    }

    /* @fn reportNumberOfGuesses(int guessCounter)
     * Reports how many guesses it took the user to guess the correct number.
     *
     * @param[in] guessCounter - the number of guesses the user made before guessing correctly.
     */
    public static void reportNumberOfGuesses(int guessCounter) {
        if (guessCounter == 1) {
            System.out.println("You got it right in 1 guess.");
        } else {
            System.out.println("You got it right in " + guessCounter + " guesses.");
        }
    }

    /* @fn playAgainChoice(Scanner console)
     * Returns true if the player wants to play another game (entered y) and false if not or invalid entry.
     *
     * @param[in/out] Scanner console - object to collect user input
     * @param choice - the first character of the user's input lowercase.
     */
    public static boolean playAgainChoice(Scanner console) {
        System.out.println("Do you want to play again?");
        char choice = console.next().toLowerCase().charAt(0);
        System.out.println();
        if (choice == 'y') {
            return true;
        } else if (choice == 'n') {
            return false;
        } else {
            System.out.println("Invalid selection.  Quitting game!");
            return false;
        }
    }

    /* @fn reportGameStats(int numberOfGames, int totalGuesses, int bestGame)
     * Prints stats to console when user finished playing and guesses / game rounded to 1 decimal place.
     *
     * @param[in] numberOfGames - total games played
     * @param[in] totalGuesses - total guesses made across all games
     * @param[in] bestGame - the game with the fewest number of guesses
     */
    public static void reportGameStats(int numberOfGames, int totalGuesses, int bestGame) {
        System.out.println("Overall results:");
        System.out.println("total games = " + numberOfGames);
        System.out.println("total guesses = " + totalGuesses);
        System.out.println("guesses/game = " + roundTo1Decimal((double) totalGuesses / numberOfGames));
        System.out.println("best game = " + bestGame);
    }

    /* @fn roundTo1Decimal(num)
     * Rounds real number to a single decimal place.
     *
     * @param num - any real number
     * @return rounded number
     */
    public static double roundTo1Decimal(double num) {
        return Math.round(num * 10.0) / 10.0;
    }
}
