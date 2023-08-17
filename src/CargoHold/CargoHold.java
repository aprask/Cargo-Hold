package CargoHold;

import java.util.*;

public class CargoHold {

    private static Scanner scanner = new Scanner(System.in);
    static Hold hold = new Hold(0);
    static Suitcase suitcase = new Suitcase(0);
    static int totalWeightOfHold = 0;
    public CargoHold() {}

    public void catalogItem(int amount, int maxWeight)
    {
        Item [] myItems = new Item[amount];
        int weightUsed = 0;
        for(int i = 0; i < amount; i++)
        {
            System.out.println("Room: " + amount);
            System.out.println("Total Weight: " + maxWeight);
            System.out.println("Weight Used: " + weightUsed);
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
            if(checkIntInput(weightOfItem))
            {
                System.out.println("This is not an appropriate weight");
                break;
            }
            int convertWeight = Integer.parseInt(weightOfItem);
            myItems[i] = new Item(nameOfItem, convertWeight);
            suitcase.addItem(myItems[i]);
            hold.addSuitcase(suitcase);
            weightUsed += maxWeight - convertWeight;
            hold.setMaxWeight(weightUsed);
        }
        System.out.println(hold);
    }

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
    static boolean checkWeightInput(int value)
    {
        return value > totalWeightOfHold;
    }
}