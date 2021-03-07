package org.jesperancinha.jtd.jee.united.kingdom.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;

@Named
@RequestScoped
public class RequestMonarchs {

    private Monarch monarch = new Monarch();

    RequestMonarchs() {
        monarch.setName("Anne Stuart");
        monarch.setFamily("Stuart");
    }

    public void save() {
        ORANGE.printGenericLn("You have just recorder monarch -> %s", monarch);
    }

    public Monarch getMonarch() {
        return monarch;
    }

    public void setMonarch(Monarch monarch) {
        this.monarch = monarch;
    }
}

