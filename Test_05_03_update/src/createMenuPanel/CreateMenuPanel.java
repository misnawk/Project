package createMenuPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreateMenuPanel {
	private static CreateMenuPanel instance_createMenuPanel;
	private String[] sortdItems;
	private JPanel label_panel;
	private int yPosition_gui = 10;

	private CreateMenuPanel() {

	}

	public static CreateMenuPanel getInstance() {
		if (instance_createMenuPanel == null) {
			instance_createMenuPanel = new CreateMenuPanel();
		}
		return instance_createMenuPanel;
	}

	public void set(String[] sortdItems) {
		this.sortdItems = sortdItems;

	}

	public JPanel create_dialog(JPanel small) {

		int yPosition = 10;
		for (int i = 0; i < sortdItems.length; i++) {

			JPanel label_panel = new JPanel();
			label_panel.setBounds(10, yPosition, 500, 50);
			label_panel.setBackground(Color.decode("#ADD8E6")); // 하늘
			label_panel.setLayout(null);

			JLabel name_label = new JLabel();
			name_label.setText(sortdItems[i]);
			name_label.setBounds(5, 5, 400, 40);
			name_label.setLayout(null);
			label_panel.add(name_label);

			small.add(label_panel);
			yPosition += 50;
		}
		return small;

	}

	// =============================================================================//

	public void create_gui(JPanel menuPanel) {
		int xPosition = 10;

		for (String data : sortdItems) {
			JLabel label_panel = new JLabel(data + " ");

			label_panel.setBounds(xPosition, yPosition_gui, 500, 50);
			label_panel.setLayout(null);
			label_panel.setText(data);
			xPosition += 200;

			menuPanel.add(label_panel);
		}
		yPosition_gui += 100;

	}
}
