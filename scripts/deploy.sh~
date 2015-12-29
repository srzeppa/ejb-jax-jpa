echo "************ UNDEPLOYING *******************"
~/glassfish3/bin/asadmin undeploy jee-jax-jpa
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
~/glassfish3/bin/asadmin deploy target/jee-jax-jpa.war
