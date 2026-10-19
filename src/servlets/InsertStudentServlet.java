package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertStudentServlet extends HttpServlet {
    private static final String URL = DbConfig.getUrl();
    private static final String USER = DbConfig.getDbUser();
    private static final String PASS = DbConfig.getDbPassword();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String contextPath = req.getContextPath();
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body><h2>Add New Student</h2>");
        out.println("<form method='post' action='" + contextPath + "/insert-student'>");
        out.println("ID: <input name='id' type='number' required/><br/><br/>");
        out.println("Name: <input name='name' required/><br/><br/>");
        out.println("Branch: <input name='branch' required/><br/><br/>");
        out.println("Year: <input name='year' type='number' required/><br/><br/>");
        out.println("<input type='submit' value='Add Student'/>");
        out.println("</form></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String branch = req.getParameter("branch");
        int year = Integer.parseInt(req.getParameter("year"));
        String contextPath = req.getContextPath();

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement ps = con.prepareStatement("INSERT INTO students VALUES(?,?,?,?)")) {
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setString(3, branch);
                ps.setInt(4, year);
                ps.executeUpdate();
                out.println("<html><body><h2 style='color:green'>Student inserted successfully!</h2>");
                out.println("<p>" + name + " added to database.</p>");
            }
        } catch (Exception e) {
            out.println("<html><body><h2 style='color:red'>Error: " + e.getMessage() + "</h2>");
        }
        out.println("<a href='" + contextPath + "/insert-student'>Insert Another</a> | <a href='" + contextPath + "/records'>View All</a>");
        out.println("</body></html>");
    }
}
