package org.openjfx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EventFiltersExample extends Application {
    private boolean isRunning = false;

    @Override
    public void start(Stage stage) {
        //Drawing a Circle
        Circle circle = new Circle();

        //Setting the position of the circle
        circle.setCenterX(300.0f);
        circle.setCenterY(135.0f);

        //Setting the radius of the circle
        circle.setRadius(25.0f);

        //Setting the color of the circle
        circle.setFill(Color.BROWN);

        //Setting the stroke width of the circle
        circle.setStrokeWidth(20);

        //Setting the text
        Text text = new Text("Click on the circle to change its color");

        //Setting the font of the text
        text.setFont(Font.font(null, FontWeight.BOLD, 15));

        //Setting the color of the text
        text.setFill(Color.CRIMSON);

        //setting the position of the text
        text.setX(150);
        text.setY(50);

        Timeline fiveSecondsWonder = new Timeline(
                new KeyFrame(
                        Duration.seconds(1),
                        event -> {
                            System.out.println("this is called every 1 seconds on UI thread");
                            circle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
                        }
                )
        );
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);

        //Creating the mouse event handler
        EventHandler<MouseEvent> eventHandler = e -> {
//            System.out.println("Hello World");
//            circle.setFill(Color.DARKSLATEBLUE);
            if (isRunning = !isRunning) {
                System.out.println("running");
                fiveSecondsWonder.play();
            } else {
                System.out.println("stopped!");
                fiveSecondsWonder.stop();
            }
        };
        //Registering the event filter
        circle.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

//        FillTransition ft = new FillTransition(Duration.millis(1000), circle, Color.RED, Color.BLUE);
//        ft.setCycleCount(500);
//        ft.setAutoReverse(true);
//        ft.play();

        //Creating a Group object
        Group root = new Group(circle, text);

        //Creating a scene object
        Scene scene = new Scene(root, 600, 300);

        //Setting the fill color to the scene
        scene.setFill(Color.LAVENDER);

        //Setting title to the Stage
        stage.setTitle("Event Filters Example");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }

//    @Override
//    public void start(Stage outStage) throws Exception {
//        Polygon traingle = new Polygon();
//        Double[] doubleValues=new Double[] { 60.0, 60.0, 200.0, 100.0, 100.0, 200.0 };
//        traingle.getPoints().addAll(doubleValues);
//        traingle.setFill(Color.LIGHTGREEN);
//        traingle.setStroke(Color.RED);
//        traingle.setStrokeWidth(5);
//        RotateTransition rotateTransition = new RotateTransition();
//        rotateTransition.setAxis(Rotate.Z_AXIS);
//        rotateTransition.setByAngle(360);
//        rotateTransition.setCycleCount(500);
//        rotateTransition.setDuration(Duration.millis(1000));
//        rotateTransition.setAutoReverse(true);
//        rotateTransition.setNode(traingle);
//        rotateTransition.play();
//        Group root = new Group();
//        root.getChildren().add(traingle);
//        Scene scene = new Scene(root, 400, 300, Color.WHEAT);
//        outStage.setScene(scene);
//        outStage.setTitle("Triangle Rotate Transition Example");
//        outStage.show();
//    }
    public static void main(String args[]){
        launch(args);
    }

}
