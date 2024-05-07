package handler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;

import createMenuPanel.CreateMenuPanel;
import view.DialogForm;

// 클라이언트로부터 메시지를 처리하는 클래스
public class ClientMessageHandler {

	private static ClientMessageHandler instance_client;

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

		Sort sort = new Sort();
		String temp[] = sort.sort(message);

		System.out.println(temp + "값 출력");
///////////////////////////////////////////////////////////////////
		CreateMenuPanel.getInstance().set(temp);
		System.out.println(temp + "값을 Create클래스에 넣음");
///////////////////////////////////////////////////////////////////
		DialogForm.getInstance().set_show();
		DialogForm.getInstance().show();
///////////////////////////////////////////////////////////////////

	}

}