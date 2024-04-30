package ch06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniGamePractice extends JFrame {

	private JLabel backgroundMap;
	private JLabel jPlayer;
	
	private int jPlayerX = 100;
	private int jPlayerY = 100;
	private final int MOVDE_DISTANCE = 50;
	private final int FRAME_WIDTH = 500;
	private final int FRAME_HEIGHT = 500;
	private final String PLAYER_NAME = "다람";
	private final int PLAYER_WIDTH = 100;
	private final int PLAYER_HEIGHT = 100;
	
	public MiniGamePractice() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		Icon icon = new ImageIcon("images/background2.jpg"); // 업캐스팅 된 상태
		backgroundMap = new JLabel(icon);
		backgroundMap.setSize(500, 500);
		backgroundMap.setLocation(0, 0);
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jPlayer = new JLabel(PLAYER_NAME); 
		jPlayer.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
	
	
	
		jPlayer = new JLabel(new ImageIcon("images/image11.png"));
		jPlayer.setSize(200, 200);
		jPlayer.setLocation(300, 100);}
	
	
	
	private void setInitLayout() {
		setLayout(null);
		add(jPlayer);
		add(backgroundMap);
		jPlayer.setLocation(100, 100);
		setVisible(true);
	}
	
	private void addEventListener() {
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					jPlayerY -= MOVDE_DISTANCE;
				}else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					jPlayerX -= MOVDE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					jPlayerX += MOVDE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					jPlayerY += MOVDE_DISTANCE;
				}
				
				jPlayer.setLocation(jPlayerX, jPlayerY);
			}
		});
	}
	
	// 코드테스트
	public static void main(String[] args) {
		new MiniGamePractice();
	} // end of main
} // end of class
