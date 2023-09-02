package CargoHold;

import CargoHold.Menu.*;

import javax.swing.*;

/**
 * Cargo Hold Main class
 * @author skalg
 *
 */
public class Main {
    public static void main(String[] args)
    {
        /*
        CargoHold cargoHold = new CargoHold();
        cargoHold.catalogItem(2,50);
         */

        Menu menu = new Menu();
        if(menu.getProceedValue())
        {
            System.out.println("start");
        }
        else if(menu.getProceedValue())
        {
            System.out.println("exit");
        }
    }
}