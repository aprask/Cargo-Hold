package CargoHold;

import CargoHold.Factors.*;
import CargoHold.Menu.*;

import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 * Cargo Hold allows the user to combine the three other previous classes located in the "Factors" package folder
 * @author skalg
 *
 */

public class CargoHold {

    private static final Scanner scanner = new Scanner(System.in);
    static Hold hold = new Hold(0);
    static Suitcase suitcase = new Suitcase(0);
    static Menu menu = new Menu();
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
            JOptionPane.showMessageDialog
                    (
                            null,
                            "Room Left: " + currentAmount,
                            "Room Info",
                            JOptionPane.PLAIN_MESSAGE
                    );
            JOptionPane.showMessageDialog
                    (
                            null,
                            "Weight Capacity: " + maxWeight,
                            "Storage Info",
                            JOptionPane.PLAIN_MESSAGE
                    );
            int index = i + 1;
            String nameOfItem = JOptionPane.showInputDialog("Name of item #" + index + "? ");
            if(checkCharInput(nameOfItem))
            {
                JOptionPane.showMessageDialog
                        (
                                null,
                                "This is not an appropriate name!",
                                "!",
                                JOptionPane.WARNING_MESSAGE
                        );
                break;
            }
            String weightOfItem = JOptionPane.showInputDialog("Weight of item? ");
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
        JOptionPane.showMessageDialog
                (
                        null,
                        hold,
                        "Result",
                        JOptionPane.INFORMATION_MESSAGE
                );
        try {
            createReceipt(hold);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    public void createReceipt(Hold hold) throws IOException {
        BufferedWriter bufferedWriter;
        {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter("result.txt"));
                bufferedWriter.write("Receipt:\n " + hold);
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("result.txt"));
            String storeLine;
            while((storeLine = bufferedReader.readLine()) != null)
            {
                System.out.println(storeLine);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void openReceipt() throws IOException {
        createReceipt(hold);
    }
}