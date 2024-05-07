package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import createMenuPanel.CreateMenuPanel;
import handler.ClientMessageHandler;

// GUIManager 클래스는 GUI를 관리하고 생성합니다.
public class GUIManager {

	private static GUIManager instance1;
	private JFrame frame; // JFrame 객체
	private JPanel pan_1; // JPanel 객체
	private JPanel pan_2; // JPanel 객체
	String name;
	int count;
	int price;
	private JLabel messageLbl;
	private JPanel menuPanel;

	private JLabel name_label;

	private JLabel count_label;

	private JLabel price_label;

	private int yPosition = 10;

	private JPanel label_panel;

	private GUIManager() {
		initialize(); // GUI 초기화 메서드 호출
	}

	// GUIManager의 인스턴스를 반환합니다.
	public static synchronized GUIManager getInstance1() {
		if (instance1 == null) {
			instance1 = new GUIManager();
		}
		return instance1;
	}

	// GUI를 표시합니다.
	public void show() {
		frame.setVisible(true);
	}

	public void set() {
		CreateMenuPanel.getInstance().create_gui(menuPanel);
		menuPanel.repaint();

	}

	// GUI를 초기화합니다.
	private void initialize() {
		// JFrame 객체 생성
		frame = new JFrame();
		frame.setBounds(100, 100, 1600, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(new GridBagLayout()); // GridBagLayout 설정
		///////////////////////////////////////////////////////////////////////////////////////

		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.fill = GridBagConstraints.BOTH;
		gbc1.weightx = 0.6;
		gbc1.weighty = 1.0;
		gbc1.gridx = 0;
		gbc1.gridy = 0;

		// JPanel 객체 생성 및 추가
		pan_1 = new JPanel();
		pan_1.setBackground(Color.black);
		pan_1.setLayout(null);
		frame.getContentPane().add(pan_1, gbc1);
		///////////////////////////////////////////////////////////////////////////////////////

		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.fill = GridBagConstraints.BOTH;
		gbc2.weightx = 0.4;
		gbc2.weighty = 1.0;
		gbc2.gridx = 1;
		gbc2.gridy = 0;

		// JPanel 객체 생성 및 추가
		pan_2 = new JPanel();
		pan_2.setBackground(Color.lightGray);
		pan_2.setLayout(null);
		frame.getContentPane().add(pan_2, gbc2);

		menuPanel = new JPanel();
		menuPanel.setBounds(20, 10, 800, 800);
		menuPanel.setBackground(Color.gray);
		menuPanel.setLayout(null);
		pan_1.add(menuPanel);

		///////////////////////////////////////////////////////////////////////////////////////

		// 클라이언트 메시지 핸들러 생성 및 메시지 수신 기능 실행
		ClientMessageHandler.getIntance().messageReceived(frame, messageLbl);
	}

}