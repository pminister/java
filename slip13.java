1. Write a Java program to display information about the database and list all the tables in the
database. (Use DatabaseMetaData).
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DatabaseInfo {
private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/your_database"; //
Replace with your database URL
private static final String USERNAME = "your_username"; // Replace with your database
username
private static final String PASSWORD = "your_password"; // Replace with your database
password
public static void main(String[] args) {
try (Connection connection = DriverManager.getConnection(DATABASE_URL,
USERNAME, PASSWORD)) {
DatabaseMetaData metaData = connection.getMetaData();
// Display database information
System.out.println("Database Information:");
System.out.println("Database Name: " + metaData.getDatabaseProductName());
System.out.println("Database Version: " + metaData.getDatabaseProductVersion());
System.out.println("Driver Name: " + metaData.getDriverName());
System.out.println("Driver Version: " + metaData.getDriverVersion());
System.out.println();
// List all tables in the database
System.out.println("Tables in the Database:");
ResultSet resultSet = metaData.getTables(null, null, null, new String[]{"TABLE"});
while (resultSet.next()) {
String tableName = resultSet.getString("TABLE_NAME");
System.out.println(tableName);
}
} catch (SQLException e) {
e.printStackTrace();
}
}
}
2. Write a Java program to show lifecycle (creation, sleep, and dead) of a thread. Program
should print randomly the name of thread and value of sleep time. The name of the thread
should be hard coded through constructor. The sleep time of a thread will be a random integer
in the range 0 to 4999.
import java.util.Random;
class MyThread extends Thread {
public MyThread(String name) {
super(name);
}
@Override
public void run() {
System.out.println("Thread " + getName() + " is created.");
// Generate a random sleep time between 0 and 4999 milliseconds
Random random = new Random();
int sleepTime = random.nextInt(5000);
System.out.println("Thread " + getName() + " will sleep for " + sleepTime + "
milliseconds.");
try {
Thread.sleep(sleepTime);
} catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println("Thread " + getName() + " is dead.");
}
}
public class ThreadLifecycleDemo {
public static void main(String[] args) {
MyThread thread1 = new MyThread("Thread-1");
MyThread thread2 = new MyThread("Thread-2");
thread1.start();
thread2.start();
}
}