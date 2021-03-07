package org.jesperancinha.jtd.jee.teeth.timer;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/timer/servlet/singleton")
public class SingletonTimerServlet extends HttpServlet {

    @Inject
    private SingletonTimerSessionBean singletonTimerSessionBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer = resp.getWriter();
        singletonTimerSessionBean.createTimer(1000);
        writer.println(singletonTimerSessionBean.hashCode());
    }
}
