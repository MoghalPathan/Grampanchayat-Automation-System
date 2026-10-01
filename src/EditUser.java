import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class EditUser implements ActionListener 
{
  
  
  private JFrame delf;
  private JButton b1,b2,b3;
  private JLabel l1;
 
  private JTextField t1;
 
  
  EditUser()
  {
    delf=new JFrame("Edit User...!!");
    b1=new JButton("Search ");
    
    b3=new JButton("Cancle");
    l1=new JLabel(" User ID ");
    t1=new JTextField(15);
   
    
    delf.setResizable(false);
    delf.setLayout(new FlowLayout());
    
    delf.add(l1);
    delf.add(t1);
    delf.add(b1);
    b1.addActionListener(this);
   
    delf.add(b3);
    b3.addActionListener(this);
    delf.setSize(250,130);
    delf.setDefaultCloseOperation(delf.DISPOSE_ON_CLOSE);
    delf.setVisible(true);
  }
 
  
 public void actionPerformed(ActionEvent ae)
  {
   if(ae.getSource()==b1)
   {
     int id=Integer.parseInt(t1.getText());
     new UpdateUser(id);
     delf.dispose();
   
   }
  
   
  if(ae.getSource()==b3)
  {
   int sel=JOptionPane.showConfirmDialog(null,"DONE..!!","ARE YOU DONE..!!",JOptionPane.YES_NO_OPTION);
   if(sel==JOptionPane.YES_OPTION)
   {
     delf.dispose();
   }
   
  }
  
  }
}