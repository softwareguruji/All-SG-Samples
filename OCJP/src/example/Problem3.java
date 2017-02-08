package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem3 {

	
    
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int nTask = Integer.parseInt(line);
        Map<Integer,int[]> tasks = new HashMap<Integer,int[]>();    
        
        for (int i = 0; i < nTask; i++) {
        	line = br.readLine();
        	int dur1 = Integer.parseInt(line.split(" ")[0]);
        	int change1 = Integer.parseInt(line.split(" ")[1]);
        	int dur2 = Integer.parseInt(line.split(" ")[2]);
        	int change2 = Integer.parseInt(line.split(" ")[3]);
        	
        	int[] task = {dur1,change1,dur2,change2};
        	tasks.put(i+1,task);
        }
        findScore(tasks);
        //System.out.println("\n"+findScore(tasks));
	}
	
	public static double findScore(Map<Integer,int[]> tasks){
		double score = 1.0;
		int[][] selectedTask = null;
		
		Set<Integer> taskNumbers = tasks.keySet();
		ArrayList<int[][][]> taskCombinations = getVariousTaskCombinations(taskNumbers, 2);
		
		for (int[][][] taskCombination : taskCombinations) {
			for(int i=0; i<taskCombination.length; i++){
				//System.out.println(taskCombination[i]);
				double currentScore = calculateIndividualScore(tasks, taskCombination[i]);
				if(currentScore < score){
					score = currentScore;
					selectedTask = taskCombination[i];
				}
				//System.out.println(score);
			}
		}
		
		if(selectedTask != null){
			for(int i=0; i<selectedTask.length; i++){
				System.out.println(selectedTask[i].length);
				for (int j = 0; j < selectedTask[i].length; j++) {
					System.out.print(selectedTask[i][j]+" ");
				}
				System.out.println();
			}
		}
		
		return score;
	}
	
	public static double calculateIndividualScore(Map<Integer,int[]> tasks, int[][] taskCombination){
		int[] taskForPersonA = taskCombination[0];
		int fatigueA = 1;
		int totalSpentTimeA = 0;
		for (int i = 0; i < taskForPersonA.length; i++) {
			int[] task = tasks.get(taskForPersonA[i]);
			totalSpentTimeA = totalSpentTimeA + (fatigueA * task[0]);
			fatigueA = fatigueA + task[1];
			
			if(fatigueA > 10){
				fatigueA = 10;
			}
			
		}
		
		int[] taskForPersonB = taskCombination[1];
		int fatigueB = 1;
		int totalSpentTimeB = 0;
		for (int i = 0; i < taskForPersonB.length; i++) {
			int[] task = tasks.get(taskForPersonB[i]);
			totalSpentTimeB = totalSpentTimeB + (fatigueB * task[0]);
			fatigueB = fatigueB + task[1];
			
			if(fatigueB > 10){
				fatigueB = 10;
			}
			
		}
		
		int maxTime = Math.max(totalSpentTimeA, totalSpentTimeB);
		
		return Math.pow(maxTime, 2)/Math.pow(10, 6);
		
	}
	
	public static ArrayList<int[][][]> getVariousTaskCombinations(Set<Integer> taskNumbers, int group){
		
		int[] taskNumbersArray = new int[taskNumbers.size()];
		int k = 0;
		for (int i : taskNumbers) {
			taskNumbersArray[k++] = i;
		}
		//pushToPermutList(taskNumbersArray);
		permute(taskNumbersArray, 0);
		//System.out.println(permuteList);
		
		/*for (int[] i : permuteList) {
			for (int j : i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}*/
		ArrayList<int[][][]> taskCombinations = new ArrayList<int[][][]>();
		for (int[] i : permuteList) {
			int[][][] a = getMultipleCombinations(i);
			//System.out.println(a);
			taskCombinations.add(a);
		}
		
		return taskCombinations;
	}
	
	//Get multiple Combinations
	public static int[][][] getMultipleCombinations(int[] a){
		int[][][] aCombinations = new int[a.length-1][2][];
		for (int i = 0; i < a.length-1; i++) {
			int[] b = new int[i+1];
			for(int j=0;j<=i;j++){
				b[j] = a[j];
			}
			//System.out.println("b length"+b.length);
			aCombinations[i][0] = b; 
					
			int[] c = new int[a.length-b.length];
			for(int j=i+1, k=0;j<a.length;j++,k++){
				c[k] = a[j];
			}
			//System.out.println("c length"+c.length);
			
			aCombinations[i][1] = c;
		}
		return aCombinations;
	}
	
	static ArrayList<int[]> permuteList = new ArrayList<int[]>();
	public static void pushToPermutList(int[] a) {
		/*for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}*/
		permuteList.add(a.clone());
		/*System.out.print(" : Size - "+permuteList.size());
		System.out.println("");*/
		
	}

	public static void permute(int[] a, int k) {
		if (k == a.length)
			pushToPermutList(a);
			//list.add(a);
		else
			for (int i = k; i < a.length; i++) {
				int temp = a[k];
				a[k] = a[i];
				a[i] = temp;
				permute(a, k + 1);
				temp = a[k];
				a[k] = a[i];
				a[i] = temp;
			}
	}
	
}
