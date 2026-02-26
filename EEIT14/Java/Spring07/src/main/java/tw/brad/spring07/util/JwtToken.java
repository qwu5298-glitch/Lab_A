package tw.brad.spring07.util;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtToken {
	private static final long EXP_TIME = 10*60*1000;
	private static final String SECURT = "BradChao12345677654321abcdefgDogCat";
	private static final Key key = Keys.hmacShaKeyFor(SECURT.getBytes());
	
	
	public static String createToken(String subject) {
		String token = Jwts.builder()
				.setSubject(subject)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXP_TIME))
				.signWith(key, SignatureAlgorithm.HS256)
				.compact();
		
		
		return token;
	}
	
	public static String parseToken(String token) {
		JwtParser parser = Jwts.parserBuilder().setSigningKey(key).build();
		String subject = parser.parseClaimsJws(token).getBody().getSubject();
		return subject;
	}
}