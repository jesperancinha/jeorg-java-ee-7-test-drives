# jee-app-2-2-wildfly

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

1. `URL Rewriting`, `Session`, `Cookie`
2. `soapenv:Envelope`, `soapenv:Header`, `soapenv:Body`, ` @Resource`, `@WebService`, `endpointInterface`
   , `@SOAPBinding(style = SOAPBinding.Style.RPC)`
3. `@CookieParam`, `JAX-WS`, `Cookie`, `WebServiceContext`
4. `@WebParam`, `@WebResult`
5. `Random Access`, `JAXB`, `Memory footprint`, `Multiple times processing`
6. `@WebFilter`, `HttpSession`, `@SessionScoped`, `@Named`, `FilterChain`
7. `Filter`, `web.xml`, `order`, `WebFilter`, `<filter>`, `<filter-mapping>`, `<filter-name>`, `<filter-class>`
   , `<init-param>`
8. `<jsp:useBean`, `JSP`, `Servlet`, `HttpServlet`
9. `Filter`, `web.xml`, `order`, `direct references`
10. `Session`, `invalidate`, `IllegalStateException`

## Test Endpoints

1. http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/
2. http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/left?leftName=Viva - URL Rewriting Session Management
3. http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/store_main.jsp - URL Rewriting, Http Session and Cookie Management
4. http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/be-there - SOAP Session management (note that this is only pulling the HTTP session out.)
5. http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/be-there?wsdl - SOAP Session management (note that this is only pulling the HTTP session out.)
6. http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/app/cookie - Sending cookies via SOAP Session Management and JAX-WS (notice that it's WS and not RS.)
7. http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/underground - @Webparam and @WebResult
8. http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/underground?wsdl - @Webparam and @WebResult
9. http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/app/registry - Random access and JAXB
10. http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/app/secure/lyrics/spice - @WebFilter studies
11. http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/CaghtUpInTheMiddle - Filter, web.xml and order
12. http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/love.jsp - JSP and Servlet
13. http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/CaghtUpInTheMiddle2 - Filter, web.xml, order and direct references
14. http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/spice - Session invalidation exercise

- Note that URL rewriting can happen via SOAP by using proxies that change the port definition as in the example:

From this:

```xml

<service name="BeThereLyricsServiceImplService">
    <port name="be-therePort" binding="tns:be-therePortBinding">
        <soap:address location="http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/be-there"/>
    </port>
</service>
```

To This:

```xml

<service name="BeThereLyricsServiceImplService">
    <port name="be-therePort" binding="tns:be-therePortBinding">
        <soap:address location="http://whatever:whateverport/whatever-path/be-there-whatever"/>
    </port>
</service>
```

### SOAP requests

#### Envelopes

```xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:bt="http://soap.bands.girl.jee.jtd.jesperancinha.org/">
    <soapenv:Header/>
    <soapenv:Body>
        <bt:sayYoullBeThere>
            <arg0>Ah, say you'll be there</arg0>
        </bt:sayYoullBeThere>
    </soapenv:Body>
</soapenv:Envelope>
```

```xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:underground="http://soap.bands.girl.jee.jtd.jesperancinha.org/">
    <soapenv:Header/>
    <soapenv:Body>
        <underground:bandMembers>
        </underground:bandMembers>
    </soapenv:Body>
</soapenv:Envelope>
```

```xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:underground="http://soap.bands.girl.jee.jtd.jesperancinha.org/">
    <soapenv:Header/>
    <soapenv:Body>
        <underground:underground>
            <pieceNumber>0</pieceNumber>
        </underground:underground>
    </soapenv:Body>
</soapenv:Envelope>
```

#### Command line

Note that we are keeping cookies in [cookies.txt](cookies.txt) file.

```bash
curl --header "Content-Type: text/xml;charset=UTF-8" --header "SOAPAction:be-therePortBinding" --data @line1.xml http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/be-there?wsdl -c "cookies.txt" -b "cookies.txt"
curl --header "Content-Type: text/xml;charset=UTF-8" --header "SOAPAction:be-therePortBinding" --data @line2.xml http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/be-there?wsdl -c "cookies.txt" -b "cookies.txt"
curl --header "Content-Type: text/xml;charset=UTF-8" --header "SOAPAction:be-therePortBinding" --data @line3.xml http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/be-there?wsdl -c "cookies.txt" -b "cookies.txt"
curl --header "Content-Type: text/xml;charset=UTF-8" --header "SOAPAction:be-therePortBinding" --data @line4.xml http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/be-there?wsdl -c "cookies.txt" -b "cookies.txt"
curl --header "Content-Type: text/xml;charset=UTF-8" --header "SOAPAction:be-therePortBinding" --data @line5.xml http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/be-there?wsdl -c "cookies.txt" -b "cookies.txt"
curl --header "Content-Type: text/xml;charset=UTF-8" --header "SOAPAction:be-therePortBinding" --data @line6.xml http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/be-there?wsdl -c "cookies.txt" -b "cookies.txt"
curl --header "Content-Type: text/xml;charset=UTF-8" --header "SOAPAction:be-therePortBinding" --data @line7.xml http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/be-there?wsdl -c "cookies.txt" -b "cookies.txt"
```

```bash
curl --header "Content-Type: text/xml;charset=UTF-8" --header "SOAPAction:undergroundPortBinding" --data @band.xml http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/underground?wsdl -c "cookies.txt" -b "cookies.txt"
curl --header "Content-Type: text/xml;charset=UTF-8" --header "SOAPAction:undergroundPortBinding" --data @underground1.xml http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/underground?wsdl -c "cookies.txt" -b "cookies.txt"
curl --header "Content-Type: text/xml;charset=UTF-8" --header "SOAPAction:undergroundPortBinding" --data @underground2.xml http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/underground?wsdl -c "cookies.txt" -b "cookies.txt"
```

We can also try sending cookies:

```bash
curl http://localhost:8080/jeorg-jee-app-2-2-wildfly-1.0.0-SNAPSHOT/app/cookie -b "beThereCookie=Tell me will this deja vu never end? Oh"
```

## Run Arquillian tests

```bash
jenv local system
sdk use java 11.0.9.hs-adpt
mvn clean install -Parq-wildfly-managed
```

## Context References

- [Spice Up Your Life](https://en.wikipedia.org/wiki/Spice_Up_Your_Life)
- [Eye Candy (album)](https://en.wikipedia.org/wiki/Eye_Candy_(album))
- [Mis-Teeq](https://en.wikipedia.org/wiki/Mis-Teeq)
- [Say you'll be there - Spice Girls by Wikipedia](https://en.wikipedia.org/wiki/Say_You%27ll_Be_There)
- [Girls Aloud](https://en.wikipedia.org/wiki/Girls_Aloud)

<div align="center">
      <a href="https://www.youtube.com/watch?v=V9Wv4SCBiTE">
     <img alt="Sound of the Underground - Girls Aloud"
          src="https://img.youtube.com/vi/V9Wv4SCBiTE/0.jpg" 
          style="width:10%;">
      </a>
      <a href="https://www.youtube.com/watch?v=9wfpXI5PKlw">
     <img alt="Spice up your life - Spice Girls"
          src="https://img.youtube.com/vi/9wfpXI5PKlw/0.jpg" 
          style="width:10%;">
      </a>
</div>
<div align="center">
      <a href="https://www.youtube.com/watch?v=S1kE0MMfr20">
     <img alt="Scandalous - Mis-Teeq"
          src="https://img.youtube.com/vi/S1kE0MMfr20/0.jpg" 
          style="width:10%;">
      </a>
      <a href="https://www.youtube.com/watch?v=rnHVIuBlAUo">
     <img alt="In the middle - Sugababes" 
          src="https://img.youtube.com/vi/rnHVIuBlAUo/0.jpg" 
          style="width:10%;">
      </a>
</div>

## References

### Online

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
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/instagram-20.png "Instagram")](https://www.instagram.com/jesperancinha/)
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
