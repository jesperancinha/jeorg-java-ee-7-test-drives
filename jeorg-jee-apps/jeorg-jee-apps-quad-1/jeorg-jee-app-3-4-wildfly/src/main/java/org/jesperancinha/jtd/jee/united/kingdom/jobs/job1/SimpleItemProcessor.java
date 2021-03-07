package org.jesperancinha.jtd.jee.united.kingdom.jobs.job1;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;

@Named
public class SimpleItemProcessor implements ItemProcessor {
    @Override
    public Object processItem(Object item) throws Exception {
        BLUE.printGenericTitleLn("Starting Process Item");

        return item;
    }

}
