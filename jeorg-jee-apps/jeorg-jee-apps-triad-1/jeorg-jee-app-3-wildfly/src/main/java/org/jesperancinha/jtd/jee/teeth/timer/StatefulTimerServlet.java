package org.jesperancinha.jtd.jee.teeth.timer;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

/**
 * This is not possible to do
 * A stateful bean cannot be used to create a timer service
 * The context does not allow it.
 */
@WebServlet("/timer/servlet/stateful")
public class StatefulTimerServlet extends HttpServlet {

    @Inject
    private StatefulTimerSessionBean statefulTimerSessionBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer = resp.getWriter();
        RED.printGenericLn("This is not possible. Check your browser. A Timer service cannot be generated from a @Stateful bean");
        statefulTimerSessionBean.createTimer(1000);
        writer.println(statefulTimerSessionBean.hashCode());
    }
}
