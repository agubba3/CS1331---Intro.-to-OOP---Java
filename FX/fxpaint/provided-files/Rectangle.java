import javafx.scene.input.MouseEvent;
import javafx.scene.canvas.GraphicsContext;

/**
 * This class allows the user to create a rectangle
 * by dragging the cursor to a given location
 * @author Anirudh Gubba
 * @version 1.0
 */

public class Rectangle implements Tool {

    private double xPosP;
    private double yPosP;
    private double xPosR;
    private double yPosR;
    private double xPosD;
    private double yPosD;

    /**
     * Tool method that is called when the mouse is pressed.
     * Usually involves beginning drawing something.
     *
     * @param e The mouseevent that fired this onPress.
     * @param g The current graphics context.
     */
    public void onPress(MouseEvent e, GraphicsContext g) {
        xPosP = e.getX();
        yPosP = e.getY();
        xPosD = xPosP;
        yPosD = yPosP;
    }
    /**
     * Tool method that is called when the mouse is dragged.
     * Usually involves updating the drawing location.
     *
     * @param e The mouseevent that fired this onDrag.
     * @param g The current graphics context.
     */
    public void onDrag(MouseEvent e, GraphicsContext g) {
        if (xPosD - xPosP >= 0 && yPosD - yPosP >= 0) {
            g.fillRect(xPosP, yPosP, xPosD - xPosP, yPosD - yPosP);
        } else if (xPosD - xPosP >= 0 && yPosD - yPosP < 0) {
            g.fillRect(xPosP, yPosD, Math.abs(xPosD - xPosP)
                , Math.abs(yPosD - yPosP));
        } else if (xPosD - xPosP < 0 && yPosD - yPosP >= 0) {
            g.fillRect(xPosD, yPosP, Math.abs(xPosD - xPosP)
                , Math.abs(yPosD - yPosP));
        } else if (xPosD - xPosP < 0 && yPosD - yPosP < 0) {
            g.fillRect(xPosD, yPosD, Math.abs(xPosD - xPosP)
                , Math.abs(yPosD - yPosP));
        }
        xPosD = e.getX();
        yPosD = e.getY();
    }
    /**
     * Tool method that is called when the mouse is released.
     * Usually involves completing an individual stroke/shape.
     *
     * @param e The mouseevent that fired this onRelease.
     * @param g The current graphics context.
     */
    public void onRelease(MouseEvent e, GraphicsContext g) {
        xPosD = e.getX();
        yPosD = e.getY();
    }
    /**
     * The name of this tool.
     *
     * @return This tool's name.
     */
    public String getName() {
        return "Rectangle";
    }
}