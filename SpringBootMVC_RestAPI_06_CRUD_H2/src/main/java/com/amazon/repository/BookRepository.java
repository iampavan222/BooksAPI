package com.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazon.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>
{
	

}
