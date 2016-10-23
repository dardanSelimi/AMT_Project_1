FROM jboss/wildfly:10.1.0.Final

MAINTAINER Dardan Selimi & Romain Albasini <dardan.selimi@heig-vd.ch & romain.albasini@heig-vd.ch>


COPY apps-dist/AMT_Project_API_REST-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/AMT_Project_API_REST-1.0-SNAPSHOT.war

COPY apps-dist/LoginWebPages-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/LoginWebPages-1.0-SNAPSHOT.war

COPY data/mysql-connector-java-5.1.40-bin.jar /opt/jboss/wildfly/standalone/deployments

COPY data/standalone.xml /opt/jboss/wildfly/standalone/configuration/

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

