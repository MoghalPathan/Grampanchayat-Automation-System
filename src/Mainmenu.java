import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JOptionPane.*;
import java.util.*;
class Mainmenu implements ActionListener 
{
  private JFrame mainf;
  private JPanel p;
  private JMenuBar mb;
  private JMenu mfile,mnew,mdelet,mabout,medit,mnewsub,mn5,minfo;
  private JMenuItem mn1,mn2,mn3,mn4,mn6,mnsub1,mnsub2,ma1,ma2,md1,md2,md3,me1,me2,me3,meditu,meditb,meditd,meditm,mdeletu,mdeletb,mdeletd,mdeletm,mi1,mi2,mi3;
  private JButton newbirth,newdeath,deletdeath,deletbirth,editbirth,editdeath;
  private int i,f;
  private JMenuItem viewbirth,viewdeath,viewmarriage,viewuser;
  JMenu m1,date,today;
  JLabel l1;
 private Calendar c;
  public Mainmenu(int f)
  {
    
    
        c=Calendar.getInstance();
    
 String day=String.valueOf(c.get(Calendar.DAY_OF_MONTH));
 String year=String.valueOf(c.get(Calendar.YEAR));
 String month="11";
 String id1=day.concat("/"+month);
 String id2=id1.concat("/"+year);

 
 System.out.println(""+id2);

 

    l1=new JLabel();
    l1.setIcon(new ImageIcon("Images/MenuBack.jpg"));
    meditb=new JMenuItem("Edit Birth Record");
    meditd=new JMenuItem("Edit Death Record");
    meditm=new JMenuItem("Edit Marriage Record");
    mdeletb=new JMenuItem("Delete Birth Record");
    mdeletd=new JMenuItem("Delete Death Record");
    mdeletm=new JMenuItem("Delete Marriage Record");
    mdeletu=new JMenuItem("Delete User");
    meditu=new JMenuItem("Edit User");
    viewbirth=new JMenuItem("View Birth Records");
    viewdeath=new JMenuItem("View Death Records");
    viewmarriage=new JMenuItem("View Marriage Records");
    viewuser=new JMenuItem("view User");
    
//For Info bar
    mi1=new JMenuItem("Education");    
    mi2=new JMenuItem("Agriculture");    
    mi3=new JMenuItem("Health");
    
    
    
   //Declairing the Containts of frame..!!
    p=new JPanel();
    mainf=new JFrame("Main Menu !!!!");
    mb=new JMenuBar();
    mfile=new JMenu("File");
    mnew=new JMenu("New");
    medit=new JMenu("Edit");
    mabout=new JMenu("About Us");
    mdelet=new JMenu("Delete");
    minfo=new JMenu("Info");  

    mn1=new JMenuItem("Birth");
    mn2=new JMenuItem("Death");
    mn3=new JMenuItem("Marridge ");
    mn4=new JMenuItem("Exit");
    mn5=new JMenu("View Record");
    mn6=new JMenuItem("Add User");
    
    ma1=new JMenuItem("About Us.");
    ma2=new JMenuItem("Help");
    md1=new JMenuItem("Delete Record");
    me1=new JMenuItem("Edit Record");
   
    m1=new JMenu("          ");
    date=new JMenu(""+id2);
    today=new JMenu("Today Is : ");
   newbirth = new JButton("New   Birth  Record",new ImageIcon("Images/birth.gif"));
    newdeath = new JButton("New   Death  Record",new ImageIcon("Images/death.gif"));
    deletbirth = new JButton("Delete  Birth  Record",new ImageIcon("Images/birth.gif"));
    deletdeath = new JButton("Delete  Death  Record",new ImageIcon("Images/death.gif"));
    editbirth = new JButton("Edit  Birth  Record",new ImageIcon("Images/birth.gif"));
    editdeath = new JButton("Edit  Death  Record",new ImageIcon("Images/death.gif"));
    
   
    //Adding the mainubar and menu buttons to frame..!!

      
    mainf.setJMenuBar(mb);
    mb.add(mfile);
    mb.add(mnew);
    mb.add(medit);
    mb.add(mdelet);
    mb.add(mabout);
    mb.add(minfo);
    mb.add(m1);
    m1.setEnabled(false);
    mb.add(today);
    today.setEnabled(false);
    mb.add(date);
    date.setEnabled(false);
    mb.setBackground(Color.orange);
    mainf.add(p);
    p.setLayout(new FlowLayout());
    p.setBackground(Color.black);
    p.add(l1);
    
    //Adding the menuitems of the menu..!!
    mfile.add(mn6);
    mn6.addActionListener(this);
    mfile.add(mn5);
    
    mfile.add(mn4);
    mn4.addActionListener(this);
    mnew.add(mn1);
    mn1.addActionListener(this);
    mnew.add(mn2);
    mn2.addActionListener(this);
    mnew.add(mn3);
    mn3.addActionListener(this);
    
   
   
     
 
      mabout.add(ma1);
      ma1.addActionListener(this);
      mabout.add(ma2);
      ma2.addActionListener(this);
    
      minfo.add(mi1);
      mi1.addActionListener(this);
      minfo.add(mi2);
      mi2.addActionListener(this);
      minfo.add(mi3);
      mi3.addActionListener(this);
        
      medit.add(meditb);
      meditb.addActionListener(this);
      medit.add(meditd);
      meditd.addActionListener(this);
      medit.add(meditm);
      meditm.addActionListener(this);
      medit.add(meditu);
      meditu.addActionListener(this);
      
      mdelet.add(mdeletb);
      mdeletb.addActionListener(this);
      mdelet.add(mdeletd);
      mdeletd.addActionListener(this);
      mdelet.add(mdeletm);
      mdeletm.addActionListener(this);
      mdelet.add(mdeletu);
      mdeletu.addActionListener(this);
      
      
      
      mn5.add(viewbirth);
      viewbirth.addActionListener(this);
      mn5.add(viewdeath);
      viewdeath.addActionListener(this);
      mn5.add(viewmarriage);
      viewmarriage.addActionListener(this);
      mn5.add(viewuser);
      viewuser.addActionListener(this);
      
      
      
      
      if(f==1)
      {}
      else
      {
         medit.setEnabled(false);
      meditb.setEnabled(false);
      medit.setEnabled(false);
      meditd.setEnabled(false);
      medit.setEnabled(false);
      meditm.setEnabled(false);
      medit.setEnabled(false);
      meditu.setEnabled(false);
      
      mdelet.setEnabled(false);
      mdeletb.setEnabled(false);
      mdelet.setEnabled(false);
      mdeletd.setEnabled(false);
      mdelet.setEnabled(false);
      mdeletm.setEnabled(false);
      mdelet.setEnabled(false);
      mdeletu.setEnabled(false);
      mn6.setEnabled(false);
      
      }
    
    mainf.setResizable(false);
    mainf.setSize(900,800);
    mainf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    mainf.setResizable(false);
    mainf.setVisible(true);
  }
  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==mn6)
    {
    new AddUser();
    }
    
    
    if(ae.getSource()==meditb)
    {
      new EditBirthrecord();
    }
    
    
    
    if(ae.getSource()==meditd)
    {
      new EditDeathrecord();
    }
    
    
    if(ae.getSource()==meditm)
    {
      new EditMarriagerecord();
    }
    
    
     if(ae.getSource()==meditu)
    {
      new EditUser();
    }
    
    
    if(ae.getSource()==mn3)
    {
    new MarriageCertificate();
    }
    
    
    
    if(ae.getSource()==mn1)
    {
      new pankaj();
    }
    
        
    
    
    if(ae.getSource()==mn2)
    {
      new DeathCirtificate();
    }
    
    
    
    if(ae.getSource()==mdeletb)
    {
    new DeletBirthrecord();
    }
    
    
    if(ae.getSource()==mdeletd)
    {
    new DeletDeathrecord();
    }
    
    
    if(ae.getSource()==mdeletm)
    {
    new DeletMarriagerecord();
    }
    
    
    if(ae.getSource()==mdeletu)
    {
      new DeletUser();
    }
    
    //View Records
    if(ae.getSource()==viewbirth)
    {
      new BirthTable();
    }
    
    if(ae.getSource()==viewdeath)
    {
      new DeathTable();
    }
    
    if(ae.getSource()==viewmarriage)
    {
      new MarriTable();
    }
    
    if(ae.getSource()==viewuser)
    {
      new UserTable();
    }
    
    
    if(ae.getSource()==mn4)
    {
     int sel=JOptionPane.showConfirmDialog(null,"Are you sure..!!","Are you sure..!!",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
         if(sel==JOptionPane.YES_OPTION)
    {
      System.exit(0);
    }
    }
    
    
    if(ae.getSource()== ma1)
    {
    JOptionPane.showMessageDialog(null,"KORABU NAVED ARIF-3406");
    }
    if(ae.getSource()==ma2)
    {
      JOptionPane.showMessageDialog(null,"Certificate Prices(per. certi.)\n Certificate      Price(Rs.)\n  Birth                    10\n  Death                  15\n  Marriage            50 \n  Resi. Proof        30 ");
    }
    
    
    if(ae.getSource()==mn5)
    {
    new BirthTable();
    }


    if(ae.getSource()==mi1)
    {
    new Education();
    }

    if(ae.getSource()==mi2)
    {
    new Agriculture();
    }

    if(ae.getSource()==mi3)
    {
    new Health();
    }
    
    
  }
 
  
  
 // public static void main(String args[])
 // {
  //new Mainmenu();
 // }
}

  
