package org.jesperancinha.jtd.jee.mastery1.beans;

import javax.inject.Inject;
import javax.inject.Named;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;

@Named
public class StudentRegistration {

    private StudentBean studentBean;

    StudentRegistration() {
        YELLOW.printGenericTitleLn("Starting with %s", this.getClass().getCanonicalName());
        GREEN.printGenericLn("Notice what happens to this instance");
        GREEN.printGenericLn(this);
        GREEN.printInstanceLn(this);
    }

    public StudentBean getStudentBean() {
        ORANGE.printInstanceLn(this);
        return studentBean;
    }

    @Inject
    public void setStudentBean(StudentBean studentBean) {
        MAGENTA.printGenericLn("Set studentBean being called!");
        MAGENTA.printInstanceLn(this);
        this.studentBean = studentBean;
    }

    @Override
    public String toString() {
        return "StudentRegistration{" +
                "studentBean=" + studentBean +
                '}';
    }
}
