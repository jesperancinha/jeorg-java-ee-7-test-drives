package org.jesperancinha.jtd.jee.teeth.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table
public class Tooth {

    private UUID uuid;

    private Jaw jaw;

    private Nerve nerve;

    private Boolean nerveHit;

    private AbstractToothType abstractToothType;

    private ToothType toothType;

    private ToothType toothTypeNumber;

    private FinalToothType finalToothType;

    @ManyToOne(fetch = FetchType.EAGER)
    public Jaw getJaw() {
        return jaw;
    }

    public void setJaw(Jaw jaw) {
        this.jaw = jaw;
    }

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
    @OneToOne(fetch = FetchType.EAGER)
    public Nerve getNerve() {
        return nerve;
    }

    public void setNerve(Nerve nerve) {
        this.nerve = nerve;
    }

    @Column
    public Boolean getNerveHit() {
        return nerveHit;
    }

    public void setNerveHit(Boolean nerveHit) {
        this.nerveHit = nerveHit;
    }

    @OneToOne(fetch = FetchType.EAGER)
    public AbstractToothType getAbstractToothType() {
        return abstractToothType;
    }

    public void setAbstractToothType(AbstractToothType abstractToothType) {
        this.abstractToothType = abstractToothType;
    }

    @OneToOne(fetch = FetchType.EAGER)
    public FinalToothType getFinalToothType() {
        return finalToothType;
    }

    public void setFinalToothType(FinalToothType finalToothType) {
        this.finalToothType = finalToothType;
    }

    // We always need to set an Id for our entities.
    // And this is why interfaces cannot be JPA entities.
    // org.jboss.arquillian.container.spi.client.container.DeploymentException:
    // Cannot deploy test.war: {"WFLYCTL0062:
    // Composite operation failed and was rolled back.
    // Steps that failed:" =>
    // {"Operation step-1" => {"WFLYCTL0080: Failed services" =>
    // {"jboss.persistenceunit.\"test.war#primary\"" =>
    // "org.hibernate.AnnotationException: No identifier specified for entity: org.jesperancinha.jtd.jee.teeth.domain.InterfaceToothType
    //    Caused by: org.hibernate.AnnotationException:
    //    No identifier specified for entity:
    //    org.jesperancinha.jtd.jee.teeth.domain.InterfaceToothType"}}}}
    // @OneToOne
    // public InterfaceToothType getInterfaceToothType() {
    //     return interfaceToothType;
    // }
    //
    // public void setInterfaceToothType(InterfaceToothType interfaceToothType) {
    //     this.interfaceToothType = interfaceToothType;
    // }`



    @Column
    @Enumerated(EnumType.STRING)
    public ToothType getToothType() {
        return toothType;
    }

    public void setToothType(ToothType toothType) {
        this.toothType = toothType;
    }

    @Column
    @Enumerated(EnumType.ORDINAL)
    public ToothType getToothTypeNumber() {
        return toothTypeNumber;
    }

    public void setToothTypeNumber(ToothType toothTypeNumber) {
        this.toothTypeNumber = toothTypeNumber;
    }

    @Override
    public String toString() {
        return "Tooth{" +
                "uuid=" + uuid +
                ", jaw=" + jaw +
                ", nerve=" + nerve +
                ", nerveHit=" + nerveHit +
                ", toothType=" + toothType +
                ", toothTypeNumber=" + toothTypeNumber +
                ", abstractToothType=" + abstractToothType +
                ", finalToothType=" + finalToothType +
                '}';
    }
}
