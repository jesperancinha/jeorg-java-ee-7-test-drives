package org.jesperancinha.jtd.jee.soul.beans;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;

public class MidasTouch {

    private String membera;
    private String memberb;
    private String memberc;
    private String memberd;
    private String membere;
    private String memberf;

    private String comment;

    public MidasTouch() {
        GREEN.printGenericLn("The JSP set function sets parameters according to their name");
        GREEN.printGenericLn("By default, the chosen name is the actual of the instance member");
        GREEN.printGenericLn("It will find a match between the member and the incoming parameter");
        GREEN.printGenericLn("We can also specify the parameter we need.");
    }

    public String getMembera() {
        return membera;
    }

    public String getMemberb() {
        return memberb;
    }

    public String getMemberc() {
        return memberc;
    }

    public String getMemberd() {
        return memberd;
    }

    public String getMembere() {
        return membere;
    }

    public String getMemberf() {
        return memberf;
    }

    public void setMembera(String membera) {
        this.membera = membera;
    }

    public void setMemberb(String memberb) {
        this.memberb = memberb;
    }

    public void setMemberc(String memberc) {
        this.memberc = memberc;
    }

    public void setMemberd(String memberd) {
        this.memberd = memberd;
    }

    public void setMembere(String membere) {
        this.membere = membere;
    }

    public void setMemberf(String memberf) {
        this.memberf = memberf;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void midasTouchSoul() {
        throw new RuntimeException();
    }
}
