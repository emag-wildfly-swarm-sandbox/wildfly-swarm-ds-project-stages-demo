# wildfly-swarm-ds-project-stages-demo

WildFly Swarm Datasource and Project Stages Demo

## Usage

### Run App

``` sh
$ ./mvnw clean package \
  && java -jar target/wildfly-swarm-ds-project-stages-demo-swarm.jar
```

``` sh
$ curl localhost:8080 
{"conn": "org.jboss.jca.adapters.jdbc.jdk7.WrappedConnectionJDK7@..."}
```

### Run the test

``` sh
$ ./mvnw clean verify \
  -Dswarm.project.stage.file=file://`pwd`/src/main/resources/project-stages.yml
```
