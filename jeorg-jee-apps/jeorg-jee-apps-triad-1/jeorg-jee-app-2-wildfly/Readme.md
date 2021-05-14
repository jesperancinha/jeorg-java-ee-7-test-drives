# jee-app-2-wildfly

## Technologies used

---

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/java-50.png "Java")](https://www.oracle.com/nl/java/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/lombok-50.png "Lombok")](https://projectlombok.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/openjdk-50.png "OpenJDK")](https://openjdk.java.net/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/sdk-man-50.png "SdkMAN!")](https://sdkman.io/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/wild-fly-50.png "WildFly")](https://www.wildfly.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/arquillian-50.png "Arquillian")](https://github.com/arquillian)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/iron-jacamar-50.png "IronJacamar")](http://www.ironjacamar.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/active-mq-50.png "ActiveMQ")](http://activemq.apache.org/)

---

## Exercise

The apps under [jee-apps](../..), cover lots of topics. For this app we cover:

1.  `@XmlRootElement(name = "herb")` and `@XmlAccessorType(XmlAccessType.FIELD)`
2.  `@Path`, `@RequestScoped`, `@POST`, `@GET`, `@Produces`, `@Consumes` and `MediaType.APPLICATION_XML`
3.  `ServletContext`, `HttpSession` and `doGet`
4.  A very complicated JCA example, that doesn't work. Only `JNDI` works - Follow-up modules may provide solution to this.
5.  `javax.ejb.MessageDriven`, `@ActivationConfigProperty` and `javax.jms.MessageListener`.
6.  ApacheMQ, queues and [standalone-full.xml](backup/standalone-full.xml) configuration
7.  Much about `@WebServiceRef`
8.  `@WebServlet`, `@WebServiceRef`, `@HandlerChain`, `@WebServiceClient`, SOAP WS - JAX-WS

In this web application it is important to understand the basics of these:

1.  The differences between using [JAXB](https://docs.oracle.com/javase/tutorial/jaxb/intro/index.html)
   and [JAX-WS](https://docs.oracle.com/javaee/7/tutorial/jaxws.htm)
2.  JCA - [Java Connector Architecture](https://github.com/fmarchioni/mastertheboss/tree/master/jca-demo)
3.  JMS - Java Message Service

This application offers you a fun overview in a very basic way about Resources, Controllers, Managed Beans, Data Access Objects, Services, Producers and Observers

The theme of this discovery app is: <b>Kitchen Herbs and History</b>

## How to run

This has been tested with Wildfly 16. Please install it and deploy this using your IDE.

```bash
jenv local system
sdk use java 11.0.9.hs-adpt 
java -version
```

Run this command first <b>WITHOUT</b> the server running:

```bash
cp backup/standalone-full.xml ../../wildfly-16.0.0.Final/standalone/configuration/
```

Be sure to run the automated installation having the sever <b>RUNNING</b>:

```bash
installAll.sh
```

Also make sure that you have read the index page of [jee-apps](../..) and that you have previously installed [Wildfly 16](../../installWildFly.sh).

Afterwards, we still need to configure a messaging system. There are many vendors out there. We randomly pick [activeMQ](http://activemq.apache.org/). Go to [the resource adapter ActiveMQ page](http://activemq.apache.org/resource-adapter.html). Then download
the [rar](https://search.maven.org/remotecontent?filepath=org/apache/activemq/activemq-rar/5.16.0/activemq-rar-5.16.0.rar)
file. Then download the [rar](https://search.maven.org/remotecontent?filepath=org/apache/activemq/activemq-rar/5.10.0/activemq-rar-5.10.0.rar)
file. Copy that file into [deployments](../../../wildfly-16.0.0.Final/standalone/deployments):

```bash
curl https://search.maven.org/remotecontent?filepath=org/apache/activemq/activemq-rar/5.16.0/activemq-rar-5.16.0.rar --output activemq-rar-5.16.0.rar
cp activemq-rar-5.16.0.rar ../../wildfly-16.0.0.Final/standalone/deployments
```

Add the following subsystem to [standalone-full.xml](../../../wildfly-16.0.0.Final/standalone/configuration/standalone-full.xml)

```xml

<subsystem xmlns="urn:jboss:domain:resource-adapters:5.0">
    <resource-adapters>
        <resource-adapter id="activemq">
            <archive>
                activemq-rar-5.16.0.rar
            </archive>

            <transaction-support>XATransaction</transaction-support>

            <config-property name="UseInboundSession">
                false
            </config-property>

            <config-property name="Password">
                defaultPassword
            </config-property>

            <config-property name="UserName">
                defaultUser
            </config-property>

            <config-property name="ServerUrl">
                tcp://localhost:61616
            </config-property>

            <connection-definitions>
                <connection-definition class-name="org.apache.activemq.ra.ActiveMQManagedConnectionFactory"
                                       jndi-name="java:/ConnectionFactoryLove" enabled="true"
                                       pool-name="ConnectionFactory">

                    <xa-pool>
                        <min-pool-size>1</min-pool-size>
                        <max-pool-size>20</max-pool-size>
                        <prefill>false</prefill>
                        <is-same-rm-override>false</is-same-rm-override>
                    </xa-pool>

                </connection-definition>
            </connection-definitions>

            <admin-objects>
                <admin-object class-name="org.apache.activemq.command.ActiveMQQueue"
                              jndi-name="java:jboss/activemq/queue/TestQueue" use-java-context="true"
                              pool-name="TestQueue" enabled="true">

                    <config-property name="PhysicalName">
                        activemq/queue/TestQueue
                    </config-property>

                </admin-object>

                <admin-object class-name="org.apache.activemq.command.ActiveMQTopic"
                              jndi-name="java:jboss/activemq/topic/TestTopic" use-java-context="true"
                              pool-name="TestTopic" enabled="true">

                    <config-property name="PhysicalName">
                        activemq/topic/TestTopic
                    </config-property>

                </admin-object>
            </admin-objects>
        </resource-adapter>
    </resource-adapters>
</subsystem>
```

Also be sure to update this section:

```xml

<subsystem xmlns="urn:jboss:domain:messaging-activemq:6.0">
    <server name="default">
        <statistics enabled="${wildfly.messaging-activemq.statistics-enabled:${wildfly.statistics-enabled:false}}"/>
        <security-setting name="#">
            <role name="guest" send="true" consume="true" create-non-durable-queue="true"
                  delete-non-durable-queue="true"/>
        </security-setting>
        <address-setting name="#" dead-letter-address="jms.queue.DLQ" expiry-address="jms.queue.ExpiryQueue"
                         max-size-bytes="10485760" page-size-bytes="2097152" message-counter-history-day-limit="10"/>
        <http-connector name="http-connector" socket-binding="http" endpoint="http-acceptor"/>
        <http-connector name="http-connector-throughput" socket-binding="http" endpoint="http-acceptor-throughput">
            <param name="batch-delay" value="50"/>
        </http-connector>
        <in-vm-connector name="in-vm" server-id="0">
            <param name="buffer-pooling" value="false"/>
        </in-vm-connector>
        <http-acceptor name="http-acceptor" http-listener="default"/>
        <http-acceptor name="http-acceptor-throughput" http-listener="default">
            <param name="batch-delay" value="50"/>
            <param name="direct-deliver" value="false"/>
        </http-acceptor>
        <in-vm-acceptor name="in-vm" server-id="0">
            <param name="buffer-pooling" value="false"/>
        </in-vm-acceptor>
        <jms-queue name="ExpiryQueue" entries="java:/jms/queue/ExpiryQueue"/>
        <jms-queue name="DLQ" entries="java:/jms/queue/DLQ"/>
        <jms-queue name="TestQueue" entries="java:jboss/activemq/queue/TestQueue"/>
        <connection-factory name="InVmConnectionFactory" entries="java:/ConnectionFactoryLove" connectors="in-vm"/>
        <connection-factory name="RemoteConnectionFactory" entries="java:jboss/exported/jms/RemoteConnectionFactory"
                            connectors="http-connector"/>
        <pooled-connection-factory name="activemq" entries="java:/JmsXA java:jboss/DefaultJMSConnectionFactory"
                                   connectors="in-vm" transaction="xa"/>
    </server>
</subsystem>
```

The important nodes to bear in mind are the whole `resource-adapters` node, `jms-queue` and the `pooled-connection-factory`. A complete backup of a successful running ApacheMQ configuration file is located in [standalone-full.xml](backup/standalone-full.xml) for your evaluation.

<b>ALWAYS start WildFly this way:</b>

```bash
./standalone.sh -c standalone-full.xml
```

After the service is running and deployed you should be able to see pages and JSON's in these addresses:

1.  http://localhost:8080/jeorg-jee-app-2-wildfly/app/herbs/parsley
2.  http://localhost:8080/jeorg-jee-app-2-wildfly/herbs/prices
3.  http://localhost:8080/jeorg-jee-app-2-wildfly/herbs/prices2
4.  http://localhost:8080/jeorg-jee-app-2-wildfly/app/herbs/connection
5.  http://localhost:8080/jeorg-jee-app-2-wildfly/jms

> NOTE: For point 4, there is a JCA running on this set of examples.
> The problem is that it does not work because classes aren't being shared via the RAR module
> Can you find out what is stopping this from working?
> And can you find a solution?

You can also perform these post requests:

```bash
curl -X POST http://localhost:8080/jeorg-jee-app-2-wildfly/app/herbs -H "Content-Type: application/xml" -d '<herb><name>Parsley</name><color>Green</color><grams>1000</grams></herb>'
```

## Troubleshooting

Installing applications in Application servers can be difficult. Although this isn't specific to Java Enterprise knowledge, it is necessary in order to make exercises. One place we always have to look at if problems arise is the standalone files. In our case we are running
the [standalone-full.xml](backup/standalone-full.xml) file. Upon successful installation we should have these `deployments` at the end of the file:

```xml

<deployments>
    <deployment name="jee-app-2-wildfly-ws-1.0-SNAPSHOT.war" runtime-name="jee-app-2-wildfly-ws-1.0-SNAPSHOT.war">
        <fs-archive
                path="/Users/jofisaes/dev/src/jofisaes/java-test-drives/jee7/jeorg-jee-apps/jeorg-jee-app-2-wildfly-ws/target/jeorg-jee-app-2-wildfly-ws-1.0-SNAPSHOT.war"/>
    </deployment>
    <deployment name="jee-app-2-wildfly-adapter.rar" runtime-name="jee-app-2-wildfly-adapter.rar">
        <fs-archive
                path="/Users/jofisaes/dev/src/jofisaes/java-test-drives/jee7/jeorg-jee-apps/jeorg-jee-app-2-wildfly-adapter/target/jeorg-jee-app-2-wildfly-adapter.rar"/>
    </deployment>
    <deployment name="jee-app-2-wildfly.war" runtime-name="jee-app-2-wildfly.war">
        <fs-archive
                path="/Users/jofisaes/dev/src/jofisaes/java-test-drives/jee7/jeorg-jee-apps/jeorg-jee-app-2-wildfly/target/jeorg-jee-app-2-wildfly.war"/>
    </deployment>
</deployments>
```

This should be automated, so don't add this manually.

## Run Arquillian tests

```bash
jenv local system
sdk use java 11.0.9.hs-adpt
mvn clean install -Parq-wildfly-managed
```

## Run Arquillian tests on Intellij

Use Arquillian Managed, and you should get a screen like this. All options should be the default ones.

![alt text](../jeorg-jee-app-1-wildfly/docs/jeorg-jee-app-1-wildfly-IntelliJ-test-config.png)

## References

### Online

-   [What's in a name? What developers can expect in Jakarta EE 9](https://www.theserverside.com/feature/Whats-in-a-name-What-developers-can-expect-in-Jakarta-EE-9)
-   [@WebService handlers with @HandlerChain](https://tomee.apache.org/examples-trunk/webservice-handlerchain/)
-   [Maven - Generate Jar and War](https://stackoverflow.com/questions/10862980/maven-generate-jar-and-war)
-   [How to use @Resource WebServiceContext injection with Spring's @Transactional](https://stackoverflow.com/questions/5820969/how-to-use-resource-webservicecontext-injection-with-springs-transactional)
-   [28.1 Creating a Simple Web Service and Clients with JAX-WS](https://docs.oracle.com/javaee/7/tutorial/jaxws001.htm)
-   [Create a web service with maven](https://tuttlem.github.io/2015/12/05/create-a-web-service-with-maven.html)
-   [When will I ever need to use @WebServiceRef?](https://stackoverflow.com/questions/15661262/when-will-i-ever-need-to-use-webserviceref)
-   [while starting wildfly 10.1 to work with artemis, jboss.ra.activemq-ra is not installed error persists](https://stackoverflow.com/questions/43179283/while-starting-wildfly-10-1-to-work-with-artemis-jboss-ra-activemq-ra-is-not-in)
-   [WildFly Integration with apache activemq](https://javadev.org/docs/appserv/wildfly/8.2/active-mq/wildfly-activemq-integration-as-application/)
-   [CHAPTER 15. JAVA CONNECTOR ARCHITECTURE (JCA) MANAGEMENT](https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.1/html/configuration_guide/jca_management)
-   [WildFly 9 - A JMS-oriented tutorial](https://gianlucacosta.info/blog/wildfly-jms-tutorial)
-   [dlmiles / full-example-ee7-jca-eis](https://github.com/dlmiles/full-example-ee7-jca-eis)
-   [Deployment Descriptors used In WildFly](https://docs.jboss.org/author/display/WFLY8/Deployment%20Descriptors%20used%20In%20WildFly.html)
-   [JCA Master The Boss - GitHub Demo](https://github.com/fmarchioni/mastertheboss/tree/master/jca-demo)
-   [JCA IronJacamar](http://www.ironjacamar.org/)
-   [JCA Connector](http://www.mastertheboss.com/jboss-frameworks/ironjacamar/create-your-first-jca-connector-tutorial#:~:text=The%20Java%20Connector%20Architecture%20(JCA,)%2C%20database%20and%20messaging%20systems.)
-   [JAXB @XmlRootElement annotation example](https://howtodoinjava.com/jaxb/xmlrootelement-annotation/)
-   [JAX-WS JEE 7](https://docs.oracle.com/javaee/7/tutorial/jaxws.htm)
-   [JAXB JEE 5](https://docs.oracle.com/javaee/5/tutorial/doc/bnbay.html)
-   [JAXB](https://docs.oracle.com/javase/tutorial/jaxb/intro/index.html)
-   [JAXP](https://docs.oracle.com/javase/tutorial/jaxp/intro/index.html)
-   [StAX](https://docs.oracle.com/javase/tutorial/jaxp/stax/index.html)
-   [CDI @RequestScoped](https://openejb.apache.org/examples-trunk/cdi-request-scope/)
-   [Wildfly - Quickstart repo](https://github.com/wildfly/quickstart)
-   [Getting Started Developing Applications Guide - WildFly team Version 20.0.0.Final, 2020-06-05T20:49:23Z](https://docs.wildfly.org/20/Getting_Started_Developing_Applications_Guide.html)
-   [DEVELOPING EJB APPLICATIONS](https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.2/html-single/developing_ejb_applications/index)
-   [Wild Fly Downloads](https://www.wildfly.org/downloads/)

### Books

-   Jendrock, E. Cervera-Navarro, R. Evans, I. (2014). <i>The Java EE 7 Tutorial</i>. (Fifth Edition Volume 1). Addison Wesley
-   Jendrock, E. Cervera-Navarro, R. Evans, I. (2014). <i>The Java EE 7 Tutorial</i>. (Fifth Edition Volume 2). Addison Wesley
- Ćmil, M. (29th December 2014). <i>Java EE 7 Development with WildFly</i>. (First Edition). Packt Publishing
-   Mihalcea, V. (October 2016). <i>High-Performance Java Persistence</i>. (First Edition). Vlad Mihalcea
-   Gonçalves, A. (June 2013). <i>Beginning Java EE 7</i> (First Edition). Apress
-   R. Allen, P. J. Bambara, J. (2014). <i>OCM Java EE 6 Enterprise Architect Exam Guide</i>. (First Edition). McGraw-Hill
-   Gupta, A. (August 2013). <i>Java EE 7 Essentials</i>. (First Edition). O'Reilly
-   Dr Coward, D. (August 2013). <i>Java EE 7 The Big Picture</i>. (First Edition). McGraw-Hill

## Context references

## About me 👨🏽‍💻🚀🏳️‍🌈

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/JEOrgLogo-20.png "João Esperancinha Homepage")](http://joaofilipesabinoesperancinha.nl)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/medium-20.png "Medium")](https://medium.com/@jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/credly-20.png "Credly")](https://www.credly.com/users/joao-esperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=joaofilipesabinoesperancinha.nl&color=6495ED "João Esperancinha Homepage")](https://joaofilipesabinoesperancinha.nl/)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=jesperancinha&style=social "GitHub")](https://github.com/jesperancinha)
[![Twitter Follow](https://img.shields.io/twitter/follow/joaofse?label=João%20Esperancinha&style=social "Twitter")](https://twitter.com/joaofse)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=JEsperancinhaOrg&color=yellow "jesperancinha.org dependencies")](https://github.com/JEsperancinhaOrg)   
[![Generic badge](https://img.shields.io/static/v1.svg?label=Articles&message=Across%20The%20Web&color=purple)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Articles.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Webapp&message=Image%20Train%20Filters&color=6495ED)](http://itf.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=All%20Badges&message=Badges&color=red "All badges")](https://joaofilipesabinoesperancinha.nl/badges)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=red "Project statuses")](https://github.com/jesperancinha/project-signer/blob/master/project-signer-quality/Info.md)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/coursera-20.png "Coursera")](https://www.coursera.org/user/da3ff90299fa9297e283ee8e65364ffb)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/google-apps-20.png "Google Apps")](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)   
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/sonatype-20.png "Sonatype Search Repos")](https://search.maven.org/search?q=org.jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/docker-20.png "Docker Images")](https://hub.docker.com/u/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/stack-overflow-20.png)](https://stackoverflow.com/users/3702839/joao-esperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/reddit-20.png "Reddit")](https://www.reddit.com/user/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/devto-20.png "Dev To")](https://dev.to/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hackernoon-20.jpeg "Hackernoon")](https://hackernoon.com/@jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codeproject-20.png "Code Project")](https://www.codeproject.com/Members/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/github-20.png "GitHub")](https://github.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/bitbucket-20.png "BitBucket")](https://bitbucket.org/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/gitlab-20.png "GitLab")](https://gitlab.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/bintray-20.png "BinTray")](https://bintray.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/free-code-camp-20.jpg "FreeCodeCamp")](https://www.freecodecamp.org/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hackerrank-20.png "HackerRank")](https://www.hackerrank.com/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codeforces-20.png "Code Forces")](https://codeforces.com/profile/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codebyte-20.png "Codebyte")](https://coderbyte.com/profile/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codewars-20.png "CodeWars")](https://www.codewars.com/users/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codepen-20.png "Code Pen")](https://codepen.io/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hacker-news-20.png "Hacker News")](https://news.ycombinator.com/user?id=jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/infoq-20.png "InfoQ")](https://www.infoq.com/profile/Joao-Esperancinha.2/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/linkedin-20.png "LinkedIn")](https://www.linkedin.com/in/joaoesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/xing-20.png "Xing")](https://www.xing.com/profile/Joao_Esperancinha/cv)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/tumblr-20.png "Tumblr")](https://jofisaes.tumblr.com/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/pinterest-20.png "Pinterest")](https://nl.pinterest.com/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/quora-20.png "Quora")](https://nl.quora.com/profile/Jo%C3%A3o-Esperancinha)

## Achievements

[![Oracle Certified Professional, JEE 7 Developer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-ee-7-application-developer-100.png "Oracle Certified Professional, JEE7 Developer")](https://www.credly.com/badges/27a14e06-f591-4105-91ca-8c3215ef39a2)
[![Oracle Certified Professional, Java SE 11 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-se-11-developer-100.png "Oracle Certified Professional, Java SE 11 Programmer")](https://www.credly.com/badges/87609d8e-27c5-45c9-9e42-60a5e9283280)
[![Oracle Certified Professional, Java SE 8 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-se-8-programmer-100.png "Oracle Certified Professional, Java SE 8 Programmer")](https://www.credly.com/badges/92e036f5-4e11-4cff-9935-3e62266d2074)
[![Oracle Certified Associate, Java SE 8 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-associate-java-se-8-programmer-100.png "Oracle Certified Associate, Java SE 8 Programmer")](https://www.credly.com/badges/a206436d-6fd8-4ca1-8feb-38a838446ee7)
[![Oracle Certified Associate, Java SE 7 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-associate-java-se-7-programmer-100.png "Oracle Certified Associate, Java SE 7 Programmer")](https://www.credly.com/badges/f4c6cc1e-cb52-432b-904d-36d266112225)
[![Oracle Certified Junior Associate](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-foundations-associate-java-100.png "Oracle Certified Foundations Associate")](https://www.credly.com/badges/6db92c1e-7bca-4856-9543-0d5ed0182794)
