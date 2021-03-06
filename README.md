# Book Reviewer - CRUD Web App
## Table of Contents
* [Overview](#overview)
* [Technologies](#technologies)
* [Frontend Repository](#frontend-repository)
* [Risk Management](#risk-management)
* [Project Tracking](#project-tracking)
* [Frontend Design](#frontend-design)
* [Javascript Function Diagram](#javascript-function-diagram)
* [Frontend to Backend Data Flow Diagram](#frontend-to-backend-data-flow-diagram)
* [ERD](#erd)
* [Testing](#testing)
* [Future Improvements](#future-improvements)
* [Links](#links)

## Overview
The goal of this project was to create a simple CRUD (create, read, update, delete) web app. I have created a  website where users can upload, edit and delete reviews about books.


## Technologies
Project created using:
* Scrum Board: Jira
* Database: GCP Managed SQL Server, H2 Client Side for testing
* Programming language: Java with Spring Boot
* Front-end: HTML, CSS and JavaScript
* API Development Testing: Postman and Swagger
* Testing: JUnit, Mockito and Spring Test
* Version Control: Git

## Frontend Repository
[Frontend repo](https://github.com/DylanRitchings/book-reviewer-frontend)


## Risk Management
A risk is an event that is uncertain that will cause an effect on an objective.
* Qualitative risk assessment where risks are split into impact and likelihood.
* **Risk Category:** What the risk impacts. For this current project completion rate is the most important category due to to the limited time for completion.
* **Likelihood:** How likely the event is to occure.
* **Impact:** How much the category is impacted if the event occurs.
* **Matrix:** A matrix is used to assess the priority of each risk.
A response to the risk is then formulated. The response will either remove the risk completely, reduce its serverity or explain what was done to attempt to reduce the serverity.

[Risk assessment table](https://docs.google.com/spreadsheets/d/1gf561jse1gIF4EhFd0s3GI9c2I2v-i698AgeN7aMWQ4/edit?usp=sharing)

## Project Tracking
Jira was used to manage the project sprints. MOSCOW prioritization was used to assess what functionality needs to be implemented first. Only the "must have" user stories were implemented.
![Jira board](https://i.ibb.co/N3MTTSm/Jira-Board.png)

A definition of done (DOD) was created for each user story. This is an example of a DOD for the user story "AS A dev there MUST be a db and backend SO THAT book review information can be retrieved and sent to the frontend":
![DOD example](https://i.ibb.co/f9VZjQC/Screenshot-from-2021-03-07-17-43-50.png)

Tasks were created for each user story. This is an example of the tasks for the user story above:
![Tasks to complete](https://i.ibb.co/TPLrdhv/Screenshot-from-2021-03-07-17-46-03.png)

## Frontend Design
A [low level design](https://drive.google.com/file/d/1xLXwMK-aSNpBKKriDs_NNFMP2Qqk-3go/view?usp=sharing) was drawn on paper. The final design was created using HTML and CSS. This is the final frontend webpage:
![Frontend webpage](https://i.ibb.co/wcMLdNQ/Screenshot-from-2021-03-07-16-54-30.png)

## Javascript Function Diagram
This diagrams shows the different types of functions and how they call each other in the JS frontend:

![JS frontend diagram](https://i.ibb.co/cQr3Fjc/js-diagram.png)


## Frontend to Backend Data Flow Diagram
This diagram shows how data and requests are sent from the front-end to the backend:

![Frontend to backend data flow](https://i.ibb.co/wrn7s44/flow-chart.png)

## ERD
This is the current DB structure:

![Current ERD](https://i.ibb.co/4ScBzsN/ERD1.png)

This is a planned DB structure to allow for further functionality:

![Database ERD](https://i.ibb.co/tKc4JCf/FinalERD.png)


## Testing
Two types of tests were used for this project. Junit and Mockito were used for unit tests which test each individual function on its own to assert if it produces the correct output. Mockito allows the parts of the application that are not being tested to be mocked. Junit handles the assertions which check whether the correct output has been output in relation to the inputs and outputs of the mock classes. Both the services and controllers were unit tested.

Integration testing is used to test parts of the application together. Spring Mock MVC was used to mock JSON calls to application. H2 database was used to mock the database so that testing data was not saved to the production database. The controller was used as the test input. The other parts of the application were tested through the controller.
The unit and integration testing had the same coverage. This is the coverage report for all the tests:
![Integration test coverage](https://i.ibb.co/R0XNYxq/Screenshot-from-2021-03-07-13-07-18.png)


## Future Improvements
* Split the single database into multiple so that it is normalized and further features can be added with greater ease
* Include Java repository testing to make sure application is fully tested
* Create a way for users to search for reviews about specific books or authors
* Create book profile page so that users can see reviews for different books
* Integrate user accounts so that users can edit and delete their own reviews


## Links
* [Risk assessment table](https://docs.google.com/spreadsheets/d/1gf561jse1gIF4EhFd0s3GI9c2I2v-i698AgeN7aMWQ4/edit?usp=sharing)
* [Frontend repo](https://github.com/DylanRitchings/book-reviewer-frontend)
* [Frontend low level design](https://drive.google.com/file/d/1xLXwMK-aSNpBKKriDs_NNFMP2Qqk-3go/view?usp=sharing)


