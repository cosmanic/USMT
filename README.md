# springboot-docker-ecs
Run your Docker image on AWS ECS (Elastic Container Service)

### Required commands

- Build Docker Image.

		mvn spring-boot:build-image
   
- Run Docker Image.

		docker run --tty --publish 8080:8080 <image-name>
    
- Tag Docker Image

		docker tag <image-name> tag-name/<image-name>
    
- Push Docker Image to Docker Hub

		docker push tag-name/<image-name>
		
- Application Flow  

<img width="576" alt="11" src="https://user-images.githubusercontent.com/25712816/91267149-570d0780-e790-11ea-8497-806b30cbcfc2.PNG">

1.	mvn clean install
2.	Start the docker container
3.	docker build -f Dockerfile -t aws-csr_spring-boot .
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


mvn spring-boot:build-image
docker network create springboot-postgres

docker run --name postgresql --network springboot-postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=password -p 5432:5432 -v /data:/var/lib/postgresql/data -d postgres

psql -h localhost -p 5432 -U postgres -d postgres
docker exec -it 6ef36ea49ec6 bash
CREATE DATABASE usmt;

docker run --network springboot-postgres --name springboot-postgres-container -p 8080:8080 usmt:0.0.1-SNAPSHOT


