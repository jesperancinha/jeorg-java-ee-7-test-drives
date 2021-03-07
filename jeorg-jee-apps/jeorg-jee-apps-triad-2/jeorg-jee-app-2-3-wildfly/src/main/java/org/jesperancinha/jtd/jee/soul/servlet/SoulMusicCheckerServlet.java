package org.jesperancinha.jtd.jee.soul.servlet;

import org.jesperancinha.jtd.jee.soul.exceptions.NotSoulMusicException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/soulchecker")
public class SoulMusicCheckerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String song = req.getParameter("song");
        if ("In My Darkest Hour".equalsIgnoreCase(song)) {
            throw new NotSoulMusicException();
        }
        final PrintWriter writer = resp.getWriter();
        writer.println(String.format("Song %s is soul!", song));
    }
}
