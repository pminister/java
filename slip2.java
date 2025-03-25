SLIP 2
1. Write a java program to read ‘N’ names of your friends, store it into HashSet and display them
in ascending order.

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
public class FriendNames {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the number of friends (N): ");
int n = scanner.nextInt();

HashSet<String> friendSet = new HashSet<>();

for (int i = 0; i < n; i++) {
System.out.print("Enter name of friend " + (i + 1) + ": ");
String name = scanner.next();
friendSet.add(name);
}

TreeSet<String> sortedFriendSet = new TreeSet<>(friendSet);

System.out.println("\nFriend Names in Ascending Order:");
Iterator<String> iterator = sortedFriendSet.iterator();
while (iterator.hasNext()) {
System.out.println(iterator.next());
}
scanner.close();
}
}

2. Design a servlet that provides information about a HTTP request from a client, such as
IP-Address and browser type. The servlet also provides information about the server on which
the servlet is running, such as the operating system type, and the names of currently loaded
servlets.

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/RequestInfoServlet")
public class RequestInfoServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<html>");
out.println("<head>");
out.println("<title>Request and Server Information</title>");
out.println("</head>");
out.println("<body>");

out.println("<h2>Client Information:</h2>");
out.println("<p>IP Address: " + request.getRemoteAddr() + "</p>");
out.println("<p>Browser Type: " + request.getHeader("User-Agent") + "</p>");

out.println("<h2>Server Information:</h2>");
out.println("<p>Server OS: " + System.getProperty("os.name") + "</p>");

out.println("<h2>Loaded Servlets:</h2>");
Enumeration<String> servletNames =
getServletConfig().getServletContext().getServletNames();
while (servletNames.hasMoreElements()) {
String servletName = servletNames.nextElement();
out.println("<p>" + servletName + "</p>");
}
out.println("</body>");
out.println("</html>");
}
}