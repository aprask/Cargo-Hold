package CargoHold;

import java.util.*;

public class CargoHold {

    private static Scanner scanner = new Scanner(System.in);
    static Hold hold = new Hold(0);
    static Suitcase suitcase = new Suitcase(0);
    static int totalWeightOfHold = 0;
    public CargoHold() {}

    public void cargoBuilder()
    {
        while(retrieveRepeat())
        {
            retrieveItemInfo();
        }
    }

    public static void retrieveItemInfo() {
        String amountOfItems;
        String maximumWeight;
        int convertItemAmount = 0;
        int convertMaxWeight = 0;
        int counter = 0;
        System.out.println("Amount? ");
        amountOfItems = scanner.next();
        try
        {
            checkIntInput(amountOfItems);
        } catch(ChoiceException e)
        {
            System.out.println("ERROR: " + e);
            retrieveItemInfo();
        }
        System.out.println("Max weight? ");
        maximumWeight = scanner.next();
        try
        {
            checkIntInput(maximumWeight);
        } catch(ChoiceException e)
        {
            System.out.println("ERROR: " + e);
            retrieveItemInfo();
        }
        convertItemAmount = Integer.parseInt(amountOfItems);
        convertMaxWeight = Integer.parseInt(maximumWeight);
        suitcase.setMaxWeight(convertMaxWeight);
        while(counter < convertItemAmount)
        {
            Item [] myItems = new Item[convertItemAmount];

            for(int i = 0; i < convertItemAmount; i++)
            {
                int totalWeight = 0;
                int index = i+1;
                System.out.println("Name of item " + index + " ? ");
                String nameOfItem = scanner.next();
                try
                {
                    checkCharInput(nameOfItem);
                } catch(Exception e)
                {
                    System.out.println("ERROR: " + e);
                    retrieveItemInfo();
                }
                System.out.println("Weight of item " + index + " ? ");
                String weightOfItem = scanner.next();
                try
                {
                    checkIntInput(weightOfItem);
                } catch(Exception e)
                {
                    System.out.println("ERROR: " + e);
                    retrieveItemInfo();
                }
                int convertWeightOfItem = Integer.parseInt(weightOfItem);
                totalWeightOfHold = convertWeightOfItem;
                try
                {
                    checkWeightInput(convertWeightOfItem);
                }catch(WeightException e)
                {
                    System.out.println("ERROR: " + e);
                    retrieveItemInfo();
                }
                myItems[i] = new Item(nameOfItem,convertWeightOfItem);
                if(i == convertItemAmount-1)
                {
                    for(int j = 0; j < convertItemAmount; j++)
                    {
                        System.out.println(myItems[j]);
                        counter++;
                    }
                }
                totalWeight += myItems[i].getWeight();
                if(totalWeight > convertMaxWeight)
                {
                    break;
                }
                suitcase.addItem(myItems[i]);
            }
        }
        totalWeightOfHold += suitcase.getMaxWeight();
        hold.addSuitcase(suitcase);
        hold.setMaxWeight(totalWeightOfHold);
        System.out.println("hold has: " + hold);
    }
    private static boolean retrieveRepeat()
    {
        System.out.println("Would you like to add a suitcase? (1=yes, 2=no) ");
        int repeatChoice = scanner.nextInt();
        if(repeatChoice == 1)
        {
            return true;
        }
        else
        {
            System.out.println("Total Cost: " + hold.holdCost());
            return false;
        }
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        CargoHold.scanner = scanner;
    }

    static void checkIntInput(String value) throws ChoiceException {
        int lengthOfArray = value.length()-1;
        char[] charArray = new char[lengthOfArray];
        for (int i = 0; i < lengthOfArray; i++) {
            charArray[i] = (char) value.indexOf(i);
            if (Character.isDigit(charArray[i])) {
                throw new ChoiceException("Please enter a word");
            }
        }
    }
    static void checkCharInput(String value) throws ChoiceException {
        int lengthOfArray = value.length()-1;
        char[] charArray = new char[lengthOfArray];
        for (int i = 0; i < lengthOfArray; i++) {
            charArray[i] = (char) value.indexOf(i);
            if (Character.isDigit(charArray[i])) {
                throw new ChoiceException("Please enter a word");
            }
        }
    }
    static void checkWeightInput(int value) throws WeightException
    {
        if(value > totalWeightOfHold)
        {
            throw new WeightException("TOO HEAVY");
        }
    }
}