package org.jesperancinha.jtd.jee.mastery1.batchlet;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

@Named
public class AudienceItemProcessor implements ItemProcessor {
    @Override
    public Object processItem(Object item) throws Exception {
        ConsolerizerColor.ORANGE.printGenericTitleLn("Processing item \"%s\"", item);
        return item;
    }

}
