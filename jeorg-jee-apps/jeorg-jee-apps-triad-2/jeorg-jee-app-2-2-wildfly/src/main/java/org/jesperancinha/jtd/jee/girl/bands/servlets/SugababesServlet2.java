package org.jesperancinha.jtd.jee.girl.bands.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.console.ConsolerizerGraphs.getUnicorns;

public class SugababesServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final String FILTERS_CANNOT_BE_USED_AS_SERVLETS_BUT_THEY_CAN_WORK_TOGETHER_WITH_SERVETS_AND_REST_ENDPOINTS = "Filters cannot be used as servlets, but they can work together with servets and rest endpoints";
    public static final String NOTE_THAT_BOTH_FILTERS_WERE_ABLE_TO_WRITE_OUTPUT = "Note that both filters were able to write output";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        final PrintWriter writer = response.getWriter();
        writer.println(getUnicorns(100));
        writer.println(NOTE_THAT_BOTH_FILTERS_WERE_ABLE_TO_WRITE_OUTPUT);
        writer.println(FILTERS_CANNOT_BE_USED_AS_SERVLETS_BUT_THEY_CAN_WORK_TOGETHER_WITH_SERVETS_AND_REST_ENDPOINTS);

        GREEN.printGenericLn(NOTE_THAT_BOTH_FILTERS_WERE_ABLE_TO_WRITE_OUTPUT);
        GREEN.printGenericLn(FILTERS_CANNOT_BE_USED_AS_SERVLETS_BUT_THEY_CAN_WORK_TOGETHER_WITH_SERVETS_AND_REST_ENDPOINTS);
        GREEN.printGenericLn("In this second installment of the same thing we are examining the use of filter-mapping directly to servlets instead of via path:");
        BLUE.printGenericLn("<filter-mapping>\n" + "        <filter-name>CaghtUpInTheMiddle22</filter-name>\n"
                + "        <servlet-name>SugababesServlet2</servlet-name>\n" + "</filter-mapping>");
        GREEN.printGenericLn("We reference the filters to be used in a certain servlet and also the url-mapping for the servlet itself");
    }

}