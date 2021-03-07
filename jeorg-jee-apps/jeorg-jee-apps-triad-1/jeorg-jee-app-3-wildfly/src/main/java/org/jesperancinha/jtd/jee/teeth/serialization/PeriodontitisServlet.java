package org.jesperancinha.jtd.jee.teeth.serialization;

import org.apache.commons.text.StringEscapeUtils;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;

@WebServlet("/periodontitis")
public class PeriodontitisServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String PERIODONTITIS_BEAN = "periodontitisBean";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var periodontitisPassivation = (PeriodontitisPassivation) null;

        BRIGHT_MAGENTA.printGenericLn("Hello from Periodontitis");
        String beanCountparam = request.getParameter("count");
        if (beanCountparam != null) {
            int beanCount = Integer.parseInt(beanCountparam);
            try {
                for (int i = 0; i < beanCount; i++) {
                    var ic = new InitialContext();
                    periodontitisPassivation = (PeriodontitisPassivation) ic.lookup("java:module/PeriodontitisBean!"
                            + "org.jesperancinha.jtd.jee.teeth.serialization.PeriodontitisPassivation");
                    ORANGE.printGenericLn("The passivation object is -> %s -> %s", periodontitisPassivation, periodontitisPassivation.hashCode());
                    periodontitisPassivation.setPropertyObject(
                            new PeriodontitisObject(String.format("Mr Patient has %d teeth with periodontitis!!", i)));
                    request.getSession()
                            .setAttribute(PERIODONTITIS_BEAN + i, periodontitisPassivation);
                }
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }
        String beanActivationIndex = request.getParameter("activate");
        if (beanActivationIndex != null) {
            try {
                final var periodontitisPassivation1 = (PeriodontitisPassivation) request.getSession()
                        .getAttribute(PERIODONTITIS_BEAN + beanActivationIndex);
                request.getSession()
                        .removeAttribute(PERIODONTITIS_BEAN + beanActivationIndex);
                GREEN.printGenericLn("TestObject property value: " + periodontitisPassivation1.getPropertyObject()
                        .getProperty());
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<title>Servlet HelloServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(
                "<p>from: <a href=\"https://en.wikipedia.org/wiki/Periodontal_disease\">https://en.wikipedia.org/wiki/Periodontal_disease</a>");
        out.println(
                "Periodontal disease, also known as gum disease, is a set of inflammatory conditions affecting the tissues surrounding the teeth.[3] In its early stage, called gingivitis, the gums become swollen, red, and may bleed.[3] In its more serious form, called periodontitis, the gums can pull away from the tooth, bone can be lost, and the teeth may loosen or fall out.[3] Bad breath may also occur.[1]\n"
                        + "\n"
                        + "Periodontal disease is generally due to bacteria in the mouth infecting the tissue around the teeth.[3] Factors that increase the risk of disease include smoking, diabetes, HIV/AIDS, family history, and certain medications.[1] Diagnosis is by inspecting the gum tissue around the teeth both visually and with a probe and X-rays looking for bone loss around the teeth.[1][5]\n"
                        + "\n"
                        + "Treatment involves good oral hygiene and regular professional teeth cleaning.[3] Recommended oral hygiene include daily brushing and flossing.[3] In certain cases antibiotics or dental surgery may be recommended.[6] Globally 538 million people were estimated to be affected in 2015.[4] In the United States nearly half of those over the age of 30 are affected to some degree, and about 70% of those over 65 have the condition.[3] Males are affected more often than females.[3]</p>");
        out.println("");
        out.println(
                "<b>To run this exercise please run http://127.0.0.1:8080/jee-app-3-wildfly/periodontitis?count=700&activate=1</b>");
        out.println("<p><b>You are supposed to see about 200 passivations and 1 activation in the server logs</b></p>");
        out.println("<p>if you look at your standalone-full.xml file you'll see that 500 is the limit:<p>");
        out.println(StringEscapeUtils.escapeHtml4("            <passivation-stores>"
                + "                <file-passivation-store name=\"file\" idle-timeout=\"30\" idle-timeout-unit=\"SECONDS\"/>\n"
                + "                <file-passivation-store name=\"custom-store\" idle-timeout=\"30\" idle-timeout-unit=\"SECONDS\" max-size=\"500\"/>\n"
                + "                <cluster-passivation-store name=\"infinispan\" idle-timeout=\"30\" idle-timeout-unit=\"SECONDS\" cache-container=\"ejb\"/>\n"
                + "            </passivation-stores>"));
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
