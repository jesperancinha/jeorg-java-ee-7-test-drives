package org.jesperancinha.jtd.jee.mastery2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Pen extends Merchandise {

    int len;

    @Column
    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }
}
