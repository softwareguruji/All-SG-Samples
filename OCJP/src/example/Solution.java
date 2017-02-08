package example;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		//String str = "abcabcaba";
		//String str = "abbabbabb";
		String str = "aaaaaaaab";
		//StringBuffer str = new StringBuffer("kndccnlefejfkyeazvzljgtefccltjlfirtngilvajxkwkhhyppuowiprwvtgzgihrnjjzzbzabrloyimexnabhwdlqcbcdgfnmqwznxoetljfjdwuutrcblkrtvctqpdmjmajaihzekhtotpphigrugkwfrhiyfenisyqqmmyqjyvaczsjyoyvzgrkbyynxmtmxyysokvxkjyefuvhdnmejezoodyhuzkpyttiovnjnkxrwyyddribudddpfuttisnsrmnrtejhzwuviectwtwuiodcdgpbyivwyvehnjrawtchmzdhomkrlgcyzlnewmgfuykhyurpikdtaqiusryktgwvyubgqxrzedqyedkalpdnhqpgcpnyyilegzeoqtzihgpzdfwvsvvjtexwwdhqfhxgtebvhnmavropigfbhiilytmbjsklqthfetrghrdoooxvyxuidmuicbhyzwxoohqpbzyfhfqqlvknnwndtpflfzwnkndccnlefejfkyeazvzljgtefccltjlfirtngilvajxkwkhhyppuowiprwvtgzgihrnjjzzbzabrloyimexnabhwdlqcbcdgfnmqwznxoetljfjdwuutrcblkrtvctqpdmjmajaihzekhtotpphigrugkwfrhiyfenisyqqmmyqjyvaczsjyoyvzgrkbyynxmtmxyysokvxkjyefuvhdnmejezoodyhuzkpyttiovnjnkxrwyyddribudddpfuttisnsrmnrtejhzwuviectwtwuiodcdgpbyivwyvehnjrawtchmzdhomkrlgcyzlnewmgfuykhyurpikdtaqiusryktgwvyubgqxrzedqyedkalpdnhqpgcpnyyilegzeoqtzihgpzdfwvsvvjtexwwdhqfhxgtebvhnmavropigfbhiilytmbjsklqthfetrghrdoooxvyxuidmuicbhyzwxoohqpbzyfhfqqlvknnwndtpflfzwnkndccnlefejfkyeazvzljgtefccltjlfirtngilvajxkwkhhyppuowiprwvtgzgihrnjjzzbzabrloyimexnabhwdlqcbcdgfnmqwznxoetljfjdwuutrcblkrtvctqpdmjmajaihzekhtotpphigrugkwfrhiyfenisyqqmmyqjyvaczsjyoyvzgrkbyynxmtmxyysokvxkjyefuvhdnmejezoodyhuzkpyttiovnjnkxrwyyddribudddpfuttisnsrmnrtejhzwuviectwtwuiodcdgpbyivwyvehnjrawtchmzdhomkrlgcyzlnewmgfuykhyurpikdtaqiusryktgwvyubgqxrzedqyedkalpdnhqpgcpnyyilegzeoqtzihgpzdfwvsvvjtexwwdhqfhxgtebvhnmavropigfbhiilytmbjsklqthfetrghrdoooxvyxuidmuicbhyzwxoohqpbzyfhfqqlvknnwndtpflfzwnkndccnlefejfkyeazvzljgtefccltjlfirtngilvajxkwkhhyppuowiprwvtgzgihrnjjzzbzabrloyimexnabhwdlqcbcdgfnmqwznxoetljfjdwuutrcblkrtvctqpdmjmajaihzekhtotpphigrugkwfrhiyfenisyqqmmyqjyvaczsjyoyvzgrkbyynxmtmxyysokvxkjyefuvhdnmejezoodyhuzkpyttiovnjnkxrwyyddribudddpfuttisnsrmnrtejhzwuviectwtwuiodcdgpbyivwyvehnjrawtchmzdhomkrlgcyzlnewmgfuykhyurpikdtaqiusryktgwvyubgqxrzedqyedkalpdnhqpgcpnyyilegzeoqtzihgpzdfwvsvvjtexwwdhqfhxgtebvhnmavropigfbhiilytmbjsklqthfetrghrdoooxvyxuidmuicbhyzwxoohqpbzyfhfqqlvknnwndtpflfzwnkndccnlefejfkyeazvzljgtefccltjlfirtngilvajxkwkhhyppuowiprwvtgzgihrnjjzzbzabrloyimexnabhwdlqcbcdgfnmqwznxoetljfjdwuutrcblkrtvctqpdmjmajaihzekhtotpphigrugkwfrhiyfenisyqqmmyqjyvaczsjyoyvzgrkbyynxmtmxyysokvxkjyefuvhdnmejezoodyhuzkpyttiovnjnkxrwyyddribudddpfuttisnsrmnrtejhzwuviectwtwuiodcdgpbyivwyvehnjrawtchmzdhomkrlgcyzlnewmgfuykhyurpikdtaqiusryktgwvyubgqxrzedqyedkalpdnhqpgcpnyyilegzeoqtzihgpzdfwvsvvjtexwwdhqfhxgtebvhnmavropigfbhiilytmbjsklqthfetrghrdoooxvyxuidmuicbhyzwxoohqpbzyfhfqqlvknnwndtpflfzwnkndccnlefejfkyeazvzljgtefccltjlfirtngilvajxkwkhhyppuowiprwvtgzgihrnjjzzbzabrloyimexnabhwdlqcbcdgfnmqwznxoetljfjdwuutrcblkrtvctqpdmjmajaihzekhtotpphigrugkwfrhiyfenisyqqmmyqjyvaczsjyoyvzgrkbyynxmtmxyysokvxkjyefuvhdnmejezoodyhuzkpyttiovnjnkxrwyyddribudddpfuttisnsrmnrtejhzwuviectwtwuiodcdgpbyivwyvehnjrawtchmzdhomkrlgcyzlnewmgfuykhyurpikdtaqiusryktgwvyubgqxrzedqyedkalpdnhqpgcpnyyilegzeoqtzihgpzdfwvsvvjtexwwdhqfhxgtebvhnmavropigfbhiilytmbjsklqthfetrghrdoooxvyxuidmuicbhyzwxoohqpbzyfhfqqlvknnwndtpflfzwn");
		int n = str.length();
		Set<String> beautifulStrings = new HashSet<String>();
		long ln = 0;
		long decrement = 0;
		for(int i=0;i<n;i++){
			for(int j=i+1; j<n; j++){
				System.out.println("["+i+","+j+"]");
				StringBuffer sb = new StringBuffer(str);
				/*if(i-1 > 0 && sb.charAt(i-1) == sb.charAt(i)){
					decrement++;
				}*/
				/*if(j-1 > 0 && sb.charAt(j-1) == sb.charAt(j)){
					decrement++;
				}
				if(i+1<n && sb.charAt(i+1) == sb.charAt(i)){
					decrement--;
				}*/
				if(sb.charAt(i) == sb.charAt(j)){
					decrement++;
				}
				/*if(i-1 > 0 && j+1<n && sb.charAt(i-1) == sb.charAt(j+1)){
					decrement++;
				}*/
				/*if(i-2 > 0 && sb.charAt(i-2) == sb.charAt(i)){
					decrement++;
				}
				if(j-2 > 0 && sb.charAt(j-2) == sb.charAt(j)){
					decrement++;
				}*/
				sb.deleteCharAt(i).deleteCharAt(j-1);
				System.out.println(sb);
				beautifulStrings.add(sb.toString());
				ln++;
			}
		}
		System.out.println(beautifulStrings.size());
		System.out.println(ln);
		System.out.println(ln - decrement);
	}
}

