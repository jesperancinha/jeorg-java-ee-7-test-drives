package org.jesperancinha.jtd.jee.app2.servlets;

import org.jesperancinha.console.consolerizer8.Consolerizer;
import org.jesperancinha.console.consolerizer8.ConsolerizerColor;
import org.jesperancinha.jtd.jee.app2.domain.Herb;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.jesperancinha.console.consolerizer8.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer8.ConsolerizerColor.RED;

@WebServlet("/herbs/prices")
public class HerbPricesServlet extends HttpServlet {

    private final Stack<Herb> herbs = new Stack<>();

    {
        final Herb herb = new Herb();
        herb.setName("Chives");
        herb.setColor("Green");
        herb.setGrams(1000L);
        final Herb herb2 = new Herb();
        herb2.setName("Garlic");
        herb2.setColor("White");
        herb2.setGrams(500L);
        final Herb herb3 = new Herb();
        herb3.setName("Onion");
        herb3.setColor("Copper Brown");
        herb3.setGrams(250L);
        herbs.push(herb);
        herbs.push(herb2);
        herbs.push(herb3);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Consolerizer.setupFastDefault();
        BLUE.printGenericTitleLn("Checking ServletContext");
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        ServletContext context = getServletContext();

        HttpSession session2 = req.getSession(false);
        if (session2 != null) {
            List<Herb> test = (List<Herb>) session2.getAttribute("herbs");
            RED.printGenericLn(test);
        }

        pw.println("<h1><p>Let's see the prices!</p></h1>");
        List<Herb> herbsList = (List<Herb>) context.getAttribute("herbs");
        HttpSession session;
        if (session2 == null)
            session = req.getSession();
        else
            session = session2;

        List<Herb> herbsListSession = (List<Herb>) session.getAttribute("herbs");

        if (herbs.isEmpty()) {
            pw.println("Your herbs list is now empty, please restart the application if you want to repeat this test.");
        } else {
            final Herb pop = herbs.pop();
            if (herbsList == null) {
                herbsList = new ArrayList<>();
            }
            if (herbsListSession == null) {
                herbsListSession = new ArrayList<>();
            }
            herbsList.add(pop);
            herbsListSession.add(pop);
            context.setAttribute("herbs", herbsList);
            session.setAttribute("herbs", herbsListSession);
            pw.println(String.format("<p>You just bought \"%s\" for %d euros.</p>", pop, (int) (Math.random() * 100)));

        }
        herbsList.forEach(ConsolerizerColor.ORANGE::printGenericLn);
        if (herbsListSession != null) {
            herbsListSession.forEach(ConsolerizerColor.BRIGHT_CYAN::printGenericLn);
        }

        pw.print("<a href='prices2'>try again!</a>");

        pw.close();
    }
}
