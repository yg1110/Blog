package com.boot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.Repository.BoardRepository;
import com.boot.dto.Board;


@RestController
public class testController {
	@Autowired
	private BoardRepository boardRepository;

	@GetMapping("/deleteboard/{id}")
	public List<Board> deleteboard(@PathVariable int id, HttpSession httpSession) {
		boardRepository.deleteById(id);
		return boardRepository.findAll();
	}

	@RequestMapping(value = "/search/{keyword}", method = RequestMethod.GET)
	public List<Board> search(@PathVariable String keyword) {
		List<Board> boardlist = new ArrayList<>();
		for(Board board : boardRepository.findByTitle(keyword)) {
			if(!boardlist.contains(board)) {
				boardlist.add(board);
			}
		}

		for(Board board : boardRepository.findByCategory(keyword)) {
			if(!boardlist.contains(board)) {
				boardlist.add(board);
			}
		}
		
		
		return boardlist;
	}
}
