package tw.brad.spring11.service;

// assertEquals, assertThrows, assertNotNull, assertNotEquals
// import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import tw.brad.spring11.entity.Member;
import tw.brad.spring11.repo.MemberRepo;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {
	@Mock MemberRepo repo;	// 假的
	
	@InjectMocks MemberService service;
	
	@Test	// 方法_條件_動作, service.register() => IllegalArgumentException
	void register_emailExists_shouldThrow() {
		// 設定(假設): repo.existsByEmail("brad@brad.tw") => true
		when(repo.existsByEmail("brad@brad.tw")).thenReturn(true);
		
		// 執行
		assertThrows(IllegalArgumentException.class, 
			() -> service.register("brad@brad.tw", "12345678", "Brad"));
		
		// 驗證
		verify(repo, never()).save(any());
	}
	
	@Test
	void register_success() {
		when(repo.existsByEmail("brad@brad.tw")).thenReturn(false);
		
		Member saved = new Member();
		saved.setId(1L);

		when(repo.save(any(Member.class))).thenReturn(saved);
		//----------------------------------------------
		Member member = service.register("brad@brad.tw", "12345678", "Brad");
		//----------------------
		assertEquals(1L, member.getId());
		
		
	}
	
	
	
}