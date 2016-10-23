# AMT - ALBASINI Romain, SELIMI Dardan

## Introduction
This project is a Java EE Web Application running Docker images for easy deployment. 

It lets a user login to an existing account or create a new one. Once logged in, access to userlist is given.

Used technologies : Java EE, MySQL, Docker, Javascript

The whole project relies on Docker images and on a Docker Compose topology. The deployment can be done easily. 


## Installation
Installation is really straightforward with Docker-Compose.

1. Clone this repo
2. Build the application to generate the war file. We could not upload it on github because it was too heavy.
2. Open a Docker terminal and move to the topology-amt folder.
3. Execute the following commands : 
`docker-compose down` 
`docker-compose up`

## General use
The installation deployed the WildFly, PHPMyAdmin and MySQL images.
Useful URLs : 
- Homepage : http://192.168.99.100:9090/amt/home
- Login : http://192.168.99.100:9090/amt/login
- Register : http://192.168.99.100:9090/amt/register
- Home page Protected against non authentified users : http://192.168.99.100:9090/amt/home

*This address depends on the docker environment. Please verify it*

## Project Structure


  id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT
  
  firstName VARCHAR(45) NOT NULL
  
  lastName VARCHAR(45) NOT NULL
  
  email VARCHAR(45) NOT NULL
  
  _password VARCHAR(45) NOT NULL
  
  
## Postman
This script can be used to test the API REST:

Script_AMT_Albasini_Selimi.postman_collection.json

## REST API - CRUD

Entrypoints implemented:

@GET Two versions are implemented. The first get can the list of all the users and the second one gives the possibility of retreiving a user by its lastname.

@POST Add a user in the structure (database).

@PUT Update one user's personal data.

@DELETE Delete a user.










