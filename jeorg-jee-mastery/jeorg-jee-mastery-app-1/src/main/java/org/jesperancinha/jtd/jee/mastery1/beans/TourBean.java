package org.jesperancinha.jtd.jee.mastery1.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 * The best example on where to us @RequestScoped.
 * For each request you know where to go and you do not need to keep that stage.
 */
//@Named
@RequestScoped
@ManagedBean(name = "tourBean",
        eager = true)
public class TourBean {

    @ManagedProperty(value = "#{param.page}")
    private String page;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String submitPage() {
        return page;
    }
}
