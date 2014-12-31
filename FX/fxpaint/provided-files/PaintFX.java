import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;

/**
 * This class creates the canvas
 * on which everything is drawn
 * @author Anirudh Gubba
 * @version 1.0
 */

public class PaintFX extends Application {

    private Path path;
    private Group lineGroup;
    private Tool tool;

    /**
     * This is the main method which
     * launches the application
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    /**
     * This is the method which is executed at
     * the start of the application.
     *
     * @param primaryStage the stage which is
     * projected onto the canvas
     */
    @Override
    public void start(Stage primaryStage) {
        tool = new Pencil();
        primaryStage.setTitle("CS 1331");
        Group root = new Group();

        Canvas canvas = new Canvas(800, 800);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        root.getChildren().add(canvas);

        Label lab = new Label("Tools");

        Button btnClear = new Button();
        btnClear.setText("Clear");
        btnClear.setOnAction((ActionEvent event)
            -> gc.clearRect(0, 0, 800, 800));

        ColorPicker col = new ColorPicker();
        col.setOnAction((ActionEvent event) ->
            {
                gc.setFill(col.getValue());
                gc.setStroke(col.getValue());
            });

        Button btnPencil = new Button();
        btnPencil.setText("Pencil");
        btnPencil.setOnAction((ActionEvent event)
            -> tool = new Pencil());

        Button btnRect = new Button();
        btnRect.setText("Rectangle");
        btnRect.setOnAction((ActionEvent event)
            -> tool = new Rectangle());

        Button btnStr = new Button();
        btnStr.setText("Eraser");
        btnStr.setOnAction((ActionEvent event)
            -> tool = new Eraser());

        VBox utilBox = new VBox(10);
        utilBox.setAlignment(Pos.TOP_CENTER);
        utilBox.getChildren().addAll(lab, btnClear, btnPencil,
            btnRect, btnStr, col);
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
            (MouseEvent event) -> tool.onPress(event, gc));
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED,
            (MouseEvent event) -> tool.onRelease(event, gc));
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
            (MouseEvent event) -> tool.onDrag(event, gc));
        VBox vb = new VBox(10);
        vb.setPrefWidth(100);
        vb.setAlignment(Pos.TOP_LEFT);
        vb.getChildren().addAll(utilBox);
        vb.setStyle("-fx-background-color: #3399FF");
        BorderPane border = new BorderPane();
        border.setCenter(canvas);
        border.setLeft(vb);
        Scene scene = new Scene(border);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}