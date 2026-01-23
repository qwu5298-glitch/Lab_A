package tw.brad.tutor;

import java.util.Scanner;

import tw.brad.apis.Member;
import tw.brad.apis.MemberDAO;
import tw.brad.apis.MemberDAOImpl;

public class Brad19 {

	public static void main(String[] args) {
		System.out.println("Member Login");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Email: ");
		String email = scanner.nextLine();
		System.out.print("Password: ");
		String passwd = scanner.nextLine();
		
		MemberDAO dao = new MemberDAOImpl();
		try {
			Member member = dao.login(email, passwd);
			if (member != null) {
				System.out.printf("Welcome, %s", member.getName());
			}else {
				System.out.println("Login Failure");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}