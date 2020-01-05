package com.boot.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boot.Repository.BoardRepository;
import com.boot.Repository.CommentRepository;
import com.boot.dto.Board;

@Controller
public class BoardController {
	
	private final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private CommentRepository commentRepository;

	@RequestMapping(value = "/addBoard.do", method = RequestMethod.POST)
	public String fileup(Board board, HttpSession session)
			throws IOException {
		log.info("Board : '" + board.toString() + "'");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String time = format.format(date);
		board.setDate(time);
		System.out.println(session.getServletContext().getRealPath("/"));
		if (boardRepository.count() == 0) {
			board.setId(1);
		} else {
			board.setId((int) boardRepository.count() + 1);
		}

//		File convertfile = new File("/Users/jeong-yeong-gil/Documents/stswork/Blog/src/main/resources/static/image/"
//				+ file.getOriginalFilename());

//		File convertfile = new File(session.getServletContext().getRealPath("/image/")
//		+ file.getOriginalFilename());

//		convertfile.createNewFile();
//
//		try (FileOutputStream fout = new FileOutputStream(convertfile)) {
//			fout.write(file.getBytes());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		board.setImage("/image/" + file.getOriginalFilename());
		boardRepository.save(board);
		return "redirect:/findAllBoard";
	}

	@RequestMapping(value = "/findAllBoard", method = RequestMethod.GET)
	public String findAllBoard(Model model) {
		model.addAttribute("board", boardRepository.findAll());
		return "blog/main";
	}

	@RequestMapping(value = "/single/{id}", method = RequestMethod.GET)
	public String single(Model model, @PathVariable int id) {
		model.addAttribute("board", boardRepository.findById(id).get());
		model.addAttribute("comment", commentRepository.findByBoardid(id));
		return "blog/blog-post";
	}

	@RequestMapping(value = "/BoardWriting", method = RequestMethod.GET)
	public String boardadd() {
		return "blog/blog-write";
	}
}