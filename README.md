# PAMPLEBACK
pamplebak is our springboot java application. We crreate it for a student project. It's a part a our project to make a newQCMPLUS app.
There is the image of the data base too, set in docker

## Installation
***
A little intro about the installation.

To start the database :
```
$ cd ../path/to/the/folder
$ docker-compose up --build
```

for linux
```
$ git clone https://github.com/NicolasDESPRIET/pampleback.git
$ cd ../path/to/the/folder
$ mvn clean package -DskipTests
$ mvn spring-boot:run
```

for windows
```
$ git clone https://github.com/NicolasDESPRIET/pampleback.git
$ cd ../path/to/the/folder
$ .\mvnw clean package -DskipTests
$ .\mvn spring-boot:run
```
