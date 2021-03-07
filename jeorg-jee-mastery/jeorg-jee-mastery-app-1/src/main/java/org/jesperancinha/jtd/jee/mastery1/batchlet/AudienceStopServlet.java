package org.jesperancinha.jtd.jee.mastery1.batchlet;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;

@WebServlet("/audience/stop")
public class AudienceStopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Properties props = new Properties();
        final JobOperator jobOperator = BatchRuntime.getJobOperator();
        final List<Long> sendPeopleToShow = jobOperator.getRunningExecutions("SendPeopleToShow");

        final PrintWriter writer = resp.getWriter();
        writer.println(MAGENTA.getPBText("All jobs stopped!"));
        sendPeopleToShow.forEach(i -> {
            jobOperator.stop(i);
            writer.println(MAGENTA.getPText("Job stopped -> %s", i));

        });
        writer.println(MAGENTA.getPBText("Check your logs!"));
        writer.println(MAGENTA.getPText("<p><a href=\"../index.xhtml\">Back</a></p>"));
    }
}
