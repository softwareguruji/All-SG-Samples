package hackerrank;

import java.util.Scanner;

public class WeekCode35_1_RegEx {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		String nameToConsider = null;
		String minValueToConsider = null;

		for (int a0 = 0; a0 < n; a0++) {
			String name = in.next();
			String valueStr = in.next();

			if (valueStr.contains("7") && valueStr.contains("4")) {
				int _7Counter = 0;
				int _4Counter = 0;
				int _otherCount = 0;
				for (char ch : valueStr.toCharArray()) {
					if (ch == '7') {
						_7Counter++;
					} else if (ch == '4') {
						_4Counter++;
					} else {
						break;
					}
				}
				if (_7Counter == _4Counter && _otherCount == 0) {
					if (minValueToConsider == null) {
						minValueToConsider = valueStr;
						nameToConsider = name;
					} else {
						if (Long.parseLong(valueStr) < Long.parseLong(minValueToConsider)) {
							minValueToConsider = valueStr;
							nameToConsider = name;
						}
					}
				}
			}
		}

		if (nameToConsider == null) {
			System.out.println("-1");
		} else {
			System.out.println(nameToConsider);
		}
		in.close();

	}
}
