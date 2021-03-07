package org.jesperancinha.jtd.jee.spain.secure;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;

@WebServlet("/history/palace/servlet")
public class PalaceWaitingRoomServlet extends HttpServlet {

    @EJB
    private ContextProvider contextProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final var context = contextProvider.getContext();
        BRIGHT_MAGENTA.printGenericLn(context.isCallerInRole("Manager"));
        final PrintWriter writer = resp.getWriter();
        GREEN.printGenericLn("With a correct role installation we can check with isCallerInRole from EJB SessionContext, if the user belongs to a certain role.");
        GREEN.printGenericLn("For semantic purposes a Caller is also the logged in user.");
        GREEN.printGenericLn("A principal can be referred to as the representation of that user.");
        writer.println("Hi there!");
        writer.println("I just checked that user" + context.getCallerPrincipal()
                .getName() + " has profile Manager!");
        writer.println("We can get the principle in various ways:");
        writer.println(String.format("One is via the session context.getCallerPrincipal() -> %s", contextProvider.getContext()
                .getCallerPrincipal()));
        writer.println(String.format("Another is via the servlet request.getUserPrincipal() -> %s", req.getUserPrincipal()));
    }
}
