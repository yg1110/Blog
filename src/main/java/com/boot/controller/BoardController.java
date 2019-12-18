package com.boot.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.boot.Repository.BoardRepository;
import com.boot.Repository.CommentRepository;
import com.boot.dto.Board;
import com.boot.dto.FileDTO;

@Controller
public class BoardController {

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private CommentRepository commentRepository;

	@RequestMapping(value="/addBoard", method=RequestMethod.POST)
	public String saveBook(Board board, MultipartFile files) throws IllegalStateException, IOException {
		FileDTO  file  = new FileDTO();
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd");
		Date date = new Date();
		String time = format.format(date);
		board.setDate(time);
		
		String fileName = files.getOriginalFilename(); 
        String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase(); 
        File destinationFile; 
        String destinationFileName; 
        String fileUrl = "/Users/jeong-yeong-gil/Documents/blog/src/main/webapp/WEB-INF/uploadfile/";
        
        do { 
            destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension; 
            destinationFile = new File(fileUrl+ destinationFileName); 
        } while (destinationFile.exists()); 
        
        destinationFile.getParentFile().mkdirs(); 
        files.transferTo(destinationFile); 

        if(boardRepository.count()==0) {
			file.setBno(1);
			board.setId(1);
		}
		else {
			file.setBno((int)boardRepository.count()+1);
			board.setId((int)boardRepository.count()+1);
		}
        board.setImage(fileUrl + fileName);
        boardRepository.save(board);

		return "redirect:/findAllBoard";
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