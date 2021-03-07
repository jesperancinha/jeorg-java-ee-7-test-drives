package org.jesperancinha.jtd.jee.mastery1.beans;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;

public class StudentBean {

    private String name = "Your name";

    public String getName() {
        ORANGE.printInstanceLn(this);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
