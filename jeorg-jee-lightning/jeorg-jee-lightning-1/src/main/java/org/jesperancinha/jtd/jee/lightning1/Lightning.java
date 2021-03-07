package org.jesperancinha.jtd.jee.lightning1;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;

@WebServlet("/")
public class Lightning extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final PrintWriter writer = resp.getWriter();
        writer.println(MAGENTA.getPText("You see? No need for web.xml"));
        ConsolerizerColor.getRandomColor().printGenericLn("Note that you do not need web.xml. War can be implemented just as well with annotations");
    }
}
