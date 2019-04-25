package techgig.exams;

/*
 * Riya and Strings (100 Marks)
Riya loves Merge Sort  especially because it selects the median value of the array as pivot.Today she has got a new problem for her brother as she was not able to solve it. 
She wants to know the given a String S of lower-case English alphabets ,what would be the new String generated if we perform the following operations-
Pick the middle character if the length is odd or if the length is even pick the left of the two middle characters and append this character to a new String and remove that character from the String S by reducing its size by 1.Keep on performing the above operation until no characters are left.

Riya is really clever.So instead of asking her brother to perform the above operation she gives him the new String and wants him to tell what was the original one .
You as a friend of her brother thought to help her by writing a program for the same.

Input Format
Your function contains a single argument A String S.
First line of input contains a String S. (1<=|S|<=100000)

Constraints
Lets move from the original String to the final one
Since the length of String is odd so we select the middle character i.e c and append it to the new String.Now new String is abde ,the length is even so we select the left of the middle two elements i.e b ,new String is now ade ,now we select d ,the String becomes ae ,we select now a and finally e .
So the new String by appending all the selected characters is cbdae .
Now, You have to reverse this process and get the original String i.e. "abcde".

Output Format
You must return a String denoting the answer to the problem.

Sample TestCase 1
Input
cbdae

Output
abcde
 
 */

public class StringProblem {

	public static void main(String[] args) {
		
		StringBuffer iS = new StringBuffer("cbdae");
		StringBuffer nS = new StringBuffer();
		
		do{
	        char c = iS.charAt(0);
	        if(iS.length() % 2 == 0){
	        	nS.insert(0, c);
	        }else{
	        	nS.insert(nS.length(), c);
	        }
	        iS.deleteCharAt(0);
	    }while(iS.length()>0);

		System.out.println(nS);
	}

}
