package PizzaMaker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Controller class for the current order window.
 * @author Pridhau Manohar, Jay Shah
 */
public class CurrentOrderController {
    private Order current_order;
    private StoreOrders store_orders;
    final static int EMPTYLISTLENGTH = 0;


    @FXML
    private TextField phonenumberText;

    @FXML
    private TextField subtotalText;

    @FXML
    private TextField taxText;

    @FXML
    private TextField totalText;

    @FXML
    private ListView<Pizza> pizzaslist;

    /**
     * Sets the store orders to the given store orders object.
     * @param orders
     */
    public void setStore_orders(StoreOrders orders){
        store_orders = orders;
    }

    /**
     * Sets the order displayed as the given order.
     * @param order
     */
    public void setCurrent_order(Order order) {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        current_order = order;
        for(int i = 0; i < order.getPizzas().size(); i++)
            pizzaslist.getItems().add(order.getPizzas().get(i));
        subtotalText.setText(df.format(current_order.getSubtotal()));
        taxText.setText(df.format(current_order.getTax()));
        totalText.setText(df.format(current_order.getTotal()));
    }

    /**
     * Places the order, clears the order displayed, and adds the order to the store orders.
     * @param event
     */
    @FXML
    void placeOrder(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        if(!current_order.validNumber(phonenumberText.getText())){
            a.setTitle("INVALID PHONE NUMBER");
            a.setContentText("Phone number must be a 10 digit number.");
            a.show();
            return;
        }
        if(current_order.getTotal() <= 0){
            a.setTitle("EMPTY ORDER");
            a.setContentText("This order is empty.");
            a.show();
            return;
        }
        if(store_orders.ordered(phonenumberText.getText())){
            a.setTitle("INVALID PHONE NUMBER");
            a.setContentText("Phone number has already placed an order.");
            a.show();
            return;
        }
        Order neworder = new Order(phonenumberText.getText());
        neworder.setPizzas(current_order.getPizzas());
        store_orders.add(neworder);
        current_order.setPizzas(new ArrayList<Pizza>());

        DecimalFormat df = new DecimalFormat("0.00");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        subtotalText.setText(df.format(current_order.getSubtotal()));
        taxText.setText(df.format(current_order.getTax()));
        totalText.setText(df.format(current_order.getTotal()));
        phonenumberText.setText(null);
        while(!pizzaslist.getItems().isEmpty())  pizzaslist.getItems().remove(EMPTYLISTLENGTH);

    }

    /**
     * Removes the selected item from the order and sets the prices accordingly.
     * @param event
     */
    @FXML
    void removeItem(ActionEvent event) {
        Pizza pizza = pizzaslist.getSelectionModel().getSelectedItem();
        pizzaslist.getItems().remove(pizza);
        current_order.remove(pizza);
        DecimalFormat df = new DecimalFormat("0.00");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        subtotalText.setText(df.format(current_order.getSubtotal()));
        taxText.setText(df.format(current_order.getTax()));
        totalText.setText(df.format(current_order.getTotal()));
    }

}
