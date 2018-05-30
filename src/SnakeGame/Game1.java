package SnakeGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.renderable.RenderableImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import MainAppPackage.JFrame2;

@SuppressWarnings("serial")
public class Game1 extends JPanel implements Runnable, KeyListener{

	public static final int WIDTH= 400;
	public static final int HEIGHT= 400;
	//Render
	private Graphics2D g2d;
	private BufferedImage image;
	
	//Game Loop
	private Thread thread;
	private boolean running;
	private long targetTime;
	
	//Game Stuff
	private int SIZE = 10;
	private Entity head,apple;
	private ArrayList<Entity> snake;
	private int score;
	private int level;
	private boolean gameover;
	
	//movement
	private int dx,dy;
	
	//key input
	private boolean up,down,right,left,start,help;
	public Game1() {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setFocusable(true);
		requestFocus();
		addKeyListener(this);
	}
	@Override
	public void addNotify() {
		super.addNotify();
		thread= new Thread(this);
		thread.start();
	}
	
	private void setFPS(int fps) {
		targetTime = 1000 / fps;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		
		if(k==KeyEvent.VK_UP) up = true;
		if(k==KeyEvent.VK_DOWN) down = true;
		if(k==KeyEvent.VK_LEFT) left = true;
		if(k==KeyEvent.VK_RIGHT) right = true;
		if(k==KeyEvent.VK_ENTER) start = true;
		if(k==KeyEvent.VK_H) help = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int k = e.getKeyCode();
		
		if(k==KeyEvent.VK_UP) up = false;
		if(k==KeyEvent.VK_DOWN) down = false;
		if(k==KeyEvent.VK_LEFT) left = false;
		if(k==KeyEvent.VK_RIGHT) right = false;
		if(k==KeyEvent.VK_ENTER) start = false;
		if(k==KeyEvent.VK_H) help = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		if(running) return;
		init();
		long startTime;
		long elapsed;
		long wait;
		while(running) {
			startTime = System.nanoTime();
			
			update();
			requestRender();
			
			elapsed = System.nanoTime()-startTime;
			wait = targetTime - elapsed / 1000000;
			if(wait>0) {
				try {
					Thread.sleep(wait);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void init() {
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		g2d= image.createGraphics();
		running = true;
		setUpLevel();
		
		
	}
	private void setUpLevel() {
		snake= new ArrayList<Entity>();
		head = new Entity(SIZE);
		head.setPosition(WIDTH /2, HEIGHT/2);
		snake.add(head);
		//snake size
		for(int i=1;i<3;i++) {
			Entity e = new Entity(SIZE);
			e.setPosition(head.getX() + (i * SIZE), head.getY());
			snake.add(e);
		}
		apple= new Entity(SIZE);
		setApple();
		score=0;
		gameover = false;
		level =1;
		dx=dy=0;
		setFPS(level * 10);
	}
	
	public void setApple() {
		int x=(int) (Math.random()* (WIDTH - SIZE));
		int y=(int) (Math.random()* (HEIGHT - SIZE));
		x= x - ( x % SIZE);
		y= y - ( y % SIZE);
		apple.setPosition(x, y);
	}
	private void requestRender() {
		render(g2d);
		Graphics g = getGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		
	}
	
	private void update() {
		if(gameover) {
			if(start) {
				setUpLevel();
			}
			
			return;
		}
		if(up && dy == 0) {
			dy=-SIZE;
			dx=0;
		}
		if(down && dy == 0) {
			dy=SIZE;
			dx=0;
		}
		if(left && dx == 0) {
			dy=0;
			dx=-SIZE;
		}
		if(right && dx == 0 && dy != 0) {
			dy=0;
			dx=SIZE;
		}
		if(dx != 0 || dy !=0) {
			for (int i = snake.size() - 1 ; i> 0 ; i--) {
			
				snake.get(i).setPosition(
						snake.get(i - 1).getX(),
						snake.get(i - 1).getY()
						);
			}
			head.move(dx, dy);
		}
		
		for(Entity e : snake) {
			if(e.isCollisiong(head)) {
				gameover = true;
				break;
			}
			
		}
		
		if(apple.isCollisiong(head)) {
			score++;
			setApple();
			
			Entity e = new Entity(SIZE);
			e.setPosition(-100,-100);
			snake.add(e);
			if(score % 10 == 0) {
				level++;
				if(level > 10 ) level = 10;
				setFPS(level * 10);
			}
		}
		
		if(head.getX() < 0) head.setX(WIDTH-10);
		if(head.getY() < 0) head.setY(HEIGHT-10);
		if(head.getX() > WIDTH-10) head.setX(0);
		if(head.getY() > HEIGHT-10) head.setY(0);
		
	}
	public void render (Graphics2D g2d) {
		g2d.clearRect(0, 0, WIDTH, HEIGHT);
		
		g2d.setColor(Color.GREEN);
		for(Entity e : snake) {
			e.render(g2d);
		}
		
		g2d.setColor(Color.RED);
		g2d.setFont(new Font("Casttelar", Font.BOLD, 40));
		apple.render(g2d);
		if(gameover) {
			g2d.drawString("GameOver!" , 100,200);
			g2d.setColor(Color.LIGHT_GRAY);
			g2d.setFont(new Font("Casttelar", Font.BOLD, 13));
			g2d.drawString("Press enter to start!", 130, 222);
			
		}
		g2d.setPaint(Color.WHITE);
		if(dx == 0 && dy == 0) {
			g2d.drawString("Ready!!!" , 123,200);
			
			
		}
		g2d.setFont(new Font("Calibri", Font.BOLD, 15));
		g2d.drawString("Score : " + score + "  Level : " + level, 10, 10);
		if(help) {
			//Frame frame=new Frame();
			JOptionPane.showMessageDialog(null, "Use the arrow keys to move the snake" );
		}
	}
	

}
