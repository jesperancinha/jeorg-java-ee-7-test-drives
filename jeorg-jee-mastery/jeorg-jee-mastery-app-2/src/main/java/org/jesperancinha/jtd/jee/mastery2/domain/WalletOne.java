package org.jesperancinha.jtd.jee.mastery2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class WalletOne extends MerchandiseOne {

    private String color;

    @Column
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
