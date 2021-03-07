package org.jesperancinha.jtd.jee.teeth.timer;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;

@Stateless
public class StatelessTimerSessionBean {

    @Resource
    private SessionContext context;

    public void createTimer(long duration) {
        context.getTimerService()
                .createTimer(duration, "I've timed in " + duration + "seconds with a StatelessTimerSessionBean");
    }

    @Timeout
    public void timeOutHandler(Timer timer) {
        YELLOW.printGenericLn(timer.getInfo());
        timer.cancel();
    }
}
