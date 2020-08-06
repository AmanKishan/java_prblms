package com.java.priorityQueueExp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Priorities {
	public List < Student > getStudents(List < String > events) {
		PriorityQueue < Student > student_queue = new PriorityQueue(Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getName).thenComparing(Student::getId));
		List < Student > students = new ArrayList < Student > ();
		for (String e: events) {
			Scanner in =new Scanner(e);
			String event = in.next();
			if (event.equals("ENTER")) {
				String name = in.next();
				float cgpa = in.nextFloat();
				int token = in.nextInt();

				Student student = new Student(token, name, cgpa);
				student_queue.add(student);
			} else if (event.equals("SERVED")) {
				Student first = student_queue.poll();
			} in .close();
		}
		Student first = student_queue.poll();
		if (first == null) {
			return students;
		} else {
			while (first != null) {

				students.add(first);
				first = student_queue.poll();

			}
			return students;
		}

	}
}