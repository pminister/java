1. Write a java program to define a thread for printing text on output screen for ‘n’ number of
times. Create 3 threads and run them. Pass the text ‘n’ parameters to the thread constructor.
Example: i. First thread prints “COVID19” 10 times. ii. Second thread prints “LOCKDOWN2020”
20 times iii. Third thread prints “VACCINATED2021” 30 times
class PrintThread extends Thread {
private String text;
private int repetitionCount;
public PrintThread(String text, int repetitionCount) {
this.text = text;
this.repetitionCount = repetitionCount;
}
@Override
public void run() {
for (int i = 0; i < repetitionCount; i++) {
System.out.println(text);
}
}
}
public class TextPrintingExample {
public static void main(String[] args) {
// Create three threads with different text and repetition count
PrintThread thread1 = new PrintThread("COVID19", 10);
PrintThread thread2 = new PrintThread("LOCKDOWN2020", 20);
PrintThread thread3 = new PrintThread("VACCINATED2021", 30);
// Start the threads
thread1.start();
thread2.start();
thread3.start();
}
}
2.Write a JSP program to check whether a given number is prime or not. Display the result in
red color.

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prime Number Checker</title>
</head>
<body>
<h2>Prime Number Checker</h2>
<form action="" method="post">
Enter a number: <input type="text" name="number">
<input type="submit" value="Check">
</form>
<%
String numberStr = request.getParameter("number");
if (numberStr != null && !numberStr.isEmpty()) {
try {
int number = Integer.parseInt(numberStr);
boolean isPrime = checkPrime(number);
// Display the result in red color
String resultColor = isPrime ? "red" : "black";
%>
<p style="color: <%= resultColor %>;">
<%= number %> is <%= isPrime ? "prime" : "not prime" %>.
</p>
<%
} catch (NumberFormatException e) {
%>
<p style="color: red;">
Please enter a valid integer.
</p>
<%
}
}
%>
</body>
</html>
<%!
boolean checkPrime(int num) {
if (num <= 1) {
return false;
}
for (int i = 2; i <= Math.sqrt(num); i++) {
if (num % i == 0) {
return false;
}
}
return true;
}
%>