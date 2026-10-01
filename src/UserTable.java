import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;

public class UserTable extends JFrame
{
 Container c;
 Connection conn;
 ResultSet rs;
 PreparedStatement psmt;
 JLabel lbl_search;
 JTextField txt_search;
 JButton cmd_search;
 JButton cmd_exit;

 public UserTable()
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



  String colname[]={"Id","UserName"};
  Vector v1=getBirth();
  String data [][]=new String[v1.size()][2];
  for (int i=0;i<v1.size();i++)
  {
    UserDetails e=(UserDetails)v1.elementAt(i);
   data[i][0]=e.Id;
   data[i][1]=e.UserName;
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
  setTitle("User Detail");
  setSize(400,400);
  
  }
 public Vector getBirth()
 {
  Vector v=new Vector();
  try
  {
   psmt=conn.prepareStatement("select * from login");
   //psmt.setString(1,id);
   rs=psmt.executeQuery();
   while(rs.next())
   {
    //Constructor for Birth_Details Class used only for store value on different varaible
   UserDetails e=new UserDetails();
  
  e.Id=rs.getString(1);
  e.UserName=rs.getString(3);
     
   v.add(e);
   }  
  }
  catch (Exception e3)
  {
  }
  return v; 
 
 }
}

