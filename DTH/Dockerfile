FROM tomcat:latest
ADD ./target/dthService-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
#ADD ./src/main/java/resources/application-test.properties  /usr/local/tomcat/webapps/application-test.properties
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/local/tomcat/webapps/dthService-0.0.1-SNAPSHOT.war"]
