package org.jesperancinha.jtd.jee.mastery1.transactional;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class QuestionWrongException2 extends RuntimeException {

}
