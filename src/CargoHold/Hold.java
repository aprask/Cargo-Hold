package CargoHold;

import java.util.*;

public class Hold {
    private final ArrayList<Suitcase> suitcases = new ArrayList<>();
    private int maxWeight;
    public Hold(int maxWeight)
    {
        this.maxWeight = maxWeight;
    }
    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addSuitcase(Suitcase suitcase) {
        this.suitcases.add(suitcase);
    }

    public double holdCost()
    {
        return (this.maxWeight)*.75;
    }

    @Override
    public String toString() {
        return
                this.suitcases.size() + " suitcases " + this.maxWeight + " kg."
                + "\nCost: " + holdCost();
    }
}