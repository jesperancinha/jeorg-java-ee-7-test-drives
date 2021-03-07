package org.jesperancinha.jtd.jee.mastery1.servlet.cookie;

import org.jesperancinha.console.consolerizer.console.Consolerizer;

import javax.enterprise.context.SessionScoped;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;

@WebServlet("/cookies")
@SessionScoped
public class MusicServletCookiesServlet extends HttpServlet {

    private static final List<String> MUSIC_LIST = Arrays.asList("Same Love", "You think you're a man", "Easy like Sunday Morning", "I Kissed a  Girl");

    private static final List<String> ALBUM_LIST = Arrays.asList("Aphrodite", "The story so far", "Collateral", "One of the Boys", "Easy Like Sunday Morning");

    private static final List<String> ARTIST_LIST = Arrays.asList("Divina", "Kylie Minogue", "N.E.R.V.O.", "Katy Perry", "Faith no More");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Optional<Cookie> music = Arrays.stream(req.getCookies()).filter(cookie -> cookie.getName().equals("music")).findAny();
        final Optional<Cookie> album = Arrays.stream(req.getCookies()).filter(cookie -> cookie.getName().equals("album")).findAny();
        final Optional<Cookie> artist = Arrays.stream(req.getCookies()).filter(cookie -> cookie.getName().equals("artist")).findAny();
        final Optional<Cookie> whatever = Arrays.stream(req.getCookies()).filter(cookie -> cookie.getName().equals("whatever")).findAny();

        final PrintWriter writer = resp.getWriter();
        if (whatever.isEmpty()) {
            Consolerizer.printRainbowTitleLn("Whatever will always be empty since its Max Age is always set to 0");
        }
        if (music.isEmpty()) {
            final var music1 = new Cookie("music", MUSIC_LIST.get((int) (MUSIC_LIST.size() * Math.random())));
            music1.setMaxAge(-1);
            resp.addCookie(music1);
            writer.println(BLUE.getPText("New Value until you close the browser"));
            writer.println(ORANGE.getPText(music1.getValue()));
        } else {
            writer.println(ORANGE.getPText(music.get().getValue()));
        }

        if (album.isEmpty()) {
            final var album1 = new Cookie("album", ALBUM_LIST.get((int) (ALBUM_LIST.size() * Math.random())));
            album1.setMaxAge(5);
            resp.addCookie(album1);
            writer.println(BLUE.getPText("New Value for 5 seconds"));
            writer.println(ORANGE.getPText(album1.getValue()));
        } else {
            writer.println(ORANGE.getPText(album.get().getValue()));
        }

        if (artist.isEmpty()) {
            final var artist1 = new Cookie("artist", ARTIST_LIST.get((int) (ARTIST_LIST.size() * Math.random())));
            artist1.setMaxAge(10);
            resp.addCookie(artist1);
            writer.println(BLUE.getPText("New Value for 10 seconds"));
            writer.println(ORANGE.getPText(artist1.getValue()));
        } else {
            writer.println(ORANGE.getPText(artist.get().getValue()));
        }

        if (whatever.isEmpty()) {
            final var whatever1 = new Cookie("whatever", "Yeah, whatever...");
            whatever1.setMaxAge(0);
            resp.addCookie(whatever1);
            writer.println(BLUE.getPText("New Value. It's always new and gets eliminated immediately"));
            writer.println(ORANGE.getPText(whatever1.getValue()));
        } else {
            writer.println(ORANGE.getPText(whatever.get().getValue()));
        }

        writer.println(GREEN.getPBText("Refresh page to understand and investigate the cookie mechanism. Keep doing it"));
        writer.println(MAGENTA.getPText("<p><a href=\"index.xhtml\">Back</a></p>"));

    }
}
