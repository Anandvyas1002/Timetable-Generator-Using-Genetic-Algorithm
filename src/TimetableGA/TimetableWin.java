/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimetableGA;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.TableColumn;

/**
 *
 * @author Anand
 */
public class TimetableWin  extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
//	private JLabel label = new JLabel("ÇëÔÚMainÀàÖÐÐÞ¸ÄÅäÖÃ²ÎÊý£¬ÐÞ¸ÄºóÖØÐÂÆô¶¯³ÌÐò£¬ÐÂµÄ¿Î³Ì°²ÅÅ½á¹û½«ÏÔÊ¾");
	JTable lecTable = null;
	JButton export = new JButton("print");
	String[][] cellData = { { "9:00------10:00", "", "", "", "", "", "", "","" }, { "10:00------11:00", "","", "", "", "", "", "", "" },
			{ "11:00------12:00", "", "", "", "", "", "", "","" }, { "12:00-13:00(break)", "", "", "", "", "","", "", "" },
			{ "13:00------14:00", "", "", "", " ", "", "", "","" }, { "14:00------15:00", "", "","", "", " ", "", "", "" },
			{ "15:00------16:00", "", "", "", " ", "", "", "","" } };
	String[] colums = { "Times", "Mon", "Tue", "Wed", "Thu", "Fri","Sat"};

	public JPanel southPanel() {
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout());
//		southPanel.add(label);
		southPanel.add(export);
		export.addActionListener(this);
		return southPanel;
	}

	public TimetableWin() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		String lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
		UIManager.setLookAndFeel(lookAndFeel);
		lecTable = new JTable(cellData, colums);
		lecTable.setDragEnabled(false);
		lecTable.setEnabled(false);
		//
		TableColumn firsetColumn = lecTable.getColumnModel().getColumn(0);
		firsetColumn.setPreferredWidth(150);
		firsetColumn.setMaxWidth(150);
		firsetColumn.setMinWidth(150);

		for (int i = 1; i < colums.length; i++) {
			TableColumn Column = lecTable.getColumnModel().getColumn(i);
			Column.setPreferredWidth(150);
			Column.setMaxWidth(150);
			Column.setMinWidth(150);
		}
		lecTable.setRowHeight(60);
		lecTable.setPreferredScrollableViewportSize(new Dimension(1020, 250));
		JScrollPane scrollPane = new JScrollPane(lecTable);
		this.getContentPane().add(scrollPane, BorderLayout.CENTER);
		this.getContentPane().add(southPanel(), BorderLayout.SOUTH);
		this.setTitle("Timetable");
		this.setVisible(true);
		this.setSize(920, 500);
		GUIUtil.toCenter(this);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// initializeCS();
	}
	// private void initializeCS() {
	// TableModel tableModel = lecTable.getModel();
	// }

	// public static void main(String[] args)
	// throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
	// new TimetableWin();
	// }

	public void fillClass(Class bestClass, Timetable timetable) {
		String timeslot = timetable.getTimeslot(bestClass.getTimeslotId()).getTimeslot();
		int group = timetable.getGroup(bestClass.getGroupId()).getGroupId();
		String course = timetable.getModule(bestClass.getModuleId()).getcourseName();
		String lecturer = timetable.getlecturer(bestClass.getlecturerId()).getLecturerName();
		String room = timetable.getRoom(bestClass.getRoomId()).getRoomNumber();
		String info = "<html>Group:" + group + "<br>" + course + "<br>Lecturer:" + lecturer + "<br>Room:" + room + "</html>";
		int row = getRowNum(timeslot);
		if (timeslot.startsWith("Mon")) {
			lecTable.setValueAt(info, row, 1);
		} else if (timeslot.startsWith("Tue")) {
			lecTable.setValueAt(info, row, 2);
		} else if (timeslot.startsWith("Wed")) {
			lecTable.setValueAt(info, row, 3);
		} else if (timeslot.startsWith("Thu")) {
			lecTable.setValueAt(info, row, 4);
		} else if (timeslot.startsWith("Fri")) {
			lecTable.setValueAt(info, row, 5);
		}
		else if (timeslot.startsWith("Sat")) {
			lecTable.setValueAt(info, row, 6);
		}
	}

	private int getRowNum(String timeslot) {
		int row = -1;
		String trimmedTimeslot = timeslot.split(" ")[1];
		if (trimmedTimeslot.startsWith("9:00")) {
			row = 0;
		} else if (trimmedTimeslot.startsWith("10:00")) {
			row = 1;
		} else if (trimmedTimeslot.startsWith("11:00")) {
			row = 2;
		} else if (trimmedTimeslot.startsWith("13:00")) {
			row = 4;
		} else if (trimmedTimeslot.startsWith("14:00")) {
			row = 5;
		} else if (trimmedTimeslot.startsWith("15:00")) {
			row = 6;
		}
		return row;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == export) {
			File file = new File(this.getTitle().split(" ")[1]);
			String fi = file.getAbsolutePath() + ".csv";
			System.out.println(file);
			FileWriter out = null;
			try {
				out = new FileWriter(fi);
				for (int i = 0; i < lecTable.getColumnCount(); i++) {
					out.write(lecTable.getColumnName(i) + ",");
				}
				out.write("\n");
				for (int i = 0; i < lecTable.getRowCount(); i++) {
					for (int j = 0; j < lecTable.getColumnCount(); j++) {
						out.write(delHTMLTag(lecTable.getValueAt(i, j).toString()) + ",");
					}
					out.write("\n");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				try {
					out.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			JOptionPane.showMessageDialog(null, "success");
		}
	}

	public String delHTMLTag(String htmlStr) {
		// htmlStr = htmlStr.replaceFirst("<html>", "\"");
		// htmlStr = htmlStr.replaceFirst("<\\html>", "\"");
		// htmlStr = htmlStr.replaceFirst("<br>", "\n");
		String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // ¶¨ÒåscriptµÄÕýÔò±í´ïÊ½
		String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // ¶¨ÒåstyleµÄÕýÔò±í´ïÊ½
		String regEx_html = "<[^>]+>"; // ¶¨ÒåHTML±êÇ©µÄÕýÔò±í´ïÊ½

		Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
		Matcher m_script = p_script.matcher(htmlStr);
		htmlStr = m_script.replaceAll(" "); // ¹ýÂËscript±êÇ©

		Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
		Matcher m_style = p_style.matcher(htmlStr);
		htmlStr = m_style.replaceAll(" "); // ¹ýÂËstyle±êÇ©

		Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(htmlStr);
		htmlStr = m_html.replaceAll(" "); // ¹ýÂËhtml±êÇ©

		return htmlStr.trim(); // ·µ»ØÎÄ±¾×Ö·û´®
	}
}
