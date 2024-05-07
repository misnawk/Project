package handler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import createMenuPanel.CreateMenuPanel;

// 클라이언트로부터 메시지를 처리하는 클래스
public class ClientMessageHandler {

	private static ClientMessageHandler instance_client;

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

	private ClientMessageHandler() {

	}

	public static ClientMessageHandler getIntance() {
		if (instance_client == null) {
			instance_client = new ClientMessageHandler();
		}
		return instance_client;
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

						// JLabel에 메시지 설정
//						messageLbl.setText(message);

						Start(message);

//						showDialog(frame, message);

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

	public void Start(String message) {

		Sort sort = new Sort(message);
		String sortdItems = sort.sort(message);
///////////////////////////////////////////////////////////////////
		CreateMenuPanel.getInstance().get(sortdItems);

///////////////////////////////////////////////////////////////////

		clearData();
		System.out.println("clearData 실행되냐?");

	}

	public void clearData() {

		menu_name.clear(); // ArrayList 비우기
		menu_count.clear(); // ArrayList 비우기
		menu_price.clear(); // ArrayList 비우기
	}
}