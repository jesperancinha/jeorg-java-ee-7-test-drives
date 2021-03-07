package org.jesperancinha.jtd.jee.mastery1.transactional;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@Named
@SessionScoped
public class QuestionsBean implements Serializable {

    private String myAnswer;

    @Inject
    private Question1 question1;

    public String getMyAnswer() {
        return myAnswer;
    }

    public void setMyAnswer(String myAnswer) {
        this.myAnswer = myAnswer;
    }

    public void answerOne() {
        try {
            question1.answerOneWay(this.myAnswer);
        } catch (Exception e) {
            RED.printThrowableAndExit(e);
        }
    }

    public void answerTwo() {
        try {
            question1.answerTwoWay(this.myAnswer);
        } catch (Exception e) {
            RED.printThrowableAndExit(e);
        }
    }

    public Question1 getQuestion1() {
        return question1;
    }

    public void setQuestion1(Question1 question1) {
        this.question1 = question1;
    }
}
