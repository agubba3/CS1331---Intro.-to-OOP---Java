import javafx.scene.input.MouseEvent;
import javafx.scene.canvas.GraphicsContext;

/**
 * This class allows the user to draw
 * in the canvas with a pencil.
 * @author Anirudh Gubba
 * @version 1.0
 */

public class Pencil implements Tool {

    private double xPos;
    private double yPos;

    /**
     * Tool method that is called when the mouse is pressed.
     * Usually involves beginning drawing something.
     *
     * @param e The mouseevent that fired this onPress.
     * @param g The current graphics context.
     */
    public void onPress(MouseEvent e, GraphicsContext g) {
        xPos = e.getX();
        yPos = e.getY();
        g.strokeLine(xPos, yPos, xPos, yPos);
    }

    /**
     * Tool method that is called when the mouse is dragged.
     * Usually involves updating the drawing location.
     *
     * @param e The mouseevent that fired this onDrag.
     * @param g The current graphics context.
     */
    public void onDrag(MouseEvent e, GraphicsContext g) {
        g.strokeLine(xPos, yPos, e.getX(), e.getY());
        xPos = e.getX();
        yPos = e.getY();
    }

    /**
     * Tool method that is called when the mouse is released.
     * Usually involves completing an individual stroke/shape.
     *
     * @param e The mouseevent that fired this onRelease.
     * @param g The current graphics context.
     */
    public void onRelease(MouseEvent e, GraphicsContext g) {
        xPos = 0;
        yPos = 0;
    }

    /**
     * The name of this tool.
     *
     * @return This tool's name.
     */
    public String getName() {
        return "Pencil";
    }
}