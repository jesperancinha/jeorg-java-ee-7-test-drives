package org.jesperancinha.jtd.jee.mastery1.servlet.reader;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;

@WebServlet("/reader")
public class VariableReaderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final ServletContext servletContext = req.getServletContext();
        GREEN.printGenericTitleLn("Context Init Params");
        servletContext.getInitParameterNames().asIterator()
                .forEachRemaining(GREEN::printGenericLn);

        final ServletConfig servletConfig = getServletConfig();
        GREEN.printGenericTitleLn("Config Init Params");
        servletConfig.getInitParameterNames().asIterator()
                .forEachRemaining(GREEN::printGenericLn);

        final PrintWriter writer = resp.getWriter();
        writer.println(ConsolerizerColor.ORANGE.getPText("-------"));
        writer.println(MAGENTA.getPText("<p><a href=\"index.xhtml\">Back</a></p>"));
    }
}
