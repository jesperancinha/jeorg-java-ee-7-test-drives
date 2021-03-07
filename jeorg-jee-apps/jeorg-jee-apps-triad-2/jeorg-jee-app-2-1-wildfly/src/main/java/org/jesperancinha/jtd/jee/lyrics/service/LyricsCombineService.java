package org.jesperancinha.jtd.jee.lyrics.service;

import javax.enterprise.inject.Alternative;
import java.io.BufferedInputStream;
import java.io.IOException;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@jakarta.enterprise.inject.Alternative
@Alternative
public class LyricsCombineService implements LyricsService {

    private final static String[] FILES = {"all.rise.txt", "boys.in.the.band.txt", "could.it.be.magic.txt",
            "the.one.txt"};

    public String getRandomLyric() {
        BRIGHT_MAGENTA.printGenericLn("This is type %s", this.getClass());
        var i = (int) (Math.random() * FILES.length);
        var j = (int) (Math.random() * FILES.length);

        final var resourceAsStream = getClass().getResourceAsStream("/" + FILES[i]);
        final var resourceAsStream2 = getClass().getResourceAsStream("/" + FILES[j]);

        try (final var bis = new BufferedInputStream(resourceAsStream);
             final var bis2 = new BufferedInputStream(resourceAsStream2)) {
            return new String(bis.readAllBytes()) + "\n" + new String(bis2.readAllBytes());
        } catch (IOException e) {
            RED.printThrowableAndExit(e);
        }

        return null;
    }
}
