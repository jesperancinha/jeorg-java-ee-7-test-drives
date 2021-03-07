package org.jesperancinha.jtd.jee.united.kingdom.bean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;

@Named
@ApplicationScoped
public class ApplicationMonarchs implements Serializable {

    private Monarch monarch = new Monarch();

    ApplicationMonarchs() {
        monarch.setName("Edward VII");
        monarch.setFamily("Saxe-Coburg and Gotha");
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
