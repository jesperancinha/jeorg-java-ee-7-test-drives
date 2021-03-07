package org.jesperancinha.jtd.jee.mastery2.schedule;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import java.util.Date;

@Stateless
public class TimerManager {

    @Resource
    private TimerService timerService;

    public void setAlarm(final Date date) {
        final TimerConfig timerConfig = new TimerConfig();
        timerConfig.setInfo("I walk the maze of moments");
        timerService.createSingleActionTimer(date, timerConfig);
    }

    @Timeout
    public void timeoutHandler(final Timer timer) {
        ConsolerizerColor.BG_ORANGE.printGenericTitleLn(timer.getInfo());
        ConsolerizerColor.BRIGHT_BLUE.printGenericLn(timer);
    }
}
