package PizzaMaker;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Store orders class that maintains a list of orders.
 * @author Pridhau Manohar, Jay Shah
 */
public class StoreOrders {
    protected ArrayList<Order> orders = new ArrayList<Order>();


    /**
     * Returns the orders list.
     * @return orders list.
     */
    ArrayList<Order> getOrders(){
        return orders;
    }

    /**
     * Returns whether the number matches an order in the orders list.
     * @param number
     * @return true if the number matches an order in the orders list, and false if not.
     */
    public boolean ordered(String number){
        for(int i = 0; i < orders.size(); i ++){
            if(orders.get(i).getPhonenumber().equals(number)) return true;
        }
        return false;
    }

    /**
     * Adds an order to the orders list.
     * @param order
     */
    public void add(Order order){
        orders.add(order);
    }

    /**
     * Returns the order that matches the given phone number.
     * @param number
     * @return the order that matches the phone number or null if not found.
     */
    public Order find(String number){
        for(int i = 0; i < orders.size(); i++){
            if(orders.get(i).getPhonenumber().equals(number)) return orders.get(i);
        }
        return null;
    }

    /**
     * Removes the order matching the phone number from the orders list.
     * @param phonenumber
     */
    public void remove(String phonenumber){
        Order tempOrder = new Order(phonenumber);
        for(int i = 0; i < orders.size(); i++){
            if(orders.get(i).equals(tempOrder)){
                orders.remove(i);
                return;
            }
        }
    }

    /**
     * Exports the store orders to a file.
     */
    public boolean export(File file){

        try{
            PrintWriter writer = new PrintWriter(file);
            for(int i = 0; i < orders.size(); i++){
                writer.println(orders.get(i).toString());
                System.out.println(orders.get(i).toString());
            }
            writer.close();
        }
        catch(java.io.IOException i){
            return false;
        }
        return true;
    }
}
