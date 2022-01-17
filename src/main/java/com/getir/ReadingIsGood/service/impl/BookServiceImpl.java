package com.getir.ReadingIsGood.service.impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getir.ReadingIsGood.dto.BookRequestDto;
import com.getir.ReadingIsGood.dto.GeneralResponseDto;
import com.getir.ReadingIsGood.dto.StockResponseDto;
import com.getir.ReadingIsGood.entity.BookEntity;
import com.getir.ReadingIsGood.repository.BookRepository;
import com.getir.ReadingIsGood.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Transactional
	public GeneralResponseDto addBook(BookRequestDto bookRequestDto) {

		LocalDateTime currentDate = LocalDateTime.now();
		BookEntity bookEntity = bookRequestDto.getBookEntity();
		bookEntity.setCreationDate(currentDate);
		bookEntity.setSalable(true);

		bookRepository.save(bookEntity);
		
		GeneralResponseDto response = new GeneralResponseDto("Book Successfuly added.","0");
		return response;

	}

	@Override
	public List<BookEntity> getAllBooksList() {
		return bookRepository.findAllByIsSalable(true);
	}

	@Override
	public BookEntity getBooksByName(String bookName) {
		return bookRepository.findByBookName(bookName);
	}

	@Override
	@Transactional
	public void deleteBook(Long bookId) {
		bookRepository.deleteById(bookId);
	}

	@Override
	public boolean isBookExist(Long bookId) {
		return bookRepository.existsByIdAndIsSalable(bookId,true);
	}

	@Override
	public BookEntity getBooksById(Long bookId) {
		return bookRepository.getById(bookId);
	}

	@Override
	@Transactional
	public void decreaseBookStock(Long bookId) {
		BookEntity foundBook = bookRepository.getById(bookId);
		int stock =foundBook.getStock();
		if(stock>1) {
		foundBook.setStock(stock-1);
		
		}else if(stock==1) {
			foundBook.setStock(stock-1);
			foundBook.setSalable(false);
		}
		
		bookRepository.save(foundBook);	
		
	}

	@Override
	@Transactional
	public void increaseBookStock(Long bookId,int increaseCount) {
		BookEntity foundBook = bookRepository.getById(bookId);
		foundBook.setStock(foundBook.getStock()+increaseCount);
		bookRepository.save(foundBook);	
	
	}

	@Override
	public BookEntity getSalableBookById(Long bookId) {
		return bookRepository.getByIdAndIsSalable(bookId,true);
	}
	
	@Override
	public Map<Long,StockResponseDto> getAllBooksStocks() {
		List<BookEntity> bookList =bookRepository.findAllByIsSalable(true);
		 Map<Long,StockResponseDto> stockMap= new HashMap<Long,StockResponseDto>();
		 
		 for(BookEntity book:bookList) {
			 StockResponseDto stockResponseDto =new StockResponseDto();
			 stockResponseDto.setBookId(book.getId());
			 stockResponseDto.setBookName(book.getBookName());
			 stockResponseDto.setStock(book.getStock());
			 
			 stockMap.put(book.getId(), stockResponseDto);
			 
			 
		 }
		
		return stockMap;
	}

	@Override
	public GeneralResponseDto updateBookStock(Long bookId, int stock) {
		BookEntity foundBook = bookRepository.getById(bookId);
		GeneralResponseDto response = new GeneralResponseDto("Book Successfuly added.","0");
		if(null!=foundBook) {
		foundBook.setStock(stock);
		foundBook.setSalable(stock>0?true:false);
		bookRepository.save(foundBook);
		return response;
		}
		response.setResponseMessage("The Book Does not exists");
		return response;
	}
}
