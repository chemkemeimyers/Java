import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TemperatureControllerGUI extends Application{

    public void start(Stage stage){

        Button convertButton = new Button();
        convertButton.setText("Convert");

        ComboBox<String> pickScaleFrom = new ComboBox();
        ComboBox<String> pickScaleTo = new ComboBox();
        pickScaleFrom.getItems().add("Fahrenheit");
        pickScaleFrom.getItems().add("Celsius");

        pickScaleTo.getItems().addAll("Fahrenheit","Celsius");

        pickScaleFrom.getSelectionModel().selectFirst();
        pickScaleTo.getSelectionModel().selectLast();

        Label from = new Label("From:");
        Label to = new Label("To");


        TextField userInput = new TextField();
        Label inputValue = new Label("Input Value: ");
        Label result = new Label();

        convertButton.setOnAction(event -> {
            String temperatureString = userInput.getCharacters().toString();
            try{
                double temperature = Double.parseDouble(temperatureString);
                String scaleFrom = pickScaleFrom.getValue();
                String scaleTo = pickScaleTo.getValue();
                double conversionResult = convert(scaleFrom, scales, temperature);
                result.setText(String.format("%.2f", conversionResult));

            }catch(NumberFormatException e)
            {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("Invalid Temperature");
                a.setContentText("That is not a valid temperature");
                a.showAndWait();
            }
        };)
        
        HBox input = new HBox();
        input.setAlignment(Pos.CENTER);
        input.getChildren.addAll(inputValue, userInput);


        Hbox scales = new HBox();
        scales.setAlignment(Pos.CENTER);
        scales.setSpacing(10);
        scales.getChildren().add(from);
        scales.getChildren().add(pickScaleFrom)
        scales.getChildren().add(to);
        scales.getChildren().add(pickScaleTo);

        VBox root = new VBox();
        root.setAlignment(Pos.center);
        root.setSpacing(10);
        root.getChildren.addAll(inout, scales, convertButton, result);

        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Temperature COnverter");
        stage.setScene(scene);
        stage.show();

        private double convert(String from, String to, double value)
        {
            double converted = 0;
            if(from.equals(to))
            {
                converted = value;
            }
            else if(from.charAt(0) == 'F')
            {
                converted = (value - 32) * (5/9);
            }
            else{
                converted = value * (9/5) + 32;
            }
            return converted;
        }
    }
}