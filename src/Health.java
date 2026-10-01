import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Health   
{
  
  
  private JFrame delf;
  private JLabel l1,l2;
 
 
  
  Health()
  {
    delf=new JFrame("Health");

    l1=new JLabel();
    l1.setIcon(new ImageIcon("Images/hel.jpg"));
   
    
    delf.setResizable(false);
    delf.setLayout(new FlowLayout());
    
    delf.add(l1);
   
     delf.setSize(800,600);
    delf.setDefaultCloseOperation(delf.DISPOSE_ON_CLOSE);
    delf.setVisible(true);
  }
 

  
   
  }
