package PizzaMaker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DecimalFormat;

/**
 * Controller class for pizza customization.
 * @author Pridhau Manohar, Jay Shah
 */
public class PizzaCustomController {
    private Pizza pizza;
    private Order current_order;
    private String flavor;
    @FXML
    private TextField priceText;

    @FXML
    private ImageView imageView;
    @FXML
    private ListView<Topping> toppingsList;

    @FXML
    private ListView<Topping> toppingsOptions;

    @FXML
    private ComboBox<Size> sizechoice;

    /**
     * Sets the price displayed in the text field.
     */
    private void setPrice(){
        DecimalFormat df = new DecimalFormat("0.00");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        priceText.setText(df.format(pizza.price()));

    }

    /**
     * Adds a given topping to the pizza and the displayed list of added toppings.
     * Removes the topping from the displayed list of unadded toppings.
     * @param t
     */
    private void addTopping(Topping t) {
        toppingsOptions.getItems().remove(t);
        toppingsList.getItems().add(t);
        pizza.addTopping(t);
    }

    /**
     * Sets the current order to the given order.
     * @param order
     */
    public void setCurrent_order(Order order) {
        current_order = order;
    }

    /**
     * Removes a topping from the pizza and from the list of added toppings.
     * Adds the topping to the list of unadded toppings.
     * @param t
     */
    private void removeTopping(Topping t) {
        toppingsOptions.getItems().add(t);
        toppingsList.getItems().remove(t);
        pizza.removeTopping(t);
    }

    /**
     * Sets the list of unadded toppings to be all of the toppings.
     * Populates the size dropdown menu with all sizes and sets the size to small by default.
     */
    @FXML
     void initialize() {

        sizechoice.getItems().add(Size.SMALL);
        sizechoice.getItems().add(Size.MEDIUM);
        sizechoice.getItems().add(Size.LARGE);
        sizechoice.getSelectionModel().selectFirst();
        toppingsOptions.getItems().add(Topping.MUSHROOMS);
        toppingsOptions.getItems().add(Topping.PEPPERS);
        toppingsOptions.getItems().add(Topping.OLIVES);
        toppingsOptions.getItems().add(Topping.SAUSAGE);
        toppingsOptions.getItems().add(Topping.CHICKEN);
        toppingsOptions.getItems().add(Topping.PINEAPPLE);
        toppingsOptions.getItems().add(Topping.PEPPERONI);
    }

    /**
     * Sets the image to a deluxe pizza and adds the appropriate toppings.
     */
    public void setDeluxe() {
        try {
            flavor = PizzaMaker.DELUXESTR;
            pizza = PizzaMaker.createPizza(flavor);
            InputStream stream = new FileInputStream(MainMenuController.DELUXE_IMG);
            Image image = new Image(stream);
            imageView.setImage(image);
            addTopping(Topping.PEPPERONI);
            addTopping(Topping.MUSHROOMS);
            addTopping(Topping.PEPPERS);
            addTopping(Topping.OLIVES);
            addTopping(Topping.SAUSAGE);
            pizza.setSize(Size.SMALL);
            setPrice();
        } catch (FileNotFoundException f) {
        }
    }

    /**
     * Sets the image to a hawaiian pizza and adds the appropriate toppings.
     */
    public void setHawaiian() {
        try {
            flavor = PizzaMaker.HAWAIIANSTR;
            pizza = PizzaMaker.createPizza(flavor);
            InputStream stream = new FileInputStream(MainMenuController.HAWAIIAN_IMG);
            Image image = new Image(stream);
            imageView.setImage(image);
            addTopping(Topping.PINEAPPLE);
            addTopping(Topping.CHICKEN);
            pizza.setSize(Size.SMALL);
            setPrice();
        } catch (FileNotFoundException f) {
        }
    }

    /**
     * Sets the image to a pepperoni pizza and adds the appropriate toppings.
     */
    public void setPepperoni() {
        try {
            flavor = PizzaMaker.PEPPERONISTR;
            pizza = PizzaMaker.createPizza(flavor);
            InputStream stream = new FileInputStream(MainMenuController.PEPPERONI_IMG);
            Image image = new Image(stream);
            imageView.setImage(image);
            addTopping(Topping.PEPPERONI);
            pizza.setSize(Size.SMALL);
            setPrice();
        } catch (FileNotFoundException f) {
        }
    }

    /**
     * Adds the selected topping to the pizza using addTopping() and sets the price using setPrice().
     * @param event
     */
    @FXML
    void add(ActionEvent event) {
        try {
            int index = toppingsOptions.getSelectionModel().getSelectedIndex();
            addTopping(toppingsOptions.getItems().get(index));
            setPrice();
        } catch (IndexOutOfBoundsException i) {
        }
    }

    /**
     * Removes the selected topping from the pizza using removeTopping() and sets the price using setPrice().
     * @param event
     */
    @FXML
    void remove(ActionEvent event) {
        try {
            int index = toppingsList.getSelectionModel().getSelectedIndex();
            removeTopping(toppingsList.getItems().get(index));
            setPrice();
        } catch (IndexOutOfBoundsException i) {
        }
    }

    /**
     * Takes the inputted phone number and adds the pizza to the order.
     * @param event
     */
    @FXML
    void addOrder(ActionEvent event) {
        current_order.add(pizza);
        pizza = PizzaMaker.createPizza(flavor);
        pizza.setSize(sizechoice.getValue());
        for(int i = 0; i< toppingsList.getItems().size(); i++){
            pizza.addTopping(toppingsList.getItems().get(i));
        }
    }

    /**
     * Changes the size of the pizza and sets the price using setPrice().
     * @param event
     */
    @FXML
    void setSize(ActionEvent event) {
        pizza.setSize(sizechoice.getValue());
        setPrice();

    }
}
