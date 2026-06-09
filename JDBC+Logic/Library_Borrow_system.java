/*
Create a Java program connected to database library_db.

Table:

book_id
title
available_copies
Task:
Allow user to input a book ID
Check availability
If available:
Reduce copy count by 1
Print “Book Issued”
Else:
Print “Not Available”
Hint:

Think:

SELECT → check condition
UPDATE → modify data
Use if-else inside Java after ResultSet
*/
package java_internship_day13;
import java.sql.*;
import java.util.Scanner;

public class BookIssueSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library_db",
                    "root",
                    "your_password"
            );

            System.out.print("Enter  the book ID: ");
            int id = sc.nextInt();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT available_copies FROM books WHERE book_id = ?"
            );
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int copies = rs.getInt(1);

                if (copies > 0) {

                    PreparedStatement ps2 = con.prepareStatement(
                            "UPDATE books SET available_copies = available_copies - 1 WHERE book_id = ?"
                    );
                    ps2.setInt(1, id);
                    ps2.executeUpdate();

                    System.out.println("Book Issued");

                } 
                else {
                    System.out.println("Book cant be isssued");
                }

            } 
            else {
                System.out.println("Book Not Found");
            }

        } 
        catch (Exception e) {
            System.out.println("Error handled");
        }
    }
}
