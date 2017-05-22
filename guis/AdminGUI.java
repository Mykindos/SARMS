package deakin.edu.au.sarms.guis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.UUID;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import deakin.edu.au.sarms.accounts.User;
import deakin.edu.au.sarms.accounts.User.Status;
import deakin.edu.au.sarms.accounts.UserManager;
import deakin.edu.au.sarms.accounts.mysql.AccountRepository;
import deakin.edu.au.sarms.accounts.types.Administrator;
import deakin.edu.au.sarms.accounts.types.Lecturer;
import deakin.edu.au.sarms.accounts.types.Student;
import deakin.edu.au.sarms.units.Enrolment;
import deakin.edu.au.sarms.units.Unit;
import deakin.edu.au.sarms.units.UnitManager;
import deakin.edu.au.sarms.units.mysql.UnitRepository;
import deakin.edu.au.sarms.utilities.UtilGUI;

public class AdminGUI extends JFrame {
	
	
	private ButtonGroup bgUnitMembers;
    private JButton btnCreateAccount;
    private JButton btnCreateUnit;
    private JButton btnDeleteAccount;
    private JButton btnDeleteUnit;
    private JButton btnSaveAccount;
    private JButton btnSaveUnit;
    private JButton btnSearchAccount;
    private JButton btnSearchByUsername;
    private JButton btnSearchUnit;
    private JButton btnSearchUnitByCode;
    private JButton btnSubmitEnrolment;
    private JComboBox<String> cmbCreateRoles;
    private JComboBox<String> cmbEnrolAs;
    private JComboBox cmbSearchRole;
    private JComboBox<?> cmbSelectUnit;
    private JComboBox<?> cmbSelectAccount;
    private JComboBox cmbStatus;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JLabel lblCreateFirstName;
    private JLabel lblCreateLastName;
    private JLabel lblCreatePassword;
    private JLabel lblCreateRole;
    private JLabel lblCreateUsername;
    private JLabel lblEnrolAs;
    private JLabel lblHeader;
    private JLabel lblORAccount;
    private JLabel lblORUnit;
    private JLabel lblSearchFirstName;
    private JLabel lblSearchLastName;
    private JLabel lblSearchPassword;
    private JLabel lblSearchRole;
    private JLabel lblSearchUnit;
    private JLabel lblSearchUsername;
    private JLabel lblSelectAccount;
    private JLabel lblSelectAccountTitle;
    private JLabel lblSelectUnit;
    private JLabel lblSelectUnitTitle;
    private JLabel lblUnitCode;
    private JLabel lblUnitName;
    private JLabel lblUnitSearchCode;
    private JLabel lblUsernameSearch;
    private JPanel pnlCreateAccounts;
    private JPanel pnlCreateUnit;
    private JPanel pnlEditAccounts;
    private JPanel pnlSearch;
    private JPanel pnlUnitInfo;
    private JPanel pnlUnitMembers;
    private JRadioButton rbEnrolAccount;
    private JRadioButton rbUnEnrolAccount;
    private JTabbedPane tabMain;
    private JFormattedTextField txtCreateFirstName;
    private JFormattedTextField txtCreateLastName;
    private JPasswordField txtCreatePassword;
    private JFormattedTextField txtCreateUsername;
    private JFormattedTextField txtSearchByUsername;
    private JFormattedTextField txtSearchFirstName;
    private JFormattedTextField txtSearchLastName;
    private JPasswordField txtSearchPassword;
    private JFormattedTextField txtSearchUnit;
    private JFormattedTextField txtSearchUnitCode;
    private JFormattedTextField txtSearchUsername;
    private JLabel txtSelectUsername;
    private JFormattedTextField txtUnitCode;
    private JFormattedTextField txtUnitName;
    private JFormattedTextField txtUsernameSearch;

    /**
     * Creates new form LoginGUI
     */
    public AdminGUI() {
        setVisible(true);
        initialize();
        setResizable(false);
    }

