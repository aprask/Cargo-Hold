package CargoHold.Factors;

import java.util.*;
/**
 * Hold allows users to store suitcases in an array list (array list within an array list)
 * @author skalg
 *
 */
public class Hold {
    private final ArrayList<Suitcase> suitcases = new ArrayList<>();
    private int maxWeight;

    /**
     *
     * @param maxWeight asking for the max weight of the hold (determines the appropriate amount of suitcases)
     */
    public Hold(int maxWeight)
    {
        this.maxWeight = maxWeight;
    }

    /**
     *
     * @param maxWeight sets maxWeight to be accessed publicly
     */
    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    /**
     *
     * @param suitcase suitcase from the Suitcase class
     */
    public void addSuitcase(Suitcase suitcase) {
        this.suitcases.add(suitcase);
    }

    /**
     *
     * @return maxWeight * $0.75 = cost for hold
     */
    public double holdCost()
    {
        return (this.maxWeight)*.75;
    }

    /**
     *
     * @return suitcase size, max weight in kg, and the total cost from holdCost()
     */
    @Override
    public String toString() {
        return
                this.suitcases.size() + " suitcases " + this.maxWeight + " kg."
                + "\nCost: " + holdCost();
    }
}