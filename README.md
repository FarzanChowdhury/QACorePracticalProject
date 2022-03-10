# QACorePracticalProject

Farzan Chowdhury
Google Slides Presentation Link - https://docs.google.com/presentation/d/1UZaoKG8qGTzLUwG7stVoEoVV1WC1oe1bhZsSFOclRt8/edit#slide=id.p
Jira - https://farzanchowdhuryy.atlassian.net/jira/software/projects/QS/boards/2

This is the second project done at QA Academy between week 8 and 9. It is a program that uses Java and mySQL as backend program. HTML, CSS and Javascript as a frontend program.

### Introduction

The requirements was to create a CRUD application that covered all the core modules covered during the training:

- You will need to plan your project, which can be created at https://www.atlassian.com/software/jira
- You will need a local installation of git, an example of this would be git bash which can be downloaded at https://git-scm.com/downloads
- You will need an IDE which can run JAVA SE & Spring Boot, an example of this would be Eclipse which can be downloaded at https://www.eclipse.org/downloads/
- You will need a software that can interact with the database outside of the application, an example would be mySQL wich can be downloaded at https://dev.mysql.com/downloads/windows/installer/8.0.html
- You will need a software to package and run tests on the backend application, an example would be MockMCV which can be downlaoded at https://maven.apache.org/download.cgi
- You will need a software to create a frontend application, an example would be HTML, CSS and JavaScript which can be downlaoded at https://code.visualstudio.com/download

### Planning Resouces

Using Jira, I created a Kanban board modelled as a Scrum and created the epics and user-stories. I created any blockers for the front and back end of my project to help the structure of the build.

I created 12 user stories:
![user-stories](https://github.com/FarzanChowdhury/QACorePracticalProject/blob/dev/Screenshots/2022-03-10-1.png?raw=true)

Within each user-story, I had about 3 child issues in each and any blockers if necessary:
!![child issues](https://github.com/FarzanChowdhury/QACorePracticalProject/blob/dev/Screenshots/2022-03-10-7.png?raw=true)

I Created 5 epics in total which I linked with my user-stories:
![epics](https://github.com/FarzanChowdhury/QACorePracticalProject/blob/dev/Screenshots/2022-03-10.png?raw=true)

I created a sprint which I could update throughout the project. 
I updated my Jira board by editing the sprint whenever I completed a user-story, child issue or blocker.
After finishing the project, I completed my sprint.

For version control, I used GitHUb to manage my repository for both my frontend and backend work:
![GitHub](https://github.com/FarzanChowdhury/QACorePracticalProject/blob/dev/Screenshots/2022-03-10-6.png?raw=true)


### Databases

I created two types of databases.
The first database was MySQL which I used to create my database and store any persistent data from the application.
I used my ERD to help me create the MySQL database.
The other database was h2 which I used as an in-storage database for Java which was used for all the testing.

![mySQL](https://github.com/FarzanChowdhury/QACorePracticalProject/blob/dev/Screenshots/2022-03-10-2.png?raw=true)


### Backend

The backend was created using Java in a Spring Boot Framework. I made sure the mappings in my code was met with the requirements of my Jira board.

![Eclipse](https://github.com/FarzanChowdhury/QACorePracticalProject/blob/dev/Screenshots/2022-03-10-3.png?raw=true)

### Integration Tests 

My integration tests covers the CatController.
I reached a coverage of 92.4%

Controllers : The MockMVC tests simulates user-input to check that objects are created and handled properly.

A user of a program would perform mock HTTP requests, and this allowed me to test to see if each outcome of the HTTP endpoint was correct.

![Test](https://github.com/FarzanChowdhury/QACorePracticalProject/blob/dev/Screenshots/2022-03-10-4.png?raw=true)

This above test in located in src/test/java/com.qa.cat/web/CatControllerIntegrationTest.java and it uses MockMVC.

### Frontend

I created the front-end using HTML, CSS and JavaScript. I made sure to link both my script.js and styles.css files in my HTML file.
I also used the Bootstrap framework.

HTML was used to design the actual webpage.
CSS was used to style my webpage such as the background and how the borders looked.
JavaScript was used to show the the existing data in the database, also it was used for the update and delete function.

![Webpage](https://github.com/FarzanChowdhury/QACorePracticalProject/blob/dev/Screenshots/2022-03-10-5.png?raw=true)