    @SuppressWarnings("unchecked")                        
    private void initialize() {

        bgUnitMembers = new ButtonGroup();
        lblHeader = new JLabel();
        tabMain = new JTabbedPane();
        pnlCreateAccounts = new JPanel();
        lblCreateUsername = new JLabel();
        txtCreateUsername = new JFormattedTextField();
        lblCreatePassword = new JLabel();
        txtCreatePassword = new JPasswordField();
        lblCreateFirstName = new JLabel();
        txtCreateFirstName = new JFormattedTextField();
        txtCreateLastName = new JFormattedTextField();
        lblCreateLastName = new JLabel();
        lblCreateRole = new JLabel();
        cmbCreateRoles = new JComboBox<>();
        btnCreateAccount = new JButton();
        pnlEditAccounts = new JPanel();
        lblUsernameSearch = new JLabel();
        txtUsernameSearch = new JFormattedTextField();
        btnSearchAccount = new JButton();
        pnlSearch = new JPanel();
        lblSearchFirstName = new JLabel();
        txtSearchPassword = new JPasswordField();
        txtSearchUsername = new JFormattedTextField();
        lblSearchUsername = new JLabel();
        lblSearchPassword = new JLabel();
        lblSearchLastName = new JLabel();
        txtSearchLastName = new JFormattedTextField();
        txtSearchFirstName = new JFormattedTextField();
        cmbSearchRole = new JComboBox<>();
        lblSearchRole = new JLabel();
        btnSaveAccount = new JButton();
        jLabel1 = new JLabel();
        cmbStatus = new JComboBox<>();
        btnDeleteAccount = new JButton();
        pnlCreateUnit = new JPanel();
        lblSearchUnit = new JLabel();
        txtSearchUnit = new JFormattedTextField();
        btnSearchUnit = new JButton();
        pnlUnitInfo = new JPanel();
        lblUnitName = new JLabel();
        txtUnitName = new JFormattedTextField();
        lblUnitCode = new JLabel();
        txtUnitCode = new JFormattedTextField();
        btnDeleteUnit = new JButton();
        btnCreateUnit = new JButton();
        btnSaveUnit = new JButton();
        pnlUnitMembers = new JPanel();
        lblSelectUnitTitle = new JLabel();
        lblORUnit = new JLabel();
        lblUnitSearchCode = new JLabel();
        txtSearchUnitCode = new JFormattedTextField();
        lblSelectUnit = new JLabel();
        btnSearchUnitByCode = new JButton();
        cmbSelectUnit = new JComboBox<>(UtilGUI.getList(UnitManager.unitList));
        jPanel1 = new JPanel();
        lblSelectAccount = new JLabel();
        txtSelectUsername = new JLabel();
        txtSearchByUsername = new JFormattedTextField();
        lblORAccount = new JLabel();
        cmbSelectAccount = new JComboBox<>(UtilGUI.getList(UserManager.userList));
        btnSearchByUsername = new JButton();
        lblSelectAccountTitle = new JLabel();
        rbEnrolAccount = new JRadioButton();
        rbUnEnrolAccount = new JRadioButton();
        lblEnrolAs = new JLabel();
        cmbEnrolAs = new JComboBox<>();
        btnSubmitEnrolment = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("SARMS");
        
        getContentPane().setLayout(null);
        getContentPane().setMaximumSize(new Dimension(750, 400));
        getContentPane().setMinimumSize(new Dimension(750, 400));
        getContentPane(). setPreferredSize(new Dimension(750, 400));

        lblHeader.setBackground(new Color(51, 255, 255));
        lblHeader.setFont(new Font("Tahoma", 1, 24)); // NOI18N
        lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeader.setText("SARMS Administrator");
        lblHeader.setBorder(BorderFactory.createEtchedBorder());
        lblHeader.setOpaque(true);
        getContentPane().add(lblHeader);
        lblHeader.setBounds(0, 0, 750, 80);

        pnlCreateAccounts.setLayout(null);

        lblCreateUsername.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        lblCreateUsername.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCreateUsername.setText("Username:");
        lblCreateUsername.setToolTipText("");
        pnlCreateAccounts.add(lblCreateUsername);
        lblCreateUsername.setBounds(20, 110, 90, 30);
        txtCreateUsername.setNextFocusableComponent(txtCreatePassword);
        pnlCreateAccounts.add(txtCreateUsername);
        txtCreateUsername.setBounds(120, 110, 150, 30);

        lblCreatePassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCreatePassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCreatePassword.setText("Password:");
        pnlCreateAccounts.add(lblCreatePassword);
        lblCreatePassword.setBounds(10, 150, 100, 30);

        txtCreatePassword.setNextFocusableComponent(cmbCreateRoles);
        pnlCreateAccounts.add(txtCreatePassword);
        txtCreatePassword.setBounds(120, 150, 150, 30);

        lblCreateFirstName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCreateFirstName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCreateFirstName.setText("First Name:");
        pnlCreateAccounts.add(lblCreateFirstName);
        lblCreateFirstName.setBounds(20, 20, 90, 30);

        txtCreateFirstName.setNextFocusableComponent(txtCreateLastName);
        pnlCreateAccounts.add(txtCreateFirstName);
        txtCreateFirstName.setBounds(120, 20, 150, 30);

        txtCreateLastName.setNextFocusableComponent(txtCreateUsername);
        pnlCreateAccounts.add(txtCreateLastName);
        txtCreateLastName.setBounds(120, 60, 150, 30);

        lblCreateLastName.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        lblCreateLastName.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCreateLastName.setText("Last Name:");
        pnlCreateAccounts.add(lblCreateLastName);
        lblCreateLastName.setBounds(10, 60, 100, 30);

        lblCreateRole.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        lblCreateRole.setText("Role:");
        pnlCreateAccounts.add(lblCreateRole);
        lblCreateRole.setBounds(340, 30, 50, 20);

        pnlCreateAccounts.add(cmbCreateRoles);
        cmbCreateRoles.setBounds(390, 20, 250, 40);
        cmbCreateRoles.setModel(new DefaultComboBoxModel(new String[] { "Student", "Lecturer", "Administrator" }));

        btnCreateAccount.setText("Create");
        pnlCreateAccounts.add(btnCreateAccount);
        btnCreateAccount.setBounds(420, 220, 160, 50);
        btnCreateAccount.addActionListener(e -> createAccount());

        tabMain.addTab("Create Account", pnlCreateAccounts);

        pnlEditAccounts.setLayout(null);

        lblUsernameSearch.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        lblUsernameSearch.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUsernameSearch.setText("Search Username:");
        pnlEditAccounts.add(lblUsernameSearch);
        lblUsernameSearch.setBounds(30, 20, 150, 30);
        pnlEditAccounts.add(txtUsernameSearch);
        txtUsernameSearch.setBounds(190, 20, 300, 30);

        btnSearchAccount.setText("Search");
        btnSearchAccount.addActionListener(e -> searchAccount());
        pnlEditAccounts.add(btnSearchAccount);
        btnSearchAccount.setBounds(530, 20, 110, 30);

        pnlSearch.setBorder(BorderFactory.createEtchedBorder());
        pnlSearch.setLayout(null);

        lblSearchFirstName.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        lblSearchFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSearchFirstName.setText("First Name:");
        pnlSearch.add(lblSearchFirstName);
        lblSearchFirstName.setBounds(30, 20, 90, 30);
        pnlSearch.add(txtSearchPassword);
        txtSearchPassword.setBounds(130, 150, 150, 30);
        pnlSearch.add(txtSearchUsername);
        txtSearchUsername.setBounds(130, 110, 150, 30);

        lblSearchUsername.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        lblSearchUsername.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSearchUsername.setText("Username:");
        lblSearchUsername.setToolTipText("");
        pnlSearch.add(lblSearchUsername);
        lblSearchUsername.setBounds(30, 110, 90, 30);

        lblSearchPassword.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        lblSearchPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSearchPassword.setText("Password:");
        pnlSearch.add(lblSearchPassword);
        lblSearchPassword.setBounds(20, 150, 100, 30);

        lblSearchLastName.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        lblSearchLastName.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSearchLastName.setText("Last Name:");
        pnlSearch.add(lblSearchLastName);
        lblSearchLastName.setBounds(20, 60, 100, 30);
        pnlSearch.add(txtSearchLastName);
        txtSearchLastName.setBounds(130, 60, 150, 30);
        pnlSearch.add(txtSearchFirstName);
        txtSearchFirstName.setBounds(130, 20, 150, 30);
        cmbSearchRole.setModel(new DefaultComboBoxModel(new String[] { "Student", "Lecturer", "Administrator" }));
        pnlSearch.add(cmbSearchRole);
        
        cmbSearchRole.setBounds(400, 20, 250, 40);

        lblSearchRole.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        lblSearchRole.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSearchRole.setText("Role:");
        pnlSearch.add(lblSearchRole);
        lblSearchRole.setBounds(350, 30, 40, 20);

        btnSaveAccount.setText("Save");
        btnSaveAccount.addActionListener(e -> saveAccountEdit());
        pnlSearch.add(btnSaveAccount);
        btnSaveAccount.setBounds(400, 140, 100, 50);

        jLabel1.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel1.setText("Status:");
        pnlSearch.add(jLabel1);
        jLabel1.setBounds(330, 90, 60, 20);

        cmbStatus.setModel(new DefaultComboBoxModel(new String[] { "Active", "Expired", "Locked", "Disabled" }));
        cmbStatus.setToolTipText("");
        pnlSearch.add(cmbStatus);
        cmbStatus.setBounds(400, 80, 250, 40);

        btnDeleteAccount.setText("Delete");
        btnDeleteAccount.addActionListener(e -> deleteAccount());
        pnlSearch.add(btnDeleteAccount);
        btnDeleteAccount.setBounds(550, 140, 100, 50);

        pnlEditAccounts.add(pnlSearch);
        
        pnlSearch.setBounds(10, 70, 720, 210);

        tabMain.addTab("Edit Account", pnlEditAccounts);

        pnlCreateUnit.setLayout(null);

        lblSearchUnit.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        lblSearchUnit.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSearchUnit.setText("Search Unit:");
        pnlCreateUnit.add(lblSearchUnit);
        lblSearchUnit.setBounds(90, 10, 90, 30);
        pnlCreateUnit.add(txtSearchUnit);
        txtSearchUnit.setBounds(190, 10, 320, 30);

        btnSearchUnit.setText("Search");
        btnSearchUnit.addActionListener(e -> searchUnit());
        pnlCreateUnit.add(btnSearchUnit);
        btnSearchUnit.setBounds(520, 10, 100, 30);

        pnlUnitInfo.setBorder(BorderFactory.createEtchedBorder());
        pnlUnitInfo.setLayout(null);

        lblUnitName.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        lblUnitName.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUnitName.setText("Unit Name:");
        pnlUnitInfo.add(lblUnitName);
        lblUnitName.setBounds(30, 70, 120, 30);
        pnlUnitInfo.add(txtUnitName);
        txtUnitName.setBounds(170, 70, 300, 30);

        lblUnitCode.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        lblUnitCode.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUnitCode.setText("Unit Code:");
        pnlUnitInfo.add(lblUnitCode);
        lblUnitCode.setBounds(70, 120, 80, 30);
        pnlUnitInfo.add(txtUnitCode);
        txtUnitCode.setBounds(170, 120, 300, 30);

        btnDeleteUnit.setText("Delete");
        btnDeleteUnit.addActionListener(e -> deleteUnit());
        pnlUnitInfo.add(btnDeleteUnit);
        btnDeleteUnit.setBounds(520, 150, 180, 60);

        btnCreateUnit.setText("Create");
        pnlUnitInfo.add(btnCreateUnit);
        btnCreateUnit.setBounds(520, 10, 180, 60);
        btnCreateUnit.addActionListener(e -> createUnit());

        btnSaveUnit.setText("Save");
        btnSaveUnit.addActionListener(e -> editUnit());
        pnlUnitInfo.add(btnSaveUnit);
        btnSaveUnit.setBounds(520, 80, 180, 60);

        pnlCreateUnit.add(pnlUnitInfo);
        pnlUnitInfo.setBounds(10, 60, 730, 230);

        tabMain.addTab("Create / Edit Units", pnlCreateUnit);

        pnlUnitMembers.setLayout(null);
        lblSelectUnitTitle.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        lblSelectUnitTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblSelectUnitTitle.setText("Select a Unit");
        pnlUnitMembers.add(lblSelectUnitTitle);
        lblSelectUnitTitle.setBounds(10, 20, 400, 30);

        lblORUnit.setHorizontalAlignment(SwingConstants.CENTER);
        lblORUnit.setText("OR");
        pnlUnitMembers.add(lblORUnit);
        lblORUnit.setBounds(10, 90, 400, 14);

        lblUnitSearchCode.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUnitSearchCode.setText("Unit Code:");
        pnlUnitMembers.add(lblUnitSearchCode);
        lblUnitSearchCode.setBounds(10, 50, 60, 30);
        pnlUnitMembers.add(txtSearchUnitCode);
        txtSearchUnitCode.setBounds(70, 50, 250, 30);

        lblSelectUnit.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSelectUnit.setText("Select Unit:");
        pnlUnitMembers.add(lblSelectUnit);
        lblSelectUnit.setBounds(0, 110, 70, 40);

        btnSearchUnitByCode.setText("Search");
        btnSearchUnitByCode.addActionListener(e -> searchUnitEnrol());
        pnlUnitMembers.add(btnSearchUnitByCode);
        btnSearchUnitByCode.setBounds(330, 50, 80, 30);

        pnlUnitMembers.add(cmbSelectUnit);
        cmbSelectUnit.setBounds(70, 110, 340, 40);

        jPanel1.setBorder(BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        lblSelectAccount.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSelectAccount.setText("Select Account:");
        jPanel1.add(lblSelectAccount);
        lblSelectAccount.setBounds(0, 100, 90, 40);

        txtSelectUsername.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSelectUsername.setText("Username:");
        jPanel1.add(txtSelectUsername);
        txtSelectUsername.setBounds(10, 40, 80, 30);
        jPanel1.add(txtSearchByUsername);
        txtSearchByUsername.setBounds(90, 40, 100, 30);

        lblORAccount.setHorizontalAlignment(SwingConstants.CENTER);
        lblORAccount.setText("OR");
        jPanel1.add(lblORAccount);
        lblORAccount.setBounds(30, 80, 250, 14);

        jPanel1.add(cmbSelectAccount);
        cmbSelectAccount.setBounds(90, 100, 190, 40);

        btnSearchByUsername.setText("Search");
        btnSearchByUsername.addActionListener(e -> searchByUsername());
        jPanel1.add(btnSearchByUsername);
        btnSearchByUsername.setBounds(200, 40, 80, 30);

        lblSelectAccountTitle.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        lblSelectAccountTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblSelectAccountTitle.setText("Select an Account");
        jPanel1.add(lblSelectAccountTitle);
        lblSelectAccountTitle.setBounds(30, 10, 250, 30);

        bgUnitMembers.add(rbEnrolAccount);
        rbEnrolAccount.setSelected(true);
        rbEnrolAccount.setText("Enrol");
        jPanel1.add(rbEnrolAccount);
        rbEnrolAccount.setBounds(10, 160, 60, 23);

        bgUnitMembers.add(rbUnEnrolAccount);
        rbUnEnrolAccount.setText("Un-Enrol");
        jPanel1.add(rbUnEnrolAccount);
        rbUnEnrolAccount.setBounds(10, 190, 80, 23);

        lblEnrolAs.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        lblEnrolAs.setText("Enrol as:");
        jPanel1.add(lblEnrolAs);
        lblEnrolAs.setBounds(100, 160, 60, 40);

        cmbEnrolAs.setModel(new DefaultComboBoxModel(new String[] { "Student", "Lecturer" }));
        jPanel1.add(cmbEnrolAs);
        cmbEnrolAs.setBounds(170, 160, 120, 40);

        btnSubmitEnrolment.setText("Submit");
        btnSubmitEnrolment.addActionListener(e -> submitEnrolment());
        jPanel1.add(btnSubmitEnrolment);
        btnSubmitEnrolment.setBounds(100, 230, 190, 40);

        pnlUnitMembers.add(jPanel1);
        jPanel1.setBounds(430, 10, 310, 280);

        tabMain.addTab("Unit Members", pnlUnitMembers);

        getContentPane().add(tabMain);
        tabMain.setBounds(0, 80, 750, 320);
        UtilGUI.togglePanel(pnlSearch, false);
        pack();
    }         
    
    private void createAccount(){
    	String username = txtCreateUsername.getText();
    	String password = String.valueOf(txtCreatePassword.getPassword());
    	String firstName = txtCreateFirstName.getText();
    	String lastName = txtCreateLastName.getText();
    	String role = cmbCreateRoles.getSelectedItem().toString();
    	
    	if(role.equalsIgnoreCase("Administrator")){
    		Administrator admin = new Administrator(UUID.randomUUID().toString(), username, password,
    				firstName, lastName, Status.ACTIVE);
    		UserManager.addUser(admin);
    		AccountRepository.saveUser(admin, role);
    	}else if(role.equalsIgnoreCase("Lecturer")){
    		Lecturer lecturer = new Lecturer(UUID.randomUUID().toString(), username, password,
    				firstName, lastName, Status.ACTIVE);
    		UserManager.addUser(lecturer);
    		AccountRepository.saveUser(lecturer, role);
    	}else{
    		Student student = new Student(UUID.randomUUID().toString(), username, password,
    				firstName, lastName, Status.ACTIVE);
    		UserManager.addUser(student);
    		AccountRepository.saveUser(student, role);
    	}
    	
    	JOptionPane.showMessageDialog(null, "Account Created!");
    	
    	
    }
    
    private void searchAccount(){
    	String search = txtUsernameSearch.getText();
    	User user = UserManager.getUserByUsername(search);
    	if(user != null){
    		UtilGUI.togglePanel(pnlSearch, true);
    		txtSearchFirstName.setText(user.getFirstName());
    		txtSearchLastName.setText(user.getLastName());
    		txtSearchUsername.setText(search);
    		txtSearchPassword.setText(user.getPassword());
    		if(user instanceof Student){
    			cmbSearchRole.setSelectedItem("Student");
    		}else if(user instanceof Lecturer){
    			cmbSearchRole.setSelectedItem("Lecturer");
    		}else{
    			cmbSearchRole.setSelectedItem("Administrator");
    		}
    		
    		cmbStatus.setSelectedItem(user.getAccountStatus().name().toLowerCase().substring(0, 1).toUpperCase()
    				+ user.getAccountStatus().name().substring(1).toLowerCase());
    	}else{
    		UtilGUI.togglePanel(pnlSearch, false);
    	}
    	
    }
    
    private void saveAccountEdit(){
    	User user = UserManager.getUserByUsername(txtUsernameSearch.getText());
    	user.setUsername(txtSearchUsername.getText());
    	user.setFirstName(txtSearchFirstName.getText());
    	user.setLastName(txtSearchLastName.getText());
    	user.setPassword(String.valueOf(txtSearchPassword.getPassword()));
    	user.setStatus(Status.valueOf(cmbStatus.getSelectedItem().toString()));
    	
    	AccountRepository.updateUser(user);
    	
    	JOptionPane.showMessageDialog(null, "Account Updated!");
    	
    }
    
    private void deleteAccount(){
    	AccountRepository.removeUser(UserManager.getUserByUsername(txtUsernameSearch.getText()));
    	UserManager.userList.remove(UserManager.getUserByUsername(txtUsernameSearch.getText()));
    	JOptionPane.showMessageDialog(null, "Account Deleted!");
    }
    
    
    
    
    public void createUnit(){
    	
    	if(UnitManager.getUnitByCode(txtUnitCode.getText()) != null){
    		JOptionPane.showMessageDialog(null, txtUnitCode.getText() + " already exists!");
    		return;
    	}
    	String unitName = txtUnitName.getText();
    	String code = txtUnitCode.getText();
    	String uuid = UUID.randomUUID().toString();
    	
    	Unit unit = new Unit(uuid, code, unitName);
    	UnitManager.addUnit(unit);
    	UnitRepository.addUnit(unit);
    	JOptionPane.showMessageDialog(null, "Created Unit!");
    }
    
    public void searchUnit(){
    	String unitCode = txtSearchUnit.getText();
    	
    	Unit unit = UnitManager.getUnitByCode(unitCode);
    	if(unit != null){
    		txtUnitName.setText(unit.getUnitName());
    		txtUnitCode.setText(unit.getUnitCode());
    	}else{
    		JOptionPane.showMessageDialog(null, "No Unit Found!");
    	}
    }
    
    public void deleteUnit(){
    	Unit unit = UnitManager.getUnitByCode(txtSearchUnit.getText());
    	if(unit != null){
    		UnitManager.removeUnit(unit);
    		UnitRepository.removeUnit(unit);
    		JOptionPane.showMessageDialog(null, "Unit Deleted");
    		
    	}
    }
    
    public void editUnit(){
    	Unit unit = UnitManager.getUnitByCode(txtSearchUnit.getText());
    	if(unit != null){
    		String newName = txtUnitName.getText();
    		String newCode = txtUnitCode.getText();
    		
    		unit.setUnitName(newName);
    		unit.setUnitCode(newCode);
    		UnitRepository.updateUnit(unit.getUnitID(), newCode, newName);
    		JOptionPane.showMessageDialog(null, "Unit Updated!");
    	}
    }
    
    public void searchUnitEnrol(){
    	String unitCode = txtSearchUnitCode.getText();
    	Unit unit = UnitManager.getUnitByCode(unitCode);
    	if(unit != null){
    		JOptionPane.showMessageDialog(null, "Found " + unitCode);
    	}else{
    		JOptionPane.showMessageDialog(null, "No Unit Found!");
    	}
    }
    
    public void searchByUsername(){
    	String username = txtSearchByUsername.getText();
    	User user = UserManager.getUserByUsername(username);
    	if(user != null){
    		JOptionPane.showMessageDialog(null, "Found " + username);
    	}else{
    		JOptionPane.showMessageDialog(null, "No Account Found!");
    	}
    }
    
    public void submitEnrolment(){
    	Unit unit = null;
    	User user = null;
    	if(UserManager.getUserByUsername(txtSearchByUsername.getText()) != null){
    		user = UserManager.getUserByUsername(txtSearchByUsername.getText());
    	}else{
    		user = (User) cmbSelectAccount.getSelectedItem();
    	}
    	
    	if(UnitManager.getUnitByCode(txtSearchUnitCode.getText()) != null){
    		unit = UnitManager.getUnitByCode(txtSearchUnitCode.getText());
    	}else{
    		unit = (Unit) cmbSelectUnit.getSelectedItem();
    	}
    	
    	if(unit != null && user != null){
    		String enrolAs = cmbEnrolAs.getSelectedItem().toString();
    		
    		if(rbEnrolAccount.isSelected()){
    			user.addEnrolment(new Enrolment(unit.getUnitID(), user.getUserID(), enrolAs));
    			UnitRepository.addEnrolment(unit, user, enrolAs);
    			JOptionPane.showMessageDialog(null, user.getUsername() + " enrolled in " + unit.getUnitCode());
    		}else{
    			user.removeEnrolment(user.getEnrolment(unit));
    			UnitRepository.removeEnrolment(unit, user);
    			JOptionPane.showMessageDialog(null, user.getUsername() + " un-enrolled from " + unit.getUnitCode());
    		}
    	}
    	
    }
    
   
    
}