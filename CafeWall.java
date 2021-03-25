import java.awt.*;

/* Draw a cafeWall.  Wall is a graphical object from java.awt.*.
 * wall panel is 650 x 400.
 * Set the background to GRAY.
 * Draws two rows of pairs of black then white squares.  Black squares have blue Xs.
 * upper left row starts at (0, 0), 4 pairs of squares, 20 size for each box.
 * mid left row starts at (50, 70), 5 pairs, 30 size for each box.
 * lower left grid starts at (10, 150), 4 pairs, 25 size, 0 row offset
 * lower middle grid starts at (250, 200), 3 pairs, 25 size, 10 row offset.
 * lower right grid starts at (425, 180), 5 pairs, 20 size, 10 row offset.
 * upper right grid starts at (400, 20), 2 pairs, 35 size, 35 row offset.
 * Draws 4 grids of these squares after the 2 rows.
 */
public class CafeWall
{
    //@param MORTAR - global value of pixel gap between rows.
    public static final int MORTAR = 2;

    public static void main(String[] args)
    {
        DrawingPanel panel = new DrawingPanel(650, 400);
        panel.setBackground(Color.GRAY);
        Graphics wall = panel.getGraphics();
        drawRowOfSquares(wall, 0, 0, 4, 20);
        drawRowOfSquares(wall, 50, 70, 5, 30 );
        drawGridOfSquares(wall, 10, 150, 4, 25, 0);
        drawGridOfSquares(wall, 250, 200, 3, 25, 10);
        drawGridOfSquares(wall, 425, 180, 5, 20, 10);
        drawGridOfSquares(wall, 400,20, 2, 35, 35);
    }
    /* @fn drawRowOfSquares(wall, x, y, numPairs, size)
     * @brief draws a row of pairs of squares with xs over the black squares.
     *
     * @param wall - passes the wall graphics
     * @param x - x coordinate of starting point for drawn square
     * @param y - y coordinate of starting point for drawn squares.
     * @param numPairs - number of black and white square pairs
     * @param size - how large will the squares be in pixels
     */
    public static void drawRowOfSquares(Graphics wall, int x, int y, int numPairs, int size)
    {
        for(int iter = 0; iter < numPairs; iter++)
        {
            wall.setColor(Color.BLACK);
            wall.fillRect(x, y, size, size);
            wall.setColor(Color.BLUE);
            wall.drawLine(x, y,x + size, y + size);
            wall.drawLine(x + size, y, x,y + size);
            wall.setColor(Color.WHITE);
            wall.fillRect(x + size, y, size, size);
            x = x + size * 2;
        }
    }
    /* @fn drawGridOfSquares(wall, x, y, numPairs, size, offset)
     * @brief calls fn drawPairOfSquares repeatedly while including the offset for each row.  numPairs * 2 long.
     *
     * @param wall - passes the wall graphics
     * @param x - x coordinate of starting point for drawn squares, start point of odd rows
     * @param y - y coordinate of starting point for drawn squares, increased by size and MORTAR for gray space
     * @param numPairs - number of black and white square pairs - * 2 is height of grid
     * @param size - how large will the squares be in pixels
     * @param offset - how offset every other row of the grid is
     */
    public static void drawGridOfSquares(Graphics wall, int x, int y, int numPairs, int size, int offset)
    {
        for (int iter = 0; iter < numPairs * 2; iter++)
        {
            drawRowOfSquares(wall, x + offset * (iter % 2), y, numPairs, size);
            y = y + size + MORTAR;
        }
    }
}
