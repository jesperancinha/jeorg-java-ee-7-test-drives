package org.jesperancinha.jtd.jee.portugal.rest.websockets1;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import java.util.Arrays;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;

public class AvizEncoder implements Encoder.Text<AvizEncodedMessage> {

    private static final char[] lowercases = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    @Override
    public void init(EndpointConfig ec) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public String encode(AvizEncodedMessage message) throws EncodeException {
        GREEN.printGenericLn("Note that encoders work with objects. This is why we can decode automatically into a String, but not decode back from a String.");
        final var lowerCaseMessage = message.getEncodedMessage().toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lowerCaseMessage.length(); i++) {
            final char c = lowerCaseMessage.charAt(i);
            int index = Arrays.binarySearch(lowercases, c);
            if (index <= -1) {
                sb.append(c);
                continue;
            }
            if (index + 13 < lowercases.length) {
                index += 13;
            } else {
                index -= lowercases.length - 13;
            }
            sb.append(lowercases[index]);
        }

        return sb.toString();
    }
}