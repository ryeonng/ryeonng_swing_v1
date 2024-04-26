package ch02;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch02.MyDrawFrame.MyDrawPanel;

// 내부 클래스를 활용해 코드를 완성해주세요.
public class PaintFrame2 extends JFrame {

	PaintPanel paintPanel;

	public PaintFrame2() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("곰인형");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		paintPanel = new PaintPanel();
	}

	private void setInitLayout() {

		add(paintPanel);
		setVisible(true);
	}

	class PaintPanel extends JPanel {
		@Override
		public void paint(Graphics g) {
			super.paint(g);

	
			
			g.drawOval(375, 445, 35, 35); // 꼬리
			
			g.drawOval(230, 100, 150, 150); // 머리
			g.drawOval(220, 250, 170, 270); // 몸
			g.drawOval(235, 290, 140, 220); // 몸
			
			g.drawOval(140, 290, 100, 30); // 왼팔
			g.drawOval(375, 290, 100, 30); // 오른팔
			
			g.drawOval(270, 160, 20, 20); // 왼쪽 눈
			g.drawOval(278, 163, 10, 10); // 왼쪽 눈알
			g.drawOval(330, 160, 20, 20); // 오른쪽 눈
			g.drawOval(331, 163, 10, 10); // 오른쪽 눈알
			
			g.drawArc(275, 170, 35, 35, 238, 75); // 스마일
			g.drawArc(296, 170, 35, 35, 238, 75); // 스마일
			
			g.drawOval(215, 100, 35, 35); // 왼쪽 귀
			g.drawOval(225, 110, 25, 25); // 왼쪽 귀속
			g.drawOval(360, 100, 35, 35); // 오른쪽 귀
			g.drawOval(360, 110, 25, 25); // 오른쪽 귀속
			
			g.drawOval(215, 490, 55, 55); // 왼쪽 발
			g.drawOval(345, 490, 55, 55); // 오른쪽 발
			
			
		}

	}
}
