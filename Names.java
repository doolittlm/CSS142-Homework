package com.names;

import java.util.*;
import java.io.*;
import java.awt.*;
/* Stephanie Liu
 *
 * Your program is to give an introduction and then prompt the user for a name and sex combination to display.
 * Then it will read through the data file searching for that combination.
 * If it finds it, it should graph the data for that combination.
 * If not, it should generate a short message indicating that the combination is not found.
 *
 * If the combination is found, you are to construct a DrawingPanel to graph the data.
 * For the cases when the combination is found:
 * you should construct the panel and then give a series of drawing commands that produce output like the following.
 *
 * The background color is the standard white.
 * There are a series of horizontal and vertical lines drawn in black.
 * The overall height of the panel should always be 550 pixels.
 * The horizontal line at the top should be 25 pixels below the top
 * the horizontal line at the bottom should be 25 pixels above the bottom.
 * The panel is divided into 14 sections of equal width to represent the 14 different decades for which we have data
 *      (starting with 1880 through 2010).
 * These particular sections have a horizontal width of 70 pixels each.
 * You should introduce class constants for the number of decades (14),
 * the starting year (1880) and the horizontal width per decade (70).
 * It should be possible to change these values and have your program adapt appropriately (more on this later).
 * You are to draw a vertical line to the left of each of the 14 sections, including at the x coordinate of 0
 * (you do not need a vertical line on the far right).
 */

public class Names {
    public static final String filePathway = "src/com/names/data/names.txt";
    public static final int totalDecades = 14;
    public static final int startingDecade = 1880;
    public static final int decadeWidth = 70;
    public static final int yCoorStart = 25;
    public static final int graphHeight = 550;
    public static final int coorStart = 0;

    public static void main(String[] args) throws FileNotFoundException {
        introduction();
        Scanner namesFile = new Scanner(new File(filePathway));
        String nameData = findNameDataInFile(namesFile);
        if (nameData.equals("")) {
            System.out.println("Name / sex combination not found");
        } else {
            DrawingPanel panel = new DrawingPanel(totalDecades * decadeWidth, graphHeight);
            Graphics chart = panel.getGraphics();
            drawGrid(chart);
            drawCoordinates(nameData, chart);

        }
    }

    /* @fn introduction
     * Provides description of program.
     */
    public static void introduction() {
        System.out.println("This program allows you to search through the");
        System.out.println("data from the Social Security Administration");
        System.out.println("to see how popular a particular name has been");
        System.out.println("since " + startingDecade + ".");
    }

    /* @fn findNamesDataInFile
     * Asks user input for name and sex, finds it in file, then prints it
     *
     * @param namesFile includes entire file
     * @return Line of file the name and sex was found in or can't be found
     */
    public static String findNameDataInFile(Scanner namesFile) {
        Scanner console = new Scanner(System.in);
        System.out.println("Name?");
        String searchForNameAndSex = console.next().toLowerCase();
        System.out.println("Sex (M or F)?");
        searchForNameAndSex += " " + console.next().toLowerCase();

        while (namesFile.hasNextLine()) {
            String nameSex = namesFile.next() + " " + namesFile.next();
            String line = namesFile.nextLine();
            if ((nameSex.toLowerCase().equals(searchForNameAndSex))) {
                return (nameSex + " " + line);
            }
        }
        return ("");
    }

    /* @fn drawGrid
     * Draws the static grid with totalDecades lines and labels decades at the bottom
     * @param chart is Graphics from DrawingPanel to allow drawing on panel.
     */
    public static void drawGrid(Graphics chart) {
        chart.drawLine(coorStart, yCoorStart, decadeWidth * totalDecades, yCoorStart);
        chart.drawLine(coorStart, graphHeight - yCoorStart, decadeWidth * totalDecades, graphHeight - yCoorStart);
        for (int iter = 0; iter < totalDecades; iter++) {
            chart.drawLine(decadeWidth * iter, coorStart, decadeWidth * iter, graphHeight);
            chart.drawString(String.valueOf(startingDecade + iter * 10), iter * decadeWidth, graphHeight);
        }
    }

    /* @fn drawCoordinates
     * Draws the red plot line with label
     * @param nameData includes the line from the file from findNameDataInFile function
     */
    public static void drawCoordinates(String nameData, Graphics chart) {
        Scanner nameDataSearch = new Scanner(nameData);
        chart.setColor(Color.red);
        String nameLabel = nameDataSearch.next() + " " + nameDataSearch.next();
        int rank = nameDataSearch.nextInt();
        int xCoordinate = coorStart;
        int yCoordinate;
        int prevYCoordinate = rankToCoordinate(rank);
        chart.drawString(nameLabel + " " + rank, xCoordinate, prevYCoordinate);
        while (nameDataSearch.hasNextInt()) {
            rank = nameDataSearch.nextInt();
            yCoordinate = rankToCoordinate(rank);
            chart.drawLine(xCoordinate, prevYCoordinate, xCoordinate + decadeWidth, yCoordinate);
            prevYCoordinate = yCoordinate;
            xCoordinate += decadeWidth;
            chart.drawString(nameLabel + " " + rank, xCoordinate, prevYCoordinate);
        }
    }

    /* @fn rankToCoordinate
     * Calculates the y coordinate based on the rank
     * If rank is > 0 and even, subtracts one due to rounding int division.
     *
     * @param rank is integer representing the name's popularity.
     * @returns 525 if the name is unranked or which pixel y coordinate to end at.  0 if data in file invalid.
     */
    public static int rankToCoordinate(int rank) {
        if (rank > 0) {
            return (yCoorStart + (rank / 2) - 1 * ((1 + rank) % 2));
        } else if (rank == 0) {
            return (525);
        } else {
            System.out.println("The ranking listed in the file is invalid.");
            return (0);
        }
    }
}
