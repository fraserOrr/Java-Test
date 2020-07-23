package WordLengthPackage;
import java.util.*;

public class UniqueIndex implements Comparable<UniqueIndex>{
	public int name;
	public int count;

	public UniqueIndex(int name){
		this.name = name;
		this.count = 1;
	}
	public String toString(){
		String result = "The Number of Words of Length " + name + " is " + count;
		return(result);
	}

	// in order to sort the array list after it has finished adding the class overides the comparable abstract class
	@Override
	public int compareTo(UniqueIndex comparesto){
		// for the comparason method this sets the names to be the comparison variable
		return Integer.compare(this.name, comparesto.name);
	}

}