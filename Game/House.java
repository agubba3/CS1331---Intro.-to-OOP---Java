/**
 * The abstract House for the Game of Thrones Simulation
 * @author Anirudh Gubba
 * @version 1.0
 */
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public abstract class House {

    protected ImageIcon image;
    protected String imageFilename;
    protected int health;
    protected int speed;
    protected int age;
    protected int xPos;
    protected int yPos;
    protected Rectangle symbol;
    protected int maxAge;
    protected Random r;

    //Put constructors here!
    /**
     * Should initize a house object for subclasses to call
     * @param xPos   Position of x
     * @param yPos   Position of y
     * @param symbol Rectangle image
     */
    public House(int xPos, int yPos, Rectangle symbol) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.symbol = symbol;
        health = 100;
        speed = 50;
        age = 0;
        r = new Random();
    }
    /**
     * Should draw the House at its location.
     * @param g    Graphics object specificying what to draw
     */
    protected void draw(Graphics g) {
        image.paintIcon(null, g, this.xPos, this.yPos);
    }
    /**
     * Move object by a random amount over time.
     */
    protected abstract void move();
    /**
     * check if a collision between two houses has occured.
     * @param   otherHouse    house which is passed
     * in to detect if a collision has occured
     * @return  boolean       true or false depending on collision
     */
    public boolean collidesWithHouse(House otherHouse) {
        if (this.xPos - otherHouse.xPos <= 90) {
            return true;
        } else if (otherHouse.xPos - this.xPos <= 90) {
            return true;
        } else if (otherHouse.yPos - this.yPos <= 60) {
            return true;
        } else if (this.yPos - otherHouse.yPos <= 60) {
            return true;
        }
        return false;
    }
    /**
     * check if reproduction between two houses is possible.
     * @param   otherHouse    house which is passed in to detect if
     * reproduction is possible
     * @return  boolean       true or false depending
     * on whether two houses can reproduce
     */
    public abstract boolean canReproduceWithHouse(House otherHouse);
    /**
     * Output a new house after reproduction between two possible houses.
     * @param   otherHouse    house which is passed in toreproduce with
     * the house which is passed in
     * @return  House        return a new House in the place of the object
     * passed in the same location
     */
    public House reproduceWithHouse(House otherHouse) {
        if (this.canReproduceWithHouse(otherHouse)
            && this.collidesWithHouse(otherHouse)) {
            double randomNum = Math.random() * 10;
            if (randomNum < 3.00) { //30% chance of reproduction
                if (this.imageFilename.equals("Stark")) {
                    return new Stark(this.xPos, this.yPos,
                        new Rectangle(this.xPos, this.yPos, 600, 600));
                } else if (this.imageFilename.equals("Tully")) {
                    return new Tully(this.xPos, this.yPos,
                        new Rectangle(this.xPos, this.yPos, 600, 600));
                } else if (this.imageFilename.equals("Lannister")) {
                    return new Lannister(this.xPos, this.yPos,
                        new Rectangle(this.xPos, this.yPos, 600, 600));
                } else if (this.imageFilename.equals("Baratheon")) {
                    return new Baratheon(this.xPos, this.yPos,
                        new Rectangle(this.xPos, this.yPos, 600, 600));
                } else if (this.imageFilename.equals("Targaryan")) {
                    return new Targaryan(this.xPos, this.yPos,
                        new Rectangle(this.xPos, this.yPos, 600, 600));
                } else if (this.imageFilename.equals("Gubstep")) {
                    return new Gubstep(this.xPos, this.yPos,
                        new Rectangle(this.xPos, this.yPos, 600, 600));
                }
            }
        }
        return null;
    }
    /**
     * check if a house is too old based on moves.
     * @return  boolean    true or false depending on how
     * old the given object is
     */
    public boolean isOld() {
        if (this.age > this.maxAge) {
            return true;
        }
        return false;
    }
    /**
     * check if a house can harm the otherHouse.
     * The method will be implemented by each subclass of house
     * @param   otherHouse    house which may be harmed by the house
     * object the method is being called by
     * @return  boolean       true or false depending on if a
     * house can harm the otherHouse or not
     */
    public abstract boolean canHarmHouse(House otherHouse);
    /**
     * Harm the house and decrement the health of an otherHouse
     *. if it is possible as determiend by the canHarmHouse method
     * @param   otherHouse    house which is
     * @return  boolean       true or false depending
     * on if a house can harm the otherHouse or not
     */
    public void harmHouse(House otherHouse) {
        if (canHarmHouse(otherHouse)) {
            otherHouse.health -= 20;
        }
    }
    /**
     * Called if a house dies and the proper actions
     * are executed after death in this method
     */
    public void die() {
        health = 0; //just set health to 0
    }
    /**
     * Checks if the object passed to it is dead
     * @return  boolean    true or false depending
     * on the health of a house
     */
    public boolean isDead() {
        if (this.health == 0) {
            return true;
        }
        return false;
    }
}
