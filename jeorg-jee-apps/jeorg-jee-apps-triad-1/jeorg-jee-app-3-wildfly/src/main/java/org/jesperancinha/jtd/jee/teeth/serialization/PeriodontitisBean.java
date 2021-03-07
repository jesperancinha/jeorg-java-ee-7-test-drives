package org.jesperancinha.jtd.jee.teeth.serialization;

import org.jboss.ejb3.annotation.Cache;

import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_MAGENTA;

@Stateful
@Cache("custom-cache")
//@Remote(Passivation.class)
public class PeriodontitisBean implements PeriodontitisPassivation {

    private PeriodontitisObject periodontitisObject;

    @Override
    public void setPropertyObject(PeriodontitisObject periodontitisObject) {
        this.periodontitisObject = periodontitisObject;
    }

    @Override
    public PeriodontitisObject getPropertyObject() {
        return this.periodontitisObject;
    }

    @PrePassivate
    private void prePassivate() {
        BRIGHT_MAGENTA.printGenericLn("Passivating: " + periodontitisObject.getProperty());
    }

    @PostActivate
    private void postActivate() {
        BRIGHT_MAGENTA.printGenericLn("Activating: " + periodontitisObject.getProperty());
    }

}
