package PizzaMaker;

import java.text.DecimalFormat;

/**
 * A deluxe pizza that calculates price accordingly.
 * @author Pridhau Manohar, Jay Shah
 */
public class Deluxe extends Pizza{
    final static int DELUXE_TOPPINGS = 5;
    final static double SMALL_DELUXE_PRICE = 12.99;

    /**
     * Constructs a deluxe pizza.
     */
    public Deluxe(){

    }

    /**
     * Returns the price of the pizza.
     * @return price of the pizza
     */
    @Override
    public double price(){
        double toppingprice = (toppings.size() - DELUXE_TOPPINGS) * ADD_TOPPING;
        if(toppingprice < 0) toppingprice = 0;
        double sizeprice = SMALL_DELUXE_PRICE;
        if(size == Size.MEDIUM) sizeprice += ADD_SIZE;
        if(size == Size.LARGE) sizeprice += ADD_SIZE + ADD_SIZE;

        return toppingprice + sizeprice;
    }

    /**
     * Returns a string with the type, size, price, and toppings of the pizza.
     * @return string with information on the pizza.
     */
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("0.00");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        return "Deluxe, " + size + ", $" + df.format(price()) + ", "+ toppingsString();
    }
}
