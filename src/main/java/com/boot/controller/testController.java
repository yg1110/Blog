package com.boot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.boot.Repository.BoardRepository;
import com.boot.dto.Board;


@RestController
public class testController {
	@Autowired
	private BoardRepository boardRepository;

	@GetMapping("/deleteboard/{id}")
	public List<Board> test(@PathVariable int id, HttpSession httpSession) {
		boardRepository.deleteById(id);
		return boardRepository.findAll();
	}

	
//	@GetMapping("/test")
//	public String test() {
//		return "test";
//	}
}
