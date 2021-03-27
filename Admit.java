package com.admit;

import java.util.*;

/*
 * Prompt for exam scores, either SAT or ACT, and overall GPA.
 * Convert exam and GPA scores to a value from 0-100, and an overall score from 0-200.
 * After getting scores for both applicants, reports their overall scores and how they compare.
 * Report the scores rounded to 1 decimal place.
 *
 * For SAT Scores (200-800): (2⋅𝑚𝑎𝑡ℎ+𝑟𝑒𝑎𝑑𝑖𝑛𝑔+𝑤𝑟𝑖𝑡𝑖𝑛𝑔) / 32
 * For ACT Scores (1-36): (𝐸𝑛𝑔𝑙𝑖𝑠ℎ+2⋅𝑚𝑎𝑡ℎ+𝑟𝑒𝑎𝑑𝑖𝑛𝑔+𝑠𝑐𝑖𝑒𝑛𝑐𝑒) / 1.8
 * For GPA: (𝑎𝑐𝑡𝑢𝑎𝑙 𝑔𝑝𝑎 / 𝑚𝑎𝑥 𝑔𝑝𝑎) ⋅ 100 ⋅ 𝑡𝑟𝑎𝑛𝑠𝑐𝑟𝑖𝑝𝑡 𝑚𝑢𝑙𝑡𝑖𝑝𝑙𝑖𝑒𝑟
 * Round values to 1 decimal place when displayed.
 *
 * No methods should have more than 15 lines of code minus curly braces or blank lines.
 * One Scanner object.
 * No for loops.  If else if okay.
 */
public class Admit {
    public static void main(String[] args) {
        introduction();
        Scanner console = new Scanner(System.in);
        applicantComparison(console);
    }

    /* @fn introduction()
     * Prints the introduction message with directions in the console.
     */
    public static void introduction() {
        System.out.println("This program compares two applicants to");
        System.out.println("determine which one seems like the stronger");
        System.out.println("applicant. For each candidate I will need");
        System.out.println("either SAT or ACT scores plus a weighted GPA.");
        System.out.println();
    }

    /* @fn applicantComparison(console)
     * Solicits input for two applicants, prints their scores, then prints who is better candidate.
     *
     * @param console - allows collection of input from user
     */
    public static void applicantComparison(Scanner console) {
        System.out.println("Information for applicant #1:");
        double applicant1 = applicantDataRequest(console);
        System.out.println("Information for applicant #2:");
        double applicant2 = applicantDataRequest(console);
        System.out.println("First applicant overall score = " + roundTo1Decimal(applicant1));
        System.out.println("Second applicant overall score = " + roundTo1Decimal(applicant2));
        if (applicant1 > applicant2) {
            System.out.println("The first applicant seems to be better");
        } else if (applicant1 < applicant2) {
            System.out.println("The second applicant seems to be better.");
        } else System.out.println("The two applicants seem to be equal.");
    }

    /* @fn applicantDataRequest(console)
     * Collects input for one applicant and returns their overall score.
     *
     * @param console - allows collection of input from user
     * @return value of their overall comparative score by adding examScore and gpaScore.
     */
    public static double applicantDataRequest(Scanner console) {
        System.out.println("Do you have 1) SAT scores or 2) ACT scores?");
        int examType = console.nextInt();
        double examScore;
        if (examType == 1) {
            examScore = satScoreCalc(console);
        } else examScore = actScoreCalc(console);
        System.out.println("Exam score = " + roundTo1Decimal(examScore));
        double gpaScore = gpaScoreCalc(console);
        System.out.println("GPA Score = " + roundTo1Decimal(gpaScore));
        System.out.println();
        return examScore + gpaScore;
    }

    /* @fn satScoreCalc(console)
     * Collects input for one applicant and calculates SAT exam score value.
     *
     * @param console - allows collection of input from user
     * @return exam value for SAT.
     */
    public static double satScoreCalc(Scanner console) {
        System.out.println("SAT math?");
        int satMath = console.nextInt();
        System.out.println("SAT critical reading?");
        int satReading = console.nextInt();
        System.out.println("SAT writing?");
        int satWriting = console.nextInt();
        return (double) (2 * satMath + satReading + satWriting) / 32;
    }

    /* @fn actScoreCalc(console)
     * Collects input for one applicant and calculates ACT exam score value.
     *
     * @param console - allows collection of input from user
     * @return exam value for ACT.
     */
    public static double actScoreCalc(Scanner console) {
        System.out.println("ACT English?");
        int actEnglish = console.nextInt();
        System.out.println("ACT math?");
        int actMath = console.nextInt();
        System.out.println("ACT reading?");
        int actReading = console.nextInt();
        System.out.println("ACT Science?");
        int actScience = console.nextInt();
        return (2 * actMath + actEnglish + actReading + actScience) / 1.8;
    }

    /* @fn gpaScoreCalc(console)
     * Collects input for one applicant and calculates GPA score value.
     *
     * @param console - allows collection of input from user
     * @return gpa score
     */
    public static double gpaScoreCalc(Scanner console) {
        System.out.println("Overall GPA?");
        double overallGPA = console.nextDouble();
        System.out.println("Max GPA?");
        double maxGPA = console.nextDouble();
        System.out.println("Transcript Multiplier?");
        double transcriptMultiplier = console.nextDouble();
        return (overallGPA / maxGPA) * 100 * transcriptMultiplier;
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
