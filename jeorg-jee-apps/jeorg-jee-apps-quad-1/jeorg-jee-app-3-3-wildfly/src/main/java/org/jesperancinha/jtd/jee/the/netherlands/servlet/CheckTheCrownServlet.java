package org.jesperancinha.jtd.jee.the.netherlands.servlet;

import org.jesperancinha.jtd.jee.the.netherlands.beans.CrownOfTheState;
import org.jesperancinha.jtd.jee.the.netherlands.beans.CurrentRuler;
import org.jesperancinha.jtd.jee.the.netherlands.beans.HeirToTheThrone;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import static org.jesperancinha.console.consolerizer.console.Consolerizer.setupFastDefault;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;

@WebServlet("/history/crown")
public class CheckTheCrownServlet extends HttpServlet {

    @EJB
    public static CrownOfTheState crownOfTheState;

    @Inject
    private CurrentRuler currentRuler;

    @Inject
    private HeirToTheThrone heirToTheThrone;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setupFastDefault();
        GREEN.printGenericLn("Current ruler is %s", currentRuler);
        GREEN.printGenericLn("The heir to the throne is %s", heirToTheThrone);
        GREEN.printGenericLn("The static crown is %s", crownOfTheState);

        final PrintWriter writer = resp.getWriter();

        writer.println("<html><head></head><body>");

        writer.println(String.format("<p>%s</p>", currentRuler));
        writer.println(String.format("<p>%s</p>", heirToTheThrone));

        Arrays.stream(CrownOfTheState.class.getDeclaredAnnotations())
                .forEach(annotation -> {
                    writer.println(String.format("<p>%s</p>", annotation));
                    Arrays.stream(annotation.annotationType()
                            .getDeclaredAnnotations())
                            .forEach(annotation1 -> writer.println(String.format("<p>%s</p>", annotation1)));
                });
        writer.println("<p><a href=\"../index.xhtml\">Back</a></p>");
        writer.println("</body></html>");
    }
}
