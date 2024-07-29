package week3.day2.LearnList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindSecondLargestNumberinList {

	public static void main(String[] args) {
		
		List<Integer> list=new ArrayList<>();
		
		list.add(3);
		list.add(2);
		list.add(11);
		list.add(4);
		list.add(6);
		list.add(7);
		
		System.out.println("The values of the list before sort - "+list);
		
		Collections.sort(list);
		int size = list.size();
		System.out.println("The size of the list is - "+size);
		
		
		System.out.println("The values of the list after sort - "+list);
		System.out.println("The second largest number is - "+list.get(size-2));


	}

}
