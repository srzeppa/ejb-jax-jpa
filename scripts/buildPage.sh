#!/bin/sh

echo 
~/glassfish3/glassfish/bin/asadmin undeploy ejb-jax-jpa
echo 
mvn package
echo 
~/glassfish3/glassfish/bin/asadmin deploy target/ejb-jax-jpa.war
