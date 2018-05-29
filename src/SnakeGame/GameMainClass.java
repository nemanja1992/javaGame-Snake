package SnakeGame;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GameMainClass {

	public static void StartGame() {
		JFrame frame= new JFrame("Snake");
		frame.setContentPane(new Game1());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setPreferredSize(new Dimension(Game1.WIDTH, Game1.HEIGHT));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
