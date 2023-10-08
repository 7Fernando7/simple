# PROJECT NAME
interfaces.ws.simple-int-api

## About
_(Brief description of the project.)_

## Features
_(Brief description of the functionalities.)_

> {environmentUrl}/interfaces.ws.simple-int-api/swagger-ui.html

## Architecture
_(Explication of both internal and external architecture, include architecture graphic with global design. Interaction with other applications, etc.)_
* The management of the properties is in [spring-cloud-configuration](https://gitlab.transfesa.com/alm/cloud-configuration-test)

* [Architecture-elasticsearch-logger](https://gitlab.transfesa.com/architecture/architecture-elastic-logger)
 
* [Architecture-jdbc](https://gitlab.transfesa.com/architecture/architecture-jdbc)
 
* [Architecture-tracing](https://gitlab.transfesa.com/architecture/architecture-tracing)
 
* [Architecture-utils](https://gitlab.transfesa.com/architecture/architecture-utils)


## Contributing
### Version control
_(Hosted in ...)_

### Prerequisites
_(For example ..:)_
* Requirements:
  - Java 1.8
  - Maven (can use mvnw included in project)
  - [Docker](https://www.docker.com/products/container-runtime#/download)

### Development
* How to run (spring local profile):
```
./mvnw spring-boot:run -Dspring.profiles.active=local
```

* How to build run docker image with ElasticSearch for logging in local:

> Pull ElasticSearch image from Docker hub:
```
docker pull elasticsearch
```
	
> Run image:
```
docker run -p 9200:9200 -p 9300:9300 id_image
```


### Programming Style Guides
_(Link to sharepoint with style guides. We should have style guides depending on technologies, equipment, clients, etc.)_

### Git
_(Link to Sharepoint on how to use the git. In most cases it will depend on technologies/equipment/customers.)_

### Deployment
For test and uat deployments, jenkins pipelines should be used:
* [interfaces.ws.simple-int-api-build](https://jenkins.transfesa.com/job/interfaces.ws.simple-int-api-build)

* [interfaces.ws.simple-int-api-release](https://jenkins.transfesa.com/job/interfaces.ws.simple-int-api-release)

For deployment in production, use the deployment procedure established for Transfesa [link to sharepoint]
* Contact person: _(Fill in ...)_
  

### Documentation
_(Link to project sharepoint.)_