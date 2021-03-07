package org.jesperancinha.jtd.jee.girl.bands.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.console.Consolerizer.printRandomColorGenericLn;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.console.ConsolerizerGraphs.getUnicorns;

@WebServlet("/CaghtUpInTheMiddle")
public class SugababesServlet extends HttpServlet {
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
        printRandomColorGenericLn("Note the order of the nodes matter in web.xml");
        printRandomColorGenericLn("A Random order is wrong, even if the nodes are correct");
        printRandomColorGenericLn("Best way to get a feel is to think of the order like this:");
        printRandomColorGenericLn("description->display name->actual name->class or url->extra params");
        printRandomColorGenericLn("A wrong order can be easy to miss, but its part of the knowledge base anyway.");
    }

}