1. Write a Java Program to display the details of College (CID, CName, address, Year) on
JTable.

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
public class CollegeDetailsJTable extends JFrame {
public CollegeDetailsJTable() {
// Sample data for College details
Object[][] data = {
{1, "ABC College", "123 Main St", 2020},
{2, "XYZ College", "456 Broad St", 2019},
{3, "PQR College", "789 Oak St", 2021}
};
// Column names
String[] columnNames = {"CID", "CName", "Address", "Year"};
// Create a DefaultTableModel
DefaultTableModel model = new DefaultTableModel(data, columnNames);
// Create a JTable with the DefaultTableModel
JTable jTable = new JTable(model);
// Create a JScrollPane and add the JTable to it
JScrollPane jScrollPane = new JScrollPane(jTable);
// Set up the JFrame
setTitle("College Details");
setSize(400, 300);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Add the JScrollPane to the JFrame
add(jScrollPane, BorderLayout.CENTER);
}
public static void main(String[] args) {
SwingUtilities.invokeLater(() -> {
CollegeDetailsJTable collegeDetailsJTable = new CollegeDetailsJTable();
collegeDetailsJTable.setVisible(true);
});
}
}

2. Write a SERVLET program to change inactive time interval of session.

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/ChangeInactiveIntervalServlet")
public class ChangeInactiveIntervalServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
// Get the session
HttpSession session = request.getSession();
// Set the inactive time interval to 180 seconds (3 minutes)
session.setMaxInactiveInterval(180);
response.getWriter().println("Inactive time interval changed to 180 seconds.");
}
}