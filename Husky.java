import java.awt.*;

public class Husky extends Critter {
    /* @fn getMove
     * Infects if non-Husky in front of it
     * Turns right if there's a wall in front or a neighbor
     * Else hops
     */
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }

    /* @fn getColor
     * @return Color.YELLOW
     */
    public Color getColor() {
        return Color.YELLOW;
    }

    /* @fn toString
     * @return "BOW"
     */
    public String toString() {
        return "BOW";
    }
}