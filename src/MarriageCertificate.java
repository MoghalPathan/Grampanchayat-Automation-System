import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


class MarriageCertificate implements ActionListener
{
  JFrame mf;
  JLabel mid,mname,fname,mdat,mdate,mmonth,myear,mbdat,mbdate,mbmonth,mbyear,fbdat,fbdate,fbmonth,fbyear,addr,ename1,ename2;
  JButton saveb,closeb;
  JTextField midt,mnamet,fnamet,mdatt,mdatet,mmontht,myeart,mbdatt,mbdatet,mbmontht,mbyeart,fbdatt,fbdatet,fbmontht,fbyeart,addrt,ename1t,ename2t;
  String id; 
Connection conn;
  ResultSet rs;
  Statement stmt;

  public MarriageCertificate()
  {
    
    mf=new JFrame("Marriage Certificate.....!!");
    
    
    
      try
    {
     
  Connection conn=DatabaseConnection.getConnection();
   Statement stmt=conn.createStatement();
   ResultSet rs=stmt.executeQuery("SELECT * FROM marriage");
      int count=0;
    while(rs.next())
    {  
      count=Integer.parseInt(rs.getString("mid"));
    }
    count++;
    id= Integer.toString(count);
    conn.close();
    }
    catch(Exception e)
    {System.out.println("\n"+e);}
    
    
    
    
    
    
    saveb=new JButton("Save");
    closeb=new JButton("Cancle/Close");
    mid  =new JLabel("    Reg.  ID   ",JLabel.LEFT);
    mname=new JLabel(" Male Name",JLabel.LEFT);
    fname=new JLabel(" Fem. name",JLabel.LEFT);
    mdat=new JLabel("Date Marriage ",JLabel.LEFT);
    mdate=new JLabel("DD");
    mmonth=new JLabel("MM");
    myear=new JLabel("YY");
    mbdat=new JLabel("Date Of Birt. Male",JLabel.LEFT);
    mbdate=new JLabel("DD");
    mbmonth=new JLabel("MM");
    mbyear=new JLabel("YY");
    fbdat=new JLabel("Date Of Birt. Fem.",JLabel.LEFT);
    fbdate=new JLabel("DD");
    fbmonth=new JLabel("MM");
    fbyear=new JLabel("YY");
    addr=new JLabel(" ADDRESS  ",JLabel.LEFT);
    ename1=new JLabel("EVIDENCE 1",JLabel.LEFT);
    ename2=new JLabel("EVIDENCE 2",JLabel.LEFT);
    
    midt=new JTextField(20);
    mnamet=new JTextField(20);
    fnamet=new JTextField(20);
    mdatet=new JTextField(2);
    mmontht=new JTextField(2);
    myeart=new JTextField(4);
    mbdatet=new JTextField(2);
    mbmontht=new JTextField(2);
    mbyeart=new JTextField(4);
    fbdatet=new JTextField(2);
    fbmontht=new JTextField(2);
    fbyeart=new JTextField(4);
    addrt=new JTextField(20);
    ename1t=new JTextField(20);
    ename2t=new JTextField(20);
    
        
    mf.add(mid);
    mf.add(midt);
    midt.setText(id);
    midt.setEditable(false);
    mf.add(mname);
    mf.add(mnamet);
    mf.add(mbdat);
    mf.add(mbdate);
    mf.add(mbdatet);
    mf.add(mbmonth);
    mf.add(mbmontht);
    mf.add(mbyear);
    mf.add(mbyeart);
    mf.add(fname);
    mf.add(fnamet);
    mf.add(fbdat);
    mf.add(fbdate);
    mf.add(fbdatet);
    mf.add(fbmonth);
    mf.add(fbmontht);
    mf.add(fbyear);
    mf.add(fbyeart);
    mf.add(mdat);
    mf.add(mdate);
    mf.add(mdatet);
    mf.add(mmonth);
    mf.add(mmontht);
    mf.add(myear);
    mf.add(myeart);
    mf.add(addr);
    mf.add(addrt);
    mf.add(ename1);
    mf.add(ename1t);
    mf.add(ename2);
    mf.add(ename2t);
    
    mf.add(saveb);
    saveb.addActionListener(this);
    mf.add(closeb);
    closeb.addActionListener(this);
   
    mf.setLayout(new FlowLayout());
    mf.setSize(320,300);
    mf.setVisible(true);
    mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mf.setResizable(false);
    
    
    
    
     
    
  }
  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==saveb)
    {
    /*midt,mnamet,fnamet,mdatet,mmontht,myeart,mbdatt,mbdatet,mbmontht,
     * mbyeart,fbdatet,fbmontht,fbyeart,addrt,ename1t,ename2t;
*/
      if(midt.getText().equals("")||
         mnamet.getText().equals("")||
         fnamet.getText().equals("")||
   mdatet.getText().equals("")||
         mmontht.getText().equals("")||
         myeart.getText().equals("")||
         mbdatet.getText().equals("")||
   mbmontht.getText().equals("")||
         mbyeart.getText().equals("")||
         fbdatet.getText().equals("")||
         fbmontht.getText().equals("")||
         fbyeart.getText().equals("")||
         addrt.getText().equals("")||
         ename1t.getText().equals("")||
         ename2t.getText().equals(""))
     {
     JOptionPane.showMessageDialog(null,"Recheck The Info & Enter The Info Again....");
     }
    else
    {
      try
      {
        int mid,mbd,mbm,mby,fbd,fbm,fby,mdd,mmm,myy;
        String mname,fname,addr,eve1,eve2;
        
       mid=Integer.parseInt(midt.getText());
       mbd=Integer.parseInt(mbdatet.getText());
       mbm=Integer.parseInt(mbmontht.getText());
       mby=Integer.parseInt(mbyeart.getText());
        fbd=Integer.parseInt(fbdatet.getText());
        fbm=Integer.parseInt(fbmontht.getText());
       fby=Integer.parseInt(fbyeart.getText());
        mdd=Integer.parseInt(mdatet.getText());
        mmm=Integer.parseInt(mmontht.getText());
        myy=Integer.parseInt(myeart.getText());
        
        
        mname=mnamet.getText();
        fname=fnamet.getText();
        addr=addrt.getText();
        eve1=ename1t.getText();
        eve2=ename2t.getText();
        
        
        
        Connection conn=DatabaseConnection.getConnection();
        Statement stmt=conn.createStatement();
        int r=stmt.executeUpdate("INSERT INTO marriage " + "VALUES("+mid+",'"+mname+"',"+mbd+","+mbm+","+mby+",'"+fname+
                                 "',"+fbd+","+fbm+","+fby+","+mdd+","+mmm+","+myy+",'"+addr+"','"+eve1+"','"+eve2+"')");
        if(r==1)
        {
        JOptionPane.showMessageDialog(null,"Record Saved...!!!");
        mid++;
        String id=Integer.toString(mid);
        midt.setText(id);
        mbdate.setText("");
        mbmontht.setText("");
        mbyeart.setText("");
        fbdatet.setText("");
        fbmontht.setText("");
        fbyeart.setText("");
        mdatet.setText("");
        mmontht.setText("");
        myeart.setText("");
        mnamet.setText("");
        fnamet.setText("");
        addrt.setText("");
        ename1t.setText("");
        ename2t.setText("");
        
        }
        else
        {JOptionPane.showMessageDialog(null,"Error....!!!!");}conn.close();
      }
      catch(Exception e)
      {
        JOptionPane.showMessageDialog(null,""+e);
      }
    }
    }
    if(ae.getSource()==closeb)
    {
    int sel=JOptionPane.showConfirmDialog(null,"Are You Sure....!!!","Are You Sure.....!!",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
      if(sel==JOptionPane.YES_OPTION)
      {
      mf.dispose();
      }
    }
  }
  }
