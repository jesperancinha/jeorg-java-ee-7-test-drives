package org.jesperancinha.jtd.jee.the.netherlands.servlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.jesperancinha.console.consolerizer.console.Consolerizer.printRainbowTitleLn;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@WebServlet("/history/dynasties")
public class ListOfKingsAndQueensServlet extends HttpServlet {

    @Inject
    private ListOfKingsAndQueensBean listOfKingsAndQueensBean;

    @Inject
    private ListOfKingsAndQueensBeanForOrangeNassau listOfKingsAndQueensBeanForOrangeNassau;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final PrintWriter writer = resp.getWriter();
        writer.println("<html><head></head><body");
        GREEN.printGenericLn("<p>You are currently logged in as %s</p>", req.getUserPrincipal());
        writer.println(String.format("<p>You are currently logged in as %s</p>", req.getUserPrincipal()));

        try {
            final List<String> orangeNassau = listOfKingsAndQueensBean.getOrangeNassau();
            writer.println("<h1>This is the Royal Orange-Nassau first Dynasty</h1>");
            orangeNassau.forEach(writer::println);
        } catch (Exception e) {
            RED.printGenericLn("This may be expected! -> %s", e.getMessage());
            GREEN.printGenericLn("Check your user. It has to have the Manager or Civilian role, otherwise they cannot see the common Orange Nassau list");
            printRainbowTitleLn("They can, however, use the royal one ;-)");
        }

        try {
            final List<String> orangeNassau = listOfKingsAndQueensBeanForOrangeNassau.getOrangeNassau();
            final List<String> nassau = listOfKingsAndQueensBeanForOrangeNassau.getNassau();
            writer.println("<h1>This is the Royal Orange-Nassau first Dynasty from a Royal perspective</h1>");
            orangeNassau.forEach(writer::println);
            writer.println("<h1>This is the Nassau Dynasty from a Royal perspective</h1>");
            nassau.forEach(writer::println);
        } catch (Exception e) {
            RED.printGenericLn("This may be expected! -> %s", e.getMessage());
            GREEN.printGenericLn("Check your user. It has to have the OranjeNassau profile, otherwise they cannot see the royal Orange Nassau list");
            printRainbowTitleLn("They can, however, use the royal one ;-)");
        }
        try {
            final List<String> nassau = listOfKingsAndQueensBean.getNassau();
            writer.println("<h1>This is the Nassau Dynasty</h1>");
            nassau.forEach(writer::println);

        } catch (Exception e) {
            RED.printGenericLn("This may be expected! -> %s", e.getMessage());
            GREEN.printGenericLn("Check your user. It has to have the Manager role, otherwise they cannot see the Nassau dynasty member list");
        }

        writer.println("<p><a href=\"../index.xhtml\">Back</a></p>");
        writer.println("</body></html>");
    }
}
