/*
Create a Java program that connects to a MySQL database college_db.

The table students contains:

id
name
marks
Task:
Fetch all student records
Display only students who scored above average marks
Also print total number of students processed
Hint:

Think in steps:

Fetch all data using ResultSet
First calculate average marks
Then filter while reading result
*/
package java_internship_day13;
import java.sql.*;

public class StudentDatabaseReportSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college_db",
                    "root",
                    "your_password"
            );

            Statement st = con.createStatement();

           
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            int total = 0;
            int sum = 0;

           
            while (rs.next()) {
                sum += rs.getInt("marks");
                total++;
            }

            if (total == 0) {
                System.out.println("No students found");
                return;
            }

            int average = sum / total;

            System.out.println("Average Marks: " + average);

            rs = st.executeQuery("SELECT * FROM students");

            int processed = 0;

            while (rs.next()) {

                processed++;

                int marks = rs.getInt("marks");

                if (marks > average) {
                    System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + marks);
                }
            }

            System.out.println("\nTotal Students Processed: " + processed);

        } 
		catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
