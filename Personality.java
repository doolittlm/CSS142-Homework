package com.personality;

import java.io.*;
import java.util.*;

/* Stephanie Liu
 * CSS 142 Assignment 7
 * Take an input file from Keirsey Temperment Sorter and produce an output file.
 * Get input and output files from user.
 * Assignment assumptions:
 * 1) File exists
 * 2) File data has no errors
 * 3) File data will include upper and lowercase letters
 * 4) File data includes pairs of lines, and second line has 70 characters of As, Bs, and -s
 * 5) No one has 0 answers for a given dimension which would make determining percentage impossible
 *
 * Arrays!  1 dimensional only.  Arrays.toString method only.  Keirsey Temperament Sorter
 * Sort scores from 4 main personality traits
 * Extrovert versus Introvert (E vs I): what energizes you
 * Sensation versus iNtuition (S vs N): what you focus on
 * Thinking versus Feeling (T vs F): how you interpret what you focus on
 * Judging versus Perceiving (J vs P): how you approach life
 * 70 letters in a row for answering A or B or - to a series of questions.  - answers omitted from calculation.
 * Percentage of answers that are B is calculated (1 A and 9 B, 90% B, thus have second trait)
 * If equal, receive an X in that location (9 A, 9 B, 2 -, receive an X for the trait)
 *
 * Test has 10 groups of 7 questions with repeating patterns.
 * Extrovert / Introvert questions are 1, 8, 15, 22, n * 7 + 1
 * Sensing / iNtuition questions are 2, 3, 9, 10, 16, 17, n * 7 + 2, n * 7 + 3
 * Thinking / Feeling questions are 4, 5, 11, 12, n * 7 + 4, n * 7 + 5
 * Judging / Perceiving questions at 6, 7, 13, 14, n * 7 + 6, n * 7 + 7
 *
 * Percentages should be rounded to nearest integer (int percent = (int) Math.round(percentage);
 *
 * Start with string of 70 letters.
 * Convert to two sets of arrays (A answers array and B answers array for each trait)
 * Convert arrays into array of percentage of answer B
 * Convert into string representing personality type
 */

public class Personality {
    /* Constants:
     * int DIMENSIONS - Total number of personality dimensions in Keiser Temperment
     * char A and B - Used for finding answers of each type, A or B.  There are also - answers, but these are not used.
     * Stringp[] PERSONAOPTIONS - Array of personality trait identifying letters.
     * XPERSONASTR - When personality is neither of the options and receives to X
     */
    public final static int DIMENSIONS = 4;
    public final static char A = 'A';
    public final static char B = 'B';
    public static final String[] PERSONAOPTIONS = {"E", "I", "S", "N", "T", "F", "J", "P"};
    public static final String XPERSONASTR = "X";

    public static void main(String[] args) throws FileNotFoundException {
        introduction();
        System.out.println("Input file name?");
        Scanner console = new Scanner(System.in);
        Scanner personalityData = new Scanner(new File(console.next()));
        System.out.print("Output file name?");
        PrintStream processedData = new PrintStream(console.next());
        while (personalityData.hasNextLine()) {
            processedData.print(personalityData.nextLine() + ": ");
            String[] answersByTrait = getAnswersByTrait(personalityData.nextLine());
            int[] percentBTraits = getPercentBPerTrait(getCountsOfChar(answersByTrait, A), getCountsOfChar(answersByTrait, B));
            processedData.print(Arrays.toString(percentBTraits));
            processedData.print(" = ");
            processedData.print(getPersonalityType(percentBTraits));
            processedData.println();
        }
    }

    /* @fn introduction
     * Introduces program to user.
     */
    public static void introduction() {
        System.out.println("This program processes a file of answers to the");
        System.out.println("Keirsey Temperament Sorter. It converts the");
        System.out.println("various A and B answers for each person into");
        System.out.println("a sequence of B-percentages and then into a");
        System.out.println("four-letter personality type.");
    }

    /* @fn getAnswersByTrait
     * Sorts answers into one of the DIMENSIONS strings for each traits based on answer location in the array
     *
     * @param answersString contains all answers for a single person
     * @return String[DIMENSIONS] including a string for all the answers of the DIMENSIONS traits
     */
    public static String[] getAnswersByTrait(String answersString) {
        String[] answersByTrait = new String[DIMENSIONS];
        int arrayLoc = 0;
        for (int iter = 0; iter < answersString.length(); iter++) {
            if (arrayLoc > 6) {
                arrayLoc = 0;
            }
            //To index to 0, 1, 1, 2, 2, 3, 3 due to order of answers for traits
            int arrayIndex = Math.round((arrayLoc + 1) / 2);
            arrayLoc++;
            if (answersByTrait[arrayIndex] == null) {
                answersByTrait[arrayIndex] = "" + answersString.toUpperCase().charAt(iter);
            } else {
                answersByTrait[arrayIndex] = answersByTrait[arrayIndex] + answersString.toUpperCase().charAt(iter);
            }
        }
        return answersByTrait;
    }

    /* @fn getCountsOfChar
     * Calculates the numbers of answers for each array that match a specific char
     *
     * @param answersByTrait - array of DIMENSIONS strings that include answers for each dimension
     * @param answer character either A or B to search for in the array
     * @return the array of totals of each answer for each trait
     */
    public static int[] getCountsOfChar(String[] answersByTrait, char answer) {
        int[] countsOfChar = new int[DIMENSIONS];
        for (int iter = 0; iter < DIMENSIONS; iter++) {
            for (int charIter = 0; charIter < answersByTrait[iter].length(); charIter++) {
                if (answersByTrait[iter].charAt(charIter) == answer) {
                    countsOfChar[iter] = countsOfChar[iter] + 1;
                }
            }
        }
        return countsOfChar;
    }

    /* @fn getPercentageBPerTrait
     * Produces an array with whole number percentage of each trait answered B (ex. 90, 10)
     *
     * @param countsOfA - includes array of total number of questions answered A on assessment
     * @param countsOfB - includes array of total number of questions answered B on assessment
     * @return array with the percentage of the total questions answered B
     */
    public static int[] getPercentBPerTrait(int[] countsOfA, int[] countsOfB) {
        int[] percentBPerTrait = new int[DIMENSIONS];
        for (int iter = 0; iter < DIMENSIONS; iter++) {
            percentBPerTrait[iter] = (int) Math.round((double) countsOfB[iter] / (countsOfA[iter] + countsOfB[iter]) * 100);
        }
        return percentBPerTrait;
    }

    /* @fn getPersonalityType
     * @return a string with the letters associated with each trait for personality type
     *
     * @param percentageBPerTrait used to calculate whether the person is first trait or second or neither
     */
    public static String getPersonalityType(int[] percentageBPerTrait) {
        String personalityType = "";

        for (int iter = 0; iter < DIMENSIONS; iter++) {
            if (percentageBPerTrait[iter] > 50) {
                personalityType += PERSONAOPTIONS[iter * 2 + 1];
            } else if (percentageBPerTrait[iter] < 50) {
                personalityType += PERSONAOPTIONS[iter * 2];
            } else if (percentageBPerTrait[iter] == 50) {
                personalityType += XPERSONASTR;
            }
        }
        return personalityType;
    }
}
