package org.jesperancinha.jtd.jee.girl.bands.soap;

import org.jesperancinha.console.consolerizer.console.ConsolerizerGraphs;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.jesperancinha.console.consolerizer.console.Consolerizer.printRainbowTitleLn;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;

@WebService(name = "be-there",
        endpointInterface = "org.jesperancinha.jtd.jee.girl.bands.soap.BeThereLyricsService")
public class BeThereLyricsServiceImpl implements BeThereLyricsService {

    private static String[] EXPECTED_LYRICS = {"Ah, say you'll be there", "I'm giving you everything",
            "All that joy can bring, this I swear", "Last time that we had this conversation",
            "I decided we should be friends, hey", "But now we're going round in circles",
            "Tell me, will this deja vu never end? Oh"};

    @Resource
    private WebServiceContext wsContext;

    @Override
    public String sayYoullBeThere(String line) {

        printRainbowTitleLn("Welcome to the say you'll be there game!");
        printRainbowTitleLn("To see session management running please send lyric line by lyric line");
        printRainbowTitleLn(
                "I'll match it to what is stated in https://genius.com/Spice-girls-say-youll-be-there-lyrics");

        Arrays.stream(EXPECTED_LYRICS)
                .forEach(text -> YELLOW.printGenericLn(text));

        ConsolerizerGraphs.printUnicornsLn(100);
        MAGENTA.printGenericLn(wsContext.getMessageContext());
        MAGENTA.printGenericLn(wsContext.getUserPrincipal());
        ConsolerizerGraphs.printUnicornsLn(100);

        final MessageContext mc = this.wsContext.getMessageContext();
        final var sr = mc.get(MessageContext.SERVLET_REQUEST);
        final var srerp = mc.get(MessageContext.SERVLET_RESPONSE);
        final HttpServletRequest hsr = (HttpServletRequest) sr;
        final HttpServletResponse hrerp = (HttpServletResponse) srerp;

        printRainbowTitleLn("Current cookies are %s", Arrays.stream(hsr.getCookies())
                .map(cookie -> String.format("%s=%s", cookie.getName(), cookie.getValue()))
                .collect(Collectors.joining(",")));

        if (sr != null && sr instanceof HttpServletRequest) {
            hrerp.addCookie(new javax.servlet.http.Cookie("beThereCookie", line));
            final HttpSession session = hsr.getSession(true);
            final List<String> currentLyrics = (List<String>) session.getAttribute("currentLyrics");
            if (Objects.isNull(currentLyrics)) {
                if (EXPECTED_LYRICS[0].equals(line)) {
                    final ArrayList<String> value = new ArrayList<>();
                    value.add(line);
                    session.setAttribute("currentLyrics", value);
                } else {
                    RED.printGenericLn("🔴 This is not correct. Please listen to the song more to get the exact next line");
                    return "WRONG";
                }
            } else if (currentLyrics.size() >= EXPECTED_LYRICS.length) {
                BLUE.printGenericTitleLn("Congratulations!! You've guessed the whole intro the Spice Girl's - Say you'll be there!");
                return "COMPLETED";
            } else {
                if (EXPECTED_LYRICS[currentLyrics.size()].equals(line)) {
                    currentLyrics.add(line);
                    session.setAttribute("currentLyrics", currentLyrics);
                } else {
                    RED.printGenericLn("🔴 This is not correct. Please listen to the song more to get the exact next line");
                    return "WRONG";
                }
            }
            GREEN.printGenericLn("Current status:");
            final List<String> currentLyrics1 = (List<String>) session.getAttribute("currentLyrics");
            GREEN.printGenericLn(currentLyrics1);
            if (currentLyrics1.size() == EXPECTED_LYRICS.length) {
                BLUE.printGenericTitleLn("Congratulations!! You've guessed the whole intro the Spice Girl's - Say you'll be there!");
                return "COMPLETED";
            }
        } else {
            RED.printThrowableAndExit(new RuntimeException(String.format("sr=%s", sr)));
        }
        return "OK";
    }
}
