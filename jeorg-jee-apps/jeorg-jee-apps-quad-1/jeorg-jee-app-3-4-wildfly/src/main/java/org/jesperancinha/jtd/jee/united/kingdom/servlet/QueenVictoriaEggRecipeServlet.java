package org.jesperancinha.jtd.jee.united.kingdom.servlet;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
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
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;
import static org.jesperancinha.console.consolerizer.console.ConsolerizerGraphs.printRainbowFlag;

@WebServlet("/history/victoria/cooking")
public class QueenVictoriaEggRecipeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printRainbowFlag("Starting Queen Victoria's egg recipe!");
        final long processId = startNewBatchJob();

        final PrintWriter writer = resp.getWriter();
        writer.println("<html><head></head><body>");

        final JobOperator jobOperator = BatchRuntime.getJobOperator();
        final List<Long> boilEggsJobs = jobOperator.getRunningExecutions("BoilEggsJob");
        boilEggsJobs.forEach(jobId -> {
            final JobExecution jobExecution = jobOperator.getJobExecution(jobId);
            writer.println(String.format("<p>Started BoilEggsJob %s</p>", jobId));
            writer.println(String.format("<p>Job execution is %s</p>", jobExecution));
            writer.println(String.format("<p>Job status is %s</p>", jobExecution.getBatchStatus()));
            YELLOW.printGenericLn("Job execution is %s", jobExecution);
            YELLOW.printGenericLn("Job status is %s", jobExecution.getBatchStatus());
        });

        writer.println("<p><a href=\"../../index.xhtml\">Back</a></p>");
        writer.println("</body></html>");

        MAGENTA.printGenericLn("Running job with id %s", processId);
    }

    private long startNewBatchJob() {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        Properties props = new Properties();
        return jobOperator.start("BoilEggsJob", props);
    }
}
