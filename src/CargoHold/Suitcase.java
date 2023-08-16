package CargoHold;
import java.util.*;
public class Suitcase {
    private int maxWeight;
    private ArrayList<Item> items = new ArrayList<>();
    public Suitcase(int maxWeight)
    {
        this.maxWeight = maxWeight;
    }
    public int getMaxWeight() {
        return maxWeight;
    }
    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item)
    {
        if(maxWeight+1 > item.getWeight())
        {
            this.items.add(item);
        }
    }

    public int totalWeight()
    {
        int sumOfWeight = 0;
        for(int i = 0; i <= items.size()-1; i++)
        {
            sumOfWeight+=items.get(i).getWeight();
        }
        return sumOfWeight;
    }

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
