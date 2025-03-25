1. Write a java program for the implementation of synchronization.

class Counter {
private int count = 0;
// Synchronized method to increment the counter
public synchronized void increment() {
count++;
System.out.println(Thread.currentThread().getName() + " incremented count to " + count);
}
// Synchronized method to decrement the counter
public synchronized void decrement() {
count--;
System.out.println(Thread.currentThread().getName() + " decremented count to " + count);
}
// Method to get the current count value
public int getCount() {
return count;
}
}
class IncrementThread extends Thread {
private Counter counter;
public IncrementThread(Counter counter) {
this.counter = counter;
}
@Override
public void run() {
for (int i = 0; i < 5; i++) {
counter.increment();
try {
Thread.sleep(100); // Simulate some work being done
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}
}
class DecrementThread extends Thread {
private Counter counter;
public DecrementThread(Counter counter) {
this.counter = counter;
}
@Override
public void run() {
for (int i = 0; i < 5; i++) {
counter.decrement();
try {
Thread.sleep(150); // Simulate some work being done
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}
}
public class SynchronizationExample {
public static void main(String[] args) {
// Create a shared Counter object
Counter counter = new Counter();
// Create two threads to increment and decrement the counter
IncrementThread incrementThread = new IncrementThread(counter);
DecrementThread decrementThread = new DecrementThread(counter);
// Start the threads
incrementThread.start();
decrementThread.start();
// Wait for threads to finish
try {
incrementThread.join();
decrementThread.join();
} catch (InterruptedException e) {
e.printStackTrace();
}
// Display the final count value
System.out.println("Final count value: " + counter.getCount());
}
}

2. Write a Java Program for the implementation of scrollable ResultSet. Assume Teacher table
with attributes (TID, TName, Salary) is already created.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ScrollableResultSetExample {
public static void main(String[] args) {
// JDBC URL, username, and password of the database
String jdbcURL = "jdbc:mysql://localhost:3306/your_database";
String username = "your_username";
String password = "your_password";
try (Connection connection = DriverManager.getConnection(jdbcURL, username,
password)) {
// Create a Statement with a scrollable ResultSet
Statement statement =
connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
ResultSet.CONCUR_READ_ONLY);
// Execute a query to retrieve data from the Teacher table
String query = "SELECT TID, TName, Salary FROM Teacher";
ResultSet resultSet = statement.executeQuery(query);
// Move to the last row
resultSet.last();
// Get the row count
int rowCount = resultSet.getRow();
System.out.println("Total rows in Teacher table: " + rowCount);
// Move back to the first row
resultSet.beforeFirst();
// Iterate over the result set and print data
System.out.println("Teacher table data:");
while (resultSet.next()) {
int teacherId = resultSet.getInt("TID");
String teacherName = resultSet.getString("TName");
double salary = resultSet.getDouble("Salary");
System.out.println("TID: " + teacherId + ", TName: " + teacherName + ", Salary: " +
salary);
}
} catch (SQLException e) {
e.printStackTrace();
}
}
}