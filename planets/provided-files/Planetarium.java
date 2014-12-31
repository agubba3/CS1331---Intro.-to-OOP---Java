import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.animation.PathTransition;
import javafx.util.Duration;
import javafx.animation.PathTransitionBuilder;
import javafx.animation.Timeline;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Interpolator;

/**
 * This class creates a scene
 * on which the planets move
 * according to their path,
 * speed, etc.
 * @author Anirudh Gubba
 * @version 1.0
 */
public class Planetarium extends Application {

    private PathTransition pathTransitionCircleMe;
    private PathTransition pathTransitionCircleMa;
    private PathTransition pathTransitionCircleE;
    private PathTransition pathTransitionCircleV;
    private final int sceneX = 800;
    private final int sceneY = 800;

    /**
     * This is the method which is executed at
     * the start of the application.
     * The method also creates the scene
     * and makes all the circles
     * using the Planet enum.
     * @param primaryStage the stage which is
     * projected onto the canvas
     */
    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, sceneX, sceneY);
        scene.setFill(Color.BLACK);

        Circle circle = new Circle(400, 400, 65, Color.YELLOW);
        Circle mercury = Planet.MERCURY.getCircle();
        Circle venus = Planet.VENUS.getCircle();
        Circle mars = Planet.MARS.getCircle();
        Circle earth = Planet.EARTH.getCircle();
        Circle[] circles = {mercury, venus, mars, earth};

        Path pathMe = Planet.MERCURY.getPath();
        Path pathV = Planet.VENUS.getPath();
        Path pathMa = Planet.MARS.getPath();
        Path pathE = Planet.EARTH.getPath();
        Path[] paths = {pathMe, pathV, pathMa, pathE};

        Planet[] planets = {Planet.MERCURY, Planet.VENUS
            , Planet.MARS, Planet.EARTH};

        for (int i = 0; i < circles.length; i++) {
            pathTransitionCircleMe = PathTransitionBuilder.create()
                .duration(Duration.seconds(planets[i].getPeriod()))
                .path(paths[i])
                .interpolator(Interpolator.LINEAR)
                .node(circles[i])
                .orientation(OrientationType.ORTHOGONAL_TO_TANGENT)
                .cycleCount(Timeline.INDEFINITE)
                .autoReverse(false)
                .build();
            pathTransitionCircleMe.play();
        }

        root.getChildren().addAll(circle, mercury, venus
            , mars, earth, pathMe, pathV, pathMa, pathE);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This is the main method which
     * launches the application.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
