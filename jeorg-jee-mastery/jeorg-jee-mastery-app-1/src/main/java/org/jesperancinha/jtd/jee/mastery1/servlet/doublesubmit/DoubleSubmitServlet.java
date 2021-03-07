package org.jesperancinha.jtd.jee.mastery1.servlet.doublesubmit;

import org.jesperancinha.jtd.jee.mastery1.beans.Record;

import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@WebServlet("/double")
public class DoubleSubmitServlet extends HttpServlet {

    private final static Record ALBUM = new Record();

    static {
        ALBUM.setName("The Heist");
        ALBUM.setArtist("Macklemore");
        ALBUM.setYear("2012");
        ALBUM.setType("LP");
    }

    @Inject
    private ManagedExecutorService managedExecutorService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final var albumList = new ArrayList<Record>();
        final Future<String> task = managedExecutorService.submit(() -> {
            BRIGHT_BLUE.printSyncGenericLn("Hey! This is done!");
            albumList.add(ALBUM);
            return "100%";
        });

        final PrintWriter writer = resp.getWriter();
        writer.println(MAGENTA.getPText("With only a single submit, we have created two tasks"));
        writer.println(MAGENTA.getPText("This is why you now see a list of two Macklemore albums instead of one."));
        try {
            writer.println(MAGENTA.getPText("This is the response %s", task.get()));
        } catch (InterruptedException | ExecutionException e) {
            RED.printThrowableAndExit(e);
        }
        writer.println(ORANGE.getPText(albumList));
        writer.println(MAGENTA.getPText("<p><a href=\"index.xhtml\">Back</a></p>"));
    }
}
