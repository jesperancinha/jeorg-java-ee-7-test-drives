package org.jesperancinha.jtd.jee.the.netherlands.rest;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import java.io.Serializable;

import static javax.enterprise.event.Reception.ALWAYS;
import static javax.enterprise.event.Reception.IF_EXISTS;
import static javax.enterprise.event.TransactionPhase.AFTER_COMPLETION;
import static javax.enterprise.event.TransactionPhase.AFTER_SUCCESS;
import static javax.enterprise.event.TransactionPhase.BEFORE_COMPLETION;
import static javax.enterprise.event.TransactionPhase.IN_PROGRESS;
import static org.jesperancinha.console.consolerizer.console.Consolerizer.printRainbowTitleLn;
import static org.jesperancinha.console.consolerizer.console.ConsolerizerGraphs.printRainbowFlag;

@RequestScoped
public class EventProcessor implements Serializable {

    public void sendPressRelease(
            @Observes(notifyObserver = Reception.ALWAYS)
                    ArrivalEvent event) {
        printRainbowTitleLn("Event received! -> %s, %s, %s", ALWAYS, IN_PROGRESS, event);
        printRainbowTitleLn("Reception.ALWAYS means that we ALWAYS receive this event.");
        printRainbowTitleLn("Reception.ALWAYS and TransactionPhase.IN_PROGRESS are the default values");
        printRainbowFlag("Press statement has been given! %s", event.getMessage());
    }

    public void cleanPalace(
            @Observes(notifyObserver = IF_EXISTS)
                    ArrivalEvent event) {
        printRainbowTitleLn("Event received! -> %s, %s, %s", IF_EXISTS, IN_PROGRESS, event);
        printRainbowTitleLn("We get this event only when there is an instance in a related context.");
        printRainbowTitleLn("Otherwise we never get this event.");
        printRainbowTitleLn("Remember that TransactionPhase.IN_PROGRESS is the default value for during.");
        printRainbowFlag("Cleaners have been notified! %s", event.getMessage());
    }

    public void informFamily(
            @Observes(notifyObserver = IF_EXISTS,
                    during = AFTER_COMPLETION)
                    ArrivalEvent event) {
        printRainbowTitleLn("Event received! -> %s, %s, %s", event, IF_EXISTS, AFTER_COMPLETION);
        printRainbowTitleLn(
                "We get this event only when there is an instance in a related context after completing the transaction.");
        printRainbowTitleLn("Otherwise we never get this event.");
        printRainbowTitleLn("Remember that TransactionPhase.IN_PROGRESS is the default value for during.");
        printRainbowFlag("Family has been notified! %s", event.getMessage());
    }

    public void orderFlowers(
            @Observes(notifyObserver = IF_EXISTS,
                    during = BEFORE_COMPLETION)
                    ArrivalEvent event) {
        printRainbowTitleLn("Event received! -> %s, %s, %s", event, IF_EXISTS, BEFORE_COMPLETION);
        printRainbowTitleLn(
                "We get this event only when there is an instance in a related context before completing the transaction.");
        printRainbowTitleLn("Otherwise we never get this event.");
        printRainbowTitleLn("Remember that TransactionPhase.IN_PROGRESS is the default value for during.");
        printRainbowFlag("Flowers have been ordered! %s", event.getMessage());

    }

    public void arrangeGarden(
            @Observes(notifyObserver = IF_EXISTS,
                    during = AFTER_SUCCESS)
                    ArrivalEvent event) {
        printRainbowTitleLn("Event received! -> %s, %s, %s", event, IF_EXISTS, AFTER_SUCCESS);
        printRainbowTitleLn(
                "We get this event only when there is an instance in a related context succeeding to perform the transaction.");
        printRainbowTitleLn("Otherwise we never get this event.");
        printRainbowTitleLn("Remember that TransactionPhase.IN_PROGRESS is the default value for during.");
        printRainbowFlag("Gardern has been arranged! %s", event.getMessage());

    }
}
