package org.jesperancinha.jtd.jee.lyrics.service;

import java.io.BufferedInputStream;
import java.io.IOException;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@jakarta.enterprise.inject.Default
public class LyricsSimpleService implements LyricsService {

    private final static String[] FILES = {"all.rise.txt", "boys.in.the.band.txt", "could.it.be.magic.txt",
            "the.one.txt"};

    public String getRandomLyric() {
        BRIGHT_MAGENTA.printGenericLn("This is type %s", this.getClass());
        var i = (int) (Math.random() * FILES.length);

        final var resourceAsStream = getClass().getResourceAsStream("/" + FILES[i]);

        try (final var bis = new BufferedInputStream(resourceAsStream)) {
            return new String(bis.readAllBytes());
        } catch (IOException e) {
            RED.printThrowableAndExit(e);
        }

        return null;
    }
}
