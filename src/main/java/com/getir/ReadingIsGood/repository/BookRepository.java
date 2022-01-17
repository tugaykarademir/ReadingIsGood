package com.getir.ReadingIsGood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getir.ReadingIsGood.entity.BookEntity;
@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
	
	public BookEntity findByBookName(String bookName);

	public boolean existsByIdAndIsSalable(Long bookId, boolean isSalable);

	public List<BookEntity> findAllByIsSalable(boolean isSalable);

	public BookEntity getByIdAndIsSalable(Long bookId, boolean isSalable);
}
