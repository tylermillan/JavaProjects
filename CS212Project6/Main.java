import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		//Testing with integers 
		OccurrenceSet<Integer> intSet = new OccurrenceSet<Integer>();
		intSet.add(1);
		intSet.add(3);
		intSet.add(5);
		intSet.add(5);
		intSet.add(3);
		intSet.add(3);
		intSet.add(3);
		System.out.println(intSet);
		
		ArrayList<Integer> exNumArray = new ArrayList<Integer>() ;
		exNumArray.add(121);
		exNumArray.add(311);
		exNumArray.add(4546);
		exNumArray.add(3234);
		exNumArray.add(31233);
		intSet.addAll(exNumArray);
		System.out.println(intSet);
		
		ArrayList<Integer> retainNumArray= new ArrayList<Integer>() ;
		retainNumArray.add(121);
		retainNumArray.add(3234);
		retainNumArray.add(31233);
		
		//convert to array and print the string representation
		System.out.println(Arrays.toString(intSet.toArray()));
		
		//check if adding a number if changes sorting like it should
		intSet.add(1);
		System.out.println(intSet);
		
		intSet.retainAll(retainNumArray);
		System.out.println(intSet);
	
		intSet.removeAll(exNumArray);
		System.out.println(intSet);
		
		intSet.remove(5);
		System.out.println(intSet);
		System.out.println(intSet.size());
		
		System.out.println(intSet.isEmpty());
		
		intSet.clear();
		System.out.println(intSet);
		
		System.out.println(intSet.isEmpty());

		System.out.println(intSet.size());

		
		//Testing With Strings
		OccurrenceSet<String> stringSet = new OccurrenceSet<String>();
		stringSet.add("hello");
		stringSet.add("hello");
		stringSet.add("world");
		stringSet.add("world");
		stringSet.add("world");
		stringSet.add("here");
		System.out.println(stringSet);
		
		ArrayList<String> exArray = new ArrayList<String>() ;
		exArray.add("dog");
		exArray.add("cat");
		exArray.add("monkey");
		exArray.add("giraffe");
		exArray.add("elephant");
		stringSet.addAll(exArray);
		System.out.println(stringSet);
		
		ArrayList<String> retainArray= new ArrayList<String>() ;
		retainArray.add("dog");
		retainArray.add("monkey");
		retainArray.add("cat");
		
		//convert to array and print the string representation
		System.out.println(Arrays.toString(stringSet.toArray()));
		
		//check if adding a number if changes sorting like it should
		stringSet.add("here");
		System.out.println(stringSet);
		
		
		stringSet.retainAll(retainArray);
		System.out.println(stringSet);
	
		stringSet.removeAll(exArray);
		System.out.println(stringSet);
		
		stringSet.remove("hello");
		System.out.println(stringSet);
		System.out.println(stringSet.size());
		
		System.out.println(stringSet.isEmpty());
		
		stringSet.clear();
		System.out.println(stringSet);
		
		System.out.println(stringSet.isEmpty());

		System.out.println(stringSet.size());

	}

}
