1. Write a java program to create a TreeSet, add some colors (String) and print out the content
of TreeSet in ascending order.

import java.util.TreeSet;
public class TreeSetExample {
public static void main(String[] args) {
// Create a TreeSet to store colors in ascending order
TreeSet<String> colorSet = new TreeSet<>();
// Add colors to the TreeSet
colorSet.add("Red");
colorSet.add("Green");
colorSet.add("Blue");
colorSet.add("Yellow");
colorSet.add("Purple");
// Print the content of TreeSet in ascending order
System.out.println("Colors in ascending order:");
for (String color : colorSet) {
System.out.println(color);
}
}
}
2. Write a Java program to accept the details of Teacher (TNo, TName, Subject). Insert at least
5 Records into Teacher Table and display the details of Teacher who is teaching “JAVA” Subject.
(Use PreparedStatement Interface)

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class TeacherDetailsExample {
private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/your_database"; //
Replace with your database URL
private static final String USERNAME = "your_username"; // Replace with your database
username
private static final String PASSWORD = "your_password"; // Replace with your database
password
public static void main(String[] args) {
try (Connection connection = DriverManager.getConnection(DATABASE_URL,
USERNAME, PASSWORD)) {
// Insert at least 5 records into the Teacher table
insertTeacherRecords(connection);
// Display details of teachers who are teaching "JAVA"
displayJavaTeachers(connection);
} catch (SQLException e) {
e.printStackTrace();
}
}
private static void insertTeacherRecords(Connection connection) throws SQLException {
// SQL query to insert records into Teacher table
String insertQuery = "INSERT INTO Teacher (TNo, TName, Subject) VALUES (?, ?, ?)";
try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
// Inserting at least 5 records
for (int i = 1; i <= 5; i++) {
preparedStatement.setInt(1, i);
preparedStatement.setString(2, "Teacher" + i);
preparedStatement.setString(3, "Subject" + i);
int rowsAffected = preparedStatement.executeUpdate();
if (rowsAffected > 0) {
System.out.println("Record inserted successfully.");
}
}
}
}
private static void displayJavaTeachers(Connection connection) throws SQLException {
// SQL query to select teachers who are teaching "JAVA" subject
String selectQuery = "SELECT * FROM Teacher WHERE Subject = ?";
try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery))
{
// Set the subject to "JAVA"
preparedStatement.setString(1, "JAVA");
try (ResultSet resultSet = preparedStatement.executeQuery()) {
System.out.println("Details of teachers teaching \"JAVA\" subject:");
while (resultSet.next()) {
System.out.println("TNo: " + resultSet.getInt("TNo"));
System.out.println("TName: " + resultSet.getString("TName"));
System.out.println("Subject: " + resultSet.getString("Subject"));
System.out.println("---------------------------");
}
}
}
}
}