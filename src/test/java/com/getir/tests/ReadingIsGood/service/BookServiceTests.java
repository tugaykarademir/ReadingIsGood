package com.getir.tests.ReadingIsGood.service;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.getir.ReadingIsGood.ReadingIsGoodApplication;
import com.getir.ReadingIsGood.dto.BookRequestDto;
import com.getir.ReadingIsGood.dto.GeneralResponseDto;
import com.getir.ReadingIsGood.dto.StockResponseDto;
import com.getir.ReadingIsGood.entity.BookEntity;
import com.getir.ReadingIsGood.repository.BookRepository;
import com.getir.ReadingIsGood.service.BookService;

@SpringBootTest(classes = ReadingIsGoodApplication.class)
@RunWith(SpringRunner.class)
public class BookServiceTests {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookService bookService;

	@Test
	@Transactional
	public void addBookServiceTest() {

		BookRequestDto bookRequestDto = new BookRequestDto();
		bookRequestDto.setId(1L);
		bookRequestDto.setBookName("Test");
		bookRequestDto.setBookIsbnNumber("Test");
		bookRequestDto.setBookAuthor("test");
		bookRequestDto.setPrice(100L);
		bookRequestDto.setStock(10);

		bookService.addBook(bookRequestDto);
		BookEntity result = bookRepository.getById(bookRequestDto.getId());

		Assert.assertTrue(result.getId() == bookRequestDto.getId());
	}

	@Test
	@Transactional
	public void deleteBookServiceTest() {

		BookRequestDto bookRequestDto = new BookRequestDto();
		bookRequestDto.setId(1L);
		bookRequestDto.setBookName("Test");
		bookRequestDto.setBookIsbnNumber("Test");
		bookRequestDto.setBookAuthor("test");
		bookRequestDto.setPrice(100L);
		bookRequestDto.setStock(10);

		bookService.addBook(bookRequestDto);
		bookService.deleteBook(bookRequestDto.getId());

		BookEntity result = bookRepository.getById(bookRequestDto.getId());

		Assert.assertTrue(null == result);
	}

	@Test
	@Transactional
	public void getBookByNameServiceTest() {

		BookRequestDto bookRequestDto = new BookRequestDto();
		bookRequestDto.setId(1L);
		bookRequestDto.setBookName("Test");
		bookRequestDto.setBookIsbnNumber("Test");
		bookRequestDto.setBookAuthor("test");
		bookRequestDto.setPrice(100L);
		bookRequestDto.setStock(10);

		bookService.addBook(bookRequestDto);

		BookEntity result = bookService.getBooksByName(bookRequestDto.getBookName());

		Assert.assertTrue(result.getBookName() == bookRequestDto.getBookName());
	}

	@Test
	@Transactional
	public void isBookExistsServiceTest() {

		BookRequestDto bookRequestDto = new BookRequestDto();
		bookRequestDto.setId(1L);
		bookRequestDto.setBookName("Test");
		bookRequestDto.setBookIsbnNumber("Test");
		bookRequestDto.setBookAuthor("test");
		bookRequestDto.setPrice(100L);
		bookRequestDto.setStock(10);

		bookService.addBook(bookRequestDto);

		boolean result = bookService.isBookExist(bookRequestDto.getId());

		Assert.assertTrue(result == true);
	}

	@Transactional
	@Test
	public void getSalableBookByIdServiceTest() {

		BookRequestDto bookRequestDto = new BookRequestDto();
		bookRequestDto.setId(1L);
		bookRequestDto.setBookName("Test");
		bookRequestDto.setBookIsbnNumber("Test");
		bookRequestDto.setBookAuthor("test");
		bookRequestDto.setPrice(100L);
		bookRequestDto.setStock(10);

		bookService.addBook(bookRequestDto);

		BookEntity result = bookService.getSalableBookById(bookRequestDto.getId());

		Assert.assertTrue(result.getId() == bookRequestDto.getId());
	}

	@Transactional
	@Test
	public void updateBookStockServiceTest() {

		BookRequestDto bookRequestDto = new BookRequestDto();
		bookRequestDto.setId(1L);
		bookRequestDto.setBookName("Test");
		bookRequestDto.setBookIsbnNumber("Test");
		bookRequestDto.setBookAuthor("test");
		bookRequestDto.setPrice(100L);
		bookRequestDto.setStock(10);

		bookService.addBook(bookRequestDto);

		GeneralResponseDto res = bookService.updateBookStock(bookRequestDto.getId(), 5);

		BookEntity result = bookService.getBooksById(bookRequestDto.getId());

		Assert.assertTrue(result.getStock() == 5);
	}

	@Transactional
	@Test
	public void increaseBookStockServiceTest() {

		BookRequestDto bookRequestDto = new BookRequestDto();
		bookRequestDto.setId(1L);
		bookRequestDto.setBookName("Test");
		bookRequestDto.setBookIsbnNumber("Test");
		bookRequestDto.setBookAuthor("test");
		bookRequestDto.setPrice(100L);
		bookRequestDto.setStock(10);

		bookService.addBook(bookRequestDto);

		bookService.increaseBookStock(bookRequestDto.getId(), 1);

		BookEntity result = bookService.getBooksById(bookRequestDto.getId());

		Assert.assertTrue(result.getStock() == 11);
	}

	@Transactional
	@Test
	public void decreaseBookStockServiceTest() {

		BookRequestDto bookRequestDto = new BookRequestDto();
		bookRequestDto.setId(1L);
		bookRequestDto.setBookName("Test");
		bookRequestDto.setBookIsbnNumber("Test");
		bookRequestDto.setBookAuthor("test");
		bookRequestDto.setPrice(100L);
		bookRequestDto.setStock(10);

		bookService.addBook(bookRequestDto);

		bookService.decreaseBookStock(bookRequestDto.getId());

		BookEntity result = bookService.getBooksById(bookRequestDto.getId());

		Assert.assertTrue(result.getStock() == 9);
	}

	@Transactional
	@Test
	public void getAllBooksStocksServiceTest() {

		BookRequestDto bookRequestDto = new BookRequestDto();
		bookRequestDto.setId(1L);
		bookRequestDto.setBookName("Test");
		bookRequestDto.setBookIsbnNumber("Test");
		bookRequestDto.setBookAuthor("test");
		bookRequestDto.setPrice(100L);
		bookRequestDto.setStock(10);
		bookService.addBook(bookRequestDto);

		bookRequestDto.setId(2L);
		bookRequestDto.setBookName("Test2");
		bookRequestDto.setBookIsbnNumber("Test2");
		bookRequestDto.setBookAuthor("test2");
		bookRequestDto.setPrice(100L);
		bookRequestDto.setStock(10);

		bookService.addBook(bookRequestDto);

		Map<Long, StockResponseDto> result = bookService.getAllBooksStocks();

		Assert.assertTrue(result.get(1L).getBookId() == 1L && result.get(2L).getBookId() == 2L);
	}

}
