package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Practice extends JFrame implements ActionListener {

	private JPanel panel1;
	private JPanel panel2;
	private JButton button1;
	private JButton button2;
	private JButton button3;

	public Practice() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		button1 = new JButton("button1");
		button2 = new JButton("button2");
		button3 = new JButton("button3");
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel1.setBackground(Color.yellow);
		panel2.setBackground(Color.cyan);
	}

	private void setInitLayout() {
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		setVisible(true);
	}

	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		JButton selectedButton = (JButton) e.getSource();
		if (selectedButton == this.button1) {
			System.out.println("button1 객체가 눌러졌다고 판명 가능");
			panel1.setBackground(Color.yellow);
		}
		if (selectedButton == this.button2) {
			System.out.println("button2 객체가 눌러졌다고 판명 가능");
			panel1.setBackground(Color.blue);
		}
		if (selectedButton == this.button3) {
			System.out.println("button3 객체가 눌러졌다고 판명 가능");
			panel1.setBackground(Color.orange);
		}
	}

	// 코드 테스트
	public static void main(String[] args) {
		new Practice();
	}

}
