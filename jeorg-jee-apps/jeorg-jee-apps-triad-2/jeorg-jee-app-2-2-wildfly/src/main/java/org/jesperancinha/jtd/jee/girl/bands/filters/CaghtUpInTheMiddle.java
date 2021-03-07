package org.jesperancinha.jtd.jee.girl.bands.filters;

import org.jesperancinha.console.consolerizer.console.ConsolerizerGraphs;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.console.Consolerizer.printRandomColorGenericLn;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;

public class CaghtUpInTheMiddle implements Filter {

    private FilterConfig filterConfig;

    private static final String FROM = "https://genius.com/Sugababes-in-the-middle-lyrics";

    private static final String LYRIC =
            "I'm caught up in the middle\n" + "Jumping through the riddle\n" + "I'm falling just a little tonight (uh uh)\n"
                    + "Cos everybody's making trouble\n" + "Someone's burst their bubble\n"
                    + "But we'll be getting by alright (uh uh uh)";

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        BRIGHT_MAGENTA.printGenericLn("This is our filter config on init -> %s", this.filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        final PrintWriter writer = response.getWriter();
        writer.println(ConsolerizerGraphs.getUnicorns(100));
        writer.println(FROM);
        writer.println(LYRIC);

        printRandomColorGenericLn(FROM);
        printRandomColorGenericLn(LYRIC);

        final String otherSong = this.filterConfig.getInitParameter("otherSong");
        printRandomColorGenericLn("Sugababes did another song called %s", otherSong);

        GREEN.printGenericLn("We can use a filter as a servlet and we can also specify the order. This is the first");
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {
        BRIGHT_MAGENTA.printGenericLn("This is our filter config at the end -> %s", this.filterConfig);
    }
}
