package org.jesperancinha.jtd.jee.portugal.rest.websockets1;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.util.Arrays;

public class AvizDecoder implements Decoder.Text<String> {

    private static final char[] lowercases = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    @Override
    public void init(EndpointConfig ec) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public String decode(final String message) throws DecodeException {
        final var lowerCaseMessage = message.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lowerCaseMessage.length(); i++) {
            final char c = lowerCaseMessage.charAt(i);
            int index = Arrays.binarySearch(lowercases, c);
            if (index <= -1) {
                sb.append(c);
                continue;
            }
            if (index - 13 >= 0) {
                index -= 13;
            } else {
                index = lowercases.length - (13 - index);
            }
            sb.append(lowercases[index]);
        }
        return sb.toString();
    }

    @Override
    public boolean willDecode(String string) {
        return true;
    }
}
