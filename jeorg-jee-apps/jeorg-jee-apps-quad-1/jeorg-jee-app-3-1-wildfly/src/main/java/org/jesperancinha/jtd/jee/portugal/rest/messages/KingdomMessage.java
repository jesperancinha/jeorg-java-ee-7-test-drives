package org.jesperancinha.jtd.jee.portugal.rest.messages;

public class KingdomMessage {

    private String text;

    private String to;

    private String from;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "KingdomMessage{" + "text='" + text + '\'' + ", to='" + to + '\'' + ", from='" + from + '\'' + '}';
    }
}
