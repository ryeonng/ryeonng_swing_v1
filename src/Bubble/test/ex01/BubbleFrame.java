package Bubble.test.ex01;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	// 포함관계 - 컴포지션관계
	private Player player;

	public BubbleFrame() {
		initData();
		setInitLayout();
		addEvenListener();
	}

	private void initData() {
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 전체 Frame 안에 root Panel 존재
		setContentPane(backgroundMap); // add 처리 (root Panel 안에)
		setSize(1000, 640); // 가로x세로 크기

		player = new Player();
	}

	private void setInitLayout() {
		// 좌표값으로 배치
		setLayout(null);
		setResizable(false); // 프레임 조절 불가 세팅
		setLocationRelativeTo(null); // JFrame을 모니터 가운데 자동으로 배치
		setVisible(true);

		add(player); // 좌표, 크기 필요
	}

	private void addEvenListener() {

		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("key code :" + e.getKeyCode());

				// 스위치 구문
				switch (e.getKeyCode()) {

				case KeyEvent.VK_LEFT:
					// 코드 구현
					player.left();
					break;

				case KeyEvent.VK_RIGHT:
					// 코드 구현
					player.right();
					break;

				case KeyEvent.VK_UP:
					player.up();
					break;
				}

			} // end of KeyPressed

		});

	}

	// 코드 테스트
	public static void main(String[] args) {

		new BubbleFrame();

	} // end of main

}
