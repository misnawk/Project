package day04_27;

import java.awt.EventQueue;

public class DMain {
	public static void main(String[] ar0gs) {
		EventQueue.invokeLater(() -> {
			try {
				// DialogForm의 인스턴스를 생성하고 show() 메서드 호출

				DialogForm dialogForm = DialogForm.dialogForm();
				dialogForm.show();

			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
