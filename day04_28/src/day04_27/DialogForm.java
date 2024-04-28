package day04_27;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
	private JPanel small;
	private Container check_panel;
	private JLabel messageLabel;
	private JButton order_button_ok;
	private JButton order_button_cancel;
	private static DialogForm instance;

	private DialogForm() {
		initialize();
		System.out.println("DialogForm 생성자 실행");

	}

	public void show() {
		frame.setVisible(true);
	}

	public static DialogForm dialogForm() {
		// 인스턴스가 없는 경우에만 생성합니다.
		if (instance == null) {
			instance = new DialogForm();
		}
		return instance;
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

		small = new JPanel();
		small.setBackground(Color.decode("#ADD8E6")); // 하늘
		small.setLayout(null);
		small.setBounds(25, 30, 600, 500);
		bigBox.add(small);

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
//

//		dialogHandler.messageReceived(frame, label);
		DialogHandler dialogHandler = new DialogHandler();
		dialogHandler.messageReceived();
	}

	public void processSocketMessage(String message) {
		createMenuPanel();
		// 메시지 라벨을 생성합니다.

		messageLabel = new JLabel(message);
//		newLabel.setBounds(30, menuPanel.getComponentCount() * 0, 100, 100);
		messageLabel.setBounds(0, 0, 300, 50);
//		messageLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		messageLabel.setOpaque(false);
		label.add(messageLabel);

		Insets insets = new Insets(10, 10, 10, 10); // 위, 왼쪽, 아래, 오른쪽 여백 설정
		GridBagConstraints gbc = new GridBagConstraints();

		order_button_ok = new JButton("OK"); // 주문확인버튼 생성
		order_button_ok.setFont(new Font("Arial", Font.PLAIN, 20));
		order_button_ok.setBounds(10, 10, 70, 30);
		order_button_ok.setContentAreaFilled(false);
		gbc.insets = insets;
		menuPanel.add(order_button_ok, gbc);

		order_button_cancel = new JButton("NO"); // 주문취소 버튼
		order_button_cancel.setFont(new Font("Arial", Font.PLAIN, 20));
		order_button_cancel.setBounds(70, 10, 70, 30);
		order_button_cancel.setContentAreaFilled(false);
		gbc.insets = insets;
		menuPanel.add(order_button_cancel, gbc);
//
//		// 메뉴 패널에 메시지 라벨을 추가합니다.
//		small.add(newLabel);
//
//		// 변경 사항을 반영하기 위해 패널을 다시 그립니다.
//		small.revalidate();
//		small.repaint();
	}

	private void createMenuPanel() {
		// 메뉴를 나타내는 JPanel 객체 생성 및 추가

		menuPanel = new JPanel(); // 주문확인, 주문취소 판넬
		menuPanel.setBounds(430, 10, 150, 60);
		menuPanel.setOpaque(false); // 배경색 투명하게
		small.add(menuPanel);

		label = new JLabel();
		label.setBorder(new LineBorder(Color.black)); // 검정색 박스
		label.setBounds(5, 10, 580, 50);
		menuPanel.setLayout(null);
		small.add(label);

	}
}
