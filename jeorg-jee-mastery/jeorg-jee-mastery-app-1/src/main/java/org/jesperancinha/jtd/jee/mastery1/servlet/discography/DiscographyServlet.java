package org.jesperancinha.jtd.jee.mastery1.servlet.discography;

import org.jesperancinha.jtd.jee.mastery1.beans.Record;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;

@WebServlet("/discography")
public class DiscographyServlet extends HttpServlet {

    private static final Record record1 = new Record();
    private static final Record record2 = new Record();

    static {
        record1.setName("The Medicine Show");
        record1.setArtist("Melissa Etheridge");
        record1.setType("LP");
        record1.setYear("2019");

        record2.setName("MEmphis Rock and Soul");
        record2.setArtist("Melissa Etheridge");
        record2.setType("LP");
        record2.setYear("2016");
    }

    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        PrintWriter writer = res.getWriter();
        writer.println(GREEN.getPText("service"));
        writer.println(BLUE.getPText(record2));
        writer.println(MAGENTA.getPText("<p><a href=\"index.xhtml\">Back</a></p>"));
        GREEN.printGenericLn("The point is the we have overridden service.");
        GREEN.printGenericLn("service gets called first and only then we call GET.");
        GREEN.printGenericLn("This is why the other servlet is broken");
        GREEN.printGenericLn(record2);
        super.service(req, res);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        PrintWriter writer = res.getWriter();
        writer.println(GREEN.getPText("get"));
        writer.print(BLUE.getPText(record1));
        writer.println(MAGENTA.getPText("<p><a href=\"index.xhtml\">Back</a></p>"));
        MAGENTA.printGenericLn(record1);
    }
}
