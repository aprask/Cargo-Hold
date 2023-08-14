package CargoHold;
public class Item
{
    private String name;
    private int weight;
    public Item(String name, int weight)
    {
        this.name = name;
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    @Override
    public String toString()
    {
        return this.name + " (" + this.weight + " kg" + ")";
    }
}