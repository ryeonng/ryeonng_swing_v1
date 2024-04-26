package ch02;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch02.MyDrawFrame.MyDrawPanel;

// 내부 클래스를 활용해 코드를 완성해주세요.
public class PaintFrame extends JFrame {

	PaintPanel paintPanel;

	public PaintFrame() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("Snowman");
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

			g.drawOval(230, 150, 150, 150); // 머리
			g.drawOval(185, 300, 250, 250); // 몸통
			g.drawOval(270, 210, 10, 10); // 왼쪽 눈
			g.drawOval(273, 211, 7, 7); // 왼쪽 눈알
			g.drawOval(330, 210, 10, 10); // 오른쪽 눈
			g.drawOval(330, 211, 7, 7); // 오른쪽 눈알
			g.drawString("★", 300, 400); // 별 단추 상
			g.drawString("★", 300, 450); // 별 단추 중
			g.drawString("★", 300, 500); // 별 단추 하
			g.drawArc(270, 200, 70, 70, 238, 75); // 스마일
			g.drawOval(500, 150, 7, 7);// 눈장식1
			g.drawOval(200, 250, 6, 6);// 눈장식1
			g.drawOval(100, 180, 7, 7);// 눈장식1
			g.drawOval(170, 200, 10, 10);// 눈장식1
			g.drawOval(570, 570, 10, 10);// 눈장식1
			g.drawOval(170, 200, 10, 10);// 눈장식1
			g.drawOval(450, 50, 15, 15);// 눈장식1
			g.drawOval(250, 50, 15, 15);// 눈장식1
			g.drawOval(100, 30, 15, 15);// 눈장식1
			g.drawOval(250, 50, 15, 15);// 눈장식1
			g.drawOval(300, 100, 5, 5);// 눈장식1
			g.drawOval(300, 100, 5, 5);// 눈장식1// g.drawRect(100, 100, 50, 100);
//			g.drawRect(200, 200, 150, 150);
//			// int x1, int y1, int x2, int y2
//			g.drawLine(250, 300, 300, 300);
//			g.drawOval(100, 150, 200, 300);
//			g.drawString("반가워", 400, 400);
//			g.drawString("🍓", 500, 500);
		}

	}
}
