package com.blacksmith.banchan.util;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenGenerator {

    public static String generateJwtToken() {
        // 토큰에 포함할 클레임 생성
    	String userId = "kk";
        Claims claims = Jwts.claims();
        claims.put("userId", userId);
        
        // 토큰의 유효 기간 설정 (예: 1시간)
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 3600 * 1000); // 1시간
        
        // JWT 토큰 생성
        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, "GgolDdooGi")
                .compact();
        
        return token;
    }
    
    
    public static String generateBase64Token() {
		// 무작위 바이트 배열 생성
		byte[] randomBytes = new byte[32];
		new SecureRandom().nextBytes(randomBytes);

		// 바이트 배열을 Base64 인코딩하여 문자열로 변환하여 반환
		return Base64.getEncoder().encodeToString(randomBytes);
	}
}