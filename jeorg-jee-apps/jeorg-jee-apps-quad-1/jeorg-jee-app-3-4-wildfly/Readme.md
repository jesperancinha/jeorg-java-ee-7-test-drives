# jee-app-3-4-wildfly History of the United Kingdom

---

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/java-50.png "Java")](https://www.oracle.com/nl/java/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/lombok-50.png "Lombok")](https://projectlombok.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/openjdk-50.png "OpenJDK")](https://openjdk.java.net/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/sdk-man-50.png "SdkMAN!")](https://sdkman.io/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/wild-fly-50.png "WildFly")](https://www.wildfly.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/arquillian-50.png "Arquillian")](https://github.com/arquillian)

---

## Exercise

The apps under [jee-apps](../..), cover lots of topics. For this app we cover:

1.  `<job`, `<step`, `<chunk`, `<end on`, `AbstractItemReader`, `AbstractItemWriter`, `ItemProcessor`, `@Named`
2.  `BatchRuntime`, `JobOperator`, `getRunningExecutions`, `getJobExecution`, `getBatchStatus`
3.  `@RequestScoped`, `@SessionScoped`, `@ApplicationScoped`

## Test Endpoints

1.  http://localhost:8080/jeorg-jee-app-3-4-wildfly-1.0.0-SNAPSHOT/history/victoria/cooking
2.  http://localhost:8080/jeorg-jee-app-3-4-wildfly-1.0.0-SNAPSHOT/history/victoria/cooking/stop
3.  http://localhost:8080/jeorg-jee-app-3-4-wildfly-1.0.0-SNAPSHOT/monarchsrequest.xhtml
4.  http://localhost:8080/jeorg-jee-app-3-4-wildfly-1.0.0-SNAPSHOT/monarchssession.xhtml
5.  http://localhost:8080/jeorg-jee-app-3-4-wildfly-1.0.0-SNAPSHOT/monarchsapplication.xhtml

### GET / Browser tests

For all of these pages, please pick a user from the table below and login. You can always log in via `admin`/`admin`
, `username`/`password` combination:

### POST requests

-

### WebSockets

## Run Arquillian tests

```bash
jenv local system
sdk use java 11.0.9.hs-adpt
mvn clean install -Parq-wildfly-managed
```

## WildFly configuration

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

1.  [setup.sh](setup.sh)

```bash
./setup.sh
```

2.  [add-user.sh](../../wildfly-16.0.0.Final/bin/add-user.sh)

3.  <b>ALWAYS start WildFly this way:</b>

```bash
./standalone.sh -c standalone-full.xml
```

4.  [installModules.sh](./installModules.sh)

```bash
./installModules.sh
```

## PostgreSQL

For this module, you'll need a ready available database. We make our security tests with a running database. It cannot be done with H2 because of WilflyInitialization and because we want to see records being affected in the database

Please install a compatible version to your system via [postgres-postgresql-downloads](https://www.enterprisedb.com/downloads/postgres-postgresql-downloads).

Also make sure your postgres default user has password admin/admin.

Then we need to install the adapter:

```bash
cd ../../wildfly-16.0.0.Final/modules
wget  https://repo1.maven.org/maven2/org/postgresql/postgresql/42.2.18/postgresql-42.2.18.jar
rm -r ../modules/org/postgresql
rm -r ../modules/postgresql
./jboss-cli.sh -c --command="module add --name=postgresql --resources=postgresql-42.2.18.jar"
```

A file like this will show up in your installation [module.xml](../../wildfly-16.0.0.Final/modules/postgresql/main/module.xml):

```xml
<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.0" name="postgresql">
    <resources>
        <resource-root path="postgresql-9.4-1201.jdbc41.jar"/>
    </resources>

    <dependencies>
        <module name="javax.api"/>
        <module name="javax.transaction.api"/>
    </dependencies>
</module>
```

## Differences between NONE, INTEGRAL and CONFIDENTIAL  guarantees

1.  NONE

```xml

<user-data-constraint>
    <transport-guarantee>NONE</transport-guarantee>
</user-data-constraint>
```

This is a `no worries` configuration where data is exchanged in plain sight. Data is thus exposed to redirection and MITM (Man In The Middle) attacks.

2.  INTEGRAL

```xml

<user-data-constraint>
    <transport-guarantee>INTEGRAL</transport-guarantee>
</user-data-constraint>
```

For this configuration, certificates need to be installed in the client. If we go to http://localhost:8080/jeorg-jee-app-3-2-wildfly-1.0.0-SNAPSHOT/kingsPageAction.xhtml as an example, we are immediately redirected to https://localhost:8443/jeorg-jee-app-3-2-wildfly-1.0.0-SNAPSHOT/kingsPageAction.xhtml. We are
now trying a secure connection SSL/TLS. Since we do not have a right certificate at the moment, we won't be able to check the page. This is a check for the integrity of the message. This means that if the data is changed in transit, that will be detected and the message will be rejected.

3.  CONFIDENTIAL

```xml

<user-data-constraint>
    <transport-guarantee>CONFIDENTIAL</transport-guarantee>
</user-data-constraint>
```

For this configuration, certificates need to be installed in the client. If we go to http://localhost:8080/jeorg-jee-app-3-2-wildfly-1.0.0-SNAPSHOT/kingsPageAction.xhtml as an example, we are immediately redirected to https://localhost:8443/jeorg-jee-app-3-2-wildfly-1.0.0-SNAPSHOT/kingsPageAction.xhtml. We are
now trying a secure connection SSL/TLS. Since we do not have a right certificate at the moment, we won't be able to check the page. This is a check for the confidentiality of the message. This means that it is not possible to check the data in transit. Only the receiver can decrypt the message and
read it.

--- 

In both previous cases, without the correct certificate installation, your browser should alert you of a potential unsafe website like this:

![alt text](./docs/jeorg-jee-app-3-2-wildfly-unsafe.png)

### A few extra notes

1.  Web Applications can:
    1.  Guarantee that data cannot be modified in transit
    2.  Guarantee that data remains confidential in transit

2.  Java Authentication and Authorization services can:
    1.  Verify identity claims
    2.  Verify authorization claims

3.  WS-Security supports these security credential types:
    1.  X.509 certificates
    2.  Kerberos tickets
    3.  User ID/Password credentials
    4.  SAML Assertions
    5.  custom-defined tokens

## Context References

-   [Ballettes of Foie Gras à l'Impériale](https://www.historicfood.com/Bllate.htm)
-   [Queen Victoria](https://en.wikipedia.org/wiki/Queen_Victoria)
-   [List of British monarchs by longevity](https://en.wikipedia.org/wiki/List_of_British_monarchs_by_longevity)
-   [List of British monarchs](https://en.wikipedia.org/wiki/List_of_British_monarchs)
-   [List of monarchs of the Netherlands](https://en.wikipedia.org/wiki/List_of_monarchs_of_the_Netherlands)
-   [Monarchy of the Netherlands](https://en.wikipedia.org/wiki/Monarchy_of_the_Netherlands)
-   [Palace of Valsain](https://en.wikipedia.org/wiki/Palace_of_Valsain)
-   [House of Trastámara](https://en.wikipedia.org/wiki/House_of_Trast%C3%A1mara)
-   [List of Spanish monarchs](https://en.wikipedia.org/wiki/List_of_Spanish_monarchs)
-   [John I of Portugal](https://en.wikipedia.org/wiki/John_I_of_Portugal)
-   [History of Portugal](https://en.wikipedia.org/wiki/History_of_Portugal)
-   [ABBA](https://nl.wikipedia.org/wiki/ABBA)
-   [List of Portuguese monarchs](https://en.wikipedia.org/wiki/List_of_Portuguese_monarchs)

<div align="center">
      <a title="The Very Elaborate Way Queen Victoria Had Her Eggs | Royal Upstairs Downstairs | Real Royalty" href="https://www.youtube.com/watch?v=p4HKB0NqsWg">
     <img 
          src="https://img.youtube.com/vi/p4HKB0NqsWg/0.jpg" 
          style="width:10%;">
      </a>
</div>

## References

### Online

-   [JSR 352: Batch Applications for the Java Platform](https://jcp.org/en/jsr/detail?id=352)
-   [An Overview of Batch Processing in Java EE 7.0](https://www.oracle.com/technical-resources/articles/java/batch-processing-ee-7.html)
-   [CDI @RequestScoped](https://tomee.apache.org/examples-trunk/cdi-request-scope/)
-   [An Overview of CDI Events](https://dzone.com/articles/an-overview-of-cdi-events)
-   [Using Events in CDI Applications](https://docs.oracle.com/javaee/6/tutorial/doc/gkhic.html)
-   [Chapter 2.  Concepts](https://docs.jboss.org/cdi/spec/1.0/html/concepts.html)
-   [Native CDI Qualifiers: @Any and @Default](https://abhirockzz.wordpress.com/2015/09/27/native-cdi-qualifiers-any-and-default/)
-   [The built-in qualifiers @Default and @Any](https://dzone.com/articles/built-qualifiers-default-and)
-   [JBoss - Chapter 3.  Programming model](https://docs.jboss.org/cdi/spec/1.0/html/implementation.html)
-   [Annotation Type Inject](https://docs.oracle.com/javaee/6/api/javax/inject/Inject.html)
-   [Dependency Injection, Annotations, and why Java is Better Than you Think it is](https://www.objc.io/issues/11-android/dependency-injection-in-java/)
-   [Chapter 37. Partial Deployment Descriptors](https://docs.jboss.org/ejb3/docs/tutorial/1.0.7/html/Partial_deployment_descriptor.html)
-   [Deployment Descriptor Schema and Document Type Definitions Reference](https://docs.oracle.com/cd/E11035_01/wls100/ejb/DD_defs_reference.html)
-   [Java EE 7 Deployment Descriptors](https://antoniogoncalves.org/2013/06/04/java-ee-7-deployment-descriptors/)
-   [Fusion Middleware Developing Web Applications, Servlets, and JSPs for Oracle WebLogic Server](https://docs.oracle.com/cd/E24329_01/web.1211/e21049/web_xml.htm#WBAPP502)
-   [Database Authentication](https://docs.jboss.org/author/display/WFLY/Database%20Authentication%20Migration.html)
-   [Securing a web application](https://openliberty.io/guides/security-intro.html)
-   [Connect JDBC driver as Wildfly module](https://javadev.org/appservers/wildfly/8.2/jdbc/postgresql/)
-   [service-java-notificacoes](https://github.com/fas-alves/service-java-notificacoes)
-   [18.2. ROLE-BASED SECURITY IN APPLICATIONS](https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/6.4/html/development_guide/sect-role-based_security_in_applications)
-   [What Are Realms, Users, Groups, and Roles?](https://docs.oracle.com/javaee/6/tutorial/doc/bnbxj.html)
-   [Examples: Securing Enterprise Beans](https://javaee.github.io/tutorial/security-javaee003.html)
-   [WS-Security](https://en.wikipedia.org/wiki/WS-Security)
-   [JSTL - Core <fmt:message> Tag](https://www.tutorialspoint.com/jsp/jstl_format_message_tag.htm)
-   [JSTL - Core <fmt:bundle> Tag](https://www.tutorialspoint.com/jsp/jstl_format_bundle_tag.htm)
-   [JSP - Standard Tag Library (JSTL) Tutorial](https://www.tutorialspoint.com/jsp/jsp_standard_tag_library.htm)
-   [JSF 2 Templating with Facelets example](https://mkyong.com/jsf2/jsf-2-templating-with-facelets-example/)
-   [23.4 About CDI Managed Beans](https://docs.oracle.com/javaee/7/tutorial/cdi-basic004.htm)
-   [JSF Navigation Rule Example Tutorial](https://www.journaldev.com/7042/jsf-navigation-rule-example-tutorial)
-   [Caesar Cipher Encrypt & Decrypt](https://md5decrypt.net/en/Caesar/)
-   [18 Java API for WebSocket](http://www.devdoc.net/javaxe/JavaEE-7u2/docs/javaee-tutorial/doc/websocket.htm)
-   [WebSocket Client API in Java EE 7](https://dzone.com/articles/websocket-client-api-in-java-ee-7)
-   [Java EE 7: Building Web Applications with WebSocket, JavaScript and HTML5](oracle.com/webfolder/technetwork/tutorials/obe/java/HomeWebsocket/WebsocketHome.html#:~:text=By%20maintaining%20a%20constant%20connection,into%20Java%20EE%207%20applications.)
-   [Creating Custom JAX-RS MessageBodyReader](https://memorynotfound.com/jax-rs-messagebodyreader/)
-   [Creating Custom JAX-RS MessageBodyWriter](https://memorynotfound.com/jax-rs-messagebodywriter/)
-   [Chapter 4.  RESTful Web Services](https://www.oreilly.com/library/view/java-ee-7/9781449370589/ch04.html)
-   [XMLHttpRequest.response](https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/response)
-   [29.2 Creating a RESTful Root Resource Class](https://docs.oracle.com/javaee/7/tutorial/jaxrs002.htm)
-   [32.7 The Lifecycles of Enterprise Beans](https://docs.oracle.com/javaee/7/tutorial/ejb-intro007.htm)
-   [Annotation Type Path](https://docs.oracle.com/javaee/7/api/javax/ws/rs/Path.html)
-   [jsp:useBean action tag](https://www.javatpoint.com/jsp-useBean-action)
-   [How can I print error stack trace in JSP page?](https://stackoverflow.com/questions/8135980/how-can-i-print-error-stack-trace-in-jsp-page/8136065)
-   [Why is a JSP converted to Servlet?](https://stackoverflow.com/questions/42203449/why-is-a-jsp-converted-to-servlet)
-   [web.xml Deployment Descriptor Elements](https://docs.oracle.com/cd/E13222_01/wls/docs81/webapp/web_xml.html#1039330)
-   [Web.xml Filter Mapping in JSP Servlet with Example](https://www.guru99.com/jsp-filter.html)
-   [Define and Map Filters](https://help.perforce.com/hydraexpress/4.3.0/html/rwsfexpservletug/4-8.html#:~:text=The%20filter%20element%20of%20a,for%20this%20particular%20filter%20instance.)
-   [How do I define a filter using @WebFilter annotation?](https://kodejava.org/how-do-i-define-a-filter-using-webfilter-annotation/)
-   [URL Rewriting in WSDL and XML Schema](https://membrane-soa.org/service-proxy-doc/4.2/url-rewriting-wsdl.htm)
-   [Web Services Custom Resource (prior to V3.3)](https://hub.verj.io/ebase/doc/WebServicesCustomResource.htm#Session_Management)
-   [Auth0 REST vs SOAP - Building Modern Applications](https://auth0.com/learn/rest-vs-soap/)
-   [O'Reilly SOAP session scope](https://www.oreilly.com/library/view/apache-axis2-web/9781849511568/ch10s05.html)
-   [WebLogic Communications Services Gatekeeper Application Developer's Guide](https://docs.oracle.com/cd/E50778_01/doc.60/e50769/app_sessmgr.htm#SGAPP138)
-   [InterSystems SOAP Session Management](https://docs.intersystems.com/irislatest/csp/docbook/DocBook.UI.Page.cls?KEY=GSOAP_SESSIONS)
-   [SOAP request from command line using curl](https://browse-tutorials.com/tutorial/soap-request-command-line-using-curl)
-   [Session Management in Java – HttpServlet, Cookies, URL Rewriting](https://www.journaldev.com/1907/java-session-management-servlet-httpsession-url-rewriting)
-   [URL Rewriting](https://www.javatpoint.com/url-rewriting-in-session-tracking)
-   [PublisherSubscriberTest.java](https://github.com/WASdev/sample.javaee7.jms/blob/master/src/main/java/com/ibm/ws/jms20/samples/PublisherSubscriberTest.java)
-   [Guaranteed Delivery using JMS Message Acknowledgement](https://jstobigdata.com/jms/guaranteed-delivery-using-jms-message-acknowledgement/)
-   [WildFly 9 - A JMS-oriented tutorial](https://gianlucacosta.info/blog/wildfly-jms-tutorial)
-   [Transaction management: EJB3 vs Spring](https://blog.frankel.ch/transaction-management-ejb3-vs-spring/)
-   [EJB passivation and activation example](https://www.javacodegeeks.com/2013/08/ejb-passivation-and-activation-example.html)
-   [@Resource injection target is invalid. Only setter methods are allowed](https://stackoverflow.com/questions/18019947/resource-injection-target-is-invalid-only-setter-methods-are-allowed)
-   [http://tomee.apache.org/testing-transactions-example.html](http://tomee.apache.org/testing-transactions-example.html)

### Books

-   Jendrock, E. Cervera-Navarro, R. Evans, I. (2014). <i>The Java EE 7 Tutorial</i>. (Fifth Edition Volume 1). Addison Wesley
-   Jendrock, E. Cervera-Navarro, R. Evans, I. (2014). <i>The Java EE 7 Tutorial</i>. (Fifth Edition Volume 2). Addison Wesley
- Ćmil, M. (29th December 2014). <i>Java EE 7 Development with WildFly</i>. (First Edition). Packt Publishing
-   Mihalcea, V. (October 2016). <i>High-Performance Java Persistence</i>. (First Edition). Vlad Mihalcea
-   Gonçalves, A. (June 2013). <i>Beginning Java EE 7</i> (First Edition). Apress
-   R. Allen, P. J. Bambara, J. (2014). <i>OCM Java EE 6 Enterprise Architect Exam Guide</i>. (First Edition). McGraw-Hill
-   Gupta, A. (August 2013). <i>Java EE 7 Essentials</i>. (First Edition). O'Reilly
-   Dr Coward, D. (August 2013). <i>Java EE 7 The Big Picture</i>. (First Edition). McGraw-Hill

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
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=red "Project statuses")](https://github.com/jesperancinha/project-signer/blob/master/project-signer-quality/Build.md)
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
