package org.jesperancinha.jtd.jee.girl.bands.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Band {

    @XmlElement(name = "Name")
    private String name;

    @XmlElementWrapper(name = "Members")
    @XmlElement(name = "Member")
    private List<Member> memberList;

    @XmlElementWrapper(name = "Albums")
    @XmlElement(name = "Album")
    private List<Album> albumList;

    public List<Member> getMemberList() {
        return memberList;
    }
}
