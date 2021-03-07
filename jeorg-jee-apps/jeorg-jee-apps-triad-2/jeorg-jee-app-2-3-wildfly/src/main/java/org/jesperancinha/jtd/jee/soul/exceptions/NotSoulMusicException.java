package org.jesperancinha.jtd.jee.soul.exceptions;

public class NotSoulMusicException extends RuntimeException {

    @Override
    public String getMessage() {
        return "The selected music is not Soul Music!";
    }
}
