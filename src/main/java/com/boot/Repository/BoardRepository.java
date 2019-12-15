package com.boot.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boot.dto.Board;

public interface BoardRepository extends MongoRepository<Board, Integer>{

}