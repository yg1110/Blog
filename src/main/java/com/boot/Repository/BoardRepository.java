package com.boot.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.boot.dto.Board;

public interface BoardRepository extends MongoRepository<Board, Integer>{
	//https://stackoverflow.com/questions/16708416/regular-expression-spring-data-mongodb-repositories/19068401#19068401
	//''를 사용할경우 문자열로 취급받기 때문에 사용하지 못하고, i는 대소문자 구분없이 찾아주는겁니다.
	//?0은 아마 찾아주는 찾아주는기능?(뇌피셜)
	@Query("{ 'title' : { '$regex' : ?0 , $options: 'i' }}")
	List<Board> findByTitle(String title);
	
	@Query("{ 'category' : { '$regex' : ?0 , $options: 'i'}}")
	List<Board> findByCategory(String category);
}