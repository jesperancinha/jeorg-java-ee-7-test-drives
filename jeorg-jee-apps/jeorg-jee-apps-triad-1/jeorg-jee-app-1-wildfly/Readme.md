# jeorg-jee-app-1-wildfly

---

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/java-50.png "Java")](https://www.oracle.com/nl/java/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/lombok-50.png "Lombok")](https://projectlombok.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/openjdk-50.png "OpenJDK")](https://openjdk.java.net/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/sdk-man-50.png "SdkMAN!")](https://sdkman.io/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/wild-fly-50.png "WildFly")](https://www.wildfly.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/arquillian-50.png "Arquillian")](https://github.com/arquillian)

---

## Exercise

The apps under [jeorg-jee-apps](../..), cover lots of topics. For this app we cover:

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
19. `@Column(updatable = false)`

In this web application it is important to understand the basics of these:

1.  CDI -> Context Dependency Injection
2.  JSF -> Java Server Faces
3.  JTA -> Java Transaction API
4.  EJB -> Enterprise Java Bean
5.  Bean Validation
6.  Arquillian
7.  JAX - RS

This application offers you a fun overview in a very basic way about Resources, Controllers, Managed Beans, Data Access Objects, Services, Producers and Observers

The theme of this discovery app is: <b>Pop stars list, music, lyrics and history</b>

## How to run

This has been tested with Wildfly 16. Please install it and deploy this using your IDE.

```bash
jenv local system
sdk use java 8.0.242.hs-adpt
java -version
```

After the service is running and deployed you should be able to see pages and JSON's in these addresses:

1.  http://localhost:8080/jeorg-jee-app-1-wildfly/app/album/resource/1
2.  http://localhost:8080/jeorg-jee-app-1-wildfly/app/album/resource/2
3.  http://localhost:8080/jeorg-jee-app-1-wildfly/app/album/resource/3
4.  http://localhost:8080/jeorg-jee-app-1-wildfly/app/album/resource/4
5.  [http://localhost:8080/jeorg-jee-app-1-wildfly/](http://localhost:8080/jeorg-jee-app-1-wildfly/)

NOTE: If you start having errors about beans not being available or that you need to use `@Model` or another stereotype to get beans loaded, that could be that the build was not done with Java 8.  Remember to makes sure that you are making the build with `Java SE 8`. Java SE 8 isn't strictly
necessary to get JEE to work. It can work with Java SE 11. However, this module ensures the study of `JEE7` with both. For the current module you are looking at, Java SE 8 is the one being used.

## Run Arquillian tests

```bash
jenv local system
sdk use java 8.0.242.hs-adpt
mvn clean install -Parq-wildfly-managed
```

## Run Arquillian tests on Intellij

Use Arquillian Managed and you should get a screen like this. All options should be the default ones.

![alt text](docs/jeorg-jee-app-1-wildfly-IntelliJ-test-config.png)

## References

### Online

-   [CDI @RequestScoped](https://openejb.apache.org/examples-trunk/cdi-request-scope/)
-   [Wildfly - Quickstart repo](https://github.com/wildfly/quickstart)
-   [Getting Started Developing Applications Guide - WildFly team Version 20.0.0.Final, 2020-06-05T20:49:23Z](https://docs.wildfly.org/20/Getting_Started_Developing_Applications_Guide.html)
-   [DEVELOPING EJB APPLICATIONS](https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.2/html-single/developing_ejb_applications/index)
-   [Wild Fly Downloads](https://www.wildfly.org/downloads/)

### Books

-   Jendrock, E. Cervera-Navarro, R. Evans, I. (2014). <i>The Java EE 7 Tutorial</i>. (Fifth Edition Volume 1). Addison Wesley
-   Jendrock, E. Cervera-Navarro, R. Evans, I. (2014). <i>The Java EE 7 Tutorial</i>. (Fifth Edition Volume 2). Addison Wesley
- ??mil, M. (29th December 2014). <i>Java EE 7 Development with WildFly</i>. (First Edition). Packt Publishing
-   Mihalcea, V. (October 2016). <i>High-Performance Java Persistence</i>. (First Edition). Vlad Mihalcea
-   Gon??alves, A. (June 2013). <i>Beginning Java EE 7</i> (First Edition). Apress
-   R. Allen, P. J. Bambara, J. (2014). <i>OCM Java EE 6 Enterprise Architect Exam Guide</i>. (First Edition). McGraw-Hill
-   Gupta, A. (August 2013). <i>Java EE 7 Essentials</i>. (First Edition). O'Reilly
-   Dr Coward, D. (August 2013). <i>Java EE 7 The Big Picture</i>. (First Edition). McGraw-Hill

## Context references

-   [Cardi B Discography](https://en.wikipedia.org/wiki/Cardi_B_discography)
-   [Sia Discography](https://en.wikipedia.org/wiki/Sia_discography)
-   [Nicky Minaj Discography](https://en.wikipedia.org/wiki/Nicki_Minaj_discography)

## About me ?????????????????????????????????

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/JEOrgLogo-20.png "Jo??o Esperancinha Homepage")](http://joaofilipesabinoesperancinha.nl)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/medium-20.png "Medium")](https://medium.com/@jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/credly-20.png "Credly")](https://www.credly.com/users/joao-esperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=joaofilipesabinoesperancinha.nl&color=6495ED "Jo??o Esperancinha Homepage")](https://joaofilipesabinoesperancinha.nl/)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=jesperancinha&style=social "GitHub")](https://github.com/jesperancinha)
[![Twitter Follow](https://img.shields.io/twitter/follow/joaofse?label=Jo??o%20Esperancinha&style=social "Twitter")](https://twitter.com/joaofse)
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
[![IBM Cybersecurity Analyst Professional](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/ibm-cybersecurity-analyst-professional-certificate-100.png "IBM Cybersecurity Analyst Professional")](https://www.credly.com/badges/ad1f4abe-3dfa-4a8c-b3c7-bae4669ad8ce)
[![Certified Advanced JavaScript Developer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/cancanit-badge-1462-100.png "Certified Advanced JavaScript Developer")](https://cancanit.com/certified/1462/)
[![Certified Neo4j Professional](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/professional_neo4j_developer-100.png "Certified Neo4j Professional")](https://graphacademy.neo4j.com/certificates/c279afd7c3988bd727f8b3acb44b87f7504f940aac952495ff827dbfcac024fb.pdf)
[![Deep Learning](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/deep-learning-100.png "Deep Learning")](https://www.credly.com/badges/8d27e38c-869d-4815-8df3-13762c642d64)
