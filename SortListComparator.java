package com.practice;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SortListComparator {
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
		List<Student> olist = new LinkedList<>();
		olist.add(new Student("Soumya", 26));
		olist.add(new Student("Soumya", 22));
		olist.add(new Student("Asmita", 22));
		olist.add(new Student("Asmita", 23));
		olist.add(new Student("Soumya", 24));
		olist.add(new Student("Soumya2", 21));
		olist.add(new Student("Soumya2", 19));
		olist.add(new Student("Asmita", 25));

		Collections.sort(olist, new SortByName());
		for (Student s : olist) {
			System.out.println(s.name + " : " + s.age);
		}
		System.out.println("\n\n");
		Collections.sort(olist, new SortByAge());
		for (Student s : olist) {
			System.out.println(s.name + " : " + s.age);
		}
		System.out.println("\n\n");
		Collections.sort(olist, new SortByName().thenComparing(new SortByAge()));
		for (Student s : olist) {
			System.out.println(s.name + " : " + s.age);
		}
		
		Collections.sort(olist, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.name.compareTo(o2.name);
			}
		}.thenComparing(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.age - o2.age;
			}
		}));
		System.out.println("\n\n");
		for (Student s : olist) {
			System.out.println(s.name + " : " + s.age);
		}
	}

	static class SortByName implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			return o1.name.compareTo(o2.name); // ascending order
		}
	}

	static class SortByAge implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			return o1.age - o2.age; // ascending order
		}
	}
}
