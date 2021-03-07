package org.jesperancinha.jtd.jee.mastery1.servlet.ticket;

import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedTask;
import javax.enterprise.concurrent.ManagedTaskListener;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BROWN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;

public class TicketListenerTask implements ManagedTask, Callable<String> {
    private final HttpServletRequest req;

    public TicketListenerTask(HttpServletRequest req) {
        this.req = req;
    }

    @Override
    public String call() {
        GREEN.printSyncGenericTitleLn("TicketListenerTask call");
        final String name = req.getParameter("name");
        ORANGE.printSyncGenericLn(name);
        return name;
    }

    @Override
    public ManagedTaskListener getManagedTaskListener() {
        BROWN.printSyncGenericTitleLn("getManagedTaskListener");
        return new ManagedTaskListener() {

            @Override
            public void taskSubmitted(Future<?> future, ManagedExecutorService executor, Object task) {
                BROWN.printSyncGenericTitleLn("taskSubmitted");
            }

            @Override
            public void taskAborted(Future<?> future, ManagedExecutorService executor, Object task, Throwable exception) {
                BROWN.printSyncGenericTitleLn("taskAborted");
            }

            @Override
            public void taskDone(Future<?> future, ManagedExecutorService executor, Object task, Throwable exception) {
                BROWN.printSyncGenericTitleLn("taskDone");
            }

            @Override
            public void taskStarting(Future<?> future, ManagedExecutorService executor, Object task) {
                BROWN.printSyncGenericTitleLn("taskStarting");
            }
        };
    }

    @Override
    public Map<String, String> getExecutionProperties() {
        BROWN.printSyncGenericTitleLn("getExecutionProperties");
        return new HashMap<>();
    }
}
