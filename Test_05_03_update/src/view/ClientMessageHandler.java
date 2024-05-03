package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

// 클라이언트로부터 메시지를 처리하는 클래스
public class ClientMessageHandler {

	private JPanel bigBox;
	private JScrollPane scrollPane;
	private JPanel small;
	private JFrame frame;
	private JLabel menuPanel;
	private String string_Data;
	ArrayList<String> menu_name = new ArrayList<>();
	ArrayList<Integer> menu_count = new ArrayList<>();
	ArrayList<Integer> menu_price = new ArrayList<>();

	private String only_text;
	private JLabel name_label;
	private JLabel count_label;
	private JLabel price_label;
	private static int small_hight = 350;
	private String[] item;

	public ClientMessageHandler() {

	}

	// 서버로부터 메시지를 수신하고 처리하는 메서드
	public void messageReceived(JFrame frame, JLabel messageLbl) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// 서버 소켓 생성 및 대기
					ServerSocket serverSocket = new ServerSocket(1233);
					while (true) {
						// 클라이언트 소켓 연결
						Socket clientSocket = serverSocket.accept();

						// 클라이언트로부터 데이터를 읽고 쓰기 위한 스트림 생성
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(clientSocket.getInputStream()));
						PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

						// 클라이언트로부터 메시지 수신
						String message = reader.readLine();
						System.out.println("메세지 넘겨받음");
						// JLabel에 메시지 설정
//						messageLbl.setText(message);
						showDialog(message);

						System.out.println("showDialog() 정상실행");
						processSocketMessage(message);
//						showDialog(frame, message);
						System.out.println("다이얼로그 출력되냐");
						// 메시지 다이얼로그로 표시
//						JOptionPane.showMessageDialog(frame, message);

