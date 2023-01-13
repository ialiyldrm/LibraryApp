# LibraryApp

* LibraryApp is the backend of a web application built using Java Spring Boot.
* The Controller-Service-Repository pattern is used.

## Controllers

A controller is a class used to perform the backend operations of a web application. It receives the user's request, 
performs the necessary operations, and returns the result to the user. 

The controller accesses data access layers (such as a database) or other services (such as a web service) to perform these operations.
After performing these operations, the controller creates HTTP responses that return the results to the user.

## Services

The service layer is an architectural pattern that separates the business logic of an application from the data access layer and user interface. 
It encapsulates specific functionality or set of business logic in a service class, providing a higher-level abstraction and making the codebase more modular and maintainable. 
The BookService and UserService classes in the provided code are examples of service classes that manage their respective entities 
using repository and provide methods for performing various operations on them.

### USerService

The UserService class is a service class that provides methods for managing User entities.
It has a single dependency UserRepository which is used to perform CRUD operations on User entities in the database.
UserService class has a method getAllUsers() which returns a list of all the User objects from the database.
saveOneUser(User newUser) method takes a new User object and saves it to the database.
getOneUserById(Long userId) returns a single User object based on the id.
updateOneUser(Long userId, User newUser) method updates the information of the User based on the id and new User object.
deleteById(Long userId) method deletes the User from the database based on the id. It also handles the scenario when 
the user does not exist in the database and returns an appropriate message.

### BookService
The BookService class is a service class that provides methods for managing Book entities.
It has two dependencies, BookRepository and UserService. BookRepository is used to perform CRUD operations on Book entities in the database 
and UserService is used to retrieve User entities associated with a Book.
BookService class has method getAllBooks(Optional<Long> userId) which returns a list of BookResponse objects. 
If the userId is present, it filters the books based on the userId, otherwise it returns all the books.
createOneBook(BookCreateRequest newBookRequest) method takes a request object which contains the information of the book 
and creates a new book and saves it to the database.
getOneBookById(Long bookId) returns a single book based on the id. updateOnePostById(Long bookId, BookUpdateRequest bookUpdateRequest) 
method updates the information of the book based on the id and request object. deleteOneBookById(Long bookId) deletes 
the book from the database based on the id.

## Repositories

Repositories are a pattern in software development used to separate the logic for retrieving and manipulating data from the rest of the application. 
They provide a consistent and organized way to interact with a data source, such as a database.

In Java, repositories are typically implemented as interfaces that extend a base repository interface, such as Spring Data's JpaRepository. 
These interfaces can be parameterized with the entity type and its primary key type, allowing them to perform CRUD operations on those entities.

## Entities

Entities are classes that represent tables in a database. The database is communicated using JPA.
These classes can be used to read, write, update and delete data in the database.

## Exception

The **UserNotFoundException** and **BookNotFoundException** are custom exception classes in Java, specifically for 
handling the scenario when a user or book is not found in the system. Both of them are child classes of **RuntimeException**
which means they are unchecked exceptions and it doesn't need to be declared in the method signature. 
They both have two constructors, one without any arguments, and the other that takes a String message as an argument. 
This message can be used to provide more information about the specific exception that occurred. These exceptions can be 
thrown in their respective Service classes, for example, when a user attempts to retrieve,update or 
delete a user/book that does not exist in the system, the appropriate message can be passed in the exception 
and it can be handled in the layer where it is caught.


