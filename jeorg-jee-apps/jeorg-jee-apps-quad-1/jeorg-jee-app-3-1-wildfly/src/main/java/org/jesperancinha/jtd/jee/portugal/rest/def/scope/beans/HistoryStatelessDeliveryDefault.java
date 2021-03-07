package org.jesperancinha.jtd.jee.portugal.rest.def.scope.beans;

import org.jesperancinha.console.consolerizer.console.Consolerizer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.List;
import java.util.Stack;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;

@Stateless
public class HistoryStatelessDeliveryDefault implements Serializable {
    final Stack<String> stackOfEvents1 = HistoryContentCreator.stackOfEvents1();

    public HistoryStatelessDeliveryDefault() {
        YELLOW.printGenericLn("This is a %s with hash %s", this.getClass()
                .getCanonicalName(), this.hashCode());
        YELLOW.printGenericLn(stackOfEvents1);
        GREEN.printGenericLn("A @Stateless bean is never passivated and only has two stages:");
        GREEN.printGenericLn("Non-existent and ready for activation");
        GREEN.printGenericLn("nonexistent and ready for the invocation of business methods.");
    }

    public List<String> getSomeHistory() {
        return HistoryContentCreator.stackOfEvents1();
    }

    public String getLatestElementOfHistory() {
        BLUE.printGenericLn("This is instance of type %s with hash %s and elements %s", this.getClass()
                .getCanonicalName(), this.hashCode(), stackOfEvents1);
        return stackOfEvents1.pop();
    }

    @PreDestroy
    public void destroy() {
        BLUE.printGenericTitleLn("Bean %s is being destroyed", this.getClass()
                .getCanonicalName());
    }

    @PostConstruct
    public void postConstruct() {
        Consolerizer.titleSpread = 150;
        BLUE.printGenericTitleLn("Bean %s with hash %s is being passivated", this.getClass()
                .getCanonicalName(), this.hashCode());
    }
}
