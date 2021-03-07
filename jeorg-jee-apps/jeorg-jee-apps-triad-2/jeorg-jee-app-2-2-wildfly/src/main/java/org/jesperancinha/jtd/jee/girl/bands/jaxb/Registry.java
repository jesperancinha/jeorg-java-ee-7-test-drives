package org.jesperancinha.jtd.jee.girl.bands.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Registry")
@XmlAccessorType(XmlAccessType.FIELD)
public class Registry {

    @XmlElementWrapper(name = "Bands")
    @XmlElement(name = "Band")
    private List<Band> bandList;

    public List<Band> getBandList() {
        return bandList;
    }
}
