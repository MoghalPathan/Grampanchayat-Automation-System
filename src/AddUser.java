import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

class AddUser implements ActionListener
{
  JFrame newuserf;
  JButton addu,close;
  JLabel l1,l2,l3;
  JTextField usert,userid;
  JPasswordField passt;
  Connection conn;
  ResultSet rs;
  Statement stmt;
   AddUser()
  {
    newuserf=new JFrame("ADD User ....!");
    addu= new JButton("Add");
    close=new JButton("Close");
    l3=new JLabel("User Id ");
    l1=new JLabel("Username");
    l2=new JLabel("Password");
    usert=new JTextField(20);
    passt=new JPasswordField(20);
    userid=new JTextField(20);
    newuserf.setResizable(false);
    newuserf.setSize(320,150);
    newuserf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    newuserf.setVisible(true);
    
    newuserf.setLayout(new FlowLayout());
    newuserf.add(l3);
    newuserf.add(userid);
    newuserf.add(l1);
    newuserf.add(usert);
    newuserf.add(l2);
    newuserf.add(passt);
    newuserf.add(addu);
    addu.addActionListener(this);
    newuserf.add(close);
    close.addActionListener(this);
  }
  
  public void actionPerformed(ActionEvent ae)
  {
  if(ae.getSource()==addu)
  {
    if(userid.getText().equals("")||passt.getText().equals("")||usert.getText().equals(""))
    {
      JOptionPane.showMessageDialog(null,"Enter Either username OR password");
    }
    else
    {
      try
      {
        /*String user,pass;
        user=usert.getText();
        pass=passt.getText();*/
        int res,id;
        id=Integer.parseInt(userid.getText());
    
        Connection conn=DatabaseConnection.getConnection();
        Statement stmt=conn.createStatement();
       res=stmt.executeUpdate("INSERT INTO login " + "VALUES("+id+",'"+passt.getText()+"','"+usert.getText()+"')");
       
       if(res==1)
       {
         JOptionPane.showMessageDialog(null,"User Added Sucessfully");
       }
       else
           JOptionPane.showMessageDialog(null,"Error Occured");
       conn.close();
    }
      catch(Exception e)
      {
        JOptionPane.showMessageDialog(null,""+e);
      }
   }
  }
  if(ae.getSource()==close)
  {
  newuserf.dispose();
  }
  }
}