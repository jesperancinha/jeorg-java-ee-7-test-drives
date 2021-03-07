package org.jesperancinha.jtd.jee.girl.bands.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.jesperancinha.console.consolerizer.console.Consolerizer.printRainbowTitleLn;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_CYAN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;

@WebServlet("/LogoutGirlBandRecordStoreServlet")
public class LogoutGirlBandRecordStoreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        final var cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                if (cookie.getName()
                        .equals("JSESSIONID")) {
                    printRainbowTitleLn("JSESSIONID=" + cookie.getValue());
                } else {
                    BRIGHT_CYAN.printGenericLn("Found cookie %s!. Invalidating...", cookie);
                    BRIGHT_CYAN.printGenericLn("%s=%s", cookie.getName(), cookie.getValue());
                }
            }
        }
        HttpSession httpSesssion = request.getSession(false);
        MAGENTA.printGenericLn("Username is=%s", httpSesssion.getAttribute("username"));
        if (httpSesssion != null) {
            httpSesssion.invalidate();
        }
        BLUE.printGenericLn("Session %s is now invalidated", httpSesssion);
        response.sendRedirect("/jee-app-2-2-wildfly-1.0.0-SNAPSHOT");
    }

}