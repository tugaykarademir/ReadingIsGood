package com.getir.ReadingIsGood.service;

import java.util.List;
import java.util.Map;

import com.getir.ReadingIsGood.dto.BookRequestDto;
import com.getir.ReadingIsGood.dto.GeneralResponseDto;
import com.getir.ReadingIsGood.dto.StockResponseDto;
import com.getir.ReadingIsGood.entity.BookEntity;

public interface BookService {

	public GeneralResponseDto addBook(BookRequestDto bookRequestDto);

	public List<BookEntity> getAllBooksList();

	public BookEntity getBooksByName(String bookName);

	public void deleteBook(Long bookId);

	public boolean isBookExist(Long bookId);
	
	public BookEntity getBooksById(Long bookId);
	
	public BookEntity getSalableBookById(Long bookId);
	
	public void increaseBookStock(Long bookId,int increaseCount);
	
	public void decreaseBookStock(Long bookId);
	
	public Map<Long,StockResponseDto> getAllBooksStocks() ;
	
	public GeneralResponseDto updateBookStock(Long bookId, int stock);

}
