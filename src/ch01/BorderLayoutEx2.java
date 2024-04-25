package ch01;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// 단축키 습관화!! ctrl+shift+s / f / o
public class BorderLayoutEx2 extends JFrame {
	final int WIDTH = 600;
	final int HEIGHT = 600;

	JButton[] buttons;
	String[] directions = { BorderLayout.EAST, BorderLayout.WEST, BorderLayout.SOUTH, BorderLayout.NORTH,
			BorderLayout.CENTER }; // 변수의 선언과 초기화

	public BorderLayoutEx2() {
		initData();
		setInitLayout();
	}

	public void initData() {
		setTitle("borderLayout 연습");
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttons = new JButton[directions.length];
	}

	public void setInitLayout() {
		// 배치 관리자 선정
		// BorderLayout -- 컴포넌트들을 동서남북가운데로 배치 시켜주는 레이아웃이다.
		setLayout(new BorderLayout());

		// 반복문을 활용해 코드를 완성하시오.
		for (int i = 0; i < buttons.length; i++) {
			add(new JButton(directions[i]), directions[i]);
		}

	}

	public static void main(String[] args) {

		new BorderLayoutEx2();

	} // end of main

} // end of class
