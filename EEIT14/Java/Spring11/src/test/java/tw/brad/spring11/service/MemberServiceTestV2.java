package tw.brad.spring11.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.ArgumentCaptor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tw.brad.spring11.entity.Member;
import tw.brad.spring11.repo.MemberRepo;
import tw.brad.spring11.util.BCrypt;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTestV2 {
	@Mock MemberRepo repo;	// 假的
	@InjectMocks MemberService service;
	
	private Member saved;
	
	@BeforeEach
	void setUp() {
		saved = new Member();
		saved.setId(12L);
	}
	
	//
	@Test
	void register_emailExists_shouldThrow_andNeverSave() {
		when(repo.existsByEmail("brad@brad.tw")).thenReturn(true);
		
		assertThrows(IllegalArgumentException.class, 
				() -> service.register("brad@brad.tw", "12345678", "Brad"));
		
		// 帳號已存在, 不該存檔
		verify(repo).existsByEmail("brad@brad.tw");
		verify(repo, never()).save(any(Member.class));
	}
	
	@Test
	void register_success_shouldHashPasswd_andReturnId() {
		when(repo.existsByEmail("brad@brad.tw")).thenReturn(false);
		when(repo.save(any(Member.class))).thenReturn(saved);
		//------------------------
		ArgumentCaptor<Member> captor = ArgumentCaptor.forClass(Member.class);
		//------------------------
		Member m = service.register("brad@brad.tw", "12345678", "Brad");
		assertEquals(12L, m.getId());
		//--------------------------
		
		verify(repo).existsByEmail("brad@brad.tw");
		verify(repo).save(captor.capture());
		
		Member arg = captor.getValue();
		
		assertEquals("brad@brad.tw", arg.getEmail());
		
		assertNotNull(arg.getPasswd());
		assertNotEquals("12345678", arg.getPasswd());
		assertTrue(BCrypt.checkpw("12345678", arg.getPasswd()));
		
		
		
		
	}
	
	
	
}