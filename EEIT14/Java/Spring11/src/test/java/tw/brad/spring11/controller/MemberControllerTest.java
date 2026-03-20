package tw.brad.spring11.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import tools.jackson.databind.ObjectMapper;
import tw.brad.spring11.dto.Login;
import tw.brad.spring11.entity.Member;
import tw.brad.spring11.service.MemberService;


import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MemberController.class)
public class MemberControllerTest {
	@Autowired
	private MockMvc mockMvc;	// HTTP
	
	@MockitoBean
	private MemberService memberService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	@DisplayName("測試 register -> 200 + Member")
	void register_Success() throws Exception{
		// 假設
		Login login = new Login("brad@brad.tw", "12345678", "Brad");
		
		Member mockMember = new Member();
		mockMember.setEmail("brad@brad.tw");
		
		when(memberService.register(anyString(), anyString(), anyString()))
			.thenReturn(mockMember);
		
		// 測試
		mockMvc.perform(post("/api/member/register")
							.contentType(MediaType.APPLICATION_JSON)
							.content(objectMapper.writeValueAsString(login))
						)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.email").value("brad@brad.tw"));
	}
	
	
	@Test
	@DisplayName("測試 register -> 200 + error ")
	void register_Failure() throws Exception{
		// 假設
		Login login = new Login("brad@brad.tw", "12345678", "Brad");

		when(memberService.register(anyString(), anyString(), anyString()))
			.thenThrow(new RuntimeException("xxx"));
		
		// 測試
		mockMvc.perform(post("/api/member/register")
							.contentType(MediaType.APPLICATION_JSON)
							.content(objectMapper.writeValueAsString(login))
						)
			.andExpect(status().isOk())
			.andExpect(content().string("error:xxx"));		
		
		
	}	
	
	
}