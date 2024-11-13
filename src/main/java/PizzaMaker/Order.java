package PizzaMaker;

import java.util.ArrayList;

/**
 * Keeps track of pizzas for a given order, identified by phone number.
 * @author Pridhau Manohar, Jay Shah
 */
public class Order {
    String phonenumber;
    protected ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
    final static int PHONENUMBERLENGTH = 10;
    final static double TAXRATE = .06625;

    /**
     * Constructor for an order given a phone number.
     * @param phonenumber
     */
    public Order(String phonenumber){
        this.phonenumber = phonenumber;
    }

    /**
     * Constructor for an order with  no parameters.
     */
    public Order(){}

    /**
     * Sets the pizzas list to the given arraylist.
     * @param pizzas
     */
    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    /**
     *Returns the phone number string for this order.
     * @return  phone number string.
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * Returns the pizzas arraylist.
     * @return pizzas arraylist.
     */
    public ArrayList<Pizza> getPizzas(){
        return pizzas;
    }

    /**
     *Calculates subtotal by adding up the prices of each pizza in the list.
     * @return the subtotal of the order.
     */
    public double getSubtotal(){
        double subtotal = 0;
        for(int i = 0; i < pizzas.size(); i++){
            subtotal += pizzas.get(i).price();
        }
        return subtotal;
    }

    /**
     * Calculates the tax by multiplying the subtotal by the tax rate.
     * @return tax.
     */
    public double getTax(){
        return getSubtotal() * TAXRATE;
    }

    /**
     * Calculates the total for the order by adding the subtotal and the tax.
     * @return the total cost of the order.
     */
    public double getTotal(){
        return getSubtotal() + getTax();
    }

    /**
     * Adds the given pizza to the pizzas list.
     * @param pizza
     */
    public void add(Pizza pizza){
        pizzas.add(pizza);
    }

    /**
     * Removes the given pizza from the pizzas list.
     * @param pizza
     */
    public void remove(Pizza pizza){
        for(int i = 0; i < pizzas.size(); i++){
            if(pizza.equals( pizzas.get(i))){
                pizzas.remove(i);
                return;
            }
        }
    }

    /**
     * Returns whether the given phone number is a valid 10 digit number.
     * @param phonenumber
     * @return true if the phone number is valid, false if not.s
     */
    public boolean validNumber(String phonenumber){
        if(phonenumber.length() != PHONENUMBERLENGTH) return false;
        for(int i = 0; i < phonenumber.length(); i++){
            if(!Character.isDigit(phonenumber.charAt(i))) return false;
        }
        return true;
    }

    /**
     * Returns a string with information about the order.
     * @return string with information about the order.
     */
    @Override
    public String toString(){
        String ret = phonenumber + ":\n";
        for(int i = 0; i< pizzas.size(); i++){
            ret += "\t" + pizzas.get(i).toString() + "\n";
        }
        return ret;
    }

    /**
     * Returns true if the phone numbers are equal.
     * Returns false if the phone numbers are different.
     * @param obj
     * @return whether the phone numbers are equal.
     */
    @Override
    public boolean equals(Object obj){
        return ((Order)obj).getPhonenumber().equals(phonenumber);
    }
}
