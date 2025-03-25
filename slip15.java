1. Write a java program to display name and priority of a Thread.

public class ThreadInfoExample {
public static void main(String[] args) {
// Create and start a thread
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
// Start the thread
myThread.start();
// Display thread information
displayThreadInfo(myThread);
}
private static void displayThreadInfo(Thread thread) {
System.out.println("Thread Name: " + thread.getName());
System.out.println("Thread Priority: " + thread.getPriority());
}
}


Q2
import java.io.*; 
import javax.servlet.*;
 import javax.servlet.http.*;
  public class S15Q2 extends HttpServlet
   { 
    public void doGet(HttpServletRequest req, HttpServletResponse res)
     throws IOException, ServletException
      { 
        res.setContentType("text/html");
         int visitCount = 0; 
         Cookie[] cookies = req.getCookies(); 
         if (cookies != null) 
         { for (Cookie cookie : cookies) 
         { 
            if (cookie.getName().equals("visitCount"))
             { visitCount = Integer.parseInt(cookie.getValue());
              break; 
              }
               }
                }
                 PrintWriter out = res.getWriter(); 
                 out.println("<html>"); 
                 out.println("<body>");
                  if (visitCount == 0) 
                  out.println("<h1>Welcome! This is your first visit to the page.</h1>"); 
                  else out.println("<h1>Welcome back! You've visited this page " + visitCount + " times.</h1>");
                   visitCount++; Cookie visitCookie = new Cookie
                   ("visitCount", String.valueOf(visitCount));
                    res.addCookie(visitCookie); 
                    out.println("<form method=\"post\">"); 
                    out.println("<input type=\"submit\" value=\"Refresh\">"); 
                    out.println("</form>"); 
                    out.println("</body>");
                     out.println("</html>"); }
public void doPost(HttpServletRequest req,
 HttpServletResponse res) 
 throws IOException, ServletException 
 {
     doGet(req, res);
      }
       }