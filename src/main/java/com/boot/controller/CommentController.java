package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boot.Repository.CommentRepository;
import com.boot.dto.Comment;

@Controller
public class CommentController {

	@Autowired
	private CommentRepository repository;

	
	@PostMapping("/addCommnet")
	public void saveComment(@RequestBody Comment comment) {
		if(repository.count()==0) {
			comment.setId(1);			
			repository.save(comment);
		}
		else {
			comment.setId((int)repository.count()+1);
			repository.save(comment);
		}
	}
	
	@RequestMapping(value="/findAllComment/", method=RequestMethod.GET)
	public String findAllBoard(Model model) {
		
		return "list";
	}

}
