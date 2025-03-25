1. Write a java program to accept ‘N’ Integers from a user store them into LinkedList Collection
and display only negative integers.

import java.util.LinkedList;
import java.util.Scanner;
public class NegativeIntegersLinkedList {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Accept 'N' integers from the user
System.out.print("Enter the value of N: ");
int n = scanner.nextInt();
// Create a LinkedList to store integers
LinkedList<Integer> integerList = new LinkedList<>();
// Accept integers from the user and add them to the LinkedList
for (int i = 0; i < n; i++) {
System.out.print("Enter integer " + (i + 1) + ": ");
int inputInt = scanner.nextInt();
integerList.add(inputInt);
}
// Display only negative integers from the LinkedList
System.out.println("Negative Integers:");
for (int num : integerList) {
if (num < 0) {
System.out.println(num);
}
}
scanner.close();
}
}

2. Write a SERVLET application to accept username and password, search them into database,
if found then display appropriate message on the browser otherwise display error message.

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
// Get username and password from request parameters
String username = request.getParameter("username");
String password = request.getParameter("password");
// Simulate database check (Replace this with actual database interaction)
if (isValidUser(username, password)) {
out.println("<html><body>");
out.println("<h2>Login Successful</h2>");
out.println("<p>Welcome, " + username + "!</p>");
out.println("</body></html>");
} else {
out.println("<html><body>");
out.println("<h2>Login Failed</h2>");
out.println("<p>Invalid username or password. Please try again.</p>");
out.println("</body></html>");
}
out.close();
}
private boolean isValidUser(String username, String password) {
// Simulate database check (Replace this with actual database interaction)
// Here, we assume a valid username: "user123" and password: "password123"
return username.equals("user123") && password.equals("password123");
}
}