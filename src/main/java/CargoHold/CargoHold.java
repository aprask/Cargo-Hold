package CargoHold;

import CargoHold.Factors.*;
import java.util.*;

/**
 * Cargo Hold allows the user to combine the three other previous classes located in the "Factors" package folder
 * @author skalg
 *
 */

public class CargoHold {

    private static final Scanner scanner = new Scanner(System.in);
    static Hold hold = new Hold(0);
    static Suitcase suitcase = new Suitcase(0);
    static int totalWeightOfHold = 0;
    public CargoHold() {}

    /**
     *
     * @param amount amount of room/capacity
     * @param maxWeight sets the ceiling for the weight
     */
    public void catalogItem(int amount, int maxWeight)
    {
        Item[] myItems = new Item[amount];
        int trackWeight = 0;
        int currentAmount = amount;
        for(int i = 0; i < amount; i++)
        {
            System.out.println("Room Left: " + currentAmount);
            System.out.println("Total Weight: " + maxWeight);
            int index = i + 1;
            System.out.println("Name of item #" + index + " ? ");
            String nameOfItem = scanner.next();
            if(checkCharInput(nameOfItem))
            {
                System.out.println("This is not an appropriate name");
                break;
            }
            System.out.println("How much does " + nameOfItem + " weigh? ");
            String weightOfItem = scanner.next();
            int convertWeight = Integer.parseInt(weightOfItem);
            myItems[i] = new Item(nameOfItem, convertWeight);
            suitcase.addItem(myItems[i]);
            hold.addSuitcase(suitcase);
            trackWeight = trackWeight + convertWeight;
            currentAmount--;
            if(i == amount-1)
            {
                hold.setMaxWeight(trackWeight);
            }
        }
        System.out.println(hold);
    }

    /**
     *
     * @param value checks to see if the value is a digit
     * @return return true if not int
     */
    static boolean checkIntInput(String value) {
        int lengthOfArray = value.length()-1;
        char[] charArray = new char[lengthOfArray];
        for (int i = 0; i < lengthOfArray; i++) {
            charArray[i] = (char) value.indexOf(i);
            if (!Character.isDigit(charArray[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param value checks to see if the value is a char
     * @return return true if not char
     */
    static boolean checkCharInput(String value) {
        int lengthOfArray = value.length()-1;
        char[] charArray = new char[lengthOfArray];
        for (int i = 0; i < lengthOfArray; i++) {
            charArray[i] = (char) value.indexOf(i);
            if (Character.isDigit(charArray[i])) {
                return true;
            }
        }
        return false;
    }
    /**
     *
     * @param value checks to see if the weight typed exceeds the current weight of the hold
     * @return return true if the input value exceeds the threshold
     */
    static boolean checkWeightInput(int value)
    {
        return value > totalWeightOfHold;
    }
}