1. Write a Java program for a simple search engine. Accept a string to be searched. Search the
string in all text files in the current folder. Use a separate thread for each file. The result should
display the filename and line number where the string is found.

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class SimpleSearchEngine {
private static final String SEARCH_STRING = "your_search_string"; // Replace with your
search string
public static void main(String[] args) {
File currentFolder = new File(".");
File[] files = currentFolder.listFiles();
if (files != null) {
for (File file : files) {
if (file.isFile() && file.getName().endsWith(".txt")) {
Thread searchThread = new Thread(() -> searchInFile(file));
searchThread.start();
}
}
}
}
private static void searchInFile(File file) {
try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
String line;
int lineNumber = 0;
while ((line = reader.readLine()) != null) {
lineNumber++;
if (line.contains(SEARCH_STRING)) {
System.out.println("Found in file: " + file.getName() + ", Line: " + lineNumber);
}
}
} catch (IOException e) {
e.printStackTrace();
}
}
}

2)Write a JSP program to calculate sum of first and last digit of a given number. Display sum in
Red Color with font size 18.

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sum of First and Last Digit</title>
</head>
<body>
<% // Get the number from the request parameter
String numberStr = request.getParameter("number");
// Validate if the number is not null and not empty
if (numberStr != null && !numberStr.isEmpty()) {
try {
// Parse the number from the string
int number = Integer.parseInt(numberStr);
// Calculate the sum of the first and last digits
int lastDigit = number % 10;
int firstDigit = Character.getNumericValue(Integer.toString(number).charAt(0));
int sum = firstDigit + lastDigit;
%>
<!-- Display the result in red color with font size 18 -->
<p style="color: red; font-size: 18px;">
Sum of the first and last digit of <%= number %> is <%= sum %>.
</p>
<%
} catch (NumberFormatException e) {
%>
<!-- Display an error message if the input is not a valid integer -->
<p style="color: red; font-size: 18px;">
Please enter a valid integer.
</p>
<%
}
}
%>
<!-- Input form for entering the number -->
<form action="" method="post">
Enter a number: <input type="text" name="number">
<input type="submit" value="Calculate Sum">
</form>
</body>
</html>