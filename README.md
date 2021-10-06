# Getting Started

Command to run rabbitmq broker as docker container with management plugin enabled

```
docker run -d --name book-rabbitmq -p 5672:5672 -p 15672:15672  rabbitmq:3-management
```

Access rabbitmq management console at http://localhost:15672/

Command to Get list of books

```
GET http://localhost:8080/books
```

Command to like a book

```
POST http://localhost:8080/books/1
POST http://localhost:8080/books/2
```

Command to see like status

```
GET http://localhost:8080/admin
```