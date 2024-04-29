package ch03;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 중첩 클래스 --> 외부, 내부 클래스로 활용 가능 내부 클래스에는 인스턴스 클래스, static 클래스가 존재
 */
public class MyImageFrame extends JFrame {

	// 내부 클래스로 정의한 데이터 타입이다.
	private MyImagePanel myImagePanel;

	public MyImageFrame() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("이미지 활용 연습");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myImagePanel = new MyImagePanel(); // 실행 > 내부클래스 > 생성자

	}

	private void setInitLayout() {
		add(myImagePanel);
		setVisible(true);
	}

	// 내부 클래스 --> static 키워드 활용 가능
	// 정적(static) 내부 클래스라고 한다.
	static class MyImagePanel extends JPanel {
		private Image image1; // 값을 넣지 않은 선언 상태
		private Image image2;
		
		public MyImagePanel() {
			// ImageIcon 이라는 데이터 타입에 getImage() 메서드 호출하면
			// image라는 데이터 타입을 만들어 낼 수 있다.
			image1 = new ImageIcon("image5.png").getImage();
			image2 = new ImageIcon("image6.png").getImage();
			// ImageIcon : 이미지를 읽어 이미지를 코드화
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(image1, 100, 100, 300, 300, null);
			g.drawImage(image2, 300, 300, 300, 300, null);
		}

	}

}
