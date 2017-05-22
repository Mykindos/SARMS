package deakin.edu.au.sarms.guis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import datechooser.beans.DateChooserPanel;
import deakin.edu.au.sarms.accounts.User;
import deakin.edu.au.sarms.accounts.types.Lecturer;
import deakin.edu.au.sarms.accounts.types.Student;
import deakin.edu.au.sarms.attendance.Attendance;
import deakin.edu.au.sarms.attendance.AttendanceManager;
import deakin.edu.au.sarms.attendance.mysql.AttendanceRepository;
import deakin.edu.au.sarms.units.Unit;
import deakin.edu.au.sarms.utilities.UtilGUI;

/**
 * 
 * @author Tom Hoogstra - SIT215123867 (22/05/2017)
 *
 */


public class LecturerGUI extends JFrame {

	private JButton btnSetAbsent;
	private JButton btnSetPresent;
	private JComboBox<Student> cmbPickStudent;
	private JComboBox<?> cmbSelectUnit;
	private DateChooserPanel datePickDay;
	private JLabel lblAttendanceStatus;
	private JLabel lblAttended;
	private JLabel lblHeader;
	private JLabel lblPickStudent;
	private JLabel lblPickUnit;
	private JPanel pnlAttendance;
	private JPanel pnlSubAttendance;
	private JTabbedPane tabMain;
	private DateFormat df;


	private Lecturer lecturer;

	/**
	 * Creates new form LoginGUI
	 */
	public LecturerGUI(Lecturer lecturer) {
		setVisible(true);
		this.lecturer = lecturer;
		df = new SimpleDateFormat("dd/MM/yyy");
		initialize();

	}


	private void initialize() {

		lblHeader = new JLabel();
		tabMain = new JTabbedPane();
		pnlAttendance = new JPanel();
		lblPickUnit = new JLabel();
		cmbSelectUnit = new JComboBox<>(UtilGUI.getList(lecturer.getLecturerUnits()));
		pnlSubAttendance = new JPanel();
		btnSetAbsent = new JButton();
		btnSetPresent = new JButton();
		lblAttended = new JLabel();
		lblAttendanceStatus = new JLabel();
		cmbPickStudent = new JComboBox<>();
		lblPickStudent = new JLabel();
		datePickDay = new DateChooserPanel();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("SARMS");
		getContentPane().setMaximumSize(new Dimension(750, 400));
		getContentPane().setMinimumSize(new Dimension(750, 400));
		getContentPane(). setPreferredSize(new Dimension(750, 400));
		getContentPane().setLayout(null);

		lblHeader.setBackground(new Color(51, 255, 255));
		lblHeader.setFont(new Font("Tahoma", 1, 24));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setText("SARMS");
		lblHeader.setBorder(BorderFactory.createEtchedBorder());
		lblHeader.setOpaque(true);
		getContentPane().add(lblHeader);
		lblHeader.setBounds(0, 0, 750, 80);

		pnlAttendance.setLayout(null);

		lblPickUnit.setFont(new Font("Tahoma", 1, 18)); // NOI18N
		lblPickUnit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPickUnit.setText("Pick Unit:");
		pnlAttendance.add(lblPickUnit);
		lblPickUnit.setBounds(10, 10, 110, 30);

		pnlAttendance.add(cmbSelectUnit);
		cmbSelectUnit.setBounds(130, 10, 590, 30);
		cmbSelectUnit.addActionListener(e -> loadStudents());

		pnlSubAttendance.setBorder(BorderFactory.createEtchedBorder());
		pnlSubAttendance.setLayout(null);

		btnSetAbsent.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		btnSetAbsent.setText("Absent");
		btnSetAbsent.addActionListener(e -> updateAttendance(false));
		pnlSubAttendance.add(btnSetAbsent);
		btnSetAbsent.setBounds(570, 130, 120, 80);

		btnSetPresent.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		btnSetPresent.setText("Present");
		btnSetPresent.addActionListener(e -> updateAttendance(true));
		pnlSubAttendance.add(btnSetPresent);
		btnSetPresent.setBounds(430, 130, 120, 80);

		lblAttended.setFont(new Font("Tahoma", 1, 11)); // NOI18N
		lblAttended.setHorizontalAlignment(SwingConstants.LEFT);
		pnlSubAttendance.add(lblAttended);
		lblAttended.setBounds(390, 70, 330, 40);

		lblAttendanceStatus.setFont(new Font("Tahoma", 1, 12)); // NOI18N
		lblAttendanceStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAttendanceStatus.setText("Attendance:");
		pnlSubAttendance.add(lblAttendanceStatus);
		lblAttendanceStatus.setBounds(290, 70, 90, 40);

		pnlSubAttendance.add(cmbPickStudent);
		cmbPickStudent.setBounds(390, 20, 330, 30);
		cmbPickStudent.addActionListener(e -> showAttendance());

		lblPickStudent.setFont(new Font("Tahoma", 1, 14)); // NOI18N
		lblPickStudent.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPickStudent.setText("Pick Student:");
		pnlSubAttendance.add(lblPickStudent);
		lblPickStudent.setBounds(260, 20, 120, 30);
		pnlSubAttendance.add(datePickDay);
		datePickDay.setBounds(10, 20, 230, 190);

		pnlAttendance.add(pnlSubAttendance);
		pnlSubAttendance.setBounds(10, 50, 730, 240);

		tabMain.addTab("Manage Attendance", pnlAttendance);

		getContentPane().add(tabMain);
		tabMain.setBounds(0, 80, 750, 320);

		datePickDay.addSelectionChangedListener(e -> showAttendance());

		loadStudents();

		pack();
	}          

	private void loadStudents(){
		Unit unit = (Unit) cmbSelectUnit.getSelectedItem();
		cmbPickStudent.removeAllItems();

		unit.getStudents().forEach(s -> {
			cmbPickStudent.addItem(s);
		});
	}



	/**
	 * Displays whether the user was present to the unit on the
	 * specified date
	 */
	private void showAttendance(){
		Date date = datePickDay.getSelectedDate().getTime();
		User user = (User) cmbPickStudent.getSelectedItem();
		Unit unit = (Unit) cmbSelectUnit.getSelectedItem();

		Attendance attendance = AttendanceManager.getAttendanceSUT(user, unit, date);
		if(attendance != null){
			lblAttended.setText(attendance.wasPresent() ? "Present" : "Absent");
		}else{
			Attendance ad = new Attendance(UUID.randomUUID().toString(), 
					unit.getUnitID(), user.getUserID(), df.format(date));
			ad.setAttendance(false);

			if(!AttendanceManager.alreadySaved(ad)){
				AttendanceRepository.saveAttendance(ad);
				AttendanceManager.addAttendance(ad);
			}


			lblAttended.setText("Absent");
		}
	}

	
	/**
	 * Change whether user was marked as present or absent
	 * Updates in database also
	 * @param present Whether the user was present to class
	 */
	private void updateAttendance(boolean present){
		Date date = datePickDay.getSelectedDate().getTime();
		User user = (User) cmbPickStudent.getSelectedItem();
		Unit unit = (Unit) cmbSelectUnit.getSelectedItem();

		Attendance attendance = AttendanceManager.getAttendanceSUT(user, unit, date);
		attendance.setAttendance(present);
		
		AttendanceRepository.updateAttendance(attendance.getAttendanceID(), present);
		
		lblAttended.setText(attendance.wasPresent() ? "Present" : "Absent");
	}



}