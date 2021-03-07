package org.jesperancinha.jtd.jee.mastery1.transactional;

import javax.ejb.ApplicationException;
import java.lang.annotation.Annotation;

public class QuestionWrongException extends RuntimeException implements ApplicationException {
    @Override
    public boolean rollback() {
        return true;
    }

    @Override
    public boolean inherited() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
