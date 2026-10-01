import javax.swing.*;
import java.awt.*;
import java.awt.Color.*;
import java.awt.event.*;
import java.sql.*;

class UpdateDeathRecord implements ActionListener
{
  private JFrame deathf;
  private JButton b1,b2,b3,b4,b5;
  private JLabel l0,l1,l2,l3,l4,l5,l5d,l5m,l5y,l6,l7,l8,l9,l10,l11,l12;
  private JPanel p;
  private JTextField t0,t1,t2,t3,t4,t5d,t5m,t5y,t6,t7,t8,t9,t10,t11;
  Connection conn;
  ResultSet rs;
  Statement stmt; 
  UpdateDeathRecord(int id)
  {
    deathf=new JFrame("Death Cirtificate !!");
   
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
    b1=new JButton("Update");
    b3=new JButton("Cancle/Close");
   
    String reg=Integer.toString(id);
    t0=new JTextField(20);
    t0.setText(reg);
    t0.setEditable(false);
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
    
    
    
    
    
    try
     {
     
  Connection conn=DatabaseConnection.getConnection();
   Statement stmt=conn.createStatement();
   ResultSet rs=stmt.executeQuery("SELECT * FROM death WHERE did="+id);
   rs.next();  

  int RegiNo,DateOfDeath,MonthOfDeath,YearOfDeath ,AgeAtDeath ;
  String PersonName,PlaceOfDeath,Catagory,Decise,InfoProvider;
   
  
  RegiNo=Integer.parseInt(rs.getString("did"));
  PersonName=rs.getString("dname");
    DateOfDeath=Integer.parseInt(rs.getString("dday"));
    MonthOfDeath=Integer.parseInt(rs.getString("dmonth"));
  YearOfDeath=Integer.parseInt(rs.getString("dyear")) ;
  AgeAtDeath=Integer.parseInt(rs.getString("dage"));
  PlaceOfDeath=rs.getString("dplace");
  Catagory=rs.getString("dcat");
  Decise=rs.getString("ddecise");
  InfoProvider=rs.getString("dinfo");
    
  
  
  String age=Integer.toString(AgeAtDeath);
  String dd=Integer.toString(DateOfDeath);
  String mm=Integer.toString(MonthOfDeath);
  String yy=Integer.toString(YearOfDeath);
  
  
  t1.setText(PersonName);
    t5d.setText(dd);
    t5m.setText(mm);
    t5y.setText(yy);
    t6.setText(age);
    t7.setText(PlaceOfDeath);
    t8.setText(Catagory);
    t10.setText(Decise);
    t11.setText(InfoProvider);
    conn.close();
    }
   catch(Exception e)
   {JOptionPane.showMessageDialog(null,"Record Not Present");}
  }
 public void actionPerformed(ActionEvent ae)
  {
 
   
   //Button "ADD" pressed
   if(ae.getSource()==b1)
  {
     
     try
     {
   
  Connection conn=DatabaseConnection.getConnection();
   Statement stmt=conn.createStatement();
   boolean r=stmt.execute("DELETE * FROM death WHERE did="+t0.getText());
   if(r==false)
   {
     
   }conn.close();
    }
  catch(Exception e)
  {
  JOptionPane.showMessageDialog(null,"Error During Update");
  }
     
     
      try
      {
        int id,dd,mm,yy,dage;
        String dcat,dname,dplace,ddecise,dinfop;
        
        id=Integer.parseInt(t0.getText());
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
        int r=stmt.executeUpdate("INSERT INTO death " + "VALUES("+id+",'"+dname+"',"+dd+","
                                +mm+","+yy+","+dage+",'"+dplace+"','"+dcat+"','"+ddecise+"','"+dinfop+
                                 "')");
        if(r==1)
        {
        JOptionPane.showMessageDialog(null,"Record Updated...!!!");
        
        }
        else{
         {JOptionPane.showMessageDialog(null,"Error....!!!!");}
      }conn.close();
      }
      catch(Exception e)
      {
        JOptionPane.showMessageDialog(null,"Record Not Present");
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
  
  
