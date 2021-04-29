import java.awt.*;

public class Bear extends Critter {
    private int count;
    private boolean polar;

    public Bear(boolean polar) {
        this.count = 0;
        this.polar = polar;
    }

    /* @fn getMove
     * Increments move counter on move.
     * If non-Bear in front of it, infects.
     * If there's nothing in front of it, it hops forward.
     * Else turns left.
     */
    public Action getMove(CritterInfo info) {
        this.count = this.count + 1;
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }

    /* @fn getColor
     * @return white if polar bear or black if not a polar bear.
     */
    public Color getColor() {
        return (this.polar ? Color.WHITE : Color.BLACK);
    }

    /* @fn toString
     * What Bear appears as on DrawingPanel
     *
     * @return / or \ changing every other step.
     */
    public String toString() {
        if (count % 2 == 1) {
            return "/";
        } else {
            return "\\";
        }
    }
}