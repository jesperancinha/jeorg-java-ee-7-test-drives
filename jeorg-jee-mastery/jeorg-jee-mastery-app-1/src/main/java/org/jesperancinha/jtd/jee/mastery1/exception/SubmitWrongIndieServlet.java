package org.jesperancinha.jtd.jee.mastery1.exception;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_GREEN;

@WebServlet("wrongindiesubmit")
public class SubmitWrongIndieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BRIGHT_GREEN.printGenericLn("Classify music... the wrong way 😊. This page handles errors");
        BRIGHT_GREEN.printGenericLn("Kylie Minogue - All The Lovers is Indie Music");
        BRIGHT_GREEN.printGenericLn("We can safely say no in this case 😊..");
        throw new NotIndieMusicException("Not indie music");

    }
}
