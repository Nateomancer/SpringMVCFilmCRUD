##Full Stack Film Query Database
This application implements full web-based C.R.U.D. (Create Read Update Delete) functionality, using Spring MVC and the DAO pattern. The DAO implementation uses JDBC to persist and retrieve data.  A user can search through the film database by either a film ID number or by a keyword in the title or description of the films in the database.  If the user looks up a film by a search keyword and a result or results are returned they will be listed in numerical order based on their ID, and their ID, Title, Description, Release Year, Rental Duration, Rental Rate, Length, Replacement Cost, Rating, and Special Features will be displayed.  If the user searched by film ID and the film is found, it will be displayed in the previously stated format with the additions of the film Category, a list of actors, along with the option to delete or edit the film or its values.  If the user deletes the film, it is removed from the database. If the delete fails the user is redirected to a page informing them of this. If a user edit’s a film, all of the film's current properties are displayed in a form, allowing them to change any property except the film's ID. When they submit the form, that film's record is updated in the database. If the update fails,  the user is redirecting to a page informing them of this. A user can also choose to add a new film. They will be presented with a form in which they can enter all the properties of the film and their input will be used to create a Film object, which the DAO implementation will save in the database. If the insert fails, the user is informed of this.

##Topics covered in Week 8:
- Apache web server and Tomcat
- Web Applications
- Java Servlets
- Web App path and structure
- Maven and web.xml configuration
- Web Archive (WAR) files
- HTTP Headers
- HTTP Status Codes
- GET vs. POST
- Java Server Pages (JSP)
- Gradle and tag libraries
- Data Access Objects (DAO) design patterns
- Spring Tool Suite
- Spring Application Contexts and Java Beans

##Lessons Learned
This project was one of the most challenging that we have completed during the course. The pace of creating a full-stack web application in less than three days was far more intense than what I expected. Success came only because of the strength of my teammates, who both brought their skills at the right time to keep the team moving forward. Applying a wide variety of new skills after less than a week of learning was extremely challenging, but we achieved our objectives.

Full-stack development is far more rewarding than the command-line based Java applications we have created before this point.  There's a true joy in being able to see a more visually appealing display of results from the projects we create.  I look forward to learning even more about front-end development and creating an even more beautiful application that has the potential to serve real-world uses.

Compartmentalization of objects is critical. In the MVC framework, database tables, Java objects, DAO methods and returned values/objects, and Controller methods all must align with each other and should be separated by their concerns in similar or identical ways. It's only in the display, the MVC View, that these separate parts should be merged to create a seamless fusion of components.
We learned how to manage developing a full stack application remotely, with using git as our repository. We had to work together to avoid conflicts, and resolve merge conflicts when one occurred.  Each of us brought a different set of skills and perspective to the group. We helped the group learn as a whole by demonstrating our strengths, and showing our weaknesses. We shared what we knew and and helped each other grow.

This was our first spring project, which meant that at times we didn’t know how to proceed.  Where one member understood JSPs, another understood how to create a controller, and the third knew JDBC. Anything we lacked as a team we were able to pull together and learn together. Executing CRUD statements in a Java Spring MVC application was a challenging part for us, but in the end we gained confidence. 