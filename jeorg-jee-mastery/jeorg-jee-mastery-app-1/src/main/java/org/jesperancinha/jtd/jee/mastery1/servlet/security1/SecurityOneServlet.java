package org.jesperancinha.jtd.jee.mastery1.servlet.security1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_RED;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;

@WebServlet("/security/one")
public class SecurityOneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String text = "You have reached the GET method of Security One";
        BRIGHT_RED.printGenericTitleLn(text);
        final PrintWriter writer = resp.getWriter();
        writer.println(BRIGHT_RED.getPText(text));
        writer.println(MAGENTA.getPText("<p><a href=\"../index.xhtml\">Back</a></p>"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String text = "You have reached the POST method of Security One";
        BRIGHT_RED.printGenericTitleLn(text);
        final PrintWriter writer = resp.getWriter();
        writer.println(BRIGHT_RED.getPText(text));
        writer.println(MAGENTA.getPText("<p><a href=\"../index.xhtml\">Back</a></p>"));
    }
}
