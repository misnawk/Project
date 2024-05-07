package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import createMenuPanel.CreateMenuPanel;

public class DialogForm {
	private static DialogForm instance_DialogForm;
	private JPanel bigBox;
	private JScrollPane scrollPane;
	private JPanel small;
	private int small_hight;
	private JFrame jFrame;
	private JDialog dialog;

	public static DialogForm getInstance() {
		if (instance_DialogForm == null) {
			instance_DialogForm = new DialogForm();
		}
		return instance_DialogForm;
	}

	public void set_show() {
		Dialog();
		CreateMenuPanel.getInstance().create_dialog(small);

	}

	public void show() {
		dialog.setVisible(true);
	}

	public void Dialog() {
		System.out.println("show시작");
		jFrame = new JFrame();

		// 다이얼로그 생성
		dialog = new JDialog(jFrame, Dialog.ModalityType.APPLICATION_MODAL);
		dialog.setTitle("Message Dialog"); // 다이얼로그 제목 설정
		dialog.setSize(800, 600);
		dialog.setLocationRelativeTo(jFrame);
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
				GUIManager.getInstance1().set();
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

//		processSocketMessage(message);

		////////////////////////////////////////////////////////////////////////////////////////

	}

}
