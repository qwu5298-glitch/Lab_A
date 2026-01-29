package tw.brad.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tw.brad.apis.BCrypt;
import tw.brad.apis.Member;

public class MemberDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/brad";
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String SQL_LOGIN = """
			SELECT id, email, passwd, name
			FROM member
			WHERE email = ?
			""";	
	private static final String SQL_QUERY_EMAIL = """
			SELECT id, email, passwd, name
			FROM member
			WHERE email = ?
			""";	
	private static final String SQL_ADD = """
			INSERT INTO member
				(email, passwd, name)
			VALUES
				(?,?,?)
			""";	
	
	public Member findByEmail(String email) throws Exception {
		ResultSet rs = null;
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY_EMAIL);
				){
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Member member = new Member();
				member.setId(rs.getLong("id"));
				member.setEmail(rs.getString("email"));
				member.setPasswd(rs.getString("passwd"));	// 2 way: bcrypt / plain
				member.setName(rs.getString("name"));
				return member;
			}else {
				return null;
			}
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			rs.close();
		}
		return null;
	}
	public boolean addMember(Member member) {
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
				PreparedStatement pstmt = conn.prepareStatement(SQL_ADD)){
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, BCrypt.hashpw(member.getPasswd(),BCrypt.gensalt()));
			pstmt.setString(3, member.getName());
			return pstmt.executeUpdate() > 0;
		}catch(Exception e) {
			return false;
		}
	}
	
	public Member login(String email, String passwd) throws Exception {
		ResultSet rs = null;
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWD);
			PreparedStatement pstmt = conn.prepareStatement(SQL_LOGIN);
				){
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next() && BCrypt.checkpw(passwd, rs.getString("passwd"))) {
				Member member = new Member();
				member.setId(rs.getLong("id"));
				member.setEmail(rs.getString("email"));
				member.setPasswd(rs.getString("passwd"));	// 2 way: bcrypt / plain
				member.setName(rs.getString("name"));
				return member;
			}else {
				return null;
			}
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			rs.close();
		}
		return null;
	}
	
}
