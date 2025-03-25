1. Write a java program to accept ‘N’ integers from a user. Store and display integers in sorted
order having proper collection class. The collection should not accept duplicate elements.

import java.util.Scanner;
import java.util.TreeSet;
public class SortedIntegerCollection {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Accept 'N' integers from the user
System.out.print("Enter the value of N: ");
int n = scanner.nextInt();
// Create a TreeSet to store integers in sorted order without duplicates
TreeSet<Integer> integerSet = new TreeSet<>();
// Accept integers from the user and add them to the TreeSet
for (int i = 0; i < n; i++) {
System.out.print("Enter integer " + (i + 1) + ": ");
int inputInt = scanner.nextInt();
integerSet.add(inputInt);
}
// Display the integers in sorted order
System.out.println("Integers in sorted order:");
for (int num : integerSet) {
System.out.println(num);
}
scanner.close();
}
}



Q2

import java.awt.*; 
import javax.swing.*;
 import java.awt.event.*;
 public class S17Q2 extends JFrame
  {
JTextField textField;
 JButton startBtn;
  public S17Q2()
   { setTitle("Number Display");
    setSize(450,300); 
    setDefaultCloseOperation(EXIT_ON_CLOSE);
     setLayout(new FlowLayout());
      textField = new JTextField(10);
       add(textField); 
       startBtn = new JButton("Start");
        startBtn.addActionListener(new ActionListener()
         { public void actionPerformed(ActionEvent e)
          { startDisplay(); 
          } 
          }
          );
           add(startBtn);
            setVisible(true);
             } 
             private void startDisplay()
              { 
                Thread displayThread = new Thread(new DisplayRunnable()); 
                displayThread.start();
                 } 
                 private class DisplayRunnable implements Runnable
                  {
                     public void run() { for(int i=1; i<=100; i++)
                      
                      
                      {
                         textField.setText(Integer.toString(i));
                          try { Thread.sleep(100); 
                          } 
                          catch (InterruptedException e)
                           { System.out.println(e);
                            } 
                           }
                            textField.setText("");
                            }
                            }
                             public static void main(String args[]) 
                             {
                                 new S17Q2();
                                  } 
                                  }