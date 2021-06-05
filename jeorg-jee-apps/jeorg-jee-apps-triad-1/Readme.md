# jee-apps-triad-1

---

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/java-50.png "Java")](https://www.oracle.com/nl/java/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/lombok-50.png "Lombok")](https://projectlombok.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/openjdk-50.png "OpenJDK")](https://openjdk.java.net/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/sdk-man-50.png "SdkMAN!")](https://sdkman.io/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/wild-fly-50.png "WildFly")](https://www.wildfly.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/arquillian-50.png "Arquillian")](https://github.com/arquillian)

---

## Prepare the environment

1.  Download [Wilfly 16](https://www.wildfly.org/downloads/)
2.  Unpack the contents of that package to this root.

This should be enough. Maven files inside the application list will refer to this folder in order to start the server.

Important to take note is that none of the modules is static. The ones marked with <b>(coming soon...)</b>, aren't ready to be used, but you can take a peek. The ones without any notice, are considered done, but they will be subject to improvements from time to time.

You can also just run the [Bash script file](installWildFly.sh) and hope that it works on your computer:

```bash
curl https://download.jboss.org/wildfly/16.0.0.Final/wildfly-16.0.0.Final.tar.gz --output wildfly-16.0.0.Final.tar.gz
tar -xvzf wildfly-16.0.0.Final.tar.gz
```

## Applications

### [jee-app-1-wildfly](jee-app-1-wildfly) - Pop stars list, music, lyrics and history

#### Subjects

1.  `Servlet` -> [17 Java Servlet Technology](https://docs.oracle.com/javaee/7/tutorial/servlets.htm)
2.  `@Target({ TYPE, METHOD, PARAMETER, FIELD })`, `@Retention(RUNTIME)`,`@Documented`,`@Qualifier`
3.  `@ApplicationScoped`
4.  JSF (Java Server Faces)
5.  `javax.enterprise.inject.Instance` - How to inject an instance and re-inject
6.  `@PersistenceContext`, `InjectionPoint` and `@RequestScoped`
7.  `@Stateful`, `@Alternative`
8.  `@Model`
9.  `<ui:repeat`, `<h:link` and `<f:param`
10. `<h:dataTable`, `<h:column` and `<f:facets`
11. `<h:outputFormat ` and `<f:param`
12. `@Resource` -> [4.1 Resource Injection](https://docs.oracle.com/javaee/7/tutorial/injection001.htm)
13. Arquillian JUnit tests
14. `@Null`, `@NotNull`, `@Size`, `@Email` and `@Digits` validations
15. `UserTransaction`, `Event<T>`
16. `FacesContext`
17. `@Path`, `@ApplicationPath`, `Application`
18. `@Observes` and `Reception.ALWAYS`

#### Modules

-   [jee-app-1-wildfly](jee-app-1-wildfly) - Pop stars list, music, lyrics and history - Java 8

### [jee-app-2-wildfly](jee-app-2-wildfly) - Kitchen Herbs and History

#### Subjects

1.  `@XmlRootElement(name = "herb")` and `@XmlAccessorType(XmlAccessType.FIELD)`
2.  `@Path`, `@RequestScoped`, `@POST`, `@GET`, `@Produces`, `@Consumes` and `MediaType.APPLICATION_XML`
3.  `ServletContext`, `HttpSession` and `doGet`
4.  A very complicated JCA example, that doesn't work. Only `JNDI` works - Follow-up modules may provide solution to this.
5.  `javax.ejb.MessageDriven`, `@ActivationConfigProperty` and `javax.jms.MessageListener`.
6.  ApacheMQ, queues and [standalone-full.xml](backup/standalone-full.xml) configuration
7.  Much about `@WebServiceRef`
8.  `@WebServlet`, `@WebServiceRef`, `@HandlerChain`, `@WebServiceClient`, SOAP WS - JAX-WS

#### Modules

-   [jee-app-2-wildfly (WAR application)](jee-app-2-wildfly) - Kitchen Herbs and History - Java 11
-   [jee-app-2-wildfly-adapter (RAR adpter)](jee-app-2-wildfly-adapter) - Kitchen Herbs and History - Java 11 - This is the adapter needed for the previous module.
-   [jee-app-2-wildfly-lib (JAR library)](jee-app-2-wildfly-lib) - Kitchen Herbs and History - Java 11 - This is the library needed for the previous adapter.
-   [jee-app-2-wildfly-lib-ws (WAR application)](jee-app-2-wildfly-ws) - Kitchen Herbs and History - Java 11 - SOAP Webservice.

### [jee-app-3-wildfly](jee-app-3-wildfly) - A lesson on teeth health and the odd cases

#### Subjects

1.  `@Entity` and `@Table`
2.  `javax.ejb.TransactionManagementType.BEAN` vs `javax.ejb.TransactionManagementType.CONTAINER`
3.  `@OneToMany` and `@ManyToOne` (NOTE: They have to be either all member instances, either all member methods. mixed won't work)
4.  `@OneToOne` The same rule applies as in point 3.
5.  `@Enumerated` JPA entities
6.  Abstract and final JPA entities -> [Requirements for Entity Classes](https://docs.oracle.com/javaee/5/tutorial/doc/bnbqa.html)
7.  `@Stateful`, `@Cache`, `@PrePassivate`, `@PostActivate`, `Serializable`, `@Local`, `java:module`, `InitialContext`
8.  `transient`, `@OneToMany(fetch = FetchType.EAGER)`,  `@OneToMany(fetch = FetchType.LAZY)`
9.  `@Singleton`, `@Stateful`, `@Stateless,` `SessionContext`,  `@Timeout`, `@Resource`, `context.getTimerService()`
   and `TimerService`
10. `@TransactionAttribute` and `TransactionAttributeType`
11. `MANDATORY`, `REQUIRED`, `REQUIRES_NEW`, `SUPPORTS`, `NOT_SUPPORTED`, `NEVER` TransactionAttribute
12. `Rollback`

#### Modules

-   [jee-app-3-wildfly](jee-app-3-wildfly) - A lesson on teeth health and the odd cases

## References

### Online

-   [Oracle 1Z0-900 Exam: Rise and Shine as an Application Developer with Oracle Certification](https://www.dbexam.com/blog/oracle-1z0-900-exam-rise-and-shine-application-developer-oracle-certification)
-   [1Z0-900: Java EE 7 Application Developer](https://www.dbexam.com/oracle/1z0-900-java-ee-7-application-developer)
-   [Building and Running a Java EE Application by Using Maven](https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Maven_EE/MavenEE.html)
-   [Run Maven Java Web Application in Jetty Maven Plugin](https://o7planning.org/en/10335/run-maven-java-web-application-in-jetty-maven-plugin)
-   [Getting Started With Jetty Server](https://www.jrebel.com/blog/jetty-server)
-   [jetty Maven Jetty plugin](https://riptutorial.com/jetty/example/22209/maven-jetty-plugin)
-   [Chapter 6.  Getting started with Weld](https://docs.jboss.org/weld/reference/3.0.0.CR1/en-US/html/gettingstarted.html)
-   [Creating a Chat Application using Java EE 7, Websockets and GlassFish 4](https://www.hascode.com/2013/08/creating-a-chat-application-using-java-ee-7-websockets-and-glassfish-4/)
-   [JAVA EE 7 – THE STANDARD FOR ENTERPRISE JAVA](https://turngeek.github.io/javaee7inaweek/chapter/i-1-java-ee-7-the-standard-for-enterprise-java/)
-   [Java Platform, Enterprise Edition (Java EE) 7](https://docs.oracle.com/javaee/7/index.html)

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

[![VMware Spring Professional 2021](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/vmware-spring-professional-2021.png "VMware Spring Professional 2021")](https://www.credly.com/badges/762fa7a4-9cf4-417d-bd29-7e072d74cdb7)
[![Oracle Certified Professional, JEE 7 Developer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-ee-7-application-developer-100.png "Oracle Certified Professional, JEE7 Developer")](https://www.credly.com/badges/27a14e06-f591-4105-91ca-8c3215ef39a2)
[![Oracle Certified Professional, Java SE 11 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-se-11-developer-100.png "Oracle Certified Professional, Java SE 11 Programmer")](https://www.credly.com/badges/87609d8e-27c5-45c9-9e42-60a5e9283280)
[![Oracle Certified Professional, Java SE 8 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-se-8-programmer-100.png "Oracle Certified Professional, Java SE 8 Programmer")](https://www.credly.com/badges/92e036f5-4e11-4cff-9935-3e62266d2074)
[![Oracle Certified Associate, Java SE 8 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-associate-java-se-8-programmer-100.png "Oracle Certified Associate, Java SE 8 Programmer")](https://www.credly.com/badges/a206436d-6fd8-4ca1-8feb-38a838446ee7)
[![Oracle Certified Associate, Java SE 7 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-associate-java-se-7-programmer-100.png "Oracle Certified Associate, Java SE 7 Programmer")](https://www.credly.com/badges/f4c6cc1e-cb52-432b-904d-36d266112225)
[![Oracle Certified Junior Associate](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-foundations-associate-java-100.png "Oracle Certified Foundations Associate")](https://www.credly.com/badges/6db92c1e-7bca-4856-9543-0d5ed0182794)
