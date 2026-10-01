import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class DeletBirthrecord implements ActionListener 
{
  
  
  private JFrame delf;
  private JButton b1,b2,b3;
  private JLabel l1;
 
  private JTextField t1;
  Connection conn;
  ResultSet rs;
  Statement stmt;
  
  DeletBirthrecord()
  {
    delf=new JFrame("Delet Birth Record...!!");
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
   ResultSet rs=stmt.executeQuery("SELECT * FROM birth WHERE bid="+t1.getText());
   rs.next();  

   
   int sel=JOptionPane.showConfirmDialog(null,"Reg No. :- "+rs.getString("bid")+"\nBaby Name  :- "+rs.getString("bname")+"\n Mother's Name  :-"+rs.getString("mname")+"\n Birth Date  :- "
                                           +rs.getString("bday")+"/"+rs.getString("bmonth")+"/"+rs.getString("byear")+"\nBirth Place  :- "+rs.getString("bplace")+"\nCatagory  :- "
                                           +rs.getString("bcat")+"\nSub.Catagory :- "+rs.getString("bsubcat")+"\n Birth Mark  :- "+rs.getString("bmark")+"\nInfo.provider :- "+rs.getString("binfo")+"\n\nAre You Sure You Want To Delet","Are you Sure",JOptionPane.YES_NO_OPTION);
     
   if(sel==JOptionPane.YES_OPTION)
   {
     try
     {
   
  conn=DatabaseConnection.getConnection();
    stmt=conn.createStatement();
   boolean r=stmt.execute("DELETE * FROM birth WHERE bid="+t1.getText());
   if(r==false)
   {
     JOptionPane.showMessageDialog(null,"Birth Record Deleted");
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