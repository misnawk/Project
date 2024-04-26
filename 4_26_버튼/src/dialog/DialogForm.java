package dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Label;
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

        JPanel BigBox = new JPanel();
        BigBox.setBackground(Color.decode("#6699CC")); // 파랑
        BigBox.setLayout(null);
        BigBox.setBounds(110, 30, 650, 550);
        background.add(BigBox);

        JPanel small = new JPanel();
        small.setBackground(Color.decode("#ADD8E6")); // 하늘
        small.setLayout(null);
        small.setBounds(25, 30, 600, 500);
        BigBox.add(small);
        
        Panel check_panel = new Panel(); //주문확인, 주문취소 판넬
        check_panel.setBounds(380, 20, 200, 30);
        small.add(check_panel);
        
        JButton order_button_ok = new JButton("주문확인");
        order_button_ok.setBounds(100, 600, 100, 100);
        check_panel.add(order_button_ok);
        
        JButton order_button_cancel = new JButton("주문취소");
        order_button_cancel.setBounds(150, 600, 100, 100);
        check_panel.add(order_button_cancel);

        
 

        JButton OK_Button = new JButton("확인");// 확인버튼
        OK_Button.setBounds(100, 600, 200, 100);
        background.add(OK_Button);

        JButton Cancel_Button = new JButton("취소"); //취소버튼
        Cancel_Button.setBounds(560, 600, 200, 100);
        background.add(Cancel_Button);

        
        label = new JLabel();
        label.setBounds(5, 10, 580, 50);
        label.setBorder(new LineBorder(Color.black));
        small.add(label);

//        JScrollPane scrollPane = new JScrollPane(background);
//        scrollPane.setBounds(60, 30, 850, 300); // 기존 크기 유지
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        BigBox.add(scrollPane); // background 패널에 스크롤 패널을 추가
//
//        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(20, 10));
        DialogHandler dialogHandler = new DialogHandler();
        dialogHandler.messageReceived(frame, label);
    }
}
