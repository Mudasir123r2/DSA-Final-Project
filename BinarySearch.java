package Visiulizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Scanner;
 class SearchValueInputFrame extends JFrame {
     JTextField searchField;
     public static int searchvalue;
     //BinarySearch bs = new BinarySearch();
    
    public int getvalue() {
    	return this.searchvalue;
    }
    public void input() {
    	setTitle("Search Value Input");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create components
        JLabel label = new JLabel("Enter Search Value:");
        searchField = new JTextField(10);
        JButton searchButton = new JButton("Search");

        // Set layout
        setLayout(new FlowLayout());

        // Add components to the frame
        add(label);
        add(searchField);
        add(searchButton);
        // Add ActionListener to the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve the search value from the text field
                String inputText = searchField.getText();

                try {
                    // Convert the input text to an integer
                     searchvalue = Integer.parseInt(inputText);
                    BinarySearch bs = new BinarySearch();
					bs.setVisible(true);//
                
              	   bs.visualizeBinarySearch();//
                    
                    
                    // You can add your search logic here

                } catch (NumberFormatException ex) {
                    // Handle the case where the input is not a valid integer
                    JOptionPane.showMessageDialog(SearchValueInputFrame.this, "Please enter a valid integer.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }
 }
public class BinarySearch extends JFrame {
	SearchValueInputFrame in = new SearchValueInputFrame();
     int space = 10;
     int multi = 10;
     int size=InputFrame.ArraySize;
     int speed=InputFrame.SortingSpeed;
     
     int Svalue =in.searchvalue  ; // Value to search for
     int[] array;
     int left = 0;
     int right;
     int mid;
     boolean found = false;

    public BinarySearch() {
        setTitle("Binary Search Visualizer");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        generateSortedArray();
        right = array.length - 1;
        getContentPane().setBackground(Color.gray);
    }

    private void generateSortedArray() {
        int arraySize = size;
        array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = i; // Generate random values between 1 and 50
        }
        Arrays.sort(array);
    }

    void visualizeBinarySearch() {
        Timer timer = new Timer(speed, e -> {
            if (left <= right) {
                mid = left + (right - left) / 2;

                
                repaint();

                if (array[mid] == Svalue) {
                    found = true;
                    if (found) {
                        JOptionPane.showMessageDialog(null, "Found " + Svalue + " at index " + mid);
                    }
                    ((Timer) e.getSource()).stop();    
                } else if (array[mid] < Svalue) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }else {
            	if(found==false) {
            		 JOptionPane.showMessageDialog(null, "Value does not exist in Array");
                }
            	((Timer) e.getSource()).stop();
            }
        });
        timer.start();
        
        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int x = space;
        int y = getHeight() - 50;

        for (int i = 0; i < array.length; i++) {
            if (i == mid) {
                g.setColor(Color.GREEN); // Highlight the mid element in green
            } else if (i == left || i == right) {
                g.setColor(Color.RED); // Highlight the elements being compared in red
            } else {
                g.setColor(Color.cyan);
            }
            int barWidth = (getWidth() - 2 * space) / array.length - space;
            drawBar(g, x, y - array[i] * multi, array[i], barWidth);
            x += barWidth + space;
        }

        
        g.setColor(Color.BLACK);
        g.drawString("Mid: " + array[mid], 50, 20);
    }

    private void drawBar(Graphics g, int x, int y, int value, int width) {
        g.fillRect(x, y, width, value * multi);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, value * multi);

        
        g.setColor(Color.BLACK);
        Font font = new Font("Arial", Font.BOLD, 12);
        g.setFont(font);
        String valueString = String.valueOf(value);
        FontMetrics fontMetrics = g.getFontMetrics();
        int stringWidth = fontMetrics.stringWidth(valueString);
        int stringHeight = fontMetrics.getHeight();
        g.drawString(valueString, x + (width - stringWidth) / 2, y - space - stringHeight / 2);
    }

    public static void main(String[] args) {
    	
}
}
