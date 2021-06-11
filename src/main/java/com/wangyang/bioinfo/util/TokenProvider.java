package com.wangyang.bioinfo.util;

import com.wangyang.bioinfo.pojo.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * @author wangyang
 * @date 2021/6/11
 */
@Component
public class TokenProvider implements InitializingBean {

    private final String base64Secret;

    public TokenProvider(@Value("${jwt.base64-secret}") String base64Secret) {
        this.base64Secret = base64Secret;
    }
    @Override
    public void afterPropertiesSet() {
        byte[] keyBytes = Decoders.BASE64.decode(base64Secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    private Key key;



    public Token generateToken(User user) {


        long now = (new Date()).getTime();
        Date validity = new Date(now + 24*1000);;


        String token = Jwts.builder()
                .setSubject(user.getUsername())
                .claim("ID", user.getId())
                .signWith(key, SignatureAlgorithm.HS512)
                .setExpiration(validity)
                .compact();
        return new Token(token,validity.getTime());
    }

}
