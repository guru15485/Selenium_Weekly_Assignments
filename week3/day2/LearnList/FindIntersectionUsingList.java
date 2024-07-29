package week3.day2.LearnList;

import java.util.ArrayList;
import java.util.List;

public class FindIntersectionUsingList {

	public static void main(String[] args) {

		int a1[] = { 3, 2, 11, 4, 6, 7 };
		int a2[] = { 1, 2, 8, 4, 9, 7 };

		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		for (int i = 0; i < a1.length; i++) {
			list1.add(a1[i]);

		}
		for (int i = 0; i < a2.length; i++) {
			list2.add(a2[i]);
		}
		System.out.println("The Intersection numbers are - ");
		for (int i = 0; i < list1.size(); i++) {

			for (int j = 0; j < list2.size(); j++) {
				if (list1.get(i) == list2.get(j)) {
					System.out.println(list1.get(i));

				}
			}

		}

	}

}
