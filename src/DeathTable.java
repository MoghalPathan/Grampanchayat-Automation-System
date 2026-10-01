import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;

public class DeathTable extends JFrame {
	Container c;
	Connection conn;
	ResultSet rs;
	PreparedStatement psmt;
	JLabel lbl_search;
	JTextField txt_search;
	JButton cmd_search;
	JButton cmd_exit;

	public DeathTable() {
		c = getContentPane();

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		try {

			// set Dsn name (empData) to a odbcad32
			conn = DatabaseConnection.getConnection();

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "" + e1);
		}
		// String id="e007";

		String colname[] = { "Id", "Name", "date", "month", "year", "age", "place", "catag.", "decise", "info" };
		Vector v1 = getBirth();
		String data[][] = new String[v1.size()][10];
		for (int i = 0; i < v1.size(); i++) {
			DeathDetails e = (DeathDetails) v1.elementAt(i);
			data[i][0] = e.Id;
			data[i][1] = e.Name;
			data[i][2] = e.date;
			data[i][3] = e.month;
			data[i][4] = e.year;
			data[i][5] = e.age;
			data[i][6] = e.place;
			data[i][7] = e.catag;
			data[i][8] = e.decise;
			data[i][9] = e.info;

		}

		JTable jt = new JTable(data, colname);
		jt.setBackground(Color.LIGHT_GRAY);
		/*
		 * //Thus Function is for Coloring to Particular Column TableColumn tm =
		 * jt.getColumnModel().getColumn(0); tm.setCellRenderer(new
		 * ColorColumnRenderer(Color.pink, Color.blue));
		 * 
		 */
		JScrollPane jsp = new JScrollPane(jt, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		c.add(jsp);

		setVisible(true);
		setResizable(false);
		setTitle("Death Detail");
		setSize(1000, 400);

	}

	public Vector getBirth() {
		Vector v = new Vector();
		try {
			psmt = conn.prepareStatement("select * from death");
			// psmt.setString(1,id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				// Constructor for Birth_Details Class used only for store value on different
				// varaible
				DeathDetails e = new DeathDetails();

				e.Id = rs.getString(1);
				e.Name = rs.getString(2);

				e.date = rs.getString(3);

				e.month = rs.getString(4);

				e.year = rs.getString(5);

				e.age = rs.getString(6);

				e.place = rs.getString(7);

				e.catag = rs.getString(8);

				e.decise = rs.getString(9);

				e.info = rs.getString(10);

				v.add(e);
			}
			conn.close();
		} catch (Exception e3) {
		}
		return v;

	}
}
