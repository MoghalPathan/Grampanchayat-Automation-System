import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Deletrecord implements ActionListener 
{
  
  private JCheckBox c1,c2; 
  private JFrame delf;
  private JButton b1,b2,b3;
  private JLabel l1;
 
  private JTextField t1;
  
  
  Deletrecord()
  {
    delf=new JFrame("Delet Record...!!");
    b1=new JButton("Search ");
    b2=new JButton("Done");
    b3=new JButton("Cancle");
    l1=new JLabel("ID NO.");
    t1=new JTextField(15);
    c1=new JCheckBox("Birth Record");
    c2=new JCheckBox("Death Record");
    
    delf.setResizable(false);
    delf.setLayout(new FlowLayout());
    
    delf.add(l1);
    delf.add(t1);
    delf.add(c1);
    delf.add(c2);
    delf.add(b1);
    b1.addActionListener(this);
    delf.add(b2);
    b2.addActionListener(this);
    delf.add(b3);
    b3.addActionListener(this);
    delf.setSize(250,130);
    delf.setDefaultCloseOperation(delf.DISPOSE_ON_CLOSE);
    delf.setVisible(true);
  }
 public void ItemStateChanged(ItemEvent ie)
 {
   if(c1.isSelected())
   {
     int i=1;
   }
   if(c2.isSelected())
   {
     int i=2;
   }
 }
  
 public void actionPerformed(ActionEvent ae)
  {
   if(ae.getSource()==b1)
   {
   
   }
   if(ae.getSource()==b2)
   {
   int sel=JOptionPane.showConfirmDialog(null,"DONE..!!","ARE YOU DONE..!!",JOptionPane.YES_NO_OPTION);
   if(sel==JOptionPane.YES_OPTION)
   {
     delf.dispose();
   }
   }
  if(ae.getSource()==b3)
  {
    delf.dispose();
  }
  
  }
}