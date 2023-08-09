package CargoHold;

public class Finance
{
    private Hold hold;
    private double cost;

    public Finance(double cost)
    {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public Hold getHold() {
        return hold;
    }
    public void setHold(Hold hold) {
        this.hold = hold;
    }

    public double getPrice(Finance fin)
    {
        return hold.sumOfWeight() * fin.cost;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
