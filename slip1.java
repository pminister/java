1. Write a Java program to display all the alphabets between ‘A’ to ‘Z’ after every 2 seconds.

public class AlphabetDisplay {
public static void main(String[] args) {
char currentChar = 'A';
try{ while (currentChar <= 'Z') {
System.out.print(currentChar + " ");
currentChar++;
Thread.sleep(2000); // Sleep for 2 seconds
}
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}

2 Write a Java program to accept the details of Employee (Eno, EName, Designation, Salary)
from a user and store it into the database. (Use Swing).

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class EmployeeDetailsForm extends JFrame {
private JTextField txtEno, txtEName, txtDesignation, txtSalary;
public EmployeeDetailsForm() {
setTitle("Employee Details Form");
setSize(400, 300);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new GridLayout(5, 2));
JLabel lblEno = new JLabel("Employee Number:");
txtEno = new JTextField();
JLabel lblEName = new JLabel("Employee Name:");
txtEName = new JTextField();
JLabel lblDesignation = new JLabel("Designation:");
txtDesignation = new JTextField();
JLabel lblSalary = new JLabel("Salary:");
txtSalary = new JTextField();
JButton btnSave = new JButton("Save");
btnSave.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
saveEmployeeDetails();
}
});
add(lblEno);
add(txtEno);
add(lblEName);
add(txtEName);
add(lblDesignation);
add(txtDesignation);
add(lblSalary);
add(txtSalary);
add(new JLabel()); // Empty label for spacing
add(btnSave);
setLocationRelativeTo(null);
setVisible(true);
}
private void saveEmployeeDetails() {
try {
// JDBC connection
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection =
DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username",
"your_password");
// SQL query to insert data into the table
String query = "INSERT INTO employee (eno, ename, designation, salary) VALUES (?,
?, ?, ?)"; PreparedStatement preparedStatement = connection.prepareStatement(query);
// Set values from the text fields
preparedStatement.setInt(1, Integer.parseInt(txtEno.getText()));
preparedStatement.setString(2, txtEName.getText());
preparedStatement.setString(3, txtDesignation.getText());
preparedStatement.setDouble(4, Double.parseDouble(txtSalary.getText()));
// Execute the query
preparedStatement.executeUpdate();

preparedStatement.close();
connection.close();
JOptionPane.showMessageDialog(this, "Employee details saved successfully!");
} catch (ClassNotFoundException | SQLException e) {
e.printStackTrace();
JOptionPane.showMessageDialog(this, "Error saving employee details.");
}
}
public static void main(String[] args) {
SwingUtilities.invokeLater(new Runnable() {
@Override
public void run() {
new EmployeeDetailsForm();
}
});
}
}