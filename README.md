# Book Reviewer - CRUD Web App
## Table of Contents
* [Usage](#usage)
* [Technologies](#technologies)
* [Setup](#setup)
* [Risk Assessment](#risk_assessment)
* [Links](#links)
* ...

## Overview
The goal of this project was to create a simple CRUD (create, read, update, delete) web app. I have created a  website where users can upload, edit and delete reviews about books.


## Technologies
Project created using:
* Scrum Board: Jira
* Database: GCP Managed SQL Server, H2 Client Side for testing
* Programming language: Java with Spring Boot
* Front-end: HTML, CSS and JavaScript
* API Development Testing: Postman and Swagger
* Unit Tests: JUnit and Mockito
* Integration Test: Spring MVC
* Version Control: Git

## Front-End 
[Front-end repo](https://github.com/DylanRitchings/book-reviewer-frontend)

## Project Tracking
In Jira MOSCOW prioritization was used. Only the must have stories were implemented.
![Jira board](https://i.ibb.co/N3MTTSm/Jira-Board.png)

## Javascript function diagram
This diagrams shows the different types of functions and how they call eachother in the JS frontend. 
![JS frontend diagram](https://i.ibb.co/cQr3Fjc/js-diagram.png)


## Flowchart backend to frontend

## Java UML

## Current ERD
![Current ERD](https://i.ibb.co/4ScBzsN/ERD1.png)


## Proposed ERD
This is a planned SQL structure.
![Database ERD](https://i.ibb.co/tKc4JCf/FinalERD.png)


## Risk Management
A risk is an event that is uncertain that will cause an effect on an objective.
* Qualitative risk assessment where risks are split into impact and likelyhood.
* **Risk Category:** What the risk impacts. For this current project completion rate is the most important category due to to the limited time for completion.
* **Likelyhood:** How likely the event is to occure.
* **Impact:** How much the category is impacted if the event occurs.
A response to the risk is then formulated. The response will either remove the risk completely, reduce its serverity or explain what was done to attempt to reduce the serverity.

[Risk assessment table](https://docs.google.com/spreadsheets/d/1gf561jse1gIF4EhFd0s3GI9c2I2v-i698AgeN7aMWQ4/edit?usp=sharing)

## Testing
Two types of tests were used for this project. Junit and Mockito were used for unit tests which test each individual function on its own to assert it produces the correct output. Mockito allows the parts of the application that are not being tested to be mocked. Junit handles the assertions which check whether the correct output has been output. For this application services and controllers were unit tested.
This is the coverage with the two unit tests:

Integration testing is used to test parts of the application together. Spring Mock MVC was used to mock JSON calls to application. H2 database was used to mock the database so that testing data was not saved to the production database. The controller was used as the test input. The other parts of the application were tested through the controller.
This is the coverage report for all the tests:
![Integration test coverage](https://i.ibb.co/R0XNYxq/Screenshot-from-2021-03-07-13-07-18.png)


## Describe workflow?

## Integration test specification, records and details of any failures


## Links
* [Front-end low level design](https://drive.google.com/file/d/1xLXwMK-aSNpBKKriDs_NNFMP2Qqk-3go/view?usp=sharing)
* Web app
* Documentation
* Issue tracker?



## More section ideas

* Scope of functionalities 
* Examples of use
* Project status 
* Sources
