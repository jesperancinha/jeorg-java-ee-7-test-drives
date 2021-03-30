# jee-mastery-app-2

## Exercise

In this exercise we will go through music related to the power of Chorus and Arias.

Note that this module is attached to project [jee-flash-1](../../jeorg-jee-flash/jeorg-jee-flash-1).

The topics covered will be ther as well.

Topics covered:

1. `JSP`, `JSF`, `Servlet`, `Busines Components`, `Application`, `Applet`, `Decoder.Binary<Lyric2>`, `Decoder.Text<Lyric>`
2. `@ServerEndpoint`, `@OnMessage`
3. `authorization`, `authentication`, `PAM`
4. `LoginContext`, `LoginModule`, `CodeSource`, `Configuration`, `Principal`, `Subject`
5. `<c:out value="${requestScope['javax.servlet.error.exception']}"/>`, `exception`, `exception.getMessage()`
6. `placeholder`, `passthrough`
7. `<error-page>`, `<error-code>`
8. `@Inject`, `setter`, `getter`, `member`
9. `@CookieParam`, `@QueryParam`, `@PathParam`, `@MatrixParam`, `@HeaderParam`, `@FormParam`
10. `@Stateless`, `@TransactionAttribute`, `@PersistenceContext`, `TransactionAttributeType.REQUIRED`, `EntityManager`
11. `JTA`, `RESOURCE_LOCAL`, `@PersistenceContext`, `@SessionScoped`, `@PersistenceContext`, `@ApplicationException`
12. `@IdClass`, `@Embeddable`, `@EmbeddableId`
13. `AttributeConverter`, `@Convert`, `converter`
14. `@ClientEndpoint`, `WebSocketContainer`, `ContainerProvider`, `RemoteEndpoint`
15. `@Resource`, `@Timeout`, `TimerService`, `Timer`, `createSingleActionTimer`
16. `dtype`, `abstract`, `@Entity`, `extends`, `@Table`, `@Column`
17. `UIViewRoot`, `FacesContext`
18. `<shared-cache-mode>ENABLE_SELECTIVE</shared-cache-mode>`, `@Cacheable`
19. `@MappedSuperclass`

### WebSockets

```bash
```

## To install

1. Start Wildfly
2. Run [installModules.sh](./installModules.sh)
3. Stop Wildfly
4. run [setup.sh](./setup.sh)
5. Run wildfly with `-c standalone-full.xml`
6. Start Wildfly
7. Deploy app

## Extra notes

1. We can use POJO's to implement a REST resource. The only requirement is for it top be annotated with at least one @Path

## Create WAR file with the jar command

```bash
cd target/jeorg-jee-mastery-app-2-1.0.0-SNAPSHOT
jar -cvf jee-mastery-app-2-1.0.0-SNAPSHOT.war *
ls WEB-INF/lib
```

## Endpoints

