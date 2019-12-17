package com.boot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boot.Repository.BoardRepository;
import com.boot.Repository.CommentRepository;
import com.boot.dto.Board;

@Controller
public class BoardController {

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private CommentRepository commentRepository;

	@PostMapping("/addBoard")
	public String saveBook(@RequestBody Board board) {
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd");
		Date date = new Date();
		String time = format.format(date);
		board.setDate(time);
		if(boardRepository.count()==0) {
			board.setId(1);
			boardRepository.save(board);
		}
		else {
			board.setId((int)boardRepository.count()+1);
			boardRepository.save(board);
		}

		return "Added book with id : " + board.getId();
	}
	
	@RequestMapping(value="/findAllBoard", method=RequestMethod.GET)
	public String findAllBoard(Model model) {
		model.addAttribute("board", boardRepository.findAll());
		return "blog/main";
	}
	
	@RequestMapping(value="/single/{id}", method=RequestMethod.GET)
	public String single(Model model, @PathVariable int id) {
		model.addAttribute("board", boardRepository.findById(id).get());
		model.addAttribute("comment", commentRepository.findByBoardid(id));
		return "blog/single";
	}
	
	@RequestMapping(value="/BoardWriting", method=RequestMethod.GET)
	public String boardadd() {
		return "blog/BoardWriting";
	}
}