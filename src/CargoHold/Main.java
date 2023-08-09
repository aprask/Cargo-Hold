package CargoHold;
import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setTitle("Cargo Hold");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        ImageIcon image = new ImageIcon("istockphoto-450152019-612x612.png");
        frame.setIconImage(image.getImage());
    }
}