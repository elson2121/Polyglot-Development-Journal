package chapter3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import javafx.animation.FadeTransition;
import javafx.util.Duration;

// this is my weather widget for the eco company
public class WeatherWidget extends Application {

    @Override
    public void start(Stage myStage) {
        // main layout is borderpane
        BorderPane root = new BorderPane();
        root.getStyleClass().add("bg-green");

        // top part for name
        VBox top = new VBox(10);
        top.setAlignment(Pos.CENTER);
        top.setPadding(new Insets(15));
        
        Label cityName = new Label("Green City Center");
        cityName.getStyleClass().add("name-style");
        
        TextField input = new TextField();
        input.setPromptText("write city name...");
        input.setMaxWidth(200);
        
        top.getChildren().addAll(cityName, input);
        root.setTop(top);

        // middle part for icon and temp
        VBox mid = new VBox(10);
        mid.setAlignment(Pos.CENTER);
        
        // i make a leaf shape here
        SVGPath leafIcon = new SVGPath();
        leafIcon.setContent("M50,10 Q80,10 90,50 Q80,90 50,90 Q20,90 10,50 Q20,10 50,10");
        leafIcon.getStyleClass().add("leaf");
        
        Label temperature = new Label("22°C");
        temperature.getStyleClass().add("temp-big");
        
        Label text = new Label("Fresh Sky");
        
        Label gardenTip = new Label("Tip: Good for plants today");
        gardenTip.getStyleClass().add("tip-area");

        mid.getChildren().addAll(leafIcon, temperature, text, gardenTip);
        root.setCenter(mid);

        // bottom part for forecast
        VBox bottom = new VBox(15);
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(15));

        HBox daysBox = new HBox(20);
        daysBox.setAlignment(Pos.CENTER);
        daysBox.getStyleClass().add("days-border");
        
        // add 3 days
        daysBox.getChildren().add(makeDay("Mon", "20"));
        daysBox.getChildren().add(makeDay("Tue", "21"));
        daysBox.getChildren().add(makeDay("Wed", "19"));

        Button btn = new Button("Refresh");
        // button not work if no text
        btn.disableProperty().bind(input.textProperty().isEmpty());

        bottom.getChildren().addAll(daysBox, btn);
        root.setBottom(bottom);

        // leaf animation
        FadeTransition anim = new FadeTransition(Duration.seconds(2.5), leafIcon);
        anim.setFromValue(0.4);
        anim.setToValue(1.0);
        anim.setCycleCount(FadeTransition.INDEFINITE);
        anim.setAutoReverse(true);
        anim.play();

        Scene scene = new Scene(root, 380, 580);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        
        myStage.setTitle("Eco Weather");
        myStage.setScene(scene);
        myStage.show();
    }

    // help make day box
    private VBox makeDay(String name, String t) {
        VBox v = new VBox(5);
        v.setAlignment(Pos.CENTER);
        v.getChildren().addAll(new Label(name), new Label(t + "°"));
        return v;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
