package com.example.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Comparators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person p1 = new Comparators().new Person("xj", "liu", 35, 70000);
		Person p2 = new Comparators().new Person("michael", "liu", 30, 50000);
		Person p3 = new Comparators().new Person("hanna", "zhao", 25, 30000);
		Person p4 = new Comparators().new Person("xi", "liu", 35, 70000);
		
		List<Person> plist = new ArrayList<>();
		plist.add(p1);
		plist.add(p2);
		plist.add(p3);
		plist.add(p4);
		
		System.out.println("Collection Comparable -- Sorted by age and first name: ");
		Collections.sort(plist);
		plist.forEach(System.out::println);
		
		Comparator<Person> cp = new Comparator<Person>(){
			@Override
			public int compare(Person o1, Person o2) {
				
				return o1.getAge() == o2.getAge() ? o1.getFname().compareToIgnoreCase(o2.getFname()) : o1.getAge() - o2.getAge(); 
			}


			
		};
		System.out.println("Collection -- Sorted by age and first name: ");
		Collections.sort(plist, cp);
		plist.forEach(System.out::println);
		
		System.out.println("Stream -- Sorted by age: ");		
		Stream<Person> pstream = Stream.of(p1,p2,p3,p4);
		pstream.sorted((p11,p22) -> p11.age - p22.age).forEach(System.out::println);

		
		System.out.println("Stream -- Sorted by age and  fname: ");		
		plist.stream().sorted((o1,o2) -> o1.getAge() == o2.getAge() ? o1.getFname().compareToIgnoreCase(o2.getFname()) : o1.getAge() - o2.getAge()).forEach(System.out::println);

	}

	
	class Person implements Comparable<Person>
	{
		String fname;
		String lname;
		String name;
		int age;
		int salary;
		
		public Person(String fname, String lname, int age, int salary) {
			super();
			this.fname = fname;
			this.lname = lname;
			this.age = age;
			this.salary = salary;
		}
		public String getFname() {
			return fname;
		}
		public void setFname(String fname) {
			this.fname = fname;
		}
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
		@Override
		public String toString() {
			return "Person [fname=" + fname + ", lname=" + lname + ", age=" + age + ", salary=" + salary + "]";
		}

		@Override
		public int compareTo(Person o) {
			
			
			return this.getAge() == o.getAge() ? this.getFname().compareToIgnoreCase(o.getFname()) : this.getAge() - o.getAge(); 
		}
		
		
	}

}

