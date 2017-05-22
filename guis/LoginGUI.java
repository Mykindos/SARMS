package deakin.edu.au.sarms.guis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import deakin.edu.au.sarms.accounts.User;
import deakin.edu.au.sarms.accounts.UserManager;
import deakin.edu.au.sarms.accounts.types.Administrator;
import deakin.edu.au.sarms.accounts.types.Lecturer;

public class LoginGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnLogin;
	private JLabel lblLogin;
	private JLabel lblPassword;
	private JLabel lblPassword1;
	private JPasswordField txtPassword;
	private JFormattedTextField txtUsername;


	public LoginGUI() {
		setVisible(true);
		initialize();
	}

	private void initialize() {

		txtPassword = new JPasswordField();
		lblLogin = new JLabel();
		lblPassword = new JLabel();
		lblPassword1 = new JLabel();
		txtUsername = new JFormattedTextField();
		btnLogin = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("SARMS");
		setMaximumSize(new Dimension(750, 400));
		setMinimumSize(new Dimension(750, 400));
		getContentPane().setLayout(null);
		getContentPane().add(txtPassword);
		txtPassword.setBounds(300, 250, 200, 30);

		lblLogin.setBackground(new Color(51, 255, 255));
		lblLogin.setFont(new Font("Tahoma", 1, 24)); // NOI18N
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setText("SARMS Login");
		lblLogin.setBorder(BorderFactory.createEtchedBorder());
		lblLogin.setOpaque(true);
		getContentPane().add(lblLogin);
		lblLogin.setBounds(0, 0, 750, 80);

		lblPassword.setFont(new Font("Tahoma", 0, 18)); // NOI18N
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setText("Password:");
		getContentPane().add(lblPassword);
		lblPassword.setBounds(200, 250, 90, 30);

		lblPassword1.setFont(new Font("Tahoma", 0, 18)); // NOI18N
		lblPassword1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword1.setText("Username:");
		getContentPane().add(lblPassword1);
		lblPassword1.setBounds(200, 170, 90, 30);
		getContentPane().add(txtUsername);
		txtUsername.setBounds(300, 170, 200, 30);

		btnLogin.setFont(new Font("Tahoma", 1, 18)); // NOI18N
		btnLogin.setText("Login");
		btnLogin.addActionListener(e -> {
			User user = UserManager.getUserByUsername(txtUsername.getText());
			if(user != null){
				
				String password = String.valueOf(txtPassword.getPassword());
				if(user.getPassword().equalsIgnoreCase(password)){
					
					JOptionPane.showMessageDialog(null, "Login Successful");
					if(user instanceof Administrator){
						new AdminGUI();
					}else if(user instanceof Lecturer){
						
					}else{
						
					}
					
					dispose();
					
				}else{
					System.out.println("Invalid Username or Password");
				}
			}
		});
		getContentPane().add(btnLogin);
		btnLogin.setBounds(300, 310, 200, 50);
		
		this.setResizable(false);
		

		pack();
	}
	
}