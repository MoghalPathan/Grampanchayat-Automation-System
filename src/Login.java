import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color.*;

import java.sql.*;

class Login implements ActionListener {
	JFrame loginf;
	private JButton b1, b2;
	JTextField t1;
	JPasswordField t2;
	private JLabel l1, l2, l3, l4;
	private JPanel p;
	Connection conn;
	ResultSet rs;
	Statement stmt;

	Login() {

		try {
			
			Connection conn = DatabaseConnection.getConnection();
			JOptionPane.showMessageDialog(null, "Database Connected \n Sucessfully");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e);
		}
		l4 = new JLabel("Logedin Sucessfuly");
		// f1=new JFrame("Done");
		l3 = new JLabel("Login To Continue..!!");
		l1 = new JLabel("    User Id  ");
		l2 = new JLabel("Password");
		loginf = new JFrame("Login frame");
		p = new JPanel();
		loginf.add(p);
		b1 = new JButton(null, new ImageIcon("Images/login.gif"));

		b2 = new JButton(null, new ImageIcon("Images/cancle.png"));

		t1 = new JTextField(20);
		t2 = new JPasswordField(20);

		b1.setToolTipText("Click Here To Login");
		b2.setToolTipText("Click Here To Cancle");
		t1.setToolTipText("Enter the username here");
		t2.setToolTipText("Enter the password here");

		loginf.pack();
		p.setBackground(Color.LIGHT_GRAY);
		loginf.setSize(320, 150);
		p.setLayout(new FlowLayout());

		p.add(l1);
		p.add(t1);
		p.add(l2);
		p.add(t2);
		p.add(l3);
		p.add(b1);
		b1.addActionListener(this);
		p.add(b2);
		b2.addActionListener(this);
		t1.setText("admin");
		t2.setText("admin");

		loginf.setResizable(false);
		loginf.setResizable(false);
		loginf.setVisible(true);
		loginf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			int f;
			if (t1.getText().equals("admin") && t2.getText().equals("admin")) {
				JOptionPane.showMessageDialog(null, "Loged in Successfully \n as :- Administraror");
				loginf.dispose();
				f = 1;
				new Mainmenu(f);
			} else if (t1.getText().equals("") || t2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, " ENTER THE CORRECT LOGIN \n USERNAME AND PASSWORD");
			} else {

				int user = Integer.parseInt(t1.getText());
				String name;
				try {

					
					Connection conn = DatabaseConnection.getConnection();
					Statement stmt = conn.createStatement();
					ResultSet r = stmt.executeQuery("SELECT * FROM login WHERE userid=" + user);
					r.next();
					String pass = r.getString("password");
					name = r.getString("username");
					if (t2.getText().equals(pass)) {
						f = 2;
						JOptionPane.showMessageDialog(null, "Loged in Successfully \n as :- " + name);
						loginf.dispose();
						new Mainmenu(f);
					} else {
						JOptionPane.showMessageDialog(null, " ENTER THE CORRECT LOGIN \n USERNAME AND PASSWORD");
					}
					conn.close();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "NO SUCH USER PRESENT OR\n CHECK THE USERNAME AND PASSWORD");
				}
			}
		}

		if (ae.getSource() == b2) {
			int i = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO EXIT", "DO YOU WANT TO EXIT",
					JOptionPane.YES_NO_OPTION);
			if (i == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}

	public static void main(String args[]) {
		new Login();
	}
}