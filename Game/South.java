/**
 * The North subclass for the northern houses to extend
 * @author Anirudh Gubba
 * @version 1.0
 */
import java.awt.Rectangle;

public abstract class South extends House {
    /**
     * Declare a south object by calling the super constructor.
     * @param xPos   Position of x
     * @param yPos   Position of y
     * @param symbol Rectangle image
     */
    public South(int xPos, int yPos, Rectangle symbol) {
        super(xPos, yPos, symbol);
    }
    /**
     * Move object by a random amount over time. Also decrement health and
     * increase age each time move is called. Give a speed bonus for
     * roaming in the south
     */
    public void move() {
        health -= 2; //health decrement
        age++; //age increment
        if (yPos > 300) {
            speed += 3;
        }
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
            if (counterx == 0 && this.xPos - distancex > 0
                && countery == 0 && this.yPos - distancey > 0) {
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
}