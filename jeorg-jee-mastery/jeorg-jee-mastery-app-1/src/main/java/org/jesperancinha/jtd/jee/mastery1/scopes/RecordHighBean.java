package org.jesperancinha.jtd.jee.mastery1.scopes;

import org.jesperancinha.jtd.jee.mastery1.beans.Record;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class RecordHighBean {

    @Inject
    private RecordApplicationBean applicationBean;

    @Inject
    private RecordSessionBean recordSessionBean;

    @Inject
    private RecordViewBean recordViewBean;

    @Inject
    private RecordRequestBean recordRequestBean;

    private Record applicationRecord;

    private Record sessionRecord;

    private Record viewRecord;

    private Record requestRecord;

    @PostConstruct
    public void init() {
        this.applicationRecord = applicationBean.getRecord();
        this.sessionRecord = recordSessionBean.getRecord();
        this.viewRecord = recordViewBean.getRecord();
        this.requestRecord = recordRequestBean.getRecord();
    }

    public Record getApplicationRecord() {
        return applicationRecord;
    }

    public void setApplicationRecord(Record applicationRecord) {
        this.applicationRecord = applicationRecord;
    }

    public Record getSessionRecord() {
        return sessionRecord;
    }

    public void setSessionRecord(Record sessionRecord) {
        this.sessionRecord = sessionRecord;
    }

    public Record getViewRecord() {
        return viewRecord;
    }

    public void setRecordViewBean(RecordViewBean recordViewBean) {
        this.recordViewBean = recordViewBean;
    }

    public RecordRequestBean getRecordRequestBean() {
        return recordRequestBean;
    }

    public void setRecordRequestBean(RecordRequestBean recordRequestBean) {
        this.recordRequestBean = recordRequestBean;
    }

    public void setRequestRecord(Record requestRecord) {
        this.requestRecord = requestRecord;
    }

    public Record getRequestRecord() {
        return requestRecord;
    }

    public void submit() {
        // Dummy
    }
}
