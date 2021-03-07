package org.jesperancinha.jtd.jee.teeth.beans;

import org.jesperancinha.console.consolerizer.console.Consolerizer;
import org.jesperancinha.jtd.jee.teeth.domain.Jaw;
import org.jesperancinha.jtd.jee.teeth.domain.Tooth;
import org.jesperancinha.jtd.jee.teeth.service.JawService;
import org.jesperancinha.jtd.jee.teeth.service.ToothService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Named
@RequestScoped
public class ToothBean {

    private List<Tooth> toothList;

    public List<Tooth> getToothList() {
        return toothList;
    }

    public void setToothList(List<Tooth> toothList) {
        this.toothList = toothList;
    }

    @Inject
    private ToothService toothService;

    @Inject
    private JawService jawService;

    public void submit() throws HeuristicRollbackException, RollbackException, SystemException, NamingException, HeuristicMixedException, NotSupportedException {
        Consolerizer.setupFastDefault();
        toothList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            final var tooth = new Tooth();
            final var uuid = UUID.randomUUID();
            tooth.setUuid(uuid);

            final var jaw = new Jaw();
            jaw.setUuid(UUID.randomUUID());
            final Jaw jaw1 = jawService.updateItRight(jaw);

            tooth.setJaw(jaw);

            final Tooth tooth1 = toothService.updateItRight(tooth);
            toothList.add(tooth1);
        }
    }
}
