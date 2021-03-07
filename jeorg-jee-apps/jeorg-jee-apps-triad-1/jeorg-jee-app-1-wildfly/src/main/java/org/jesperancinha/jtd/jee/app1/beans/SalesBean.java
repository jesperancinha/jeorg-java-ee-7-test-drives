package org.jesperancinha.jtd.jee.app1.beans;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("salesBean")
@SessionScoped
public class SalesBean implements Serializable {

    private static final long serialVersionUID = -2564031884483676327L;

    @Inject
    @Sales
    private long salesNumber;

    // Caused by: org.jboss.weld.exceptions.DefinitionException: WELD-000075:
    // Normal scoped managed bean implementation class has a public field:
    // [EnhancedAnnotatedFieldImpl]
    // @Sales public org.jesperancinha.jtd.jee.app1.beans.SalesBean.sales
    // public Long sales;

    // Caused by: org.jboss.weld.exceptions.DeploymentException: WELD-000072:
    // Bean declaring a passivating scope must be passivation capable.
    // Bean:  Managed Bean [class org.jesperancinha.jtd.jee.app1.beans.Sales]
    // with qualifiers [@Any @Default]
    // This can be a deceiving exception. In other words it means that
    // org.jesperancinha.jtd.jee.app1.beans.Sales is not reachable
    // This could be because of several reasons and more:
    // 1. The bean isn't serializable
    // 2. The bean is actually an annotation that belongs to a different package

    @Inject
    @Sales
    Instance<Long> salesNumberRandomGenerator;

    private long salesNumberRandom;

    public long getSalesNumber() {
        return salesNumber;
    }

    public void setSalesNumber(long salesNumber) {
        this.salesNumber = salesNumber;
    }

    public long getSalesNumberRandom() {
        return salesNumberRandomGenerator.get();
    }
}
