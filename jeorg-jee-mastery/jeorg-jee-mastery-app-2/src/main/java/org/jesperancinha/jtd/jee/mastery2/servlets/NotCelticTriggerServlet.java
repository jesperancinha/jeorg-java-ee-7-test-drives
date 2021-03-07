package org.jesperancinha.jtd.jee.mastery2.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;

@WebServlet("/ariaschorus/notceltic")
public class NotCelticTriggerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GREEN.printGenericTitleLn("Kyla La Grange style isn't really celtic.");
        throw new NotCelticMusicException("Kyla La Grange style isn't really celtic.");
    }
}
