/*
 * 
In the XYZ society, the neighbours hate each other for their attitude. Various activities are organized in the society for Welcoming the New Year. The tickets were provided to each house with an integer written on it. Some got tickets with positive integers and some got tickets with negative integers. In the evening, people had to carry their tickets to the club house where the eligible ones will get the exciting gifts. The eligibility of winning the gift depends on the maximum sum which can be formed from the tickets numbers keeping in mind that neighbours hate each other. Since the neighbours hate each other, the two cannot be together in the list of maximum sum. 
The President of the society, Mr. Singh, is a wise men and know that neighbours in society don't like each other. Also, he don't wish to become bad in front of people. So, he came up with an idea to design a program which will provide the list of integers forming maximum sum and thus all the members of the list will be given the gifts. The only problem with this idea is that he don't know programming so he is asking you to provide the correct list of integers. The people may be annoying but are smart and will fight if the list provided by you doesn't form the maximum sum.

Note: The integer written on ticket of individuals may or may not be unique. In case, when there are two list with equal maximum sum, the list with first greater element would be considered. For better understanding, look at the explanation of Test case 4 in Sample Test Case. The tickets with integer 0 are not considered for winning the gifts.

Input Format

The first line of input consist of number of test cases, T.

The first line of each test case consist of the number of houses (tickets distributed) in society, N.

The second line of each test case consist of N space separated tickets with integer written on them.



Constraints

1<= T <=10

1<= N <=10000

-1000<= Integer_on_Ticket <=1000


Output Format
For each test case, print the ticket numbers in a single line forming the maximum sum in the format similar to Sample Test Case.


Sample TestCase 1
Input
5
5
-1 7 8 -5 4
4
3 2 1 -1
4
11 12 -2 -1
4
4 5 4 3
4
5 10 4 -1
Output
48
13
12
44
10
Explanation

Test Case 1: Maximum sum which can be formed is 12. Element considered 8, 4. Note that Output is printed from the reverse side of the array which is TRUE for all the test cases without the space. So, the output is 48.
Test Case 2: Maximum sum which can be formed is 4. Element considered 3, 1. Output = 13.
Test Case 3: Maximum sum which can be formed is 12 as by taking any other element value of maximum sum decreases.
Test Case 4: Maximum sum which can be formed is 8 by taking 3, 5 or 4, 4. But the output is 4, 4 as 3 is smaller than 4.
Test Case 5: Maximum sum which can be formed is 10.

https://www.techgig.com/codegladiators/question/MVZBbllQMFp0aFZQY1RWbER6cGw0bmk4TDViNEl4VlkrQ0FxYk5TOTZvVT0=/1&msg_type=1

 * 
 */
package techgig.exams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NeighboursandNewYearParty2 {

	public static void main(String[] args) {

		
		Scanner in = new Scanner(System.in);
		int totalTestCase = Integer.parseInt(in.nextLine());
		String[] testCaseResult = new String[totalTestCase];
		
		StringToIntArray fStringIntObj = (String s) -> {
			String[] tokens = s.split(" ");
			int[] ary = new int[tokens.length];

			int i = 0;
			for (String token : tokens){
			    ary[i++] = Integer.parseInt(token); 
			}
			return ary;
		};
		
		for (int testCase = 0; testCase < totalTestCase; testCase++) {

			int numberOfHouses = Integer.parseInt(in.nextLine());
			String ticketsPerHouseStr = in.nextLine();
			
			int[] ticketsPerHouse = fStringIntObj.stringToInt(ticketsPerHouseStr);
			
			int ticketMaxValue = -1;
			for (int i : ticketsPerHouse) {
				if(ticketMaxValue < i) {
					ticketMaxValue = i;
				}
			}

			List<Integer> combineSelection = null;
			
			int addition = 0;
			List<Integer> lastSelected = new ArrayList<>();
			for(int j=0; j <= ticketsPerHouse.length - 2; j = j + 2){
				addition = 0;
				lastSelected = new ArrayList<>();
				for(int i = 0; i <= j; i = i + 2) {
					addition = ticketsPerHouse[i] + addition; 
					lastSelected.add(ticketsPerHouse[i]);
				}
				if(addition > ticketMaxValue) {
					ticketMaxValue = addition;
					combineSelection = lastSelected;
				}
			}
			
			for(int j=1; j <= ticketsPerHouse.length - 3; j = j + 2){
				addition = 0;
				lastSelected = new ArrayList<>();
				for(int i = 1; i <= j; i = i + 2) {
					addition = ticketsPerHouse[i] + addition; 
					lastSelected.add(ticketsPerHouse[i]);
				}
				if(addition > ticketMaxValue) {
					ticketMaxValue = addition;
					combineSelection = lastSelected;
				}
			}
		
			for(int j=ticketsPerHouse.length - 1; j >= 1; j = j - 2){
				addition = 0;
				lastSelected = new ArrayList<>();
				for(int i = ticketsPerHouse.length - 1; i >= j; i = j - 2) {
					addition = ticketsPerHouse[i] + addition; 
					lastSelected.add(ticketsPerHouse[i]);
				}
				if(addition > ticketMaxValue) {
					ticketMaxValue = addition;
					combineSelection = lastSelected;
				}
			}
			
			for(int j=ticketsPerHouse.length - 2; j >= 2; j = j - 2){
				addition = 0;
				lastSelected = new ArrayList<>();
				for(int i = ticketsPerHouse.length - 2; i >= j; i = i - 2) {
					addition = ticketsPerHouse[i] + addition; 
					lastSelected.add(ticketsPerHouse[i]);
				}
				if(addition > ticketMaxValue) {
					ticketMaxValue = addition;
					combineSelection = lastSelected;
				}
			}
		
			if(combineSelection != null) {
				StringBuffer result = new StringBuffer();
				for (int i = combineSelection.size()-1; i >= 0; i--) {
					result.append(combineSelection.get(i)+"");
				}
				testCaseResult[testCase] = result.toString();
				
			}else {
				testCaseResult[testCase] = ticketMaxValue+"";
			}
			
		}
		
		for (String tcr : testCaseResult) {
			System.out.println(tcr);
		}
		
	}

	
}
