package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminFeedbackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String contextPath = req.getContextPath();
        if (session == null || !"admin".equals(session.getAttribute("role"))) {
            resp.sendRedirect(contextPath + "/login.html");
            return;
        }
        req.getRequestDispatcher("/jsp/admin-dashboard.jsp").forward(req, resp);
    }
}
