package CargoHold;

import javax.swing.*;
import java.util.ArrayList;

public class Query {

    private Item item;
    static int totalWeightOfCase = 0;
    private final Suitcase suitcase = new Suitcase(totalWeightOfCase);
    static int totalWeightOfHold = totalWeightOfCase;
    private final Hold hold = new Hold(totalWeightOfHold);
    public Query() {}
    public void generateQuery() {
        JOptionPane.showMessageDialog(null, "Welcome to Cargo Hold\nPress Ok", "Cargo Hold", JOptionPane.PLAIN_MESSAGE);
        while (true) {
            int amountOfItems = Integer.parseInt(JOptionPane.showInputDialog
                    (null, "How many items?", "Item Amount", JOptionPane.PLAIN_MESSAGE));
            Item [] myItems = new Item[amountOfItems];
            for(int i = 0; i < myItems.length; i++)
            {
                String itemName = JOptionPane.showInputDialog
                        (null, "Name of item? ", "Item Properties",
                                JOptionPane.INFORMATION_MESSAGE);
                int itemWeight = Integer.parseInt((JOptionPane.showInputDialog
                        (null, "Weight of item", "Item Properties",
                                JOptionPane.INFORMATION_MESSAGE)));
                if(itemName.isEmpty() || itemWeight < 0)
                {
                    String warningMessage = JOptionPane.showInputDialog
                        (null, "ERROR: Input appropriate values", "!WARNING!",
                                JOptionPane.WARNING_MESSAGE);
                }
                myItems[i] = new Item(itemName,itemWeight);
            }
            totalWeightOfCase = Integer.parseInt(JOptionPane.showInputDialog
                        (null,"Enter max weight for suitcase", "Case",
                                JOptionPane.INFORMATION_MESSAGE));
            JOptionPane.showMessageDialog
                        (null, "Making suitcase...", "Loading case",
                                JOptionPane.PLAIN_MESSAGE);
            suitcase.setMaxWeight(totalWeightOfCase);
            for(int i = 0; i <= myItems.length-1; i++)
            {
                int calcWeight = myItems[i].getWeight();
                // TODO: Fix weight calculation
                    // TODO: How to not essentially add the weight when it exceeds the total weight?
                if(calcWeight <= totalWeightOfCase)
                {
                    suitcase.addItem(myItems[i]);
                    suitcase.totalWeight();
                }
                else
                {
                    break;
                }
                calcWeight++;

            }
            System.out.println(suitcase);

        }
    }

}

/*
Program pattern:

list details with GUI window

ask if the user would like to complete purchase (if no, then either quit or restart)
 */

/*
for(int w = 0; w <= myItems.length-1; w++)
            {
                totalWeightOfCase+=myItems[w].getWeight();
            }
            suitcase.setMaxWeight(totalWeightOfCase);
            JOptionPane.showMessageDialog(null, "Selecting hold...", "Loading hold", JOptionPane.PLAIN_MESSAGE);
            for(int i = 0; i <= myItems.length-1; i++)
            {
                suitcase.addItem(myItems[i]);
                hold.addSuitcase(suitcase);
                hold.setMaxWeight(totalWeightOfHold+=totalWeightOfCase);
            }
            hold.setMaxWeight(hold.getMaxWeight()/2);
            JOptionPane.showMessageDialog(null, "WORKING OUT THE DETAILS", "...", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Done.", "...", JOptionPane.PLAIN_MESSAGE);
            System.out.println(suitcase);
            System.out.println();
            System.out.println(hold);
 */