package dialog;

import java.awt.EventQueue;

public class DMain {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                // DialogForm의 인스턴스를 생성하고 show() 메서드 호출
            	DialogForm dialogForm = new DialogForm();
            	dialogForm.show();
               
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
