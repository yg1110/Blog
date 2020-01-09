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
import com.boot.dto.Board;
import com.boot.dto.User;
import com.boot.service.IUserService;

@Controller
public class BoardController {
	
	private final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	IUserService userService;

	@RequestMapping(value = "/addBoard.do", method = RequestMethod.POST)
	public String fileup(Board board, HttpSession session)
			throws IOException {
		log.info("Board : '" + board.toString() + "'");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String time = format.format(date);
		board.setDate(time);
//		System.out.println(session.getServletContext().getRealPath("/"));
		
		int start = board.getContent().indexOf("src");
		int end = board.getContent().indexOf(" /></p>");

		if(start != -1) {
			String word = board.getContent().substring(start+5, end-1);
			board.setImage(word);
		}
		else {
			board.setImage("image/noimg.gif");
		}
		
		int index1 = 0;
		int index2 = 0;
		while(true) {
			start = board.getContent().indexOf("<p>", index1);
			end = board.getContent().indexOf("</p>", index2);
			
			if(start != -1) {
				String word = board.getContent().substring(start+3, end);
				if(word.contains("src")) {
					index1 = start + 1;
					index2 = end + 1;
				}
				else {					
					if(word.length()>20) {				
						board.setDescription(word.substring(0, 19));
					}
					else {
						board.setDescription(word);
					}
					break;
				}
			}
			else {
				board.setDescription("내용없음");
				break;
			}
		}
		
		if (boardRepository.count() == 0) {
			board.setId(1);
		} else {
			int size = (int) (boardRepository.count()+1);
			while(boardRepository.existsById(size)) {
				size++;
			}
			board.setId(size);
		}
		
		boardRepository.save(board);
		return "redirect:/";
	}

	@RequestMapping(value = "/findAllBoard", method = RequestMethod.GET)
	public String findAllBoard(Model model, HttpSession httpSession) {
		model.addAttribute("board", boardRepository.findAll());
		User user = new User();
		user.setUsername(httpSession.getAttribute("login").toString());
		model.addAttribute("user", userService.findUser(user));
		return "blog/main";
	}

	@RequestMapping(value = "/single/{id}", method = RequestMethod.GET)
	public String single(Model model, @PathVariable int id, HttpSession httpSession) {
		model.addAttribute("board", boardRepository.findById(id).get());
		User user = new User();
		user.setUsername(httpSession.getAttribute("login").toString());
		model.addAttribute("user", userService.findUser(user));
		return "blog/blog-post";
	}

	@RequestMapping(value = "/BoardWriting", method = RequestMethod.GET)
	public String boardadd(Model model, HttpSession httpSession) {
		User user = new User();
		user.setUsername(httpSession.getAttribute("login").toString());
		model.addAttribute("user", userService.findUser(user));
		return "blog/blog-write";
	}	
}