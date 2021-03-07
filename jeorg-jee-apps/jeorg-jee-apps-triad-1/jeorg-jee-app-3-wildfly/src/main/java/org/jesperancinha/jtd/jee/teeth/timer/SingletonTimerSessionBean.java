package org.jesperancinha.jtd.jee.teeth.timer;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.Timer;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;

@Singleton
public class SingletonTimerSessionBean {

    @Resource
    private SessionContext context;

    public void createTimer(long duration) {
        context.getTimerService()
                .createTimer(duration, "I've timed in " + duration + "seconds with a SingletonTimerSessionBean");
    }

    @Timeout
    public void timeOutHandler(Timer timer) {
        YELLOW.printGenericLn(timer.getInfo());
        timer.cancel();
    }
}
