package net.sevecek;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import net.sevecek.util.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JPanel contentPane;
    JLabel labBalon;
    JLabel labOdrazka1;
    JLabel labOdrazka2;
    JKeyboard klavesnice;
    Random random1;
    JTimer casovac;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    Integer posunX;
    Integer posunY;


    public HlavniOkno() {
        initComponents();
    }

    private void priOtevreniOkna(WindowEvent e) {
        casovac.start();
        posunX = -5;
        posunY = -5;
    }

    private void priZavreniOkna(WindowEvent e) {
        casovac.stop();
    }

    private void priTiknitiCasovace(ActionEvent e) {

        Point poziceBalon;
        Integer xBalon;
        Integer yBalon;
        Integer balonSirka;
        balonSirka = labBalon.getWidth();
        Integer balonVyska;
        balonVyska = labBalon.getHeight();
        poziceBalon = labBalon.getLocation();
        xBalon = poziceBalon.x;
        yBalon = poziceBalon.y;

        if (xBalon < 5 + labOdrazka1.getWidth()) {
            posunX = 5;
        }
        if (xBalon + balonSirka > labOdrazka2.getWidth()) {
            posunX = -5;
        }
        if (yBalon < 0) {
            posunY = 5;
        }
        if (yBalon + balonVyska > contentPane.getHeight()) {
            posunY = -5;
        }

        xBalon = xBalon + posunX;
        yBalon = yBalon + posunY;

        poziceBalon.x = xBalon;
        poziceBalon.y = yBalon;

        labBalon.setLocation(poziceBalon);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        contentPane = new JPanel();
        labBalon = new JLabel();
        labOdrazka1 = new JLabel();
        labOdrazka2 = new JLabel();
        klavesnice = new JKeyboard();
        random1 = new Random();
        casovac = new JTimer();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Moje nov\u00e1 aplikace");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                priZavreniOkna(e);
            }
            @Override
            public void windowOpened(WindowEvent e) {
                priOtevreniOkna(e);
            }
        });
        Container contentPane2 = getContentPane();
        contentPane2.setLayout(new BorderLayout());

        //======== contentPane ========
        {
            contentPane.setBackground(Color.white);
            contentPane.setLayout(null);

            //---- labBalon ----
            labBalon.setIcon(new ImageIcon(getClass().getResource("/net/sevecek/balonek.jpg")));
            contentPane.add(labBalon);
            labBalon.setBounds(new Rectangle(new Point(185, 125), labBalon.getPreferredSize()));

            //---- labOdrazka1 ----
            labOdrazka1.setBackground(new Color(0, 102, 204));
            labOdrazka1.setOpaque(true);
            contentPane.add(labOdrazka1);
            labOdrazka1.setBounds(5, 80, 15, 185);

            //---- labOdrazka2 ----
            labOdrazka2.setBackground(new Color(0, 102, 204));
            labOdrazka2.setOpaque(true);
            contentPane.add(labOdrazka2);
            labOdrazka2.setBounds(785, 65, 15, 185);
            contentPane.add(klavesnice);
            klavesnice.setBounds(new Rectangle(new Point(20, 15), klavesnice.getPreferredSize()));

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < contentPane.getComponentCount(); i++) {
                    Rectangle bounds = contentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = contentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                contentPane.setMinimumSize(preferredSize);
                contentPane.setPreferredSize(preferredSize);
            }
        }
        contentPane2.add(contentPane, BorderLayout.CENTER);
        setSize(815, 535);
        setLocationRelativeTo(null);

        //---- casovac ----
        casovac.setDelay(25);
        casovac.setInitialDelay(25);
        casovac.addActionListener(e -> priTiknitiCasovace(e));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
