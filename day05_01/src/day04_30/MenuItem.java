package day04_30;

import java.util.HashMap;

public class MenuItem {
	private String menu_name;
	private String menu_count;
	private String menu_price;
	private HashMap<Integer, MenuItem> menuitemMap;

	public MenuItem(String name, String count, String price) {
		this.menu_name = name;
		this.menu_count = count;
		this.menu_price = price;

		if (menuitemMap == null) {
			menuitemMap = new HashMap<>();

		}
	}

}
