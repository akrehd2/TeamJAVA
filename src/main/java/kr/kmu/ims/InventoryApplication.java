package kr.kmu.ims;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import kr.kmu.ims.controllers.RootLayoutController;

import java.io.IOException;

public class InventoryApplication extends Application {
    private BorderPane rootLayout;
    public Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage=stage;

        initRootLayout();
    }


    //Initializes the root layout.
    public void initRootLayout() {
        try {
            //First, load root layout from layout.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(InventoryApplication.class.getResource("layout.fxml"));
            rootLayout = (BorderPane) loader.load();

            //Second, show the scene containing the root layout.
            Scene scene = new Scene(rootLayout); //We are sending rootLayout to the Scene.
            primaryStage.setScene(scene); //Set the scene in primary stage.

            //Give the controller access to the main.
            RootLayoutController controller = loader.getController();

            controller.setStage(primaryStage);

            //Third, show the primary stage
            primaryStage.show(); //Display the primary stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}