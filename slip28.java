1. Write a JSP script to accept a String from a user and display it in reverse order

<!DOCTYPE html>
<html>
<head>
<title>Reverse String</title>
</head>
<body>
<h2>Reverse String</h2>
<form action="" method="post">
Enter a string: <input type="text" name="inputString" required>
<input type="submit" value="Reverse">
</form>
<%
// Retrieve the input string from the request parameters
String inputString = request.getParameter("inputString");
// Check if the form has been submitted
if (inputString != null && !inputString.isEmpty()) {
// Reverse the input string
String reversedString = new StringBuilder(inputString).reverse().toString();
%>
<p>Original String: <%= inputString %></p>
<p>Reversed String: <%= reversedString %></p>
<%}
%>
</body>
</html>
2. Write a java program to display name of currently executing Thread in multithreading

public class CurrentThreadExample {
public static void main(String[] args) {
// Create and start two threads
Thread thread1 = new Thread(new MyRunnable(), "Thread 1");
Thread thread2 = new Thread(new MyRunnable(), "Thread 2");
thread1.start();
thread2.start();
// Display the name of the main thread
System.out.println("Main thread name: " + Thread.currentThread().getName());
}
static class MyRunnable implements Runnable {
@Override
public void run() {
// Display the name of the currently executing thread
System.out.println("Thread name: " + Thread.currentThread().getName());
}
}
}