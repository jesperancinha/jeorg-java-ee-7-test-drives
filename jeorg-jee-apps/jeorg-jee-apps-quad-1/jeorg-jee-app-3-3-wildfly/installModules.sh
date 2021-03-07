#!/bin/sh
cd ../../wildfly-16.0.0.Final/bin

wget  https://repo1.maven.org/maven2/org/postgresql/postgresql/42.2.18/postgresql-42.2.18.jar
rm -r ../modules/org/postgresql
rm -r ../modules/postgresql
./jboss-cli.sh -c --command="module add --name=postgresql --resources=postgresql-42.2.18.jar"
