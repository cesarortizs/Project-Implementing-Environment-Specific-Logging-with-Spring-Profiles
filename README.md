**How to set up the project**
<br><br>
We will need to create an user called "prueba" with the password "12345" on our MySQL instance and grant it permissions to read, create, update and delete registries using the commands found below, alternatively we can modify the "application.properties" file to configure our own username and password combo:
<br><br><br>
*CREATE USER 'prueba'@'localhost' IDENTIFIED BY '12345';*
<br><br>
*GRANT CREATE, ALTER, DROP, INSERT, UPDATE, DELETE, SELECT, REFERENCES, RELOAD on \*.\* TO 'prueba'@'localhost' WITH GRANT OPTION;*
<br><br><br>
A database named "SpringBootActivityFour" is also required, we can create it using the following command:
<br><br><br>
*CREATE DATABASE SpringBootActivityFour;*
<br><br><br>
We also need a table called "users" that can be created using the following command:
<br><br><br>
*CREATE TABLE users*
*(id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,*
*username VARCHAR(100) NOT NULL,*
*password VARCHAR(100) NOT NULL);*
<br><br><br>
**How to run the application**
<br><br>
The application runs on port 8081, 8082 or 8083 depending on the profile, it will not ask for authentication as its a very basic spring boot project, it comes configured with the previous database specifications but it will not automatically create any table, therefore the need to create our "users" table on MySQL directly.
<br><br><br>
The application handles exceptions if we make a request with an incorrect HTTP method to an existing endpoint, if we send an incorrect body to an specific endpoint (incomplete or with wrong types) and if we request a non existing resource from an endpoint.
<br><br><br>
It also has three profiles, one for developing that runs on port 8081, one for testing that runs on port 8082 and one for production that runs on port 8083, we can choose our desired one by modifying the "spring.profiles.active" property on the "application.properties" file.
<br><br><br>
The applications has a logger that will record all the relevant events in the application, this varies according to the selected profile, it we choose the developing or testing one it will log events from the DEBUG level and up and they won't be saved on an external file, alternatively if we choose the production profile it will log events from the WARN level and up and they will be saved on an external file in the route "/logs/app.log" of the application, we can modify these logging configurations in the "logback-spring.xml" file
<br><br><br>
**API endpoints and sample requests for testing**
<br><br>
The application has three endpoints:
<br><br><br>
*GET /users*
<br><br>
This will return a list with all the users registered in the "users" table
<br><br><br>
*POST /users*
<br><br>
We can send a request body with the properties of an user object to create and insert it in the "users" table as presented below:
<br><br>
*{*
*"username": "BartSimpson25",*
*"password": "aycaramba"*
*}*
<br><br><br>
*DELETE /users/{id}*
<br><br>
We can replace {id} with the number of the id of an specific user in the "users" table, it will delete its registry
