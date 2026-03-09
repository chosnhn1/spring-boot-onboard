package com.asdf.minilog.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.Serializable;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/** 
 * 토큰 관련 로직 담당 클래스
 * (SRP 관점에서 "Util" 클래스는 썩 좋은 방법은 아니다 - less cohesive - 현실적이지만)
 * 어떻게 개선할 수 있을까? 생각해보기
 * 
 * 책은 이 클래스를 "Serializable" 구현체로 만들던데
 */

@Component
public class JwtUtil implements Serializable {
    private static final long serialVersionUID = -2550185165626007488L;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expire}")
    public Long JWT_VALIDITY; // 초 단위

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Long getUserIdFromToken(String token) {
        String jwt;
        if (token.startsWith("Bearer ")) {
            jwt = token.substring(7);
        } else {
            jwt = token;
        }

        return getClaimFromToken(jwt, claims -> claims.get("userId", Long.class));
    }

    public Date getExpirationFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    public Claims getAllClaimsFromToken(String token) {
        Key signingKey =
            new SecretKeySpec(
                Base64.getDecoder().decode(secret), SignatureAlgorithm.HS256.getJcaName());
        
        return Jwts.parser().setSigningKey(signingKey).build().parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        Date expiration = getExpirationFromToken(token);
        return expiration.before(new Date());
    }

    // 토큰 작성
    public String generateToken(UserDetails userDetails, Long userId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_VALIDITY * 1000))
                .signWith(
                        new SecretKeySpec(
                                Base64.getDecoder().decode(secret),
                                SignatureAlgorithm.HS256.getJcaName()))
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        String username = getUsernameFromToken(token);

        // 요청-토큰 사용자명 일치 여부 & 토큰 만료 여부 체크
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
