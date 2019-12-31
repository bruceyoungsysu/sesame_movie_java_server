# Sesame Movie Java Server

#### Overview

In this repository, we implement the Java server of the [Sesame Movie](https://sesame-movie.herokuapp.com/). The Java server handles the communication between the relational database and the front end utilizing the MVC architecture. In the model module, we implement the class of each entity by specifying their constructor and setters and getters. It forms a sense of what information a class will take. Meanwhile, the crud repository handler of each entity is created correspondingly which simply extends the CrudRepository from the spring framework.

Both the entities and its curd repos are called in the service handlers. In each service handler, the @RestController annotation is used to create restful API for the front end. @Autowired annotation is used to link the service and repo. The logic of methods each post and get requests are calling are implemented in the service module of each entity annotated with corresponding get or post method. 

In the implementation of some methods, cookies are utilized to keep track of the user's session. In each session, we put the User class into a HttpSessionattribute curuser to authenticate the user who is sending HTTP requests.

#### Implementation

The logic of back end service of Sesame Movie can be separated into the following entities/classes:

**The movie entity**: holds the information of a movie and this information can be used to formalize a movie card. The information of a movie includes the title, production date, poster, introduction, casts, reviews, etc. All of the information is requested directly from the movie database API thus no entity and service are implemented to handle the requests. Each movie is identified with a unique movie id in the API.

**The user entity**: The user entity holds the information to identify a user including the user name, password and email address. When registering, the user needs to provide this information. The user service module provides the functions to register or login as a specific user, getting the profile of a user and logout the session of the current user. Each user is identified with a generated user id.

**The like entity**: The like entity holds the information about a certain user likes a certain movie. It uses the user_id to identify each user and movie_id to identify each movie. Also, it utilizes a boolean variable to note whether this user likes this movie. If a record does not exist in the database, it means the user has not provided the preference over this movie which means the user does not like it by default.

#### Notes

In each service module we handled the cors issue by setting the following annotation:

`@CrossOrigin(origins="https://sesame-movie.herokuapp.com", allowCredentials = "true", allowedHeaders = "*")`