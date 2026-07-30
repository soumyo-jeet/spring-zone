package in.soumyo.CRUDSpringBoot;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;


@Component
public class AuthUtil {
    @Value("${jwt.secret-key}")
    private String secretKey;

    private SecretKey getKey () {
        System.out.println(secretKey);
        System.out.println(secretKey.length());
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateAccessToken (StudentEntity student) {
        return Jwts.builder()
                .subject(student.getName())
                .claim("id", student.getId())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10)) // valid for 10 mins
                .signWith(getKey())
                .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claim = Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token).getPayload();

        return claim.getSubject();
    }
}
