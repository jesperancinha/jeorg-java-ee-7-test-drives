package org.jesperancinha.jtd.jee.teeth.serialization.property;

import java.io.Serializable;

public class PropertyObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String property;

    public PropertyObject(String value) {
        this.property = value;
    }

    public String getProperty() {
        return property;
    }

}
