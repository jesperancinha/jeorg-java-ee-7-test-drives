package org.jesperancinha.jtd.jee.mastery1.servlet.ticket;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;

@WebServlet(value = "/ticket/sender",
        asyncSupported = true)
public class TicketSenderNonBlockingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final AsyncContext asyncContext = req.startAsync(req, resp);
        final ServletInputStream inputStream = req.getInputStream();
        req.getInputStream().setReadListener(new TicketReadListener(asyncContext, resp, inputStream));

        final var writer = resp.getWriter();
        writer.println(BLUE.getPBText("Check your logs!, your name will appear there!"));
        writer.println(MAGENTA.getPText("<p><a href=\"../index.xhtml\">Back</a></p>"));
    }
}
