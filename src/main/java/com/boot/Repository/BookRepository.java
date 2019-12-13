package com.boot.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boot.dto.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}