package org.jesperancinha.jtd.jee.mastery1.timer;

import javax.ejb.AccessTimeout;
import javax.ejb.Singleton;
import java.util.concurrent.TimeUnit;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@Singleton
public class AccessTimeoutBean {

    @AccessTimeout(0)
    public String accessImmediateTimeout() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            RED.printGenericLn("This is expected -> %s", e.getMessage());
        }
        return "accessImmediateTimeout";
    }

    @AccessTimeout(-1)
    public String accessIndefiniteTimeout() throws InterruptedException {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            RED.printGenericLn("This is expected -> %s", e.getMessage());
        }
        return "accessIndefiniteTimeout";
    }

    @AccessTimeout(value = 1,
            unit = TimeUnit.SECONDS)
    public String accessOneSecondTimeout() throws InterruptedException {
        Thread.sleep(2000);
        return "accessOneSecondTimeout";
    }
}
