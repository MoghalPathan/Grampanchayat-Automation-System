import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


class UpdateMarriagerecord implements ActionListener
{
  JFrame mf;
  JLabel mid,mname,fname,mdat,mdate,mmonth,myear,mbdat,mbdate,mbmonth,mbyear,fbdat,fbdate,fbmonth,fbyear,addr,ename1,ename2;
  JButton saveb,closeb;
  JTextField midt,mnamet,fnamet,mdatt,mdatet,mmontht,myeart,mbdatt,mbdatet,mbmontht,mbyeart,fbdatt,fbdatet,fbmontht,fbyeart,addrt,ename1t,ename2t;
Connection conn;
  ResultSet rs;
  Statement stmt;
  public UpdateMarriagerecord(int id)
  {
    
    mf=new JFrame("Update Marriage Certificate.....!!");
    saveb=new JButton("Update");
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
    
   String rid=Integer.toString(id);
    midt=new JTextField(20);
    midt.setText(rid);
    midt.setEditable(false);
    
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
    //mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mf.setResizable(false);
    
    try
     {
     
  Connection conn=DatabaseConnection.getConnection();
   Statement stmt=conn.createStatement();
   ResultSet rs=stmt.executeQuery("SELECT * FROM marriage WHERE mid="+id);
   rs.next();  

   
   int RegiId=Integer.parseInt(rs.getString("mid"));
   String MaleName=rs.getString("malename");
   int DateOfBirthm=Integer.parseInt(rs.getString("mbdate"));
   int MonthOfBirthm=Integer.parseInt(rs.getString("mbmonth"));
   int YearOfBirthm=Integer.parseInt(rs.getString("mbyear"));
   String FemaleName=rs.getString("femalename");
   int DateOfBirthf=Integer.parseInt(rs.getString("fbdate"));
   int MonthOfBirthf=Integer.parseInt(rs.getString("fbmonth"));
   int YearOfBirthf=Integer.parseInt(rs.getString("fbyear"));
   int DateOfMarriage=Integer.parseInt(rs.getString("mdate"));
   int MonthOfMarriage=Integer.parseInt(rs.getString("mmonth"));
   int YearOfMarriage=Integer.parseInt(rs.getString("myear"));
   String EvidenceNo1=rs.getString("ename1");
   String EvidenceNo2=rs.getString("ename2");
   String Address=rs.getString("addr");
   
   
   String DOBM=Integer.toString(DateOfBirthm);
   String MOBM=Integer.toString(MonthOfBirthm);
   String YOBM=Integer.toString(YearOfBirthm);
   String DOBF=Integer.toString(DateOfBirthf);
   String MOBF=Integer.toString(MonthOfBirthf);
   String YOBF=Integer.toString(YearOfBirthf);
   String DOM=Integer.toString(DateOfMarriage);
   String MOM=Integer.toString(MonthOfMarriage);
   String YOM=Integer.toString(YearOfMarriage);
   
   
   
   mnamet.setText(MaleName);
    fnamet.setText(FemaleName);
    mdatet.setText(DOM);
    mmontht.setText(MOM);
    myeart.setText(YOM);
    mbdatet.setText(DOBM);
    mbmontht.setText(MOBM);
    mbyeart.setText(YOBM);
    fbdatet.setText(DOBF);
    fbmontht.setText(MOBF);
    fbyeart.setText(YOBF);
    addrt.setText(Address);
    ename1t.setText(EvidenceNo1);
    ename2t.setText(EvidenceNo2);
   conn.close();
    }
    
    catch(Exception e)
    {JOptionPane.showMessageDialog(null,"Record Not Present");}
    
    
    
  }
  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==saveb)
    {
      
     try
     {
   
  Connection conn=DatabaseConnection.getConnection();
   Statement stmt=conn.createStatement();
   boolean r=stmt.execute("DELETE * FROM marriage WHERE mid="+midt.getText());
   if(r==false)
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
        
        
        
        conn=DatabaseConnection.getConnection();
       stmt=conn.createStatement();
        int re=stmt.executeUpdate("INSERT INTO marriage " + "VALUES("+mid+",'"+mname+"',"+mbd+","+mbm+","+mby+",'"+fname+
                                 "',"+fbd+","+fbm+","+fby+","+mdd+","+mmm+","+myy+",'"+addr+"','"+eve1+"','"+eve2+"')");
        if(re==1)
        {
        JOptionPane.showMessageDialog(null,"Record Updated...!!!");
        }
        else
        {JOptionPane.showMessageDialog(null,"Error....!!!!");}conn.close();
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
