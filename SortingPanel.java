package Visiulizer;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;

public class SortingPanel extends JPanel implements ActionListener {
    

    Random random;
    int[] array;
    BubbleSort bubbleSort;
    InsertionSort insertionSort;
    SelectionSort selectionSort;
    QuickSort quickSort;
    MergeSort mergeSort;
    
    JButton start;
    JButton bubble;
    JButton insertion;
    JButton selection;
    JButton quick;
    JButton reset;
    JButton binary;
    JButton Merge;
    
    int Size;
    int speed;
    
    boolean Bubble,Insertion  ,Selection, Quick,merge=false;

    boolean Run;

    

    public SortingPanel() {
        Size=InputFrame.ArraySize;   
        speed=InputFrame.SortingSpeed;
        random = new Random();
        array = new int[Size];
        this.setArray();

        bubbleSort = new BubbleSort(array);
        insertionSort = new InsertionSort(array);
        selectionSort = new SelectionSort(array);
        quickSort = new QuickSort(array);
        mergeSort = new MergeSort(array);
        
        start = new JButton("Start");
        binary = new JButton("Binary");
        bubble = new JButton("Bubble");
        insertion = new JButton("Insertion");
        selection = new JButton("Selection");
        quick = new JButton("Quick");
        Merge = new JButton("Merge");
        reset = new JButton("Reset");

        start.setModel(new ButtonModel());
        start.setBackground(Color.WHITE);
        start.setFocusPainted(false);
        start.setBorderPainted(false);
        start.addActionListener(this); 

        bubble.setModel(new ButtonModel());
        bubble.setBackground(Color.WHITE);
        bubble.setFocusPainted(false);
        bubble.setBorderPainted(false);
        bubble.addActionListener(this);
        
        binary.setModel(new ButtonModel());
        binary.setBackground(Color.WHITE);
        binary.setFocusPainted(false);
        binary.setBorderPainted(false);
        binary.addActionListener(this);

        insertion.setModel(new ButtonModel());
        insertion.setBackground(Color.WHITE);
        insertion.setFocusPainted(false);
        insertion.setBorderPainted(false);
        insertion.addActionListener( this); 


        selection.setModel(new ButtonModel());
        selection.setBackground(Color.WHITE);
        selection.setFocusPainted(false);
        selection.setBorderPainted(false);
        selection.addActionListener(this); 


        quick.setModel(new ButtonModel());
        quick.setBackground(Color.WHITE);
        quick.setFocusPainted(false);
        quick.setBorderPainted(false);
        quick.addActionListener(this);
        
        Merge.setModel(new ButtonModel());
        Merge.setBackground(Color.WHITE);
        Merge.setFocusPainted(false);
        Merge.setBorderPainted(false);
        Merge.addActionListener(this);
        
        reset.setModel(new ButtonModel());
        reset.setBackground(Color.WHITE);
        reset.setFocusPainted(false);
        reset.setBorderPainted(false);
        reset.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 

                reset.setBackground(Color.lightGray);
                start.setBackground(Color.WHITE);

                setArray();

        
                bubbleSort.setCompareIndex(Integer.MAX_VALUE);
                bubbleSort.setArrayIndex(0);
                bubbleSort.setArray(array);

                insertionSort.setCompareIndex(Integer.MAX_VALUE);
                insertionSort.setArrayIndex(Integer.MAX_VALUE);
                insertionSort.setArray(array);
                insertionSort.setStartOfIteration(false);

                quickSort.setSP(-1);
                quickSort.push(0);
                quickSort.push(array.length-1);
                quickSort.setArrayIndex(Integer.MAX_VALUE);
                quickSort.setCompareIndex(Integer.MAX_VALUE);
                quickSort.setPartition(-1);
                quickSort.setIsPartioning(false);

                Run = false;
                
                Timer timer  = new Timer(speed, new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        reset.setBackground(Color.WHITE);
                        ((Timer)e.getSource()).stop();
                    }
                });

                timer.start();
                repaint();
            } 
        });

        this.add(start);
        this.add(bubble);
        this.add(insertion);
        this.add(selection);
        this.add(binary);
        this.add(quick);
        this.add(Merge);
        this.add(reset);
    }

    public void setButtonBackground() {
        bubble.setBackground(Color.WHITE);
        insertion.setBackground(Color.WHITE);
        selection.setBackground(Color.WHITE);
        quick.setBackground(Color.WHITE);
        binary.setBackground(Color.WHITE);
        Merge.setBackground(Color.WHITE);
    }

    public int[] getArray() {
        return this.array;
    }

    public void setArray() {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = random.nextInt(510) + 40;
        }
    }

    public boolean isSorted() {

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] >= array[i + 1]) {
                return false; 
            }
        }
    
        return true;
    }
    
    public void actionPerformed(ActionEvent e) {
    	
    	if(e.getSource()==start) {
    		try {
    		start.setBackground(Color.lightGray);
            if (Run == false)
                Run = true;
					animate();
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
    	}
    	
    	if(e.getSource()==bubble) {
    		 if (Run == false) {
                 Insertion = false;
                 Selection = false;
                 Quick = false;
                 Bubble = true;
                 setButtonBackground();
                 bubble.setBackground(Color.lightGray);
             }   
    	}
    	
        if(e.getSource()==selection) {
        	if (Run == false) {
                Bubble = false;
                Insertion = false;
                Quick = false;
                Selection = true;
                setButtonBackground();
                selection.setBackground(Color.lightGray);
            } 
    	} 

        if(e.getSource()==insertion) {
        	 if (Run == false) {
                 Bubble = false;
                 Selection = false;
                 Quick = false;
                 Insertion = true;
                 setButtonBackground();
                 insertion.setBackground(Color.lightGray);
             } 
        }
        if(e.getSource()==quick) {
        	if (Run == false) {
                Bubble = false;
                Insertion = false;
                Selection = false;
                Quick = true;
                setButtonBackground();
                quick.setBackground(Color.lightGray);
            }   
        }

       if(e.getSource()==binary) {
    	   
    	   JFrame jf = new JFrame();
    	   jf=Frame.getFrame();
    	   jf.dispose();
    	   SearchValueInputFrame in = new SearchValueInputFrame();
    	   in.setVisible(true);
    	   in.input();
    	   
       }
       
       if(e.getSource()==Merge) {
    	   if (Run == false) {
               Bubble = false;
               Insertion = false;
               Selection = false;
               Quick = false;
               merge=true;
               setButtonBackground();
               Merge.setBackground(Color.lightGray);
           }   
       }
    }
    

    public void animate() throws Exception{

        if (Bubble) {

            bubbleSort.setCompareIndex(0);

            Timer bubbleTimer  = new Timer(speed, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (isSorted() || Run == false) {
                        bubbleSort.setCompareIndex(Integer.MAX_VALUE);
                        Run = false;
                        start.setBackground(Color.WHITE);
                        ((Timer)e.getSource()).stop();
                        JOptionPane.showMessageDialog(null, "The Worst Time Complexity of BubbleSort is O(N^2)");
                    } 
                    else {
                        if (Run == true)
                            array = bubbleSort.sortOnlyOneItem();
                    }
                    
                    repaint();
                    
                }
            });
            bubbleTimer.start();
        }
        
        
        if (Insertion) {

            insertionSort.setArrayIndex(1);

            Timer insertionTimer  = new Timer(speed, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (isSorted() || Run == false) {
                        insertionSort.setCompareIndex(Integer.MAX_VALUE);
                        insertionSort.setArrayIndex(Integer.MAX_VALUE);
                        insertionSort.setStartOfIteration(false);
                        Run = false;
                        start.setBackground(Color.WHITE);
                        ((Timer)e.getSource()).stop();
                        JOptionPane.showMessageDialog(null, "The Worst Time Complexity of InsertionSort is O(N^2)");
                    } 
                    else {
                        if (Run == true)
                            array = insertionSort.sortOnlyOneItem();
                    }

                    repaint();
                }
            });

            insertionTimer.start();
        }

        if (Selection) {

            selectionSort.setArrayIndex(0);
            selectionSort.setCompareIndex(1);
            selectionSort.setMinIdx(0);

            Timer selectionTimer  = new Timer(speed, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (isSorted() || Run == false) {
                        selectionSort.setCompareIndex(Integer.MAX_VALUE);
                        selectionSort.setArrayIndex(Integer.MAX_VALUE);
                        selectionSort.setMinIdx(Integer.MAX_VALUE);
                        Run = false;
                        start.setBackground(Color.WHITE);
                        ((Timer)e.getSource()).stop();
                        JOptionPane.showMessageDialog(null, "The Worst Time Complexity of SelectionSort is O(N^2)");
                    } 
                    else {
                        if (Run == true)
                            array = selectionSort.sortOnlyOneItem();
                    }

                    repaint();
                }
            });

            selectionTimer.start();
        }

        if (Quick) {

            Timer quickTimer  = new Timer(speed, new ActionListener(){ 
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (isSorted() || Run == false) {
                        quickSort.setSP(-1);
                        quickSort.push(0);
                        quickSort.push(array.length-1);
                        quickSort.setArrayIndex(Integer.MAX_VALUE);
                        quickSort.setCompareIndex(Integer.MAX_VALUE);
                        quickSort.setPartition(-1);
                        quickSort.setIsPartioning(false);
                        Run = false;
                        start.setBackground(Color.WHITE);
                        
                        JOptionPane.showMessageDialog(null, "The Worst Time Complexity of QuickSort is O(N^2)");
                        ((Timer)e.getSource()).stop();
                    } 

                    else {
                        if (Run == true)
                            array = quickSort.sortOnlyOneItem();
                    }

                    repaint();
                }
            });

            quickTimer.start();
        }
        if(merge) {
        	Timer mergeSortTimer = new Timer(speed, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (isSorted() || Run == false) {
                        Run = false;
                        start.setBackground(Color.WHITE);
                        mergeSort.resetMergingIndex(); // Reset merging index after sorting
                        ((Timer) e.getSource()).stop();
                        JOptionPane.showMessageDialog(null, "The Worst Time Complexity of MergeSort is O(N Log n)");
                    } else {
                        if (Run == true) {
                            MergingIndex mergingIndex = mergeSort.sortOneStep();
                            mergeSort.setMergingIndex(mergingIndex);
                            
                        }
                    }
                    repaint();
                }
            });

            mergeSortTimer.start();
        }
        
    }
    

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        this.setBackground(Color.gray);
        int arrayLength = array.length;
        int barWidth = (getWidth() - 20) / arrayLength; // Adjusted to add space between bars
        int valueSpacing = 5;
        for (int i = 0; i < array.length; i++) {
        	int barHeight = array[i];
        	int x = 10 + i * (barWidth + 2);
            int y = getHeight() - barHeight;
            g.setColor(Color.BLACK);
            g.drawRect(x, y, barWidth, barHeight); 
            g.setColor(Color.WHITE);
            
            
            
            if (Bubble) {
                if (i == bubbleSort.getCompareIndex() || i == (bubbleSort.getCompareIndex() + 1)) {
                    g.setColor(Color.MAGENTA);
                }

            }
            if(merge) {
            	if (mergeSort.getMergingIndex() != null) {
                    System.out.println("E2");
                    int left = mergeSort.getMergingIndex().getLeft();
                    int right = mergeSort.getMergingIndex().getRight();
                    int mid=left+right/2;
                    if (i == mid) {
                        g.setColor(Color.RED); // highlight mid index
                    }
                    if (i == left || i == right) {
                        g.setColor(Color.BLUE); // highlight left and right indices
                    }
                    if (i >= left && i <= right) {
                        g.setColor(Color.GREEN); // highlight merging subarray
                    }
                }
            }

            if (Insertion) {

                if (i == insertionSort.getCompareIndex() || i == (insertionSort.getCompareIndex() + 1)) {
                    g.setColor(Color.MAGENTA);
                }

                if (i == insertionSort.getArrayIndex()) {
                    g.setColor(Color.GREEN);
                }
            }

            if (Selection) {

                if (i == selectionSort.getCompareIndex() ) {
                    g.setColor(Color.MAGENTA);
                }
                if( i == selectionSort.getMinIdx()) {
                	g.setColor(Color.RED);
                }

                if (i == selectionSort.getArrayIndex()) {
                    g.setColor(Color.GREEN);
                }
            }

            if (Quick) {
                
                if (i == quickSort.getArrayIndex()) {
                    g.setColor(Color.MAGENTA);
                }

                if (i == quickSort.getCompareIndex()) {
                    g.setColor(Color.BLUE);
                }

                if (i == quickSort.getPartition())
                    g.setColor(Color.GREEN);
            }
        
            if (g.getColor() != Color.MAGENTA && g.getColor() != Color.GREEN && g.getColor() != Color.BLUE && g.getColor() != Color.RED)
                g.setColor(Color.CYAN);

                g.fillRect(x, y, barWidth, barHeight);
                g.setColor(Color.magenta);
                Font font = new Font("Arial", Font.BOLD, 12); // Adjust font size and style as needed
                g.setFont(font);
                String valueString = String.valueOf(array[i]);
                FontMetrics fontMetrics = g.getFontMetrics();
                int stringWidth = fontMetrics.stringWidth(valueString);
                int valueX = x + (barWidth - stringWidth) / 2;
                int valueY = y - valueSpacing; // Adjusted position to draw on the top of the bar
                g.drawString(valueString, valueX, valueY);
                
              
        }
    }
}
