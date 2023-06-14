package org.openjfx;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

public class TransformApp extends Application {

    private Parent createContent() {
        Rectangle box = new Rectangle(100, 50, Color.BLUE);
        Button button = new Button("Click me");

        UserEvent userEvent = new UserEvent(UserEvent.LOGIN_SUCCEEDED);

        box.addEventHandler(UserEvent.LOGIN_SUCCEEDED, event -> {
            System.out.println("hello world");
        });
//        transform(box);

        button.fireEvent(userEvent);
        button.fire();
        return new Pane(box, button);
    }

    private void transform(Rectangle box) {
        // we will apply transformations here
//        box.addEventHandler(UserEvent.LOGIN_SUCCEEDED, event -> {
//            EventType<? extends Event> eventType = event.getEventType();
//            String name = eventType.getName();
//            System.out.println(name);
//        });
//        UserEvent userEvent = new UserEvent(UserEvent.LOGIN_SUCCEEDED);
//        box.fireEvent(userEvent);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent(), 300, 300, Color.GRAY));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