1. [http://localhost:8080/jeorg-jee-mastery-app-2-1.0.0-SNAPSHOT](http://localhost:8080/jeorg-jee-mastery-app-2-1.0.0-SNAPSHOT) / - Main Page

## Curl requests

## Context References

- [Madonna: An Intimate Biography](https://en.wikipedia.org/wiki/Madonna:_An_Intimate_Biography)
- [Royal Albert Hall](https://en.wikipedia.org/wiki/Royal_Albert_Hall)
- [Faun Tour dates](https://faune.de/en/tour/)
- [Luna (Faun album)](https://en.wikipedia.org/wiki/Luna_(Faun_album))
- [This Mortal Coil](https://en.wikipedia.org/wiki/This_Mortal_Coil)
- [Aria Wikipedia](https://en.wikipedia.org/wiki/Aria)
- [Strophic form](https://en.wikipedia.org/wiki/Strophic_form)

<div align="center">
      <a title="Marina - Handmade Heaven" href="https://www.youtube.com/watch?v=GiOGlYjKgX8">
     <img 
          src="https://img.youtube.com/vi/GiOGlYjKgX8/0.jpg" 
          style="width:10%;">
      </a>
      <a title="Josh Groban - You Raise Me Up" href="https://www.youtube.com/watch?v=aJxrX42WcjQ">
     <img 
          src="https://img.youtube.com/vi/aJxrX42WcjQ/0.jpg" 
          style="width:10%;">
      </a>
</div>
<div align="center">
      <a title="Faun - Walpurgisnacht" href="https://www.youtube.com/watch?v=nLgM1QJ3S_I">
     <img 
          src="https://img.youtube.com/vi/nLgM1QJ3S_I/0.jpg" 
          style="width:10%;">
      </a>
      <a title="Faun Duett mit Santiano - Tanz mit mir" href="https://www.youtube.com/watch?v=beXW5s3ZCB4">
     <img 
          src="https://img.youtube.com/vi/beXW5s3ZCB4/0.jpg" 
          style="width:10%;">
      </a>
</div>

<div align="center">
      <a title="Opera gala: the greatest arias from Mozart, Verdi, Rossini and others" href="https://www.youtube.com/watch?v=qXUMqSWpomA">
     <img 
          src="https://img.youtube.com/vi/qXUMqSWpomA/0.jpg" 
          style="width:10%;">
      </a>
      <a title="Kyla La Grange - Cut Your Teeth" href="https://www.youtube.com/watch?v=GINpKSkZawk ">
     <img 
          src="https://img.youtube.com/vi/GINpKSkZawk/0.jpg" 
          style="width:10%;">
      </a>
</div>
<div align="center">
      <a title="Massive Attack - Four Walls | Paradise Circus" href="https://www.youtube.com/watch?v=t4XxJgRihW8">
     <img 
          src="https://img.youtube.com/vi/t4XxJgRihW8/0.jpg" 
          style="width:10%;">
      </a>
      <a title="This mortal coil - Song to the Siren" href="https://www.youtube.com/watch?v=HFWKJ2FUiAQ">
     <img 
          src="https://img.youtube.com/vi/HFWKJ2FUiAQ/0.jpg" 
          style="width:10%;">
      </a>
</div>

<div align="center">
      <a title="Enya - The Book of Days" href="https://www.youtube.com/watch?v=LiBwr4U59EI">
     <img 
          src="https://img.youtube.com/vi/LiBwr4U59EI/0.jpg" 
          style="width:10%;">
      </a>
      <a title="Enya - So I Could Find My Way" href="https://www.youtube.com/watch?v=aLDLpqZdhX0">
     <img 
          src="https://img.youtube.com/vi/aLDLpqZdhX0/0.jpg" 
          style="width:10%;">
      </a>
</div>

<div align="center">
      <a title="Celtic Woman - Tír na nÓg ft. Oonagh" href="https://www.youtube.com/watch?v=dhW1mh7U6-U">
     <img 
          src="https://img.youtube.com/vi/dhW1mh7U6-U/0.jpg" 
          style="width:10%;">
      </a>
      <a title="Sarah Brightman - Scarborough Fair" href="https://www.youtube.com/watch?v=oJLNCTdJKu4">
     <img 
          src="https://img.youtube.com/vi/oJLNCTdJKu4/0.jpg" 
          style="width:10%;">
      </a>
</div>
<div align="center">
      <a title="Evening Star: the Eternal Light - Elvish Melodies from the Motion Score : The Lord of the Rings" href="https://www.youtube.com/watch?v=3bY0XO0vuZA">
     <img 
          src="https://img.youtube.com/vi/3bY0XO0vuZA/0.jpg" 
          style="width:10%;">
      </a>
      <a title="CeeLo Green - Music To My Soul" href="https://www.youtube.com/watch?v=u3-k-5KOduE">
     <img 
          src="https://img.youtube.com/vi/u3-k-5KOduE/0.jpg" 
          style="width:10%;">
      </a>
</div>

## References

### Online

- [Teun-Hakvoort article about WebSockets for NLJUG - 2014/05 in Dutch](https://blogs.infosupport.com/wp-content/uploads/2014/05/Artikel-Websockets-en-Java-Teun-Hakvoort.pdf)
- [Tackling RESOURCE_LOCAL Vs. JTA Under Java EE Umbrella and Payara Server](https://dzone.com/articles/resource-local-vs-jta-transaction-types-and-payara)
- [JPA 101n](https://tomee.apache.org/jpa-concepts.html)
- [Java EE HTML5 WebSockets Encoder and Decoder example](https://www.byteslounge.com/tutorials/java-ee-html5-websockets-encoder-and-decoder-example)
- [42.2 Lock Modes](https://docs.oracle.com/javaee/7/tutorial/persistence-locking002.htm)
- [Locking in JPA](https://www.objectdb.com/java/jpa/persistence/lock)
- [How does LockModeType.OPTIMISTIC work in JPA and Hibernate](https://vladmihalcea.com/hibernate-locking-patterns-how-does-optimistic-lock-mode-work/)
- [JSR 338: JavaTM Persistence API, Version 2.1](https://download.oracle.com/otn-pub/jcp/persistence-2_1-fr-eval-spec/JavaPersistence.pdf?AuthParam=1611180403_428ca418c9306d162b6b4194d54123fe)
- [Difference between Shared Lock and Exclusive Lock](https://www.geeksforgeeks.org/difference-between-shared-lock-and-exclusive-lock/#:~:text=Exclusive%20Lock%20(X)%20%3A&text=Also%20called%20write%20lock.,one%20transaction%20at%20a%20time.)
- [Optimistic vs. Pessimistic locking](https://stackoverflow.com/questions/129329/optimistic-vs-pessimistic-locking)
- [What is isErrorPage attribute in JSP?](https://www.tutorialspoint.com/what-is-iserrorpage-attribute-in-jsp)
- [Error Handler Servlet: how to get exception cause](https://stackoverflow.com/questions/4207586/error-handler-servlet-how-to-get-exception-cause)
- [Optimistic locking and automatic retry](https://enterprisecraftsmanship.com/posts/optimistic-locking-automatic-retry/#:~:text=Pessimistic%20locking%20is%20when%20you,to%20proceed%20with%20the%20update.)
- [Lock Modes](https://docs.oracle.com/javaee/6/tutorial/doc/gkjiu.html)
- [Using the WebSocket API in a Web Application](https://netbeans.apache.org/kb/docs/javaee/maven-websocketapi.html#_sending_binary_data_to_the_endpoint)
- [ServletConfig Interface](https://www.javatpoint.com/servletconfig)
- [JSTL Format Tag fmt:setLocale Example](https://www.codejava.net/java-ee/jstl/jstl-format-tag-setlocale)
- [JViews JSF applications globalization and multicultural support](https://help.perforce.com/visualization/jviews/8.10/jviews-charts810/doc/html/en-US/Content/Visualization/Documentation/JViews/JViews_Charts/_pubskel/ps_usrwebcharts476.html)
- [Creating Durable Subscriptions](https://docs.oracle.com/cd/E19798-01/821-1841/bncgd/index.html#:~:text=To%20delete%20a%20durable%20subscription,unsubscribe(%22MySub%22)%3B)
- [Interface JsonReader](https://docs.oracle.com/javaee/7/api/javax/json/JsonReader.html)
- [How to use Message Selectors to filter messages](https://timjansen.github.io/jarfiller/guide/jms/selectors.xhtml)
- [JPA issue in combo with @SessionScoped](http://tomee-openejb.979440.n4.nabble.com/JPA-issue-in-combo-with-SessionScoped-td4662268.html)
- [JMSContext createContext(int sessionMode)](https://docs.oracle.com/javaee/7/api/javax/jms/ConnectionFactory.html#createContext-int-)
- [JSTL - Core <c:forEach>, <c:forTokens> Tag](https://www.tutorialspoint.com/jsp/jstl_core_foreach_tag.htm)
- [8.8. Transactional Stateful Session Beans](http://www.cs.ait.ac.th/~on/O/oreilly/java-ent/ebeans/ch08_08.htm)
- [Transaction Annotations](http://tomee.apache.org/transaction-annotations.html)
- [EJB - Transactions](https://www.tutorialspoint.com/ejb/ejb_transactions.htm)
- [Programming WebLogic Enterprise JavaBeans](https://docs.oracle.com/cd/E13222_01/wls/docs103/ejb/index.html)
- [CDI : WELD-001408 Unsatisfied dependencies, how to resolve it?](https://stackoverflow.com/questions/22191377/cdi-weld-001408-unsatisfied-dependencies-how-to-resolve-it)
- [The Java EE 6 Tutorial using scopes](https://docs.oracle.com/javaee/6/tutorial/doc/gjbbk.html)
- [JSR 352: Batch Applications for the Java Platform](https://jcp.org/en/jsr/detail?id=352)
- [An Overview of Batch Processing in Java EE 7.0](https://www.oracle.com/technical-resources/articles/java/batch-processing-ee-7.html)
- [CDI @RequestScoped](https://tomee.apache.org/examples-trunk/cdi-request-scope/)
- [An Overview of CDI Events](https://dzone.com/articles/an-overview-of-cdi-events)
- [Using Events in CDI Applications](https://docs.oracle.com/javaee/6/tutorial/doc/gkhic.html)
- [Chapter 2. Concepts](https://docs.jboss.org/cdi/spec/1.0/html/concepts.html)
- [Native CDI Qualifiers: @Any and @Default](https://abhirockzz.wordpress.com/2015/09/27/native-cdi-qualifiers-any-and-default/)
- [The built-in qualifiers @Default and @Any](https://dzone.com/articles/built-qualifiers-default-and)
- [JBoss - Chapter 3. Programming model](https://docs.jboss.org/cdi/spec/1.0/html/implementation.html)
- [Annotation Type Inject](https://docs.oracle.com/javaee/6/api/javax/inject/Inject.html)
- [Dependency Injection, Annotations, and why Java is Better Than you Think it is](https://www.objc.io/issues/11-android/dependency-injection-in-java/)
- [Chapter 37. Partial Deployment Descriptors](https://docs.jboss.org/ejb3/docs/tutorial/1.0.7/html/Partial_deployment_descriptor.html)
- [Deployment Descriptor Schema and Document Type Definitions Reference](https://docs.oracle.com/cd/E11035_01/wls100/ejb/DD_defs_reference.html)
- [Java EE 7 Deployment Descriptors](https://antoniogoncalves.org/2013/06/04/java-ee-7-deployment-descriptors/)
- [Fusion Middleware Developing Web Applications, Servlets, and JSPs for Oracle WebLogic Server](https://docs.oracle.com/cd/E24329_01/web.1211/e21049/web_xml.htm#WBAPP502)
- [Database Authentication](https://docs.jboss.org/author/display/WFLY/Database%20Authentication%20Migration.html)
- [Securing a web application](https://openliberty.io/guides/security-intro.html)
- [Connect JDBC driver as Wildfly module](https://javadev.org/appservers/wildfly/8.2/jdbc/postgresql/)
- [service-java-notificacoes](https://github.com/fas-alves/service-java-notificacoes)
- [18.2. ROLE-BASED SECURITY IN APPLICATIONS](https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/6.4/html/development_guide/sect-role-based_security_in_applications)
- [What Are Realms, Users, Groups, and Roles?](https://docs.oracle.com/javaee/6/tutorial/doc/bnbxj.html)
- [Examples: Securing Enterprise Beans](https://javaee.github.io/tutorial/security-javaee003.html)
- [WS-Security](https://en.wikipedia.org/wiki/WS-Security)
- [JSTL - Core <fmt:message> Tag](https://www.tutorialspoint.com/jsp/jstl_format_message_tag.htm)
- [JSTL - Core <fmt:bundle> Tag](https://www.tutorialspoint.com/jsp/jstl_format_bundle_tag.htm)
- [JSP - Standard Tag Library (JSTL) Tutorial](https://www.tutorialspoint.com/jsp/jsp_standard_tag_library.htm)
- [JSF 2 Templating with Facelets example](https://mkyong.com/jsf2/jsf-2-templating-with-facelets-example/)
- [23.4 About CDI Managed Beans](https://docs.oracle.com/javaee/7/tutorial/cdi-basic004.htm)
- [JSF Navigation Rule Example Tutorial](https://www.journaldev.com/7042/jsf-navigation-rule-example-tutorial)
- [Caesar Cipher Encrypt & Decrypt](https://md5decrypt.net/en/Caesar/)
- [18 Java API for WebSocket](http://www.devdoc.net/javaxe/JavaEE-7u2/docs/javaee-tutorial/doc/websocket.htm)
- [WebSocket Client API in Java EE 7](https://dzone.com/articles/websocket-client-api-in-java-ee-7)
- [Java EE 7: Building Web Applications with WebSocket, JavaScript and HTML5](oracle.com/webfolder/technetwork/tutorials/obe/java/HomeWebsocket/WebsocketHome.html#:~:text=By%20maintaining%20a%20constant%20connection,into%20Java%20EE%207%20applications.)
- [Creating Custom JAX-RS MessageBodyReader](https://memorynotfound.com/jax-rs-messagebodyreader/)
- [Creating Custom JAX-RS MessageBodyWriter](https://memorynotfound.com/jax-rs-messagebodywriter/)
- [Chapter 4. RESTful Web Services](https://www.oreilly.com/library/view/java-ee-7/9781449370589/ch04.html)
- [XMLHttpRequest.response](https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/response)
- [29.2 Creating a RESTful Root Resource Class](https://docs.oracle.com/javaee/7/tutorial/jaxrs002.htm)
- [32.7 The Lifecycles of Enterprise Beans](https://docs.oracle.com/javaee/7/tutorial/ejb-intro007.htm)
- [Annotation Type Path](https://docs.oracle.com/javaee/7/api/javax/ws/rs/Path.html)
- [jsp:useBean action tag](https://www.javatpoint.com/jsp-useBean-action)
- [How can I print error stack trace in JSP page?](https://stackoverflow.com/questions/8135980/how-can-i-print-error-stack-trace-in-jsp-page/8136065)
- [Why is a JSP converted to Servlet?](https://stackoverflow.com/questions/42203449/why-is-a-jsp-converted-to-servlet)
- [web.xml Deployment Descriptor Elements](https://docs.oracle.com/cd/E13222_01/wls/docs81/webapp/web_xml.html#1039330)
- [Web.xml Filter Mapping in JSP Servlet with Example](https://www.guru99.com/jsp-filter.html)
- [Define and Map Filters](https://help.perforce.com/hydraexpress/4.3.0/html/rwsfexpservletug/4-8.html#:~:text=The%20filter%20element%20of%20a,for%20this%20particular%20filter%20instance.)
- [How do I define a filter using @WebFilter annotation?](https://kodejava.org/how-do-i-define-a-filter-using-webfilter-annotation/)
- [URL Rewriting in WSDL and XML Schema](https://membrane-soa.org/service-proxy-doc/4.2/url-rewriting-wsdl.htm)
- [Web Services Custom Resource (prior to V3.3)](https://hub.verj.io/ebase/doc/WebServicesCustomResource.htm#Session_Management)
- [Auth0 REST vs SOAP - Building Modern Applications](https://auth0.com/learn/rest-vs-soap/)
- [O'Reilly SOAP session scope](https://www.oreilly.com/library/view/apache-axis2-web/9781849511568/ch10s05.html)
- [WebLogic Communications Services Gatekeeper Application Developer's Guide](https://docs.oracle.com/cd/E50778_01/doc.60/e50769/app_sessmgr.htm#SGAPP138)
- [InterSystems SOAP Session Management](https://docs.intersystems.com/irislatest/csp/docbook/DocBook.UI.Page.cls?KEY=GSOAP_SESSIONS)
- [SOAP request from command line using curl](https://browse-tutorials.com/tutorial/soap-request-command-line-using-curl)
- [Session Management in Java – HttpServlet, Cookies, URL Rewriting](https://www.journaldev.com/1907/java-session-management-servlet-httpsession-url-rewriting)
- [URL Rewriting](https://www.javatpoint.com/url-rewriting-in-session-tracking)
- [PublisherSubscriberTest.java](https://github.com/WASdev/sample.javaee7.jms/blob/master/src/main/java/com/ibm/ws/jms20/samples/PublisherSubscriberTest.java)
- [Guaranteed Delivery using JMS Message Acknowledgement](https://jstobigdata.com/jms/guaranteed-delivery-using-jms-message-acknowledgement/)
- [WildFly 9 - A JMS-oriented tutorial](https://gianlucacosta.info/blog/wildfly-jms-tutorial)
- [Transaction management: EJB3 vs Spring](https://blog.frankel.ch/transaction-management-ejb3-vs-spring/)
- [EJB passivation and activation example](https://www.javacodegeeks.com/2013/08/ejb-passivation-and-activation-example.html)
- [@Resource injection target is invalid. Only setter methods are allowed](https://stackoverflow.com/questions/18019947/resource-injection-target-is-invalid-only-setter-methods-are-allowed)
- [http://tomee.apache.org/testing-transactions-example.html](http://tomee.apache.org/testing-transactions-example.html)

### Books

- Jendrock, E. Cervera-Navarro, R. Evans, I. (2014). <i>The Java EE 7 Tutorial</i>. (Fifth Edition Volume 1). Addison Wesley
- Jendrock, E. Cervera-Navarro, R. Evans, I. (2014). <i>The Java EE 7 Tutorial</i>. (Fifth Edition Volume 2). Addison Wesley
- Ćmil, M. (29th December 2014). <i>Java EE 7 Development with WildFly</i>. (First Edition). Packt Publishing
- Mihalcea, V. (October 2016). <i>High-Performance Java Persistence</i>. (First Edition). Vlad Mihalcea
- Gonçalves, A. (June 2013). <i>Beginning Java EE 7</i> (First Edition). Apress
- R. Allen, P. J. Bambara, J. (2014). <i>OCM Java EE 6 Enterprise Architect Exam Guide</i>. (First Edition). McGraw-Hill
- Gupta, A. (August 2013). <i>Java EE 7 Essentials</i>. (First Edition). O'Reilly
- Dr Coward, D. (August 2013). <i>Java EE 7 The Big Picture</i>. (First Edition). McGraw-Hill

## About me 👨🏽‍💻🚀

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/JEOrgLogo-20.png "João Esperancinha Homepage")](http://joaofilipesabinoesperancinha.nl)
[![Twitter Follow](https://img.shields.io/twitter/follow/joaofse?label=João%20Esperancinha&style=social "Twitter")](https://twitter.com/joaofse)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=jesperancinha&style=social "GitHub")](https://github.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/medium-20.png "Medium")](https://medium.com/@jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/google-apps-20.png "Google Apps")](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/sonatype-20.png "Sonatype Search Repos")](https://search.maven.org/search?q=org.jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/docker-20.png "Docker Images")](https://hub.docker.com/u/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/stack-overflow-20.png)](https://stackoverflow.com/users/3702839/joao-esperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/reddit-20.png "Reddit")](https://www.reddit.com/user/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/acclaim-20.png "Acclaim")](https://www.youracclaim.com/users/joao-esperancinha/badges)
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
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/coursera-20.png "Coursera")](https://www.coursera.org/user/da3ff90299fa9297e283ee8e65364ffb)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hacker-news-20.png "Hacker News")](https://news.ycombinator.com/user?id=jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/infoq-20.png "InfoQ")](https://www.infoq.com/profile/Joao-Esperancinha.2/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Articles&message=Across%20The%20Web&color=purple)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Articles.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=Time%20Disruption%20Studios&color=6495ED)](http://tds.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=Image%20Train%20Filters&color=6495ED)](http://itf.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=MancalaJE&color=6495ED)](http://mancalaje.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=All%20Badges&message=Badges&color=red)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Badges.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=red)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Status.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20Android&color=yellow)](https://github.com/JEsperancinhaOrg/itf-chartizate-android)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20Java&color=yellow)](https://github.com/JEsperancinhaOrg/itf-chartizate-modules/tree/master/itf-chartizate-java)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20API&color=yellow)](https://github.com/JEsperancinhaOrg/itf-chartizate/tree/master/itf-chartizate-api)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Markdowner%20Core&color=yellow)](https://github.com/jesperancinha/markdowner/tree/master/markdowner-core)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Markdowner%20Filter&color=yellow)](https://github.com/jesperancinha/markdowner/tree/master/markdowner-filter)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/linkedin-20.png "LinkedIn")](https://www.linkedin.com/in/joaoesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/xing-20.png "Xing")](https://www.xing.com/profile/Joao_Esperancinha/cv)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/tumblr-20.png "Tumblr")](https://jofisaes.tumblr.com/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/pinterest-20.png "Pinterest")](https://nl.pinterest.com/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/quora-20.png "Quora")](https://nl.quora.com/profile/Jo%C3%A3o-Esperancinha)

## Achievements

[![Oracle Certified Professional, JEE 7 Developer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-ee-7-application-developer-100.png "Oracle Certified Professional, JEE7 Developer")](https://www.youracclaim.com/badges/27a14e06-f591-4105-91ca-8c3215ef39a2/public_url)
[![Oracle Certified Professional, Java SE 11 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-se-11-developer-100.png "Oracle Certified Professional, Java SE 11 Programmer")](https://www.youracclaim.com/badges/87609d8e-27c5-45c9-9e42-60a5e9283280/public_url)
[![Oracle Certified Professional, Java SE 8 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-se-8-programmer-100.png "Oracle Certified Professional, Java SE 8 Programmer")](https://www.youracclaim.com/badges/92e036f5-4e11-4cff-9935-3e62266d2074/public_url)
[![Oracle Certified Associate, Java SE 8 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-associate-java-se-8-programmer-100.png "Oracle Certified Associate, Java SE 8 Programmer")](https://www.youracclaim.com/badges/a206436d-6fd8-4ca1-8feb-38a838446ee7/public_url)
[![Oracle Certified Associate, Java SE 7 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-associate-java-se-7-programmer-100.png "Oracle Certified Associate, Java SE 7 Programmer")](https://www.youracclaim.com/badges/f4c6cc1e-cb52-432b-904d-36d266112225/public_url)
[![Oracle Certified Junior Associate](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-foundations-associate-java-100.png "Oracle Certified Foundations Associate")](https://www.youracclaim.com/badges/6db92c1e-7bca-4856-9543-0d5ed0182794/public_url)
