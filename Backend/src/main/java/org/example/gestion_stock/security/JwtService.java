package org.example.gestion_stock.security;

import org.example.gestion_stock.model.User;
import org.example.gestion_stock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.util.Date;
import java.util.function.Function;
import javax.crypto.SecretKey;
@Service
public class JwtService {
    @Autowired
    private UserRepository userRepo;
    private final SecretKey secretKey = Keys.hmacShaKeyFor("super-secret-key-super-secret-key".getBytes());
    private final long jwtExpiration = 86400000; // 1 jour

    public String generateToken(String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return Jwts.builder()
                .setSubject(username)
                .claim("role", user.getRole()) // Add this line to include role in JWT
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(secretKey)
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token, UserDetails username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
        return claimsResolver.apply(claims);
    }
}
