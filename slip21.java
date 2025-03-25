1. Write a java program to accept ‘N’ Subject Names from a user store them into LinkedList
Collection and Display them by using Iterator interface.

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;
public class SubjectNamesLinkedList {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Accept 'N' subject names from the user
System.out.print("Enter the value of N: ");
int n = scanner.nextInt();
// Create a LinkedList to store subject names
LinkedList<String> subjectList = new LinkedList<>();
// Accept subject names from the user and add them to the LinkedList
for (int i = 0; i < n; i++) {
System.out.print("Enter subject name " + (i + 1) + ": ");
String subjectName = scanner.next();
subjectList.add(subjectName);
}
// Display subject names using Iterator
System.out.println("Subject Names:");
Iterator<String> iterator = subjectList.iterator();
while (iterator.hasNext()) {
System.out.println(iterator.next());
}
scanner.close();
}
}