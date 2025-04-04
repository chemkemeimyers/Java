import java.awt.TextField;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Hbox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.stage.Stage;
public class dollarsToPounds extends Application{
    final static double EXCHANGE_RATE = 0.81;
    public void Start(Stage stage)
    {
        Label valueLb1 = new Label("Input value: $");
        Label poundsLb1 = new Label();

        TextField dollarsTxt = new TextField();

        Button exchangeBtn = new Button();

        exchangeBtn.setText("Exchange");
    }

}