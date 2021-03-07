package org.jesperancinha.jtd.jee.mastery2.sockets;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.StringReader;

public class LyricTextDecoder implements Decoder.Text<Lyric> {
    @Override
    public Lyric decode(String jsonMessage) throws DecodeException {
        JsonObject jsonObject = Json
                .createReader(new StringReader(jsonMessage)).readObject();
        Lyric lyric = new Lyric();
        lyric.setSong(jsonObject.getString("song"));
        lyric.setArtist(jsonObject.getString("artist"));
        lyric.setLyricExtract(jsonObject.getString("lyricExtract"));
        return lyric;
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public void destroy() {

    }
}
