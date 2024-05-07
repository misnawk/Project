package handler;

public class Sort {

	private static Sort instance_sort;
	private String message;
	public String[] items;
	private String temp = "";

	public Sort(String message) {

		this.message = message;
	}

	public String sort(String message) {
		int lastIndex = message.lastIndexOf("@");
		String result = message.substring(0, lastIndex);

		String items[] = result.split("@");

		for (String item : items) {
			String[] components = item.split(";");
			String name = components[0];
			String count = components[1];
			String price = components[2];

			temp += name + " " + count + "개 " + price + "원;";
		}
		System.out.println(temp);
		return temp;
	}

}
