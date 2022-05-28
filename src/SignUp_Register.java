

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JDesktopPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class SignUp_Register extends JFrame {

	private JPanel contentPane;
	//To email kai to password molis patietai kapoio koympi(sign in/ register) stelnontai san string ston server.
	// an ola einai komple vazei mesa ton xristi alliws error kai 3anadokimazei
	private JTextField emailField;
	private JPasswordField passwordField;
	private String email;
	private String password;
	private String passRegex = "^(?=.*\\d)(?=.*[a-z])[0-9a-zA-Z]{8,12}$";
	private Pattern pattern =Pattern.compile(passRegex);
	
	Infection i;
	private User u;


	/**
	 * Create the frame.
	 */
	public SignUp_Register() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\UOMLOGOGR22.png"));
		setTitle("Cuac");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 560);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(86, 45, 485, 438);
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		emailField = new JTextField();
		emailField.setBounds(129, 72, 229, 36);
		panel.add(emailField);
		emailField.setColumns(10);
		
	
		
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(129, 182, 229, 36);
		panel.add(passwordField);
		
	
		
		 
		JButton signIn = new JButton("Sign In");
		signIn.setForeground(new Color(255, 255, 255));
		signIn.setFont(new Font("Microsoft Tai Le", Font.BOLD, 17));
		signIn.setBackground(new Color(0, 0, 128));
		signIn.setBounds(73, 297, 161, 36);
		panel.add(signIn);
		
		JLabel lblNewLabel = new JLabel("Enter Email");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
		lblNewLabel.setBounds(170, 34, 161, 27);
		panel.add(lblNewLabel);
		
		JButton Register = new JButton("Register");
		Register.setForeground(Color.WHITE);
		Register.setFont(new Font("Microsoft Tai Le", Font.BOLD, 17));
		Register.setBackground(new Color(0, 0, 128));
		Register.setBounds(267, 297, 161, 36);
		panel.add(Register);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
		lblEnterPassword.setBounds(145, 144, 223, 27);
		panel.add(lblEnterPassword);
		
		 ButtonListener bb= new ButtonListener();
		 signIn.addActionListener(bb);   
		 Register.addActionListener(bb);  
		 
	}
	
	 class ButtonListener implements ActionListener {
		 
		 
			
			public void actionPerformed(ActionEvent e) {
				i = new Infection();
				email = emailField.getText();
				password = String.valueOf(passwordField.getPassword());
				u = new User(email, password, i);
				
				if(email.isBlank()) {
					JOptionPane.showMessageDialog(null,"���������� �� email");
					return;
				}
//				else if(!pattern.matcher(password).matches()) {  disabled for testing
//					JOptionPane.showMessageDialog(null, "� ������� ������ �� ������������ \r\n"
//							+ "� ����������� 6 ����������.\r\n"
//							+ "� �� ���� 12 ����������.\r\n"
//							+ "� ����������� ��� �������� ������.\r\n"
//							+ "� ����������� ���� ������.\r\n"
//							+ "� ������������ � ����� ����� �������� ���� ��� �������� ��������\r\n"
//							+ "��� ��������.\r\n"
//							+ "","������ �������",JOptionPane.ERROR_MESSAGE);
//					return;
//				}
				
				if(u.connect()) {
					if (e.getActionCommand().equals("Register")) {
					
						if(u.sendRegCredentials()) {
							JOptionPane.showMessageDialog(null,"�������� �������");
						}
						else {
							JOptionPane.showMessageDialog(null,"����� � ����������� ������� ���", "������", JOptionPane.ERROR_MESSAGE);
						}
					}		
					else  if (e.getActionCommand().equals("Sign In")) {
						if (u.sendLogCredentials()) {
							MainScreen mainScr= new MainScreen(u);
							mainScr.setVisible(true);
							u.getMainScreen(mainScr);
							dispose ();
						
						
						}
					else {
						System.out.println("user not found"); //pop-up
						JOptionPane.showMessageDialog(null,"� ������� �� �������. ������ �� �������� ��� ������", "������", JOptionPane.ERROR_MESSAGE);
						u.closeConnection();
						//delete user object
						}
					}	
						
				}
				else {
					System.out.println("Connection error");
					JOptionPane.showMessageDialog(null,"������ �� �� �������", "������", JOptionPane.ERROR_MESSAGE);
					//pop-up
				}
				 
		}

	
	
}
}