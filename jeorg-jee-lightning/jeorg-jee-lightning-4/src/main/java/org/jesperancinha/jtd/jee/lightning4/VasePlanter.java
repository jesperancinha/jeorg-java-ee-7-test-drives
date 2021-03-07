package org.jesperancinha.jtd.jee.lightning4;

import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@AccessTimeout(
        value = 40,
        unit = TimeUnit.SECONDS)
public class VasePlanter implements Serializable {

    private String planted;

    @Lock(LockType.READ)
    public String getPlantedPlant() {
        RED.printGenericLn("Read started for %s -> %s", planted, LocalDateTime.now());
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(10));
        } catch (InterruptedException e) {
            RED.printThrowableAndExit(e);
        }
        GREEN.printGenericLn("Read stopped for %s -> %s", planted, LocalDateTime.now());
        return planted;
    }

    @Lock(LockType.WRITE)
    public void setPlantedPlant(String planted) {
        RED.printGenericLn("Write started for %s -> %s", planted, LocalDateTime.now());
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(10));
        } catch (InterruptedException e) {
            RED.printThrowableAndExit(e);
        }
        GREEN.printGenericLn("Write stopped for %s -> %s", planted, LocalDateTime.now());
        this.planted = planted;
    }

    public String getPlanted() {
        return planted;
    }

    public void setPlanted(String planted) {
        this.planted = planted;
    }
}
