package ch06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniGame1 extends JFrame {

	private JLabel jPlayer;
	// 변수는 변하는 수이다.
	private int jPlayerX = 100;
	private int jPlayerY = 100;
	private final int MOVDE_DISTANCE = 50;
	private final int FRAME_WIDTH = 500;
	private final int FRAME_HEIGHT = 500;
	private final String PLAYER_NAME = "야스오";
	private final int PLAYER_WIDTH = 100;
	private final int PLAYER_HEIGHT = 100;
	
	
	public MiniGame1() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jPlayer = new JLabel(PLAYER_NAME); // 좌표기반일때, 위치(좌표값)와 크기 지정 해야 함
		jPlayer.setSize(PLAYER_WIDTH, PLAYER_HEIGHT); // 가로 세로 크기
	}

	private void setInitLayout() {
		setLayout(null); // null로 설정 : 좌표 기반으로 배치 관리자를 변경.
		add(jPlayer);
		jPlayer.setLocation(100, 100); // 위치 좌표값
		setVisible(true);
	}

	private void addEventListener() {
		// jPlayer(j라벨) 객체에게만 keyListener 동작을 시키고자 한다면,
		// 익명 구현 클래스로 keyListener 인터페이스를 재정의할 수 있다.
		// jPlayer.addKeyListener(this);

		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					jPlayerY -= MOVDE_DISTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
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

	// 코드 테스트
	public static void main(String[] args) {
		new MiniGame1();
	} // end of main

} // end of class
