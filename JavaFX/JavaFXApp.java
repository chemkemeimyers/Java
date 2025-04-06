import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXApp extends Application{
    public void start(Stage stage)
    {
        stage.setTitle("JavaFX app");
        Button button = new Button("Click Me");
       // button.setOnAction(new CustomEventHandler());

        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                System.out.println("Button Clicked");
            }
        };
        button.setOnAction(handler);

        StackPane root = new StackPane();
        root.getChildren().add(button);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}