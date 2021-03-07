package org.jesperancinha.jtd.jee.mastery2.sockets;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.StringReader;
import java.nio.ByteBuffer;

public class LyricBinaryDecoder implements Decoder.Binary<Lyric2> {
    @Override
    public Lyric2 decode(ByteBuffer bytes) throws DecodeException {
        byte[] array = new byte[bytes.limit()];
        bytes.get(array);
        final String receivedString = new String(array).replace("" + (char) 0, "");
        JsonObject jsonObject = Json
                .createReader(new StringReader(receivedString)).readObject();
        Lyric2 lyric2 = new Lyric2();
        lyric2.setSong(jsonObject.getString("song"));
        lyric2.setArtist(jsonObject.getString("artist"));
        lyric2.setLyricExtract(jsonObject.getString("lyricExtract"));
        return lyric2;
    }

    @Override
    public boolean willDecode(ByteBuffer bytes) {
        return true;
    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public void destroy() {
    }
}
