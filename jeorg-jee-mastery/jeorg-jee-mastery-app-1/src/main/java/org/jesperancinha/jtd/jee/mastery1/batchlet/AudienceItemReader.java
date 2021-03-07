package org.jesperancinha.jtd.jee.mastery1.batchlet;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Stack;

@Named
public class AudienceItemReader extends AbstractItemReader {

    Stack<String> stack = new Stack<>();

    {
        stack.push("audience");
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return 1;
    }

    @Override
    public Object readItem() throws Exception {
        if (stack.empty()) {
            return null;
        }
        final String item = stack.pop();
        ConsolerizerColor.ORANGE.printGenericTitleLn("Reading item \"%s\"", item);
        return "item";
    }
}
