# ContactSearch
Search for entities in DB with regular expression. Spring Boot. REST. Postgres.
Application could be run from console. 
Run in application root folder 
mvn clean compile package
Then 
java -jar target/demo-0.0.1-SNAPSHOT.jar
In case default java installed in your computer is 9+, install java 8 and provide path to it in this command. Othewise, you might get "NoClassDefFoundError: javax/xml/bind/JAXBException". 

On start, Application connects with postgresql-database with url: jdbc:postgresql://localhost:5432/postgres
User with credentials
username=postgres
password=nbuser
should exist.
Application created table "contacts" and fills it with test data.
[![Build Status](https://travis-ci.org/ofesenyuk/ContactSearch.svg?branch=master)](https://travis-ci.org/ofesenyuk/ContactSearch)

I found that class order {ContactServiceTestConfig.class, HelloControllerTestConfig.class} in HelloControllerTest is essential. This is because HelloControllerTestConfig ContactService Bean creation should override that of ContactServiceTestConfig. I left it for further investigation. 