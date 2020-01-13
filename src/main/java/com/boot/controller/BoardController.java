package com.boot.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.boot.Repository.BoardRepository;
import com.boot.dto.Board;
import com.boot.dto.FileValidator;
import com.boot.dto.UploadFile;
import com.boot.dto.User;
import com.boot.service.IUserService;

@Controller
public class BoardController {
	
	private final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	IUserService userService;
	
	@Autowired
    private FileValidator fileValidator;

	@RequestMapping(value = "/addBoard.do", method = RequestMethod.POST)
	public String fileup(Model model, Board board, HttpSession session, @ModelAttribute("uploadFile") UploadFile uploadFile, BindingResult result)
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
		
		
		InputStream inputStream = null;
        OutputStream outputStream = null;
        
        // 에러 검사 : 업로드 파일 유무
        MultipartFile file = uploadFile.getFile();
        fileValidator.validate(uploadFile, result);
        
        String fileName = file.getOriginalFilename();
        if(result.hasErrors()) {
            //업로드할 파일을 선택하지 않은 경우 form에 에러 메세지를 출력함
            return "blog/blog-write";
        }
        
        try {
            inputStream = file.getInputStream();
            
            File newFile = new File("/Users/jeong-yeong-gil/Documents/stswork/Blog/src/main/resources/static/image/" + fileName);
            if(newFile.exists()) {
                newFile.createNewFile();
            }
            outputStream = new FileOutputStream(newFile);
            int read = 0;
            byte[] bytes = new byte[1024];
            
            while((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes,0,read);
            }
            
        } catch (Exception e) {
            System.out.println("err : " + e);
        }finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (Exception e2) {
            }
        }
		
        board.setFilename(fileName);
		boardRepository.save(board);
		return "redirect:/";
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
	
	@RequestMapping(value = "/updateboard/{id}", method = RequestMethod.GET)
	public String updateboard(Model model, @PathVariable int id, HttpSession httpSession) {
		User user = new User();
		user.setUsername(httpSession.getAttribute("login").toString());
		model.addAttribute("user", userService.findUser(user));
		
		model.addAttribute("board", boardRepository.findById(id).get());
		log.info(boardRepository.findById(id)+"");
		return "blog/blog-update";
	}
	
	@RequestMapping(value = "/updateBoard.do", method = RequestMethod.POST)
	public String updateBoard(Model model, Board board) {
		log.info("board : " + board +"");
		Board updateBoard = boardRepository.findById(board.getId()).get();
		updateBoard.setTitle(board.getTitle());
		updateBoard.setCategory(board.getCategory());
		updateBoard.setContent(board.getContent());
		
		int start = board.getContent().indexOf("src");
		int end = board.getContent().indexOf(" /></p>");

		if(start != -1) {
			String word = updateBoard.getContent().substring(start+5, end-1);
			updateBoard.setImage(word);
		}
		else {
			updateBoard.setImage("image/noimg.gif");
		}
		
		int index1 = 0;
		int index2 = 0;
		while(true) {
			start = updateBoard.getContent().indexOf("<p>", index1);
			end = updateBoard.getContent().indexOf("</p>", index2);
			
			if(start != -1) {
				String word = updateBoard.getContent().substring(start+3, end);
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

		boardRepository.save(updateBoard);
		return "redirect:/";
	}
}