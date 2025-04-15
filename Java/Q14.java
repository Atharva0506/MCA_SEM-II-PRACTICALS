
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

        out.println("<html><head><title>Request and Server Info</title></head><body>");
        out.println("<h2>Client Information:</h2>");
        out.println("<ul>");
        out.println("<li><b>IP Address:</b> " + request.getRemoteAddr() + "</li>");
        out.println("<li><b>Browser:</b> " + request.getHeader("User-Agent") + "</li>");
        out.println("<li><b>HTTP Method:</b> " + request.getMethod() + "</li>");
        out.println("<li><b>Request URI:</b> " + request.getRequestURI() + "</li>");
        out.println("</ul>");

        out.println("<h2>Server Information:</h2>");
        out.println("<ul>");
        out.println("<li><b>Server Name:</b> " + request.getServerName() + "</li>");
        out.println("<li><b>Server Port:</b> " + request.getServerPort() + "</li>");
        out.println("<li><b>Servlet Context:</b> " + getServletContext().getServerInfo() + "</li>");
        out.println("<li><b>Operating System:</b> " + System.getProperty("os.name") + "</li>");
        out.println("</ul>");

        out.println("<h2>Loaded Servlets:</h2>");
        out.println("<ul>");
        Enumeration<String> servletNames = getServletContext().getServletNames();
        while (servletNames.hasMoreElements()) {
            out.println("<li>" + servletNames.nextElement() + "</li>");
        }
        out.println("</ul>");

        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}

