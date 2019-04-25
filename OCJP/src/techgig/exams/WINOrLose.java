/*
 * 
A new fighting game has become popular. There are N number of villains with each having some strength. There are N players in the game with each having some energy. The energy is used to kill the villains. The villain can be killed only if the energy of the player is greater than the strength of the villain. 

Maxi is playing the game and at a particular time wants to know if it is possible for him to win the game or not with the given set of energies and strengths of players and villains. Maxi wins the game if his players can kill all the villains with the allotted energy.


Input Format

The first line of input consist of number of test cases, T.

The first line of each test case consist of number of villains and player, N.

The second line of each test case consist of the N space separated strengths of Villains.

The third line of each test case consist of N space separated energy of players.


Constraints

1<= T <=10

1<= N <=1000

1<= strength , energy <=100000


Output Format
For each test case, Print WIN if all villains can be killed else print LOSE in separate lines.

Sample TestCase 1
Input
1
6
112 243 512 343 90 478
500 789 234 400 452 150
Output
WIN

Explanation

For the given test case, If we shuffle the players and villains, we can observe that all the villains can be killed by players.


Player
	

Villain
	

RESULT

500
	

478
	

WIN

789
	

512
	

WIN

234
	

112
	

WIN

400
	

243
	

WIN

452
	

343
	

WIN

150
	

90
	

WIN

As all the villains can be killed by the players, MAXI will WIN the game. Thus, the final output is WIN.

Sample TestCase 2
Input
2
6
10 20 50 100 500 400
30 20 60 70 90 490
5
10 20 30 40 50
40 50 60 70 80
Output
LOSE
WIN

https://www.techgig.com/codegladiators/question/b09IYUxYaTI5ZjFBblozalMxNnErNjlyZ01jRkZRK2RyRDh1T2t0dnVlcTNIaXAvZ3ZyTnZPakluS1ZlU2UwcQ==/1&msg_type=1

 * 
 */



package techgig.exams;

import java.util.Scanner;

public class WINOrLose {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int totalTestCase = Integer.parseInt(in.nextLine());
		String[] testCaseResult = new String[totalTestCase];
		
		for (int testCase = 0; testCase < totalTestCase; testCase++) {
			int maxPlayer = Integer.parseInt(in.nextLine());
			String villainStrengthStr = in.nextLine();
			String playerEnergy = in.nextLine();
					
			StringToIntArray fStringIntObj = (String s) -> {
				String[] tokens = s.split(" ");
				int[] ary = new int[tokens.length];

				int i = 0;
				for (String token : tokens){
				    ary[i++] = Integer.parseInt(token); 
				}
				return ary;
			};
			
			int[] villainstrength = fStringIntObj.stringToInt(villainStrengthStr);
			int[] playerenergy = fStringIntObj.stringToInt(playerEnergy);
			
			GetMaxOfArray fMaxObj = (int x[]) -> {
				int maxValue = -1;
				for(int i=0; i<x.length; i++) {
					if(x[i] > maxValue) {
						maxValue = x[i];
					}
				}
				return maxValue;
			};
			
			UpdateArray fUpdateArr = (int x[], int y) -> {
				int[] anotherArray = new int[x.length - 1];
				boolean alreayRemoved = false;
				for (int i = 0, k = 0; i < x.length; i++) { 
					  
		            if (x[i] == y && !alreayRemoved) { 
		                alreayRemoved = true;
		            	continue; 
		            } 
		  
		            anotherArray[k++] = x[i]; 
		        } 
				return anotherArray;
			};
			
			boolean willLose = false;
			for(int i=0; i<maxPlayer; i++) {
				int villainMax = fMaxObj.getMax(villainstrength);
				int playerMax = fMaxObj.getMax(playerenergy);
				
				if(villainMax > playerMax) {
					willLose = true;
					break;
				}
				
				villainstrength = fUpdateArr.updateArray(villainstrength, villainMax);
				playerenergy = fUpdateArr.updateArray(playerenergy, playerMax);
			}
			
			if(willLose) {
				testCaseResult[testCase] = "LOSE";
			} else {
				testCaseResult[testCase] = "WIN";
			}
		}
		
		for (int i = 0; i < testCaseResult.length; i++) {
			System.out.println(testCaseResult[i]);
		}
		
	}

}

interface GetMaxOfArray
{
	public int getMax(int arr[]);
}

interface UpdateArray
{
	public int[] updateArray(int arr[], int value);
}
	
interface StringToIntArray
{
	public int[] stringToInt(String str);
}