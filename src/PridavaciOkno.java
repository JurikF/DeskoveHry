import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PridavaciOkno extends JFrame{

    JFrame jFrame = new JFrame();
    JTextField text = new JTextField();
    JButton button = new JButton("Přidej!");

    JRadioButton RB1 = new JRadioButton("1");
    JRadioButton RB2 = new JRadioButton("2");
    JRadioButton RB3 = new JRadioButton("3");

    JCheckBox checkBox = new JCheckBox("Zakoupeno");

    String nazev;
    boolean check;

    public PridavaciOkno() {

        text.setBounds(0, 0, 300, 20);
        button.setBounds(100, 30, 80, 20);
        checkBox.setBounds(20, 60, 90, 50);
        RB1.setBounds(30, 100, 90, 50);
        RB2.setBounds(100, 100, 90, 50);
        RB3.setBounds(170, 100, 90, 50);

        jFrame.add(text);
        jFrame.add(button);
        jFrame.add(checkBox);
        jFrame.add(RB1);
        jFrame.add(RB2);
        jFrame.add(RB3);

        jFrame.setTitle("Přidávání hry");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(300, 200);
        jFrame.setLayout(null);
        jFrame.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nazev = text.getText();
                check = checkBox.isSelected();
                ulozDoSouboru();
                jFrame.setVisible(false);
            }
        });
    }
    public void ulozDoSouboru() {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("Deskovky.txt", true)))) {
            writer.println(nazev + ";" + check + ";" + "2"); //musí se zjistit checkbox -> true x false a dodělat radio buttony
            JOptionPane.showMessageDialog(this,"Změny uloženy do souboru.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Chyba při zápisu do souboru: " + e.getLocalizedMessage());
        }
    }

}
