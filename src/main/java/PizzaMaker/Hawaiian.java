package PizzaMaker;

import java.text.DecimalFormat;

/**
 * A Hawaiian pizza that calculates price accordingly.
 * @author Pridhau Manohar, Jay Shah
 */
public class Hawaiian extends Pizza{
    final static int HAWAIIAN_TOPPINGS = 2;
    final static double SMALL_HAWAIIAN_PRICE = 10.99;

    /**
     * Constructs a hawaiian pizza.
     */
    public Hawaiian(){

    }

    /**
     * Return the price of the pizza.
     * @return price of the pizza.
     */
    @Override
    public double price(){
        double toppingprice = (toppings.size() - HAWAIIAN_TOPPINGS) * ADD_TOPPING;
        double sizeprice = SMALL_HAWAIIAN_PRICE;
        if(toppingprice < 0) toppingprice = 0;
        if(size == Size.MEDIUM) sizeprice += ADD_SIZE;
        if(size == Size.LARGE) sizeprice += ADD_SIZE*2;

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
        return "Hawaiian, " + size + ", $" + df.format(price()) + ", "+ toppingsString();
    }
}
