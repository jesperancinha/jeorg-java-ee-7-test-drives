package org.jesperancinha.jtd.jee.teeth.domain;

// org.jboss.arquillian.container.spi.client.container.DeploymentException:
// Cannot deploy test.war:
// {"WFLYCTL0062: Composite operation failed and was rolled back. Steps that failed:" =>
// {"Operation step-1" => {"WFLYCTL0080: Failed services" =>
// {"jboss.persistenceunit.\"test.war#primary\"" =>
// "org.hibernate.AnnotationException:
// No identifier specified for entity:
// org.jesperancinha.jtd.jee.teeth.domain.InterfaceToothType
//    Caused by: org.hibernate.AnnotationException:
//    No identifier specified for entity:
//    org.jesperancinha.jtd.jee.teeth.domain.InterfaceToothType"}}}}
// @Entity
// @Table
public interface InterfaceToothType {

}
