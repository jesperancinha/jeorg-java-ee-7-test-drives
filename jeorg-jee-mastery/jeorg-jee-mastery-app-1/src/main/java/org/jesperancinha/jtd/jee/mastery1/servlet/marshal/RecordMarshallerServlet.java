package org.jesperancinha.jtd.jee.mastery1.servlet.marshal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@WebServlet("/marshaller")
public class RecordMarshallerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(Record.class);
            Marshaller m = jc.createMarshaller();
            Record record = new Record();
            record.setName("Lady of the Night");
            record.setArtist("Donna Summer");
            record.setYear("1974");
            record.setType("LP");
            m.marshal(record, System.out);
            final PrintWriter writer = resp.getWriter();
            m.marshal(record, writer);
        } catch (JAXBException e) {
            RED.printThrowableAndExit(e);
        }
    }
}
