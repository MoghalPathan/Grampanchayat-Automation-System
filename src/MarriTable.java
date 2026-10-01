import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;

public class MarriTable extends JFrame
{
 Container c;
 Connection conn;
 ResultSet rs;
 PreparedStatement psmt;
 JLabel lbl_search;
 JTextField txt_search;
 JButton cmd_search;
 JButton cmd_exit;

 public MarriTable()
 {
  c=getContentPane();

  Dimension   screen  = Toolkit.getDefaultToolkit().getScreenSize();

  try
  {
   
   //set Dsn name (empData) to a odbcad32
   conn=DatabaseConnection.getConnection();
  }
  catch (Exception e1)
  {
    JOptionPane.showMessageDialog(null,""+e1);
  }
  //String id="e007";



  String colname[]={"Id","MaleName","Birthdate","Birthmonth","Birthyear","FemaleName","Birthdate","Birthmonth","Birthyear","Marridate","Marrimonth","Marriyear","Address","Evedence1","Evedence2",};
  Vector v1=getBirth();
  String data [][]=new String[v1.size()][15];
  for (int i=0;i<v1.size();i++)
  {
    MarriDetails e=(MarriDetails)v1.elementAt(i);
   data[i][0]=e.Id;
   data[i][1]=e.MaleName;
   data[i][2]=e.Birthdate;
   data[i][3]=e.Birthmonth;
   data[i][4]=e.Birthyear;
   data[i][5]=e.FemaleName;
   data[i][6]=e.date;
   data[i][7]=e.month;
   data[i][8]=e.year;
   data[i][9]=e.Marridate;
   data[i][10]=e.Marrimonth;
   data[i][11]=e.Marriyear;
   data[i][12]=e.Address;
   data[i][13]=e.Evedence1;
   data[i][14]=e.Evedence2;
  }
  
  
  
  
  JTable jt=new JTable(data,colname);
 jt.setBackground(Color.LIGHT_GRAY);
/*
 //Thus Function is for Coloring to Particular Column
  TableColumn tm = jt.getColumnModel().getColumn(0);
  tm.setCellRenderer(new ColorColumnRenderer(Color.pink, Color.blue));

*/
  JScrollPane jsp=new JScrollPane(jt,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
 
  c.add(jsp);

  setVisible(true);
  setResizable(false);
  setTitle("Marriage Detail");
  setSize(1000,400);
  
  }
 public Vector getBirth()
 {
  Vector v=new Vector();
  try
  {
   psmt=conn.prepareStatement("select * from marriage");
   //psmt.setString(1,id);
   rs=psmt.executeQuery();
   while(rs.next())
   {
    //Constructor for Birth_Details Class used only for store value on different varaible
   MarriDetails e=new MarriDetails();
  
  e.Id=rs.getString(1);
  e.MaleName=rs.getString(2);
  e.Birthdate=rs.getString(3);
  e.Birthmonth=rs.getString(4);
  e.Birthyear=rs.getString(5);
  e.FemaleName=rs.getString(6);
  e.date=rs.getString(7);
  e.month=rs.getString(8);
  e.year=rs.getString(9);
  e.Marridate=rs.getString(10);
  e.Marrimonth=rs.getString(11);
  e.Marriyear=rs.getString(12);
  e.Address=rs.getString(13);
  e.Evedence1=rs.getString(14);
  e.Evedence2=rs.getString(15); 
  
  
  
   
   
   v.add(e);
   }  conn.close();
  }
  catch (Exception e3)
  {
  }
  return v; 
 
 }
}

