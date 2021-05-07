# jee-mastery-app-1

## Exercise

In this exercise we will go through music that one way or the other, has been involved in PRIDE events. Topics covered:

1. `<h:panelGrid`, `<c:forEach`, `<h:outputLabel`, `<h:inputText`
2. `@SessionScoped`, `@Named`, `@Local`, `@LocalBean`, `@Stateless`
3. `@Transactional`, `@RequestScoped`, `@Dependent`, `SessionScoped`, `Serializable`
4. `@Inject`, `setter`, `getter`
5. `@MessageDriven`, ` @ActivationConfigProperty`, `acknowledgeMode`, `destinationType`, `destination`, `Topic`
6. `ApplicationException`, `interface`, `rollback`, `@SessionScoped`, `@Named`,
7. `@TransactionAttribute`, `TransactionAttributeType.REQUIRED`, `TransactionManagementType.CONTAINER`, `@TransactionManagement`
8. `ExternalContext`, `redirect`, `FacesContext`, `getCurrentInstance`
9. `jar -cvf jee-mastery-app-1-1.0.0-SNAPSHOT.war *`
10. `xmlns="http://www.w3.org/1999/xhtml"`, `xmlns:h="http://java.sun.com/jsf/html`, `xmlns:ui="http://java.sun.com/jsf/facelets"`, `xmlns:pt="http://xmlns.jcp.org/jsf/passthrough"` `xmlns:f="http://xmlns.jcp.org/jsf/core"` `xmlns:jsf="http://xmlns.jcp.org/jsf"`
11. `JsonGenerator`, `Json`. `createGenerator`, `JsonArrayBuilder`, `createArrayBuilder`, `createObjectBuilder`
12. `@GET`, `@HEAD`
13. `Serializable`, ` @TransactionAttribute`, `TransactionAttributeType.REQUIRES_NEW`, `@IdClass`, `@Id`, `@Identity`, `@Column`, `@NonNull`
14. `@Embeddable`, `@Entity`, `@Table`, `@Embedded`, `@EmbeddedId`, `@IdClass`
15. `createDurableConsumer`, `receive`, `ObjectMessage`
16. `@Singleton`,  `@Schedule`, `second`, `minute`, `hour`, `month`, `dayOfMonth`, `dayOfWeek`, `year`, `timezone`, `info`, `persistent`
17. `HttpServletRequest`, `HttpServletResponse`, `@WebServlet`, `service`, `doGet`
18. `http://java.sun.com/jsp/jstl/sql`, `<sql:setDataSource`, `<sql:query`
19. `JspWriterImpl`, `out`, `<% %>`, `<%= %>`
20. `<f:view locale="de_DE">`, `<f:loadBundle basename="messages" var="msg"/>`
21. `<application>`, `<locale-config>`, `<default-locale>`, `<resource-bundle>`,` <base-name>`, `<h:outputText value="#{bundle['title']}"/>`
22. `<servlet>`, `<init-param>`, `<param-name>`, `<param-value>`, `ServletConfig`, `ServletContext`
23. `@AccessTimeout(0)`, `@AccessTimeout(-1)`, `@AccessTimeout(1)`
24. `ManagedExecutorService`, `submit`
25. `@WebServlet`, `<%@ page isErrorPage = "true" %>`, `<error-page>`, `<exception-type>`, `<location>`, `<error-code>`
26. `setMaxAge`, `Cookie`, `setMaxAge(0)`, `setMaxAge(-1)`, `setMaxAge(5)`, `setMaxAge(10)`
27. `AttributeConverter`, `@TransactionManagement`, `@Stateless`, `@SessionScoped`, `persist`, `@Entityt`, `@Column`, `@Id`
28. `Javascript` `Uint16Array`, `@ServerEndpoint`, `@OnMessage`, `String`, `ByteBuffer`, `PongMessage`
29. `@HttpMethodConstraint`, `@ServletSecurity`, `httpMethodConstraints`, `rolesAllowed`, `j_security_check`, `j_username`, `j_password`, `@WebServlet`, `@Override`, `doPost`, `doGet`
30. `@Version`, `LockModeType.PESSIMISTIC_WRITE`. `LockModeType.OPTIMISTIC`, `LockModeType.NONE`, `persist`
31. `<h:commandButton`, `actionListener`, `action`, `@Named`, `@SessionScoped`
32. `@ApplicationScoped`, `@Named`, `@RequestScoped`, `@SessionScoped`, `@ManagedBean`, `@ViewScoped`, `@Inject`
33. `ReadListener`, `AsyncContext`. `HttpServletResponse`, `ServletInputStream`, `onDataAvailable`, `onAllDataRead`, `onError`, `setReadListener`, `getInputStream`
34. `@ManagedProperty`, `@ManagedBean`, `navigation-rule`, `from-view-id`, `navigation-case`, `from-action`, `from-outcome`, `to-view-id`
35. `ManagedTaskListener`, `ManagedExecutorService`, `ManagedTask`
36. `ConnectionFactory`, `Queue`, `Connection`, `Session`, `Message`, `MessageProducer`, `@MessageDriven`, `@ActivationConfigProperty`
37. `EJBContext`, `EntityManager`, `UserTransaction`, `begin`, `commit`, `setRollbackOnly`
38. `AbstractBatchlet`, `ItemProcessor`, `AbstractItemReader`, `AbstractItemWriter`
39. `@Resources`, `@Resource`
40. `JAXBContext`, `marshal`, `unmarshal`, `ValidationEventHandler`

