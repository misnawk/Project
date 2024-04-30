package day04_30;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class DialogForm {
	private JFrame frame;
	private JLabel menuPanel;
	private JPanel small;
	private Container check_panel;
	private JButton order_button_ok;
	private JButton order_button_cancel;
	private String string_Data;
	ArrayList<String> menu_name = new ArrayList<>();
	ArrayList<Integer> menu_count = new ArrayList<>();
	ArrayList<Integer> menu_price = new ArrayList<>();
	private String only_text;
	private JLabel name_label;
	private JLabel count_label;
	private JLabel price_label;
	private int yPosition = 10;
	private JScrollPane scrollPane;
	private String[] item;

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
		frame.setBounds(100, 100, 800, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel background = new JPanel();
		background.setBackground(Color.decode("#D3D3D3")); // 회색
		background.setLayout(null);
		background.setBounds(10, 10, 760, 540);
		frame.add(background);

		JPanel bigBox = new JPanel();
		bigBox.setBackground(Color.decode("#6699CC")); // 파랑
		bigBox.setLayout(null);
		bigBox.setBounds(80, 30, 600, 400);
		background.add(bigBox);

		small = new JPanel();
		small.setBackground(Color.decode("#ADD8E6")); // 하늘
		small.setLayout(null);
		small.setLayout(new BoxLayout(small, BoxLayout.Y_AXIS)); // 세로 방향으로 배치
		small.setBounds(25, 30, 550, 350);
		bigBox.add(small);

		JButton OK_Button = new JButton("확인");// 확인버튼
		OK_Button.setBounds(140, 435, 200, 100);
		background.add(OK_Button);

		JButton Cancel_Button = new JButton("취소"); // 취소버튼
		Cancel_Button.setBounds(400, 435, 200, 100);
		background.add(Cancel_Button);

		scrollPane = new JScrollPane(small);
		scrollPane.setBounds(25, 30, 550, 350);
//		small.setPreferredSize(new Dimension(1000, small.getPreferredSize().height)); // small x축 1000지정
//		small.setPreferredSize(new Dimension(small.getPreferredSize().width, 500));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(20, 50));

		bigBox.add(scrollPane);
		bigBox.setVisible(true);

		DialogHandler dialogHandler = new DialogHandler();
		dialogHandler.messageReceived();
	}

	public void processSocketMessage(String message) {
		sort(message);
		createMenuPanel();
		// 메시지 라벨을 생성합니다.

		scroll();

	}

	public void scroll() {

//		System.out.println(small.getHeight());
	}

	private void createMenuPanel() {
		System.out.println("createMenuPanel 메서드 들어오냐!!");
		for (int i = 0; i < item.length; i++) {
			System.out.println("for문 들어오냐!!");

			menuPanel = new JLabel();// 데이터가 들어가는 공간
			System.out.println("menuPanel 객체만들어지냐");
			menuPanel.setBorder(new LineBorder(Color.black)); // 검정색 테두리 추가
			menuPanel.setBounds(5, yPosition, 520, 70);
			menuPanel.setLayout(null);
			small.add(menuPanel);
			System.out.println("menuPanel 만들어지냐");

			name_label = new JLabel(menu_name.get(i));// 제품의 이름이 들어가는 박스
			name_label.setBorder(new LineBorder(Color.black)); // 검정색 테두리 추가
			name_label.setBounds(15, 10, 150, 50);
			name_label.setLayout(null);
			menuPanel.add(name_label);

			count_label = new JLabel("" + menu_count.get(i));// 제품의 개수가 들어가는 박스
			count_label.setBorder(new LineBorder(Color.black)); // 검정색 테두리 추가
			count_label.setBounds(185, 10, 150, 50);
			count_label.setLayout(null);
			menuPanel.add(count_label);

			price_label = new JLabel("" + menu_price.get(i));// 제품의 가격이 들어가는 박스
			price_label.setBorder(new LineBorder(Color.black)); // 검정색 테두리 추가
			price_label.setBounds(355, 10, 150, 50);
			price_label.setLayout(null);
			menuPanel.add(price_label);

			this.yPosition += 100;
		}

//
//		System.out.println(this.yPosition + "높이");

		small.repaint();
	}

	public void sort(String message) {
		int j = message.lastIndexOf('@'); // 마지막 @기준 앞에있는 문자열의 길이를 구한다.
		only_text = message.substring(0, j); // 마지막 @뒤의 글자를 뺀 나머지 문자열을 저장
		item = only_text.split("@"); // 마지막 @를 제거한 문자열 저장

		for (int i = 0; i < item.length; i++) {
			string_Data = item[i];
			System.out.println("1 - " + string_Data); // @기준으로 나눔
			String[] str = item[i].split(";");
			menu_name.add(str[0]);
			menu_count.add(Integer.parseInt(str[1]));
			menu_price.add(Integer.parseInt(str[2]));
		}
	}

	public void repaint() {
		frame.revalidate(); // 크기가 변하면 초기화하는방법
		menuPanel.revalidate();
		small.repaint(); // 내용물이 변하면 초기화하는방법
	}
}
