<h1>ReadingIsGood</h1>
ReadingIsGood is an online books retail platform which operates only on the Internet. Main
target of ReadingIsGood is to deliver books from its one centralized warehouse to their
customers. Platform is developed with below tech.

* Spring Boot
* H2 Database
* Spring Web
* Junit
* Spring JPA
* Spring Security
* JWT Web token
* Swagger Ui
* log4j

<h2>ReadingIsGood Endpoints</h2>

ReadingIsGood platform provides below endpoint as Restful service.

<h3>Customer Controller</h3>

* persist new customers
* query all orders of the customer
* 
![swagger_customer](https://user-images.githubusercontent.com/10910391/149808333-abaa5593-85fa-4ee8-bb5c-e3276a077492.PNG)

<h3>Book Controller</h3>
  
* persist new book
* update book’s stock
* delete book
* list all book
* list all book stocks
* get book by name
* get salable book
![swagger_book](https://user-images.githubusercontent.com/10910391/149808362-ef669b25-bd2f-43c4-a2a6-64ff00c23d3d.PNG)

<h3>Order Controller</h3>

* persist new order
* query order by Id
* orders by date interval ( startDate - endDate )

![swagger_order](https://user-images.githubusercontent.com/10910391/149808393-c2b3e927-b213-44d5-886e-ce1c86665907.PNG)

<h3>Statistics Controller</h3>

* Will serve customer’s monthly Total Order count , Total amount of all purchased and Total count of purchased books orders statistics 

![swagger_statistics](https://user-images.githubusercontent.com/10910391/149808412-563ab165-5625-4633-8f01-b1e0fc57395c.PNG)

<h3>Documentation</h3> 

 Swagger Documantation can chekc on  http://localhost:8080/swagger-ui.html
 
 <h3>Api Run</h3>
 
 Application can run with below scripts
 
  docker build -f Dockerfile -t readingisgood-1.0.0 .  
  docker run -p 8080:8080 readingisgood-1.0.0  
 
 * For database process on consle url : http://localhost:8080/h2-console
 * For user Web services you should have token. For get token you can  find postman collection under /src/main/resources .default <Strong>username:user</Strong>, <Strong>password:secret</Strong>
 * For Aplication web services you can import postman collection whic is define under /src/main/resources
 
 
