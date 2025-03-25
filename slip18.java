1. Write a java program to display name and priority of a Thread.

public class ThreadInfoExample {
public static void main(String[] args) {
// Create a thread
Thread myThread = new Thread(() -> {
// Thread's logic goes here
for (int i = 0; i < 5; i++) {
System.out.println(Thread.currentThread().getName() + ": " + i);
}
});
// Set thread name
myThread.setName("MyCustomThread");
// Set thread priority (1 to 10, where 1 is the lowest and 10 is the highest)
myThread.setPriority(Thread.NORM_PRIORITY); // Default priority
// Display thread information before starting the thread
displayThreadInfo(myThread);
// Start the thread
myThread.start();
// Display thread information after starting the thread
displayThreadInfo(myThread);
}
private static void displayThreadInfo(Thread thread) {
System.out.println("Thread Name: " + thread.getName());
System.out.println("Thread Priority: " + thread.getPriority());
System.out.println("---------------------------");
}
}
2. Write a SERVLET program in java to accept details of student (SeatNo, Stud_Name, Class,
Total_Marks). Calculate percentage and grade obtained and display details on page.

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/StudentDetailsServlet")
public class StudentDetailsServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
// Get student details from request parameters
int seatNo = Integer.parseInt(request.getParameter("seatNo"));
String studName = request.getParameter("studName");
String className = request.getParameter("className");
int totalMarks = Integer.parseInt(request.getParameter("totalMarks"));
// Calculate percentage and grade
double percentage = (double) totalMarks / 500 * 100;
String grade = calculateGrade(percentage);
// Display student details, percentage, and grade on the web page
out.println("<html><body>");
out.println("<h2>Student Details:</h2>");
out.println("<p>Seat No: " + seatNo + "</p>");
out.println("<p>Student Name: " + studName + "</p>");
out.println("<p>Class: " + className + "</p>");
out.println("<p>Total Marks: " + totalMarks + "</p>");
out.println("<h2>Result:</h2>");
out.println("<p>Percentage: " + percentage + "%</p>");
out.println("<p>Grade: " + grade + "</p>");
out.println("</body></html>");
out.close();
}
private String calculateGrade(double percentage) {
if (percentage >= 90) {
return "A+";
} else if (percentage >= 80) {
return "A";
} else if (percentage >= 70) {
return "B";
} else if (percentage >= 60) {
return "C";
} else if (percentage >= 50) {
return "D";
} else {
return "Fail";
}
}
}