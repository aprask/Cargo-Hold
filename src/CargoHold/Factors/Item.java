package CargoHold.Factors;

/**
 * Item allows users to specify the name and weight of an individual item before it is placed in a suitcase
 * @author skalg
 *
 */
public class Item
{
    private String name;
    private int weight;

    /**
     *
     * @param name uses the string type given by the user for the name of the item
     * @param weight uses the int type given by the user for the weight of the item
     */
    public Item(String name, int weight)
    {
        this.name = name;
        this.weight = weight;
    }

    /**
     *
     * @return getter for private weight
     */
    public int getWeight() {
        return weight;
    }
    /**
     *
     * @return getter for private name
     */
    public String getName() {
        return name;
    }
    /**
     *
     * @param name setter for private name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *
     * @param weight setter for private weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     *
     * @return lists the name and weight of the item in kg (kilograms)
     */
    @Override
    public String toString()
    {
        return this.name + " (" + this.weight + " kg" + ")";
    }
}