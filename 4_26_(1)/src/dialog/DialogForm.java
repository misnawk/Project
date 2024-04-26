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

        JPanel bigBox = new JPanel();
        bigBox.setBackground(Color.decode("#6699CC")); // 파랑
        bigBox.setLayout(null);
        bigBox.setBounds(110, 30, 650, 550);
        background.add(bigBox);

        JPanel small = new JPanel();
        small.setBackground(Color.decode("#ADD8E6")); // 하늘
        small.setLayout(null);
        small.setBounds(25, 30, 600, 500);
        bigBox.add(small);
        
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

        
        label = new JLabel(); //검정색 라인
        label.setBounds(5, 10, 580, 50);
        label.setBorder(new LineBorder(Color.black));
        small.add(label);
 

        JScrollPane scrollPane = new JScrollPane(small);
        scrollPane.setBounds(25, 30, 600, 500);// 기존 크기 유지
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        bigBox.add(scrollPane); // 
        
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(20, 50));
       
        
        
        DialogHandler dialogHandler = new DialogHandler();
        dialogHandler.messageReceived(frame, label);
    }
}