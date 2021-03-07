package org.jesperancinha.jtd.jee.teeth.timer;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.Timeout;
import javax.ejb.Timer;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;

@Stateful
public class StatefulTimerSessionBean {

    @Resource
    private SessionContext context;

    public void createTimer(long duration) {
        RED.printGenericLn("This is not possible. Check your browser. A Timer service cannot be generated from a @Stateful bean");
        final var timerService = context.getTimerService();
        timerService.createTimer(duration, "I've timed in " + duration + "seconds with a StatefulTimerSessionBean");
    }

    @Timeout
    public void timeOutHandler(Timer timer) {
        YELLOW.printGenericLn(timer.getInfo());
        timer.cancel();
    }
}
