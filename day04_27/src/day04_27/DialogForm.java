package day04_27;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class DialogForm {

	private JFrame frame;
	private JLabel label;
	private JPanel menuPanel;
	private Panel small;
	private Container check_panel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	DialogForm() {
		initialize();

	}

	public void show() {
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setLayout(null);
		frame.setBounds(100, 100, 900, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel background = new JPanel();
		background.setBackground(Color.decode("#D3D3D3")); // 회색
		background.setLayout(null);
		background.setBounds(10, 10, 860, 740);
		frame.add(background);

		JPanel bigBox = new JPanel();
		bigBox.setBackground(Color.decode("#6699CC")); // 파랑
		bigBox.setLayout(null);
		bigBox.setBounds(110, 30, 650, 550);
		background.add(bigBox);

		JPanel small = new JPanel();
		small.setBackground(Color.decode("#ADD8E6")); // 하늘
		small.setLayout(null);
		small.setBounds(25, 30, 600, 500);
		bigBox.add(small);
//
//		label = new JLabel(); // 값을 받아오는 라벨 과 검정색 박스
//		label.setBounds(5, 10, 580, 50);
//		label.setBorder(new LineBorder(Color.black));
//		small.add(label);
//
//		label = new JLabel(); // 값을 받아오는 라벨 과 검정색 박스
//		label.setBounds(5, 65, 580, 50);
//		label.setBorder(new LineBorder(Color.black));
//		small.add(label);
//
//		label = new JLabel(); // 값을 받아오는 라벨 과 검정색 박스
//		label.setBounds(5, 120, 580, 50);
//		label.setBorder(new LineBorder(Color.black));
//		small.add(label);
//
//		label = new JLabel(); // 값을 받아오는 라벨 과 검정색 박스
//		label.setBounds(5, 175, 580, 50);
//		label.setBorder(new LineBorder(Color.black));
//		small.add(label);
//
//		label = new JLabel(); // 값을 받아오는 라벨 과 검정색 박스
//		label.setBounds(5, 230, 580, 50);
//		label.setBorder(new LineBorder(Color.black));
//		small.add(label);
//
//		label = new JLabel(); // 값을 받아오는 라벨 과 검정색 박스
//		label.setBounds(5, 285, 580, 50);
//		label.setBorder(new LineBorder(Color.black));
//		small.add(label);
//
//		label = new JLabel(); // 값을 받아오는 라벨 과 검정색 박스
//		label.setBounds(5, 340, 580, 50);
//		label.setBorder(new LineBorder(Color.black));
//		small.add(label);
//
//		label = new JLabel(); // 값을 받아오는 라벨 과 검정색 박스
//		label.setBounds(5, 395, 580, 50);
//		label.setBorder(new LineBorder(Color.black));
//		small.add(label);
//
//		label = new JLabel(); // 값을 받아오는 라벨 과 검정색 박스
//		label.setBounds(5, 450, 580, 50);
//		label.setBorder(new LineBorder(Color.black));
//		small.add(label);

		JButton OK_Button = new JButton("확인");// 확인버튼
		OK_Button.setBounds(100, 600, 200, 100);
		background.add(OK_Button);

		JButton Cancel_Button = new JButton("취소"); // 취소버튼
		Cancel_Button.setBounds(560, 600, 200, 100);
		background.add(Cancel_Button);

		JScrollPane scrollPane = new JScrollPane(small);
		scrollPane.setBounds(25, 30, 600, 500);// 기존 크기 유지
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		bigBox.add(scrollPane); //
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(20, 50));

		// 메세지를 클라이언트로부터 받으면 반응하는 메서드

		// 메뉴를 나타내는 JPanel을 생성하는 메서드

		// 받아온 라벨이 화면을 넘어가는 높이
//        int totalHight = label.getHeight();
//        System.out.println(totalHight);

		DialogHandler dialogHandler = new DialogHandler();
		dialogHandler.messageReceived(frame, label);

	}

	public void processSocketMessage(String message) {

		createMenuPanel();

		// 메시지 라벨을 생성합니다.
		JLabel newLabel = new JLabel(message);
		newLabel.setBounds(30, menuPanel.getComponentCount() * 90, 730, 80);
		newLabel.setBackground(Color.yellow);
		newLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		newLabel.setOpaque(true);

		JButton order_button_ok = new JButton("주문확인"); // 주문확인버튼 생성
		order_button_ok.setBounds(100, 600, 100, 100);
		check_panel.add(order_button_ok);

		JButton order_button_cancel = new JButton("주문취소"); // 주문취소 버튼
		order_button_cancel.setBounds(150, 600, 100, 100);
		check_panel.add(order_button_cancel);

		// 메뉴 패널에 메시지 라벨을 추가합니다.
		small.add(newLabel);

		// 변경 사항을 반영하기 위해 패널을 다시 그립니다.
		small.revalidate();
		small.repaint();
	}

	private void createMenuPanel() {
		// 메뉴를 나타내는 JPanel 객체 생성 및 추가
		menuPanel = new JPanel();
		menuPanel.setBounds(380, 20, 200, 30);// 주문확인, 주문취소 판넬
		label.setBorder(new LineBorder(Color.black)); // 검정색 박스

		menuPanel.setLayout(null);
		small.add(menuPanel);

	}

}
