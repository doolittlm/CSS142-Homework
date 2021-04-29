import java.awt.*;

public class Lion extends Critter {
    private int count = 0;
    private Color color;

    public Lion() {
    }

    /* @fn getMove(info)
     * Increments move counter.
     * Infects if there's a non-Lion in front of it
     * Turns left if it reaches a wall in front of it or to the right
     * Turns right if another Lion is in front of it.
     * Else hops forward.
     */
    public Action getMove(CritterInfo info) {
        this.count = this.count + 1;
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }

    /* @fn getColor
     * @return pseudorandomly blue, red, or green after this Lion moves 3 times
     */
    public Color getColor() {
        if (this.count % 3 == 0) {
            this.color = getRandomColor();
        }
        return this.color;
    }

    /* @fn toString
     * What lion appears as on drawingPanel
     *
     * @return "L"
     */
    public String toString() {
        return "L";
    }

    /* @fn getRandomColor
     * @return 33% pseudo random chance of returning Red, Blue, or Green
     */
    public Color getRandomColor() {
        double random = Math.random();
        if (random > 0.66) {
            return Color.RED;
        } else if (random > 0.33) {
            return Color.BLUE;
        } else {
            return Color.GREEN;
        }
    }
}