						// 클라이언트 소켓 닫기
						clientSocket.close();
					}
				} catch (Exception e) {
					// 예외 처리
					e.printStackTrace();
				}
			}
		}).start();
	}

	private void showDialog(String message) {
		System.out.println("show시작");
		// 부모 프레임 설정
		Window parentWindow = (frame != null) ? (Window) frame : null;

		// 다이얼로그 생성
		JDialog dialog = new JDialog(parentWindow, Dialog.ModalityType.APPLICATION_MODAL);
		dialog.setTitle("Message Dialog"); // 다이얼로그 제목 설정
		dialog.setSize(800, 600);
		dialog.setLocationRelativeTo(parentWindow);
		dialog.setLayout(new GridBagLayout());

		////////////////////////////////////////////////////////////////////////////////////////

		GridBagConstraints gbc1 = new GridBagConstraints(); // 새로운 GridBagConstraints 객체 생성
		gbc1.gridx = 0; // x축의 그리드 위치 설정
		gbc1.gridy = 1; // y축의 그리드 위치 설정
		gbc1.weightx = 1.0; // x축의 가중치 설정
		gbc1.weighty = 0.2; // y축의 가중치 설정
		gbc1.fill = GridBagConstraints.BOTH; // 채우기 옵션을 "BOTH"로 설정하여 수평 및 수직 방향으로 모두 채움

		JPanel pan_1 = new JPanel(); // 판넬생성
		pan_1.setBackground(Color.yellow); // 판넬 색지정
		pan_1.setLayout(null); // 판넬 레이아웃지정
		dialog.getContentPane().add(pan_1, gbc1); // 프레임.추가(컴포넌트,레이아웃설정)
		// 다이얼로그 크기 및 위치 설정

		////////////////////////////////////////////////////////////////////////////////////////

		GridBagConstraints gbc2 = new GridBagConstraints(); // 새로운 GridBagConstraints 객체 생성
		gbc2.gridx = 0; // x축의 그리드 위치 설정
		gbc2.gridy = 0; // y축의 그리드 위치 설정
		gbc2.weightx = 1.0; // x축의 가중치 설정
		gbc2.weighty = 0.8; // y축의 가중치 설정
		gbc2.fill = GridBagConstraints.BOTH; // 채우기 옵션을 "BOTH"로 설정하여 수평 및 수직 방향으로 모두 채움
		JPanel pan_2 = new JPanel(); // 판넬생성
		pan_2.setBackground(Color.blue); // 판넬 색지정
		pan_2.setLayout(null); // 판넬 레이아웃지정
		dialog.getContentPane().add(pan_2, gbc2); // 프레임.추가(컴포넌트,레이아웃설정)
		////////////////////////////////////////////////////////////////////////////////////////

		bigBox = new JPanel();
		bigBox.setBackground(Color.decode("#D3D3D3")); // 회색
		bigBox.setLayout(null);
		bigBox.setBounds(80, 30, 600, 400);
		pan_2.add(bigBox);
		////////////////////////////////////////////////////////////////////////////////////////

		scrollPane = new JScrollPane(); // small을 스크롤 가능한 패널로 감쌈
		scrollPane.setBounds(25, 30, 550, 350); // scrollPane의 크기 설정
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 가로 사용X
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // 수직 스크롤 항상 표시
		bigBox.add(scrollPane); // 스크롤 패널을 bigBox에 추가
		////////////////////////////////////////////////////////////////////////////////////////

		small = new JPanel();
		small.setBackground(Color.decode("#ADD8E6")); // 하늘
		small.setLayout(null);
		small.setPreferredSize(new Dimension(550, small_hight));
		scrollPane.setViewportView(small);

		///////////////////////////////////////////////////////////////////////////////////////

		JButton OK_Button = new JButton("확인");// 확인버튼
		OK_Button.setBounds(130, 30, 200, 70);
		OK_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 확인 버튼이 클릭되었을 때 처리할 내용
				// 데이터를 다른 클래스로 전달하는 예시

				System.out.println("리스트값 가져오나");

				GUIManager.getInstance1().Create(item);

				dialog.dispose();

			}
		});

		pan_1.add(OK_Button);

		JButton Cancel_Button = new JButton("취소"); // 취소버튼
		Cancel_Button.setBounds(400, 30, 200, 70);
		pan_1.add(Cancel_Button);
		Cancel_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 다이얼로그를 닫음
				dialog.dispose();
			}
		});

		processSocketMessage(message);
		dialog.setVisible(true);
		////////////////////////////////////////////////////////////////////////////////////////

	}

	public void processSocketMessage(String message) {

		sort(message);
		System.out.println("sort 실행되냐?");

		createMenuPanel();
		System.out.println("createMenuPanel 실행되냐?");

		clearData();
		System.out.println("clearData 실행되냐?");

	}

	public void sort(String message) {
		int j = message.lastIndexOf('@'); // 마지막 @기준 앞에있는 문자열의 길이를 구한다.
		only_text = message.substring(0, j); // 마지막 @뒤의 글자를 뺀 나머지 문자열을 저장
		item = only_text.split("@"); // 마지막 @를 제거한 문자열 저장

		for (int i = 0; i < item.length; i++) {
			string_Data = item[i];
//			System.out.println("1 - " + string_Data); // @기준으로 나눔
			String[] str = item[i].split(";");
			menu_name.add(str[0]);
			menu_count.add(Integer.parseInt(str[1]));
			menu_price.add(Integer.parseInt(str[2]));
		}
		System.out.println("1 - " + string_Data); // @기준으로 나눔
	}

	private void createMenuPanel() {
		int yPosition = 10; // 테두리 간격 추가
		for (int i = 0; i < item.length; i++) {
//			System.out.printf("라벨 반복문 %d번 실행", i + "\n");
			System.out.println("반복문 들어가나");

			menuPanel = new JLabel();
			menuPanel.setBorder(new LineBorder(Color.black)); // 검정색 테두리 추가
			menuPanel.setBounds(5, yPosition, 520, 70);
			menuPanel.setLayout(null);
			small.add(menuPanel);

			////////////////////////////////////////////////////////////////////////////////////////

			name_label = new JLabel(menu_name.get(i));
			name_label.setBounds(15, 10, 150, 50);
			name_label.setLayout(null);
			menuPanel.add(name_label);
			////////////////////////////////////////////////////////////////////////////////////////

			count_label = new JLabel("" + menu_count.get(i));
			count_label.setBounds(185, 10, 150, 50);
			name_label.setLayout(null);
			menuPanel.add(count_label);
			////////////////////////////////////////////////////////////////////////////////////////

			price_label = new JLabel("" + menu_price.get(i));
			price_label.setBounds(355, 10, 150, 50);
			name_label.setLayout(null);
			menuPanel.add(price_label);

			System.out.println("small에 라벨 저장");
			yPosition += 80; // 테두리 간격 추가
			System.out.println("라벨의 y축 길이" + yPosition);

			////////////////////////////////////////////////////////////////////////////////////////

			if (yPosition > 350) {
				small.setPreferredSize(new Dimension(550, small_hight += 80));
				System.out.println("small의 높이가 70커짐");
				System.out.println("small의 y축 길이" + small.getHeight());
//				scrollPane.revalidate();
//				bigBox.repaint();
			}

			small.revalidate();
			small.repaint();
//			small.repaint(); // JPanel을 다시 그릴 때 호출
			////////////////////////////////////////////////////////////////////////////////////////

		}
//		messageReceived(frame, count_label);
	}

	public void clearData() {

		menu_name.clear(); // ArrayList 비우기
		menu_count.clear(); // ArrayList 비우기
		menu_price.clear(); // ArrayList 비우기
	}
}