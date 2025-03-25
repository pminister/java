SLIP 7
1. Write a java program that implements a multi-thread application that has three threads. First
thread generates random integer number after every one second, if the number is even; second
thread computes the square of that number and print it. If the number is odd, the third thread
computes the of cube of that number and print it.

import java.util.Random;
public class MultiThreadApplication {
public static void main(String[] args) {
NumberGenerator generator = new NumberGenerator();
SquareCalculator squareCalculator = new SquareCalculator(generator);
CubeCalculator cubeCalculator = new CubeCalculator(generator);
Thread generatorThread = new Thread(generator);
Thread squareThread = new Thread(squareCalculator);
Thread cubeThread = new Thread(cubeCalculator);
generatorThread.start();
squareThread.start();
cubeThread.start();
}
}
class NumberGenerator implements Runnable {
private Random random = new Random();
@Override
public void run() {
try{ while (true) {
int randomNumber = getRandomNumber();
System.out.println("Generated number: " + randomNumber);
if (randomNumber % 2 == 0) {
SquareCalculator.setNumber(randomNumber);
} else {
CubeCalculator.setNumber(randomNumber);
}
Thread.sleep(1000);
}
} catch (InterruptedException e) {
e.printStackTrace();
}
}
private int getRandomNumber() {
return random.nextInt(100);
}
}
class SquareCalculator implements Runnable {
private static int number;
private NumberGenerator generator;
public SquareCalculator(NumberGenerator generator) {
this.generator = generator;
}
public static void setNumber(int num) {
number = num;
}
@Override
public void run() {
try{ while (true) {
synchronized (this) {
wait();
int square = number * number;
System.out.println("Square of " + number + ": " + square);
}
}
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}
class CubeCalculator implements Runnable {
private static int number;
private NumberGenerator generator;
public CubeCalculator(NumberGenerator generator) {
this.generator = generator;
}
public static void setNumber(int num) {
number = num;
}
@Override
public void run() {
try{ while (true) {
synchronized (this) {
wait();
int cube = number * number * number;
System.out.println("Cube of " + number + ": " + cube);
}
}
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}


Q2)

import java.sql.*; public class S7Q2 { 
    public static void main(String args[])
     { try { 
        Class.forName("org.postgresql.Driver"); 
     Connection con = DriverManager.getConnection
     ("jdbc:postgresql://localhost:5432/ty92","ty92","ty92");
      Statement stmt = con.createStatement();
       stmt.execute("CREATE TABLE IF NOT EXISTS Product(PID int primary key, PNAME varchar(20), PRICE int)");
        System.out.println("Table created successfully!");
         insertRecords(stmt); displayRecords(stmt); 
         stmt.close(); }
          catch 
          (SQLException | ClassNotFoundException e) 
          { 
            System.out.println(e);
           } 
           } 
           private static void insertRecords(Statement stmt)
           throws SQLException 
           { 
            String insertSQL = "INSERT INTO Product (PID, PNAME, PRICE) VALUES ";
            String records[] = { "(1, 'A', 12)", "(2, 'B', 32)", "(3, 'C', 24)", 
            "(4, 'D', 14)", "(5, 'E', 10)" }; 
            for(String record : records) stmt.executeUpdate(insertSQL + record);
             System.out.println("\nRecords inserted into product table successfully!");
} private static void displayRecords(Statement stmt) 
throws SQLException
 { ResultSet rs = stmt.executeQuery("SELECT * FROM Product"); 
 System.out.println("\n- Records from Product Table -\n"); 
 System.out.println("\nPID\tPNAME\tPRICE"); 
 while(rs.next())
  { int pid = rs.getInt("PID"); 
  String pname = rs.getString("PNAME");
   int price = rs.getInt("PRICE"); 
  System.out.println(pid + "\t" + pname + "\t" + price); 
  } rs.close(); } }