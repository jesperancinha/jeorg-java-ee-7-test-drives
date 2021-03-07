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

public class CaghtUpInTheMiddle2 implements Filter {

    private FilterConfig filterConfig;

    private static final String FROM = "https://genius.com/Sugababes-in-the-middle-lyrics";

    private static final String LYRIC =
            "Night's kind of funny\n" + "Not in it for the money\n" + "But I know that I've got to pay\n"
                    + "Love's gonna get ya\n" + "But only when I let ya\n" + "And I don't wanna turn away";

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

        final String yetAnotherSong = this.filterConfig.getInitParameter("yetAnotherSong");
        printRandomColorGenericLn("Sugababes did yet another song called %s", yetAnotherSong);

        GREEN.printGenericLn("We can use a filter as a servlet and we can also specify the order. This is the second.");
        GREEN.printGenericLn("Notice that the filters respect the order of the filter-mapping declaration.");
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {
        BRIGHT_MAGENTA.printGenericLn("This is our filter config at the end -> %s", this.filterConfig);
    }
}
