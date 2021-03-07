package org.jesperancinha.jtd.jee.teeth.servlets;

import org.jesperancinha.jtd.jee.teeth.domain.Jaw;
import org.jesperancinha.jtd.jee.teeth.domain.Tooth;
import org.jesperancinha.jtd.jee.teeth.service.JawService;
import org.jesperancinha.jtd.jee.teeth.service.ToothService;

import javax.inject.Inject;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@WebServlet("/tooth/servlet/all")
public class ToothServlet extends HttpServlet {

    @Inject
    private ToothService toothService;

    @Inject
    private JawService jawService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<Tooth> all = toothService.findAll();
        final PrintWriter writer = resp.getWriter();

        final var tooth = new Tooth();
        final var uuid = UUID.randomUUID();
        tooth.setUuid(uuid);

        final var jaw = new Jaw();
        jaw.setUuid(UUID.randomUUID());
        final Jaw jaw1 = jawService.updateItRight(jaw);

        tooth.setJaw(jaw);

        var tooth1 = (Tooth) null;
        try {
            tooth1 = toothService.updateItRight(tooth);
        } catch (NamingException e) {
            RED.printThrowableAndExit(e);
        } catch (HeuristicMixedException e) {
            RED.printThrowableAndExit(e);
        } catch (HeuristicRollbackException e) {
            RED.printThrowableAndExit(e);
        } catch (NotSupportedException e) {
            RED.printThrowableAndExit(e);
        } catch (SystemException e) {
            RED.printThrowableAndExit(e);
        } catch (RollbackException e) {
            RED.printThrowableAndExit(e);
        }
        ORANGE.printGenericLn(tooth1);
        ORANGE.printGenericLn(jaw1);

        all.forEach(toothAll -> writer.println(String.format("<p>%s</p>", toothAll.getUuid())));
    }
}
