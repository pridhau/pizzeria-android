package PizzaMaker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.text.DecimalFormat;

/**
 * Controller class for the store orders.
 * @author Pridhau Manohar, Jay Shah
 */
public class StoreOrdersController {
    private StoreOrders store_orders;
    private Order order = null;

    @FXML
    private ListView<Pizza> orderlist;

    @FXML
    private ComboBox<String> phonenumberlist;

    @FXML
    private TextField totaltext;

    /**
     * Sets the store orders to the given store orders.
     * @param sorders
     */
    public void setStore_orders(StoreOrders sorders){
        store_orders = sorders;
        for(int i = 0; i < sorders.getOrders().size(); i++){
            phonenumberlist.getItems().add(sorders.getOrders().get(i).getPhonenumber());
        }

    }

    /**
     * Deletes the order from the store orders list.
     * @param event
     */
    @FXML
    void cancelOrder(ActionEvent event) {
        if(phonenumberlist.getValue() == null) return;
        store_orders.remove(phonenumberlist.getValue());
        totaltext.setText(null);
        while(!orderlist.getItems().isEmpty())
            orderlist.getItems().remove(CurrentOrderController.EMPTYLISTLENGTH);
        phonenumberlist.getItems().remove(phonenumberlist.getValue());
        phonenumberlist.getSelectionModel().selectFirst();
    }

    /**
     * Exports the order to a file of the user's choosing.
     * @param event
     */
    @FXML
    void exportOrder(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Target File");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
        new FileChooser.ExtensionFilter("All Files", "*"));
        Stage stage = new Stage();
        File targetFile = chooser.showSaveDialog(stage);

        store_orders.export(targetFile);
    }

    /**
     * Shows the order of the phone number that the user selects from the dropdown menu.
     * @param event
     */
    @FXML
    void listOrder(ActionEvent event){
        order = store_orders.find(phonenumberlist.getValue());
        if(order == null) return;
        DecimalFormat df = new DecimalFormat("0.00");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        totaltext.setText(df.format(order.getTotal()));

        while(!orderlist.getItems().isEmpty())
            orderlist.getItems().remove(CurrentOrderController.EMPTYLISTLENGTH);
        for(int i = 0; i < order.getPizzas().size(); i++){
            orderlist.getItems().add(order.getPizzas().get(i));
        }
    }
}
