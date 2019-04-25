package concept.collection.learn;

import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
		

		long startTime = System.nanoTime();
		Set<String> s = new TreeSet<String>();
		s.add("f"); //Tree set is sorted so in sysout "f" came last.
		s.add("a");
		s.add("b");
		s.add("c");
		s.add("d");
		s.add("e");
		
		long endTime = System.nanoTime();
		System.out.println((endTime - startTime)/1000);
		
		
		Iterator<String> it = s.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

		startTime = System.nanoTime();
		Set<Dog> dogs = new TreeSet<>();
		dogs.add(new Dog("Tiger"));
		dogs.add(new Dog("Puppy"));
		dogs.add(new Dog("Kuku"));
		dogs.add(new Dog("Tomy"));
		endTime = System.nanoTime();
		System.out.println((endTime - startTime)/1000);
		
		Iterator<Dog> it1 = dogs.iterator();
		while(it1.hasNext()){
			System.out.println(it1.next().name);
		}
		System.out.println();
		
	}
}


class Dog implements Comparable{
	String name;
	
	Dog(String name){
		this.name = name;
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Dog){
			/*if(this.name.hashCode() > ((Dog)o).name.hashCode()){
				return 1;
			}else{
				return -1;
			}*/
			
			//Default compare
			//return this.name.compareTo(((Dog)o).name);
			
			//custom compare
			//i.e. we want min length first and then more length
			if(this.name.length() > ((Dog)o).name.length()){
				return 1;
			}else{
				return -1;
			}
			
		}else{
			return 0;
		}
	}
}