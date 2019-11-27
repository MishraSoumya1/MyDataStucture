package com.java.sortalgo;

import java.util.ArrayList;
import java.util.List;

public class SortByNameThenAge {

	static class Student {
		String name;
		int age;

		public Student(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

	}

	public static void main(String[] args) {
		List<Student> olist = new ArrayList<>();
		olist.add(new Student("Soumya", 26));
		olist.add(new Student("Soumya", 22));
		olist.add(new Student("Asmita", 22));
		olist.add(new Student("Asmita", 23));
		olist.add(new Student("Soumya", 24));
		olist.add(new Student("Soumya2", 21));
		olist.add(new Student("Soumya2", 19));
		olist.add(new Student("Asmita", 25)); 
		// Order By name
		for (int i = 0; i < olist.size(); i++) {
			for (int j = olist.size() - 1; j > i; j--) {
				if (olist.get(i).name.compareTo(olist.get(j).name) > 0) {
					Student temp = olist.get(i);
					olist.set(i, olist.get(j));
					olist.set(j, temp);
				}
			}
		}

		for (Student s : olist) {
			System.out.println(s.name + " : " + s.age);
		}

		// Order by name then age
		for (int i = 0; i < olist.size(); i++) {
			for (int j = i + 1; j < olist.size(); j++) {
				if (olist.get(i).name.compareTo(olist.get(j).name) == 0) {
					if (olist.get(i).age > olist.get(j).age) {
						Student temp = olist.get(i);
						olist.set(i, olist.get(j));
						olist.set(j, temp);
					}
				} else {
					break;
				}
			}
		}
		System.out.println("\nSorting by age keeping name as it is");

		for (Student s : olist) {
			System.out.println(s.name + " : " + s.age);
		}
	}
}
