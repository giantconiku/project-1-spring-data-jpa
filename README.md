## First Mini-Project with Spring Data JPA
##### `Lab 3:` Spring Boot Data Access with Spring Data JPA and Database Connection
##### `Course:` Enterprise Applications in Java
##### `Master:` Software Engineering
##### `Institutions:` Polytechnic University of Tirana & Lufthansa Industry Solutions

---

##### `Application:` BookCRUDApplication
    Technology stack:
    1️⃣ Spring Boot
    2️⃣ Spring Web
    3️⃣ Spring Data JPA
    4️⃣ PostgreSQL database
    5️⃣ Hibernate


The view on Postman:

Add new Book

`POST /books`

http://localhost:8080/books

![Add New Book](BookCRUDApplication/img/addBook.png "Add New Book")

Get All Books

`GET /books`

http://localhost:8080/books

![Get All Books](BookCRUDApplication/img/getAllBooks.png "Get All Books")

Get Book By Id

`GET /books/{id}`

http://localhost:8080/books/{id}

![Get Book By Id](BookCRUDApplication/img/getBookById.png "Get Book By Id")

Get Book By Title

`GET /books?title=title`

http://localhost:8080/books?title=title

![Get Book By Title](BookCRUDApplication/img/getBookByTitle.png "Get Book By Title")

Edit Book

`PUT /books/{id}`

http://localhost:8080/books/{id}

![Edit Book](BookCRUDApplication/img/updateBook.png "Edit Book")

Delete Book By Id

`DELETE /books/{id}`

http://localhost:8080/books/{id}

![Delete Book By Id](BookCRUDApplication/img/deleteBookById.png "Delete Book By Id")

Delete All Books

`DELETE /books`

http://localhost:8080/books

![Delete All Books](BookCRUDApplication/img/deleteAllBook.png "Delete All Books")
