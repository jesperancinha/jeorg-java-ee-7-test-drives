# jeorg-jee-apps

---

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/java-50.png "Java")](https://www.oracle.com/nl/java/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/lombok-50.png "Lombok")](https://projectlombok.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/openjdk-50.png "OpenJDK")](https://openjdk.java.net/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/sdk-man-50.png "SdkMAN!")](https://sdkman.io/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/wild-fly-50.png "WildFly")](https://www.wildfly.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/arquillian-50.png "Arquillian")](https://github.com/arquillian)

---

## Introduction

For a good understanding of JEE I've created different Triads. A triad is a basically a set of three applications. Each application may also be a set of one or three modules. In this document you can see a cloud of topics for every triad and their contexts. This way I hope to make your path to JEE
certification a fun success! Enjoy!

</i>João Esperancinha, on the 5th of January 2021</i>

Note that the quad module is a conclusion module for the triads. We will continue with the [mastery web-apps](../jeorg-jee-mastery).

## Prepare the environment

### Wildfly 16.0

1. Download [Wilfly 16](https://www.wildfly.org/downloads/)
2. Unpack the contents of that package to this root.

You can also just run the [Bash script file](installWildFly.sh) and hope that it works on your computer:

### End Installation notes

This should be enough. Maven files inside the application list will refer to this folder in order to start the server.

Important to take note is that none of the modules is static. The ones marked with <b>(coming soon...)</b>, aren't ready to be used, but you can take a peek. The ones without any notice, are considered done, but they will be subject to improvements from time to time.

## Triads

### [jeorg-jee-apps-triad-1](./jeorg-jee-apps-triad-1)

#### Subjects:

----

`Servlet`
`@Target({ TYPE, METHOD, PARAMETER, FIELD })`, `@Retention(RUNTIME)`,`@Documented`,`@Qualifier`,
`@ApplicationScoped`, `JSF`
`javax.enterprise.inject.Instance`,
`@PersistenceContext`, `InjectionPoint`, `@RequestScoped`
`@Stateful`, `@Alternative`
`@Model`
`<ui:repeat`, `<h:link`, `<f:param`
`<h:dataTable`, `<h:column`, `<f:facets`
`<h:outputFormat` `<f:param`
`@Resource`,
`Arquillian` `JUnit` `tests`
`@Null`, `@NotNull`, `@Size`, `@Email`, `@Digits`
`UserTransaction`, `Event<T>`,
`FacesContext`,
`@Path`, `@ApplicationPath`, `Application`
`@Observes`, `Reception.ALWAYS`
`@XmlRootElement(name = "herb")`, `@XmlAccessorType(XmlAccessType.FIELD)`
`@Path`, `@RequestScoped`, `@POST`, `@GET`, `@Produces`, `@Consumes`, `MediaType.APPLICATION_XML`
`ServletContext`, `HttpSession`, `doGet`
`JCA`, `JNDI`,
`javax.ejb.MessageDriven`, `@ActivationConfigProperty`, `javax.jms.MessageListener`.
`ApacheMQ`, `queues`, `standalone-full.xml`,
`@WebServiceRef`
`@WebServlet`, `@WebServiceRef`, `@HandlerChain`, `@WebServiceClient`, `SOAP WS - JAX-WS`
`@Entity`, `@Table`
`javax.ejb.TransactionManagementType.BEAN`,`javax.ejb.TransactionManagementType.CONTAINER`
`@OneToMany`, `@ManyToOne`
`@OneToOne`
`@Enumerated`,`entities`
`Abstract`, `final`,  `JPA`,
`@Stateful`, `@Cache`, `@PrePassivate`, `@PostActivate`, `Serializable`, `@Local`, `java:module`, `InitialContext`
`transient`, `@OneToMany(fetch = FetchType.EAGER)`,  `@OneToMany(fetch = FetchType.LAZY)`
`@Singleton`, `@Stateful`, `@Stateless,` `SessionContext`,  `@Timeout`, `@Resource`, `context.getTimerService()`
, `TimerService`
`@TransactionAttribute`, `TransactionAttributeType`
`MANDATORY`, `REQUIRED`, `REQUIRES_NEW`, `SUPPORTS`, `NOT_SUPPORTED`, `NEVER` `TransactionAttribute`
`Rollback`

---

#### Applications:

- [jeorg-jee-app-1-wildfly](./jeorg-jee-apps-triad-1/jeorg-jee-app-1-wildfly) - Pop stars list, music, lyrics and history - Java 8
- [jeorg-jee-app-2-wildfly](./jeorg-jee-apps-triad-1/jeorg-jee-app-2-wildfly) - Kitchen Herbs and History - Java 11
- [jeorg-jee-app-3-wildfly](./jeorg-jee-apps-triad-1/jeorg-jee-app-3-wildfly) - A lesson on teeth health and the odd cases - Java 11

### [jeorg-jee-apps-triad-2](./jeorg-jee-apps-triad-2)

#### Subjects:

`@MessageDriven(activationConfig`, `@ActivationConfigProperty`, `ConnectionFactory`, `Destination`, `JNDI`
`acknowledge`, `connection.createQueueSession(false, Session.CLIENT_ACKNOWLEDGE);`
`<alternatives>`, `@Alternative`, `@Default`
`JMSContext`, `JMSConsumer`, `JMSProducer`, `createDurableConsumer`
`URL Rewriting`, `Session`, `Cookie`
`soapenv:Envelope`, `soapenv:Header`, `soapenv:Body`, ` @Resource`, `@WebService`, `endpointInterface`
, `@SOAPBinding(style = SOAPBinding.Style.RPC)`
`@CookieParam`, `JAX-WS`, `Cookie`, `WebServiceContext`
`@WebParam`, `@WebResult`
`Random Access`, `JAXB`, `Memory footprint`, `Multiple times processing`
`@WebFilter`, `HttpSession`, `@SessionScoped`, `@Named`, `FilterChain`
`Filter`, `web.xml`, `order`, `WebFilter`, `<filter>`, `<filter-mapping>`, `<filter-name>`, `<filter-class>`
, `<init-param>`
`<jsp:useBean`, `JSP`, `Servlet`, `HttpServlet`
`Filter`, `web.xml`, `order`, `direct references`
`Session`, `invalidate`, `IllegalStateException`
`service`, `doGet`
`<jsp:getProperty`, `<jsp:setProperty`, `<jsp:useBean`
, `<jsp:setProperty name="midasBean" property="comment" param="review"/>`
`<error-page>`, `<exception-type>`, `<location>`
`<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>`, `javax.servlet.error.exception`
, `javax.servlet.error.exception_type`, `javax.servlet.error.message`, `javax.servlet.error.request_uri`
, `javax.servlet.error.servlet_name`, `javax.servlet.error.status_code`
`<%@ page errorPage="soulexception.jsp" %>`, `<%@ page isErrorPage="true" %>`, `pageContext.errorData`
`<jsp:useBean id="simpleLyricBean2" scope="page" type="org.jesperancinha.jtd.jee.soul.beans.LyricsExtended" class="org.jesperancinha.jtd.jee.soul.beans.Lyric">`
`<context-param>`, `<param-name>javax.faces.DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE</param-name>`
, `<f:convertDateTime pattern="yyyy-MMM-dd"/>`

#### Applications:

- [jeorg-jee-app-2-1-wildfly](./jeorg-jee-apps-triad-2/jeorg-jee-app-2-1-wildfly) - Boy bands in the 90's
- [jeorg-jee-app-2-2-wildfly](./jeorg-jee-apps-triad-2/jeorg-jee-app-2-2-wildfly) - Girl Bands
- [jeorg-jee-app-2-3-wildfly](./jeorg-jee-apps-triad-2/jeorg-jee-app-2-3-wildfly) - Soul Music

### [jeorg-jee-apps-quad-1](./jeorg-jee-apps-quad-1)

#### Subjects:

`@PathParam`, `@RequestScoped`, `@Path`, `@GET`, `@Produces`, `MediaType`, `APPLICATION_JSON`
`RegEx`, `@PathParam`, `@GET`
`@Stateless`, `@Stateful`, `@Singleton`, `@RequestScoped`, `@Dependent`, `@ApplicationScoped`
`Scope`, `@RequestScoped`
`Specific`, `Generic`, `@GET`, `@Path`
`@QueryParam`
`MessageBodyReader`
`MessageBodyWritter`
`@ServerEndpoint`, `@OnMessage`, `@OnOpen`, `@OnError`, `@OnClose`, `getBasicRemote`, `sendText`
`Encoder.Text`, `Decoder.Text`, `init`, `destroy`, `decode`, `encode`, `encoders`, `decoders`
`MessageHandler.Partial`, `MessageHandler.Whole`, `@OnMessage`, `isLast`
`navigation-rule`, `from-view-id`, `navigation-case`, `from-outcome`, `to-view-id`, `from-action`, `h:commandLink`
`http://java.sun.com/jsp/jstl/core`, `forEach`, `EL`, `Expression Language`
`xmlns:h="http://xmlns.jcp.org/jsf/html"`, `xmlns:jsf="http://xmlns.jcp.org/jsf"`
, `xmlns:f="http://xmlns.jcp.org/jsf/core"`, `xmlns:pt="http://xmlns.jcp.org/jsf/passthrough"`
`<fmt:bundle`, `<fmt:message`, `<fmt:setBundle`, `<fmt:setLocale`
`j_security_check`, `j_username`, `j_password`, `security-constraint`, `web-resource-collection`, `web-resource-name`
, `description`, `url-pattern`, `http-method`, `auth-constraint`, `role-name`, `security-role`, `login-config`
, `auth-method`, `form-login-config`, `form-login-page`, `form-error-page`
`getCallerPrincipal`, `isCallerInRole`, `SessionContext`, `@EJB`, `@Resource`
`@Stateless`, `Stateful`, `isCallerInRole`, `@PreDestroy`, `@PostConstruct`
`SessionContext.getCallerPrincial`, `HttpServletRequest.getUserPrincipal`
`NONE`, `INTEGRAL`, `CONFIDENTIAL`
`<job`, `<step`, `<chunk`, `<end on`, `AbstractItemReader`, `AbstractItemWriter`, `ItemProcessor`, `@Named`
`BatchRuntime`, `JobOperator`, `getRunningExecutions`, `getJobExecution`, `getBatchStatus`
`@RequestScoped`, `@SessionScoped`, `@ApplicationScoped`

#### Applications:

- [jeorg-jee-app-3-1-wildfly](./jeorg-jee-apps-quad-1/jeorg-jee-app-3-1-wildfly) - History of Portugal - 🇵🇹
- [jeorg-jee-app-3-2-wildfly](./jeorg-jee-apps-quad-1/jeorg-jee-app-3-2-wildfly) - History of Spain - 🇪🇸
- [jeorg-jee-app-3-3-wildfly](./jeorg-jee-apps-quad-1/jeorg-jee-app-3-3-wildfly) - History of The Netherlands - 🇳🇱
- [jeorg-jee-app-3-4-wildfly](./jeorg-jee-apps-quad-1/jeorg-jee-app-3-4-wildfly) - History of the United Kingdom - 🇬🇧

## References

### Online

- [Java EE 7 full platform and Web Profile](https://www.ibm.com/support/knowledgecenter/SSEQTP_9.0.5/com.ibm.websphere.base.doc/ae/covr_javaee7.html)
- [JSR 342: JavaTM Platform, Enterprise Edition 7 (Java EE 7) Specification](https://jcp.org/en/jsr/detail?id=342)
- [JEE7 Spec document](https://download.oracle.com/otn-pub/jcp/java_ee-7-fr-spec/JavaEE_Platform_Spec.pdf?AuthParam=1610297053_dc338cf9ac2f643c005b280582ab4052)
- [Oracle 1Z0-900 Exam: Rise and Shine as an Application Developer with Oracle Certification](https://www.dbexam.com/blog/oracle-1z0-900-exam-rise-and-shine-application-developer-oracle-certification)
- [1Z0-900: Java EE 7 Application Developer](https://www.dbexam.com/oracle/1z0-900-java-ee-7-application-developer)
- [Building and Running a Java EE Application by Using Maven](https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Maven_EE/MavenEE.html)
- [Run Maven Java Web Application in Jetty Maven Plugin](https://o7planning.org/en/10335/run-maven-java-web-application-in-jetty-maven-plugin)
- [Getting Started With Jetty Server](https://www.jrebel.com/blog/jetty-server)
- [jetty Maven Jetty plugin](https://riptutorial.com/jetty/example/22209/maven-jetty-plugin)
- [Chapter 6. Getting started with Weld](https://docs.jboss.org/weld/reference/3.0.0.CR1/en-US/html/gettingstarted.html)
- [Creating a Chat Application using Java EE 7, Websockets and GlassFish 4](https://www.hascode.com/2013/08/creating-a-chat-application-using-java-ee-7-websockets-and-glassfish-4/)
- [JAVA EE 7 – THE STANDARD FOR ENTERPRISE JAVA](https://turngeek.github.io/javaee7inaweek/chapter/i-1-java-ee-7-the-standard-for-enterprise-java/)
- [Java Platform, Enterprise Edition (Java EE) 7](https://docs.oracle.com/javaee/7/index.html)

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
