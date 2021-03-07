package org.jesperancinha.jtd.jee.girl.bands.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Song {

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Duration")
    private Long duration;
}
