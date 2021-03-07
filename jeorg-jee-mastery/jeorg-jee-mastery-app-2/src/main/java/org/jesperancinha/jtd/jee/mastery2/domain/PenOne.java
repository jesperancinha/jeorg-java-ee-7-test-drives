package org.jesperancinha.jtd.jee.mastery2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PenOne extends MerchandiseOne {

    int len;

    @Column
    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }
}
