package org.jesperancinha.jtd.jee.mastery1.messaging;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.getRandomColor;

@WebServlet("/warehouse")
@SessionScoped
public class RecordSenderServlet extends HttpServlet {

    @Inject
    private RecordWarehouse recordWarehouse;

    @Override
    @RolesAllowed({"Manager", "Organizer"})
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final var writer = resp.getWriter();
        recordWarehouse.getRecordList().forEach(record -> writer.println(getRandomColor().getPText(record.toString())));
        writer.println(MAGENTA.getPText("<p><a href=\"index.xhtml\">Back</a></p>"));
    }
}
