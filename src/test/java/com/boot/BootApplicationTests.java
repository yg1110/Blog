package com.boot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.boot.controller.JwtController;

@WebMvcTest(JwtController.class)
@SpringBootTest
class BootApplicationTests {

	@Autowired
	MockMvc mokMvc;
	
	@Test
	void contextLoads() throws Exception {
		mokMvc.perform(get("/hello"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("hello"));
	}
	
	@Test
	void contextLoads2() throws Exception {
		mokMvc.perform(get("/my"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("my"));
	}

}
