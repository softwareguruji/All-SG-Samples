package concept.collection.learn;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TimerExample {

	private static int NO_OF_RECORDS = 10;
	
	public static void main(String[] args) {
		
		//Tree Set Setup
		Set<Cat> cats = new TreeSet<>();
		long startTime = System.nanoTime();
		for (int i = 0; i < NO_OF_RECORDS; i++) {
			cats.add(new Cat(RandomString.randomAlphaNumeric(5)));
		}
		long endTime = System.nanoTime();
		System.out.println("Insert Tree Set Time: "+(endTime - startTime)/1000+" Micro Sec.");

		startTime = System.nanoTime();
		for (Cat cat : cats) {
			//Nothing to do just traverse
		}
		endTime = System.nanoTime();
		System.out.println("Select Tree Set Time: "+(endTime - startTime)/1000+" Micro Sec.");
		
		
		//HashSet Setup
		Set<Cat> cats1 = new HashSet<>();
		startTime = System.nanoTime();
		for (int i = 0; i < NO_OF_RECORDS; i++) {
			cats1.add(new Cat(RandomString.randomAlphaNumeric(5)));
		}
		endTime = System.nanoTime();
		System.out.println("Insert Hash Set Time: "+(endTime - startTime)/1000+" Micro Sec.");

		startTime = System.nanoTime();
		for (Cat cat : cats1) {
			//Nothing to do just traverse
		}
		endTime = System.nanoTime();
		System.out.println("Select Hash Set Time: "+(endTime - startTime)/1000+" Micro Sec.");
		
		//Linked HashSet
		Set<Cat> linkedHashSet = new LinkedHashSet<>();
		startTime = System.nanoTime();
		for (int i = 0; i < NO_OF_RECORDS; i++) {
			linkedHashSet.add(new Cat(RandomString.randomAlphaNumeric(5)));
		}
		endTime = System.nanoTime();
		System.out.println("Insert Linkedhash Set Time: "+(endTime - startTime)/1000+" Micro Sec.");

		startTime = System.nanoTime();
		for (Cat cat : linkedHashSet) {
			//Nothing to do just traverse
		}
		endTime = System.nanoTime();
		System.out.println("Select Linkedhash Set Time: "+(endTime - startTime)/1000+" Micro Sec.");
		
		
		/*for (Cat cat : cats) {
			System.out.println(cat.name);
		}*/
	}
}

class Cat implements Comparable{
	String name;
	
	Cat(String name){
		this.name = name;
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Cat){
			/*if(this.name.hashCode() > ((Dog)o).name.hashCode()){
				return 1;
			}else{
				return -1;
			}*/
			
			//Default compare
			return this.name.compareTo(((Cat)o).name);
			
			//custom compare
			//i.e. we want min length first and then more length
			/*if(this.name.length() > ((Cat)o).name.length()){
				return 1;
			}else{
				return -1;
			}*/
			
		}else{
			return 0;
		}
	}
}