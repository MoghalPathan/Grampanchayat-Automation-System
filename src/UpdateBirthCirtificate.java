import javax.swing.*;
import java.awt.*;
import java.awt.Color.*;
import java.awt.event.*;
import java.sql.*;

class UpdateBirthCirtificate implements ActionListener 
{
  private JFrame birthf;
  private JButton b1,b2,b3,b4,b5;
  private JLabel l0,l1,l2,l3,l4,l5,l5d,l5m,l5y,l6,l7,l8,l9,l10,l11,l12;
  private JPanel p;
  private JTextField t0,t1,t2,t3,t4,t5d,t5m,t5y,t6,t7,t8,t9,t10,t11;
  Connection conn;
  ResultSet rs;
  Statement stmt;
  public UpdateBirthCirtificate(int id)
  {
    birthf=new JFrame("Update Birth Cirtificate !!");
   
    birthf.setResizable(false);
    l0=new JLabel("  Regi.No ",JLabel.LEFT);
    l1=new JLabel("B.Name   ",JLabel.LEFT);
    //l2=new JLabel("F.Name   ");
    l3=new JLabel("M.Name   ",JLabel.LEFT);
   // l4=new JLabel("Surname  ");
    l5=new JLabel("Birth Date ",JLabel.LEFT);
    l5d=new JLabel("   DD ");
    l5m=new JLabel("   MM ");
    l5y=new JLabel("   YY ");
    l7=new JLabel("  Birth plc",JLabel.LEFT);
    l8=new JLabel("Catagory ",JLabel.LEFT);
    l9=new JLabel("Sub-Cat. ",JLabel.LEFT);
    l10=new JLabel("B.Mark   ",JLabel.LEFT);
    l11=new JLabel("InfoRec  ",JLabel.LEFT);
    
    birthf.setSize(325,320);
    birthf.setVisible(true);
    birthf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    p=new JPanel();
    //birthf.add(p);
   
    
    //p.setBackground(Color.RED);
    
     birthf.setLayout(new FlowLayout());
    b1=new JButton("Update");
    b3=new JButton("Cancle/Close");
   
    String i=Integer.toString(id); 
    t0=new JTextField(20);
    t0.setText(i);
    t0.setEditable(false);
    t1=new JTextField(20);
   // t2=new JTextField(25);
    t3=new JTextField(20);
    //t4=new JTextField(25);
    t5d=new JTextField(2);
    t5m=new JTextField(2);
    t5y=new JTextField(4);
    t7=new JTextField(20);
    t8=new JTextField(20);
    t9=new JTextField(20);
    t10=new JTextField(20);
    t11=new JTextField(20);
    
    
    birthf.add(l0);
    birthf.add(t0);
   birthf.add(l1);
   birthf.add(t1);
    //birthf.add(l2);
   // birthf.add(t2);
    birthf.add(l3);
    birthf.add(t3);
   // birthf.add(l4);
   // birthf.add(t4);
    birthf.add(l5);
    birthf.add(l5d);
    birthf.add(t5d);
    birthf.add(l5m);
    birthf.add(t5m);
    birthf.add(l5y);
    birthf.add(t5y);
    birthf.add(l7);
    birthf.add(t7);
    birthf.add(l8);
    birthf.add(t8);
    birthf.add(l9);
    birthf.add(t9);
    birthf.add(l10);
    birthf.add(t10);
    birthf.add(l11);
    birthf.add(t11);
   
    //birthf.setResizable(false);
    birthf.setDefaultCloseOperation(birthf.DISPOSE_ON_CLOSE);
    birthf.add(b1);
    b1.addActionListener(this);
    birthf.add(b3);
    b3.addActionListener(this);
    
    
    
    
    try
      {
        int dd,mm,yy;
        String bname,mname,bplace,cat,subcat,bmark,infop;
        
         
        
        
        Connection conn=DatabaseConnection.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM birth WHERE bid="+id);
        
          rs.next();
          bname=rs.getString("bname");
           mname=rs.getString("mname");
            dd=Integer.parseInt(rs.getString("bday"));
           mm=Integer.parseInt(rs.getString("bmonth"));
           yy=Integer.parseInt(rs.getString("byear"));
          bplace=rs.getString("bplace");
          cat=rs.getString("bcat");
          subcat=rs.getString("bsubcat");
          bmark=rs.getString("bmark");
          infop=rs.getString("binfo");
       
          
          
          String bd=Integer.toString(dd);
          String bm=Integer.toString(mm);
          String by=Integer.toString(yy);
          
          t1.setText(bname);
   
    t3.setText(mname);
    
    t5d.setText(bd);
    t5m.setText(bm);
    t5y.setText(by);
    t7.setText(bplace);
    t8.setText(cat);
    t9.setText(subcat);
    t10.setText(bmark);
    t11.setText(infop);
    
        conn.close();
        }
      catch(Exception e)
      {
        JOptionPane.showMessageDialog(null,"Record Not Present");
      }
      
      
    
  }
 public void actionPerformed(ActionEvent ae)
  {
   
  //if "ADD" Button pressed

   if(ae.getSource()==b1)
  {
     
     
     try
      {
      
  Connection conn=DatabaseConnection.getConnection();
   Statement stmt=conn.createStatement();
   boolean r=stmt.execute("DELETE * FROM birth WHERE bid="+t0.getText());
   
   
   if(r==false)
   {
     
     try
      {
        int id,dd,mm,yy;
        String bname,mname,bplace,cat,subcat,bmark,infop;
        
        id=Integer.parseInt(t0.getText());
        dd=Integer.parseInt(t5d.getText());
        mm=Integer.parseInt(t5m.getText());
        yy=Integer.parseInt(t5y.getText());
        
        
        bname=t1.getText();
        mname=t3.getText();
        bplace=t7.getText();
        cat=t8.getText();
        subcat=t9.getText();
        bmark=t10.getText();
        infop=t11.getText();
        
        
        conn=DatabaseConnection.getConnection();
         stmt=conn.createStatement();
        int x=stmt.executeUpdate("INSERT INTO birth " + "VALUES("+id+",'"+bname+"','" +mname+ "',"+dd+","
                                +mm+","+yy+",'"+bplace+"','"+cat+"','"+subcat+"','"+bmark+
                                 "','"+infop+"')");
        
        JOptionPane.showMessageDialog(null,"Birth Record Updated");conn.close();
        
     }
      catch(Exception e)
      {
        JOptionPane.showMessageDialog(null,"Record Not Present");
      }
   }conn.close();
      }
      catch(Exception e)
      {JOptionPane.showMessageDialog(null," Record Not Present");}
   
          
    }
   
  
   
   
   
   //if "CANCLE " BUTTON presed

   if(ae.getSource()==b3)
   {
   int sel=JOptionPane.showConfirmDialog(null,"ARE YOU DONE","ARE YOU SURE YOUR DONE",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
   if(sel==JOptionPane.YES_OPTION)
    {
     birthf.dispose();
    }
  }
 }
 
}
  
  
