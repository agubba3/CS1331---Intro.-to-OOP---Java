/**
 * The North subclass for the northern houses to extend
 * @author Anirudh Gubba
 * @version 1.0
 */

import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class Gubstep extends South {

    private static int maximumAge = 50; //middle aged
    /**
     * Declare a Gubstep object with its own characteristics by assigning
     * its maximum age, file name, and its image file path.
     * @param xPos   Position of x
     * @param yPos   Position of y
     * @param symbol Rectangle image
     */
    public Gubstep(int xPos, int yPos, Rectangle symbol) {
        super(xPos, yPos, symbol);
        maxAge = maximumAge;
        imageFilename = "Gubstep";
        image = new ImageIcon("bear.png");
    }
    /**
     * check if two houses can reproduce. It will only
     * reproduce if the other house is a Tully.
     * Only perform reproduction on the 15th move and
     * after the age of 15
     * @param   otherHouse    house which is passed in
     * to detect if reproduction is possible
     * @return  boolean       true or false depending on
     * whether two houses can reproduce
     */
    public boolean canReproduceWithHouse(House otherHouse) {
        if (otherHouse.imageFilename.equals("Tully")
            && this.age > 15 && (this.age % 15) == 0) {
            return true;
        }
        return false;
    }
    /**
     * check if a house can harm the otherHouse. It will
     * only harm the other house if it is a Stark
     * @param   otherHouse    house which may be harmed by
     * the house object the method is being called by
     * @return  boolean       true or false depending on if
     * a house can harm the otherHouse or not
     */
    public boolean canHarmHouse(House otherHouse) {
        if (otherHouse.imageFilename.equals("Stark")) {
            double randomNum = Math.random() * 10;
            if (randomNum < 10.00) {
                return true;
            }
        }
        return false;
    }
}