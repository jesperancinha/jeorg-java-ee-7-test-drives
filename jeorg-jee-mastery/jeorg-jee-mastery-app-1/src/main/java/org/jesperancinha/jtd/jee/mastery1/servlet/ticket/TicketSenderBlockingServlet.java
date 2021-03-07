package org.jesperancinha.jtd.jee.mastery1.servlet.ticket;

import org.jesperancinha.jtd.jee.mastery1.executors.MainCustomManagedExecutorService;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;

@WebServlet(value = "/ticket/sender/blocking1",
        asyncSupported = true)
public class TicketSenderBlockingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.startAsync();
        final AsyncContext asyncContext = req.getAsyncContext();
        asyncContext.start(() -> {
            GREEN.printSyncGenericTitleLn("From AsyncContext");
            ORANGE.printSyncGenericLn(req.getParameter("name"));
            asyncContext.complete();
        });

        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent event) throws IOException {
                GREEN.printSyncGenericTitleLn("From onComplete Listener");
                ORANGE.printSyncGenericLn(event.getAsyncContext().getRequest().getParameter("name"));

            }

            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                GREEN.printSyncGenericTitleLn("From onTimeout Listener");
                ORANGE.printSyncGenericLn(event.getAsyncContext().getRequest().getParameter("name"));
            }

            @Override
            public void onError(AsyncEvent event) throws IOException {
                GREEN.printSyncGenericTitleLn("From onError Listener");
                ORANGE.printSyncGenericLn(event.getAsyncContext().getRequest().getParameter("name"));
            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {
                GREEN.printSyncGenericTitleLn("From onStartAsync Listener");
                ORANGE.printSyncGenericLn(event.getAsyncContext().getRequest().getParameter("name"));
            }
        });
        asyncContext.complete();
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        final Future<String> text = executorService.submit(() -> {
            GREEN.printSyncGenericTitleLn("From Callable");
            final String name = req.getParameter("name");
            ORANGE.printSyncGenericLn(name);
            return name;
        });
        try {
            final String o = text.get();
            executorService.shutdown();
            RED.printSyncGenericLn("Got %s on normal Executor!!", o);
            executorService.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException e) {
            RED.printThrowableAndExit(e);
        }
        MainCustomManagedExecutorService managedExecutorService = new MainCustomManagedExecutorService(1);
        YELLOW.printGenericLn("Remember that we send our task two times with our custom ManagedExecutorService");

        final TicketListenerTask task = new TicketListenerTask(req);
        final Future<String> text2 = managedExecutorService.submit(task);
        try {
            final String o = text2.get();
            RED.printSyncGenericLn("Got %s on managed Executor!!", o);
            managedExecutorService.shutdown();
            managedExecutorService.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException e) {
            RED.printThrowableAndExit(e);
        }

        final PrintWriter writer = resp.getWriter();
        writer.println(BLUE.getPBText("Check your logs!, your name will appear there!"));
        writer.println(MAGENTA.getPText("<p><a href=\"../../index.xhtml\">Back</a></p>"));
    }
}
