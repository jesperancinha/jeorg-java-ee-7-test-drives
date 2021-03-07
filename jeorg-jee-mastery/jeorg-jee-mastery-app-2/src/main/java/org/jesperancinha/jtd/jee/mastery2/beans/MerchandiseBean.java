package org.jesperancinha.jtd.jee.mastery2.beans;

import jdk.jfr.Name;
import org.jesperancinha.jtd.jee.mastery2.domain.MerchandiseDAO;
import org.jesperancinha.jtd.jee.mastery2.domain.Pen;
import org.jesperancinha.jtd.jee.mastery2.domain.PenOne;
import org.jesperancinha.jtd.jee.mastery2.domain.Wallet;
import org.jesperancinha.jtd.jee.mastery2.domain.WalletOne;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.UUID;

@Named
@RequestScoped
public class MerchandiseBean {

    private String color;

    private Integer len;

    private String message;

    @Inject
    private MerchandiseDAO merchandiseDAO;

    public void submitValuesToAllTables() throws Exception {

        final PenOne penOne = new PenOne();
        penOne.setLen(len);
        penOne.setId(UUID.randomUUID().toString());
        final WalletOne walletOne = new WalletOne();
        walletOne.setColor(color);
        walletOne.setId(UUID.randomUUID().toString());

        merchandiseDAO.createMerchandise(penOne);
        merchandiseDAO.createMerchandise(walletOne);

        final Pen pen = new Pen();
        pen.setLen(len);
        pen.setId(UUID.randomUUID().toString());
        final Wallet wallet = new Wallet();
        wallet.setColor(color);

        wallet.setId(UUID.randomUUID().toString());
        merchandiseDAO.createMerchandise(pen);
        merchandiseDAO.createMerchandise(wallet);

        this.message = "Your merchandise is saved. Check your database to see the differences. Look for table `penone`, `walletone` and `merchandise`.";
    }

    public String getColor() {
        return color;
    }

    public Integer getLen() {
        return len;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setLen(Integer len) {
        this.len = len;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
