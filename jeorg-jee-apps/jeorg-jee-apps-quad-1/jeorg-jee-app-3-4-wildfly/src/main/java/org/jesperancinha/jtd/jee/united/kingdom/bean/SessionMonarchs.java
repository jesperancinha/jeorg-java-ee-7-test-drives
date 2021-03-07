package org.jesperancinha.jtd.jee.united.kingdom.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;

@Named
@SessionScoped
public class SessionMonarchs implements Serializable {

    private Monarch monarch = new Monarch();

    SessionMonarchs() {
        monarch.setName("George I");
        monarch.setFamily("Hanover");
    }

    public void save() {
        ORANGE.printGenericLn("You have just recorder monarch -> %s", monarch);
    }

    public void setMonarch(Monarch monarch) {
        this.monarch = monarch;
    }

    public Monarch getMonarch() {
        return monarch;
    }
}
