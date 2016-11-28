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
    JKeyboard klavesnice;
    JLabel labKonecHry;
    JLabel labOdrazka2;
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
        pohybujBalonem();
        pohybujOdrazka1();
        pohybujOdrazka2();
        if (detekujKolizi(labBalon, labOdrazka1) == true) {
            odrazOdrazku1 ();
        }
        if (detekujKolizi(labBalon, labOdrazka2)== true){
            odrazOdrazku2();       }
        ukonciHru();
    }

    private void priStiskuKlavesy(KeyEvent e) {
        if (klavesnice.isKeyDown(KeyEvent.VK_R)) {
            labBalon.setLocation(375, 200);
            labKonecHry.setVisible(false);
            casovac.start();
        }
    }


    private boolean detekujKolizi(JLabel label1, JLabel label2) {
        Integer ax = label1.getX();
        Integer ay = label1.getY();
        Integer bx = ax + label1.getWidth();
        Integer by = ay + label1.getHeight();

        Integer cx = label2.getX();
        Integer cy = label2.getY();
        Integer dx = cx + label2.getWidth();
        Integer dy = cy + label2.getHeight();

        if ((bx >= cx) && (ax <= dx) && (by >= cy) && (ay <= dy)) {
            return true;
        } else {
            return false;
        }

    }

    private void ukonciHru() {
        Point poziceBalon;
        poziceBalon = labBalon.getLocation();
        Integer xBalon = poziceBalon.x;
        Integer yBalon = poziceBalon.y;
        if (xBalon <= 0 || xBalon + labBalon.getWidth() >= contentPane.getWidth()) {

            casovac.stop();
            labKonecHry.setVisible(true);
        }
    }

    private void pohybujBalonem() {
        Point poziceBalon = labBalon.getLocation();
        Integer xBalon = poziceBalon.x;
        Integer yBalon = poziceBalon.y;
        Integer x2Balon = xBalon + labBalon.getWidth();
        Integer y2Balon = yBalon + labBalon.getHeight();

        if (xBalon < 0) {
            posunX = 10;
        }
        if (x2Balon > contentPane.getWidth()) {
            posunX = -10;
        }
        if (yBalon < 0) {
            posunY = 10;
        }
        if (y2Balon > contentPane.getHeight()) {
            posunY = -10;
        }

        xBalon = xBalon + posunX;
        yBalon = yBalon + posunY;

        poziceBalon.x = xBalon;
        poziceBalon.y = yBalon;

        labBalon.setLocation(poziceBalon);
    }

    private void pohybujOdrazka1() {
        Point poziceOdrazka1 = labOdrazka1.getLocation();
        Integer odrazkaX = poziceOdrazka1.x;
        Integer odrazkaY = poziceOdrazka1.y;
        Integer odrazkaY2 = odrazkaY + labOdrazka1.getHeight();
        if (klavesnice.isKeyDown(KeyEvent.VK_W)) {
            if (odrazkaY > 0) {
                odrazkaY = odrazkaY - 5;
            }
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_S)) {
            if (odrazkaY2 < contentPane.getHeight()) {
                odrazkaY = odrazkaY + 5;
            }
        }
        poziceOdrazka1.x = odrazkaX;
        poziceOdrazka1.y = odrazkaY;
        labOdrazka1.setLocation(poziceOdrazka1);
    }

    private void pohybujOdrazka2() {
        Point poziceOdrazka2 = labOdrazka2.getLocation();
        Integer odrazkaX = poziceOdrazka2.x;
        Integer odrazkaY = poziceOdrazka2.y;
        Integer odrazkaY2 = odrazkaY + labOdrazka2.getHeight();
        if (klavesnice.isKeyDown(KeyEvent.VK_UP)) {
            if (odrazkaY > 0) {
                odrazkaY = odrazkaY - 10;
            }
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_DOWN)) {
            if (odrazkaY2 < contentPane.getHeight()) {
                odrazkaY = odrazkaY + 10;
            }
        }

        poziceOdrazka2.x = odrazkaX;
        poziceOdrazka2.y = odrazkaY;

        labOdrazka2.setLocation(poziceOdrazka2);
    }
    private void odrazOdrazku1(){
        Point poziceBalonu = labBalon.getLocation();
        Integer balonX = poziceBalonu.x;
        Integer balonY = poziceBalonu.y;
        posunX = 10;
        balonX = balonX + posunX;
        labBalon.setLocation(poziceBalonu);
    }
    private void odrazOdrazku2 (){
        Point poziceBalonu = labBalon.getLocation();
        Integer balonX = poziceBalonu.x;
        Integer balonY = poziceBalonu.y;
        posunX = - 10;
        balonX = balonX + posunX;

        labBalon.setLocation(poziceBalonu);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        contentPane = new JPanel();
        labBalon = new JLabel();
        labOdrazka1 = new JLabel();
        klavesnice = new JKeyboard();
        labKonecHry = new JLabel();
        labOdrazka2 = new JLabel();
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
            labBalon.setBounds(new Rectangle(new Point(375, 200), labBalon.getPreferredSize()));

            //---- labOdrazka1 ----
            labOdrazka1.setBackground(new Color(0, 102, 204));
            labOdrazka1.setOpaque(true);
            contentPane.add(labOdrazka1);
            labOdrazka1.setBounds(15, 85, 25, 185);

            //---- klavesnice ----
            klavesnice.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    priStiskuKlavesy(e);
                }
            });
            contentPane.add(klavesnice);
            klavesnice.setBounds(new Rectangle(new Point(20, 15), klavesnice.getPreferredSize()));

            //---- labKonecHry ----
            labKonecHry.setText("Konec hry!!!\nPro novou hru stiskn\u011bte \"r\".");
            labKonecHry.setVisible(false);
            contentPane.add(labKonecHry);
            labKonecHry.setBounds(new Rectangle(new Point(290, 315), labKonecHry.getPreferredSize()));

            //---- labOdrazka2 ----
            labOdrazka2.setBackground(new Color(0, 102, 204));
            labOdrazka2.setOpaque(true);
            contentPane.add(labOdrazka2);
            labOdrazka2.setBounds(770, 200, 25, 185);

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
        casovac.setDelay(15);
        casovac.setInitialDelay(5);
        casovac.addActionListener(e -> priTiknitiCasovace(e));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
