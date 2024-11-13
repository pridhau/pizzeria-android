package PizzaMaker;

/**
 * Creates an instance of subclasses based on the chosen flavor.
 * @author Pridhau Manohar, Jay Shah
 */
public class PizzaMaker {
    final static String HAWAIIANSTR = "HAWAIIAN";
    final static String DELUXESTR = "DELUXE";
    final static String PEPPERONISTR = "PEPPERONI";
    /**
     * Returns a pizza object with the correct flavor.
     * Expected flavor is Hawaiian, Pepperoni, or Deluxe.
     * @param flavor
     * @return pizza object.
     */
    public static Pizza createPizza(String flavor) {
        flavor = flavor.toUpperCase();
        if(flavor.equals(HAWAIIANSTR)) return new Hawaiian();
        if(flavor.equals(DELUXESTR)) return new Deluxe();
        if(flavor.equals(PEPPERONISTR)) return new Pepperoni();
        return null;
    }
}
