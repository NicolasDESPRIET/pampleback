# PAMPLEBACK
pamplebak is our springboot java application. We crreate it for a student project. It's a part a our project to make a newQCMPLUS app.
There is the image of the data base too, set in docker

## Installation
***
A little intro about the installation. this application can be launched in a docker. 

### first step :
```
$ git clone https://github.com/NicolasDESPRIET/pampleback.git
$ cd ../path/to/the/folder
```

### We have to ways to start it. First way, with only bd in docker and without env file.
- first step: 
```
$ docker-compose -f docker-compose-db.yml up --build
```

- second step, depend:
```
$ mvn clean package -DskipTests
$ mvn spring-boot:run
```
or 
```
$ .\mvnw clean package -DskipTests
$ .\mvn spring-boot:run
```

Then, to apply the changes, you will just have to redo step 2.

### Second way, with bdd and back app in a docker, using an env file. It will be necessary to ask the env file to Nicolas Despriet.
After getting the .env, put it next to the docker-compose, then :
```
$ docker-compose -f docker-compose.yml up --build
```

that will build the project and start it. To apply modifications, you will need to down the containers and restart it:**
Ctrl+C in terminal or
```
$ docker-compose stop
```
after so :
```
$ docker-compose start
```
You can do both at the same time  :
```
$ docker-compose restart
```