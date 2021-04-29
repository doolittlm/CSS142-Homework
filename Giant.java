
import java.awt.*;

public class Giant extends Critter {
    private int count = 0;
    private int nameIndex = 0;
    //displayName is what Giant displays as for 6 steps before turning to the next
    private String[] displayName = {"fee", "fie", "foe", "fum"};

    /* @fn getMove
     * Increments step counter
     * Infects if non-Giant in front of it
     * Hops if nothing is in front of it
     * Else turns right
     */
    public Action getMove(CritterInfo info) {
        this.count = this.count + 1;
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }

    /* @fn getColor
     * @return Color.GRAY for display of Giant in drawingPanel
     */
    public Color getColor() {
        return Color.GRAY;
    }

    /* @fn toString
     * Increments nameIndex location every 6 steps, if nameIndex is greater than or equal to length reset to 0
     *
     * @return displayName[nameIndex] (fee, fie, foe, or fum)
     */
    public String toString() {
        if (this.count % 6 == 0 && this.count != 0) {
            this.nameIndex = this.nameIndex + 1;
        }
        if (this.nameIndex >= displayName.length - 1) {
            this.nameIndex = 0;
        }
        return this.displayName[this.nameIndex];
    }
}