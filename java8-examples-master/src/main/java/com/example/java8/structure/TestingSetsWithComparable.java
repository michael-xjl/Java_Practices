package com.example.java8.structure;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Employee implements Comparable<Employee> {

    String employeeName;
    int employeeId;

    public Employee(String name, int id) {
        this.employeeName = name;
        this.employeeId = id;
    }

    public int compareTo(Employee emp) {
        //return this.employeeName.compareTo(emp.employeeName);
        return Integer.valueOf(this.employeeId).compareTo(new Integer(emp.employeeId));
    }

    @Override
    public String toString() {
        return ("Name is: " + employeeName + " Emp id is: " + employeeId);
    }

    @Override
    public boolean equals(Object emp) {
        if (emp instanceof Employee && ((Employee) emp).employeeName.equals(this.employeeName)) {
            return true;
        }
        return false;
    }

}


public class TestingSetsWithComparable {

	public static void main(String[] args) {
	       Employee e1 = new Employee("A", 1);
	        Employee e2 = new Employee("A", 2);
	        Employee e3 = new Employee("B", 3);
	        
	        Set<Employee> hashSet = new HashSet<>();
	        hashSet.add(null);

	        Set<Employee> set = new TreeSet<Employee>();
	        set.add(e1);
	        set.add(e2);
	        set.add(e3);
//	        set.add(null);
	        System.out.println(set);
	        
	        Queue<Employee> queue = new PriorityQueue<>();
	        queue.add(e3);
	        queue.add(e1);
	        queue.add(e2);
//	        queue.add(null);
	        	        	       
	        System.out.println(queue.poll());
	        System.out.println(queue.poll());
	        
	        
	        Map<Employee, Employee> map = new TreeMap<>();
	        map.put(e3,e3);
	        map.put(e1,e1);
	        map.put(e2,e2);
	        
	        
	        
	    }

	}


