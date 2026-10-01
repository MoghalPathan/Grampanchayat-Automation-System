import javax.swing.*;
import java.awt.*;
import java.awt.Color.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class pankaj implements ActionListener {
	private JFrame birthf;
	private JButton b1, b2, b3, b4, b5;
	private JLabel l0, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
	private JPanel p;
	private JTextField t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12;
	String id;
	Connection conn;
	ResultSet rs;
	Statement stmt;

	public pankaj() {
		birthf = new JFrame("Birth Form !!");

		try {

			Connection conn = DatabaseConnection.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Birth");
			int count = 0;
			while (rs.next()) {
				count = Integer.parseInt(rs.getString(1));
			}
			count++;
			id = Integer.toString(count);
			conn.close();

		} catch (Exception e) {
			System.out.println("\n" + e);
		}

		l0 = new JLabel("  Bid       ", JLabel.LEFT);
		l1 = new JLabel("  B.Name ", JLabel.LEFT);
		l2 = new JLabel("   F.Name  ", JLabel.LEFT);
		l3 = new JLabel("  M.Name  ", JLabel.LEFT);
		l4 = new JLabel(" Birth Date   ", JLabel.LEFT);
		l5 = new JLabel("  Birth plc   ", JLabel.LEFT);
		l6 = new JLabel("  B.Group ", JLabel.LEFT);
		l7 = new JLabel("  B.Mark   ", JLabel.LEFT);
		l8 = new JLabel("   Gender    ", JLabel.LEFT);
		l12 = new JLabel(" HouseID ", JLabel.LEFT);
		l9 = new JLabel(" Street ", JLabel.LEFT);
		l10 = new JLabel(" Addr ", JLabel.LEFT);
		l11 = new JLabel(" Phone No ", JLabel.LEFT);
		birthf.setResizable(false);
		birthf.setSize(325, 320);
		birthf.setVisible(true);
		birthf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		p = new JPanel();
		// birthf.add(p);

		// p.setBackground(Color.RED);
		birthf.setLayout(new GridLayout(12, 2, 20, 20));
		// birthf.setLayout(new FlowLayout());
		b1 = new JButton("Save");
		b3 = new JButton("Cancle/Close");

		t0 = new JTextField(20);
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		t3 = new JTextField(20);
		t4 = new JTextField(20);
		t5 = new JTextField(20);
		t6 = new JTextField(20);
		t7 = new JTextField(20);
		t8 = new JTextField(20);
		t12 = new JTextField(20);
		t9 = new JTextField(20);
		t10 = new JTextField(20);
		t11 = new JTextField(20);

		birthf.add(l0);
		birthf.add(t0);
		t0.setText(id);
		t0.setEditable(false);
		birthf.add(l1);
		birthf.add(t1);
		birthf.add(l2);
		birthf.add(t2);
		birthf.add(l3);
		birthf.add(t3);
		birthf.add(l4);
		birthf.add(t4);
		birthf.add(l5);
		birthf.add(t5);
		birthf.add(l6);
		birthf.add(t6);
		birthf.add(l7);
		birthf.add(t7);
		birthf.add(l8);
		birthf.add(t8);
		birthf.add(l12);
		birthf.add(t12);
		birthf.add(l9);
		birthf.add(t9);
		birthf.add(l10);
		birthf.add(t10);
		birthf.add(l11);
		birthf.add(t11);

		birthf.setSize(500, 500);
		birthf.setDefaultCloseOperation(birthf.DISPOSE_ON_CLOSE);
		birthf.add(b1);
		b1.addActionListener(this);
		birthf.add(b3);
		b3.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ae) {

		// if "ADD" Button pressed

		if (ae.getSource() == b1) {
			if (t0.getText().equals("") || t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("")
					|| t4.getText().equals("") || t5.getText().equals("") || t6.getText().equals("")
					|| t7.getText().equals("") || t8.getText().equals("") || t12.getText().equals("")
					|| t9.getText().equals("") || t10.getText().equals("") || t11.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Recheck The Info & Enter The Info Again....");
			} else {
				try {
					int bid, phno, hid;// dd,mm,yy;
					String bdate, bname, fname, mname, bplace, bg, gen, bmark, street, addr;

					bid = Integer.parseInt(t0.getText());
					phno = Integer.parseInt(t11.getText());
					hid = Integer.parseInt(t12.getText());

					bname = t1.getText();
					fname = t2.getText();
					mname = t3.getText();
					bdate = t4.getText();
					bplace = t5.getText();
					bg = t6.getText();
					gen = t8.getText();
					bmark = t7.getText();
					street = t9.getText();
					addr = t10.getText();

					Connection conn = DatabaseConnection.getConnection();
					Statement stmt = conn.createStatement();
					int r = stmt.executeUpdate("INSERT INTO Birth " + "VALUES(" + bid + ",'" + bname + "','" + fname
							+ "','" + mname + "','" + bdate + "','" + bplace + "','" + bg + "','" + bmark + "','" + gen
							+ "'," + hid + ")");
					int r1 = stmt.executeUpdate("INSERT INTO Housing " + "VALUES(" + hid + ",'" + street + "','" + addr
							+ "'," + phno + ")");
					if ((r == 1) && (r1 == 1)) {
						JOptionPane.showMessageDialog(null, "Record Saved...!!!");
						bid++;

						String id = Integer.toString(bid);
						t0.setText(id);
						t1.setText("");
						t2.setText("");
						t3.setText("");
						t4.setText("");
						t5.setText("");
						t6.setText("");
						t7.setText("");
						t8.setText("");
						t9.setText("");
						t10.setText("");
						t11.setText("");

					} else {
						JOptionPane.showMessageDialog(null, "Error....!!!!");
					}
					conn.close();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "" + e);
				}
			}
		}

		// if "CANCLE " BUTTON presed

		if (ae.getSource() == b3) {
			int sel = JOptionPane.showConfirmDialog(null, "ARE YOU DONE", "ARE YOU SURE YOUR DONE",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (sel == JOptionPane.YES_OPTION) {
				birthf.dispose();
			}
		}
	}

	public static void main(String args[]) {
		new pankaj();
	}
}
