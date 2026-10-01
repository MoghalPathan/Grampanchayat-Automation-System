import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

class UpdateUser implements ActionListener
{
  JFrame newuserf;
  JButton addu,close;
  JLabel l1,l2,l3;
  JTextField usert,userid;
  JPasswordField passt;
  Connection conn;
  ResultSet rs;
  Statement stmt;
   UpdateUser(int id)
  {
     
    newuserf=new JFrame("ADD User ....!");
    addu= new JButton("Update");
    close=new JButton("Close");
    l3=new JLabel("User Id ");
    l1=new JLabel("Username");
    l2=new JLabel("Password");
    String uid=Integer.toString(id);
    usert=new JTextField(20);
        
    passt=new JPasswordField(20);
    userid=new JTextField(20);
    userid.setText(uid);
    userid.setEditable(false);
    
    newuserf.setSize(320,150);
    newuserf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    newuserf.setVisible(true);
    newuserf.setResizable(false);
    
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
    
    try
     {
     
     Connection conn=DatabaseConnection.getConnection();
     Statement stmt=conn.createStatement();
     ResultSet rs=stmt.executeQuery("SELECT * FROM login WHERE userid="+userid.getText());
     rs.next();  

   
    int ID=Integer.parseInt(rs.getString("userid"));
    String UsersName=rs.getString("username");
  
     String ui=Integer.toString(id);
   
     usert.setText(UsersName);
     passt.setText("");conn.close();
   }

catch(Exception e)
{JOptionPane.showMessageDialog(null,"Record Not Present");}
    
  }
  
  public void actionPerformed(ActionEvent ae)
  {
  if(ae.getSource()==addu)
  {
         
   try
     {
   
  Connection conn=DatabaseConnection.getConnection();
   Statement stmt=conn.createStatement();
   boolean r=stmt.execute("DELETE * FROM login WHERE userid="+userid.getText());
   if(r==false)
   {   
      try
      {
        /*String user,pass;
        user=usert.getText();
        pass=passt.getText();*/
        int res,id;
        id=Integer.parseInt(userid.getText());
    
        conn=DatabaseConnection.getConnection();
        stmt=conn.createStatement();
       res=stmt.executeUpdate("INSERT INTO login " + "VALUES("+id+",'"+passt.getText()+"','"+usert.getText()+"')");
       
       if(res==1)
       {
         JOptionPane.showMessageDialog(null,"User Info Updated Sucessfully");
       }
       else
       {
           JOptionPane.showMessageDialog(null,"Error Occured");
       }conn.close();
      }
      catch(Exception e)
      {
        JOptionPane.showMessageDialog(null,"Record Not Present");
      }
   }
   conn.close();
   }
   catch(Exception e)
   {}
  }
    
  
  if(ae.getSource()==close)
  {
  newuserf.dispose();
  }
  }
}