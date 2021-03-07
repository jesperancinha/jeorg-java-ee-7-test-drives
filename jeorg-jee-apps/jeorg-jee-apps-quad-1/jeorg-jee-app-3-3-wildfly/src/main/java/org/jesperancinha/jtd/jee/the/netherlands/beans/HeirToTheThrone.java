package org.jesperancinha.jtd.jee.the.netherlands.beans;

import javax.inject.Inject;

public class HeirToTheThrone {

    private CrownOfTheState currentCurrenCrown;

    public CrownOfTheState getCurrentCurrenCrown() {
        return currentCurrenCrown;
    }

    @Inject
    public void setCurrentCurrenCrown(CrownOfTheState currentCurrenCrown) {
        this.currentCurrenCrown = currentCurrenCrown;
    }

    @Override
    public String toString() {
        return "HeirToTheThrone{" + "currentCurrenCrown=" + currentCurrenCrown + '}';
    }
}
