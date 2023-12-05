package Visiulizer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class LoadingPage {
	
	JLabel logo;
	ImageIcon image;
	JFrame loadframe;
	JProgressBar ProgressBar;
	
	LoadingPage(){
		
		LoadingMenuImage();
		LoadingMenu();
		Bar();
	}	
		
	public void Bar() {	
		ProgressBar = new JProgressBar();
		ProgressBar.setBounds(25,390,750 , 15);
		ProgressBar.setBackground(Color.blue);
		ProgressBar.setForeground(Color.black);
		loadframe.add(logo);
		logo.add(ProgressBar);
		loadframe.setVisible(true);
		try {
			for(int i=0; i<100; i++) {
				Thread.sleep(35);
				ProgressBar.setValue(i);
		}
				
			} catch (Exception e){
							} 
		}
	
	     public void LoadingMenu() {
	    	 loadframe = new JFrame();
		    loadframe.getContentPane().setLayout(null);
			loadframe.setBounds(350,150,790,450);
			loadframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			loadframe.setVisible(true);
			loadframe.setResizable(false);
			  }
	     
	     
	     public void LoadingMenuImage() {
	    	 image = new ImageIcon("C:\\Users\\Hafeez\\Desktop\\P\\FinalProject\\src\\Visiulizer\\Loading.jpeg");
	    	 logo = new JLabel(image);
	    	 logo.setOpaque(true);
	    	 logo.setBounds(0, 0, 800, 410);  
	 	}     
 
	public static void main (String args[]) {
         
	}
}
