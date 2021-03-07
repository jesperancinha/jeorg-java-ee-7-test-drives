package org.jesperancinha.jtd.jee.the.netherlands.beans;

import javax.inject.Inject;

public class CurrentRuler {

    private CrownOfTheState currenCrown;

    @Inject
    public CurrentRuler(CrownOfTheState crownOfTheState) {
        this.currenCrown = crownOfTheState;
    }

    public CrownOfTheState getCurrentCrown() {
        return currenCrown;
    }

    public void setCurrenCrown(CrownOfTheState currenCrown) {
        this.currenCrown = currenCrown;
    }

    @Override
    public String toString() {
        return "CurrentRuler{" + "currentCurrenCrown=" + currenCrown + '}';
    }
}
