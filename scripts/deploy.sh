echo "************ UNDEPLOYING *******************"
~/glassfish3/bin/asadmin undeploy ejb-jax-jpa
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
~/glassfish3/bin/asadmin deploy target/ejb-jax-jpa.war
