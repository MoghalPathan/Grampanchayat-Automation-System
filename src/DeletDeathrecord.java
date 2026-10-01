import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class DeletDeathrecord implements ActionListener 
{
  
  
  private JFrame delf;
  private JButton b1,b2,b3;
  private JLabel l1;
 
  private JTextField t1;
  Connection conn;
  ResultSet rs;
  Statement stmt;
  
  DeletDeathrecord()
  {
    delf=new JFrame("Delet Death Record..!!");
    b1=new JButton("Search ");
    delf.setResizable(false);
    b3=new JButton("Cancle");
    l1=new JLabel(" User ID ");
    t1=new JTextField(15);
   
    
    
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
     try
     {
     
  Connection conn=DatabaseConnection.getConnection();
   Statement stmt=conn.createStatement();
   ResultSet rs=stmt.executeQuery("SELECT * FROM death WHERE did="+t1.getText());
   rs.next();  

   
   int sel=JOptionPane.showConfirmDialog(null,"Regi. No :- "+rs.getString("did")+"\nPerson Name :- "+rs.getString("dname")+"\nDate Of Death :-"+rs.getString("dday")+"/"+rs.getString("dmonth")+"/"+rs.getString("dyear")+"\nAge At Death:- "+rs.getString("dage")+"\nPlace Of Death:-"+rs.getString("dplace")+"\nCatagory:-"+rs.getString("dcat")+"\nDecise:-"+rs.getString("ddecise")+"\nInfo.Provider:-"+rs.getString("dinfo")+"\n\nAre You Sure You Want To Delet","Are you Sure ",JOptionPane.YES_NO_OPTION);
     
   if(sel==JOptionPane.YES_OPTION)
   {
     try
     {
   
  conn=DatabaseConnection.getConnection();
    stmt=conn.createStatement();
   boolean r=stmt.execute("DELETE * FROM death WHERE did="+t1.getText());
   if(r==false)
   {
     JOptionPane.showMessageDialog(null,"User  Deleted");
   }conn.close();
    }
  catch(Exception e)
  {
  JOptionPane.showMessageDialog(null,""+e);
  }
   }conn.close();
     }
   
     catch(Exception e)
  {
  JOptionPane.showMessageDialog(null,"Record Not Present");
  }
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