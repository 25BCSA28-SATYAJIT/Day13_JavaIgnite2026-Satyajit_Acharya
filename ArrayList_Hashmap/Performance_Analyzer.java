/*
Create a Java program to manage student course performance.

Task:

You are given multiple students with the following details:

Student Name
Course Name
Marks
Requirements:
Store all student records using ArrayList
Use a HashMap<String, List<Integer>> where:
Key = Course Name
Value = List of marks in that course
Calculate and display:
Average marks for each course
Course with highest average
Hint:

Break the problem into steps:

First store raw data in ArrayList
Then group marks by course using HashMap

for each loop - enhanced for loop 
for(int i=0;i<list.size();i++)
Student s=list.get(i)

for(Student s : list)
String course = s.course 
int marks = s.marks 
if(map.containsKey(course))
ArrayList<Integer> marksList = map.get(course)
marksList.add(marks)

ArrayList<Integer> marksList = map.get(course)
marksList.add(marks)
map.put(course,marksList)


Then iterate HashMap to calculate averages - for(String course:map.keySet())- creating arraylist -int sum =0, 
for(int i=0;i<marksList.size();i++)
sum=sum+marksList(i)
double =(double)sum/marksList.size();


Finally compare averages
  */
package java_internship_day13;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

class student {
	String name,course;
	int marks;
	
	student(String name,String course,int marks) {
		this.name = name;
		this.course = course;
		this.marks = marks;
	}
}
public class Performance_Analyzer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num,marks,i;
		String name,course;
		Scanner sc = new Scanner(System.in);
		ArrayList<student> Student = new ArrayList<>();
		System.out.println("Enter the nummber of students :");
		num = sc.nextInt();
		sc.nextLine();
		for(i=0;i<num;i++) {
			System.out.println("Enter the name of the student");
			name = sc.nextLine();
			System.out.println("Enter the course name :");
			course = sc.nextLine();
			System.out.println("Enter the marks :");
			marks = sc.nextInt();
			sc.nextLine();
			Student.add(new student(name,course,marks));
		}
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();

		for(student s : Student) {
		    String courseName = s.course;
		    int marksObtained = s.marks;

		    if(map.containsKey(courseName)) {
		        ArrayList<Integer> marksList = map.get(courseName);
		        marksList.add(marksObtained);
		    }
		    else {
		        ArrayList<Integer> marksList = new ArrayList<Integer>();

		        marksList.add(marksObtained);

		        map.put(courseName, marksList);
		    }
		}
		String highestCourse = "";
		double highestAverage = 0;

		for(String courseName : map.keySet()) {
		    ArrayList<Integer> marksList = map.get(courseName);

		    int sum = 0;

		    for(i = 0; i < marksList.size(); i++) {
		        sum = sum + marksList.get(i);
		    }

		    double average = (double)sum / marksList.size();

		    System.out.println(courseName + " Average = " + average);

		    if(average > highestAverage) {
		        highestAverage = average;
		        highestCourse = courseName;
		    }
		}
		System.out.println("Course of Highest Average : " + highestCourse);

		System.out.println("Highest Average : "+ highestAverage);
		sc.close();
	}

}
