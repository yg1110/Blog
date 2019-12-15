package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boot.Repository.BoardRepository;
import com.boot.dto.Board;

@Controller
public class BoardController {

	@Autowired
	private BoardRepository repository;

	@PostMapping("/addBoard")
	public String saveBook(@RequestBody Board board) {
		repository.save(board);
		return "Added book with id : " + board.getTitle();
	}
	
	@RequestMapping(value="/findAllBoard", method=RequestMethod.GET)
	public String findAllBoard(Model model) {
		model.addAttribute("board", repository.findAll());
		return "blog/main";
	}
}