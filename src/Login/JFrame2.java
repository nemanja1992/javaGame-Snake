package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

import SnakeGame.GameMainClass;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JFrame2 {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame2 window = new JFrame2();
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
	public JFrame2() throws HeadlessException {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		JLabel background=new JLabel(new ImageIcon("cosmos.jpg"));
		background.setLayout(new FlowLayout());
		
		
		JButton snakeBtn = new JButton("Snake");
		snakeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			GameMainClass g=new GameMainClass();
			g.StartGame();
			frame.dispose();
			}
		});
//		snakeBtn.setLayout(null);
		snakeBtn.setBounds(219, 172, 89, 23);
		snakeBtn.setLocation(10,10);
		snakeBtn.setPreferredSize(new Dimension(100, 100));
		frame.getContentPane().add(snakeBtn);
		frame.add(background);
	}
	
	
		
}