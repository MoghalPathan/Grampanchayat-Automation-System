import javax.swing.*;
import java.awt.*;
import java.awt.Color.*;
import java.awt.event.*;
import java.sql.*;

class DeathCirtificate implements ActionListener
{
  private JFrame deathf;
  private JButton b1,b2,b3,b4,b5;
  private JLabel l0,l1,l2,l3,l4,l5,l5d,l5m,l5y,l6,l7,l8,l9,l10,l11,l12;
  private JPanel p;
  private JTextField t0,t1,t2,t3,t4,t5d,t5m,t5y,t6,t7,t8,t9,t10,t11;
  String id; 
  Connection conn;
  ResultSet rs;
  Statement stmt;
  DeathCirtificate()
  {
    deathf=new JFrame("Death Cirtificate !!");
   
    
      try
    {
     
  Connection conn=DatabaseConnection.getConnection();
   Statement stmt=conn.createStatement();
   ResultSet rs=stmt.executeQuery("SELECT * FROM death");
      int count=0;
    while(rs.next())
    {
      count=Integer.parseInt(rs.getString("did"));
    }
    count++;
    id= Integer.toString(count);
     conn.close();
    }
    catch(Exception e)
    {System.out.println("\n"+e);}
    
    
    
    
    deathf.setResizable(false);
    l0=new JLabel(" Per. Regi. No ",JLabel.LEFT);
    l1=new JLabel("Person Name ",JLabel.LEFT);
    l5=new JLabel("Date of death",JLabel.LEFT);
    l5d=new JLabel("DD");
    l5m=new JLabel("MM");
    l5y=new JLabel("YY");
    l6=new JLabel("Age");
    l7=new JLabel("place of death",JLabel.LEFT);
    l8=new JLabel("      Catagory   ",JLabel.LEFT);
    l10=new JLabel("Decise If any  ",JLabel.LEFT);
    l11=new JLabel("Info. provider  ",JLabel.LEFT);
    
    deathf.setSize(345,270);
    deathf.setVisible(true);
    deathf.setDefaultCloseOperation(deathf.DISPOSE_ON_CLOSE);
    
    p=new JPanel();
    //deathf.add(p);
   
    
    //p.setBackground(Color.RED);
    
     deathf.setLayout(new FlowLayout());
    b1=new JButton("Save");
    b3=new JButton("Cancle/Close");
   
    
    t0=new JTextField(20);
    t1=new JTextField(20);
    t5d=new JTextField(2);
    t5m=new JTextField(2);
    t5y=new JTextField(4);
    t6=new JTextField(3);
    t7=new JTextField(20);
    t8=new JTextField(20);
    t10=new JTextField(20);
    t11=new JTextField(20);
    
    
    deathf.add(l0);
    deathf.add(t0);
    t0.setText(id);
    t0.setEditable(false);
    deathf.add(l1);
    deathf.add(t1);
    deathf.add(l5);
    deathf.add(l5d);
    deathf.add(t5d);
    deathf.add(l5m);
    deathf.add(t5m);
    deathf.add(l5y);
    deathf.add(t5y);
    deathf.add(l6);
    deathf.add(t6);
    deathf.add(l7);
    deathf.add(t7);
    deathf.add(l8);
    deathf.add(t8);
    deathf.add(l10);
    deathf.add(t10);
    deathf.add(l11);
    deathf.add(t11);
   
    //deathf.setResizable(false);
    deathf.setDefaultCloseOperation(deathf.DISPOSE_ON_CLOSE);
    deathf.add(b1);
    b1.addActionListener(this);
    deathf.add(b3);
    b3.addActionListener(this);
    
    
    
    
  }
 public void actionPerformed(ActionEvent ae)
  {
 
   
   //Button "ADD" pressed
   if(ae.getSource()==b1)
  {
     
     if(t0.getText().equals("")||t1.getText().equals("")||t6.getText().equals("")||
   t5d.getText().equals("")||t5m.getText().equals("")||t5y.getText().equals("")||t7.getText().equals("")||
   t8.getText().equals("")||t10.getText().equals("")||t11.getText().equals(""))
     {
     JOptionPane.showMessageDialog(null,"Recheck The Info & Enter The Info Again....");
     }
    else
    {
      try
      {
        int did,dd,mm,yy,dage;
        String dcat,dname,dplace,ddecise,dinfop;
        
        did=Integer.parseInt(t0.getText());
        dd=Integer.parseInt(t5d.getText());
        mm=Integer.parseInt(t5m.getText());
        yy=Integer.parseInt(t5y.getText());
        dage=Integer.parseInt(t6.getText());
        
        dname=t1.getText();
       
        dplace=t7.getText();
        dcat=t8.getText();
        
        ddecise=t10.getText();
        dinfop=t11.getText();
        
        
        Connection conn=DatabaseConnection.getConnection();
        Statement stmt=conn.createStatement();
        int r=stmt.executeUpdate("INSERT INTO death " + "VALUES("+did+",'"+dname+"',"+dd+","
                                +mm+","+yy+","+dage+",'"+dplace+"','"+dcat+"','"+ddecise+"','"+dinfop+
                                 "')");
        if(r==1)
        {
        JOptionPane.showMessageDialog(null,"Record Saved...!!!");
        did++;
        String id=Integer.toString(did);
        t0.setText(id);
        t1.setText("");
        t6.setText("");
        t5d.setText("");
        t5m.setText("");
        t5y.setText("");
        t7.setText("");
        t8.setText("");
        
        t10.setText("");
        t11.setText("");
        }
        else{
         {JOptionPane.showMessageDialog(null,"Error....!!!!");}
         conn.close();
      }
      }
      catch(Exception e)
      {
        JOptionPane.showMessageDialog(null,""+e);
      }
  }
   }
   
   //Button "Cancle Pressed"
  if(ae.getSource()==b3)
   {
   int sel=JOptionPane.showConfirmDialog(null,"ARE YOU DONE","ARE YOU SURE YOUR DONE",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
   if(sel==JOptionPane.YES_OPTION)
    {
     deathf.dispose();
    }
  }
 }
}
  
  
