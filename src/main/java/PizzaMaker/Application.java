package PizzaMaker;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Runs the pizza maker.
 * @author Pridhau Manohar, Jay Shah
 */
public class Application extends javafx.application.Application {

    /**
     * Starts the pizza maker by creating a loader and setting the stage.
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 450);
        stage.setTitle("Pizza Maker");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Launches the pizza maker.
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}