package gui;

import mod.Mod;

import javax.swing.*;
import java.awt.*;

public class GUI {

    private Mod[] mods = {
            new Mod("Intensify", "Rare", "Madurai", 0, 5, 6, new String[]{"Ability_Strength"}, new Double[]{1.05}, new Double[]{0.05}, 1)
    };

    public void createGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Warframe Modding Project");
        frame.setSize(1920, 1080);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);


        frame.setLayout(new BorderLayout());

        JPanel panelTop = new JPanel();
        panelTop.setBackground(Color.BLUE);
        panelTop.setPreferredSize(new Dimension(100, 100));

        JPanel panelRight = new JPanel();
        panelRight.setBackground(Color.RED);
        panelRight.setPreferredSize(new Dimension(100, 100));

        JPanel panelBottom = new JPanel();
        panelBottom.setBackground(Color.GREEN);
        panelBottom.setPreferredSize(new Dimension(100, 250));

        JPanel panelLeft = new JPanel();
        panelLeft.setBackground(Color.YELLOW);
        panelLeft.setPreferredSize(new Dimension(100, 100));

        JPanel panelCenter = new JPanel();
        panelCenter.setPreferredSize(new Dimension(100, 100));
        panelCenter.setLayout(new GridLayout(2, 4));

        JComboBox modBox1 = new JComboBox(mods);
        JComboBox modBox2 = new JComboBox(mods);
        JComboBox modBox3 = new JComboBox(mods);
        JComboBox modBox4 = new JComboBox(mods);
        JComboBox modBox5 = new JComboBox(mods);
        JComboBox modBox6 = new JComboBox(mods);
        JComboBox modBox7 = new JComboBox(mods);
        JComboBox modBox8 = new JComboBox(mods);


        JPanel mod1 = new JPanel();
        mod1.add(modBox1, BorderLayout.SOUTH);
        panelCenter.add(mod1);

        JPanel mod2 = new JPanel();
        mod2.add(modBox2, BorderLayout.SOUTH);
        panelCenter.add(mod2);

        JPanel mod3 = new JPanel();
        mod3.add(modBox3, BorderLayout.SOUTH);
        panelCenter.add(mod3);

        JPanel mod4 = new JPanel();
        mod4.add(modBox4, BorderLayout.SOUTH);
        panelCenter.add(mod4);

        JPanel mod5 = new JPanel();
        mod5.add(modBox5, BorderLayout.SOUTH);
        panelCenter.add(mod5);

        JPanel mod6 = new JPanel();
        mod6.add(modBox6, BorderLayout.SOUTH);
        panelCenter.add(mod6);

        JPanel mod7 = new JPanel();
        mod7.add(modBox7, BorderLayout.SOUTH);
        panelCenter.add(mod7);

        JPanel mod8 = new JPanel();
        mod8.add(modBox8, BorderLayout.SOUTH);
        panelCenter.add(mod8);

        frame.add(panelTop, BorderLayout.NORTH);
        frame.add(panelRight, BorderLayout.EAST);
        frame.add(panelBottom, BorderLayout.SOUTH);
        frame.add(panelLeft, BorderLayout.WEST);
        frame.add(panelCenter, BorderLayout.CENTER);


        frame.setVisible(true);
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.createGUI();
    }

}
