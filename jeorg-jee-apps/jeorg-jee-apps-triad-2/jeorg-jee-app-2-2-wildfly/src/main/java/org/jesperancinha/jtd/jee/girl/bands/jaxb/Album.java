package org.jesperancinha.jtd.jee.girl.bands.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Album {

    @XmlElement(name = "Name")
    private String name;

    @XmlElementWrapper(name = "Songs")
    @XmlElement(name = "Song")
    private List<Song> songList;

}
