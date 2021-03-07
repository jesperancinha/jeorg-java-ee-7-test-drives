package org.jesperancinha.jtd.jee.the.netherlands.beans;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named("crownOfTheState")
@Stateless
public class CrownOfTheState {

    private String description;

    public CrownOfTheState() {
        this.description = "This crown has jewels, diamonds, gold, silver, silk and ruby's";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CrownOfTheState{" + "description='" + description + '\'' + '}';
    }
}
