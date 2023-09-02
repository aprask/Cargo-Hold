package CargoHold.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    JButton jButton1;
    JButton jButton2;
    public boolean proceedValue;
    public Menu()
    {
        ImageIcon imageIcon = new
                ImageIcon("C:\\Users\\skalg\\IdeaProjects\\CargoHold\\reference\\image4.jpg");

        jButton1 = new JButton();
        jButton1.setBounds(5,5,100,50);
        jButton1.setText("START");
        jButton1.setForeground(Color.white);
        jButton1.setBackground(Color.black);
        jButton1.setBorder(BorderFactory.createEtchedBorder());
        jButton1.addActionListener(this);

        jButton2 = new JButton();
        jButton2.setBounds(5,100,100,50);
        jButton2.setText("EXIT");
        jButton2.setForeground(Color.white);
        jButton2.setBackground(Color.black);
        jButton2.setBorder(BorderFactory.createEtchedBorder());
        jButton2.addActionListener(this);

        JLabel label = new JLabel();
        label.setIcon(imageIcon);
        label.setFont(new Font("MV Boli", Font.BOLD,20));
        label.setText("Cargo Hold Simulator");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setBackground(Color.white);
        label.setOpaque(true);

        this.setTitle("Cargo Hold");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000,1000);
        this.add(jButton1);
        this.add(jButton2);
        this.add(label);
        this.setVisible(true);
    }

    public boolean getProceedValue() {
        return proceedValue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jButton1)
        {
            proceedValue = true;
        }
        else if(e.getSource()==jButton2)
        {
            proceedValue = false;
        }
    }
}
