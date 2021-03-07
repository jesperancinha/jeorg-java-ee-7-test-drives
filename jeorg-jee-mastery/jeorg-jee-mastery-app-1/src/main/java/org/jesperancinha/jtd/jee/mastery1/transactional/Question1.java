package org.jesperancinha.jtd.jee.mastery1.transactional;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import java.io.Serializable;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class Question1 implements Serializable {

    private static final String RIGHT_ANSWER = "1980";

    private boolean correctAnswer;

    private String answer;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void answerOneWay(String year) throws QuestionWrongException {
        this.answer = year;
        if (RIGHT_ANSWER.equals(year)) {
            this.correctAnswer = true;
        } else {
            throw new QuestionWrongException();
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void answerTwoWay(String year) throws QuestionWrongException {
        this.answer = year;
        if (RIGHT_ANSWER.equals(year)) {
            this.correctAnswer = true;
        }
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
