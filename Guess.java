package com.guess;

import java.util.*;

/* Stephanie Liu
 * Homework 5
 * Number guessing game that gives hints of higher or lower and reports stats at the end.
 * The correct number can be [1, MAX_NUMBER]
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
        int guesses;
        int totalGuesses = 0;
        int bestGame = MAX_NUMBER;
        boolean playAgain;
        do {
            guesses = playOneGame(console);
            totalGuesses += guesses;
            if (bestGame > guesses) {
                bestGame = guesses;
            }
            numberOfGames++;
            playAgain = playAgainChoice(console);
        } while (playAgain);
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
     * @param - object Scanner console allows user input
     */
    public static int playOneGame(Scanner console) {
        System.out.println("I'm thinking of a number between 1 and " + MAX_NUMBER + "...");
        Random randomObject = new Random();
        //correctNumber - A pseudorandom number between 1 and MAX_NUMBER, sent to IsNumberHigherOrLower to give a hint.
        int correctNumber = randomObject.nextInt(MAX_NUMBER) + 1;
        // guess - Users guess - sent to isNumberHigherOrLower to give guess hint.
        int guess = 0;
        // guessCounter - increases for each guess entered, returned to calculate stats at end
        int guessCounter = 0;
        while (guess != correctNumber) {
            System.out.println("Your guess?");
            guess = console.nextInt();
            console.nextLine();
            guessCounter++;
            isNumberHigherOrLowerOrCorrect(guess, correctNumber, guessCounter);
        }
        return guessCounter;
    }

    /* @fn isNumberHigherOrLower(int guess, int correctNumber)
     * Gives a hint whether the correct number is higher or lower than the user's guess.
     * Reports nothing if the guess is the correct number.
     *
     * @param[in] guess - the user input guess
     * @param[in] correctNumber - the pseudorandom generated number the user attempts to guess
     * @param[in] guessCounter - if numbers are equal, then reports total guesses to get it correct.
     */
    public static void isNumberHigherOrLowerOrCorrect(int guess, int correctNumber, int guessCounter) {
        if (correctNumber > guess) {
            System.out.println("It's higher.");
        } else if (correctNumber < guess) {
            System.out.println("It's lower.");
        } else {
            System.out.println("You got it right in " + guessCounter + " guess" + (guessCounter == 1 ? "" : "es") + ".");
        }
    }

    /* @fn playAgainChoice(Scanner console)
     * Returns true if the player wants to play another game (entered y) and false if not to end game.
     *
     * @param[in/out] Scanner console - object to collect user input
     */
    public static boolean playAgainChoice(Scanner console) {
        System.out.println("Do you want to play again?");
        //choice - the first character of the user's input lowercase.
        char choice = console.next().toLowerCase().charAt(0);
        console.nextLine();
        System.out.println();
        return (choice == 'y');
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
        System.out.printf("guesses/game = %.1f%n", ((double) totalGuesses / numberOfGames));
        System.out.println("best game = " + bestGame);
    }
}
