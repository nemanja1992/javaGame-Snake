package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Users.User;
import Users.UserFunctionsSerialization;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.event.ActionEvent;

public class MainApplicationClass {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private UserFunctionsSerialization read= new UserFunctionsSerialization();
	private List<User> userL= read.deserialize("user.bin");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApplicationClass window = new MainApplicationClass();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApplicationClass() throws HeadlessException {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new DrawArea());
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText("username");
		txtUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		txtUsername.setBounds(222, 37, 127, 25);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(15);
		txtUsername.setToolTipText("enter username");
		
		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
					if (e.getKeyCode()==KeyEvent.VK_ENTER){			
						
					    }
				
			}
		});
			
		txtPassword.setToolTipText("password");
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
					if (e.getKeyCode()==KeyEvent.VK_ENTER){			
						log(txtUsername.getText(), txtPassword.getText());
					    }
				
			}
		});
		txtPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPassword.setBounds(222, 102, 127, 25);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(15);
		txtPassword.setToolTipText("enter password");
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				log(txtUsername.getText(), txtPassword.getText());
				
				
			}
		});
		btnLogin.setBounds(219, 172, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnCAcc = new JButton("Create acc");
		btnCAcc.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				CreateAccount ca=new CreateAccount();
				ca.CreateAcc();
				
				
			}
		});
		btnCAcc.setBounds(219, 172, 89, 23);
		frame.getContentPane().add(btnCAcc);
		
		JLabel lblPassword = new JLabel("");
		lblPassword.setToolTipText("password");
		lblPassword.setBounds(162, 110, 55, 14);
		frame.getContentPane().add(lblPassword);
	}
	
	public void log(String userName,String userPassword) {
//		if((userNick.equals(userName))&&(userPass.equals(userPassword))) {
//			System.out.println("welcome!");
//			frame.dispose();
//			JFrame2 nf= new JFrame2();					
//			nf.NewScreen();
//		}
		boolean a=false;
		for(int i=0;i<userL.size();i++) {
			
			if((userL.get(i).getUsername().equals(userName))&&(userL.get(i).getPassword().equals(userPassword))) {
				System.out.println("welcome!");
				frame.dispose();
				JFrame2 nf= new JFrame2();					
				nf.NewScreen();
				a=true;
			}
		
		}
			 if(a==false){
				System.out.println("wrong pass or nick!");
				JOptionPane.showMessageDialog(frame, "Username and password doesn't existe");
			
			
		}
	}
	
	class DrawArea extends JPanel{

		Point A=null;
		int nmbOfLoops=100;
		int length=100;
		public DrawArea(){
			A= new Point(250,250);
			
		}
		@Override
		protected void paintComponent (Graphics g) {
			g.fillRect(0, 0, 800, 700);
			g.setColor(Color.red);
			for(int i=0;i<400;i++) {
				g.drawLine(A.x + (int)(length * Math.cos(Math.PI * i/200.0) *(1-Math.cos(nmbOfLoops * Math.PI * i/200.0))),
						A.y + (int)(length * Math.sin(Math.PI * i/200.0) *(1-Math.sin(nmbOfLoops * Math.PI * i/200.0))),
						A.x + (int)(length * Math.cos(Math.PI * (i+1)/200.0) *(1-Math.cos(nmbOfLoops * Math.PI * (i+1)/200.0))),
						A.x + (int)(length * Math.sin(Math.PI * (i+1)/200.0) *(1-Math.sin(nmbOfLoops * Math.PI * (i+1)/200.0))));
				
			}
		}
		}
}
