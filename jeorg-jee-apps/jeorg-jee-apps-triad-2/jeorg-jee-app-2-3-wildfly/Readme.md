# jee-app-2-3-wildfly Soul Music

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

1. `service`, `doGet`
2. `<jsp:getProperty`, `<jsp:setProperty`, `<jsp:useBean`
   , `<jsp:setProperty name="midasBean" property="comment" param="review"/>`
3. `<error-page>`, `<exception-type>`, `<location>`
4. `<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>`, `javax.servlet.error.exception`
   , `javax.servlet.error.exception_type`, `javax.servlet.error.message`, `javax.servlet.error.request_uri`
   , `javax.servlet.error.servlet_name`, `javax.servlet.error.status_code`
5. `<%@ page errorPage="soulexception.jsp" %>`, `<%@ page isErrorPage="true" %>`, `pageContext.errorData`
6. `<jsp:useBean id="simpleLyricBean2" scope="page" type="org.jesperancinha.jtd.jee.soul.beans.LyricsExtended" class="org.jesperancinha.jtd.jee.soul.beans.Lyric">`
7. `<context-param>`, `<param-name>javax.faces.DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE</param-name>`
   , `<f:convertDateTime pattern="yyyy-MMM-dd"/>`

## Test Endpoints

## Run Arquillian tests

```bash
jenv local system
sdk use java 11.0.9.hs-adpt
mvn clean install -Parq-wildfly-managed
```

## Context References

- [Angie Stone - Unexpected](https://en.wikipedia.org/wiki/Unexpected_(Angie_Stone_album))
- [Megadeth - So Far, So Good... So What! - In My Darkest Hour](https://en.wikipedia.org/wiki/So_Far,_So_Good..._So_What!)
- [Luther Vandross](https://en.wikipedia.org/wiki/Luther_Vandross)
- [Midnight Star (band)](https://en.wikipedia.org/wiki/Midnight_Star_(band))

<div align="center">
      <a title="Little Red Corvette - Prince" href="https://www.youtube.com/watch?v=v0KpfrJE4zw">
     <img alt="Little Red Corvette - Prince"
          src="https://img.youtube.com/vi/v0KpfrJE4zw/0.jpg" 
          style="width:10%;">
      </a>
      <a href="https://www.youtube.com/watch?v=qRbEBf_ShDA">
     <img alt="Midas Touch - Midnight Start"
          src="https://img.youtube.com/vi/qRbEBf_ShDA/0.jpg" 
          style="width:10%;">
      </a>
</div>
<div align="center">
      <a href="https://www.youtube.com/watch?v=5X-Mrc2l1d0">
     <img alt="Rock With You - Michael Jackson"
          src="https://img.youtube.com/vi/5X-Mrc2l1d0/0.jpg" 
          style="width:10%;">
      </a>
      <a title="Pretty Wings - Maxwell" href="https://www.youtube.com/watch?v=RkPy4yq7EJo">
     <img alt="Pretty Wings - Maxwell"
          src="https://img.youtube.com/vi/RkPy4yq7EJo/0.jpg" 
          style="width:10%;">
      </a>
</div>
<div align="center">
      <a title="She's a super lady - Luther Vandross" href="https://www.youtube.com/watch?v=Bc7vBEdYfbA">
     <img alt="She's a super lady - Luther Vandross"
          src="https://img.youtube.com/vi/Bc7vBEdYfbA/0.jpg" 
          style="width:10%;">
      </a>
      <a href="https://www.youtube.com/watch?v=Iii33aHd7zY">
     <img alt="I ain't hearing you - Angie Stone"
          src="https://img.youtube.com/vi/Iii33aHd7zY/0.jpg" 
          style="width:10%;">
      </a>
</div>
<div align="center">
      <a href="https://www.youtube.com/watch?v=uSu6tcbMOu0">
     <img alt="Let's stay together - Al Green"
          src="https://img.youtube.com/vi/uSu6tcbMOu0/0.jpg" 
          style="width:10%;">
      </a>
      <a href="https://www.youtube.com/watch?v=iN3KsbnQZxU">
     <img alt="Move on up - Curtis Mayfield"
          src="https://img.youtube.com/vi/iN3KsbnQZxU/0.jpg" 
          style="width:10%;">
      </a>
</div>
<div align="center">
      <a href="https://www.youtube.com/watch?v=JSEbDN49bYM">
     <img alt="No One`s Gonna Love You - S.O.S. Band"
          src="https://img.youtube.com/vi/JSEbDN49bYM/0.jpg" 
          style="width:10%;">
      </a>
      <a href="https://www.youtube.com/watch?v=0fNxgaw8I7I">
     <img alt="Use Ta Be My Girl - The O'Jays"
          src="https://img.youtube.com/vi/0fNxgaw8I7I/0.jpg" 
          style="width:10%;">
      </a>
</div>

<div align="center">
      <a href="https://www.youtube.com/watch?v=mu3Fy6c3VR0">
     <img alt="Voggue - Dancin' the Night Away - Voggue"
          src="https://img.youtube.com/vi/mu3Fy6c3VR0/0.jpg" 
          style="width:10%;">
      </a>
      <a href="https://www.youtube.com/watch?v=q4Octh286e0">
     <img alt="Back For More feat. Eugene Wilde - Cool Million"
          src="https://img.youtube.com/vi/q4Octh286e0/0.jpg" 
          style="width:10%;">
      </a>
</div>

<div align="center">
      <a href="https://www.youtube.com/watch?v=ooOFMsvn4gk">
     <img alt="Like I Want To - Lisa Shaw"
          src="https://img.youtube.com/vi/ooOFMsvn4gk/0.jpg" 
          style="width:10%;">
      </a>
      <a href="https://www.youtube.com/watch?v=fKyXVFN8znk">
     <img alt="She works hard for the summer - Donna Summer"
          src="https://img.youtube.com/vi/fKyXVFN8znk/0.jpg" 
          style="width:10%;">
      </a>
</div>

## References

### Online

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

-   Jendrock, E. Cervera-Navarro, R. Evans, I. (2014). <i>The Java EE 7 Tutorial</i>. (Fifth Edition Volume 1). Addison Wesley
-   Jendrock, E. Cervera-Navarro, R. Evans, I. (2014). <i>The Java EE 7 Tutorial</i>. (Fifth Edition Volume 2). Addison Wesley
-   Ćmil, M. (29th December 2014). <i>Java EE 7 Development with WildFly</i>. (First Edition). Packt Publishing
-   Mihalcea, V. (October 2016). <i>High-Performance Java Persistence</i>. (First Edition). Vlad Mihalcea
-   Gonçalves, A. (June 2013). <i>Beginning Java EE 7</i> (First Edition). Apress

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
