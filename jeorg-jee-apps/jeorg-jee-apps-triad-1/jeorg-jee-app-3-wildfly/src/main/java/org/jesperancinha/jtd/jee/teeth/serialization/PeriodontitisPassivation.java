package org.jesperancinha.jtd.jee.teeth.serialization;

import javax.ejb.Local;

@Local
public interface PeriodontitisPassivation {

    void setPropertyObject(PeriodontitisObject periodontitisObject);

    PeriodontitisObject getPropertyObject();

}
