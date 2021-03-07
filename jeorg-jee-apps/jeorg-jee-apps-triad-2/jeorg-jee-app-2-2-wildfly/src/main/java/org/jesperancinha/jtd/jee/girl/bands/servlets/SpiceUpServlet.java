package org.jesperancinha.jtd.jee.girl.bands.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer.console.ConsolerizerGraphs.printUnicornsLn;

@WebServlet("/spice")
public class SpiceUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final var writer = resp.getWriter();
        final var session = req.getSession();
        final String id = session.getId();
        session.invalidate();
        try {
            session.getAttribute("spice");
        } catch (IllegalStateException e) {
            printUnicornsLn(100);
            RED.printGenericLn("This is expected! None of the session accessors are available when invalidate is summoned -> %s", e);
        }
        printUnicornsLn(100);
        writer.println(String.format("Session %s has been invalidated! Refresh to get a new one!", id));
        writer.println("Don't forget to check your logs!");
    }
}
