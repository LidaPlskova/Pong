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
    JLabel labKonecHry;
    Random random1;
    JTimer casovac;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    Integer posunX;
    Integer posunY;
    Integer AX;
    Integer AY;
    Integer BX;
    Integer BY;
    Integer CX;
    Integer CY;
    Integer DX;
    Integer DY;
    Integer xBalon;
    Integer yBalon;
    Integer x2Balon;
    Integer y2Balon;

    private void konecHry() {
        casovac.stop();
        labKonecHry.setVisible(true);

    }

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
        Integer balonSirka;
        balonSirka = labBalon.getWidth();
        Integer balonVyska;
        balonVyska = labBalon.getHeight();
        poziceBalon = labBalon.getLocation();
        xBalon = poziceBalon.x;
        yBalon = poziceBalon.y;
        x2Balon = xBalon + balonSirka;
        y2Balon = yBalon + balonVyska;

        Point poziceOdrazka1;
        poziceOdrazka1 = labOdrazka1.getLocation();
        AX = poziceOdrazka1.x;
        AY = poziceOdrazka1.y;
        BX = AX + labOdrazka1.getWidth();
        BY = BX + labOdrazka1.getHeight();
        if (klavesnice.isKeyDown(KeyEvent.VK_W)){
            if (AY>0){
                AY = AY-5;
            }
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_S)){
            if (BY < contentPane.getHeight()){
                AY = AY +5;
            }
        }
        if (BX >= this.xBalon && BY >= this.yBalon && BY <= y2Balon) {
            posunX = 5;
            posunY = -5;
        }
        if (BX >= this.xBalon && AY <= y2Balon && AY >= this.yBalon) {
            posunX = 5;
            posunY = 5;
        }

        poziceOdrazka1.x = AX;
        poziceOdrazka1.y = AY;
        labOdrazka1.setLocation(poziceOdrazka1);

        Point poziceOdrazka2;
        poziceOdrazka2 = labOdrazka2.getLocation();
        CX = poziceOdrazka2.x;
        CY = poziceOdrazka2.y;
        DX = CX + labOdrazka2.getWidth();
        DY = CY + labOdrazka2.getHeight();
        if (klavesnice.isKeyDown(KeyEvent.VK_UP)){
            if (CY >0){
                CY = CY-5;
            }
        }
        if (klavesnice.isKeyDown(KeyEvent.VK_DOWN)) {
            if (DY < contentPane.getHeight()){
                CY = CY +5;
            }
        }

        if (CX <= x2Balon && CY <= y2Balon && CY >= yBalon) {
            posunX = -5;
            posunY = 5;
        }
        if (CX <= x2Balon && DY >= yBalon && DY <= y2Balon) {
            posunX = -5;
            posunY = -5;
        }

        poziceOdrazka2.x = CX;
        poziceOdrazka2.y = CY;

        labOdrazka2.setLocation(poziceOdrazka2);

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

        if (xBalon <= 0 || xBalon + balonSirka >= contentPane.getWidth()) {
            konecHry();
        }

    }

    private void priStiskuKlavesy(KeyEvent e) {
        if (klavesnice.isKeyDown(KeyEvent.VK_R)) {
            labBalon.setLocation(375, 200);
            labKonecHry.setVisible(false);
            casovac.start();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        contentPane = new JPanel();
        labBalon = new JLabel();
        labOdrazka1 = new JLabel();
        labOdrazka2 = new JLabel();
        klavesnice = new JKeyboard();
        labKonecHry = new JLabel();
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
            labOdrazka1.setBounds(0, 85, 15, 185);

            //---- labOdrazka2 ----
            labOdrazka2.setBackground(new Color(0, 102, 204));
            labOdrazka2.setOpaque(true);
            contentPane.add(labOdrazka2);
            labOdrazka2.setBounds(790, 65, 15, 185);

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
