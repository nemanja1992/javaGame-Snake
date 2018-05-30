package MainAppPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import SnakeGame.GameMainClass;
import Users.User;
import Users.UserFunctionsSerialization;

public class CreateAccount {
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtPassword2;
	private JFrame frame;
	private UserFunctionsSerialization u= new UserFunctionsSerialization();
	private List<User> userL= new ArrayList<>();
	private List<User> result= new ArrayList<>();
	private MainApplicationClass ma= new MainApplicationClass();
	private List<User> userLread= u.deserialize("user.bin");

	/**
	 * Launch the application.
	 */
	public  void add(String userName, String password) {
		boolean a=false;
		for(int i=0;i<userL.size();i++) {
			if((userLread.get(i).getUsername().equals(userName))) {
				JOptionPane.showMessageDialog(null, "Username alredy existe");
				a=true;
			}
			
		}
		if(a==false) {
			
			for(int i=0;i<userL.size();i++) {
			result.add(new User(userLread.get(i).getUsername(),userLread.get(i).getPassword()));
			
			u.serialize(result, "user.bin");
			
			}
			userL.add(new User(userName,password));
			u.serialize(userL, "user.bin");
		}
	
		
	}
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
						if(txtPassword.getText().equals(txtPassword2.getText())) {
							add(txtUsername.getText(), txtPassword.getText());
							ma.main(null);
							frame.dispose();
							
						}
						else {
							JOptionPane.showMessageDialog(frame, "password don't match");
							
						}
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
						
					if(txtPassword.getText().equals(txtPassword2.getText())) {
						add(txtUsername.getText(), txtPassword.getText());
						ma.main(null);
						frame.dispose();
						
					}
					else {
						JOptionPane.showMessageDialog(frame, "password don't match");
						
					}
				   
			}
		});
		createBtn.setBounds(219, 172, 150, 28);
		createBtn.setLocation(75,220);
		createBtn.setPreferredSize(new Dimension(100, 100));
		
		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			GameMainClass g=new GameMainClass();
			ma.main(null);
			frame.dispose();
			}
		});
		backBtn.setBounds(219, 172, 150, 28);
		backBtn.setLocation(75,260);
		backBtn.setPreferredSize(new Dimension(100, 100));
		
		JLabel userName = new JLabel("Enter new username: ");
		userName.setText("Enter new username: ");
		userName.setBounds(75,20,155,28);
		userName.setForeground(Color.white);
		userName.setFont(new Font("Calibri", Font.BOLD, 16));
		
        JLabel userPassword = new JLabel();
        userPassword.setText("Enter new password:");
        userPassword.setBounds(75,80,155,28);
        userPassword.setForeground(Color.white);
        userPassword.setFont(new Font("Calibri", Font.BOLD, 16));
        
        JLabel checkPassword = new JLabel();
        checkPassword.setText("Re-enter password:");
        checkPassword.setBounds(75,140,155,28);
        checkPassword.setForeground(Color.white);
        checkPassword.setFont(new Font("Calibri", Font.BOLD, 16));

		
		frame.getContentPane().add(createBtn);
		frame.getContentPane().add(backBtn);
		frame.getContentPane().add(userName);
		frame.getContentPane().add(userPassword);
		frame.getContentPane().add(checkPassword);
		frame.add(background);
		
	}
	
}
