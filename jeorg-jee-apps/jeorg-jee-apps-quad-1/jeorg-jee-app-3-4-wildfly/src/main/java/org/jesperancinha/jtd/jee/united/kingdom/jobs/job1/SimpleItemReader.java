package org.jesperancinha.jtd.jee.united.kingdom.jobs.job1;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;
import java.io.Serializable;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;

@Named
public class SimpleItemReader extends AbstractItemReader {

    @Override
    public Serializable checkpointInfo() throws Exception {
        return 2;
    }

    @Override
    public Object readItem() throws Exception {
        BLUE.printGenericTitleLn("Starting Read Item");
        return "Some eggs";
    }

    @Override
    public void open(Serializable checkpoint) throws Exception {
        BLUE.printGenericTitleLn("Starting Open Read Item");
    }
}
