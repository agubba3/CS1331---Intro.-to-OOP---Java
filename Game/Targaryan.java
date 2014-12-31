/**
 * The North subclass for the northern houses to extend
 * @author Anirudh Gubba
 * @version 1.0
 */

import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class Targaryan extends House {

    private static int maximumAge = 0; //default
    private static int counterMove = 1;
    private static int loopcount = 0;
    /**
     * Declare a Targaryan object with its own characteristics by assigning
     * its maximum age, file name, and its image file path.
     * @param xPos   Position of x
     * @param yPos   Position of y
     * @param symbol Rectangle image
     */
    public Targaryan(int xPos, int yPos, Rectangle symbol) {
        super(xPos, yPos, symbol);
        maxAge = maximumAge;
        imageFilename = "Targaryan";
        image = new ImageIcon("dragon.png");
    }
    /**
     * Move object by a random amount over time.
     * Also decrement health and increase
     * age each time move is called. Give a health
     * bonus because of norhern roaming
     * The counter is there in place of age to
     * curb infinite reproduction
     * The while loop ensures that the objects
     * stay in bouds
     */
    public void move() {
        counterMove++;
        boolean canMove = false;
        int distancex = (int) (Math.random() * speed);
        int distancey = (int) (Math.random() * speed);
        int counterx = r.nextInt(2);
        int countery = r.nextInt(2);
        while (!canMove) {
            distancex = (int) (Math.random() * speed);
            distancey = (int) (Math.random() * speed);
            counterx = r.nextInt(2);
            countery = r.nextInt(2);
            if (counterx == 0 && this.xPos - distancex > 0 && countery == 0
                && this.yPos - distancey > 0) {
                canMove = true;
            } else if (counterx == 1 && this.xPos + distancex < 510
                && countery == 1 && this.yPos + distancey < 530) {
                canMove = true;
            }
        }
        if (counterx == 0 && countery == 0) {
            xPos -= distancex;
            yPos -= distancey;
        } else if (counterx == 0 && countery == 1) {
            xPos -= distancex;
            yPos += distancey;
        } else if (counterx == 1 && countery == 0) {
            xPos += distancex;
            yPos -= distancey;
        } else if (counterx == 1 && countery == 1) {
            xPos += distancex;
            yPos += distancey;
        }
    }
    /**
     * check if two houses can reproduce. It will only
     * reproduce if the other house is a Targaryan.
     * Only perform reproduction on the 20th move and only
     * 20% chance of it reproducing with itself
     * @param   otherHouse    house which is passed in to
     * detect if reproduction is possible
     * @return  boolean       true or false depending on
     * whether two houses can reproduce
     */
    public boolean canReproduceWithHouse(House otherHouse) {
        double randomNum = Math.random() * 10;
        if (randomNum < 3.00) {
            if (otherHouse.imageFilename.equals("Targaryan")
                && (counterMove % 10) == 0) {
                return true;
            }
            return false;
        }
        return false;
    }
    /**
     * check if a house can harm the otherHouse. It will only not harm the
     * other house as long as it is not a Targaryan or Baratheon
     * @param   otherHouse    house which may be harmed
     * by the house object the method is being called by
     * @return  boolean       true or false depending on
     * if a house can harm the otherHouse or not
     */
    public boolean canHarmHouse(House otherHouse) {
        if (otherHouse.imageFilename.equals("Baratheon")
            || otherHouse.imageFilename.equals("Targaryan")) {
            return false;
        }
        return true;
    }
    /**
     * Overriding the isOld method to make
     * Targaryans live forever
     * @return  boolean       true or false
     * depending on if a a house is old or not
     */
    @Override
    public boolean isOld() {
        return false;
    }
}