package day04_30;

import java.awt.Color;
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
	private String string_Data;
	ArrayList<String> menu_name = new ArrayList<>();
	ArrayList<Integer> menu_count = new ArrayList<>();
	ArrayList<Integer> menu_price = new ArrayList<>();
	private String only_text;
	private JLabel name_label;
	private JLabel count_label;
	private JLabel price_label;
	private static int yPosition = 10;
	private static int small_hight = 350;
	private JScrollPane scrollPane;
	private String[] item;
	private JPanel bigBox;
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

		bigBox = new JPanel();
		bigBox.setBackground(Color.decode("#6699CC")); // 파랑
		bigBox.setLayout(null);
		bigBox.setBounds(80, 30, 600, 400);
		background.add(bigBox);

		small = new JPanel();
		small.setBackground(Color.decode("#ADD8E6")); // 하늘
		small.setLayout(null);
		small.setPreferredSize(new Dimension(550, small_hight));
//		small.setBounds(25, 30, 550, 350);
//		bigBox.add(small);

		JButton OK_Button = new JButton("확인");// 확인버튼
		OK_Button.setBounds(140, 435, 200, 100);
		background.add(OK_Button);

		JButton Cancel_Button = new JButton("취소"); // 취소버튼
		Cancel_Button.setBounds(400, 435, 200, 100);
		background.add(Cancel_Button);

		scrollPane = new JScrollPane(small); // small을 스크롤 가능한 패널로 감쌈
		scrollPane.setBounds(25, 30, 550, 350); // scrollPane의 크기 설정
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 가로 사용X
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // 수직 스크롤 항상 표시

		bigBox.add(scrollPane); // 스크롤 패널을 bigBox에 추가

		DialogHandler dialogHandler = new DialogHandler();
		dialogHandler.messageReceived();
	}

	public void processSocketMessage(String message) {
		sort(message);

		createMenuPanel();

		clearData();
	}

	private void createMenuPanel() {

		for (int i = 0; i < item.length; i++) {
//			System.out.printf("라벨 반복문 %d번 실행", i + "\n");
			menuPanel = new JLabel();
			menuPanel.setBorder(new LineBorder(Color.black)); // 검정색 테두리 추가
			menuPanel.setBounds(5, yPosition, 520, 70);
			menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS)); // 세로 방향으로 배치
			menuPanel.setLayout(null);
			small.add(menuPanel);

			yPosition += 80; // 테두리 간격 추가
			System.out.println("라벨의 y축 길이" + yPosition);

			name_label = new JLabel(menu_name.get(i));
			name_label.setBounds(15, 10, 150, 50);
			name_label.setLayout(null);
			menuPanel.add(name_label);

			count_label = new JLabel("" + menu_count.get(i));
			count_label.setBounds(185, 10, 150, 50);
			name_label.setLayout(null);
			menuPanel.add(count_label);

			price_label = new JLabel("" + menu_price.get(i));
			price_label.setBounds(355, 10, 150, 50);
			name_label.setLayout(null);
			menuPanel.add(price_label);

			if (yPosition > 350) {
				small.setPreferredSize(new Dimension(550, small_hight += 80));
				System.out.println("small의 높이가 70커짐");
				System.out.println("small의 y축 길이" + small.getHeight());
//				scrollPane.revalidate();
//				bigBox.repaint();
			}
			small.repaint();
//			small.repaint(); // JPanel을 다시 그릴 때 호출

		}

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

	public void clearData() {
		menu_name.clear(); // ArrayList 비우기
		menu_count.clear(); // ArrayList 비우기
		menu_price.clear(); // ArrayList 비우기
	}

}
