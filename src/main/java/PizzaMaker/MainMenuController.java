package PizzaMaker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Controller class for main menu.
 * Includes the options of ordering different flavors of pizzas, checking the current order,
 * and managing the store orders placed by the user
 * @author Pridhau Manohar, Jay Shah
 */
public class MainMenuController {
    final static String DELUXE_IMG = "./src/main/java/PizzaMaker/deluxe.jpg";
    final static String PEPPERONI_IMG = "./src/main/java/PizzaMaker/pepperoni.jpg";
    final static String HAWAIIAN_IMG = "./src/main/java/PizzaMaker/hawaiian.jpg";
    private Order current_order = new Order();
    private StoreOrders sorders = new StoreOrders();

    @FXML
    private ImageView deluxeview;

    @FXML
    private ImageView hawaiianview;

    @FXML
    private ImageView pepperoniview;

    /**
     * Sets the buttons to have the pictures of each flavor of pizza.
     */
    @FXML
    void initialize(){
        try{
            InputStream stream = new FileInputStream(DELUXE_IMG);
            Image image = new Image(stream);
            deluxeview.setImage(image);

            stream = new FileInputStream(PEPPERONI_IMG);
            image = new Image(stream);
            pepperoniview.setImage(image);

            stream = new FileInputStream(HAWAIIAN_IMG);
            image = new Image(stream);
            hawaiianview.setImage(image);
        }
        catch(IOException i){}

    }

    /**
     * Opens the pizza customization window for a deluxe pizza.
     * @param event
     */
    @FXML
    void orderDeluxe(ActionEvent event) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pizza-custom.fxml"));
            Scene scene = new Scene(loader.load(), 600, 400);
            stage.setTitle("Deluxe");
            stage.setScene(scene);
            stage.show();
            ((PizzaCustomController)(loader.getController())).setDeluxe();
            ((PizzaCustomController)(loader.getController())).setCurrent_order(current_order);
        }
        catch(java.io.IOException i){
        }

    }

    /**
     * Opens the pizza customization window for a hawaiian pizza.
     * @param event
     */
    @FXML
    void orderHawaiian(ActionEvent event) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pizza-custom.fxml"));
            Scene scene = new Scene(loader.load(), 600, 400);
            stage.setTitle("Hawaiian");
            stage.setScene(scene);
            stage.show();
            ((PizzaCustomController)(loader.getController())).setHawaiian();
            ((PizzaCustomController)(loader.getController())).setCurrent_order(current_order);
        }
        catch(java.io.IOException i){
        }
    }

    /**
     * Opens the pizza customization window for a pepperoni pizza.
     * @param event
     */
    @FXML
    void orderPepperoni(ActionEvent event) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pizza-custom.fxml"));
            Scene scene = new Scene(loader.load(), 600, 400);
            stage.setTitle("Pepperoni");
            stage.setScene(scene);
            stage.show();
            ((PizzaCustomController)(loader.getController())).setPepperoni();
            ((PizzaCustomController)(loader.getController())).setCurrent_order(current_order);
        }
        catch(java.io.IOException i){
        }
    }

    /**
     * Opens the current orders window with all pizzas added to the order.
     * @param event
     */
    @FXML
    void openCurrentOrder(ActionEvent event) {
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("current-order.fxml"));
            Scene scene = new Scene(loader.load(), 600, 400);
            stage.setTitle("Current Order");
            stage.setScene(scene);
            ((CurrentOrderController)(loader.getController())).setCurrent_order(current_order);
            ((CurrentOrderController)(loader.getController())).setStore_orders(sorders);
            stage.showAndWait();
            if(current_order.getPhonenumber() != null) current_order = new Order();
        }
        catch(java.io.IOException i){
        }
    }

    /**
     * Opens the store orders window with all orders placed to the store.
     * @param event
     */
    @FXML
    void storeOrders(ActionEvent event){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("store-orders.fxml"));
            Scene scene = new Scene(loader.load(), 600, 400);
            stage.setTitle("Current Order");
            stage.setScene(scene);
            ((StoreOrdersController)(loader.getController())).setStore_orders(sorders);
            stage.showAndWait();
            if(current_order.getPhonenumber() != null) current_order = new Order();
        }
        catch(java.io.IOException i){
        }
    }
}

