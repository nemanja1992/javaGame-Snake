package Login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import SnakeGame.GameMainClass;

public class CreateAccount {
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtPassword2;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void CreateAcc() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount window = new CreateAccount();
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
	public CreateAccount() throws HeadlessException {	
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Create new accout");
		frame.setBounds(100, 100, 300, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		frame.setLayout(new BorderLayout());
		JLabel background=new JLabel(new ImageIcon("cosmos.jpg"));
		background.setLayout(new FlowLayout());
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText("username");
		txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsername.setBounds(222, 37, 150, 28);txtUsername.setLocation(75,40);
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
						
					    }
				
			}
		});
		txtPassword.setHorizontalAlignment(SwingConstants.LEFT);
		txtPassword.setBounds(222, 102, 150, 28);txtPassword.setLocation(75,100);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(15);
		txtPassword.setToolTipText("enter password");
		
		txtPassword2 = new JPasswordField();
		txtPassword2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
					if (e.getKeyCode()==KeyEvent.VK_ENTER){			
						
					    }
				
			}
		});
		txtPassword2.setToolTipText("password2");
		txtPassword2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
					if (e.getKeyCode()==KeyEvent.VK_ENTER){			
						
					    }
				
			}
		});
		txtPassword2.setHorizontalAlignment(SwingConstants.LEFT);
		txtPassword2.setBounds(222, 102, 150, 28);txtPassword2.setLocation(75,160);
		frame.getContentPane().add(txtPassword2);
		txtPassword2.setColumns(15);
		txtPassword2.setToolTipText("enter password");
		
		
		JButton createBtn = new JButton("Create");
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			GameMainClass g=new GameMainClass();
			g.StartGame();
			frame.dispose();
			}
		});
		createBtn.setBounds(219, 172, 150, 28);
		createBtn.setLocation(75,220);
		createBtn.setPreferredSize(new Dimension(100, 100));
		
		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			GameMainClass g=new GameMainClass();
			
			frame.dispose();
			}
		});
		backBtn.setBounds(219, 172, 150, 28);
		backBtn.setLocation(75,260);
		backBtn.setPreferredSize(new Dimension(100, 100));
		
		frame.getContentPane().add(createBtn);
		frame.getContentPane().add(backBtn);
		frame.add(background);
	}
	
}
