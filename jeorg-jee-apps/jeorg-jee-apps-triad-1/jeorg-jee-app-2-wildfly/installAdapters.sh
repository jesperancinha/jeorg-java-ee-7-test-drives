#!/bin/sh

cd ../../wildfly-16.0.0.Final/bin


rm -r ../modules/jee-app-2-wildfly-adapter
rm -r ../modules/jee-app-2-wildfly-lib
rm -r ../modules/activemq-rar-5


./jboss-cli.sh -c --command="module add --name=jee-app-2-wildfly-adapter.rar --resources=../../jee-apps-triad-1/jee-app-2-wildfly-adapter/rars/jee-app-2-wildfly-adapter.rar"
./jboss-cli.sh -c --command="module add --name=activemq-rar-5.16.0.rar --resources=../../jee-apps-triad-1/jee-app-2-wildfly/activemq-rar-5.16.0.rar"
