package Visiulizer;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {


     SortingPanel panel = new SortingPanel();
    static JFrame f = new JFrame();
    public Frame() {
        f.setTitle("Sorting Visualizer");
        f.getContentPane().setPreferredSize(new Dimension(1300, 600));
        f.getContentPane().add(panel);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    } 
    public static JFrame getFrame() {
    	return f;
    }

    public SortingPanel getPanel() {
        return this.panel;
    }
}