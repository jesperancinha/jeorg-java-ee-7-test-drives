package org.jesperancinha.jtd.jee.mastery1.exception;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_GREEN;

@WebServlet("wrongpopsubmit")
public class SubmitWrongPopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BRIGHT_GREEN.printGenericLn("Classify music... the wrong way 😊. This page handles errors");
        BRIGHT_GREEN.printGenericLn("Scissor Sisters - Let's have a Kiki is Pop Music");
        BRIGHT_GREEN.printGenericLn("Debatable, but we'll say no 😊.. for now...");
        throw new NotPopMusicException("It's not pop music!");

    }
}
