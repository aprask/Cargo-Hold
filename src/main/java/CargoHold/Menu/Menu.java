package CargoHold.Menu;

import CargoHold.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Menu extends JFrame implements ActionListener {

    static CargoHold cargoHold = new CargoHold();
    JMenuItem beginProgram;
    JMenuItem openReceipt;
    JMenuItem exitProgram;
    JMenuItem resetProgram;
    public Menu()
    {

        JMenuBar menu = new JMenuBar();
        menu.setBackground(Color.gray);
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        beginProgram = new JMenuItem("Start");
        openReceipt  = new JMenuItem("Open Receipt");
        exitProgram  = new JMenuItem("Exit");
        menu.add(fileMenu);
        fileMenu.add(beginProgram);
        fileMenu.add(openReceipt);
        fileMenu.add(exitProgram);
        beginProgram.addActionListener(this);
        openReceipt.addActionListener(this);
        exitProgram.addActionListener(this);

        resetProgram = new JMenuItem("Reset");
        editMenu.add(resetProgram);
        menu.add(editMenu);
        resetProgram.addActionListener(this);

        ImageIcon image = new ImageIcon("C:\\Users\\skalg\\IdeaProjects\\CargoHold\\reference\\box.png");
        JLabel label = new JLabel();
        label.setBackground(Color.white);
        label.setIcon(image);
        label.setText("Cargo Hold");
        label.setFont(new Font("MV Boli", Font.BOLD, 100));
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setOpaque(false);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,1000);
        this.setLayout(new FlowLayout());
        this.setJMenuBar(menu);
        this.add(label);
        this.setTitle("Cargo Hold");
        this.setBackground(Color.white);
        this.setVisible(true);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==beginProgram)
        {
            cargoHold.catalogItem(2,50);
        }
        if(e.getSource()==openReceipt)
        {
            try {
                displayReceipt();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if(e.getSource()==exitProgram)
        {
            System.exit(0);
        }
        if(e.getSource()==resetProgram)
        {
            cargoHold.catalogItem(2,50);
        }
    }
    public void displayReceipt() throws IOException {

        cargoHold.openReceipt();
    }
}
