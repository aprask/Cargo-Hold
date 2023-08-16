package CargoHold;

import java.util.*;

public class Hold {
    private ArrayList<Suitcase> suitcases = new ArrayList<>();
    private int maxWeight;
    public Hold(int maxWeight)
    {
        this.maxWeight = maxWeight;
    }
    public ArrayList<Suitcase> getSuitcases() {
        return suitcases;
    }
    public void setSuitcases(ArrayList<Suitcase> suitcases) {
        this.suitcases = suitcases;
    }
    public int getMaxWeight() {
        return maxWeight;
    }
    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int sumOfWeight()
    {
        int sumTotal = 0;
        for(int i = 0; i <= suitcases.size()-1; i++)
        {
            sumTotal+=this.maxWeight;
        }
        return sumTotal;
    }
    public void addSuitcase(Suitcase suitcase) {
        this.suitcases.add(suitcase);
    }

    public void printItems()
    {
        for(int i = 0; i <= suitcases.size()-1; i++)
        {
            System.out.println(suitcases.get(i).getItems());
        }
    }

    public double holdCost()
    {
        return (sumOfWeight())*.75; // sum of weight * amount of cases * .75
    }

    @Override
    public String toString() {
        return
                this.suitcases.size() + " suitcases " + sumOfWeight() + " kg."
                + "\nCost: " + holdCost();
    }
}