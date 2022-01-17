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
![swagger_controller](https://user-images.githubusercontent.com/10910391/149804360-66dceefd-0462-4512-bc71-b6c8f12cbd0e.PNG)

<h3>Book Controller</h3>
  
* persist new book
* update book’s stock
![swagger_book](https://user-images.githubusercontent.com/10910391/149804338-52b6f4a7-420a-45be-8bfc-0ecd42e12458.PNG)

<h3>Order Controller</h3>

* persist new order
* update stock records.
* query order by Id
* orders by date interval ( startDate - endDate )

<h3>Statistics Controller</h3>

* Will serve customer’s monthly Total Order count , Total amount of all purchased and Total count of purchased books orders statistics 


