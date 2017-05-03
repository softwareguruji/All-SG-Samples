package example;

public class StringExample {

	public static void main(String[] args) {
		String s = "Plug-in Base, Individual Exhaust, Side Cylinder Ports, Speed Controls";
		s = s.replaceAll("\\,", "");
		s = s.replaceAll("\\ ", "");
		s = s.replaceAll("\\-", "");
		s = s.replaceAll("\\(", "");
		s = s.replaceAll("\\)", "");
		s = s.replaceAll("\\/", "");
		System.out.println(s);
	}
}
