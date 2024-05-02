package Bubble.test.ex03;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	private int x;
	private int y; // 좌표 저장하는 데이터
	private ImageIcon playerR, playerL; // 데이터 타입 축약 ver.

	// 움직임의 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	// 플레이어 속도 상태
	private final int SPEED = 4;
	private final int JUMPSPEED = 2;

	// setter
	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public Player() {
		initData();
		setInitLayout();
	}

	private void initData() {
		playerR = new ImageIcon("img/playerR.png");
		playerL = new ImageIcon("img/playerL.png");

		// 처음 게임 실행 시, 초기 값 세팅
		x = 450;
		y = 535;

		// 플레이어가 가만히 멈추어 있는 상태
		left = false;
		right = false;
		up = false;
		down = false;

		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	private void setInitLayout() {

	}

	@Override
	public void left() {
		left = true;
		setIcon(playerL);

		// <-<-<-<- 반복하는 반복문
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (left) {

					x = x - SPEED;
					setLocation(x, y); // 위치를 다시 찍어주는 동작
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

	}

	// 왼쪽 방향키의 이벤트 발생 시,
	// 이미지를 왼쪽으로 보는 이미지로 세팅
	// 왼쪽으로 가고 있는 상태
	// 멈추어 있는 상태라는 개념이 필요하다.

	@Override
	public void right() {

		right = true;
		setIcon(playerR);

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (right) {
					x = x + SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10); // 0.01초
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

			}

		}).start();

	} // end of right

	@Override
	public void up() {
		System.out.println("점프");
		up = true;
		new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 130 / JUMPSPEED; i++) {
					y = y - JUMPSPEED;
					setLocation(x, y);

					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// 객체의 상태값을 잘 조절해주어야 한다.
				up = false;
				down();
			}
		}).start();

	}

	@Override
	public void down() {
		System.out.println("다운");
		down = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 130 / JUMPSPEED; i++) {
					y = y + JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		// 상태값 처리를 확실하게 하자!
		down = false;

	}

}
