package com.online_library.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

	private static final String SECRET_KEY = "MzQ1Njc4OTAxMjM0NTY3ODkwMTIzNDU2Nzg5MDEyMzQ1Njc4OTAxMjM0NTY3ODkw";

	// Token validity: 24 hours
	private static final long JWT_EXPIRATION = 1000 * 60 * 60 * 24;

	/**
	 * Generate JWT Token
	 */
	public String generateToken(UserDetails userDetails) {

		Map<String, Object> claims = new HashMap<>();

		claims.put("role", userDetails.getAuthorities().iterator().next().getAuthority());

		return createToken(claims, userDetails.getUsername());
	}

	/**
	 * Create JWT Token
	 */
	private String createToken(Map<String, Object> claims, String username) {

		return Jwts.builder()

				.setClaims(claims)

				.setSubject(username)

				.setIssuedAt(new Date(System.currentTimeMillis()))

				.setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))

				.signWith(getSigningKey(), SignatureAlgorithm.HS256)

				.compact();
	}

	/**
	 * Extract Username (Email)
	 */
	public String extractUsername(String token) {

		return extractClaim(token, Claims::getSubject);
	}

	/**
	 * Extract Expiration Date
	 */
	public Date extractExpiration(String token) {

		return extractClaim(token, Claims::getExpiration);
	}

	/**
	 * Extract Any Claim
	 */
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {

		final Claims claims = extractAllClaims(token);

		return claimsResolver.apply(claims);
	}

	/**
	 * Extract All Claims
	 */
	private Claims extractAllClaims(String token) {

		return Jwts.parserBuilder()

				.setSigningKey(getSigningKey())

				.build()

				.parseClaimsJws(token)

				.getBody();
	}

	/**
	 * Check Token Expired
	 */
	private boolean isTokenExpired(String token) {

		return extractExpiration(token).before(new Date());
	}

	/**
	 * Validate Token
	 */
	public boolean isTokenValid(String token, UserDetails userDetails) {

		final String username = extractUsername(token);

		return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
	}

	/**
	 * Secret Key
	 */
	private Key getSigningKey() {

		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);

		return Keys.hmacShaKeyFor(keyBytes);
	}
}
