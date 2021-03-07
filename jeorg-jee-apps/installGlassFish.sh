#!/bin/sh
echo "WARNING - This version does now allow you to use Java 11 - Press CTRL - C to stop this."
echo "If you are sure of this, please press any other key to continue..."
read
wget http://download.oracle.com/glassfish/5.0/nightly/latest-glassfish.zip
#wget http://download.oracle.com/glassfish/4.1.2/nightly/latest-glassfish.zip
#wget http://download.oracle.com/glassfish/4.0/nightly/latest-glassfish.zip
unzip latest-glassfish.zip