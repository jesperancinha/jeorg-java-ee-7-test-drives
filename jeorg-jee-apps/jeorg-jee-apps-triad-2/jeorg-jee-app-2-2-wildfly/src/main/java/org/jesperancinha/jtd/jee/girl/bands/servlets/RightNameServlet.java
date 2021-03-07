package org.jesperancinha.jtd.jee.girl.bands.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

public class RightNameServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            final var writer = response.getWriter();
            final var leftName = request.getParameter("left");
            writer.println("The song is:");
            writer.println(leftName + " Forever");
            writer.close();
        } catch (Exception e) {
            RED.printThrowableAndExit(e);
        }
    }

    public String getSongName() {
        return "Forever";
    }
}
