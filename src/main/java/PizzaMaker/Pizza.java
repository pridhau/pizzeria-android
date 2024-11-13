package PizzaMaker;

import java.util.ArrayList;

/**
 * A pizza with a toppings list, size, and price.
 * @author Pridhau Manohar, Jay Shah
 */
public abstract class Pizza {
    final static double ADD_SIZE = 2;
    final static double ADD_TOPPING = 1.49;
    protected ArrayList<Topping> toppings = new ArrayList<Topping>();
    protected Size size;

    /**
     * Returns the price of the pizza.
     * @return price of the pizza.
     */
    public abstract double price();

    /**
     * Returns the size of the pizza.
     * @return size of the pizza.
     */
    public Size getSize() {
        return size;
    }

    /**
     * Adds the given topping to the pizza.
     * @param topping
     */
    public void addTopping(Topping topping){
        toppings.add(topping);
    }

    /**
     * Removes the given topping from the pizza.
     * @param topping
     */
    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }

    /**
     * Returns a string with all toppings on the pizza.
     * @return string with all toppings on the pizza.
     */
    public String toppingsString(){
        String fin = "";
        boolean first = true;
        for(int i = 0; i < toppings.size(); i++){
            if(!first){
                fin += ", ";
            }
            else first = false;
            fin += toppings.get(i);
        }
        return fin;
    }

    /**
     * Sets the size of the pizza to the given size.
     * @param size
     */
    public void setSize(Size size){
        this.size = size;
    }
}
