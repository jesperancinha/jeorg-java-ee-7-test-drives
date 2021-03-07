package org.jesperancinha.jtd.jee.mastery1.servlet.ticket;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

public class TicketReadListener implements ReadListener {
    private final AsyncContext asyncContext;
    private final HttpServletResponse resp;
    private final ServletInputStream inputStream;

    public TicketReadListener(AsyncContext asyncContext,
                              HttpServletResponse resp,
                              ServletInputStream inputStream) {
        this.asyncContext = asyncContext;
        this.resp = resp;
        this.inputStream = inputStream;
    }

    @Override
    public void onDataAvailable() throws IOException {
        GREEN.printSyncGenericTitleLn("From onDataAvailable ReadListener");

        int len = -1;
        byte[] b = new byte[1024];

        while (inputStream.isReady() && (len = inputStream.read(b)) != -1) {
            String data = new String(b, 0, len);
            RED.printGenericLn((data));
        }
    }

    @Override
    public void onAllDataRead() throws IOException {
        GREEN.printSyncGenericTitleLn("From onAllDataRead ReadListener");
        BRIGHT_BLUE.printSyncGenericLn("All done!");
        asyncContext.complete();
    }

    @Override
    public void onError(Throwable t) {
        GREEN.printSyncGenericTitleLn("From onError ReadListener");
        RED.printGenericLn(t);

    }
}
