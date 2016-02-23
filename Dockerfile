FROM tomcat:7
ADD target/*.war /usr/local/tomcat/webapps/
echo EXPOSE 8080