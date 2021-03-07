package org.jesperancinha.jtd.jee.girl.bands.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Member {

    @XmlElement(name = "Name")
    private String name;

    public String getName() {
        return name;
    }
}
