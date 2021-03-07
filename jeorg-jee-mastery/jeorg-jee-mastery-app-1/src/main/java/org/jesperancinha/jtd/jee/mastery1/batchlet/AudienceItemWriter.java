package org.jesperancinha.jtd.jee.mastery1.batchlet;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import java.util.List;

@Named
public class AudienceItemWriter extends AbstractItemWriter {
    @Override
    public void writeItems(List<Object> items) throws Exception {
        ConsolerizerColor.ORANGE.printGenericTitleLn("Writing items \"%s\"", items);
    }
}
