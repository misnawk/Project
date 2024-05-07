package createMenuPanel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreateMenuPanel {
	private static CreateMenuPanel instance_createMenuPanel;
	private int yPosition;
	private String sortdItems;
	private JPanel label_panel;

	private CreateMenuPanel() {

	}

	public static CreateMenuPanel getInstance() {
		if (instance_createMenuPanel == null) {
			instance_createMenuPanel = new CreateMenuPanel();
		}
		return instance_createMenuPanel;
	}

	public void get(String sortdItems) {
		this.sortdItems = sortdItems;
	}

	public JPanel Create(JPanel jPanel) {

		String[] item = sortdItems.split(";");

		for (int i = 0; i < item.length; i++) {

			JPanel label_panel = new JPanel();
			label_panel.setBounds(10, yPosition, 500, 50);
			label_panel.setLayout(null);
			yPosition += 50;

			JLabel name_label = new JLabel();
			name_label.setText(item[i]);
			name_label.setBounds(5, 5, 400, 40);
			name_label.setLayout(null);
			label_panel.add(name_label);
		}
		return label_panel;

	}
}
