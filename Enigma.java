
/*****************
 * Cartwright II,*
 * Steve         *    
 * Enigma	     *  
 * 6/9/2015      *
 ****************/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.lang.Character;

public class Enigma extends JFrame
{  private ActionListener listener = new KeyEvent();
   private JTextField input = new JTextField("input", 5);
   private JTextField offset_ = new JTextField("offset", 1);
   private JButton button1 = new JButton("Encrypt");
   private JButton button2 = new JButton("Decrypt");
   private Character cha = null;
   private static int offset = 0;
   private final int twentysix = 26;


    public Enigma()
    {  
      // Set the layout of the frame with GridLayout 
      setLayout(new BorderLayout());
      
      // Create two new panels for each of the three buttons
      // using FlowLayout
      JPanel p1 = new JPanel(new GridLayout(2,1,0,0));
      JPanel p2 = new JPanel(new GridLayout(1,1,0,0));
      
     
       // Add three textfields and labels to the frame
      //p1.add(new JLabel("Encrypt"));  
      //p1.add(new JLabel("Decrypt"));
            add(p1, BorderLayout.WEST);
            
      p2.add(offset_);
      p2.add(input);
      
      p2.add(button1);
      p2.add(button2);
      button1.addActionListener(listener);
      
      button2.addActionListener(listener);
            add(p2);
     
     
      
    }  

	String mutate (char[] buffer, char f) {
		StringBuilder str = new StringBuilder();
		int flag = 0;
		char c = ' ';
		
		if(f == 'e') flag = 1;
		else if (f == 'd') flag = -1;
		else {}
		
		for(int i = 0; i < buffer.length; i++){
		
			c = (char)((int) buffer[i] + offset*flag);
			str.append(c);
		}
		
	
		return str.toString();
	
	}
	

   class KeyEvent implements ActionListener
   {  // Pre condition - check which textfield used event
      // Post condition - use corresponding commands in if / else 
      public void actionPerformed(ActionEvent e)
      {  
      	 offset = Integer.parseInt(offset_.getText());
      	 char[] s = input.getText().toCharArray();
      	 
         	
         if(e.getSource() == button1)
         {  
            
            input.setText(mutate(s, 'e'));
                    
         } 
         else if(e.getSource() == button2) {
         	
         	         
         	input.setText(mutate(s, 'd'));
         	
         }
         else {}
      }
   }
    
  
 }
