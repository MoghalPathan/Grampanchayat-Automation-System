import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class DeletMarriagerecord implements ActionListener 
{
  
  
  private JFrame delf;
  private JButton b1,b2,b3;
  private JLabel l1;
 
  private JTextField t1;
  
  Connection conn;
  ResultSet rs;
  Statement stmt;
  DeletMarriagerecord()
  {
    delf=new JFrame("Delet Marriage Record..!!");
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
   ResultSet rs=stmt.executeQuery("SELECT * FROM marriage WHERE mid="+t1.getText());
   rs.next();  

   
   int sel=JOptionPane.showConfirmDialog(null,"Regi.Id :- "+rs.getString("mid")+"\nMale Name :- "+rs.getString("malename")+"\nDate Of Birth :-  "+rs.getString("mbdate")+
                                         "/"+rs.getString("mbmonth")+"/"+rs.getString("mbyear")+"\nFemale Name:-"+rs.getString("femalename")+"\nDate Of Birth :-"+rs.getString("fbdate")
                                           +"/"+rs.getString("fbmonth")+"/"+rs.getString("fbyear")+"\nDate Of Marriage:- "+rs.getString("mdate")+"/"+rs.getString("mmonth")+
                                         "/"+rs.getString("myear")+"\n Address:- "+rs.getString("addr")+"\nEvidence No.1"+rs.getString("ename1")+"\nEvidence No.2"+rs.getString("ename2")+"\n\n\n Are Sure You Want To Delet","Are you Sure",JOptionPane.YES_NO_OPTION);
     
   if(sel==JOptionPane.YES_OPTION)
   {
     try
     {
   
  conn=DatabaseConnection.getConnection();
   stmt=conn.createStatement();
   boolean r=stmt.execute("DELETE * FROM marriage WHERE mid="+t1.getText());
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