package org.jesperancinha.jtd.jee.teeth.serialization;

import java.io.Serializable;

// Note that this EJB needs to be serializable because Marshalling is being used to cache objects.
// Counterwise, Unmarshalling is being used to retrieve objects from the database.
// Without Serialization, passivation is not possible.
// Unable to passivate entry under InfinispanBeanGroupKey(UUIDSessionID [7d529385-2808-47fc-af7a-a4bd4709813d])
// Caused by: org.infinispan.commons.marshall.NotSerializableException: org.jesperancinha.jtd.jee.teeth.serialization.PeriodontitisObject
public class PeriodontitisObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String property;

    public PeriodontitisObject(String value) {
        this.property = value;
    }

    public String getProperty() {
        return property;
    }

}
