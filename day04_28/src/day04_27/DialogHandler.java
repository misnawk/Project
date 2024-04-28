package day04_27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 클라이언트로부터 메시지를 처리하는 클래스
public class DialogHandler {
//	DialogForm dialogForm = new DialogForm();

	// 서버로부터 메시지를 수신하고 처리하는 메서드
	public void messageReceived() {
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
						DialogForm.dialogForm().processSocketMessage(message);
//						dialogForm.processSocketMessage(message); // dialogForm에게 메세지 전송
//						System.out.println("메세지를 보냄");

//						messageLbl.setText(message);

						// 메시지 다이얼로그로 표시
//						JOptionPane.showMessageDialog(frame, message);

//						dialogForm.processSocketMessage(message); // 메시지 처리 메서드 호출

//
//						DialogForm dialogForm = new DialogForm();
//						dialogForm.processSocketMessage(message);

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
}