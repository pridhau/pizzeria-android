package PizzaMaker;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit tests for Deluxe pizza.
 * @author Pridhau Manohar, Jay Shah
 */

public class JUnit {

    /**
     * Tests deluxe for all sizes and every number of toppings.
     */
    @Test
    public static void testDeluxe(){
        Pizza pizza = PizzaMaker.createPizza("DELUXE"); // creates a new deluxe pizza.
        Size[] sizes = {Size.SMALL, Size.MEDIUM, Size.LARGE};
        Topping[] toppings = { Topping.CHICKEN, Topping.OLIVES, Topping.PEPPERS,
            Topping.MUSHROOMS, Topping.PEPPERONI, Topping.PINEAPPLE, Topping.SAUSAGE};
        for(int s = 0; s < sizes.length; s ++){ // goes through each size option of the pizza
            pizza.setSize(sizes[s]);
            Assert.assertEquals(12.99 + (2*s) , pizza.price(), .001); //price increases by 2 for each size increase
            //previous asserts that pizza with 0 toppings is still the base price

            for(int t = 0; t < toppings.length; t ++){ //goes through each topping to add it to the pizza and check price
                pizza.addTopping(toppings[t]);
                if(t < 5) Assert.assertEquals(12.99 + (2*s) , pizza.price(), .001); //price does not change for first 5 toppings
                else Assert.assertEquals(12.99 + (2*s) + (1.49 * (t-4)), pizza.price(), .001); //1.49 for each additional topping
            }
            for(int t = 0; t < toppings.length; t ++)
                pizza.removeTopping(toppings[t]); //remove all toppings before testing next size
        }
    }
}
