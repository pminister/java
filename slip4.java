1. Write a Java program using Runnable interface to blink Text on the frame

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BlinkingTextFrame implements Runnable {
private JFrame frame;
private JLabel label;
public static void main(String[] args) {
SwingUtilities.invokeLater(new BlinkingTextFrame());
}
@Override
public void run() {
frame = new JFrame("Blinking Text Frame");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(300, 100);
label = new JLabel("Blinking Text", JLabel.CENTER);
frame.add(label);
Timer timer = new Timer(500, new ActionListener() {
private boolean isVisible = true;
@Override
public void actionPerformed(ActionEvent e) {
isVisible = !isVisible;
label.setVisible(isVisible);
}
});
timer.start();
frame.setVisible(true);
}
}
2. Write a Java program to store city names and their STD codes using an appropriate collection
and perform following operations: i. Add a new city and its code (No duplicates) ii. Remove a
city from the collection iii. Search for a city name and display the code
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class CityStdCodeCollection {
private static Map<String, String> cityStdCodes = new HashMap<>();
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
int choice;
do{ System.out.println("1. Add a new city and its code");
System.out.println("2. Remove a city from the collection");
System.out.println("3. Search for a city name and display the code");
System.out.println("4. Exit");
System.out.print("Enter your choice: ");
choice = scanner.nextInt();
switch (choice) {
case 1:
addCityAndCode(scanner);
break;
case 2:
removeCity(scanner);
break;
case 3:
searchCity(scanner);
break;
case 4:
System.out.println("Exiting program.");
break;
default:
System.out.println("Invalid choice. Please enter a valid option.");
break;
}
} while (choice != 4);
scanner.close();
}
private static void addCityAndCode(Scanner scanner) {
System.out.print("Enter city name: ");
String cityName = scanner.next();
if (!cityStdCodes.containsKey(cityName)) {
System.out.print("Enter STD code for " + cityName + ": ");
String stdCode = scanner.next();
cityStdCodes.put(cityName, stdCode);
System.out.println("City added successfully.");
} else {
System.out.println("City already exists. Cannot add duplicate entries.");
}
}
private static void removeCity(Scanner scanner) {
System.out.print("Enter city name to remove: ");
String cityName = scanner.next();
if (cityStdCodes.containsKey(cityName)) {
cityStdCodes.remove(cityName);
System.out.println("City removed successfully.");
} else {
System.out.println("City not found. Cannot remove.");
}
}
private static void searchCity(Scanner scanner) {
System.out.print("Enter city name to search: ");
String cityName = scanner.next();
if (cityStdCodes.containsKey(cityName)) {
System.out.println("STD code for " + cityName + ": " + cityStdCodes.get(cityName));
} else {
System.out.println("City not found.");
}
}
}