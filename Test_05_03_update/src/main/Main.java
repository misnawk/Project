package main;

import java.awt.EventQueue;

import view.GUIManager;

public class Main {
	public static void main(String[] args) {
		// EventQueue.invokeLater()을 사용하여 GUI를 생성하고 표시합니다.
		EventQueue.invokeLater(() -> {
			try {
				// GUIManager의 인스턴스를 생성하고 GUI를 표시합니다.
				GUIManager guiManager = GUIManager.getInstance1();
				guiManager.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