### WebSockets

```bash
curl --include --no-buffer --header "Connection: Upgrade" --header "Upgrade: websocket" --header "Host: localhost:8080" --header "Origin: http://localhost:8080" --header "Sec-WebSocket-Key: SomeKey==" --header "Sec-WebSocket-Version: 13" http://localhost:8080/jeorg-jee-mastery-app-1-1.0.0-SNAPSHOT/lyricsreceiver
```

## Extra notes

1. We can use POJO's to implement a REST resource. The only requirement is for it top be annotated with at least one @Path

## Create WAR file with the jar command

```bash
cd target/jeorg-jee-mastery-app-1-1.0.0-SNAPSHOT
jar -cvf jee-mastery-app-1-1.0.0-SNAPSHOT.war *
ls WEB-INF/lib
```

## Endpoints

1. [http://localhost:8080/jeorg-jee-mastery-app-1-1.0.0-SNAPSHOT/](http://localhost:8080/jeorg-jee-mastery-app-1-1.0.0-SNAPSHOT)

## Curl requests

```bash
curl -X HEAD http://localhost:8080/jeorg-jee-mastery-app-1-1.0.0-SNAPSHOT/app/fado/bands
curl -X HEAD -I http://localhost:8080/jeorg-jee-mastery-app-1-1.0.0-SNAPSHOT/app/fado/bands
curl -X GET http://localhost:8080/jeorg-jee-mastery-app-1-1.0.0-SNAPSHOT/app/fado/bands
curl -X HEAD http://localhost:8080/jeorg-jee-mastery-app-1-1.0.0-SNAPSHOT/app/fado/bands/head
curl -X HEAD -I http://localhost:8080/jeorg-jee-mastery-app-1-1.0.0-SNAPSHOT/app/fado/bands/head
curl -X GET http://localhost:8080/jeorg-jee-mastery-app-1-1.0.0-SNAPSHOT/app/fado/bands/head
```

## Context References

- [Donna Summer discography](https://en.wikipedia.org/wiki/Donna_Summer_discography)
- [Dorian (Spanish band)](https://en.wikipedia.org/wiki/Dorian_(Spanish_band))
- [Last Night (Moby album)](https://en.wikipedia.org/wiki/Last_Night_(Moby_album))
- [Disco Lies](https://en.wikipedia.org/wiki/Disco_Lies)
- [Hercules and Love Affair](https://en.wikipedia.org/wiki/Hercules_and_Love_Affair)
- [Faith no More](https://en.wikipedia.org/wiki/Faith_No_More)
- [Easy (Commodores song)](https://en.wikipedia.org/wiki/Easy_(Commodores_song))
- [Same Love](https://en.wikipedia.org/wiki/Same_Love)
- [The Heist (album)](https://en.wikipedia.org/wiki/The_Heist_(album))
- [Melissa Etheridge discography](https://en.wikipedia.org/wiki/Melissa_Etheridge_discography)
- [Melissa Etheridge](https://en.wikipedia.org/wiki/Melissa_Etheridge)
- [Whaler (album)](https://en.wikipedia.org/wiki/Whaler_(album))
- [Right Beside You (Sophie B. Hawkins song)](https://en.wikipedia.org/wiki/Right_Beside_You_(Sophie_B._Hawkins_song))
- [Humanos LP - Humanos](https://en.wikipedia.org/wiki/Humanos)
- [You Spin Me Round (Like a Record)](https://en.wikipedia.org/wiki/You_Spin_Me_Round_(Like_a_Record))
- [Farbenspiel](https://en.wikipedia.org/wiki/Farbenspiel)
- [Atemlos durch die Nacht](https://en.wikipedia.org/wiki/Atemlos_durch_die_Nacht)
- [Divine - You think you're a man](https://en.wikipedia.org/wiki/You_Think_You%27re_a_Man)
- [The Story So Far (Divine album)](https://en.wikipedia.org/wiki/The_Story_So_Far_(Divine_album))
- [Dead or Alive discography](https://en.wikipedia.org/wiki/Dead_or_Alive_discography)

<div align="center">
      <a title="Melissa Etheridge - Angels Would Fall" href="https://www.youtube.com/watch?v=eC8FfGvCFho">
     <img 
          src="https://img.youtube.com/vi/eC8FfGvCFho/0.jpg" 
          style="width:10%;">
      </a>
      <a title="Sophie B. Hawkins - Right Beside You" href="https://www.youtube.com/watch?v=VDJSOAYEzPA">
     <img 
          src="https://img.youtube.com/vi/VDJSOAYEzPA/0.jpg" 
          style="width:10%;">
      </a>
</div>
<div align="center">
      <a title="Divine - You Think You're a Man" href="https://www.youtube.com/watch?v=063RGou-P_8">
     <img 
          src="https://img.youtube.com/vi/063RGou-P_8/0.jpg" 
          style="width:10%;">
      </a>
      <a title="Full Frontal - You Think You're a Man" href="https://www.youtube.com/watch?v=Esxotxomw8s">
     <img 
          src="https://img.youtube.com/vi/Esxotxomw8s/0.jpg" 
          style="width:10%;">
      </a>
</div>
<div align="center">
      <a title="Donna Summer - Could it be magic" href="https://www.youtube.com/watch?v=3G8FJPdhSOY">
     <img 
          src="https://img.youtube.com/vi/3G8FJPdhSOY/0.jpg" 
          style="width:10%;">
      </a>
      <a title="Helene Fischer - Atemlos durch die Nacht" href="https://www.youtube.com/watch?v=haECT-SerHk">
     <img 
          src="https://img.youtube.com/vi/haECT-SerHk/0.jpg" 
          style="width:10%;">
      </a>
</div>

<div align="center">
      <a title="Dead or Alive - You Spin Me Round (Like a Record)" href="https://www.youtube.com/watch?v=PGNiXGX2nLU">
     <img 
          src="https://img.youtube.com/vi/PGNiXGX2nLU/0.jpg" 
          style="width:10%;">
      </a>
      <a title="Moby - Disco Lies" href="https://www.youtube.com/watch?v=RjJYznmSjkg">
     <img 
          src="https://img.youtube.com/vi/RjJYznmSjkg/0.jpg" 
          style="width:10%;">
      </a>
</div>

<div align="center">
      <a title="Scissor Sisters - Let's have a Kiki" href="https://www.youtube.com/watch?v=eGCD4xb-Tr8">
     <img 
          src="https://img.youtube.com/vi/eGCD4xb-Tr8/0.jpg" 
          style="width:10%;">
      </a>
      <a title="NERVO feat. Kylie Minogue, Jake Shears & Nile Rodgers - The other boys" href="https://www.youtube.com/watch?v=N62Edu_WIhs">
     <img 
          src="https://img.youtube.com/vi/N62Edu_WIhs/0.jpg" 
          style="width:10%;">
      </a>
</div>
<div align="center">
      <a title="Kylie Minogue - All the lovers" href="https://www.youtube.com/watch?v=frv6FOt1BNI">
     <img 
          src="https://img.youtube.com/vi/frv6FOt1BNI/0.jpg" 
          style="width:10%;">
      </a>
      <a title="St. Vincent - Fast Slow Disco" href="https://www.youtube.com/watch?v=dNm0b2SCXxY">
     <img 
          src="https://img.youtube.com/vi/dNm0b2SCXxY/0.jpg" 
          style="width:10%;">
      </a>
</div>
<div align="center">
      <a title="Hercules & Love Affair - Do You Feel The Same?" href="https://www.youtube.com/watch?v=JozUoRIbsEE">
     <img 
          src="https://img.youtube.com/vi/JozUoRIbsEE/0.jpg" 
          style="width:10%;">
      </a>
      <a title="Dorian & Pimp Flaco - Dual" href="https://www.youtube.com/watch?v=TBZ52zCD0zk">
     <img 
          src="https://img.youtube.com/vi/TBZ52zCD0zk/0.jpg" 
          style="width:10%;">
      </a>
</div>
<div align="center">
      <a title="Macklemore & Ryan Lewis, Mary Lambert - Same Love" href="https://www.youtube.com/watch?v=hlVBg7_08n0">
     <img 
          src="https://img.youtube.com/vi/hlVBg7_08n0/0.jpg" 
          style="width:10%;">
      </a>
      <a title="P!nk - Raise Your Glass" href="https://www.youtube.com/watch?v=XjVNlG5cZyQ">
     <img 
          src="https://img.youtube.com/vi/XjVNlG5cZyQ/0.jpg" 
          style="width:10%;">
      </a>
</div>
<div align="center">
      <a title="Humanos - Muda De Vida - [ Official Music Video ]" href="https://www.youtube.com/watch?v=qK-WYZD4Bic">
     <img 
          src="https://img.youtube.com/vi/qK-WYZD4Bic/0.jpg" 
          style="width:10%;">
      </a>
      <a title="In-Grid - Tu Es Foutu (LAMUR)" href="https://www.youtube.com/watch?v=MZqlhQm7hv4">
     <img 
          src="https://img.youtube.com/vi/MZqlhQm7hv4/0.jpg" 
          style="width:10%;">
      </a>
</div>

<div align="center">
      <a title="Faith no more - Easy" href="https://www.youtube.com/watch?v=vPzDTfIb0DU">
     <img 
          src="https://img.youtube.com/vi/vPzDTfIb0DU/0.jpg" 
          style="width:10%;">
      </a>
      <a title="The Young Professionals feat Uriel Yekutiel - D.I.S.C.O." href="https://www.youtube.com/watch?v=VcZnRz7WujA">
     <img 
          src="https://img.youtube.com/vi/VcZnRz7WujA/0.jpg" 
          style="width:10%;">
      </a>
</div>

<div align="center">
      <a title="La Prohibida - Baloncesto" href="https://www.youtube.com/watch?v=HSzekat1ajU">
     <img 
          src="https://img.youtube.com/vi/HSzekat1ajU/0.jpg" 
          style="width:10%;">
      </a>
      <a title="Katy Perry - I Kissed a Girl" href="https://www.youtube.com/watch?v=tAp9BKosZXs">
     <img 
          src="https://img.youtube.com/vi/tAp9BKosZXs/0.jpg" 
          style="width:10%;">
      </a>
</div>

## References

### Online

- [Batch Properties](https://jberet.gitbooks.io/jberet-user-guide/content/batch_properties/)
- [Create and Invoke a JSR-352 Batchlet Using EJB Timer](http://techtipsjava.blogspot.com/2014/11/create-and-invoke-jsr-352-batchlet.html)
- [Java EE 7 Batch (JSR 352)](http://www.jknowledge.de/tutorials/java-batch-jsr-352/)
- [CHAPTER 18. JAVA BATCH APPLICATION DEVELOPMENT](https://access.redhat.com/documentation/en-us/jboss_enterprise_application_platform_continuous_delivery/17/html/development_guide/java_batch_application_development)
- [45.5 Using the JMS API in Java EE Applications](https://docs.oracle.com/javaee/7/tutorial/jms-concepts005.htm)
- [Java Authentication and Authorization Service (JAAS) Reference Guide](https://docs.oracle.com/javase/8/docs/technotes/guides/security/jaas/JAASRefGuide.html)
- [Receiving Messages 2](https://abhirockzz.gitbooks.io/java-websocket-api-handbook/content/Receiving%20Messages.html)
- [Receiving Messages](https://abhishek-gupta.gitbook.io/java-websocket-api-handbook/receiving-messages)
- [JSF - Page Navigation](https://www.tutorialspoint.com/jsf/jsf_page_navigation.htm#:~:text=Navigation%20rules%20are%20those%20rules,xml.&text=Navigation%20rules%20can%20contain%20conditions,resulted%20view%20can%20be%20shown.)
- [Demonstrating Async ReadListener / WriteListener processing](https://gist.github.com/joakime/1a77946248e5ff028f99)
- [Difference between View and Request scope in managed beans](https://stackoverflow.com/questions/6025998/difference-between-view-and-request-scope-in-managed-beans)
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
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=red "Project statuses")](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Status.md)
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
