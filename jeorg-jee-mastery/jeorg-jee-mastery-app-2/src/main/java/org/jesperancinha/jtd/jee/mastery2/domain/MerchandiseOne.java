package org.jesperancinha.jtd.jee.mastery2.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

//{"WFLYCTL0080: Failed services" => {
//    "jboss.persistenceunit.\"jee-mastery-app-2-1.0.0-SNAPSHOT.war#primary\"" => "org.hibernate.AnnotationException: An entity cannot be annotated with both @Entity and @MappedSuperclass: org.jesperancinha.jtd.jee.mastery2.domain.MerchandiseOne
//    Caused by: org.hibernate.AnnotationException: An entity cannot be annotated with both @Entity and @MappedSuperclass: org.jesperancinha.jtd.jee.mastery2.domain.MerchandiseOne",
//    "jboss.persistenceunit.\"jee-mastery-app-2-1.0.0-SNAPSHOT.war#secondary\"" => "org.hibernate.AnnotationException: An entity cannot be annotated with both @Entity and @MappedSuperclass: org.jesperancinha.jtd.jee.mastery2.domain.MerchandiseOne
//    Caused by: org.hibernate.AnnotationException: An entity cannot be annotated with both @Entity and @MappedSuperclass: org.jesperancinha.jtd.jee.mastery2.domain.MerchandiseOne"
//}}
//@Entity
@Table
@MappedSuperclass
public abstract class MerchandiseOne {

    private String id;

    public void setId(String id) {

        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }

}
