1. Write a Java program to delete the details of given employee (ENo EName Salary). Accept
employee ID through command line. (Use PreparedStatement Interface).

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DeleteEmployeeDetails {
public static void main(String[] args) {
// Check if the correct number of command line arguments are provided
if (args.length != 1) {
System.out.println("Usage: java DeleteEmployeeDetails <employeeID>");
return;
}
// Extract employee ID from command line argument
int employeeID = Integer.parseInt(args[0]);
// JDBC URL, username, and password of MySQL server
String jdbcURL = "jdbc:mysql://localhost:3306/your_database";
String username = "your_username";
String password = "your_password";
try (Connection connection = DriverManager.getConnection(jdbcURL, username,
password)) {
// SQL query to delete employee details based on employee ID
String sqlQuery = "DELETE FROM Employee WHERE ENo = ?";
// Create a PreparedStatement
try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
// Set the parameter (employee ID) in the PreparedStatement
preparedStatement.setInt(1, employeeID);
// Execute the query
int rowsAffected = preparedStatement.executeUpdate();
// Check if any rows were affected
if (rowsAffected > 0) {
System.out.println("Employee details deleted successfully.");
} else {
System.out.println("Employee not found with ID: " + employeeID);
}
}
} catch (SQLException e) {
e.printStackTrace();
}
}
}

2. Write a JSP program to calculate sum of first and last digit of a given number. Display sum in
Red Color with font size 18.

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Sum of First and Last Digit</title>
</head>
<body>
<h2>Sum of First and Last Digit Calculator</h2>
<form action="" method="post">
Enter a number: <input type="text" name="number" required>
<input type="submit" value="Calculate">
</form>
<% // Retrieve the number from the request parameter
String numberStr = request.getParameter("number");
if (numberStr != null && !numberStr.isEmpty()) {
try {
// Parse the number
int number = Integer.parseInt(numberStr);
// Calculate the sum of first and last digit
int lastDigit = number % 10;
int firstDigit = Character.getNumericValue(Integer.toString(number).charAt(0));
int sum = firstDigit + lastDigit;
// Display the result in red color with font size 18
%>
<p style="color: red; font-size: 18px;">
Sum of the first and last digit of <%= number %> is: <%= sum %>
</p>
<%
} catch (NumberFormatException e) {
// Handle the case where the input is not a valid number
%>
<p style="color: red; font-size: 18px;">
Invalid input! Please enter a valid number.
</p>
<%
}
}
%>
</body>
</html>