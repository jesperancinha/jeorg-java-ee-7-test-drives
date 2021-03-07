package org.jesperancinha.jtd.jee.portugal.beans;

import org.jesperancinha.console.consolerizer.console.Consolerizer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Singleton;
import java.io.Serializable;
import java.util.List;
import java.util.Stack;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@Singleton
public class HistorySingletonDelivery implements Serializable {
    final Stack<String> stackOfEvents1 = HistoryContentCreator.stackOfEvents1();

    public HistorySingletonDelivery() {
        RED.printGenericLn("This is a %s with hash %s", this.getClass()
                .getCanonicalName(), this.hashCode());

        GREEN.printGenericLn("A @Singleton bean is never passivated and only has two stages:");
        GREEN.printGenericLn("Non-existent and ready for activation");
        GREEN.printGenericLn("A @Singleton is already @ApplicationScoped");
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
        BLUE.printGenericTitleLn("Bean %s with hash %s is being destroyed", this.getClass()
                .getCanonicalName(), this.hashCode());
    }

    @PostConstruct
    public void postConstruct() {
        Consolerizer.titleSpread = 150;
        BLUE.printGenericTitleLn("Bean %s with hash %s is being passivated", this.getClass()
                .getCanonicalName(), this.hashCode());
    }
}
