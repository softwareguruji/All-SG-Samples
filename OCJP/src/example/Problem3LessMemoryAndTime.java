package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem3LessMemoryAndTime {

	
    
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int nTask = Integer.parseInt(line);
        Map<Integer,int[]> tasks = new HashMap<Integer,int[]>();    
        
        for (int i = 0; i < nTask; i++) {
        	line = br.readLine();
        	int[] task = {Integer.parseInt(line.split(" ")[0]),Integer.parseInt(line.split(" ")[1]),Integer.parseInt(line.split(" ")[2]),Integer.parseInt(line.split(" ")[3])};
        	tasks.put(i+1,task);
        }
        findScore(tasks);
        //System.out.println("\n"+findScore(tasks));
	}
	
	public static double findScore(Map<Integer,int[]> tasks){
		double score = 1.0;
		int[][] selectedTask = null;
		Map<int[][],Double> tempTaskStore = new HashMap<int[][],Double>();
		ArrayList<int[][][]> taskCombinations = getVariousTaskCombinations(tasks, 2);
		
		for (int[][][] taskCombination : taskCombinations) {
			for(int i=0; i<taskCombination.length; i++){
				
				double currentScore = 1.0;
				if(!tempTaskStore.containsKey(taskCombination[i])){
					currentScore = calculateIndividualScore(tasks, taskCombination[i]);
					tempTaskStore.put(taskCombination[i], currentScore);	
				}else{
					currentScore = tempTaskStore.get(taskCombination[i]);
				}
				
				if(currentScore < score){
					score = currentScore;
					selectedTask = taskCombination[i];
				}
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
		
		return Math.pow(maxTime, 2)/10000000;
		
	}
	
	public static ArrayList<int[][][]> getVariousTaskCombinations(Map<Integer,int[]> taskNumbers, int group){
		
		int[] taskNumbersArray = new int[taskNumbers.size()];
		int k = 0;
		for (int i : taskNumbers.keySet()) {
			taskNumbersArray[k++] = i;
		}
		permute(taskNumbersArray, 0);
		ArrayList<int[][][]> taskCombinations = new ArrayList<int[][][]>();
		for (int[] i : permuteList) {
			int[][][] a = getMultipleCombinations(i);
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
			aCombinations[i][0] = b; 
					
			int[] c = new int[a.length-b.length];
			for(int j=i+1, k=0;j<a.length;j++,k++){
				c[k] = a[j];
			}
			aCombinations[i][1] = c;
		}
		return aCombinations;
	}
	
	static ArrayList<int[]> permuteList = new ArrayList<int[]>();
	public static void pushToPermutList(int[] a) {
		permuteList.add(a.clone());
	}

	//Get various Permutations
	public static void permute(int[] a, int k) {
		if (k == a.length)
			pushToPermutList(a);
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
