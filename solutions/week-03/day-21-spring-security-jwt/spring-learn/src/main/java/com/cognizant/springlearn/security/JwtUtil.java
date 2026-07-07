package com.cognizant.springlearn.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

// pulled the key and the generate/parse logic out into one place instead of copy
// pasting the secret into both AuthenticationController and JwtAuthorizationFilter -
// two copies of a signing key drifting apart would be a nightmare to debug
public final class JwtUtil {

    // hs256 needs a key thats at least 256 bits, handout used the literal string
    // "secretkey" which jjwt 0.11 rejects with WeakKeyException, had to pad it out
    private static final Key KEY = Keys.hmacShaKeyFor(
            "cognizant-digital-nurture-java-fse-jwt-secret".getBytes(StandardCharsets.UTF_8));

    private static final long EXPIRY_MILLIS = 20 * 60 * 1000; // 20 minutes, same as handout

    private JwtUtil() {
    }

    public static String generateToken(String user) {
        Date issuedAt = new Date();
        Date expiry = new Date(issuedAt.getTime() + EXPIRY_MILLIS);

        return Jwts.builder()
                .setSubject(user)
                .setIssuedAt(issuedAt)
                .setExpiration(expiry)
                .signWith(KEY)
                .compact();
    }

    // returns null instead of throwing so the filter can just treat a bad token
    // as "not authenticated" and move on
    public static String getUser(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(KEY)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject();
        } catch (JwtException ex) {
            return null;
        }
    }
}
