package org.jesperancinha.jtd.jee.vegetables;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.util.Date;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_MAGENTA;

@Named
@RequestScoped
public class NutsBean {
    private String nutType1;

    private String nutType2;

    private Long year;

    private Date date;

    private String secretNut;

    private String hiddenNut = "Almonds";

    private Part file;

    public String getNutType1() {
        return nutType1;
    }

    public String getNutType2() {
        return nutType2;
    }

    public Long getYear() {
        return year;
    }

    public Date getDate() {
        return date;
    }

    public void setNutType1(String nutType1) {
        this.nutType1 = nutType1;
    }

    public void setNutType2(String nutType2) {
        this.nutType2 = nutType2;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSecretNut() {
        return secretNut;
    }

    public void setSecretNut(String secretNut) {
        this.secretNut = secretNut;
    }

    public String getHiddenNut() {
        return hiddenNut;
    }

    public void setHiddenNut(String hiddenNut) {
        BRIGHT_BLUE.printGenericLn(hiddenNut);
        this.hiddenNut = "Peanuts";
    }

    public void logResults() {
        BRIGHT_MAGENTA.printGenericLn(toString());
    }

    @Override
    public String toString() {
        return "NutsBean{" +
                "nutType1='" + nutType1 + '\'' +
                ", nutType2='" + nutType2 + '\'' +
                ", year=" + year +
                ", date=" + date +
                ", secretNut='" + secretNut + '\'' +
                ", hiddenNut='" + hiddenNut + '\'' +
                ", file=" + file +
                '}';
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
}
