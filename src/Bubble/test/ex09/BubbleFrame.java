package Bubble.test.ex09;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

	// 컨텍스트를 생성하는 방법 ( 셀프 참조 )
	BubbleFrame mContext = this;
	
	private JLabel backgroundMap;
	// 포함관계 - 컴포지션관계
	private Player player;
	private Enemy enemy1;
	
	public BubbleFrame() {
		initData();
		setInitLayout();
		addEvenListener();

	}
	private void initData() {
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
//		backgroundMap = new JLabel(new ImageIcon("img/test.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 전체 Frame 안에 root Panel 존재
		setContentPane(backgroundMap); // add 처리 (root Panel 안에)
		setSize(1000, 640); // 가로x세로 크기

		// mContext → 참조 타입() → 주소값의 크기는 기본 4byte 이다. 
		player = new Player(mContext);
		
		enemy1 = new Enemy(mContext);
	}

	private void setInitLayout() {
		// 좌표값으로 배치
		setLayout(null);
		setResizable(false); // 프레임 조절 불가 세팅
		setLocationRelativeTo(null); // JFrame을 모니터 가운데 자동으로 배치
		setVisible(true);

		add(player); // 좌표, 크기 필요
		add(enemy1);
	}

	private void addEvenListener() {

		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("key code :" + e.getKeyCode());

				// 스위치 구문
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:

					// 왼쪽으로 방향키 누르고 있다면,
					// key 이벤트가 계속 ← ← ← ← ← ←
					// 왼쪽 상태가 아니라면
					// player가 왼쪽 벽에 충돌한 게 아니라면
					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
					break;

				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
					break;

				case KeyEvent.VK_UP:
					player.up();
					break;

				case KeyEvent.VK_SPACE:
					player.attack();
					// 프레임에 컴포넌트를 add 동작은 누구? JFrame → add() 메서드 이다.
					// 버블 실행 시에 끊김 현상이 발생하는 이유는?
					break;
				default:
					break;
				}

			} // end of KeyPressed

			@Override
			public void keyReleased(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					// 왼쪽으로 가는 상태 멈춤
					player.setLeft(false);
					break;

				case KeyEvent.VK_RIGHT:
					// 오른쪽으로 가는 상태 멈춤
					player.setRight(false);
					break;
				default:
					break;
				}

			} // end of keyReleased

		});

	}

	// getter
	public Player getPlayer() {
		return player;
	}
	
	public Enemy getEnemy() {
		return enemy1;
	}
	
	// 코드 테스트
	public static void main(String[] args) {
		//★★★★★★ main 함수를 가지고 있는 클래스는 하위에 생성된
		// 모든 객체들의 주소값을 알고 있다. ★★★★★★
		
		
		new BubbleFrame();

	} // end of main

}
