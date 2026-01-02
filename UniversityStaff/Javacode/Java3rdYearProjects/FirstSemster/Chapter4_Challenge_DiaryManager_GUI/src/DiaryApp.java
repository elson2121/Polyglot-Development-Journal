import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.*;
import java.nio.file.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DiaryApp extends Application {
    
    // executor for background saving so app dont lag
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    
    TextArea editor = new TextArea();
    ListView<String> entryList = new ListView<>();
    
    @Override
    public void start(Stage stage) {
        // sidebar part
        VBox sidebar = new VBox(25);
        sidebar.setPadding(new Insets(20));
        sidebar.setPrefWidth(120);
        sidebar.getStyleClass().add("sidebar");
        
        Label navToday = new Label("Today");
        Label navCal = new Label("Calendar");
        Label navSet = new Label("Settings");
        
        VBox profileBox = new VBox(5);
        Label name = new Label("Jane Doe");
        Label edit = new Label("Edit Profile");
        edit.setStyle("-fx-font-size: 9px;");
        profileBox.getChildren().addAll(name, edit);
        profileBox.setPadding(new Insets(100, 0, 0, 0));
        
        sidebar.getChildren().addAll(navToday, navCal, navSet, profileBox);

        // list of entries in middle
        VBox centerList = new VBox(15);
        centerList.setPadding(new Insets(20));
        Label title = new Label("Entries");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        
        entryList.getItems().addAll("October 26, 2023", "Morning Reflections", "Project Update");
        centerList.getChildren().addAll(title, entryList);

        // right side editor
        VBox rightEditor = new VBox(15);
        rightEditor.setPadding(new Insets(20));
        Label dateHeader = new Label("October 25, 2023");
        dateHeader.setStyle("-fx-font-size: 16px;");
        
        editor.setPromptText("write something here...");
        editor.setWrapText(true);
        
        Button saveBtn = new Button("Save Entry");
        saveBtn.getStyleClass().add("save-button");
        saveBtn.setOnAction(e -> handleSave());

        rightEditor.getChildren().addAll(dateHeader, editor, saveBtn);

        // layout setup
        HBox mainContainer = new HBox(0);
        mainContainer.getChildren().addAll(sidebar, centerList, rightEditor);
        HBox.setHgrow(rightEditor, Priority.ALWAYS);

        Scene scene = new Scene(mainContainer, 950, 600);
        // apply the css file
        scene.getStylesheets().add("file:src/style.css");
        
        stage.setScene(scene);
        stage.setTitle("Personal Diary - Chapter 4 Challenge");
        stage.show();
    }

    private void handleSave() {
        String text = editor.getText();
        String filename = "entry_" + System.currentTimeMillis() + ".txt";
        
        // i use background thread here so UI is smooth
        executor.submit(() -> {
            try {
                // nio files write like teacher wanted
                Files.write(Paths.get(filename), text.getBytes());
                System.out.println("file saved as " + filename);
            } catch (IOException ex) {
                // i show error if it break
                System.out.println("error saving file!");
            }
        });
    }

    @Override
    public void stop() {
        executor.shutdown(); // kill thread when close
    }

    public static void main(String[] args) {
        launch(args);
    }
}
