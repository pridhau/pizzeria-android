package PizzaMaker;

import java.text.DecimalFormat;

/**
 * A pepperoni pizza that calculates price accordingly.
 * @author Pridhau Manohar, Jay Shah
 */
public class Pepperoni extends Pizza{
    final static int PEPPERONI_TOPPINGS = 1;
    final static double SMALL_PEPPERONI_PRICE = 8.99;

    /**
     * Constructs a pepperoni pizza.
     */
    public Pepperoni(){

    }
    /**
     * Returns the price of the pizza.
     * @return price of the pizza
     */
    @Override
    public double price(){
        double toppingprice = (toppings.size() - PEPPERONI_TOPPINGS) * ADD_TOPPING;
        double sizeprice = SMALL_PEPPERONI_PRICE;
        if(toppingprice < 0) toppingprice = 0;
        if(size == Size.MEDIUM) sizeprice += ADD_SIZE;
        if(size == Size.LARGE) sizeprice += ADD_SIZE * 2;

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
        return "Pepperoni, " + size + ", $" + df.format(price()) + ", "+ toppingsString();
    }
}
