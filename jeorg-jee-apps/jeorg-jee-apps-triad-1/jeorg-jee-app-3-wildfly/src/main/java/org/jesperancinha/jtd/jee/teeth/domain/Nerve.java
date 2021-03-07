package org.jesperancinha.jtd.jee.teeth.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table
public class Nerve {

    private UUID uuid;

    private Tooth tooth;

    @Id
    @Column
    @NotNull
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    // org.jboss.arquillian.container.spi.client.container.DeploymentException:
    // Cannot deploy test.war:
    // {"WFLYCTL0062: Composite operation failed and was rolled back.
    // Steps that failed:" => {"Operation step-1" =>
    // {"WFLYCTL0080: Failed services" => {"jboss.persistenceunit.\"test.war#primary\"" =>
    // "org.hibernate.AnnotationException: @Column(s) not allowed on a
    // @OneToOne property: org.jesperancinha.jtd.jee.teeth.domain.Tooth.nerve
    //    Caused by: org.hibernate.AnnotationException: @Column(s)
    //    not allowed on a @OneToOne property:
    //    org.jesperancinha.jtd.jee.teeth.domain.Tooth.nerve"}}}}
    // @Column
    @OneToOne
    public Tooth getTooth() {
        return tooth;
    }

    public void setTooth(Tooth tooth) {
        this.tooth = tooth;
    }
}
