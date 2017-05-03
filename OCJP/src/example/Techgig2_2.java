package example;

public class Techgig2_2 {

	public static void main(String[] args) {
		System.out.println(appearanceCount(4, 11, "cAda", "AbrAcadAbRa"));
	}

	public static String S = null;
	public static int countI = 0;
	public static int appearanceCount(int lenW, int lenS, String W, String S) {
		Techgig2_2.S = S;
		perm(W);
		
		/*for (String pS : l) {
			if(S.contains(pS)){
				countI++;
			}
		}*/
		return countI;
	}

	//public static ArrayList<String> l = new ArrayList<String>();

	public static void perm(String strForPermute) {
		perm("", strForPermute);
		//System.out.println("Length : "+l.size());
	}

	private static void perm(String prefix, String s) {
		int n = s.length();
		if (n == 0){
			//l.add(prefix);
			if(S.contains(prefix)){
				countI++;
			}
		}
		else {
			for (int i = 0; i < n; i++)
				perm(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n));
		}
	}
}
