package org.jesperancinha.jtd.jee.mastery2.schedule;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@WebServlet("/ariaschorus/minute")
public class TimerIn1MinuteServlet extends HttpServlet {

    @Inject
    private TimerManager timerManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Date date = new Date();
        date.setMinutes(date.getMinutes() + 1);
        timerManager.setAlarm(date);

        final PrintWriter writer = resp.getWriter();
        writer.println(RED.getPBText("Please wait one minute and check your logs!"));
        writer.println(MAGENTA.getPText("<p><a href=\"../index.xhtml\">Back</a></p>"));
    }
}
