package org.jesperancinha.jtd.jee.app1.servlets;

import org.jesperancinha.jtd.jee.app1.service.PopArtistsService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.jesperancinha.console.consolerizer8.Consolerizer.blackAndWhite;
import static org.jesperancinha.console.consolerizer8.Consolerizer.maxLineCharsGlobal;
import static org.jesperancinha.console.consolerizer8.Consolerizer.titleSpread;
import static org.jesperancinha.console.consolerizer8.Consolerizer.typingWaitGlobal;
import static org.jesperancinha.console.consolerizer8.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer8.ConsolerizerColor.MAGENTA;

@WebServlet("/popartists")
public class PopArtistsServlet extends HttpServlet {

    @Inject
    PopArtistsService popArtistsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        typingWaitGlobal = 0;
        maxLineCharsGlobal = 100;
        titleSpread = 100;
        blackAndWhite = false;
        BLUE.printGenericTitleLn("Application1");
        BLUE.printGenericTitleLn(PopArtistsServlet.this.getClass());

        final List<String> popArtists = popArtistsService.popArtists();
        MAGENTA.printGenericTitleLn(popArtists);

        PrintWriter writer = resp.getWriter();
        writer.println("<html><head><title>An artists page</title></head><body>");
        writer.println("<h1>" + popArtists + "</h1>");
        final String exercise1 = "Note that in JEE, we do not need to use any extra annotation to inject a Service.\n"
                + "The service itself, does not use any annotation";
        writer.println("<p>" + exercise1 + "</p>");
        writer.println("<a href=\"index.html\">Back</a>");
        writer.println("<a href=\"./popartists\">Refresh</a>");
        writer.println("</body></html>");
        writer.close();
    }

}