SLIP 3
1. Write a JSP program to display the details of Patient (PNo, PName, Address, age, disease) in
tabular form on browser.
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Details</title>
</head>
<body>
<h2>Patient Details</h2>
<table border="1">
<thead>
<tr>
<th>Patient Number</th>
<th>Patient Name</th>
<th>Address</th>
<th>Age</th>
<th>Disease</th>
</tr>
</thead>
<tbody>
<%-- Sample data, replace it with actual data retrieval logic --%>
<% 
String[][] patients = {
{"P001", "John Doe", "123 Main St", "25", "Fever"},
{"P002", "Jane Smith", "456 Oak St", "30", "Headache"},
{"P003", "Bob Johnson", "789 Pine St", "40", "Cough"}
};
for (String[] patient : patients) {
%>
<tr>
<td><%= patient[0] %></td>
<td><%= patient[1] %></td>
<td><%= patient[2] %></td>
<td><%= patient[3] %></td>
<td><%= patient[4] %></td>
</tr>
<%}
%>
</tbody>
</table>
</body>
</html>
2. Write a Java program to create LinkedList of String objects and perform the following:
 i. Addelement at the end of the list 
 ii. Delete first element of the list 
 iii. Display the contents of list inreverse order
import java.util.LinkedList;
public class StringLinkedListExample {
public static void main(String[] args) {

LinkedList<String> stringList = new LinkedList<>();

stringList.add("Apple");
stringList.add("Banana");
stringList.add("Orange");

System.out.println("Original List: " + stringList);

stringList.add("Grapes");
System.out.println("List after adding 'Grapes': " + stringList);

if (!stringList.isEmpty()) {
stringList.removeFirst();
System.out.println("List after deleting the first element: " + stringList);
} else {
System.out.println("List is empty. Cannot remove the first element.");
}

System.out.println("List in reverse order:");
for (int i = stringList.size() - 1; i >= 0; i--) {
System.out.println(stringList.get(i));
}
}
}