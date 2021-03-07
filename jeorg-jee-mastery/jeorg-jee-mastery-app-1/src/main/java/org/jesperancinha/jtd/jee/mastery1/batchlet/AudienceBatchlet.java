package org.jesperancinha.jtd.jee.mastery1.batchlet;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;

import javax.batch.api.AbstractBatchlet;
import javax.inject.Named;

@Named
public class AudienceBatchlet extends AbstractBatchlet {

    @Override
    public String process() throws Exception {
        ConsolerizerColor.ORANGE.printGenericTitleLn("Processing Batchlet");
        return null;
    }
}