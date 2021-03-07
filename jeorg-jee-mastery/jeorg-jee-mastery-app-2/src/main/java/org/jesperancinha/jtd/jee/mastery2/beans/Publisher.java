package org.jesperancinha.jtd.jee.mastery2.beans;

public class Publisher {

    public String publisher = "4AD";

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisher='" + publisher + '\'' +
                '}';
    }
}
