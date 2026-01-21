FROM tomcat:9.0-jdk17

# Remove default apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR
COPY SAVEN_BITES.war /usr/local/tomcat/webapps/ROOT.war

# Railway provides PORT dynamically
ENV PORT=8080

# Make Tomcat use Railway PORT
CMD ["sh", "-c", "sed -i \"s/port=\\\"8080\\\"/port=\\\"$PORT\\\"/\" /usr/local/tomcat/conf/server.xml && catalina.sh run"]
