1. Write a java program to accept a String from a user and display each vowel from a String
after every 3 seconds.

import java.util.Scanner;
public class DisplayVowelsWithDelay {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Accept a string from the user
System.out.print("Enter a string: ");
String inputString = scanner.nextLine();
// Display each vowel after every 3 seconds
displayVowelsWithDelay(inputString);
scanner.close();
}
private static void displayVowelsWithDelay(String inputString) {
char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
for (char ch : inputString.toCharArray()) {
if (isVowel(ch)) {
System.out.println("Vowel: " + ch);
try {
// Pause execution for 3 seconds
Thread.sleep(3000);
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}
}
private static boolean isVowel(char ch) {
return "aeiouAEIOU".indexOf(ch) != -1;
}
}
    
2. Write a java program to accept ‘N’ student names through command line, store them into the
appropriate Collection and display them by using Iterator and ListIterator interface.

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
public class StudentNamesCollection {
public static void main(String[] args) {
// Check if at least one student name is provided as a command line argument
if (args.length < 1) {
System.out.println("Please provide at least one student name.");
return;
}
// Create an ArrayList to store student names
List<String> studentNamesList = new ArrayList<>();
// Add student names from command line arguments to the ArrayList
for (String studentName : args) {
studentNamesList.add(studentName);
}
// Display student names using Iterator
displayStudentNamesWithIterator(studentNamesList);
// Display student names using ListIterator
displayStudentNamesWithListIterator(studentNamesList);
}
private static void displayStudentNamesWithIterator(List<String> studentNamesList) {
System.out.println("Student Names using Iterator:");
Iterator<String> iterator = studentNamesList.iterator();
while (iterator.hasNext()) {
System.out.println(iterator.next());
}
System.out.println();
}
private static void displayStudentNamesWithListIterator(List<String> studentNamesList) {
System.out.println("Student Names using ListIterator (in reverse order):");
ListIterator<String> listIterator = studentNamesList.listIterator(studentNamesList.size());
while (listIterator.hasPrevious()) {
System.out.println(listIterator.previous());
}
}
}