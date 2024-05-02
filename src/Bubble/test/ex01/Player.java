package Bubble.test.ex01;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	private int x;
	private int y; // 좌표 저장하는 데이터
	private ImageIcon playerR, playerL; // 데이터 타입 축약 ver.

	public Player() {
		initData();
		setInitLayout();
	}

	private void initData() {
		playerR = new ImageIcon("img/playerR.png");
		playerL = new ImageIcon("img/playerL.png");

		// 처음 게임 실행 시, 초기 값 세팅
		x = 55;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	private void setInitLayout() {

	}

	@Override
	public void left() {
		// 왼쪽 방향키의 이벤트 발생 시,
		// 이미지를 왼쪽으로 보는 이미지로 세팅
		setIcon(playerL);
		x = x - 10; // 왼쪽으로 좌표 10 이동
		setLocation(x, y); // 위치를 다시 찍어주는 동작
	}

	@Override
	public void right() {
		setIcon(playerR);
		x = x + 10;
		setLocation(x, y);
	}

	@Override
	public void up() {
		System.out.println("점프");
	}

	@Override
	public void down() {
		System.out.println("다운");
	}

}
