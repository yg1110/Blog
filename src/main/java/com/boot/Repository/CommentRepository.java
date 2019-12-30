package com.boot.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boot.dto.Comment;


public interface CommentRepository extends MongoRepository<Comment, Integer>{

	List<Comment> findByBoardid(int id);
}