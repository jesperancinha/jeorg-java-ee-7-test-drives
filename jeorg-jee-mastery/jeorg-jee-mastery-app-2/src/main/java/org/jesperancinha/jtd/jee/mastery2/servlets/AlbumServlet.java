package org.jesperancinha.jtd.jee.mastery2.servlets;

import org.jesperancinha.jtd.jee.mastery2.beans.Album;
import org.jesperancinha.jtd.jee.mastery2.beans.Album2;
import org.jesperancinha.jtd.jee.mastery2.beans.Album3;
import org.jesperancinha.jtd.jee.mastery2.beans.Publisher;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;

@WebServlet("/ariaschorus/album")
public class AlbumServlet extends HttpServlet {

    @Inject
    private Album album;

    @Inject
    private Album2 album2;

    @Inject
    private Album3 album3;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer = resp.getWriter();
        YELLOW.printGenericLn(album);
        YELLOW.printGenericLn(album2);
        YELLOW.printGenericLn(album3);
        writer.println(BLUE.getPBText("Look at the log and refresh the page"));
        writer.println(BLUE.getPBText(album));
        writer.println(BLUE.getPBText(album2));
        writer.println(BLUE.getPBText(album3));
        final Publisher publisher = new Publisher();
        publisher.setPublisher("This publisher isn't right");
        album3.setPublisher(publisher);
        writer.println(MAGENTA.getPText("<p><a href=\"../index.xhtml\">Back</a></p>"));
    }
}
