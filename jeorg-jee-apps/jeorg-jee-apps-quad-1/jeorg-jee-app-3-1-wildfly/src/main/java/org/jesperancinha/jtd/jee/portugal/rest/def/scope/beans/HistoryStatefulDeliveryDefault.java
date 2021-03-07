package org.jesperancinha.jtd.jee.portugal.rest.def.scope.beans;

import org.jesperancinha.console.consolerizer.console.Consolerizer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.io.Serializable;
import java.util.List;
import java.util.Stack;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;

@Stateful
public class HistoryStatefulDeliveryDefault implements Serializable {
    final Stack<String> stackOfEvents1 = HistoryContentCreator.stackOfEvents1();

    public HistoryStatefulDeliveryDefault() {
        GREEN.printGenericLn("This is a %s with hash %s", this.getClass()
                .getCanonicalName(), this.hashCode());
        YELLOW.printGenericLn(stackOfEvents1);

    }

    public List<String> getSomeHistory() {
        return HistoryContentCreator.stackOfEvents1();
    }

    public String getLatestElementOfHistory() {
        BLUE.printGenericLn("This is instance of type %s with hash %s and elements %s", this.getClass()
                .getCanonicalName(), this.hashCode(), stackOfEvents1);
        return stackOfEvents1.pop();
    }

    @PostConstruct
    public void postConstruct() {
        Consolerizer.titleSpread = 150;
        BLUE.printGenericTitleLn("Bean %s with hash %s is being passivated", this.getClass()
                .getCanonicalName(), this.hashCode());
    }

    @PrePassivate
    public void prePassivate() {
        BLUE.printGenericTitleLn("Bean %s with hash %s is being passivated", this.getClass()
                .getCanonicalName(), this.hashCode());
    }

    @PostActivate
    public void postActivate() {
        BLUE.printGenericTitleLn("Bean %s with hash %s has been activated", this.getClass()
                .getCanonicalName(), this.hashCode());
    }

    @Remove
    public void remove() {
        BLUE.printGenericTitleLn("Bean %s with hash %s is being removed", this.getClass()
                .getCanonicalName(), this.hashCode());
    }

    @PreDestroy
    public void destroy() {
        BLUE.printGenericTitleLn("Bean %s with hash %s is being destroyed", this.getClass()
                .getCanonicalName(), this.hashCode());
    }
}
