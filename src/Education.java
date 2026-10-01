import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Education   
{
  
  
  private JFrame delf;
  private JLabel l1,l2;
 
 
  
  Education()
  {
    delf=new JFrame("Education");

    l1=new JLabel();
    l1.setIcon(new ImageIcon("Images/Edu.jpg"));
   
    
    delf.setResizable(false);
    delf.setLayout(new FlowLayout());
    
    delf.add(l1);
   
     delf.setSize(1200,600);
    delf.setDefaultCloseOperation(delf.DISPOSE_ON_CLOSE);
    delf.setVisible(true);
  }
  
  public static void main(String args[])
   {
    new Education();
   }  
   
  }
