package CargoHold.Factors;

import java.util.*;
/**
 * Suitcase allows users to store items within an array list and calculate the total weight
 * @author skalg
 *
 */
public class Suitcase {
    private int maxWeight;
    private ArrayList<Item> items = new ArrayList<>();

    /**
     *
     * @param maxWeight
     * asking for the maximum weight of the suitcase to determine the appropriate amount of items inserted
     */
    public Suitcase(int maxWeight)
    {
        this.maxWeight = maxWeight;
    }

    /**
     *
     * @return getter for private maxWeight
     */
    public int getMaxWeight() {
        return maxWeight;
    }

    /**
     *
     * @param maxWeight setter for private maxWeight
     */
    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    /**
     *
     * @return getter for private array list items
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     *
     * @param items setter for private array list items
     */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     *
     * @param item item name from the Item class
     */
    public void addItem(Item item)
    {
        if(maxWeight+1 > item.getWeight())
        {
            this.items.add(item);
        }
    }

    /**
     *
     * @return sum of the weight based on the size of the array
     */
    public int totalWeight()
    {
        int sumOfWeight = 0;
        for(int i = 0; i <= items.size()-1; i++)
        {
            sumOfWeight+=items.get(i).getWeight();
        }
        return sumOfWeight;
    }

    /**
     *
     * @return returns a message based on the amount of items within the suitcase
     */
    @Override
    public String toString() {

        String itemString = "";

        if(items.size() == 0){
            itemString = "no items" + " (" + this.totalWeight() + " kg)";
        }
        else if(items.size() == 1){
            itemString = this.items.size() + " item (" + this.totalWeight() + " kg)";
        } else {
            itemString = this.items.size() + " items (" + this.totalWeight() + " kg)";
        }

        return itemString;
    }
}
