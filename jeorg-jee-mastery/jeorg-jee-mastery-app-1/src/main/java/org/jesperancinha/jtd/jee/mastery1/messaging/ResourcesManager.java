package org.jesperancinha.jtd.jee.mastery1.messaging;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.jms.ConnectionFactory;
import javax.jms.Session;

@Resources({
        @Resource(name = "connectionFactory",
                type = javax.jms.ConnectionFactory.class),
        @Resource(name = "java:jboss/mail/Default",
                type = javax.mail.Session.class)
})
public class ResourcesManager {

    private ConnectionFactory connectionFactory;

    private Session session;

}
