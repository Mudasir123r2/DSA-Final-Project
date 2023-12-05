package Visiulizer;

import javax.swing.*;

import Visiulizer.ButtonModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputFrame extends JFrame implements ActionListener {
    static int ArraySize;
    static int SortingSpeed;
    JButton startSortingButton;
    JComboBox arraySizeTextField;
    JComboBox sortingSpeedTextField;
    String[] size ={"10","20","30","40","50","60","70"};
    String[] speed = {"100","500","1000","2000","2500"};

    public InputFrame() {
        // Set the JFrame properties
        setTitle("Sorting Input");
        setSize(460, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(135, 206, 250)); // Sky Blue

        // Create and add components to the JFrame
        initComponents();

        // Make the JFrame visible
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));
        setVisible(true);
    }

    private void initComponents() {
        JLabel arraySizeLabel = new JLabel("Size of Array");
        arraySizeLabel.setForeground(Color.BLACK);
        arraySizeTextField = new JComboBox(size);

        JLabel sortingSpeedLabel = new JLabel("Sorting Speed:");
        sortingSpeedLabel.setForeground(Color.BLACK);
        sortingSpeedTextField = new JComboBox(speed);

        startSortingButton = new JButton("Start Sorting");
        
        startSortingButton.addActionListener(this);

        add(arraySizeLabel);
        add(arraySizeTextField);
        add(sortingSpeedLabel);
        add(sortingSpeedTextField);
        add(new JLabel()); // Placeholder for an empty cell
        add(startSortingButton);
    }

    

    public static void main(String[] args) {
        
                
            
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub 
		if(e.getSource()==startSortingButton) {
			String arraySizeStr = arraySizeTextField.getSelectedItem().toString();
	        String sortingSpeedStr = sortingSpeedTextField.getSelectedItem().toString();
	         ArraySize = Integer.parseInt(arraySizeStr);
              SortingSpeed = Integer.parseInt(sortingSpeedStr);
              
              this.dispose();
              Frame frame = new Frame(); 

		}
	}
}