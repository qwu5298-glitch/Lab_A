package tw.brad.spring05.test;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserForm {
	@NotBlank(message = "Email 不可空白")
	@Email(message = "請輸入有效的 Email")
	private String email;
	
	@Size(min=6, message = "密碼長度 >= 6")
	private String passwd;
	
	@NotBlank(message = "Name 不可空白")
	private String name;
}