2) Write a Java Program to create a PROJECT table with field’s project_id, Project_name,
Project_description, Project_Status. Insert values in the table. Display all the details of the
PROJECT table in a tabular format on the screen.(using swing).

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class ProjectTableApp extends JFrame {
private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/your_database"; //
Replace with your database URL
private static final String USERNAME = "your_username"; // Replace with your database
username
private static final String PASSWORD = "your_password"; // Replace with your database
password
private DefaultTableModel tableModel;
public ProjectTableApp() {
super("Project Table");
// Create table model with columns
tableModel = new DefaultTableModel();
tableModel.addColumn("Project ID");
tableModel.addColumn("Project Name");
tableModel.addColumn("Project Description");
tableModel.addColumn("Project Status");
// Create table with the table model
JTable table = new JTable(tableModel);
// Create scroll pane and add the table to it
JScrollPane scrollPane = new JScrollPane(table);
// Create button to insert values into the table
JButton insertButton = new JButton("Insert Values");
insertButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
insertValuesIntoTable();
}
});
// Set layout and add components to the frame
setLayout(new BorderLayout());
add(scrollPane, BorderLayout.CENTER);
add(insertButton, BorderLayout.SOUTH);
// Set frame properties
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(600, 400);
setLocationRelativeTo(null); // Center the frame on the screen
}
private void insertValuesIntoTable() {
try (Connection connection = DriverManager.getConnection(DATABASE_URL,
USERNAME, PASSWORD)) {
// Insert values into the PROJECT table
String insertQuery = "INSERT INTO PROJECT (project_id, Project_name,
Project_description, Project_Status) VALUES (?, ?, ?, ?)";
try (PreparedStatement preparedStatement =
connection.prepareStatement(insertQuery)) {
// Replace these values with the actual values you want to insert
preparedStatement.setInt(1, 1);
preparedStatement.setString(2, "Project 1");
preparedStatement.setString(3, "Description 1");
preparedStatement.setString(4, "Active");
int rowsAffected = preparedStatement.executeUpdate();
if (rowsAffected > 0) {
System.out.println("Values inserted successfully.");
}
}
// Display all details of the PROJECT table
String selectQuery = "SELECT * FROM PROJECT";
try (Statement statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery(selectQuery)) {
tableModel.setRowCount(0); // Clear existing rows in the table
while (resultSet.next()) {
Object[] rowData = {
resultSet.getInt("project_id"),
resultSet.getString("Project_name"),
resultSet.getString("Project_description"),
resultSet.getString("Project_Status")
};
tableModel.addRow(rowData);
}
}
} catch (SQLException e) {
e.printStackTrace();
}
}
public static void main(String[] args) {
SwingUtilities.invokeLater(new Runnable() {
@Override
public void run() {
new ProjectTableApp().setVisible(true);
}
});
}
}