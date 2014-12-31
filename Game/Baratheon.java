/**
 * The North subclass for the northern houses to extend
 * @author Anirudh Gubba
 * @version 1.0
 */

import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class Baratheon extends South {

    private static int maximumAge = 40; //older than lannister
    /**
     * Declare a Naratheon object with its own
     * characteristics by assigning its
     * maximum age, file name, and its image file path.
     * @param   xPos    Position of x
     * @param   yPos    Position of y
     * @param   symbol  Rectangle image
     */
    public Baratheon(int xPos, int yPos, Rectangle symbol) {
        super(xPos, yPos, symbol);
        maxAge = maximumAge;
        imageFilename = "Baratheon";
        image = new ImageIcon("stag.png");
    }
    /**
     * check if two houses can reproduce. It will only reproduce
     * if the other house is a Lannister.
     * Only perform reproduction on the 20th move and after the age of 0
     * @param   otherHouse    house which is passed in to detect
     * if reproduction is possible
     * @return  boolean       true or false depending on whether
     * two houses can reproduce
     */
    public boolean canReproduceWithHouse(House otherHouse) {
        if (otherHouse.imageFilename.equals("Lannister")
            && this.age > 15 && (this.age % 10) == 0) {
            return true;
        }
        return false;
    }
    /**
     * check if a house can harm the otherHouse. It will only harm
     * the other house if it is a Targaryan
     * @param   otherHouse    house which may be harmed by the house
     * object the method is being called by
     * @return  boolean       true or false depending on if a house
     * can harm the otherHouse or not
     */
    public boolean canHarmHouse(House otherHouse) {
        if (otherHouse.imageFilename.equals("Targaryan")) {
            double randomNum = Math.random() * 10;
            if (randomNum < 10.00) {
                return true;
            }
        }
        return false;
    }
}