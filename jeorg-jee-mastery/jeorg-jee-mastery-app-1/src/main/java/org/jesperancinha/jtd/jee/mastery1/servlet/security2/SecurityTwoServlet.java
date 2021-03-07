package org.jesperancinha.jtd.jee.mastery1.servlet.security2;

import org.jesperancinha.console.consolerizer.console.ConsolerizerGraphs;
import org.jesperancinha.console.consolerizer.html.HtmlPWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_RED;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;

@WebServlet("/security/two")
@ServletSecurity(httpMethodConstraints = {
        @HttpMethodConstraint(value = "GET",
                rolesAllowed = "Organizer"),
        @HttpMethodConstraint(value = "POST",
                rolesAllowed = "Manager")})
public class SecurityTwoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String text = "You have reached the GET method of Security Two";
        BRIGHT_RED.printGenericTitleLn(text);
        final PrintWriter writer = resp.getWriter();
        writer.println(BRIGHT_RED.getPText(text));
        ConsolerizerGraphs.printRainbowFlag(text, new HtmlPWriter(writer));
        writer.println(MAGENTA.getPText("<p><a href=\"../index.xhtml\">Back</a></p>"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String text = "You have reached the POST method of Security Two";
        BRIGHT_RED.printGenericTitleLn(text);
        final PrintWriter writer = resp.getWriter();
        writer.println(BRIGHT_RED.getPText(text));
        writer.println(MAGENTA.getPText("<p><a href=\"../index.xhtml\">Back</a></p>"));
    }
}
