package org.jesperancinha.jtd.jee.mastery1.servlet.marshal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@WebServlet("/unmarshaller")
public class RecordUnmarshallerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            JAXBContext jc = JAXBContext.newInstance(Record.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            unmarshaller.setEventHandler(new RecordValidatorEventHandler());
            final var recordString = "<record>\n" +
                    "<artist>Donna Summer</artist>\n" +
                    "<name>Lady of the Night</name>\n" +
                    "<type>LP</type>\n" +
                    "<year>1974</year>\n" +
                    "</record>";
            InputStream in = new ByteArrayInputStream(recordString.getBytes(StandardCharsets.UTF_8));
            final Record record = (Record) unmarshaller.unmarshal(in);
            BRIGHT_GREEN.printGenericTitleLn(record);
            final PrintWriter writer = resp.getWriter();
            writer.println(BLUE.getPBText("We have unmarshalled this:"));
            writer.println(BLUE.getPBEscapedText(recordString));
            writer.println(BLUE.getPBText("The result is:"));
            writer.println(ORANGE.getPBText(record));

            final var recordStringError = "<record>\n" +
                    "<artist>Donna Summer</artist>\n" +
                    "<name>Lady of the Night</name>\n" +
                    "<type>LP</type>\n" +
                    "<year>1974</year>\n" +
                    "</record";
            try {
                InputStream in2 = new ByteArrayInputStream(recordStringError.getBytes(StandardCharsets.UTF_8));
                unmarshaller.unmarshal(in2);
            } catch (UnmarshalException unmarshalException) {
                RED.printExpectedException("Notice that the validation has been called!", unmarshalException.getMessage());
                writer.println(RED.getPBText("For the wrong record:"));
                writer.println(RED.getPBEscapedText(recordStringError));
                writer.println(RED.getPBText("The result is:"));
                writer.println(RED.getPBText(unmarshalException));
            }

            writer.println(GREEN.getPBText("Marshalling is the act of creating an object representation, other than with Java. In our case, an XML representation"));
            writer.println(GREEN.getPBText("Unmarshalling is the act of creating a Java object representation. In our case, from an XML representation"));

            writer.println(MAGENTA.getPText("<p><a href=\"index.xhtml\">Back</a></p>"));
        } catch (JAXBException e) {
            RED.printThrowableAndExit(e);
        }
    }
}
