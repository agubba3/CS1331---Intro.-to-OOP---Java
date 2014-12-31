import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.PathBuilder;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.ClosePath;

/**
 * This enum defines each planet
 * and allows the user to make
 * a new planet
 * the planets which can be used
 * @author Anirudh Gubba
 * @version 1.0
 */
public enum Planet {

    /**
     * Planet Earth, Mercury, Venus, Mars and
     * their multiples for each field
     */
    EARTH(Color.SPRINGGREEN, 1, 1, 1),
    MERCURY(Color.SILVER, 0.24, 0.1915, 0.387),
    VENUS(Color.GREEN, 0.62, 0.4745, 0.723),
    MARS(Color.RED, 1.88, 0.266, 1.52);

    private Color pColor;
    private final double pPeriod;
    private final double pRad;
    private final double pDist;
    private Circle cir;
    private Path path;

    /** DO NOT MODIFY IT'S FOR YOUR OWN GOOD**/
    private final int earthRadius = 35;
    private final int earthDistance = 265;
    private final int earthPeriod = 5;
    /** OK YOU'RE GOOD GO AHEAD AND DO WORK NOW **/

    /**
     * This is the constructor which creates a
     * new planet as an enum.
     * @param c The planet's color passed in
     * @param pp The planet's period passed in
     * @param pr The planet's radius passed in
     * @param pd The planet's distance from the sun
     */
    Planet(Color c, double pp, double pr, double pd) {
        pColor = c;
        pPeriod = pp * earthPeriod;
        pRad = pr * earthRadius;
        pDist = pd * earthDistance;
        cir = new Circle(400, 400 - pDist, pRad, pColor);
        path = generatePath(400 + pDist, 400, pDist);
    }

    /**
     * This generates a path pased on a planet's
     * center on the scene and its
     * radius.
     * @param centerX The planet's orbital's X coordinate
     * @param centerY The planet's orbital's X coordinate
     * @param r The radius of the orbital or the planet's
     * distance from the sun
     * @return Path the Path based on the orbital's parameters
     */
    private Path generatePath(double centerX, double centerY, double r) {
        ArcTo arcTo = new ArcTo();
        arcTo.setX(centerX - r + 1);
        arcTo.setY(centerY - r);
        arcTo.setSweepFlag(false);
        arcTo.setLargeArcFlag(true);
        arcTo.setRadiusX(r);
        arcTo.setRadiusY(r);
        Path pathC = PathBuilder.create()
            .elements(new MoveTo(centerX - r, centerY - r)
            , arcTo, new ClosePath()).build();
        pathC.setStroke(Color.WHITE);
        return pathC;
    }

    /**
     * This returns the color of the Planet
     * enum created.
     * @return Color the color of the planet made
     */
    public Color getColor() {
        return pColor;
    }

    /**
     * This returns the period of the Planet
     * enum created
     * @return double the period of the planet made
     */
    public double getPeriod() {
        return pPeriod;
    }

    /**
     * This returns the radius of the Planet
     * enum created
     * @return double the radius of the planet made
     */
    public double getRad() {
        return pRad;
    }

    /**
     * This returns the distance of the Planet
     * enum created
     * @return double the distance of the planet made
     */
    public double getDist() {
        return pDist;
    }

    /**
     * This returns the Circle of te Planet
     * enum created
     * @return Circle the Circle made based on
     * the planet's parameters
     */
    public Circle getCircle() {
        return cir;
    }

    /**
     * This returns the Path of te Planet
     * enum created
     * @return Path the Path made based on
     * the planet's parameters
     */
    public Path getPath() {
        return path;
    }

}

