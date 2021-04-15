# jee-app-2-wildfly-ws

## References

### Online

- [28.1 Creating a Simple Web Service and Clients with JAX-WS](https://docs.oracle.com/javaee/7/tutorial/jaxws001.htm)
- [JAX-WS Hello World Example – RPC Style](https://examples.javacodegeeks.com/enterprise-java/jws/jax-ws-hello-world-example-rpc-style/)
- [Hello World JAX-RS Application](https://www.journaldev.com/9191/java-web-services-tutorial)
- [Create a Java Web Service (SOAP RPC) for WildFly](https://www.learn-it-with-examples.com/development/java/java-web-services/create-simple-java-web-service-soap-rpc-web-app.html)

### Books

- Jendrock, E. Cervera-Navarro, R. Evans, I. (2014). <i>The Java EE 7 Tutorial</i>. (Fifth Edition Volume 1). Addison Wesley
- Jendrock, E. Cervera-Navarro, R. Evans, I. (2014). <i>The Java EE 7 Tutorial</i>. (Fifth Edition Volume 2). Addison Wesley
- Ćmil, M. (29th December 2014). <i>Java EE 7 Development with WildFly</i>. (First Edition). Packt Publishing
- Mihalcea, V. (October 2016). <i>High-Performance Java Persistence</i>. (First Edition). Vlad Mihalcea
- Gonçalves, A. (June 2013). <i>Beginning Java EE 7</i> (First Edition). Apress
- R. Allen, P. J. Bambara, J. (2014). <i>OCM Java EE 6 Enterprise Architect Exam Guide</i>. (First Edition). McGraw-Hill
- Gupta, A. (August 2013). <i>Java EE 7 Essentials</i>. (First Edition). O'Reilly
- Dr Coward, D. (August 2013). <i>Java EE 7 The Big Picture</i>. (First Edition). McGraw-Hill

## Running

After deployment you can test the WSDL here:

- http://localhost:8080/jeorg-jee-app-2-wildfly-ws-1.0-SNAPSHOT/kitchen-herbs?wsdl

## Errors Reported While  Deploying

As part of the JEE learning experience, I've added exceptions here with a resolution for it.

### Error 1 - Apache CXF library (cxf-rt-transports-http-3.3.7.jar) detected in ws endpoint deployment

```shell
14:56:52,007 ERROR [org.jboss.msc.service.fail] (MSC service thread 1-4) MSC000001: Failed to start service jboss.deployment.unit."jee-app-2-wildfly-ws-1.0-SNAPSHOT.war".PARSE: org.jboss.msc.service.StartException in service jboss.deployment.unit."jee-app-2-wildfly-ws-1.0-SNAPSHOT.war".PARSE: WFLYSRV0153: Failed to process phase PARSE of deployment "jee-app-2-wildfly-ws-1.0-SNAPSHOT.war"
	at org.jboss.as.server@8.0.0.Final//org.jboss.as.server.deployment.DeploymentUnitPhaseService.start(DeploymentUnitPhaseService.java:183)
	at org.jboss.msc@1.4.5.Final//org.jboss.msc.service.ServiceControllerImpl$StartTask.startService(ServiceControllerImpl.java:1738)
	at org.jboss.msc@1.4.5.Final//org.jboss.msc.service.ServiceControllerImpl$StartTask.execute(ServiceControllerImpl.java:1700)
	at org.jboss.msc@1.4.5.Final//org.jboss.msc.service.ServiceControllerImpl$ControllerTask.run(ServiceControllerImpl.java:1558)
	at org.jboss.threads@2.3.3.Final//org.jboss.threads.ContextClassLoaderSavingRunnable.run(ContextClassLoaderSavingRunnable.java:35)
	at org.jboss.threads@2.3.3.Final//org.jboss.threads.EnhancedQueueExecutor.safeRun(EnhancedQueueExecutor.java:1982)
	at org.jboss.threads@2.3.3.Final//org.jboss.threads.EnhancedQueueExecutor$ThreadBody.doRunTask(EnhancedQueueExecutor.java:1486)
	at org.jboss.threads@2.3.3.Final//org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1377)
	at java.base/java.lang.Thread.run(Thread.java:832)
Caused by: org.jboss.as.server.deployment.DeploymentUnitProcessingException: WFLYWS0059: Apache CXF library (cxf-rt-transports-http-3.3.7.jar) detected in ws endpoint deployment; either provide a proper deployment replacing embedded libraries with container module dependencies or disable the webservices subsystem for the current deployment adding a proper jboss-deployment-structure.xml descriptor to it. The former approach is recommended, as the latter approach causes most of the webservices Java EE and any JBossWS specific functionality to be disabled.
	at org.jboss.as.webservices//org.jboss.as.webservices.deployers.WSLibraryFilterProcessor.deploy(WSLibraryFilterProcessor.java:70)
	at org.jboss.as.server@8.0.0.Final//org.jboss.as.server.deployment.DeploymentUnitPhaseService.start(DeploymentUnitPhaseService.java:176)
	... 8 more
```

<b>Solution<b>

Add a `proper` `jboss-deployment-structure.xml`. From [JBoss Application Server](https://cxf.apache.org/docs/application-server-specific-configuration-guide.html):

```xml

<jboss-deployment-structure xmlns="urn:jboss:deployment-structure:1.2">
    <deployment>
        <exclude-subsystems>
            <subsystem name="webservices"/>
        </exclude-subsystems>
    </deployment>
</jboss-deployment-structure>
```

### Error 2 - Managed bean with a parameterized bean class must be @Dependent

```shell
15:06:25,407 ERROR [org.jboss.msc.service.fail] (MSC service thread 1-3) MSC000001: Failed to start service jboss.deployment.unit."jee-app-2-wildfly-ws-1.0-SNAPSHOT.war".WeldStartService: org.jboss.msc.service.StartException in service jboss.deployment.unit."jee-app-2-wildfly-ws-1.0-SNAPSHOT.war".WeldStartService: Failed to start service
	at org.jboss.msc@1.4.5.Final//org.jboss.msc.service.ServiceControllerImpl$StartTask.execute(ServiceControllerImpl.java:1730)
	at org.jboss.msc@1.4.5.Final//org.jboss.msc.service.ServiceControllerImpl$ControllerTask.run(ServiceControllerImpl.java:1558)
	at org.jboss.threads@2.3.3.Final//org.jboss.threads.ContextClassLoaderSavingRunnable.run(ContextClassLoaderSavingRunnable.java:35)
	at org.jboss.threads@2.3.3.Final//org.jboss.threads.EnhancedQueueExecutor.safeRun(EnhancedQueueExecutor.java:1982)
	at org.jboss.threads@2.3.3.Final//org.jboss.threads.EnhancedQueueExecutor$ThreadBody.doRunTask(EnhancedQueueExecutor.java:1486)
	at org.jboss.threads@2.3.3.Final//org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1377)
	at java.base/java.lang.Thread.run(Thread.java:832)
Caused by: org.jboss.weld.exceptions.DefinitionException: WELD-000071: Managed bean with a parameterized bean class must be @Dependent: class org.apache.cxf.jaxrs.provider.AbstractCachingMessageProvider
	at org.jboss.weld.core@3.1.0.Final//org.jboss.weld.bean.ManagedBean.checkType(ManagedBean.java:211)
	at org.jboss.weld.core@3.1.0.Final//org.jboss.weld.bean.AbstractBean.initializeAfterBeanDiscovery(AbstractBean.java:108)
	at org.jboss.weld.core@3.1.0.Final//org.jboss.weld.bean.ManagedBean.initializeAfterBeanDiscovery(ManagedBean.java:122)
	at org.jboss.weld.core@3.1.0.Final//org.jboss.weld.bootstrap.ConcurrentBeanDeployer$AfterBeanDiscoveryInitializerFactory.doWork(ConcurrentBeanDeployer.java:111)
	at org.jboss.weld.core@3.1.0.Final//org.jboss.weld.bootstrap.ConcurrentBeanDeployer$AfterBeanDiscoveryInitializerFactory.doWork(ConcurrentBeanDeployer.java:102)
	at org.jboss.weld.core@3.1.0.Final//org.jboss.weld.executor.IterativeWorkerTaskFactory$1.call(IterativeWorkerTaskFactory.java:62)
	at org.jboss.weld.core@3.1.0.Final//org.jboss.weld.executor.IterativeWorkerTaskFactory$1.call(IterativeWorkerTaskFactory.java:55)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1130)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:630)
	at java.base/java.lang.Thread.run(Thread.java:832)
	at org.jboss.threads@2.3.3.Final//org.jboss.threads.JBossThread.run(JBossThread.java:485)
```

<b>Solution</b>

Change `jboss-deployment-structure.xml` to:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<jboss-deployment-structure>
    <ear-subdeployments-isolated>false</ear-subdeployments-isolated>
    <deployment>
        <exclude-subsystems>
            <subsystem name="jaxrs"/>
        </exclude-subsystems>
    </deployment>
</jboss-deployment-structure>
```

## About me 👨🏽‍💻🚀🏳️‍🌈

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/JEOrgLogo-20.png "João Esperancinha Homepage")](http://joaofilipesabinoesperancinha.nl)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/medium-20.png "Medium")](https://medium.com/@jofisaes)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=joaofilipesabinoesperancinha.nl&color=6495ED "João Esperancinha Homepage")](https://joaofilipesabinoesperancinha.nl/)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=jesperancinha&style=social "GitHub")](https://github.com/jesperancinha)
[![Twitter Follow](https://img.shields.io/twitter/follow/joaofse?label=João%20Esperancinha&style=social "Twitter")](https://twitter.com/joaofse)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/credly-20.png "Credly")](https://www.credly.com/users/joao-esperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=JEsperancinhaOrg%20Repos&color=yellow "jesperancinha.org dependencies")](https://github.com/JEsperancinhaOrg)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Articles&message=Across%20The%20Web&color=purple)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Articles.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Webapp&message=Image%20Train%20Filters&color=6495ED)](http://itf.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=All%20Badges&message=Badges&color=red "All badges")](https://joaofilipesabinoesperancinha.nl/badges)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=red "Project statuses")](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Status.md)
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
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/coursera-20.png "Coursera")](https://www.coursera.org/user/da3ff90299fa9297e283ee8e65364ffb)
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
