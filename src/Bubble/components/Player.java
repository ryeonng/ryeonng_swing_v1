package Bubble.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Bubble.BubbleFrame;
import Bubble.interfaces.Moveable;
import Bubble.service.BackgroundPlayerService;
import Bubble.state.PlayerWay;

public class Player extends JLabel implements Moveable {

	BubbleFrame mContext;
	
	private int x;
	private int y; // 좌표 저장하는 데이터
	private ImageIcon playerR, playerL; // 데이터 타입 축약 ver.

	// 움직임의 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	// 벽에 충돌한 상태
	private boolean leftWallCrash;
	private boolean rightWallCrash;

	// 플레이어 속도 상태
	private final int SPEED = 4;
	private final int JUMPSPEED = 2;

	// enum 타입의 활용
	PlayerWay playerWay;
	
	// get, set
	public Player(BubbleFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		// Player 백그라운드 서비스 시작
		new Thread(new BackgroundPlayerService(this)).start();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ImageIcon getPlayerR() {
		return playerR;
	}

	public void setPlayerR(ImageIcon playerR) {
		this.playerR = playerR;
	}

	public ImageIcon getPlayerL() {
		return playerL;
	}

	public void setPlayerL(ImageIcon playerL) {
		this.playerL = playerL;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}

	public int getSPEED() {
		return SPEED;
	}

	public int getJUMPSPEED() {
		return JUMPSPEED;
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

		leftWallCrash = false;
		rightWallCrash = false;
		
		playerWay = PlayerWay.RIGHT;

	}

	private void setInitLayout() {
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	@Override
	public void left() {
		playerWay = PlayerWay.LEFT;
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
		playerWay = PlayerWay.RIGHT;
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
				
				while(down) {
					y = y + SPEED;
					setLocation(x, y);
					
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				down = false;
				
			}
		}).start();

	}
	
	// 플레이어의 공격
	   public void attack() {

	      // 작업자에게 위임처리
	      // 람다 표현식 -> 말그대로 표현식일뿐. , 자바는 타입추론 가능
	      new Thread(() -> {
	         // run() 안에 들어오는 식을 작성하면됨
	         Bubble bubble = new Bubble(mContext);
	         // mContext를 통해서 JFrame의 메서드를 호출할 수 있다.
	         mContext.add(bubble);
	         
	         if (playerWay == PlayerWay.LEFT) {
	            // 버블을 왼쪽으로 쏘기
	            bubble.left();
	         } else {
	            // 버블을 오른쪽으로 쏘기
	            bubble.right();
	         }
	      }).start();

	   }

	}
