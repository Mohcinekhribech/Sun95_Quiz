//package com.youcode.sunquizz.Security.jwt;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.security.Key;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//@Service
//public class JwtService {
//    @Value("${application.security.jwt.secret-key}")
//    private String secretKey;
//    @Value("${application.security.jwt.expiration}")
//    private long jwtExpiration;
//    @Value("${application.security.jwt.refresh-token.expiration}")
//    private long refreshExpiration;
//    public String extractUsername(String token)
//    {
//        return extractClaims(token,Claims::getSubject);
//    }
//
//    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver)
//    {
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//    }
//
//    public String generateToken(UserDetails userDetails)
//    {
//        return generateToken(new HashMap<>(),userDetails);
//    }
//
//    public boolean isTokenValid(String token,UserDetails userDetails)
//    {
//        final String username = extractUsername(token);
//        return (username.equals(userDetails.getUsername()))&& ! isTokenExpired(token);
//    }
//
//    public String generateRefreshToken(
//            UserDetails userDetails
//    ) {
//        return buildToken(new HashMap<>(), userDetails, refreshExpiration);
//    }
//
//    private String buildToken(
//            Map<String, Object> extraClaims,
//            UserDetails userDetails,
//            long expiration
//    ) {
//        return Jwts
//                .builder()
//                .setClaims(extraClaims)
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + expiration))
//                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    public boolean isTokenExpired(String token)
//    {
//        return extractExpiration(token).before(new Date());
//    }
//
//    public Date extractExpiration(String token)
//    {
//        return extractClaims(token,Claims::getExpiration);
//    }
//
//    public String generateToken(Map<String,Object> extractClaims, UserDetails userDetails)
//    {
//        return Jwts
//                .builder()
//                .setClaims(extractClaims)
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis()+100*60*24))
//                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    private Claims extractAllClaims(String token)
//    {
//        return Jwts
//                .parserBuilder()
//                .setSigningKey(getSignInKey())
//                .build().
//                parseClaimsJws(token).
//                getBody();
//    }
//    private Key getSignInKey()
//    {
//        byte[] keyBytes = Decoders.BASE64.decode(this.secretKey);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }
//}
