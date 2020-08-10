# authentication-wizard
## Features
### Sign up:
A user can signup using an email. A verification link is sent to the corresponding email address. After verifying email address, signup process is completed.
### Sign in:
User can sign in using the verified email address and password provided during signup.

## Installation process
This installation process is for mac and linux server.
### System requirements:
1. Java 8+
2. Maven 3.6.0+
3. mysql
### Steps:
#### Clone the project
git clone https://github.com/ndatta41/authnetication-wizard.git
#### Run the db scripts from db-script folder
#### Set the following property values in application.properties file
##### Database
1. spring.datasource.username
2. spring.datasource.password
3. spring.datasource.serverName
##### Email server
1. spring.mail.fromaddress
2. spring.mail.host
3. spring.mail.port
4. spring.mail.username
5. spring.mail.password
## Build process
Use command: mvn clean install
## Run the application:
Go to home directory of the project and run "java -jar target/authentication-wizard.jar"
## Swagger link
http://localhost:9003/api/v1/swagger-ui.html
# my-app
