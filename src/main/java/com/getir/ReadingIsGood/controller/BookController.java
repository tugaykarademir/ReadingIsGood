package com.getir.ReadingIsGood.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.getir.ReadingIsGood.dto.BookRequestDto;
import com.getir.ReadingIsGood.dto.GeneralResponseDto;
import com.getir.ReadingIsGood.dto.StockResponseDto;
import com.getir.ReadingIsGood.entity.BookEntity;
import com.getir.ReadingIsGood.service.BookService;

@Controller
@RequestMapping(value = "/v1/bookApi")
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public ResponseEntity<String> addBook(@Valid @RequestBody BookRequestDto bookRequestDto) {
		try {
			GeneralResponseDto response = bookService.addBook(bookRequestDto);

			return new ResponseEntity<String>(response.getResponseMessage(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("<BookController> - <addBook> - Throw Error." + e);
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllBooks")
	public ResponseEntity<List<BookEntity>> getAllBooks() {
		List<BookEntity> response = bookService.getAllBooksList();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/getBookByName")
	public ResponseEntity<BookEntity> getBookByName(@RequestParam(name = "bookName") String bookName) {
		BookEntity response = bookService.getBooksByName(bookName);
		return new ResponseEntity<BookEntity>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/deleteBook")
	public ResponseEntity<String> deleteBook(@RequestParam(name = "bookId") Long bookId) {

		bookService.deleteBook(bookId);
		return new ResponseEntity<String>("The book is successfuly deleted",HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/getBookById")
	public ResponseEntity<BookEntity> getBookById(@RequestParam(name = "bookId") Long bookId) {
		BookEntity response = bookService.getBooksById(bookId);
		return new ResponseEntity<BookEntity>(response, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/getSalableBookById")
	public ResponseEntity<BookEntity> getSalableBookById(@RequestParam(name = "bookId") Long bookId) {
		BookEntity response = bookService.getSalableBookById(bookId);
		return new ResponseEntity<BookEntity>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/getBookStock")
	public ResponseEntity<Integer> getBookStock(@RequestParam(name = "bookId") Long bookId) {
		BookEntity response = bookService.getBooksById(bookId);
		return new ResponseEntity<Integer>(response.getStock(), HttpStatus.OK);
	}
	

	@RequestMapping(method = RequestMethod.POST, value = "/getAllBookStocks", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Map<Long,StockResponseDto>> getAllBookStocks() {
		Map<Long,StockResponseDto> response = bookService.getAllBooksStocks();
		return new ResponseEntity<Map<Long,StockResponseDto>>(response, HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.POST, value = "/updateBookStock", produces = "application/json", consumes = "application/json")
	public ResponseEntity<GeneralResponseDto> getAllBookStocks(@RequestParam(name = "bookId") Long bookId,@RequestParam(name = "stock") Integer stock) {
		GeneralResponseDto response = bookService.updateBookStock(bookId, stock);
		return new ResponseEntity<GeneralResponseDto>(response, HttpStatus.OK);
	}

}
