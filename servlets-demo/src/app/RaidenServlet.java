package app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "raidenServlet",
        urlPatterns = { "/raiden-servlet" }
)
public class RaidenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<html><head></head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<marquee><img src='images/raiden.gif'/></marquee>");
        resp.getWriter().write("</body>");
    }
}
