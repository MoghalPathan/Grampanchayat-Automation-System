import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class EditDeathrecord implements ActionListener 
{
  
  private JFrame editf;
  private JButton b1,b2,b3;
  private JLabel l1;
 
  private JTextField t1;
  
  
  EditDeathrecord()
  {
    editf=new JFrame("Edit Death Record...!!");
    b1=new JButton("Search ");
   
    b3=new JButton("Cancle");
    l1=new JLabel("ID NO.");
    t1=new JTextField(15);
    
    editf.setResizable(false);
    
    editf.setLayout(new FlowLayout());
    
    editf.add(l1);
    editf.add(t1);
    editf.add(b1);
    b1.addActionListener(this);
    
    editf.add(b3);
    b3.addActionListener(this);
    editf.setSize(250,130);
    editf.setDefaultCloseOperation(editf.DISPOSE_ON_CLOSE);
    editf.setVisible(true);
  }

  
 public void actionPerformed(ActionEvent ae)
  {
   if(ae.getSource()==b1)
   {int id;
     id=Integer.parseInt(t1.getText());
   new UpdateDeathRecord(id);
   editf.dispose();
   }
   
  if(ae.getSource()==b3)
  {
    int sel=JOptionPane.showConfirmDialog(null,"DONE..!!","ARE YOU DONE..!!",JOptionPane.YES_NO_OPTION);
   if(sel==JOptionPane.YES_OPTION)
   {
     editf.dispose();
   }
  }
  
  }
}