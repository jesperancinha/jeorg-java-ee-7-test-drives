package org.jesperancinha.jtd.jee.teeth.timer;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/timer/servlet/stateless")
public class StatelessTimerServlet extends HttpServlet {

    @Inject
    private StatelessTimerSessionBean statelessTimerSessionBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer = resp.getWriter();
        statelessTimerSessionBean.createTimer(1000);
        writer.println(statelessTimerSessionBean.hashCode());
    }
}
