package org.jesperancinha.jtd.jee.soul.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;

@WebServlet("/corvette")
public class LittleRedCorvetteServlet extends HttpServlet {

    private static final String FROM = "https://genius.com/Prince-little-red-corvette-lyrics";
    private static final String LITTLE_RED_CORVETTE = "Little Red Corvette";
    private static final String BABY_YOU_RE_MUCH_TOO_FAST = "Baby, you're much too fast";

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        final PrintWriter writer = res.getWriter();
        writer.println(FROM);
        writer.println(LITTLE_RED_CORVETTE);
        YELLOW.printGenericLn(LITTLE_RED_CORVETTE);
        super.service(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer = resp.getWriter();
        writer.println(FROM);
        writer.println(BABY_YOU_RE_MUCH_TOO_FAST);
        YELLOW.printGenericLn(BABY_YOU_RE_MUCH_TOO_FAST);
        GREEN.printGenericLn("The point here is that in a normal situation the sequence is init -> service -> get -> destroy");
        GREEN.printGenericLn("This cycle can be broken if overriding doesn't continue in the super methods");
        super.service(req, resp);

    }
}
