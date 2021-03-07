package org.jesperancinha.jtd.jee.girl.bands.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;

public class SpiceGirlsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer = resp.getWriter();

        GREEN.printGenericLn("This is the servlet that I expect you to hit in your browser");
        GREEN.printGenericLn("Analysing the XML config:");
        BLUE.printGenericLn("<web-app xmlns=\"http://xmlns.jcp.org/xml/ns/javaee\"\n"
                + "         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"
                + "         xsi:schemaLocation=\"http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd\"\n"
                + "         version=\"4.0\">\n" + "    <display-name>Girl Bands Web Service Fast Track</display-name>\n"
                + "\n" + "    <servlet>\n" + "        <servlet-name>Faces Servlet</servlet-name>\n"
                + "        <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>\n"
                + "        <load-on-startup>1</load-on-startup>\n" + "    </servlet>\n" + "    <servlet-mapping>\n"
                + "        <servlet-name>Faces Servlet</servlet-name>\n" + "        <url-pattern>*.xhtml</url-pattern>\n"
                + "    </servlet-mapping>\n" + "\n" + "    <servlet>\n"
                + "        <servlet-name>GirlsAloudSerlet</servlet-name>\n"
                + "        <servlet-class>org.jesperancinha.jtd.jee.girl.bands.servlets.GirlsAloudServlet</servlet-class>\n"
                + "    </servlet>\n" + "\n" + "    <servlet>\n" + "        <servlet-name>MissTeeqServlet</servlet-name>\n"
                + "        <servlet-class>org.jesperancinha.jtd.jee.girl.bands.servlets.MissTeeqServlet</servlet-class>\n"
                + "    </servlet>\n" + "\n" + "    <servlet>\n" + "        <servlet-name>SpiceGirlsServlet</servlet-name>\n"
                + "        <servlet-class>org.jesperancinha.jtd.jee.girl.bands.servlets.SpiceGirlsServlet</servlet-class>\n"
                + "    </servlet>\n" + "\n" + "    <servlet>\n" + "        <servlet-name>SugababesServlet</servlet-name>\n"
                + "        <servlet-class>org.jesperancinha.jtd.jee.girl.bands.servlets.SugababesServlet</servlet-class>\n"
                + "    </servlet>\n" + "\n" + "    <servlet-mapping>\n"
                + "        <servlet-name>GirlsAloudSerlet</servlet-name>\n" + "        <url-pattern>/</url-pattern>\n"
                + "    </servlet-mapping>\n" + "    <servlet-mapping>\n"
                + "        <servlet-name>MissTeeqServlet</servlet-name>\n" + "        <url-pattern>/</url-pattern>\n"
                + "    </servlet-mapping>\n" + "    <servlet-mapping>\n"
                + "        <servlet-name>SpiceGirlsServlet</servlet-name>\n" + "        <url-pattern>/*</url-pattern>\n"
                + "    </servlet-mapping>\n" + "    <servlet-mapping>\n"
                + "        <servlet-name>SugababesServlet</servlet-name>\n" + "        <url-pattern>/*</url-pattern>\n"
                + "    </servlet-mapping>\n" + "\n" + "    <welcome-file-list>\n"
                + "        <welcome-file>index.html</welcome-file>\n" + "        <welcome-file>index.jsp</welcome-file>\n"
                + "        <welcome-file>index.jsf</welcome-file>\n" + "        <welcome-file>index.xhtml</welcome-file>\n"
                + "    </welcome-file-list>\n" + "</web-app>");
        GREEN.printGenericLn("What this means is that /* overrides them all. / overrides some, but overriding a pattern only happens when the overriding is broader than the previous.");
        GREEN.printGenericLn("If the range is the same, then the first servlet seems to be called.");
        GREEN.printGenericLn("Depending on the implementation, the order may differ, an error may be thrown or the result may be random.");
        writer.println("It's the Spice Girls!");
    }
}
