/*
Create a program that stores employee data in memory:

Each employee has:

id
department
salary
Task:
Store employees using ArrayList
Create a HashMap where:
Key = Department
Value = Total salary of that department
Display department with highest total salary
Hint:

Break into:

Grouping logic
Summation logic
Comparison logic
*/
package java_internship_day13;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

class employee {
	int id,salary;
	String department;
	
	employee(int id,String department,int salary) {
		this.id = id;
		this.department = department;
		this.salary = salary;
	}
}
public class EmpDataAnalyzer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,id,salary,i;
		String department;
		ArrayList<employee> employees = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the numbmer of the employes :");
		n = sc.nextInt();
		//employee em = new employee();
		for(i=0;i<n;i++) {
			System.out.println("Enter the id :");
			id = sc.nextInt();
			System.out.println("Enter the department :");
			department = sc.next();
			//sc.nextLine();
			System.out.println("Enter the salary :");
			salary = sc.nextInt();
			employees.add(new employee(id,department,salary));
		}
		
		HashMap<String,Integer> Salary = new HashMap<>();
		
		for(employee e : employees) {
		    Salary.put(
		        e.department,
		        Salary.getOrDefault(e.department,0)
		        + e.salary
		    );
		}
		String hdepart = "";
		int hsalary = 0;
		for(String dept : Salary.keySet()) {
			if(Salary.get(dept) > hsalary) {
                hsalary = Salary.get(dept);
                hdepart = dept;
            }
        }
		System.out.println("Highest salary department :" + hdepart);
		System.out.println("Salary :" + hsalary);
		sc.close();
	}

}

