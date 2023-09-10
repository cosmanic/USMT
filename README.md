# springboot-docker-ecs
Run your Docker image on AWS ECS (Elastic Container Service)

### Required commands

- Build Docker Image.

		mvn spring-boot:build-image  --create image using springbuildpck  no need of dockerfile
   
- Run Docker Image.

		docker run --tty --publish 8080:8080 <image-name>
    
- Tag Docker Image

		docker tag <image-name> tag-name/<image-name>

The command to tag an image using an imageId is as follows:

    docker tag 46ee47a7422d baeldung-java:9

- Push Docker Image to Docker Hub

		docker push tag-name/<image-name>
		
- Application Flow  

<img width="576" alt="11" src="https://user-images.githubusercontent.com/25712816/91267149-570d0780-e790-11ea-8497-806b30cbcfc2.PNG">

-------------------------dockerfile example----------
FROM openjdk:11
LABEL maintainer="com.Opera"
ADD target/spring-boot-jenkins-integration.jar spring-boot-jenkins-integration.jar
ENTRYPOINT ["java","-jar","spring-boot-jenkins-integration.jar"]

-----------------------------------------


1.	mvn clean install
2.	Start the docker application
3.	docker build -f Dockerfile -t aws-csr_spring-boot .   ---> to create image using dockerfile
4.	docker images
5.	docker run -p 8080:8080 aws-csr_spring-boot

Run below commands for docker hub
-----------------------------------
docker tag aws-csr_spring-boot:latest mail4dhananjaya/aws-csr_spring-boot:latest
docker push mail4dhananjaya/aws-csr_spring-boot:latest  [IMG Location:  docker.io/mail4dhananjaya/aws-csr_spring-boot]



AWS CLI Commands
----------
1.  aws configure [set user name and password to aws cli]
2.	aws ecr get-login-password --region us-east-2 | docker login --username AWS --password-stdin <accID>.dkr.ecr.us-east-2.amazonaws.com
3.	docker tag realspeed:latest <accID>.dkr.ecr.us-east-2.amazonaws.com/realspeed:latest
4.	docker push <accID>.dkr.ecr.us-east-2.amazonaws.com/realspeed:latest



![Capture](https://user-images.githubusercontent.com/25712816/92306201-ef826380-efaa-11ea-9704-5304319e0517.PNG)

add aws code build then in thir role add two permission AmazonEC2ContainerRegistryFullAccess and AmazonEC2ContainerRegistryPowerUser

----------------docker image pull on local-------------------------

mvn spring-boot:build-image  --to build docker image

docker pull errajeevranjanmailid/usmt:0.0.2-SNAPSHOT  ---to pull docker image of app


docker network create springboot-postgres  --create network

docker pull postgres --- pull postgres image

docker run --name postgresql --network springboot-postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=password -p 5432:5432 -v /data:/var/lib/postgresql/data -d postgres

docker exec -it 6ef36ea49ec6 bash  -- to enter in container

psql -h localhost -p 5432 -U postgres -d postgres   --login in database

CREATE DATABASE usmt;

docker run --network springboot-postgres --name springboot-postgres-container -p 8080:8080 usmt:0.0.1-SNAPSHOT


--------------------------------

install docker on ec2

sudo yum update -y

sudo yum install docker

sudo service docker start

sudo docker pull shiprasingh2/samsung:1

sudo docker run -p 80:9091 --name spring-docker shiprasingh2/samsung:1


in28min/aws-hello-world-rest-api:1.0.0-RELEASE --image with min size




-------------------------
connect through ssh to ec2 instance

ssh -i .\dockerkeypair.pem ec2-user@13.126.104.206

