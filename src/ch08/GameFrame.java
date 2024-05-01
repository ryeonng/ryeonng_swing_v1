package ch08;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {

	// 배경화면과 캐릭터 이미지 필요
	BufferedImage backgroundImage;
	BufferedImage player1;
	BufferedImage enemy1;
	ImagePanel imagePanel;

	int playerX = 150; // 플레이어 좌표
	int playerY = 300;

	int enemyX = 250; // 적군 좌표
	int enemyY = 420;

	public GameFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	// 클래스 안에 클래스를 작성 : 중첩 클래스 -> 외부(outer) / 내부(inner) 클래스
	// 내부 클래스가 외부 클래스의 멤버 변수를 바로 사용 가능하다는 장점
	private class ImagePanel extends JPanel implements Runnable { // 다중 상속 불가 > runnable

		// paintCoponents X
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backgroundImage, 0, 0, 600, 600, null); // x,y,가로,세로
			g.drawImage(player1, playerX, playerY, 50, 50, null);
			g.drawImage(enemy1, enemyX, enemyY, 50, 50, null);

			// Todo ) 플레이어, 적군 그림을 그려야 함
			// 쓰레드 활용할 예정

		}

		@Override
		public void run() { // start 메서드로 수행
			
			// true는 왼쪽으로 가는 상황
			// false : 오른쪽으로 가는 상황
			boolean direction = true;
			
			while (true) {
				System.out.println("진행중");
				
				if(direction) { // 한 쪽으로만 향하지 않도록 설계
					enemyX -= 10;
				} else {
					enemyX += 10;
				}
				
				// 방향을 바꾸는 개념은 적군의 X좌표값이 
				if(enemyX <= 50) {
					// false --> 오른쪽으로
					direction = false;
				} // else 를 쓰면 안된다. ( if문 하나 더 작성)
				
				if(enemyX >= 510) {
					// true --> 왼쪽으로
					direction = true;
				}
				
				

				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				repaint();
			}
		}

	}

	private void initData() {
		setTitle("Thread를 활용한 미니 예제");
		setSize(600, 600); // 가로x세로
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x클릭 시, 프로그램종료

		try { // 예외가 발생할 수 있는 코드를 작성하는 영역
			backgroundImage = ImageIO.read(new File("img/backgroundMap.png"));
			player1 = ImageIO.read(new File("img/playerL.png"));
			enemy1 = ImageIO.read(new File("img/enemyL.png"));
		} catch (IOException e) { // 예외 처리 (이미지 파일 없을 시)
			e.printStackTrace();
		}

		imagePanel = new ImagePanel();
		// 다른 작업자에게 일을 위임 시킨다.
		Thread thread = new Thread(imagePanel);
		thread.start();
	}

	private void setInitLayout() {
		// 배치 관리자를 좌표 기반으로 하려면 setLayout을 null값으로
		// setLayout(null); // 크기,위치 지정하지 않으면 이미지 출력 x
		// setResizable(false); // 프레임 크기 조절 불가 설정
		setVisible(true); // 화면에 보이도록 설정

		add(imagePanel);
	}

	private void addEventListener() {
		// 이벤트 리스너를 등록하는 법 2가지 중 익명구현리스너
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("이곳이 동작 합니다.");
				int code = e.getKeyCode();
				// 제어문 작성
				if (code == KeyEvent.VK_UP) {
					playerY -= 10; // -10 만큼
				} else if (code == KeyEvent.VK_DOWN) {
					playerY += 10;// +10 만큼 y좌표 더해라
				} else if (code == KeyEvent.VK_LEFT) {
					playerX -= 10;
				} else if (code == KeyEvent.VK_RIGHT) {
					playerX += 10;
				} else if (code == KeyEvent.VK_SPACE) {
					// 1. 스페이스바를 눌렀을 때, 적군을 멈출 수 있도록 코드를 수정
					
							
				}
				
				// 2. player가 적군과 마주쳤다면, player 그림을 없애주세요.
				
				repaint(); // ImagePanel 코드 부분을 다시 그려준다.
			} // end of keyPressed
		});
	}

}
