1. Write a Java program to display information about all columns in the DONAR table using
ResultSetMetaData.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
public class ColumnInfoExample {
public static void main(String[] args) {
// JDBC URL, username, and password of MySQL server
String jdbcURL = "jdbc:mysql://localhost:3306/your_database";
String username = "your_username";
String password = "your_password";
try (Connection connection = DriverManager.getConnection(jdbcURL, username,
password)) {
// SQL query to retrieve all columns from the DONAR table
String sqlQuery = "SELECT * FROM DONAR WHERE 1 = 0"; // Adding WHERE
condition to fetch no records
try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
ResultSet resultSet = preparedStatement.executeQuery()) {
// Get ResultSetMetaData to retrieve column details
ResultSetMetaData metaData = resultSet.getMetaData();
// Get the number of columns
int columnCount = metaData.getColumnCount();
System.out.println("Column Details for DONAR table:");
// Iterate over columns and print details
for (int i = 1; i <= columnCount; i++) {
System.out.println("Column " + i + ":");
System.out.println(" Name: " + metaData.getColumnName(i));
System.out.println(" Type: " + metaData.getColumnTypeName(i));
System.out.println(" Size: " + metaData.getColumnDisplaySize(i));
System.out.println(" Nullable: " + (metaData.isNullable(i) ==
ResultSetMetaData.columnNullable ? "Yes" : "No"));
System.out.println();
}
}
} catch (SQLException e) {
e.printStackTrace();
}
}
}
2. Write a Java program to create LinkedList of integer objects and perform the following: i. Add
element at first position ii. Delete last element iii. Display the size of link list

import java.util.LinkedList;
public class LinkedListExample {
public static void main(String[] args) {
// Create a LinkedList of integers
LinkedList<Integer> linkedList = new LinkedList<>();
// i. Add element at the first position
addElementAtFirstPosition(linkedList, 10);
addElementAtFirstPosition(linkedList, 20);
addElementAtFirstPosition(linkedList, 30);
// ii. Delete last element
deleteLastElement(linkedList);
// iii. Display the size of the linked list
displaySize(linkedList);
}
// Add element at the first position
private static void addElementAtFirstPosition(LinkedList<Integer> list, int element) {
list.addFirst(element);
System.out.println("Added " + element + " at the first position. List: " + list);
}
// Delete last element
private static void deleteLastElement(LinkedList<Integer> list) {
if (!list.isEmpty()) {
Integer removedElement = list.removeLast();
System.out.println("Removed last element " + removedElement + ". List: " + list);
} else {
System.out.println("The list is empty.");
}
}
// Display the size of the linked list
private static void displaySize(LinkedList<Integer> list) {
System.out.println("Size of the linked list: " + list.size());
}
}