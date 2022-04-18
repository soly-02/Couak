package cuac.windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class CovidWallet extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public CovidWallet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 672, 467);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel user_email = new JLabel("dummie@uom.edu.gr");
		user_email.setBounds(10, 11, 167, 21);
		user_email.setForeground(Color.WHITE);
		user_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(user_email);
		
		JLabel lblCovidWallet = new JLabel("Covid Wallet");
		lblCovidWallet.setForeground(Color.WHITE);
		lblCovidWallet.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCovidWallet.setBounds(10, 43, 221, 41);
		panel.add(lblCovidWallet);
	}

}
