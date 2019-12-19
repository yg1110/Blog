package com.boot.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.boot.Repository.BoardRepository;
import com.boot.dto.Board;

@RestController
public class filecontroller {
	@Autowired
	private BoardRepository boardRepository;

//	@RequestMapping(value="/addBoard", method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//	public String fileup(Board board, @RequestParam("file") MultipartFile file) throws IOException {
//		System.out.println("============= add ==============");
//		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd");
//		Date date = new Date();
//		String time = format.format(date);
//		board.setDate(time);
//		
//        if(boardRepository.count()==0) {
//			board.setId(1);
//		}
//		else {
//			board.setId((int)boardRepository.count()+1);
//		}
//        
//        File convertfile = new File("/Users/jeong-yeong-gil/Documents/blog/src/main/webapp/WEB-INF/file/" + file.getOriginalFilename());
//		convertfile.createNewFile();
//		
//		try(FileOutputStream fout = new FileOutputStream(convertfile)){
//			fout.write(file.getBytes());
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//        board.setImage(convertfile.toString());
//        System.out.println(board);
//        boardRepository.save(board);
//		return "upload success";
//	}

	
	@RequestMapping(value="/addBoard", method=RequestMethod.POST)
	public String fileup(Board board) throws IOException {
		System.out.println("============= add ==============");
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd");
		Date date = new Date();
		String time = format.format(date);
		board.setDate(time);
		
        if(boardRepository.count()==0) {
			board.setId(1);
		}
		else {
			board.setId((int)boardRepository.count()+1);
		}
        
        System.out.println(board);
        boardRepository.save(board);
		return "upload success";
	}
}