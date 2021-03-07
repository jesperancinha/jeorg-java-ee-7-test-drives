package org.jesperancinha.jtd.jee.mastery1.timer;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import java.time.LocalDateTime;

import static org.jesperancinha.console.consolerizer.console.Consolerizer.printRainbowTitleLn;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;

@Singleton
public class CyclicRegister {
    @Schedule(minute = "*/1",
            hour = "*")
    public void register() {
        printRainbowTitleLn("It is now %s", LocalDateTime.now());
        GREEN.printGenericLn("second, hour, minute, default to 0");
        GREEN.printGenericLn("dayOfMonth, month, dayOfWeek, year default to *");
        GREEN.printGenericLn("timezone and info default to empty");
        GREEN.printGenericLn("persistent default to true");
    }

    @Schedule(minute = "*/1")
    public void registerAfterMidnight() {
        printRainbowTitleLn("Since the default is 0 for hour, this one will only be triggered after midnight  %s", LocalDateTime.now());
    }
}
