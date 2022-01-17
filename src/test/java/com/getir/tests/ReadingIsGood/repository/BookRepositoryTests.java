package com.getir.tests.ReadingIsGood.repository;



import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.getir.ReadingIsGood.ReadingIsGoodApplication;
import com.getir.ReadingIsGood.entity.BookEntity;
import com.getir.ReadingIsGood.repository.BookRepository;


@SpringBootTest(classes = ReadingIsGoodApplication.class)
@RunWith(SpringRunner.class)
public class BookRepositoryTests {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Test
	@Transactional
	public void saveBookTest() {
		
		BookEntity entity =new BookEntity();
		entity.setId(1L);
		entity.setBookName("Test");
		entity.setBookIsbnNumber("Test");
		entity.setBookAuthor("test");
		entity.setPrice(100L);
		entity.setStock(10);
		entity.setSalable(true);
		entity.setCreationDate(LocalDateTime.now());
		
		bookRepository.save(entity);
		BookEntity result = bookRepository.getById(entity.getId());
		
		Assert.assertTrue(result.getId()==entity.getId());
		

	}
	
	@Test
	@Transactional
	public void findBookTest() {
		
		BookEntity entity =new BookEntity();
		entity.setId(1L);
		entity.setBookName("Test");
		entity.setBookIsbnNumber("Test");
		entity.setBookAuthor("test");
		entity.setPrice(100L);
		entity.setStock(10);
		entity.setCreationDate(LocalDateTime.now());
		entity.setSalable(true);
		
		bookRepository.save(entity);
		
		BookEntity result = bookRepository.getById(1L);
		
		Assert.assertTrue(result.getId()==entity.getId());
		

	}
	@Test
	@Transactional
	public void findByBookName() {
		
		BookEntity entity =new BookEntity();
		entity.setId(1L);
		entity.setBookName("Test");
		entity.setBookIsbnNumber("Test");
		entity.setBookAuthor("test");
		entity.setPrice(100L);
		entity.setStock(10);
		entity.setSalable(true);
		
		bookRepository.save(entity);
		
		BookEntity result = bookRepository.findByBookName("Test");
		
		Assert.assertTrue(result.getBookName()==entity.getBookName());
		

	}
	@Test
	@Transactional
	public void checkBookExistsByIdAndIsSalable() {
		
		BookEntity entity =new BookEntity();
		entity.setId(1L);
		entity.setBookName("Test");
		entity.setBookIsbnNumber("Test");
		entity.setBookAuthor("test");
		entity.setPrice(100L);
		entity.setStock(10);
		entity.setSalable(true);
		entity.setCreationDate(LocalDateTime.now());
		
		bookRepository.save(entity);
		BookEntity result1 = bookRepository.getById(1L);
		boolean result = bookRepository.existsByIdAndIsSalable(result1.getId(),true);
		
		Assert.assertSame(result, true);
		

	}
}
