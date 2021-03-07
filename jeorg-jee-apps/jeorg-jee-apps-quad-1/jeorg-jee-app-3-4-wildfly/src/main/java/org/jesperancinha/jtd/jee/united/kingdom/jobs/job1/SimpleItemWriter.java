package org.jesperancinha.jtd.jee.united.kingdom.jobs.job1;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;

@Named
public class SimpleItemWriter extends AbstractItemWriter {

    @Override
    public void writeItems(List<Object> items) throws Exception {
        BLUE.printGenericTitleLn("Starting Write Items");
    }

    @Override
    public void open(Serializable checkpoint) throws Exception {
        BLUE.printGenericTitleLn("Starting Open Write Item");
    }

    @Override
    public void close() throws Exception {
        BLUE.printGenericTitleLn("Job closing");
    }
}
